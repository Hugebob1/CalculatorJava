package com.example.javafx1;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField textField;
    @FXML
    private TextField textField1;
    private double f = 0;
    private String num = "";
    private String operator = "";
    public void startingpos() {
        textField.setText("0");
    }
    // Metody do wpisywania cyfr
    public void addDigit(String digit) {
        num += digit;
        textField.setText(num);
    }

    public void b1(javafx.event.ActionEvent actionEvent) { addDigit("1"); }
    public void b2(javafx.event.ActionEvent actionEvent) { addDigit("2"); }
    public void b3(javafx.event.ActionEvent actionEvent) { addDigit("3"); }
    public void b4(javafx.event.ActionEvent actionEvent) { addDigit("4"); }
    public void b5(javafx.event.ActionEvent actionEvent) { addDigit("5"); }
    public void b6(javafx.event.ActionEvent actionEvent) { addDigit("6"); }
    public void b7(javafx.event.ActionEvent actionEvent) { addDigit("7"); }
    public void b8(javafx.event.ActionEvent actionEvent) { addDigit("8"); }
    public void b9(javafx.event.ActionEvent actionEvent) { addDigit("9"); }
    public void b0(javafx.event.ActionEvent actionEvent) { addDigit("0"); }

    // Metoda do dodawania kropki (.)
    public void bcomma(javafx.event.ActionEvent actionEvent) {
        if (!num.contains(".")) {
            num += ".";
            textField.setText(num);
        }
    }

    // Metoda do obsługi operatorów (+, -, *, /)
    public void setOperator(String op) {
        if (!num.isEmpty()) {
            if (!operator.isEmpty()) {
                calculate(); // Jeśli użytkownik już wybrał operator i wpisuje kolejny, wykonujemy obliczenie
            } else {
                f = Double.parseDouble(num);
            }
            operator = op;
            textField1.setText(num + " " + operator);
            num = "";
        }
    }

    public void bplus(javafx.event.ActionEvent actionEvent) { setOperator("+"); }
    public void bminus(javafx.event.ActionEvent actionEvent) { setOperator("-"); }
    public void bmultiply(javafx.event.ActionEvent actionEvent) { setOperator("*"); }
    public void bdivide(javafx.event.ActionEvent actionEvent) { setOperator("/"); }

    // Obliczanie wyniku po naciśnięciu "="
    public void bmod(javafx.event.ActionEvent actionEvent) {
        if (!num.isEmpty() && !operator.isEmpty()) {
            calculate();
            operator = ""; // Resetowanie operatora
        }
    }

    // Metoda wykonująca obliczenia
    private void calculate() {
        double y = Double.parseDouble(num);
        switch (operator) {
            case "+": f += y; break;
            case "-": f -= y; break;
            case "*": f *= y; break;
            case "/":
                if (y != 0) {
                    f /= y;
                } else {
                    textField.setText("Błąd: dzielenie przez 0");
                    return;
                }
                break;
        }

        // Aktualizacja pól tekstowych
        textField1.setText("");
        textField.setText(String.valueOf(f));
        num = String.valueOf(f); // Aby można było kontynuować działania
    }

    // Resetowanie kalkulatora (opcjonalnie)
    public void bclear(javafx.event.ActionEvent actionEvent) {
        f = 0;
        num = "";
        operator = "";
        textField.setText("");
        textField1.setText("");
    }
}
