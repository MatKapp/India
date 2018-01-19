package sample;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

public class Main extends Application {
    static final Logger LOG = LoggerFactory.getLogger(Main.class);

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        LOG.info("App started");

        //Get all locations and show them in frontend
        EndPoint getLocations = new EndPoint("http://localhost:8080/India_war_exploded/india/locations","GetLocations");
        final EndPoint checkHeatingAlert = new EndPoint("http://localhost:8080/India_war_exploded/india/checkHeatingAlert","GetLocations");
        List<Location> locations = Connection.GetLocations(getLocations.url);
<<<<<<< HEAD
        List<Location> locationsWithAlert = Connection.GetLocations(checkHeatingAlert.url);
=======
        if(locations.isEmpty()){
            LOG.error("No Locations downloaded");
        }else{
            LOG.debug("Downloaded Locations");
        }
>>>>>>> 8e6d19e4edddf826032a8d06cb43fbbd4f9c57e9
        ObservableList<Location> itemsList = FXCollections.observableArrayList();
        itemsList.addAll(locations);



        //Add all endpoints and add them to frontend
        List<EndPoint> endPoints = new ArrayList();
        endPoints.add(new EndPoint("http://localhost:8080/India_war_exploded/india/area","Area"));
        endPoints.add(new EndPoint("http://localhost:8080/India_war_exploded/india/cube","Cube"));
        endPoints.add(new EndPoint("http://localhost:8080/India_war_exploded/india/heating","Heating"));
        endPoints.add(new EndPoint("http://localhost:8080/India_war_exploded/india/light","Light"));
        ObservableList<EndPoint> typesList = FXCollections.observableArrayList();
        typesList.addAll(endPoints);

        LOG.debug("Added endpoints");

        //Prepare components
        int prefWidth = 200;
        int defaultX = 50;
        int labelOffset = 20;
        int groupOffset = 40;

        final Label locationNameLabel = new Label("Choose location to check");
        locationNameLabel.setLayoutX(defaultX);
        locationNameLabel.setPrefWidth(prefWidth);
        locationNameLabel.setLayoutY(20);

        final ChoiceBox locationNameChoose = new ChoiceBox();
        locationNameChoose.setConverter(new LocationConverter());
        locationNameChoose.setItems(itemsList);
        locationNameChoose.setLayoutX(defaultX);
        locationNameChoose.setPrefWidth(prefWidth);
        locationNameChoose.setLayoutY(labelOffset + locationNameLabel.getLayoutY());
        locationNameChoose.setValue(itemsList.get(0));

        final Label dataTypeLabel = new Label("Choose query to ask");
        dataTypeLabel.setLayoutX(defaultX);
        dataTypeLabel.setPrefWidth(prefWidth);
        dataTypeLabel.setLayoutY(groupOffset + locationNameChoose.getLayoutY());

        final ChoiceBox dataTypeChoose = new ChoiceBox();
        dataTypeChoose.setConverter(new EndPointConverter());
        dataTypeChoose.setItems(typesList);
        dataTypeChoose.setLayoutX(defaultX);
        dataTypeChoose.setPrefWidth(prefWidth);
        dataTypeChoose.setLayoutY(labelOffset + dataTypeLabel.getLayoutY());
        dataTypeChoose.setValue(typesList.get(0));

        Button confirmButton = new Button();
        confirmButton.setText("Get Data!!!");
        confirmButton.setLayoutX(defaultX);
        confirmButton.setPrefWidth(prefWidth);
        confirmButton.setLayoutY(groupOffset + labelOffset + dataTypeChoose.getLayoutY());
        confirmButton.setTextFill(Color.WHITE);
        confirmButton.setBackground(new Background(new BackgroundFill(Color.BLUE,
                new CornerRadii(5), Insets.EMPTY)));

        final Separator resultSeparator = new Separator();
        resultSeparator.setMaxWidth(prefWidth);
        resultSeparator.setMinWidth(prefWidth);
        resultSeparator.setLayoutX(defaultX);
        resultSeparator.setLayoutY(groupOffset +  confirmButton.getLayoutY());
        resultSeparator.setBackground(new Background(new BackgroundFill(Color.BLUE,
                new CornerRadii(5), Insets.EMPTY)));
        resultSeparator.setVisible(false);

        final Label resultInfoLabel = new Label();
        resultInfoLabel.setFont(Font.font("Regular", 14));
        resultInfoLabel.setLayoutX(defaultX);
        resultInfoLabel.setPrefWidth(prefWidth);
        resultInfoLabel.setLayoutY(labelOffset +  resultSeparator.getLayoutY());

