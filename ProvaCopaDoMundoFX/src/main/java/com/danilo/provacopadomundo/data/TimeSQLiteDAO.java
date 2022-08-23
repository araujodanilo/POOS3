package com.danilo.provacopadomundo.data;

import com.danilo.provacopadomundo.model.Time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeSQLiteDAO implements GenericDAO<Time>{
    @Override
    public void salvar(Time time) {
        String sql = "INSERT INTO time (pais) VALUES (?)";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1, time.getPais());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Time time) {
        String sql = "UPDATE time SET pais = ? WHERE idTime = ?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1, time.getPais());
            stmt.setInt(2, time.getIdTime());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Time time){
        String sql = "DELETE FROM time WHERE idTime = ?";
        try {
            PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setInt(1, time.getIdTime());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Time buscar(int idTime) {
        Time time = new Time();
        String sql = "SELECT pais FROM time WHERE idTime = ?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, idTime);
            ResultSet rs;
            rs = stmt.executeQuery();
            if (rs.next()){

                time.setIdTime(idTime);
                time.setPais(rs.getString(1));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return time;
    }

    @Override
    public List<Time> buscarTodos() {
        List<Time> timeList = new ArrayList<>();
        String sql = "select idTime, pais From time;";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()){
                Time time = new Time();

                time.setIdTime(rs.getInt(1));
                time.setPais(rs.getString(2));

                timeList.add(time);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return timeList;
    }
}
