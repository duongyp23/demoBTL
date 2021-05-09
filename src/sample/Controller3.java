package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller3  implements Initializable{
    @FXML
    private TableView<String> table1;
    @FXML
    private  TableView<String> table2;
    @FXML
    private  TableColumn<String,String> khuyenkhich;
    @FXML
    private TableColumn<String,String> hanche;

    private ObservableList<String> khuyenkhichs;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        khuyenkhichs = FXCollections.observableArrayList("aaaa","dádasd");

        table1.setItems(khuyenkhichs);
    }
    public void fix1(ActionEvent e) {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("thongtinsuckhoe.fxml"));
        Parent manhinh = null;
        try {
            manhinh = loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Scene scene = new Scene(manhinh);

        stage.setScene(scene);
    }

    public void fix2(ActionEvent event) {
    }

    public void diendan(ActionEvent e) {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("diendan.fxml"));
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
