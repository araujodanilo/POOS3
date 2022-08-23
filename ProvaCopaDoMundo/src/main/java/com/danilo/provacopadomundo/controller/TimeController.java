package com.danilo.provacopadomundo.controller;

import com.danilo.provacopadomundo.data.TimeSQLiteDAO;
import com.danilo.provacopadomundo.model.Time;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class TimeController implements Initializable {
    public TextField txtNomeTime;
    public Button btnNovo;
    public Button btnSalvar;
    public Button btnAtualizar;
    public Button btnExcluir;
    public TableView<Time> tblTime;
    public TableColumn<Time, Integer> colIDCurso;
    public TableColumn<Time, String> colIDNome;

    ObservableList<Time> listView = FXCollections.observableArrayList();
    TimeSQLiteDAO timeSQLiteDAO = new TimeSQLiteDAO();

    public void limparCampos(ActionEvent actionEvent) {
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        btnNovo.setDisable(true);
        btnSalvar.setDisable(false);
        txtNomeTime.setEditable(true);
        tblTime.setDisable(false);

    }

    public void salvar(ActionEvent actionEvent) {
        Time time = new Time();
        time.setPais(txtNomeTime.getText());
        timeSQLiteDAO.salvar(time);
        txtNomeTime.clear();

        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        txtNomeTime.setEditable(false);
        tblTime.setDisable(false);
        preencherTabela();

    }

    public void atualizar(ActionEvent actionEvent) {
        Time time = tblTime.getSelectionModel().getSelectedItem();
        time.setPais(txtNomeTime.getText());
        System.out.println(txtNomeTime.getText());
        timeSQLiteDAO.atualizar(time);
        txtNomeTime.clear();

        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        txtNomeTime.setEditable(false);
        tblTime.setDisable(false);
        preencherTabela();

    }

    public void excluir(ActionEvent actionEvent) {
        Time time = tblTime.getSelectionModel().getSelectedItem();
        timeSQLiteDAO.excluir(time);
        txtNomeTime.clear();

        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        txtNomeTime.setEditable(false);
        tblTime.setDisable(false);
        preencherTabela();

    }

    public void selecionaTime(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2){
            tblTime.setDisable(true);
            btnAtualizar.setDisable(false);
            btnExcluir.setDisable(false);
            btnNovo.setDisable(false);
            btnSalvar.setDisable(true);
            txtNomeTime.setEditable(true);
            tblTime.setDisable(true);


        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        txtNomeTime.setEditable(false);
        tblTime.setDisable(false);
        preencherTabela();
    }

    private void preencherTabela() {
        listView.clear();

        colIDCurso.setCellValueFactory(new PropertyValueFactory<>("idTime"));
        colIDNome.setCellValueFactory(new PropertyValueFactory<>("pais"));

        listView = FXCollections.observableArrayList(timeSQLiteDAO.buscarTodos());

        tblTime.setItems(listView);
    }
}
