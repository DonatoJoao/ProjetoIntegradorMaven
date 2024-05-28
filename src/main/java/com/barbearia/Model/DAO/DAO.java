package com.barbearia.Model.DAO;

import com.barbearia.Model.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {

    public void cadastrar(Cliente cliente){
        String sql = "INSERT INTO CLIENTE (NOME, SENHA, CPF) VALUES (?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = ConexaoBD.getConexao().prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getSenha());
            ps.setString(3, cliente.getCpf());
            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    //Implementar CRUD aqui








//    refatorado*************************
//    private Connection con;
//    private String driver = "com.mysql.cj.jdbc.Driver";
//    private String url = "jdbc:mysql://127.0.0.1:3306";
//    private String user = "root";
//    private String password = "root";
//
//    public Connection conectar() {
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, user, password);
//            return con;
//        } catch (Exception e) {
//            System.out.println(e);
//            return null;
//        }
//    }
}
