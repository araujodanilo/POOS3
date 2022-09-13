package com.danilo.provacopadomundo.data;

import com.danilo.provacopadomundo.model.Partida;
import com.danilo.provacopadomundo.model.Time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidaSQLiteDAO implements GenericDAO<Partida> {
    @Override
    public void save(Partida partida) {
        String sql = "INSERT INTO partida (dataJogo, time1, time2, placarTime1, placarTime2) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = ConnectionFactory.createStatment(sql);
        try {
            stmt.setString(1, partida.getDataJogo());
            stmt.setInt(2, partida.getTime1().getIdTime());
            stmt.setInt(3, partida.getTime2().getIdTime());
            stmt.setInt(4, partida.getPlacarTime1());
            stmt.setInt(5, partida.getPlacarTime2());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Partida partida) {
        String sql = "UPDATE partida SET dataJogo = ?, time1 = ?, time2 = ?, placarTime1 = ?, placarTime2 = ? WHERE idPartida = ?";
        PreparedStatement stmt = ConnectionFactory.createStatment(sql);
        try {
            stmt.setString(1, partida.getDataJogo());
            stmt.setInt(2, partida.getTime1().getIdTime());
            stmt.setInt(3, partida.getTime2().getIdTime());
            stmt.setInt(4, partida.getPlacarTime1());
            stmt.setInt(5, partida.getPlacarTime2());
            stmt.setInt(6, partida.getIdPartida());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void erase(Partida partida) {
        String sql = "DELETE FROM partida WHERE idPartida = ?";
        PreparedStatement stmt = ConnectionFactory.createStatment(sql);
        try {
            stmt.setInt(1, partida.getPlacarTime2());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Partida search(int id) {
        Partida partida = new Partida();

        String sql = "SELECT dataJogo, time1, time2, placarTime1, placarTime2 FROM partida WHERE idPartida = ?";
        PreparedStatement stmt = ConnectionFactory.createStatment(sql);

        try{
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                partida.setIdPartida(id);
                partida.setDataJogo(rs.getString("dataJogo"));
                Time time1 = new TimeSQLiteDAO().search(rs.getInt("time1"));
                partida.setTime1(time1);
                Time time2 = new TimeSQLiteDAO().search(rs.getInt("time2"));
                partida.setTime2(time2);
                partida.atualzarPlacar(rs.getInt("placarTime1"), rs.getInt("placarTime2"));

            }

        }catch (SQLException e){
            e.printStackTrace();
        }


        return partida;
    }

    @Override
    public List<Partida> searchAll() {
        List<Partida> partidaList = new ArrayList<>();

        String sql = "SELECT idPartida, dataJogo, time1, time2, placarTime1, placarTime2 FROM partida";
        PreparedStatement stmt = ConnectionFactory.createStatment(sql);

        try{
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Partida partida = new Partida();

                partida.setIdPartida(rs.getInt("idPartida"));
                partida.setDataJogo(rs.getString("dataJogo"));
                Time time1 = new TimeSQLiteDAO().search(rs.getInt("time1"));
                partida.setTime1(time1);
                Time time2 = new TimeSQLiteDAO().search(rs.getInt("time2"));
                partida.setTime2(time2);
                partida.atualzarPlacar(rs.getInt("placarTime1"), rs.getInt("placarTime2"));

                partidaList.add(partida);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


        return partidaList;
    }
}
