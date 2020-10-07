package com.naridsara.myapplication_test;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Objects;

public class RegisterViewModel extends ViewModel {

    private static final String TAG = "RegisterViewModel";
    private MutableLiveData<String> _responseToast = new MutableLiveData<>();

    private Repository repository = new Repository();

    LiveData<Objects> responseRegister() {
        return repository.responseRegister();
    }
    LiveData<Boolean> responseValidateUsername() {
        return repository.responseValidateUsername();
    }

    LiveData<Boolean> responseValidateEmail() {
        return repository.responseValidateEmail();
    }

    LiveData<Boolean> responseValidateTel() {
        return repository.responseValidateTel();
    }

    LiveData<String> responseToast() {
        return _responseToast;
    }

    void requestRegister(String name, String surname, String username, String email, String password, String repassword, String tel, String housenumber, String moo, String district, String subdistrict, String province, String postalcode) {
        Log.d(TAG, "requestRegister: begin");

        if (name.isEmpty()) {
            _responseToast.setValue("username is empty");
            return;
        } else if (surname.isEmpty()) {
            _responseToast.setValue("surname is empty");
            return;
        } else if (username.isEmpty()) {
            _responseToast.setValue("username is empty");
            return;
        } else if (email.isEmpty()) {
            _responseToast.setValue("email is empty");
            return;
        } else if (tel.isEmpty()) {
            _responseToast.setValue("tel is empty");
            return;
        } else if (housenumber.isEmpty()) {
            _responseToast.setValue("housenumber is empty");
            return;
        } else if (moo.isEmpty()) {
            _responseToast.setValue("moo is empty");
            return;
        } else if (district.isEmpty()) {
            _responseToast.setValue("district is empty");
            return;
        } else if (subdistrict.isEmpty()) {
            _responseToast.setValue("subdistrict is empty");
            return;
        } else if (province.isEmpty()) {
            _responseToast.setValue("province is empty");
            return;
        } else if (postalcode.isEmpty()) {
            _responseToast.setValue("postalcode is empty");
            return;
        } else if (name.length() < 4) {
            _responseToast.setValue("ชื่อต้องมากกว่า4 ตัวอักษร");
            return;
        } else if (surname.length() < 4) {
            _responseToast.setValue("นามสกุลต้องมากกว่า 4 ตัวอักษร");
            return;
        } else if (username.length() < 4) {
            _responseToast.setValue("ชื่อผู้ใช้ต้องมากกว่า4 ตัวอักษร");
            return;
        } else if (email.length() < 4) {
            _responseToast.setValue("อีเมลล์ต้องมากกว่า4 ตัวอักษร");
            return;
        } else if (tel.length() < 4) {
            _responseToast.setValue("เบอร์โทรต้องมากกว่า 4 ตัวอักษร");
            return;
        } else if (housenumber.length() < 2) {
            _responseToast.setValue("บ้านเลขที่ต้องมากกว่า2 ตัวอักษร");
            return;
        } else if (district.length() < 4) {
            _responseToast.setValue("อำเภอต้องมากกว่า4 ตัวอักษร");
            return;
        } else if (subdistrict.length() < 4) {
            _responseToast.setValue("ตำบลต้องมากกว่า4 ตัวอักษร");
            return;
        } else if (postalcode.length() < 3) {
            _responseToast.setValue("จังหวัดต้องมากกว่า 3 ตัวอักษร");
            return;
        } else if (!password.equals(repassword)) {
            _responseToast.setValue("รหัสผ่านไม่ตรงกัน");
            return;
        }

        repository.requestRegister(name, surname, username, email, password, tel, housenumber, moo, district, subdistrict, province, postalcode);

        Log.d(TAG, "requestRegister: end");
    }

    void requestValidateUsername(String username) {
        Log.d(TAG, "requestValidateUsername: ");
        repository.requestValidateUsername(username);
    }

    void requestValidateEmail(String email) {
        Log.d(TAG, "requestValidateEmail: ");
        repository.requestValidateEmail(email);
    }

    void requestValidateTel(String tel) {
        Log.d(TAG, "requestValidateTel: ");
        repository.requestValidateTel(tel);
    }


}
