package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller6 {
    public void see(ActionEvent e) {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("cauhoi.fxml"));
        Parent manhinh = null;
        try {
            manhinh = loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Scene scene = new Scene(manhinh);

        stage.setScene(scene);
    }

    public void back(ActionEvent e) {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("manhinhchinh.fxml"));
        Parent manhinh = null;
        try {
            manhinh = loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Scene scene = new Scene(manhinh);

        stage.setScene(scene);
    }
}
