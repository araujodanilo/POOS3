package com.danilo.escoladbfx.controller;

import com.danilo.escoladbfx.data.CidadeSQLiteDAO;
import com.danilo.escoladbfx.model.Cidade;
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

public class CidadeController implements Initializable {
    @FXML private TextField txtNomeCidade;
    @FXML private Button btnNovo;
    @FXML private Button btnSalvar;
    @FXML private Button btnAtualizar;
    @FXML private Button btnExcluir;
    @FXML private TableView<Cidade> tblCidade;
    @FXML private TableColumn<Cidade, Integer> colIdCidade;
    @FXML private TableColumn<Cidade, String> colNomeCidade;

    ObservableList<Cidade> listView = FXCollections.observableArrayList();
    CidadeSQLiteDAO cidadeSQLiteDAO = new CidadeSQLiteDAO();

    public void limparCampos(ActionEvent actionEvent) {
        txtNomeCidade.clear();
        txtNomeCidade.requestFocus();
        btnNovo.setDisable(true);
        btnSalvar.setDisable(false);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtNomeCidade.setEditable(true);
    }

    public void salvar(ActionEvent actionEvent) {
        Cidade c = new Cidade(txtNomeCidade.getText());
        cidadeSQLiteDAO.salvar(c);

        preencherTabela();

        txtNomeCidade.clear();
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtNomeCidade.setEditable(false);
    }

    public void atualizar(ActionEvent actionEvent) {
        Cidade c = tblCidade.getSelectionModel().getSelectedItem();
        c.setNome(txtNomeCidade.getText());
        cidadeSQLiteDAO.atualizar(c);

        txtNomeCidade.clear();
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtNomeCidade.setEditable(false);

        preencherTabela();
    }
    public void excluir(ActionEvent actionEvent) {
        Cidade c = tblCidade.getSelectionModel().getSelectedItem();
        cidadeSQLiteDAO.apagar(c);
        preencherTabela();

        txtNomeCidade.clear();
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtNomeCidade.setEditable(false);

    }

    public void selecionaCidade(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount()==2) {
            Cidade c = tblCidade.getSelectionModel().getSelectedItem();
            txtNomeCidade.setText(c.getNome());

            txtNomeCidade.setEditable(true);
            btnAtualizar.setDisable(false);
            btnExcluir.setDisable(false);
            btnSalvar.setDisable(true);
            btnNovo.setDisable(false);
        }
    }

    public void preencherTabela(){
        listView.clear();
        colIdCidade.setCellValueFactory(new PropertyValueFactory<>("idCidade"));
        colNomeCidade.setCellValueFactory(new PropertyValueFactory<>("nome"));

        listView = FXCollections.observableArrayList(cidadeSQLiteDAO.buscarTodos());

        tblCidade.setItems(listView);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        preencherTabela();
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtNomeCidade.setEditable(false);
    }
}
