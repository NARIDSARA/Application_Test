package com.naridsara.myapplication_test;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.adedom.library.Dru;
import com.adedom.library.ExecuteQuery;
import com.adedom.library.ExecuteUpdate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Repository {

    private static final String TAG = "Repository";
    private MutableLiveData<Objects> _responseRegister =new MutableLiveData<>();
    private MutableLiveData<Boolean> _responseValidateUsername =new MutableLiveData<>();
    private MutableLiveData<Boolean> _responseValidateTel =new MutableLiveData<>();
    private MutableLiveData<Boolean> _responseValidateEmail =new MutableLiveData<>();


    LiveData<Objects> responseRegister(){
        return _responseRegister;
    }

    LiveData<Boolean> responseValidateUsername(){
        return _responseValidateUsername;
    }
    LiveData<Boolean> responseValidateTel(){
        return _responseValidateTel;
    }
    LiveData<Boolean> responseValidateEmail(){
        return _responseValidateEmail;
    }

    void requestValidateUsername(String username){
        String sql = "SELECT * FROM `customer` WHERE `customer_username` = '"+username+"'";
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteQuery() {
                    @Override
                    public void onComplete(ResultSet resultSet) {
                        try {
                            if (resultSet.next()){
                                _responseValidateUsername.setValue(true);
                            }else{
                                _responseValidateUsername.setValue(false);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    void requestValidateEmail(String email) {
        String sql = " SELECT * FROM `customer` WHERE `customer_email` = '" + email + "'";
        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteQuery() {
                    @Override
                    public void onComplete(ResultSet resultSet) {
                        try {
                            if (resultSet.next()) {
                                _responseValidateEmail.setValue(true);
                            } else {
                                _responseValidateEmail.setValue(false);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
        void requestValidateTel(String tel){
            String sql="SELECT * FROM `customer` WHERE `customer_tel` = '"+tel+"'";
            Dru.connection(ConnectDB.getConnection())
                    .execute(sql)
                    .commit(new ExecuteQuery() {
                        @Override
                        public void onComplete(ResultSet resultSet) {
                            try {
                                if(resultSet.next()){
                                    _responseValidateTel.setValue(true);
                                }else {
                                    _responseValidateTel.setValue(false);
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        }
                    });
        }


    void requestRegister(String name, String surname, String username, String email, String password, String tel, String housenumber, String moo, String district, String subdistrict, String province, String postalcode){
        String sql="INSERT INTO `customer`(`customer_name`, `customer_surname`, `customer_username`, `customer_email`,`customer_password`, `customer_tel`, `customer_housenumber`, `customer_moo`, `customer_district`, `customer_subdistrict`, `customer_province`, `customer_postalcode`) " +
                "VALUES ('"+name+"','"+surname+"','"+username+"','"+email+"','"+password+"','"+tel+"','"+housenumber+"','"+moo+"','"+district+"','"+subdistrict+"','"+province+"','"+postalcode+"')";

        Log.d(TAG, "requestRegister: "+sql);

        Dru.connection(ConnectDB.getConnection())
                .execute(sql)
                .commit(new ExecuteUpdate() {
                    @Override
                    public void onComplete() {
                        _responseRegister.setValue(null);
                    }
                });
    }
}
