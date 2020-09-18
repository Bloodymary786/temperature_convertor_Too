package com.anshuman;

import com.sun.javaws.exceptions.InvalidArgumentException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Label welcomeLabel;

    @FXML
    public Button convertButton;

    @FXML
    public TextField valueText;

    @FXML
    public ChoiceBox<String> choiceBox;

    boolean C_TO_F = true;
    private static final String C_To_F = "Celcius to Fahrenheit";
    private static final String F_to_C = "Fahrenheit to Celcius";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().add(C_To_F);
        choiceBox.getItems().add(F_to_C);
        choiceBox.setValue(C_To_F);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(C_To_F)) {
                C_TO_F=true;
            }else {
                C_TO_F=false;
            }

        });


        convertButton.setOnAction(event -> {
            String input=valueText.getText();
            float value=0.0f;

            try{
                value=Float.parseFloat(input);
            }
            catch (NumberFormatException e){
                userError();
                return;
            }
            float newTemp;
            if(C_TO_F){
                newTemp=(value*9/5)+32;
            }else {
                newTemp=(value-32)*5/9;
            }
            display(newTemp);

        });

    }

    private void userError() {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("INVALID INPUT");
        alert.setHeaderText("Wrong Value Entered");
        alert.setContentText("Please enter the Valid Input");
        alert.show();
    }

    private void display(float newTemp) {
        String unit=C_TO_F?"F":"C";
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("RESPONSE");
        alert.setHeaderText("Final Value");
        alert.setContentText("The final Temprature is :: "+newTemp+" "+unit);
        alert.show();
    }
}
