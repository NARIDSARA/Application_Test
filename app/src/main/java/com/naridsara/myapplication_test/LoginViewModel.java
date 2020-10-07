package com.naridsara.myapplication_test;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Objects;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<String> _responseToast = new MutableLiveData<>();
    private Repository repository = new Repository();


    LiveData<Boolean> responseLogin() {
        return repository.responseLogin();
    }
    LiveData<String> responseToast() {
        return _responseToast;
    }
     void requestLogin(String username,String password){
        if(username.isEmpty()){
            _responseToast.setValue("กรุณากรอชื่อผู้ใช้");
            return;
        } else if (password.isEmpty()){
            _responseToast.setValue("กรุณากรอกรหัสผ่าน");
            return;
         }
        repository.requestLogin(username,password);


     }

}
