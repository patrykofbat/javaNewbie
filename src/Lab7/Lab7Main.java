package Lab7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Lab7Main extends Application {


    //overriding abstract method start from abstract class Application
    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group(); // Group - not resizable Pane - resizable
        Circle circle  = new Circle(300, 200, 60, Color.RED);
        Text text = new Text(240,60,"Kształt");
        text.setFont(new Font(40));
        text.setFill(Color.DARKBLUE);

        //creating button
        Button button1 = new Button("Next shape");
        button1.setLayoutX(265);
        button1.setLayoutY(300);
        root.getChildren().add(circle);
        root.getChildren().add(text);
        root.getChildren().add(button1);

        //creating button

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Rectangle rectangle = new Rectangle(100, 100, Color.RED);
                rectangle.setX(240);
                rectangle.setY(150);
                root.getChildren().remove(circle);
                root.getChildren().add(rectangle);




            }
        });


        //creating scene(root, width, height, fill)
        Scene scene = new Scene(root, 600 , 400, Color.LIGHTGRAY);
        //setting stage scene
        primaryStage.setScene(scene);
        primaryStage.setTitle("Shapes");
        primaryStage.getIcons().add(new Image("file:C:\\Users\\Patryk\\Documents\\Obrazki\\icon.jpg"));
        //display stage
        primaryStage.show();

    }

    public static void main(String[] args){
        //running app
        Application.launch(args);
    }

}
