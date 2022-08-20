package com.danilo.escolaacessodb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cidade {
    private int idCidade;
    private String nome;

    public Cidade(int idCidade, String nome) {
        this.idCidade = idCidade;
        this.nome = nome;
    }

    public Cidade(){}

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void salvar(){
        Connection conn;
        String sql;
        sql = "INSERT INTO cidade (id, nome) VALUES (?, ?)";
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:EscolaAcessoDB/EscolaDB.db");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, this.getIdCidade());
            stmt.setString(2, this.getNome());
            stmt.execute();

            conn = null;
            stmt = null;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void apagar(){
        Connection conn;
        String sql = "DELETE FROM cidade WHERE id = ?";
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:EscolaAcessoDB/EscolaDB.db");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, this.getIdCidade());
            stmt.execute();

            conn = null;
            stmt = null;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void atualizar(){
        Connection conn;
        String sql = "UPDATE cidade SET id = ?, nome = ? WHERE id = ?";
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:EscolaAcessoDB/EscolaDB.db");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(3, this.getIdCidade());
            stmt.setInt(1, this.getIdCidade());
            stmt.setString(2, this.getNome());
            stmt.execute();

            conn = null;
            stmt = null;
        }catch (SQLException e){
            System.out.println(e.getStackTrace());
        }
    }

    public static List<Cidade> buscarTodos(){
        List<Cidade> listaCidades = new ArrayList<>();

        Connection conn;
        String sql = "SELECT id, nome FROM cidade";

        try{
            conn = DriverManager.getConnection("jdbc:sqlite:EscolaAcessoDB/EscolaDB.db");
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
                listaCidades.add(cidade);
            }
        }catch (SQLException e){
            System.out.println(e.getStackTrace());
        }

        return listaCidades;
    }

    public static Cidade buscar(int idCidade){
        Cidade cidade = new Cidade();

        Connection conn;
        String sql;
        sql = "SELECT id, nome FROM cidade WHERE id = ?";

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:EscolaAcessoDB/EscolaDB.db");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCidade);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                cidade.setIdCidade(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));

            }
        }catch (SQLException e){
            System.out.println(e.getStackTrace());
        }

        return cidade;
    }

    public void mostrarDados(){
        System.out.println("Cidade: "+this.getNome()+"\tID: "+this.getIdCidade());
    }
}
