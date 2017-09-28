package ru.feeleen.calculator.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import sun.net.www.protocol.https.Handler;

import java.awt.*;

public class ControllerCalculatorView {
    @FXML private TextField textField;
    @FXML public void checkNumberText(){
        String f = textField.getText();
    }

}
