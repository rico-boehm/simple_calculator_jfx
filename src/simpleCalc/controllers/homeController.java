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
    private String values = "0123456789";

    public void onClickEvent(MouseEvent mouseEvent) {

        if (output.getText().equals("0")){
            if (values.contains(((Button)mouseEvent.getSource()).getText())){
                output.setText(((Button)mouseEvent.getSource()).getText());
                first = Integer.parseInt(((Button)mouseEvent.getSource()).getText());
            }
            else {

            }
        }
        else {
            output.setText(output.getText() + ((Button)mouseEvent.getSource()).getText());
            if (values.contains(((Button)mouseEvent.getSource()).getText()) ) {
                second = Integer.parseInt(((Button)mouseEvent.getSource()).getText());
            }
            else if (((Button)mouseEvent.getSource()).getText().equals("=")){
                calculate();
            }
            else if (((Button)mouseEvent.getSource()).getText().equals("CE")) {
                output.setText("0");
            }
            else {
                operator = ((Button)mouseEvent.getSource()).getText();
            }
        }

    }
    public void calculate(){
        int result;
        if (operator.equals("*")){
            output.setText(Integer.toString(first*second));
        }
        else if (operator.equals("/")){
            output.setText(Integer.toString(first/second));
        }
        else if (operator.equals("-")) {
            output.setText(Integer.toString(first-second));
        }
        else {
            output.setText(Integer.toString(first+second));
        }
    }
}
