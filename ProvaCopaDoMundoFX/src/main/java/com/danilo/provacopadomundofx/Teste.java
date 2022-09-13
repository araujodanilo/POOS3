package com.danilo.provacopadomundofx;

import com.danilo.provacopadomundofx.data.PartidaSQLiteDAO;
import com.danilo.provacopadomundofx.data.TimeSQLiteDAO;
import com.danilo.provacopadomundofx.model.Partida;
import com.danilo.provacopadomundofx.model.Time;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        List<Time> timeList = new ArrayList<>();
        TimeSQLiteDAO timeSQLiteDAO = new TimeSQLiteDAO();
        timeList = timeSQLiteDAO.buscarTodos();

        for (Time t : timeList){
            t.mostrarDados();
        }

        List<Partida> partidaList = new ArrayList<>();
        PartidaSQLiteDAO partidaSQLiteDAO = new PartidaSQLiteDAO();
        partidaList = partidaSQLiteDAO.buscarTodos();

        for (Partida p : partidaList){
            p.mostrarDados();
        }

    }
}
