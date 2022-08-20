package com.danilo.escoladbfx.data;

import com.danilo.escoladbfx.model.Curso;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoSQLiteDAO implements GenericDAO<Curso>{
    @Override
    public void salvar(Curso curso) {
        String sql = "INSERT INTO curso (nome) VALUES (?)";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1, curso.getNome());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Curso curso) {
        String sql = "UPDATE curso SET nome = ? WHERE idCurso = ?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getIdCurso());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(Curso curso) {
        String sql = "DELETE FROM curso WHERE idCurso = ?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, curso.getIdCurso());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Curso buscar(int idCurso) {
        Curso curso = new Curso();
        String sql = "SELECT nome FROM curso WHERE idCurso = ?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, idCurso);
            ResultSet rs;
            rs = stmt.executeQuery();
            if (rs.next()){

                curso.setIdCurso(idCurso);
                curso.setNome(rs.getString(1));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return curso;
    }

    @Override
    public List<Curso> buscarTodos() {
        List<Curso> listaCurso = new ArrayList<>();

        String sql = "SELECT idCurso, nome FROM curso";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs;
            rs = stmt.executeQuery();
            while(rs.next()){
                Curso curso = new Curso();

                curso.setIdCurso(rs.getInt(1));
                curso.setNome(rs.getString(2));

                listaCurso.add(curso);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return listaCurso;
    }
}
