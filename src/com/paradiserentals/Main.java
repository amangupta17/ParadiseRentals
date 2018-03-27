package com.paradiserentals;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Aman on 3/25/2018.
 */
public class Main extends Application implements EventHandler<ActionEvent>{

    private Button button;
    private List<VehicleRequest> vehicleRequests = new ArrayList<VehicleRequest>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Paradise Rentals");

        button = new Button();
        button.setText("Add Vehicle");

        button.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == button){*+
            VehicleRequest vRequest = new VehicleRequest();
            this.vehicleRequests.add(vRequest);
        }
    }
}
