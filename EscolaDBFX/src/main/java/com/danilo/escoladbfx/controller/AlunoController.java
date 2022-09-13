package com.danilo.escoladbfx.controller;

import com.danilo.escoladbfx.data.AlunoSQLiteDAO;
import com.danilo.escoladbfx.data.CidadeSQLiteDAO;
import com.danilo.escoladbfx.data.CursoSQLiteDAO;
import com.danilo.escoladbfx.model.Aluno;
import com.danilo.escoladbfx.model.Cidade;
import com.danilo.escoladbfx.model.Curso;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class AlunoController implements Initializable {
    @FXML private TextField txtNomeAluno;
    @FXML private TextField txtProntuarioAluno;
    @FXML private Button btnNovo;
    @FXML private Button btnSalvar;
    @FXML private Button btnAtualizar;
    @FXML private Button btnExcluir;
    @FXML private TableView<Aluno> tblAluno;
    @FXML private TableColumn<Aluno, Integer> colIdAluno;
    @FXML private TableColumn<Aluno, String> colProntuarioAluno;
    @FXML private TableColumn<Aluno, String> colNomeAluno;
    @FXML private TableColumn<Aluno, String> colNomeCidade;
    @FXML private TableColumn<Aluno, String> colNomeCurso;
    @FXML private ComboBox<Cidade> comboCidade;
    @FXML private ComboBox<Curso> comboCurso;

    ObservableList<Aluno> listView = FXCollections.observableArrayList();
    AlunoSQLiteDAO alunoSQLiteDAO = new AlunoSQLiteDAO();

    public void limparCampos(ActionEvent actionEvent) {
        tblAluno.setDisable(false);

        txtNomeAluno.clear();
        txtProntuarioAluno.clear();
        txtNomeAluno.requestFocus();
        btnNovo.setDisable(true);
        btnSalvar.setDisable(false);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtNomeAluno.setEditable(true);
        txtProntuarioAluno.setEditable(true);
        comboCurso.setDisable(false);
        comboCidade.setDisable(false);
    }

    public void salvar(ActionEvent actionEvent) {
        Aluno a = new Aluno();
        a.setNome(txtNomeAluno.getText());
        a.setProntuario(txtProntuarioAluno.getText());
        a.setCurso(comboCurso.getValue());
        a.setCidade(comboCidade.getValue());
        alunoSQLiteDAO.salvar(a);
        tblAluno.setDisable(false);
        preencherTabela();

        txtNomeAluno.clear();
        txtProntuarioAluno.clear();
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtNomeAluno.setEditable(false);
        txtProntuarioAluno.setEditable(false);
        comboCurso.setDisable(true);
        comboCidade.setDisable(true);
    }

    public void atualizar(ActionEvent actionEvent) {
        tblAluno.setDisable(false);

        Aluno a = tblAluno.getSelectionModel().getSelectedItem();
        a.setNome(txtNomeAluno.getText());
        a.setProntuario(txtProntuarioAluno.getText());
        a.setCurso(comboCurso.getValue());
        a.setCidade(comboCidade.getValue());
        alunoSQLiteDAO.atualizar(a);

        txtNomeAluno.clear();
        txtProntuarioAluno.clear();
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtNomeAluno.setEditable(false);
        txtProntuarioAluno.setEditable(false);
        comboCurso.setDisable(true);
        comboCidade.setDisable(true);

        preencherTabela();
    }
    public void excluir(ActionEvent actionEvent) {
        Aluno a = tblAluno.getSelectionModel().getSelectedItem();
        alunoSQLiteDAO.apagar(a);
        tblAluno.setDisable(false);

        preencherTabela();

        txtNomeAluno.clear();
        txtProntuarioAluno.clear();
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtNomeAluno.setEditable(false);
        txtProntuarioAluno.setEditable(false);
        comboCurso.setDisable(true);
        comboCidade.setDisable(true);

    }
    public void selecionaAluno(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount()==2) {
            tblAluno.setDisable(true);

            Aluno a = tblAluno.getSelectionModel().getSelectedItem();
            txtNomeAluno.setText(a.getNome());
            txtProntuarioAluno.setText(a.getProntuario());

            txtNomeAluno.setEditable(true);
            txtProntuarioAluno.setEditable(true);
            btnAtualizar.setDisable(false);
            btnExcluir.setDisable(false);
            btnSalvar.setDisable(true);
            btnNovo.setDisable(false);
            comboCurso.setDisable(false);
            comboCidade.setDisable(false);
        }
    }

    public void preencherTabela(){
        listView.clear();
        colIdAluno.setCellValueFactory(new PropertyValueFactory<>("idAluno"));
        colProntuarioAluno.setCellValueFactory(new PropertyValueFactory<>("prontuario"));
        colNomeAluno.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colNomeCurso.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getCurso().getNome()));
        colNomeCidade.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getCidade().getNome()));

        listView = FXCollections.observableArrayList(alunoSQLiteDAO.buscarTodos());

        tblAluno.setItems(listView);
    }

    public void preencherComboBox(){
        ObservableList<Curso> listViewCurso;
        listViewCurso = FXCollections.observableArrayList(new CursoSQLiteDAO().buscarTodos());
        comboCurso.setItems(listViewCurso);
        comboCurso.setConverter(new StringConverter<>() {
            @Override
            public String toString(Curso c) {
                if (c!=null)
                    return c.getNome();
                return null;
            }

            @Override
            public Curso fromString(String s) {
                return null;
            }
        });

        ObservableList<Cidade> listViewCidade;
        listViewCidade = FXCollections.observableArrayList(new CidadeSQLiteDAO().buscarTodos());
        comboCidade.setItems(listViewCidade);
        comboCidade.setConverter(new StringConverter<>() {
            @Override
            public String toString(Cidade c) {
                if (c!=null)
                    return c.getNome();
                return null;
            }

            @Override
            public Cidade fromString(String s) {
                return null;
            }
        });
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        preencherTabela();
        preencherComboBox();
        btnSalvar.setDisable(true);
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        txtNomeAluno.setEditable(false);
        txtProntuarioAluno.setEditable(false);
        comboCurso.setDisable(true);
        comboCidade.setDisable(true);
    }
}
