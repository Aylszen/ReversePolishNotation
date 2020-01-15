import java.awt.Color;
import java.util.Scanner;

public class ReversePolishNotation {

	public static void main(String[] args) {
		new Utility();
		new GUI();

	}

	public static void run() {
		Utility.infix = GUI.dataTextField.getText();
		GUI.enteredDataLabel.setText(Utility.infix);
		if (Utility.isInputDataCorrect(Utility.infix)) {
			GUI.dataCorrect.setText("Data correct");
			GUI.dataCorrect.setForeground(Color.GREEN);
			Utility.postfix = Utility.convertToPostfix(Utility.infix);
			GUI.postfixLabel.setText(Utility.postfix);
		} else {
			GUI.dataCorrect.setText("Data incorrect!");
			GUI.dataCorrect.setForeground(Color.RED);
			GUI.postfixLabel.setText("");
		}
	}
}
