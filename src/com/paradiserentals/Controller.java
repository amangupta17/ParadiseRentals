package com.paradiserentals;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private ChoiceBox<String> cb;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> vehicleList = FXCollections.observableArrayList(
                "Midsize Cars",
                "Economy Cars",
                "Luxury Cars",
                "Motorcycles"
        );

        //this.cb = new ChoiceBox<>();
        cb.setItems(vehicleList);
    }
}


