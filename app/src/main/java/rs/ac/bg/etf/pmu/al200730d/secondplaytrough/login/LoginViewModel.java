package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.login;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LoginViewModel extends ViewModel {

    public static final String LOGIN_LABEL = "login-label";
    private boolean labelValid = false;
    private MutableLiveData<String> loginLabel = new MutableLiveData<>("");
    public static final String LOGIN_COLOR = "login-color";
    private boolean colorValid = false;
    private MutableLiveData<Integer> loginLabelColor = new MutableLiveData<>(0);

    @Inject
    public LoginViewModel() {
    }

    public void initByBundle(Bundle bundle) {
        if (bundle != null ) {
            if (!labelValid && bundle.containsKey(LOGIN_LABEL)) {
                loginLabel.setValue(bundle.getString(LOGIN_LABEL));
            }
            if (!colorValid && bundle.containsKey(LOGIN_COLOR)) {
                loginLabelColor.setValue(bundle.getInt(LOGIN_COLOR));
            }
        }
    }

    public LiveData<String> getLoginLabel() {
        return loginLabel;
    }

    public void setLoginLabel(String loginLabel) {
        labelValid = true;
        this.loginLabel.setValue(loginLabel);
    }

    public LiveData<Integer> getLoginLabelColor() {
        return loginLabelColor;
    }

    public void setLoginLabelColor(int loginLabelColor) {
        colorValid = true;
        this.loginLabelColor.setValue(loginLabelColor);
    }
}
