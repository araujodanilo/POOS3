package com.danilo.escolaacessodb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int idCurso;
    private String nome;

    public Curso(){

    }

    public Curso(int idCurso, String nome) {
        this.idCurso = idCurso;
        this.nome = nome;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void salvar(){
        Connection conn;
        String sql = "INSERT INTO curso (id, nome) VALUES (?, ?)";
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:EscolaAcessoDB/EscolaDB.db");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, this.getIdCurso());
            stmt.setString(2, this.getNome());
            stmt.execute();
            conn.close();
            stmt.close();
        }catch (SQLException e){
            System.out.println(e.getStackTrace());
        }
    }

    public void apagar(){
        Connection conn;
        String sql;
        sql = "DELETE FROM curso WHERE id = ?";
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:EscolaAcessoDB/EscolaDB.db");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, this.getIdCurso());
            stmt.execute();
            conn.close();
            stmt.close();
        }catch(SQLException e){
            System.out.println(e.getStackTrace());
        }
    }

    public void atualizar(){
        Connection conn;
        String sql = "UPDATE curso SET nome = ? WHERE id = ?";
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:EscolaAcessoDB/EscolaDB.db");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(2, this.getIdCurso());
            stmt.setString(1, this.getNome());
            stmt.execute();
            Curso c = Curso.buscar(this.getIdCurso());
            c.mostrarDados();

            conn.close();
            stmt.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Curso> buscarTodos(){
    List<Curso> listaCurso = new ArrayList<>();
    Connection conn;
    String sql = "SELECT id, nome FROM curso";
    try{
        conn = DriverManager.getConnection("jdbc:sqlite:EscolaAcessoDB/EscolaDB.db");
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs;
        rs = stmt.executeQuery();
        while(rs.next()){
            Curso c = new Curso();
            c.setNome(rs.getString("nome"));
            c.setIdCurso(rs.getInt("id"));
            listaCurso.add(c);
        }
        conn.close();
        stmt.close();
    }catch (SQLException e){
        System.out.println(e.getMessage());
    }
    return listaCurso;
    }

    public static Curso buscar(int idCurso){
        Curso c = new Curso();
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:EscolaAcessoDB/EscolaDB.db");
            String sql = "SELECT * FROM curso WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCurso);
            ResultSet rs;
            rs = stmt.executeQuery();
            if(rs.next()){
                c.setIdCurso(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
            }
            conn.close();
            stmt.close();
        }catch (SQLException exception){
            System.out.println(exception.getSQLState());
        }
        return c;
    }

    public void mostrarDados(){
        System.out.println("Curso: " + this.getNome() + "\tID: " + this.getIdCurso());
    }
}
