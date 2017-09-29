package ru.feeleen.calculator.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import ru.feeleen.calculator.bll.CreditFormulas;

import java.awt.*;

public class ControllerCalculatorView {
    @FXML
    public Label monthlyRepaymant;
    @FXML

    public Label overpayment;

    @FXML
    public Label totalDebt;

    @FXML
    private TextField textAmount;

    @FXML
    private TextField textMonths;

    @FXML
    private TextField textRate;

    @FXML
    private Button buttonCalc;

    @FXML
    private void initialize(){
        monthlyRepaymant.setText("");
        overpayment.setText("");
        totalDebt.setText("");
        buttonCalc.setDisable(true);
    }


    @FXML
    private void checkNumberText(){
        if(textAmount.getText().length()==0 || textMonths.getText().length()==0 || (textRate.getText().length())==0) {
            buttonCalc.setDisable(true);
        } else {
            try {
                Double.parseDouble(textMonths.getText());
                textMonths.setStyle("-fx-text-inner-color: black;");
                buttonCalc.setDisable(false);
            } catch (NumberFormatException e) {
                buttonCalc.setDisable(true);
                textMonths.setStyle("-fx-text-inner-color: red;");
            }

            try {
                Double.parseDouble(textRate.getText());
                textRate.setStyle("-fx-text-inner-color: black;");
                buttonCalc.setDisable(false);
            } catch (NumberFormatException e) {
                buttonCalc.setDisable(true);
                textRate.setStyle("-fx-text-inner-color: red;");
            }

            try {
                Double.parseDouble(textAmount.getText());
                textAmount.setStyle("-fx-text-inner-color: black;");
                buttonCalc.setDisable(false);
            } catch (NumberFormatException e) {
                buttonCalc.setDisable(true);
                textAmount.setStyle("-fx-text-inner-color: red;");
            }
        }
    }


    @FXML
    private void calculateCredit(ActionEvent actionEvent) {
        double amout = Double.parseDouble(textAmount.getText());
        int months = Integer.parseInt(textMonths.getText());
        double mothlyPayment = CreditFormulas.annuityPayment(amout, months, Double.parseDouble(textRate.getText()));
        monthlyRepaymant.setText(Double.toString(mothlyPayment));
        overpayment.setText(Double.toString(mothlyPayment*months-amout));
        totalDebt.setText(Double.toString(mothlyPayment*months));

    }
}
