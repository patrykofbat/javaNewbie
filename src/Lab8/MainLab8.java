package Lab8;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

public class MainLab8 extends Application {



    @Override
    public void start(Stage primaryStage)throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root, 600,400);
        primaryStage.setTitle("Image dependecies");
        File file = new File("C:\\Users\\Patryk\\Documents\\Obrazki\\icon.jpg");
        Image img = new Image(file.toURI().toString());
        primaryStage.getIcons().add(img);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);

    }

}
