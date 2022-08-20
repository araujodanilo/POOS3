package com.danilo.escoladbfx.data;


import com.danilo.escoladbfx.model.Aluno;
import com.danilo.escoladbfx.model.Cidade;
import com.danilo.escoladbfx.model.Curso;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoSQLiteDAO implements GenericDAO<Aluno>{

    @Override
    public void salvar(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, prontuario, curso, cidade) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getProntuario());
            stmt.setInt(3, aluno.getCurso().getIdCurso());
            stmt.setInt(4, aluno.getCidade().getIdCidade());

            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, prontuario = ?, curso = ?, cidade = ? WHERE idAluno = ?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getProntuario());
            stmt.setInt(3, aluno.getCurso().getIdCurso());
            stmt.setInt(4, aluno.getCidade().getIdCidade());
            stmt.setInt(5, aluno.getIdAluno());

            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(Aluno aluno) {
        String sql = "DELETE FROM aluno WHERE idAluno = ?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, aluno.getIdAluno());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Aluno buscar(int idAluno) {
        Aluno aluno = new Aluno();

        String sql = "SELECT idAluno, nome, prontuario, curso, cidade FROM aluno WHERE id = ?";

        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, idAluno);
            ResultSet rs;
            rs = stmt.executeQuery();

            if (rs.next()){
                aluno.setIdAluno(rs.getInt(1));
                aluno.setNome(rs.getString(2));
                aluno.setProntuario(rs.getString(3));
                Curso curso = new CursoSQLiteDAO().buscar(rs.getInt(4));
                Cidade cidade = new CidadeSQLiteDAO().buscar(rs.getInt(5));
                aluno.setCurso(curso);
                aluno.setCidade(cidade);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return aluno;
    }

    @Override
    public List<Aluno> buscarTodos() {
        List<Aluno> listaAluno = new ArrayList<>();

        String sql = "SELECT idAluno, nome, prontuario, curso, cidade FROM aluno";

        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()){
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt(1));
                aluno.setNome(rs.getString(2));
                aluno.setProntuario(rs.getString(3));
                Curso curso = new CursoSQLiteDAO().buscar(rs.getInt(4));
                Cidade cidade = new CidadeSQLiteDAO().buscar(rs.getInt(5));

                aluno.setCurso(curso);
                aluno.setCidade(cidade);
                listaAluno.add(aluno);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return listaAluno;
    }
}
