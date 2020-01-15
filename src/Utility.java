
public class Utility {
	static String infix;
	static String postfix;

	public void initialize() {
		infix = new String();
		postfix = new String();
	}

	public static String convertToPostfix(String infix) {
		String postfix = "";
		char[] infixCharTable = infix.toCharArray();
		if (infixCharTable == null || infixCharTable.length == 0) {
			return postfix;
		}

		Stack stack = new Stack(100);
		for (int i = 0; i < infixCharTable.length; i++) {
			if (isNumber(infixCharTable[i])) {
				postfix += infixCharTable[i];
			} else if (infixCharTable[i] == '(') {
				if (!postfix.isEmpty() && isNumber(postfix.charAt(postfix.length() - 1))) {
					stack.push('*');
					postfix += " ";
				}
				stack.push(infixCharTable[i]);
			} else if (infixCharTable[i] == ')') {
				while (stack.peek() != '(') {
					postfix += " " + stack.pop();
				}
				stack.pop();
			} else if ((postfix.isEmpty() && infixCharTable[i] == '-')
					|| (!postfix.isEmpty() && infixCharTable[i] == '-' && !stack.isEmpty()
							&& getPriority(stack.peek()) < 4) && !isNumber(infixCharTable[i - 1])) {
				postfix += '-';
			} else {
				while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(infixCharTable[i])) {
					postfix += " " + stack.pop();
				}
				stack.push(infixCharTable[i]);
				postfix += " ";
			}
		}

		while (!stack.isEmpty()) {
			postfix += " " + stack.pop();
		}
		return postfix;
	}

	public static boolean isNumber(char charElement) {
		if (charElement >= '0' && charElement <= '9') {
			return true;
		}
		return false;
	}

	public static int getPriority(char charElement) {
		if (charElement == '(') {
			return 0;
		} else if (charElement == '+' || charElement == '-') {
			return 1;
		} else if (charElement == '/' || charElement == '*') {
			return 2;
		} else if (charElement == '^') {
			return 3;
		} else {
			return 4;
		}
	}

	public static boolean isInputDataCorrect(String infix) {
		char[] infixCharTable = infix.toCharArray();
		if (infixCharTable == null || infixCharTable.length == 0) {
			return false;
		}
		for (char charElement : infixCharTable) {
			if (!isNumber(charElement) && getPriority(charElement) >= 4 && charElement != ')') {
				return false;
			}
		}
		return true;
	}
}
