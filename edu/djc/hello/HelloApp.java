package edu.djc.hello;

import javax.tools.DocumentationTool.Location;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApp extends Application
{    
    private Parent loadDesign(String fxml)
    {
        try  
            {return FXMLLoader.load(getClass().getResource(fxml));}
        catch(Exception e)
        {
            System.out.println(getClass());
            System.out.println(getClass().getResource(fxml));
            System.out.println("Fxml loading error " + e);
            return (Parent)null;
        }
    }

    Parent root = loadDesign("UI.fxml");
    
    //FXMLLoader fxml = new FXMLLoader(getClass().getResource("UI.fxml"));
     //Parent root = fxml.load();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}