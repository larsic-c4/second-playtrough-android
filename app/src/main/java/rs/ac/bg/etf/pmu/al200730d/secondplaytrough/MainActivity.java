package rs.ac.bg.etf.pmu.al200730d.secondplaytrough;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data.Account;
import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data.AccountDao;
import rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data.GamesDatabase;

public class MainActivity extends AppCompatActivity {

    Activity mainActivity;
    private EditText usernameEt, passwordEt;
    private TextView loginLabel;
    private int defaultColor;
    private Button registerBt, loginBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        GamesDatabase database = GamesDatabase.getDatabase(this);
        usernameEt = findViewById(R.id.loginUsername);
        passwordEt = findViewById(R.id.loginPassword);
        loginLabel = findViewById(R.id.loginLabel);
        registerBt = findViewById(R.id.btRegister);
        loginBt = findViewById(R.id.btLogin);
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
}