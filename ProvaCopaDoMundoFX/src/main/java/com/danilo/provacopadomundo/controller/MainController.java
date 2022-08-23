package com.danilo.provacopadomundo.controller;

import com.danilo.provacopadomundo.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    public void showPartida(ActionEvent actionEvent) {
        Parent root;
        try{
            root = FXMLLoader.load(MainApplication.class.getResource("partida-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Partida");
            stage.setScene(new Scene(root, 590, 450));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showTime(ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(MainApplication.class.getResource("time-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Time");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}