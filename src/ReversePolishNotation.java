import java.util.Scanner;

public class ReversePolishNotation {

	public static void main(String[] args) {
		Utility utility = new Utility();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter data: ");
		Utility.infix = scan.nextLine();
		System.out.println("Data: " + Utility.infix);
		if (utility.isInputDataCorrect(Utility.infix)) {
			System.out.println("Input data within alphabet range");
			Utility.postfix = Utility.convertToPostfix(Utility.infix);
			System.out.println("ONP: " + Utility.postfix);
		} else {
			System.out.println("Data incorrect!");
		}

	}

}
