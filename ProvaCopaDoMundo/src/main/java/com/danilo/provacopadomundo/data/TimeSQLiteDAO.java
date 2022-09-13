package com.danilo.provacopadomundo.data;

import com.danilo.provacopadomundo.model.Time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeSQLiteDAO implements GenericDAO<Time> {
    @Override
    public void save(Time time) {
        String sql = "INSERT INTO time (pais) VALUES (?)";
        PreparedStatement stmt = ConnectionFactory.createStatment(sql);
        try{
            stmt.setString(1, time.getPais());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Time time) {
        String sql = "UPDATE time SET pais = ? WHERE idTime = ?";
        PreparedStatement stmt = ConnectionFactory.createStatment(sql);
        try {
            stmt.setString(1, time.getPais());
            stmt.setInt(2, time.getIdTime());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void erase(Time time) {
        String sql = "DELETE FROM time WHERE idTime = ?";
        PreparedStatement stmt = ConnectionFactory.createStatment(sql);
        try {
            stmt.setInt(1,  time.getIdTime());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Time search(int id) {
        Time time = new Time();

        String sql = "SELECT (pais) FROM time WHERE idTime = ?";
        PreparedStatement stmt = ConnectionFactory.createStatment(sql);
        try {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                time.setIdTime(id);
                time.setPais(rs.getString("pais"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return time;
    }

    @Override
    public List<Time> searchAll() {
        List<Time> listTime = new ArrayList<>();

        String sql = "SELECT idTime, pais FROM time";
        PreparedStatement stmt = ConnectionFactory.createStatment(sql);

        try{
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Time time = new Time();
                time.setIdTime(rs.getInt("idTime"));
                time.setPais(rs.getString("pais"));

                listTime.add(time);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return listTime;
    }
}
