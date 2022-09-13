package com.danilo.escoladbfx.controller;

import com.danilo.escoladbfx.data.CursoSQLiteDAO;
import com.danilo.escoladbfx.model.Curso;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CursoController implements Initializable {
    @FXML private TextField txtNomeCurso;
    @FXML private Button btnNovo;
    @FXML private Button btnSalvar;
    @FXML private Button btnAtualizar;
    @FXML private Button btnExcluir;
    @FXML private TableView<Curso> tblCurso;
    @FXML private TableColumn<Curso, String> colNomeCurso;
    @FXML private TableColumn colIdCurso;

    ObservableList<Curso> listView = FXCollections.observableArrayList();
    CursoSQLiteDAO cursoSQLiteDAO = new CursoSQLiteDAO();

    public void limparCampos(ActionEvent actionEvent) {
        txtNomeCurso.clear();
        txtNomeCurso.requestFocus();
        btnNovo.setDisable(true);
        btnSalvar.setDisable(false);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtNomeCurso.setEditable(true);
    }

    public void salvar(ActionEvent actionEvent) {
        Curso c = new Curso(txtNomeCurso.getText());
        cursoSQLiteDAO.salvar(c);

        preencherTabela();

        txtNomeCurso.clear();
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtNomeCurso.setEditable(false);
    }

    public void atualizar(ActionEvent actionEvent) {
        Curso c = tblCurso.getSelectionModel().getSelectedItem();
        c.setNome(txtNomeCurso.getText());
        cursoSQLiteDAO.atualizar(c);
        preencherTabela();
    }
    public void excluir(ActionEvent actionEvent) {
        Curso c = tblCurso.getSelectionModel().getSelectedItem();
        cursoSQLiteDAO.apagar(c);
        preencherTabela();

        txtNomeCurso.clear();
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtNomeCurso.setEditable(false);

    }

    public void selecionaCurso(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount()==2) {
            Curso c = tblCurso.getSelectionModel().getSelectedItem();
            txtNomeCurso.setText(c.getNome());

            txtNomeCurso.setEditable(true);
            btnAtualizar.setDisable(false);
            btnExcluir.setDisable(false);

        }
    }

    public void preencherTabela(){
        listView.clear();
        colNomeCurso.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colIdCurso.setCellValueFactory(new PropertyValueFactory<>("idCurso"));

        listView = FXCollections.observableArrayList(cursoSQLiteDAO.buscarTodos());

        tblCurso.setItems(listView);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        preencherTabela();
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtNomeCurso.setEditable(false);
    }

}