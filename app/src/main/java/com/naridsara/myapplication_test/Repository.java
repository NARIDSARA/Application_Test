package com.naridsara.myapplication_test;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.adedom.library.Dru;
import com.adedom.library.ExecuteQuery;
import com.adedom.library.ExecuteUpdate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Repository {

    private MutableLiveData<Objects> _register=new MutableLiveData<>();
    private MutableLiveData<Boolean> _validateUsername=new MutableLiveData<>();
    private MutableLiveData<Boolean> _validateTel=new MutableLiveData<>();
    private MutableLiveData<Boolean> _validateEmail=new MutableLiveData<>();


    LiveData<Objects> register(){
        return _register;
    }

    LiveData<Boolean> validateUsername(){
        return _validateUsername;
    }
    LiveData<Boolean> validateTel(){
        return _validateTel;
    }
    LiveData<Boolean> validateEmail(){
        return _validateEmail;
    }

    void validateUsername(String username){
        String sql = "SELECT * FROM `customer` WHERE `customer_username` = '"+username+"'";
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteQuery() {
                    @Override
                    public void onComplete(ResultSet resultSet) {
                        try {
                            if (resultSet.next()){
                                _validateUsername.setValue(true);
                            }else{
                                _validateUsername.setValue(false);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    void validateEmail(String email){
        String sql=" SELECT * FROM `customer` WHERE `customer_email` = '"+email+"'";
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteQuery() {
                    @Override
                    public void onComplete(ResultSet resultSet) {
                        try {
                            if(resultSet.next()){
                                _validateEmail.setValue(true);
                            }else {
                                _validateEmail.setValue(false);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
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
