/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Gaukhar
 */
public class TrafficLight extends Application{
        
        private double paneWidth = 200;
        private double paneHeight = 100;

        public void start(Stage primaryStage) {
                Pane pane = new Pane();
                Circle redcircle = new Circle(paneWidth/2, 20, 10);
                Circle yellowcircle = new Circle(paneWidth/2, 50, 10);
                Circle greencircle = new Circle(paneWidth/2, 80, 10);
                redcircle.setFill(Color.WHITE);
                yellowcircle.setFill(Color.WHITE);
                greencircle.setFill(Color.WHITE);
                redcircle.setStroke(Color.BLACK);
                yellowcircle.setStroke(Color.BLACK);
                greencircle.setStroke(Color.BLACK);
                
                Rectangle rect = new Rectangle(paneWidth/2 -15, 5, 30, 90);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.BLACK);
                pane.getChildren().addAll(rect, redcircle, 
                                yellowcircle, greencircle);
                
                
                HBox paneForRadioButtons = new HBox(5);
                paneForRadioButtons.setAlignment(Pos.CENTER);
                paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5));
                paneForRadioButtons.setStyle("-fx-border-color: green");
                paneForRadioButtons.setStyle
                ("-fx-border-width: 2px; -fx-border-color: green");
                RadioButton rbRed = new RadioButton("Red");
                RadioButton rbGreen = new RadioButton("Yellow");
                RadioButton rbBlue = new RadioButton("Green");
                paneForRadioButtons.getChildren().addAll(rbRed, rbGreen, rbBlue);
                
                ToggleGroup group = new ToggleGroup();
                rbRed.setToggleGroup(group);
                rbGreen.setToggleGroup(group);
                rbBlue.setToggleGroup(group);

                rbRed.setOnAction(e -> {
                if (rbRed.isSelected()) {
                redcircle.setFill(Color.RED);
                yellowcircle.setFill(Color.WHITE);
                greencircle.setFill(Color.WHITE);
                }
                });

                rbGreen.setOnAction(e -> {
                if (rbGreen.isSelected()) {
                yellowcircle.setFill(Color.YELLOW);
                redcircle.setFill(Color.WHITE);
                greencircle.setFill(Color.WHITE);
                
               }
                });

                rbBlue.setOnAction(e -> {
                if (rbBlue.isSelected()) {
                greencircle.setFill(Color.GREEN);
                yellowcircle.setFill(Color.WHITE);
                redcircle.setFill(Color.WHITE);
                }
                });
                
                BorderPane bPane = new BorderPane();
                bPane.setCenter(pane);
                bPane.setBottom(paneForRadioButtons);
                
                
                Scene scene = new Scene(bPane, paneWidth, paneHeight + 40 );
                primaryStage.setTitle("Traffic Light");
                primaryStage.setScene(scene);
                primaryStage.show();
        }
        public static void main(String[] args){
    Application.launch(args);
}
}
