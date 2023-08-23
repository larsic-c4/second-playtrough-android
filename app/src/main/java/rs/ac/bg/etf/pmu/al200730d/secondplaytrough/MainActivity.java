package rs.ac.bg.etf.pmu.al200730d.secondplaytrough;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data.Account;
import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data.GamesDatabase;
import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.databinding.LoginMenuBinding;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "my-log-watcher";
    private LoginMenuBinding binding;
    private EditText usernameEt, passwordEt;
    private TextView loginLabel;
    private int defaultColor;
    private Button registerBt, loginBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d(LOG_TAG, "onCreate() called");

        GamesDatabase database = GamesDatabase.getDatabase(this);
        usernameEt = binding.loginUsername;
        passwordEt = binding.loginPassword;
        loginLabel = binding.loginLabel;
        registerBt = binding.btRegister;
        loginBt = binding.btLogin;
        defaultColor = loginLabel.getCurrentTextColor();

        registerBt.setOnClickListener(view -> {
            String username = usernameEt.getText().toString();
            String password = passwordEt.getText().toString();
            String passwordHash = GamesDatabase.generateSHA256Hash(password);
            if (username.trim().isEmpty() || password.trim().isEmpty()
                    || username.length() < 4 || username.length() > 16
                    || password.length() < 4 || password.length() > 16 ) {
                int red = getColor(R.color.red);
                loginLabel.setTextColor(red);
                loginLabel.setText(R.string.register_fail);
            } else {
                database.accountDao().insert(new Account(0, username, passwordHash));
                loginLabel.setTextColor(defaultColor);
                loginLabel.setText(R.string.register_success);
            }
        });

        loginBt.setOnClickListener(view -> {
            String username = usernameEt.getText().toString();
            String password = passwordEt.getText().toString();
            Account account;
            if (!username.trim().isEmpty() && !password.trim().isEmpty()
                    && username.length() >= 4 && username.length() <= 16
                    && password.length() >= 4 && password.length() <= 16
                    && (account = database.accountDao().findByUsername(username)) != null) {
                // we ave account
                loginLabel.setTextColor(defaultColor);
                loginLabel.setText(R.string.login_success);
            } else {
                int red = getColor(R.color.red);
                loginLabel.setTextColor(red);
                loginLabel.setText(R.string.login_fail);
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
}