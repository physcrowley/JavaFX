package edu.djc.button;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
 
public class MovingButtonApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        // Make button
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(event -> System.out.println("Hello World!"));

        //
        // Animate Button as per www.javafxpedia.com 
        //   - instead of just X, added Y translations to march the button around a box
        //
        Timeline t = new Timeline(
            new KeyFrame(Duration.seconds(0), new KeyValue(btn.translateXProperty(), 0)), // original example
            new KeyFrame(Duration.seconds(0), new KeyValue(btn.translateYProperty(), 0)),
            new KeyFrame(Duration.seconds(1), new KeyValue(btn.translateXProperty(), 80)), // original example
            new KeyFrame(Duration.seconds(1), new KeyValue(btn.translateYProperty(), 0)),
            new KeyFrame(Duration.seconds(2), new KeyValue(btn.translateXProperty(), 80)),
            new KeyFrame(Duration.seconds(2), new KeyValue(btn.translateYProperty(), -80)),
            new KeyFrame(Duration.seconds(3), new KeyValue(btn.translateXProperty(), 0)),
            new KeyFrame(Duration.seconds(3), new KeyValue(btn.translateYProperty(), -80)),
            new KeyFrame(Duration.seconds(4), new KeyValue(btn.translateXProperty(), 0)),
            new KeyFrame(Duration.seconds(4), new KeyValue(btn.translateYProperty(), 0))
        );
        //t.setAutoReverse(true);
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();

        // Set DOM
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        // Set and show window
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
