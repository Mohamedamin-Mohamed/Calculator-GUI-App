import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * Files: MyActionListener.java          
 * Author: Mohamedamin Mohamed          
 * Contact mohamedamin204080@gmail.com  
 * Created 07/18/2023                   
 * Modified: 07/18/2023              
 * Description:This class implements the ActionListener interface to handle button actions
in the calculator application
 */

public class MyActionListener implements ActionListener {
    private JTextField textField;
    private String currentInput;
    private double firstNumber;
    private double secondNumber;
    private char operator;

    /**
     * Constructs a MyActionListener object with the specified text field.
     *
     * @param textField The text field to update with the calculation result.
     */
    public MyActionListener(JTextField textField) {
        this.textField = textField;
        currentInput = "";
        firstNumber = 0.0;
        secondNumber = 0.0;
    }

    /**
     * Handles button actions performed in the calculator application.
     *
     * @param e The action event representing the button action.
     */
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String buttonText = source.getText();

        if (buttonText.equals("AC"))
            clear();
        else if (buttonText.equals("+/-"))
            toggleSign();
        else if (buttonText.equals("%"))
            calculatePercentage();
        else if (buttonText.equals("/") || buttonText.equals("X") || buttonText.equals("-") || buttonText.equals("+")) {
            operator = buttonText.charAt(0);
            firstNumber = Double.parseDouble(currentInput);
            currentInput = "";
        } else if (buttonText.equals("=")) {
            secondNumber = Double.parseDouble(currentInput);
            performOperation();
        } else {
            currentInput += buttonText;
            textField.setText(currentInput);
        }
    }

    /**
     * Clears the current input and resets the calculator state.
     */
    private void clear() {
        currentInput = "";
        firstNumber = 0.0;
        secondNumber = 0.0;
        textField.setText("");
    }

    /**
     * Toggles the sign of the current input value.
     */
    private void toggleSign() {
        double value = Double.parseDouble(currentInput);
        value *= -1;
        currentInput = Double.toString(value);
        textField.setText(currentInput);
    }

    /**
     * Calculates the percentage of the current input value.
     */
    private void calculatePercentage() {
        double value = Double.parseDouble(currentInput);
        value /= 100;
        currentInput = Double.toString(value);
        textField.setText(currentInput);
    }

    /**
     * Performs the arithmetic operation based on the selected operator.
     */
    private void performOperation() {
        double result;
        switch (operator) {
            case '/':
                result = firstNumber / secondNumber;
                break;
            case 'X':
                result = firstNumber * secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '+':
                result = firstNumber + secondNumber;
                break;
            default:
                result = 0.0;
                break;
        }
        currentInput = Double.toString(result);
        textField.setText(currentInput);
        firstNumber = result;
        secondNumber = 0.0;
    }
}
