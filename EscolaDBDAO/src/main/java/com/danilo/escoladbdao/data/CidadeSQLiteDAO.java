package com.danilo.escoladbdao.data;

import com.danilo.escoladbdao.model.Cidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeSQLiteDAO implements GenericDAO<Cidade>{
    @Override
    public void salvar(Cidade cidade) {
        String sql = "INSERT INTO cidade (id, nome) VALUES (?, ?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, cidade.getIdCidade());
            stmt.setString(2, cidade.getNome());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Cidade cidade) {
        String sql = "UPDATE cidade SET nome = ? WHERE id = ?";

        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1, cidade.getNome());
            stmt.setInt(2, cidade.getIdCidade());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(Cidade cidade) {
        String sql = "DELETE FROM cidade WHERE id = ?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, cidade.getIdCidade());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Cidade buscar(int idCidade) {
        Cidade cidade = new Cidade();

        String sql = "SELECT nome FROM cidade WHERE id = ?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, idCidade);
            ResultSet rs;
            rs = stmt.executeQuery();
            if (rs.next()){

                cidade.setIdCidade(idCidade);
                cidade.setNome(rs.getString(1));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return cidade;
    }

    @Override
    public List<Cidade> buscarTodos() {
        List<Cidade> listaCidade = new ArrayList<>();

        String sql = "SELECT id, nome FROM cidade";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs;
            rs = stmt.executeQuery();

            while (rs.next()){
                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt(1));
                cidade.setNome(rs.getString(2));

                listaCidade.add(cidade);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return listaCidade;
    }
}
