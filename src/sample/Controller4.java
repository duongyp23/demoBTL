package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static sample.Controller5.*;

public class Controller4 {
    public Float _BMI ;
    @FXML
    private TextField hight;
    @FXML
    private TextField weight;
    public void confirm(ActionEvent e) {

        if( hight.getText()!= null && String.valueOf(weight)!= null ) {
            Float _hight = Float.parseFloat(hight.getText());
            Float _weight = Float.parseFloat(weight.getText());
            _BMI = _weight/(_hight/50);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Chỉ số BMI của bạn là: "+ String.valueOf(_BMI));
            if(_BMI<18.5) {
                alert.setContentText("Chỉ số BMI cho thấy bạn hơi GẦY");
            } else if(_BMI<25) {
                alert.setContentText("Chỉ số BMI của bạn bình thường");
            } else if(_BMI<30) {
                alert.setContentText("Chỉ số BMI cho thấy bạn đang tăng cân");
            } else if(_BMI<35) {
                alert.setContentText("Chỉ số BMI cho thấy bạn đang béo phì độ 1");
            } else if(_BMI<40) {
                alert.setContentText("Chỉ số BMI cho thấy bạn đang béo phì độ 2");
            } else {
                alert.setContentText("Chỉ số BMI cho thấy bạn đang béo phì độ 3");
            }

            alert.show();

            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
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
}
