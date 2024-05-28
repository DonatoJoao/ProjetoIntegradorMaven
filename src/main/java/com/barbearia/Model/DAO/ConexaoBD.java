package com.barbearia.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    //Criando Conexao com banco de dados local

        private static final String url = "jdbc:mysql://localhost:3306/projeto_integrador";
        private static final String user = "********";
        private static final String password = "*********";
        private static Connection conn;

        public static Connection getConexao() {
            try {
                if (conn == null) {
                    conn = DriverManager.getConnection(url, user, password);
                    return conn;
                } else {
                    return conn;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }


