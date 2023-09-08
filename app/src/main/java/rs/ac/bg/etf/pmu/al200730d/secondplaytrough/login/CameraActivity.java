package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.login;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import com.google.common.util.concurrent.ListenableFuture;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.R;

public class CameraActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA_PERMISSION = 100;
    private PreviewView previewView;
    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    private ImageCapture imageCapture;
    Button captureButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        captureButton = findViewById(R.id.captureButton);
        captureButton.setVisibility(View.INVISIBLE);

        if (allPermissionsGranted()) {
            startCamera();
        } else {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CAMERA},
                    REQUEST_CAMERA_PERMISSION
            );
        }
    }

    private boolean allPermissionsGranted() {
        return ContextCompat.checkSelfPermission(
                this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    private void startCamera() {
        previewView = findViewById(R.id.previewView);

        LifecycleOwner lifecycleOwner = this;
        cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        cameraProviderFuture.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                Preview preview = new Preview.Builder().build();
                imageCapture = new ImageCapture.Builder().setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                                .build();

                int lensFacing;
                if (hasBackCamera(cameraProvider)) lensFacing = CameraSelector.LENS_FACING_BACK;
                else if (hasFrontCamera(cameraProvider)) lensFacing = CameraSelector.LENS_FACING_FRONT;
                else throw new IllegalStateException("Back and front camera are unavailable");
                CameraSelector cameraSelector = new CameraSelector.Builder().requireLensFacing(lensFacing).build();

                cameraProvider.unbindAll();

                // Attach use cases to the camera with the same lifecycle owner
                Camera camera = cameraProvider.bindToLifecycle(
                        lifecycleOwner, cameraSelector, preview, imageCapture
                );
                // Connect the preview use case to the previewView
                preview.setSurfaceProvider(previewView.getSurfaceProvider());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }, ContextCompat.getMainExecutor(this));
        captureButton.setVisibility(View.VISIBLE);
        captureButton.setOnClickListener(view -> takePhoto());
    }


    private void takePhoto() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        String fileName = "IMG_" + sdf.format(new Date()) + ".jpg";

        File outputDirectory = getOutputDirectory();
        File photoFile = new File(outputDirectory, fileName);

        ImageCapture.OutputFileOptions outputFileOptions =
                    new ImageCapture.OutputFileOptions.Builder(photoFile).build();
        final String[] imagePath = {null};
        imageCapture.takePicture(outputFileOptions, ContextCompat.getMainExecutor(this),
                new ImageCapture.OnImageSavedCallback() {
                    @Override
                    public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {
                        Log.d("CameraActivity", "Photo saved: " + photoFile.getAbsolutePath());
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("imagePath", photoFile.getAbsolutePath());
                        setResult(RESULT_OK, resultIntent);
                        finish();
                    }

                    @Override
                    public void onError(@NonNull ImageCaptureException exception) {
                        exception.printStackTrace();
                    }
                });
    }

    private File getOutputDirectory() {
        File mediaDir = getExternalMediaDirs()[0];
        File file = new File(mediaDir, "CameraX");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                return null;
            }
        }
        return file;
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (allPermissionsGranted()) {
                startCamera();
            }
        }
    }

    private boolean hasBackCamera(CameraProvider cameraProvider) {
        try {
            return cameraProvider.hasCamera(CameraSelector.DEFAULT_BACK_CAMERA);
        } catch (CameraInfoUnavailableException e) {
            return false;
        }
    }

    private boolean hasFrontCamera(CameraProvider cameraProvider) {
        try {
            return cameraProvider.hasCamera(CameraSelector.DEFAULT_FRONT_CAMERA);
        } catch (CameraInfoUnavailableException e) {
            return false;
        }
    }
}