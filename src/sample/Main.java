package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\ADMIN\\Downloads\\CNPM\\BTLDEMO\\src\\sample\\Taikhoan.txt"))) {
            String line = bufferedReader.readLine();
            while (line != null) {

                int n=0;
                String[] cutline = new String[4];
                for (String w : line.split("\\t", 4)) {
                    cutline[n]=w;
                    n++;
                }
                Account A = new Account(cutline[1],cutline[2]);
                ManageAccount.manageAccount.add(A);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Parent root = FXMLLoader.load(getClass().getResource("manhinh.fxml"));
            primaryStage.setTitle("LỐI SỐNG LÀNH MẠNH");
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args){
        launch(args);
    }
}