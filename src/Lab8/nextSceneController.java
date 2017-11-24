package Lab8;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class nextSceneController implements Initializable{

    @FXML
    private ImageView imgDis;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("C:\\Users\\Patryk\\Documents\\Obrazki\\icon.jpg");
        Image img = new Image(file.toURI().toString());
        imgDis.setImage(img);

    }
}
