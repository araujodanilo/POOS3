package com.danilo.provacopadomundofx.data;

import com.danilo.provacopadomundofx.model.Partida;
import com.danilo.provacopadomundofx.model.Time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidaSQLiteDAO implements GenericDAO<Partida>{
    @Override
    public void salvar(Partida partida) {
        String sql = "INSERT INTO partida (dataJogo, time1, time2, placarTime1, placarTime2) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
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
    public void atualizar(Partida partida) {
        String sql = "UPDATE partida SET dataJogo = ?, time1 = ?, time2 = ?, placarTime1 = ?, placarTime2 = ? WHERE idPartida = ?";

        try {
            PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
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
    public void excluir(Partida partida) {
        String sql = "DELETE FROM partida WHERE idPartida = ?";

        try {
            PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setInt(1, partida.getIdPartida());
            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Partida buscar(int id) {
        Partida partida = new Partida();

        String sql = "SELECT * FROM partida WHERE idPartida = ?";

        try {
            PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs;

            rs = stmt.executeQuery();

            if (rs.next()){
                partida.setIdPartida(rs.getInt("idPartida"));
                partida.setDataJogo(rs.getString("dataJogo"));
                Time time1 = new TimeSQLiteDAO().buscar(rs.getInt("time1"));
                Time time2 = new TimeSQLiteDAO().buscar(rs.getInt("time2"));

                partida.setTime1(time1);
                partida.setTime1(time2);

                partida.atualizarPlacar(rs.getInt("placarTime1"), rs.getInt("placarTime2"));

            }

            stmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return partida;
    }

    @Override
    public List<Partida> buscarTodos() {
        List<Partida> partidaList = new ArrayList<>();

        String sql = "SELECT * FROM partida";

        try {

            PreparedStatement stmt = ConnectionFactory.criaStatement(sql);
            ResultSet rs;
            rs = stmt.executeQuery();
            while(rs.next()){
                Partida partida = new Partida();

                partida.setIdPartida(rs.getInt("idPartida"));
                partida.setDataJogo(rs.getString("dataJogo"));
                Time time1 = new TimeSQLiteDAO().buscar(rs.getInt("time1"));
                Time time2 = new TimeSQLiteDAO().buscar(rs.getInt("time2"));

                partida.setTime1(time1);
                partida.setTime2(time2);

                partida.atualizarPlacar(rs.getInt("placarTime1"), rs.getInt("placarTime2"));

                partidaList.add(partida);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }


        return partidaList;
    }
}
