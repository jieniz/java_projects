/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facedetect2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.opencv.core.Core;

/**
 *
 * @author jieni
 */
public class FaceDetect2 extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            BorderPane root = (BorderPane) loader.load();
            // set a whitesmoke background
            root.setStyle("-fx-background-color: whitesmoke;");
            // create and style a scene
            Scene scene = new Scene(root, 800, 600);
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            // create the stage with the given title and the previously created
            // scene
            stage.setTitle("Face Detection and Tracking");
            stage.setScene(scene);
            // show the GUI
            stage.show();

            // init the controller
            FXMLDocumentController controller = loader.getController();

            // set the proper behavior on closing the application
            stage.setOnCloseRequest((new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    controller.setClosed();
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        launch(args);
    }

}
