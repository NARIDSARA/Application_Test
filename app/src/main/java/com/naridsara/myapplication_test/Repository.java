package com.naridsara.myapplication_test;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.adedom.library.Dru;
import com.adedom.library.ExecuteUpdate;

import java.util.Objects;

public class Repository {

    private MutableLiveData<Objects> _register=new MutableLiveData<>();

    LiveData<Objects> register(){
        return _register;
    }

    void register(String name,String surname,String username,String email,String password,String tel,String housenumber,String moo,String district, String subdistrict,String province,String postalcode){
        String sql="INSERT INTO `customer`(`customer_name`, `customer_surname`, `customer_username`, `customer_email`,`customer_password`, `customer_tel`, `customer_housenumber`, `customer_moo`, `customer_district`, `customer_subdistrict`, `customer_province`, `customer_postalcode`) " +
                "VALUES ('"+name+"','"+surname+"','"+username+"','"+email+"','"+password+"','"+tel+"','"+housenumber+"','"+moo+"','"+district+"','"+subdistrict+"','"+province+"','"+postalcode+"')";
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteUpdate() {
                    @Override
                    public void onComplete() {
                        _register.setValue(null);
                    }
                });
    }
}
