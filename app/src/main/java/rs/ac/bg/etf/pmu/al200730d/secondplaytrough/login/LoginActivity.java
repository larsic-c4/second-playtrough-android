package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import dagger.hilt.android.AndroidEntryPoint;
import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.R;
import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data.Account;
import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data.LoginLifecycle;
import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.databinding.LoginMenuBinding;

@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity {

    public static final String LOG_TAG = "my-log-watcher";
    private LoginMenuBinding binding;
    private LoginViewModel loginViewModel;
    private EditText usernameEt, passwordEt;
    private TextView loginLabel;
    private int defaultColor;
    private Button registerBt, loginBt;
    private static final int PHOTO_TAKEN = 500;
    private static final int REQUEST_CAMERA_PERMISSION = 100;
    private ActivityResultLauncher<Intent> cameraLauncher;
    private String imagePath;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        if (loginViewModel.getLoginLabel().getValue() != null)
            outState.putString(LoginViewModel.LOGIN_LABEL, loginViewModel.getLoginLabel().getValue());
        if (loginViewModel.getLoginLabelColor().getValue() != null)
            outState.putInt(LoginViewModel.LOGIN_COLOR, loginViewModel.getLoginLabelColor().getValue());
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG, "onSaveInstanceState() called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = LoginMenuBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        getLifecycle().addObserver(new LoginLifecycle());

        Log.d(LOG_TAG, "onCreate() called");

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        loginViewModel.getLoginLabel().observe(this,
                s -> binding.loginLabel.setText(s));
        loginViewModel.getLoginLabelColor().observe(this,
                integer -> binding.loginLabel.setTextColor(integer));
        loginViewModel.initByBundle(savedInstanceState);

        usernameEt = binding.loginUsername;
        passwordEt = binding.loginPassword;
        loginLabel = binding.loginLabel;
        registerBt = binding.btRegister;
        loginBt = binding.btLogin;
        defaultColor = loginLabel.getCurrentTextColor();

        cameraLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                this::onActivityResult);

        registerBt.setOnClickListener(view -> {
            String username = usernameEt.getText().toString();
            String password = passwordEt.getText().toString();
            if (username.trim().isEmpty() || username.length() < 4 || username.length() > 16) {
                int red = getColor(R.color.red);
                loginViewModel.setLoginLabel(getString(R.string.register_fail));
                loginViewModel.setLoginLabelColor(red);
                binding.loginUsernameF.getEditText().requestFocus();
            } else if (password.trim().isEmpty() || password.length() < 4 || password.length() > 16) {
                int red = getColor(R.color.red);
                loginViewModel.setLoginLabel(getString(R.string.register_fail));
                loginViewModel.setLoginLabelColor(red);
                binding.loginPasswordF.getEditText().requestFocus();
            } else if (loginViewModel.findByUsername(username) != null) {
                int red = getColor(R.color.red);
                loginViewModel.setLoginLabel(getString(R.string.register_username_taken));
                loginViewModel.setLoginLabelColor(red);
            } else { //registration

                Intent intent = new Intent(this, CameraActivity.class);
                cameraLauncher.launch(intent);
                //imagepath
                //appRepository.insert(new Account(0, username, passwordHash));

            }
        });

        loginBt.setOnClickListener(view -> {
            String username = usernameEt.getText().toString();
            String password = passwordEt.getText().toString();
            Account account;
            if (!username.trim().isEmpty() && !password.trim().isEmpty()
                    && username.length() >= 4 && username.length() <= 16
                    && password.length() >= 4 && password.length() <= 16
                    && (account = loginViewModel.findByUsername(username)) != null) {
                // we ave account
                loginViewModel.setLoginLabel(getString(R.string.login_success));
                loginViewModel.setLoginLabelColor(defaultColor);
            } else {
                int red = getColor(R.color.red);
                loginViewModel.setLoginLabel(getString(R.string.login_fail));
                loginViewModel.setLoginLabelColor(red);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy() called");
    }


    private void onActivityResult(ActivityResult result) {
        if (result.getResultCode() == RESULT_OK) {
            Intent data = result.getData();
            if (data != null) {
                imagePath = data.getStringExtra("imagePath");

                loginViewModel.setLoginLabel(getString(R.string.register_success) + "\n" + imagePath);
                loginViewModel.setLoginLabelColor(defaultColor);
            } else {

                int red = getColor(R.color.red);
                loginViewModel.setLoginLabel(getString(R.string.photo_failed));
                loginViewModel.setLoginLabelColor(red);
            }
        }
    }
}