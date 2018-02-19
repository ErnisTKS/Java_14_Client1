package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main extends Application {
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 8080;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {

        // launch(args);
        try {
            Socket kanalas = new Socket(HOST, PORT);
            ObjectInputStream serverioKanalas = new ObjectInputStream(kanalas.getInputStream());
            System.out.println(serverioKanalas.readUTF());
            ObjectOutputStream isvedimas = new ObjectOutputStream(kanalas.getOutputStream());
            isvedimas.writeUTF("Uzduotis 1");
            isvedimas.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
