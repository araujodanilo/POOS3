package com.danilo.escolaacessodb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private int idAluno;
    private String prontuario;
    private String nome;
    private Curso curso;
    private Cidade cidade;

    public Aluno(int idAluno, String prontuario, String nome, Curso curso, Cidade cidade) {
        this.idAluno = idAluno;
        this.prontuario = prontuario;
        this.nome = nome;
        this.curso = curso;
        this.cidade = cidade;
    }
    public Aluno(){};

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
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
        sql = "INSERT INTO aluno (id, nome, prontuario, id_curso, id_cidade) VALUES (?, ?, ?, ?, ?)";
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:EscolaAcessoDB/EscolaDB.db");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, this.getIdAluno());
            stmt.setString(2, this.getNome());
            stmt.setString(3, this.getProntuario());
            stmt.setInt(4, this.getCurso().getIdCurso());
            stmt.setInt(5, this.getCidade().getIdCidade());
            stmt.execute();

            conn.close();
            stmt.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void apagar(){
        Connection conn;
        String sql = "DELETE FROM aluno WHERE id = ?";
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:EscolaAcessoDB/EscolaDB.db");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, this.getIdAluno());
            stmt.execute();

            conn.close();
            stmt.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void atualizar(){
        Connection conn;
        String sql;
        sql = "UPDATE aluno SET nome = ?, prontuario = ?, id_curso = ?, id_cidade = ? WHERE id = ?";
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:EscolaAcessoDB/EscolaDB.db");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, this.getNome());
            stmt.setString(2, this.getProntuario());
            stmt.setInt(3, this.getCurso().getIdCurso());
            stmt.setInt(4, this.getCidade().getIdCidade());
            stmt.setInt(5, this.getIdAluno());
            stmt.execute();

            conn.close();
            stmt.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Aluno> buscarTodos(){
        List<Aluno> listaAluno = new ArrayList<>();
        Connection conn;
        String sql = "SELECT id, nome, prontuario, id_curso, id_cidade FROM aluno";
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:EscolaAcessoDB/EscolaDB.db");
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs;
            rs = stmt.executeQuery();
            while(rs.next()){
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setProntuario(rs.getString("prontuario"));
                Curso curso = Curso.buscar(rs.getInt("id_curso"));
                Cidade cidade = Cidade.buscar(rs.getInt("id_cidade"));
                aluno.setCurso(curso);
                aluno.setCidade(cidade);
                listaAluno.add(aluno);
            }
            conn.close();
            stmt.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return listaAluno;
    }

    public static Aluno buscar(int idAluno){
        Aluno aluno = new Aluno();
        Connection conn;
        String sql = "SELECT (id, nome, prontuario, id_curso, id_cidade) FROM aluno WHERE id = ?";
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:EscolaAcessoDB/EscolaDB.db");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAluno);
            ResultSet rs;
            rs = stmt.executeQuery();

            aluno.setIdAluno(rs.getInt("id"));
            aluno.setNome(rs.getString("nome"));
            aluno.setProntuario(rs.getString("prontuario"));
            Curso curso = Curso.buscar(rs.getInt("id_curso"));
            Cidade cidade = Cidade.buscar(rs.getInt("id_cidade"));
            aluno.setCurso(curso);
            aluno.setCidade(cidade);

            conn.close();
            stmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return aluno;
    }

    public void mostrarDados(){
        System.out.println("Prontuario: "+this.getProntuario()+"\tAluno: "+this.getNome()+"\tID: "+this.getIdAluno()+"\tCurso: "+this.getCurso().getNome()+"\tCidade: "+this.getCidade().getNome());
    }
}
