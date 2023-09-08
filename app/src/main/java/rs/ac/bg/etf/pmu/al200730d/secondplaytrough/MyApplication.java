package rs.ac.bg.etf.pmu.al200730d.secondplaytrough;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import androidx.annotation.NonNull;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MyApplication extends Application {

    private static final String LOG_TAG = "my-log-watcher";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "Application.onCreate() called");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(LOG_TAG, "Application.onTerminate() called");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(LOG_TAG, "Application.onConfigurationChanged() called");
    }
}
