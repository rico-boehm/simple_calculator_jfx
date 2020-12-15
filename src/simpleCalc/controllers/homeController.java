package simpleCalc.controllers;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class homeController {

    public Text output;
    public Button one;
    private int first = -1;
    private int second = -1;
    private String operator;
    private final String values = "0123456789";
    private final String[] operators = new String[] {"+","-","*","/"};
    private String input;

    public void onClickEvent(MouseEvent mouseEvent) {
        organizeInput(((Button)mouseEvent.getSource()).getText());
    }

    public void calculate(int first, int second, String operator){
        switch (operator) {
            case "*" -> output.setText(Integer.toString(first * second));
            case "/" -> output.setText(Double.toString((double) first / (double) second));
            case "-" -> output.setText(Integer.toString(first - second));
            default -> output.setText(Integer.toString(first + second));
        }
    }

    /*public void organizeInput(String input) {
        if (output.getText().equals("0")){ // if the screen only shows 0
            if (values.contains(input)){ // if number was clicked
                output.setText(input);
                first = Integer.parseInt(input);
            }
        }
        else {
            output.setText(output.getText() + input);
            if (values.contains(input) ) {
                second = Integer.parseInt(input);
            }
            else {
                switch (input){
                    case "=" -> calculate(first, second, operator);
                    case "CE" -> output.setText("0");
                    default -> operator = input;
                }
            }

        }
    }*/

    public void organizeInput(String input) {
        if (input.equals("=")) {
            analyze(this.input);
            input = "";
        }
        else {
            this.input += input;
        }
    }

    public void analyze(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (i>0 && values.contains(Character.toString(input.charAt(i))) && values.contains(Character.toString(input.charAt(i-1)))) {

            }
        }
    }
}
