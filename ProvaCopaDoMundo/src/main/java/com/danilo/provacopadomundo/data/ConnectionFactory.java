package com.danilo.provacopadomundo.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory implements AutoCloseable{
    private static Connection conn;
    private static PreparedStatement stmt;

    private static Connection openConnection(){
        if (conn == null){
            try{
                conn = DriverManager.getConnection("jdbc:sqlite:ProvaCopaDoMundo/jogos.db");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static PreparedStatement createStatment(String sql){
        try{
            stmt = openConnection().prepareStatement(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return stmt;
    }

    @Override
    public void close() throws Exception {
        if (conn != null){
            conn.close();
        }
    }
}
