package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private TextField account;
    @FXML
    private PasswordField password;

    public void Create(ActionEvent e) {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("dangkytaikhoan.fxml"));
        Parent dangkytaikhoan = null;
        try {
            dangkytaikhoan = loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Scene scene = new Scene(dangkytaikhoan);

        stage.setScene(scene);
    }

    public void Login(ActionEvent e) {
        int tmp=0;
        for(int i=0;i<ManageAccount.manageAccount.size();i++){
            if(account.getText().equals(ManageAccount.manageAccount.get(i).getAccount())) {
                if(password.getText().equals(ManageAccount.manageAccount.get(i).getPassword())){

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Đăng nhập thành công");
                    alert.show();

                    Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("manhinhchinh.fxml"));



                    Parent manhinh = null;
                    try {
                        manhinh = loader.load();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    Scene scene;
                    scene = new Scene(manhinh);

                    stage.setScene(scene);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Đăng nhập không thành công.Sai mật khẩu");
                    alert.show();
                }
                tmp=1;
            }
        }
        if(tmp==0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Đăng nhập không thành công.Tài khoản không tồn tại");
            alert.show();
        }
    }
}
