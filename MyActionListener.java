import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class MyActionListener implements ActionListener{
	private JTextField textField;
	private String currentInput;
	private double firstNumber;
	private double secondNumber;
	private char operator;

	public MyActionListener(JTextField textField) {
		this.textField = textField;
		currentInput = "";
		firstNumber = 0.0;
		secondNumber = 0.0;
	}

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
			currentInput += buttonText;//just concatenate every button apart from the operator buttons the user clicks
			textField.setText(currentInput);
		}
	}

	private void clear() {
		currentInput = "";
		firstNumber = 0.0;
		secondNumber = 0.0;
		textField.setText("");
	}

	private void toggleSign() {
		double value = Double.parseDouble(currentInput);
		value *= -1;
		currentInput = Double.toString(value);
		textField.setText(currentInput);

	}

	private void calculatePercentage() {
		double value = Double.parseDouble(currentInput);
		value /= 100;
		currentInput = Double.toString(value);
		textField.setText(currentInput);
	}

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
