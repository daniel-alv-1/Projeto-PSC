package com.example.projetopsc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class HelloApplication extends Application {

    Stage janela;


    @Override
    public void start(Stage stage) throws Exception {

        janela = stage;

        Parent tela = FXMLLoader.load(getClass().getResource("telas/Login.fxml"));

        Scene scene = new Scene(tela);

        janela.setScene(scene);
        janela.show();







    }
}
