package edu.djc.button;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class ButtonApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    public void buttonClick()
    {
        System.out.println("Hello World!");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");

        btn.setOnAction(event -> System.out.println("Hello World!")); //expression lambda
        
        //btn.setOnAction(event -> buttonClick()); //expression lambda qui appelle une autre fonction

        /*
        btn.setOnAction(new EventHandler<ActionEvent>() { // déclaration de classe anonyme
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        */

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
