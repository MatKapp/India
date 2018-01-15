package sample;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Pane root = new Pane();

        EndPoint getLocations = new EndPoint("http://localhost:8080/India_war_exploded/helloworld/locations","GetLocations");

        List<Location> locations = Connection.GetLocations(getLocations.url);

        ObservableList<Location> itemsList = FXCollections.observableArrayList();

        itemsList.addAll(locations);

        List<EndPoint> endPoints = new ArrayList();
        endPoints.add(new EndPoint("http://localhost:8080/India_war_exploded/helloworld","Area"));
        endPoints.add(new EndPoint("","Cube"));

        ObservableList<EndPoint> typesList = FXCollections.observableArrayList();
        typesList.addAll(endPoints);

        final ChoiceBox locationNameChoose = new ChoiceBox();
        locationNameChoose.setConverter(new LocationConverter());
        locationNameChoose.setItems(itemsList);
        locationNameChoose.setLayoutX(100);
        locationNameChoose.setPrefWidth(100);
        locationNameChoose.setLayoutY(10);
        locationNameChoose.setValue(itemsList.get(0));

        final ChoiceBox dataTypeChoose = new ChoiceBox();
        dataTypeChoose.setConverter(new EndPointConverter());
        dataTypeChoose.setItems(typesList);
        dataTypeChoose.setLayoutX(100);
        dataTypeChoose.setPrefWidth(100);
        dataTypeChoose.setLayoutY(50);
        dataTypeChoose.setValue(typesList.get(0));

        final Label resultLabel = new Label("");
        resultLabel.setLayoutX(100);
        resultLabel.setPrefWidth(100);
        resultLabel.setLayoutY(150);

        Button button = new Button();
        button.setText("Get Data!!!");
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                EndPoint currentEndPoint = (EndPoint) dataTypeChoose.getValue();
                Location currentLocation = (Location) locationNameChoose.getValue();
                resultLabel.setText(currentEndPoint.GetData(currentLocation.id));
            }
        });
        button.setLayoutX(100);
        button.setPrefWidth(100);
        button.setLayoutY(100);

        root.getChildren().add(button);
        root.getChildren().add(locationNameChoose);
        root.getChildren().add(dataTypeChoose);
        root.getChildren().add(resultLabel);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
