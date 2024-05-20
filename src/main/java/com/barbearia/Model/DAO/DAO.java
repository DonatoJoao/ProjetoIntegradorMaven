package com.barbearia.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

    private Connection con;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306";
    private String user = "root";
    private String password = "root";

    public Connection conectar() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