        final Label resultLabel = new Label();
        resultLabel.setLayoutX(50 + defaultX);
        resultLabel.setPrefWidth(prefWidth);
        resultLabel.setLayoutY(labelOffset + resultInfoLabel.getLayoutY());

        //Add actions
        confirmButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                LOG.info("Requesting data from server");
                EndPoint currentEndPoint = (EndPoint) dataTypeChoose.getValue();
                Location currentLocation = (Location) locationNameChoose.getValue();
                resultSeparator.setVisible(true);
                resultInfoLabel.setText("Your result:");
                String responseData = currentEndPoint.GetData(currentLocation.id);
                resultLabel.setText(responseData);
                LOG.debug("Requested {} for index {} is {}", currentEndPoint.typeName, currentLocation.id, responseData);
            }
        });


        Button checkAlertButton = new Button();
        checkAlertButton.setText("Check alert!");
        checkAlertButton.setLayoutX(defaultX);
        checkAlertButton.setPrefWidth(prefWidth);
        checkAlertButton.setLayoutY(groupOffset + labelOffset + resultLabel.getLayoutY());
        checkAlertButton.setTextFill(Color.WHITE);
        checkAlertButton.setBackground(new Background(new BackgroundFill(Color.BLUE,
                new CornerRadii(5), Insets.EMPTY)));

        Label label1 = new Label("Treshold:");
        TextField textField = new TextField();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField);
        hb.setSpacing(10);
        hb.setLayoutX(defaultX);
        hb.setLayoutY(groupOffset + labelOffset + checkAlertButton.getLayoutY());

        final Separator alertResultSeparator = new Separator();
        alertResultSeparator.setMaxWidth(prefWidth);
        alertResultSeparator.setMinWidth(prefWidth);
        alertResultSeparator.setLayoutX(defaultX);
        alertResultSeparator.setLayoutY(groupOffset +  hb.getLayoutY());
        alertResultSeparator.setBackground(new Background(new BackgroundFill(Color.BLUE,
                new CornerRadii(5), Insets.EMPTY)));
        alertResultSeparator.setVisible(false);

        final Label alertResultInfoLabel = new Label();
        alertResultInfoLabel.setFont(Font.font("Regular", 14));
        alertResultInfoLabel.setLayoutX(defaultX);
        alertResultInfoLabel.setPrefWidth(prefWidth);
        alertResultInfoLabel.setLayoutY(labelOffset +  alertResultSeparator.getLayoutY());

        final Label alertResultLabel = new Label();
        alertResultLabel.setLayoutX(50 + defaultX);
        alertResultLabel.setPrefWidth(prefWidth);
        alertResultLabel.setLayoutY(labelOffset + alertResultInfoLabel.getLayoutY());
        //Add actions
        checkAlertButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    Location currentLocation = (Location) locationNameChoose.getValue();
                    List<Location> locationsWithAlert = Connection.GetLocations(checkHeatingAlert.url);
                    String result = checkHeatingAlert.GetData(currentLocation.id);//"";
//                    for (int i=0; i<locationsWithAlert.size(); i++){
//                        result += locationsWithAlert.get(i).name +String.format(",%n");
//                    }
                    alertResultSeparator.setVisible(true);
                    alertResultInfoLabel.setText("Your result:");
                    alertResultLabel.setText(result);
                }
        });

        //Create header pane
        Pane header = new Pane();

        Label h1 = new Label("Get info about locations!");
        h1.setFont(Font.font("Regular", 16));
        h1.setLayoutX(defaultX);
        h1.setPrefWidth(prefWidth);
        h1.setLayoutY(20);
        header.getChildren().add(h1);

        //Add components to pane
        Pane body = new Pane();
        body.getChildren().add(locationNameLabel);
        body.getChildren().add(locationNameChoose);
        body.getChildren().add(dataTypeLabel);
        body.getChildren().add(dataTypeChoose);
        body.getChildren().add(confirmButton);
        body.getChildren().add(resultSeparator);
        body.getChildren().add(resultInfoLabel);
        body.getChildren().add(resultLabel);
        body.getChildren().add(checkAlertButton);
       // body.getChildren().add(hb);
        body.getChildren().add(alertResultSeparator);
        body.getChildren().add(alertResultInfoLabel);
        body.getChildren().add(alertResultLabel);

        //Add panes to root
        Pane root = new Pane();
        root.getChildren().add(header);
        body.setLayoutY(50);
        root.getChildren().add(body);

        primaryStage.setTitle("Building Info");
        primaryStage.setScene(new Scene(root, 300, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
