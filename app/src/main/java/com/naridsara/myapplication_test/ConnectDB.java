package com.naridsara.myapplication_test;

import com.adedom.library.Dru;

import java.sql.Connection;

public class ConnectDB {
    public static Connection getConnection(){
        return Dru.connection("192.168.1.3","naridsara","242541","android_test");

    }
}
