package rs.ac.bg.etf.pmu.al200730d.secondplaytrough;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<String> loginLabel = new MutableLiveData<>("");
    private MutableLiveData<Integer> loginLabelColor = new MutableLiveData<>(0);

    public LiveData<String> getLoginLabel() {
        return loginLabel;
    }

    public void setLoginLabel(String loginLabel) {
        this.loginLabel.setValue(loginLabel);
    }

    public LiveData<Integer> getLoginLabelColor() {
        return loginLabelColor;
    }

    public void setLoginLabelColor(int loginLabelColor) {
        this.loginLabelColor.setValue(loginLabelColor);
    }
}
