import java.util.Scanner;

public class ReversePolishNotation {

	public static void main(String[] args) {
		Utility utility = new Utility();
		
		 Scanner scan = new Scanner(System.in);
	     System.out.println("Enter data: ");
	     Utility.infix = scan.nextLine();
	     System.out.println("Data: " + Utility.infix);
	     Utility.postfix = Utility.convertToPostfix(Utility.infix);
	     System.out.println("ONP: " + Utility.postfix);
	     
	}

}
