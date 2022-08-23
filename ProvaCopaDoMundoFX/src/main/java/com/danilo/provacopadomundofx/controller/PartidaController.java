package com.danilo.provacopadomundofx.controller;

import com.danilo.provacopadomundofx.data.PartidaSQLiteDAO;
import com.danilo.provacopadomundofx.data.TimeSQLiteDAO;
import com.danilo.provacopadomundofx.model.Partida;
import com.danilo.provacopadomundofx.model.Time;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class PartidaController  implements Initializable {
    public ComboBox<Time> comboTime1;
    public ComboBox<Time> comboTime2;
    public Spinner<Integer> placarTime1 = new Spinner<Integer>();
    public Spinner<Integer> placarTime2 = new Spinner<Integer>();
    SpinnerValueFactory<Integer> valueFactoryTime1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
    SpinnerValueFactory<Integer> valueFactoryTime2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
    public Button btnNovo;
    public Button btnSalvar;
    public Button btnAtualizar;
    public Button btnExcluir;
    public TableView<Partida> tblTime;
    public TableColumn<Partida, Integer> colIDPartida;
    public TableColumn<Partida, String> colDataPartida;
    public TableColumn<Partida, String> colTime1;
    public TableColumn<Partida, Integer> colPlacarTime1;
    public TableColumn<Partida, String> colTime2;
    public TableColumn<Partida, Integer> colPlacarTime2;
    public DatePicker dataJogo;

    ObservableList<Partida> listView = FXCollections.observableArrayList();
    TimeSQLiteDAO timeSQLiteDAO = new TimeSQLiteDAO();
    PartidaSQLiteDAO partidaSQLiteDAO = new PartidaSQLiteDAO();

    public void limparCampos(ActionEvent actionEvent) {
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        btnNovo.setDisable(true);
        btnSalvar.setDisable(false);
        comboTime1.setDisable(false);
        comboTime2.setDisable(false);
        placarTime1.setEditable(true);
        placarTime2.setEditable(true);
    }

    public void salvar(ActionEvent actionEvent) {
        Partida partida = new Partida();
        partida.setTime1(comboTime1.getValue());
        partida.setTime2(comboTime2.getValue());
        partida.atualizarPlacar(placarTime1.getValue(), placarTime2.getValue());
        partida.setDataJogo(dataJogo.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        partidaSQLiteDAO.salvar(partida);

        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        comboTime1.setDisable(true);
        comboTime2.setDisable(true);
        placarTime1.setEditable(false);
        placarTime2.setEditable(false);

        comboTime1.setValue(null);
        comboTime2.setValue(null);
        valueFactoryTime1.setValue(0);
        valueFactoryTime2.setValue(0);
        dataJogo.setValue(null);
        preencherTabela();
    }

    public void atualizar(ActionEvent actionEvent) {
        Partida partida = tblTime.getSelectionModel().getSelectedItem();
        partida.setTime1(comboTime1.getValue());
        partida.setTime2(comboTime2.getValue());
        partida.atualizarPlacar(placarTime1.getValue(), placarTime2.getValue());
        partida.setDataJogo(dataJogo.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        partidaSQLiteDAO.atualizar(partida);

        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        comboTime1.setDisable(true);
        comboTime2.setDisable(true);
        placarTime1.setEditable(false);
        placarTime2.setEditable(false);

        comboTime1.setValue(null);
        comboTime2.setValue(null);
        valueFactoryTime1.setValue(0);
        valueFactoryTime2.setValue(0);
        dataJogo.setValue(null);
        preencherTabela();
    }

    public void excluir(ActionEvent actionEvent) {
        Partida partida = tblTime.getSelectionModel().getSelectedItem();

        partidaSQLiteDAO.excluir(partida);

        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        comboTime1.setDisable(true);
        comboTime2.setDisable(true);
        placarTime1.setEditable(false);
        placarTime2.setEditable(false);

        comboTime1.setValue(null);
        comboTime2.setValue(null);
        valueFactoryTime1.setValue(0);
        valueFactoryTime2.setValue(0);
        dataJogo.setValue(null);
        preencherTabela();
    }

    public void selecionaPartida(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2){
            comboTime1.setValue(tblTime.getSelectionModel().getSelectedItem().getTime1());
            comboTime2.setValue(tblTime.getSelectionModel().getSelectedItem().getTime2());
            valueFactoryTime1.setValue(tblTime.getSelectionModel().getSelectedItem().getPlacarTime1());
            valueFactoryTime2.setValue(tblTime.getSelectionModel().getSelectedItem().getPlacarTime2());
            dataJogo.setValue(LocalDate.parse(tblTime.getSelectionModel().getSelectedItem().getDataJogo()));

            btnAtualizar.setDisable(false);
            btnExcluir.setDisable(false);
            btnNovo.setDisable(false);
            btnSalvar.setDisable(true);
            comboTime1.setDisable(false);
            comboTime2.setDisable(false);
            placarTime1.setEditable(true);
            placarTime2.setEditable(true);
            dataJogo.setEditable(true);

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAtualizar.setDisable(true);
        btnExcluir.setDisable(true);
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        comboTime1.setDisable(true);
        comboTime2.setDisable(true);
        placarTime1.setEditable(false);
        placarTime2.setEditable(false);
        dataJogo.setEditable(false);
        preencherTabela();
        preencherCombos();


        placarTime1.setValueFactory(valueFactoryTime1);
        placarTime2.setValueFactory(valueFactoryTime2);

    }

    private void preencherCombos(){
        ObservableList<Time> listViewTime;

        listViewTime = FXCollections.observableArrayList(timeSQLiteDAO.buscarTodos());

        comboTime1.setItems(listViewTime);
        comboTime1.setConverter(new StringConverter<Time>() {
            @Override
            public String toString(Time object) {
                if (object != null){
                    return object.getPais();
                }
                return null;
            }

            @Override
            public Time fromString(String string) {
                return null;
            }
        });

        comboTime2.setItems(listViewTime);
        comboTime2.setConverter(new StringConverter<Time>() {
            @Override
            public String toString(Time object) {
                if (object != null){
                    return object.getPais();
                }
                return null;
            }

            @Override
            public Time fromString(String string) {
                return null;
            }
        });
    }

    private void preencherTabela() {
        listView.clear();

        colIDPartida.setCellValueFactory(new PropertyValueFactory<>("idPartida"));
        colDataPartida.setCellValueFactory(new PropertyValueFactory<>("dataJogo"));
        colPlacarTime1.setCellValueFactory(new PropertyValueFactory<>("placarTime1"));
        colPlacarTime2.setCellValueFactory(new PropertyValueFactory<>("placarTime2"));
        colTime1.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getTime1().getPais()));
        colTime2.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getTime2().getPais()));

        listView = FXCollections.observableArrayList(partidaSQLiteDAO.buscarTodos());

        tblTime.setItems(listView);

    }
}
