package com.naridsara.myapplication_test;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.Objects;

public class RegisterViewModel extends ViewModel {

    private Repository repository = new Repository();

    LiveData<Objects> register(){
        return repository.register();
    }

    void register(String name, String surname, String username, String email,String password, String tel, String housenumber, String moo, String district, String subdistrict, String province, String postalcode) {
        repository.register(name, surname, username, email,password, tel, housenumber, moo, district, subdistrict, province, postalcode);
    }
}
