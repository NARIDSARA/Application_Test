package com.naridsara.myapplication_test;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.Objects;

public class RegisterViewModel extends ViewModel {

    private static final String TAG = "RegisterViewModel";

    private Repository repository = new Repository();

    LiveData<Objects> register() {
        return repository.register();
    }

    LiveData<Boolean> validateUsername(){
        return repository.validateUsername();
    }

    void register(String name, String surname, String username, String email, String password, String tel, String housenumber, String moo, String district, String subdistrict, String province, String postalcode) {
        repository.register(name, surname, username, email, password, tel, housenumber, moo, district, subdistrict, province, postalcode);
    }

    void validateUsername(String username) {
        repository.validateUsername(username);
    }

}
