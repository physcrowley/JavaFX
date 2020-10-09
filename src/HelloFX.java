/* Command line arguments from the folder containing this file:
javac --module-path "%JAVAFX_HOME%" --add-modules javafx.controls HelloFX.java

java --module-path "%JAVAFX_HOME%" --add-modules javafx.controls HelloFX

Where the system environment variable JAVAFX_HOME has been set to the \lib folder of the JavaFX sdk.

================
In case these cannot be set properly > create the following configuration files :

compile-<projectName> = 
-d bin
--module-path "Full\path\to\JavaFX\folder\lib" 
--add-modules javafx.controls
<projectName>.java

run-<projectName> =
-cp bin
--module-path "Full\path\to\JavaFX\folder\lib" 
--add-modules javafx.controls
<projectName>

where <projectName> is replaced by the name of the appropriate Java file, in this case HelloFX.

Then use the console commands:
javac @compile-<projectName>
java @run-<projectName>
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Simple Hello World window application
 */
public class HelloFX extends Application {

    /**
     * Main JavaFX script
     * @param stage is the window created at launch
     */
    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main Java script
     * @param args runtime arguments from the shell
     */
    public static void main(String[] args) {
        launch();
    }

}