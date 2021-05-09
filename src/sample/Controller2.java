package sample;

import javafx.collections.transformation.TransformationList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

public class Controller2 {
    @FXML
    private TextField name;
    @FXML
    private TextField phone;
    @FXML
    private TextField account;
    @FXML
    private TextField email;
    @FXML
    private TextField link;
    @FXML
    private DatePicker birthday;
    @FXML
    private CheckBox man;
    @FXML
    private CheckBox woman;
    @FXML
    private CheckBox user1;
    @FXML
    private CheckBox user2;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password2;



    public void Ok(ActionEvent e) throws IOException {
        if(name.getText()!=null && phone.getText()!=null && account.getText()!=null && email.getText()!=null && password.getText()!=null && password2.getText()!=null && birthday.getValue()!=null) {


            boolean accept = true;

            for (int i = 0; i < ManageAccount.manageAccount.size(); i++) {
                if (account.getText().equals(ManageAccount.manageAccount.get(i).getAccount())) {
                    accept = false;
                }
            }
            if (accept) {
                if (user1.isSelected() && !user2.isSelected()) {
                    if (password.getText().equals(password2.getText())) {
                        FileWriter writer = new FileWriter("C:\\Users\\ADMIN\\Downloads\\CNPM\\BTLDEMO\\src\\sample\\Taikhoan.txt", true);
                        BufferedWriter buffer = new BufferedWriter(writer);

                        String s = "1\t" + account.getText() + "\t" + password.getText() + "\t" + name.getText() + "\t" +birthday.getValue() + "\t" + phone.getText() + "\t" + email.getText() ;
                        if (man.isSelected() && !woman.isSelected()) {
                            buffer.write(s + "\t" + "man" + "\n");
                            buffer.close();
                            Account A = new Account(account.getText(), password.getText());
                            ManageAccount.manageAccount.add(A);
                            Finish(e);
                        } else if (woman.isSelected() && !man.isSelected()) {
                            buffer.write(s + "\t" + "woman" + "\n");
                            buffer.close();
                            Account A = new Account(account.getText(), password.getText());
                            ManageAccount.manageAccount.add(A);
                            Finish(e);
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("ERROR");
                            alert.setHeaderText("Xin chọn lại giới tính");
                            alert.show();


                        }
                    } else {

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setHeaderText("Mật khẩu không chính xác");
                        alert.show();


                    }
                } else if (user2.isSelected() && !user1.isSelected()) {
                    if (password.getText().equals(password2.getText())) {
                        FileWriter writer = new FileWriter("C:\\Users\\ADMIN\\Downloads\\CNPM\\BTLDEMO\\src\\sample\\Taikhoan.txt", true);

                        BufferedWriter buffer = new BufferedWriter(writer);

                        FileWriter writer1 = new FileWriter("C:\\Users\\ADMIN\\Downloads\\CNPM\\BTLDEMO\\src\\sample\\check.txt", true);
                        BufferedWriter buffer1 = new BufferedWriter(writer1);
                        if (link.getText() != null) {
                            buffer1.write(account.getText() + "\t" + link.getText() + "\n");
                            buffer1.close();
                        }
                        String s = "1\t" + account.getText() + "\t" + password.getText() + "\t" + name.getText() + "\t" +birthday.getValue() + "\t" + phone.getText() + "\t" + email.getText() ;
                        if (man.isSelected() && !woman.isSelected()) {
                            buffer.write(s + "\t" + "man" + "\n");
                            buffer.close();
                            Account A = new Account(account.getText(), password.getText());
                            ManageAccount.manageAccount.add(A);
                            Finish(e);
                        } else if (woman.isSelected() && !man.isSelected()) {
                            buffer.write(s + "\t" + "woman" + "\n");
                            buffer.close();
                            Account A = new Account(account.getText(), password.getText());
                            ManageAccount.manageAccount.add(A);
                            Finish(e);
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("ERROR");
                            alert.setHeaderText("Xin chọn lại giới tính");
                            alert.show();


                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setHeaderText("Mật khẩu không chính xác");
                        alert.show();


                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Xin chọn lại Loại tài khoản");
                    alert.show();


                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Tài khoản đã được sử dụng vui lòng tạo lại");
                alert.show();

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Vui lòng điền đầy đủ thông tin");
            alert.show();
        }
    }
    public void Finish(ActionEvent e) {


        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("manhinh.fxml"));
        Parent manhinh = null;
        try {
            manhinh = loader.load();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Scene scene = new Scene(manhinh);

        stage.setScene(scene);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("XÁC NHẬN");
        alert.setHeaderText("Tài khoản đã được tạo");
        alert.show();
    }
}
