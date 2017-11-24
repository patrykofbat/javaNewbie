package Lab8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class controller  {
    @FXML
    private Button btn1;

    public void handleSubmitButton(ActionEvent event)throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("sample_2.fxml"));
        Scene nextScene = new Scene(root, 600, 400);
        System.out.println("siemka");
        Stage stage = (Stage)btn1.getScene().getWindow();
        stage.setScene(nextScene);



    }

}
