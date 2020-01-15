
public class Utility {
	static String infix;
	static String postfix;
	static Stack stack;
	static int stackSize = 100;

	public void initialize() {
		infix = new String();
		postfix = new String();
		stack = new Stack(stackSize);
	}

	public static String convertToPostfix(String infix) {
		String postfix = "";
		char[] infixCharTable = infix.toCharArray();
		if (infixCharTable == null || infixCharTable.length == 0) {
			return postfix;
		}

		Stack stack = new Stack(100);
		for (char charElement : infixCharTable) {
			if (isNumber(charElement)) {
				postfix += charElement;
			} else if (charElement == '(') {
				if (!postfix.isEmpty() && isNumber(postfix.charAt(postfix.length() - 1))) {
					stack.push('*');
					postfix += " ";
				}
				stack.push(charElement);
			} else if (charElement == ')') {
				while (stack.peek() != '(') {
					postfix += " " + stack.pop();
				}
				stack.pop();
			} else if ((postfix.isEmpty() && charElement == '-')
					|| (!postfix.isEmpty() && charElement == '-' && getPriority(stack.peek()) < 4)) {
				postfix += '-';
			} else {
				while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(charElement)) {
					postfix += " " + stack.pop();
				}
				stack.push(charElement);
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

}
