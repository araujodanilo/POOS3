package com.danilo.escoladbfx.controller;

import com.danilo.escoladbfx.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalController {
    public void showCursoController(ActionEvent actionEvent) {
        Parent root;
        try{
            root = FXMLLoader.load(Principal.class.getResource("curso-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Curso");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showCidadeController(ActionEvent actionEvent) {
        Parent root;
        try{
            root = FXMLLoader.load(Principal.class.getResource("cidade-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Cidade");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showAlunoController(ActionEvent actionEvent) {
        Parent root;
        try{
            root = FXMLLoader.load(Principal.class.getResource("aluno-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Cidade");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}