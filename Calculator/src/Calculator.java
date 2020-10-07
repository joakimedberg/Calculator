import javax.swing.JOptionPane;

/**
 * Representing a simple calculator. Binary operations. No negative values allowed. Can
 * operate addition, subtraction, multiplication and division.
 * Part 2 of assignment 1. Javautveckling @ Nackademin -20
 * 
 * @author Joakim Edberg
 *
 */
class Calculator {
	/**
	 * Stores the first operand.
	 */
	private double operand1;

	/**
	 * Stores the second operand.
	 */
	private double operand2;

	/**
	 * Stores the result.
	 */
	private String result;

	/**
	 * Stores the operator.
	 */
	private char operator;
	
	public static void main(String[] args) {
		initCalculator();
		runTestCode();

	}
	
	static void runTestCode() {

		System.out.println("Empty input. " + new Calculator("").getResult());

		System.out.println("\nMissing approved operator.");
		System.out.println(new Calculator("2%2").getResult());
		System.out.println(new Calculator("2 2").getResult());

		System.out.println("\nIf is not a binary operator. ");
		System.out.println(new Calculator("1+1+1").getResult());
		System.out.println(new Calculator("2/").getResult());
		System.out.println(new Calculator("2+1*2").getResult());
		System.out.println(new Calculator("2+").getResult());
		System.out.println(new Calculator("+2").getResult());
		System.out.println(new Calculator("-22").getResult());
		System.out.println(new Calculator("*2").getResult());

		System.out.println("\nIf it contains other illegal characters. ");
		System.out.println(new Calculator("2+2a").getResult());
		System.out.println(new Calculator("2&+21").getResult());
		System.out.println(new Calculator("2 +2").getResult());
		System.out.println(new Calculator("2+2i").getResult());

		System.out.println("\nIf it's divided by 0. ");
		System.out.println(new Calculator("2/0").getResult());

		System.out.println("OBS! negative values gives error!");
		System.out.println(new Calculator("-1+10").getResult());

		System.out.println("\nCorrect input. ");
		System.out.println(new Calculator("1+1").getResult());
		System.out.println(new Calculator("12+10").getResult());
		System.out.println(new Calculator("25*25").getResult());
		System.out.println(new Calculator("22/22").getResult());
		System.out.println(new Calculator("20.2/2").getResult());
		System.out.println(new Calculator("4.5+4.5").getResult());
		System.out.println(new Calculator("500/2").getResult());

	}
	
	/**
	 * Initializes the calculator and graphic user interface.
	 */
	static void initCalculator() {
		String input = JOptionPane.showInputDialog("Kalkylera: ");
		JOptionPane.showMessageDialog(null, new Calculator(input).getResult());
	}
	/**
	 * Constructs Calculator with the mathematical expression.
	 * 
	 * @param input the expression.
	 */
	Calculator(String expression) {
		performCalculation(expression);
	}
	/**
	 * Checks if the mathematical expression is valid and prints possible errors.
	 * 
	 * @param expression the mathematical expression.
	 * @return true if the expression is valid, otherwise false.
	 */
	private boolean isExpressionValid(String expression) {

		// Check if expression is empty.
		if (expression.isEmpty()) {
			System.out.println("Uttrycket får inte vara tomt.");
			return false;
		}

		// Loops through the expression String to validate and extract operator and operands.
		for (int i = 0; i < expression.length(); i++) {
			
			// Check if the operator is either +,-,*,/
			if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'
					|| expression.charAt(i) == '/') {
				operator = expression.charAt(i);
				
				// Check if the operands are valid and extracts them.
				try {
					operand1 = Double.valueOf(expression.substring(0, i));
					operand2 = Double.valueOf(expression.substring(i + 1, expression.length()));
					
					// Check if the expression is trying to divide by zero.
					if (operand2 == 0 && operator == '/') {
						System.out.println("Division med noll är ej definierat.");
						return false;
					}
					return true;
				// Throws exception if it's something else than a binary operator with +-*/
				} catch (Exception e) {
					System.out.println("Endast binär operator med operatorerna +,-,*,/ tillåten.");
					return false;
				}
			}
		}
		
		System.out.println("Uttrycket måste innehålla en av följande operatorer: +,-,*,/");
		return false;
	}

	/**
	 * Performs the calculation of the expression.
	 * 
	 * @param expression the mathematical expression.
	 */
	private void performCalculation(String expression) {
		
		// Performs the calculations if the expression is valid. Otherwise sets result to ERROR.
		if (isExpressionValid(expression)) {
			if (operator == '+') {
				result = String.valueOf(operand1 + operand2);
			} else if (operator == '-') {
				result = String.valueOf(operand1 + operand2);
			} else if (operator == '*') {
				result = String.valueOf(operand1 * operand2);
			} else {
				result = String.valueOf(operand1 / operand2);
			}
			return;
		}
		result = "ERROR";

	}

	/**
	 * Retrieves the result of the calculation.
	 * @return the result.
	 */
	String getResult() {
		return result;
	}

}