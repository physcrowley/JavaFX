import javafx.application.Application; // overall program template
import javafx.scene.Scene; // drawing surface object
import javafx.scene.control.Label; // text area object
import javafx.scene.layout.StackPane; // grid object for aligning graphic elements
import javafx.stage.Stage; // window object

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
        Label txt = new Label("Hello, JavaFX!");

        /* Alternate Label using properly set system PATH variables
        String javaVersion = System.getProperty("java.version");  
        String javafxVersion = System.getProperty("javafx.version");
        Label txt = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " 
                        + javaVersion + ".");
        */
        Scene scene = new Scene(new StackPane(txt), 640, 480);
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

/* Windows command line arguments from the folder containing this file:

javac --module-path "%JAVAFX_HOME%" --add-modules javafx.controls HelloFX.java

java --module-path "%JAVAFX_HOME%" --add-modules javafx.controls HelloFX

Where the system environment variable JAVAFX_HOME has been set to the \lib folder of the JavaFX SDK extracted to your system.

*** I have recently had issues with the Windows PATH variable not being interpreted correctly by the javac command and getting the error : cannot find module javafx.controls > in that case, use the config files as described below. ***

================
In case the system environment variable cannot be set properly > create the following configuration files :

compile-<projectName> = 
-d bin
--module-path "Full/path/to/JavaFX/folder/lib" 
--add-modules javafx.controls
src/<projectName>.java

run-<projectName> =
-cp bin
--module-path "Full/path/to/JavaFX/folder/lib" 
--add-modules javafx.controls
<projectName>

where <projectName> is replaced by the name of the appropriate Java file, in this case HelloFX, and "Full/path/..." is the actual path on your system, for example : "C:/Program Files/JavaFX/javafx-sdk-11.0.2/lib"

**** All the "/" need to be forward slashes "/", not the Windows backslash "\" ****

Then use the console commands:
javac @compile-<projectName>
java @run-<projectName>

===============
These config files may be the practical solution whether or not a JAVAFX_HOME variable is set, especially if you are creating your own objects in separate .java files to add to the project > you would also need to add these files to the compilation arguments and that becomes more manageable in a configuration file.
*/