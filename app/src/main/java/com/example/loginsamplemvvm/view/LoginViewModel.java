package com.example.loginsamplemvvm.view;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginsamplemvvm.model.LoginModel;
import com.example.loginsamplemvvm.service.Repositories;

public class LoginViewModel extends ViewModel {
    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> errMsg = new MutableLiveData<>();
    public MutableLiveData<LoginModel> user = new MutableLiveData<>();
    private Repositories repositories;
    private Context context;

    public void init(Context context){
        repositories = Repositories.getInstance();
        user.setValue(repositories.getUser());
        this.context = context;
    }

    public void login(){
        errMsg.setValue("");
        if(getUsername().getValue().isEmpty() || getPassword().getValue().isEmpty()){
            errMsg.setValue("Username or Password field is empty.");
        }
        if(errMsg.getValue().isEmpty()){
            if(user.getValue().getUsername().equals(getUsername().getValue()) &&
                    user.getValue().getPassword().equals(getPassword().getValue())){
                errMsg.setValue("");
                Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show();
            }else{
                errMsg.setValue("Incorrect Username or Password");
            }
        }
    }

    public MutableLiveData<String> getUsername() {
        if(username.getValue() == null) {
            username.setValue("");
        }
        return username;
    }

    public MutableLiveData<String> getPassword() {
        if(password.getValue() == null) {
            password.setValue("");
        }
        return password;
    }

    public MutableLiveData<String> getErrMsg() {
        if(errMsg.getValue() == null) {
            errMsg.setValue("");
        }
        return errMsg;
    }
}
