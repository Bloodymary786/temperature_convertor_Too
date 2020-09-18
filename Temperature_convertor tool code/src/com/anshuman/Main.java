package com.anshuman;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;


public class Main extends Application {

    public static void main(String...args){

        launch(args);
    }

    public void init(){
        System.out.println("new");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Start");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("layout.fxml"));
        VBox rootNode = loader.load();
        javafx.scene.control.MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("TEMPRATURE CONVERTER TOOL");
        primaryStage.show();
    }
    private MenuBar createMenu(){

        Menu fileMenu=new Menu("File");
        MenuItem quitMenuItem=new MenuItem("Quit");
        quitMenuItem.setOnAction(event ->{
            Platform.exit();
            System.exit(0);
        }
        );

        fileMenu.getItems().addAll(quitMenuItem);

        Menu helpMenu =new Menu("Help");
        MenuItem aboutMenuItem=new MenuItem("About");

        aboutMenuItem.setOnAction(event -> {
            aboutClicked();
        });

        helpMenu.getItems().addAll(aboutMenuItem);

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;

    }

    private static void aboutClicked() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ABOUT THE DEVELOPER");
        alert.setHeaderText("Thank you For your Support");
        alert.setContentText("This app can Successfully convert Temprature on either side regarding to need of user");
        alert.show();
    }
}
