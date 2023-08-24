package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.login.LoginActivity;

public class LoginLifecycle implements LifecycleEventObserver {

    @Override
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_CREATE) {

            Log.d(LoginActivity.LOG_TAG, "LoginLifecycle.onCreate() called");
        }
    }
}
