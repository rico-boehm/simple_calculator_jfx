package simpleCalc.controllers;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class homeController {

    public Text output;
    private ArrayList<String> input = new ArrayList<>();

    public void onClickEvent(MouseEvent mouseEvent) { //registers which button was clicked and sets up making the string and displaying the input
        String input = ((Button)mouseEvent.getSource()).getText();
        makeStringArray(input);
        displayInput(input);
    }

    private void displayInput(String input) { //displays the input
        if (output.getText().equals("0")){ // if the screen only shows 0
            String values = "0123456789";
            if (values.contains(input)){ // if a number was clicked
                output.setText(input);
            }
        }
        else if (!input.equals("=") && !input.equals("CE")) {
            output.setText(output.getText() + input);
        }
    }

    public void makeStringArray(String input) { //makes a string with the given input
        if (input.equals("=")) {
            calculateOutput(this.input);
            this.input.clear();
        }
        else if (input.equals("CE")) {
            this.input.clear();
            output.setText("0");
        }
        else {
            if (this.input.size() > 0) {
                try {
                    Integer.parseInt(this.input.get(this.input.size() - 1));
                    Integer.parseInt(input);
                    this.input.set(this.input.size() - 1, this.input.get(this.input.size() - 1) + input);
                } catch (NumberFormatException e) {
                    this.input.add(input);
                }
            }
            else {
                this.input.add(input);
            }
        }
    }

    public void calculateOutput(ArrayList<String> input) { //organizes the input into addends and factors
        System.out.println(input);
        if (!input.contains("+") && !input.contains("-") && !input.contains("*") && !input.contains("/")) {
            System.out.println("Yes");
            for (int i = 0; i < input.size(); i++) {
                if (i == 0) {
                    output.setText(input.get(i));
                }
                else {
                    output.setText(output.getText() + input.get(i));
                }
            }
            this.input.clear();
        }
        else {
            double first = -1;
            double second = -1;
            String operator = "";
            int endOfPart = input.size()-1;
            double tmpResult;
            for (int j = 0; j < input.size(); j++) {
                if (first != -1 && second != -1) {
                    endOfPart = j-1;
                    break;
                }
                else {
                    try {
                        if (first == -1) {
                            first = Double.parseDouble(input.get(j));
                        } else {
                            second = Double.parseDouble(input.get(j));
                        }
                    } catch (NumberFormatException e) {
                        operator = input.get(j);
                    }
                }
            }
            tmpResult = calculate(first, second, operator);
            input.subList(0, endOfPart + 1).clear();
            input.add(0, Double.toString(tmpResult));
            calculateOutput(input);
        }

    }

    public double calculate(double first, double second, String operator){ //calculates two given numbers with their operator
        return switch (operator) {
            case "*" -> (first * second);
            case "/" -> (first / second);
            case "-" -> (first - second);
            default -> (first + second);
        };
    }
}
