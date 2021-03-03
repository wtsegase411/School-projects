/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 2
 *Instructor: Farnaz Eivazi
 *Summary of Description: This is a Notation class that converts Postfix expressions to Infix and vice versa. It also evaluates the postfix expression into doubles
 *Due Date: 3/03/20
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 */
public class Notation {

	/**
	 * A default constructor 
	 */
	private Notation() {

	}
	/**
	 * This method converts postfix expression to infix expresssion
	 * @param postfixExp the postfix expression in string
	 * @return stack.toString() the infix expression in string format 
	 * @throws InvalidNotationFormatException error to be thrown if the postfix expression is invalid
	 */
	public static String convertPostfixToInfix(String postfixExp)throws InvalidNotationFormatException {
		NotationStack<String> stack=new NotationStack<>();

		for(int i=0; i<postfixExp.length();i++) {
			if(Character.isWhitespace(postfixExp.charAt(i))) {
				continue;
			}
			if (Character.isDigit(postfixExp.charAt(i))) {

				stack.push(String.valueOf(postfixExp.charAt(i)));
			}

			else if(postfixExp.charAt(i)=='+'||postfixExp.charAt(i)=='-'||postfixExp.charAt(i)=='/'||postfixExp.charAt(i)=='*') {
				if(stack.size()<2) {
					throw new InvalidNotationFormatException();
				}
				else {
					String str=stack.pop();
					String str1=stack.pop();
					switch(postfixExp.charAt(i)) {
					case '+':
						stack.push("("+str1+"+"+str+")");
						break;
					case'-':
						stack.push("("+str1+"-"+str+")");
						break;
					case'*':
						stack.push("("+str1+"*"+str+")");
						break;
					default :
						stack.push("("+str1+"/"+str+")");
						break;

					}					
				}
			}

		}


		if(stack.size()>1) {
			throw new InvalidNotationFormatException();
		}


		return stack.toString();

	}
	/**
	 * This method converts Infix to Postfix expression
	 * @param infixExpression the infix expression 
	 * @return queue.toString() the postfix expression in a string format
	 * @throws InvalidNotationFormatException thrown if the infix expression is invalid
	 */

	public static String convertInfixToPostfix(String infixExpression) throws InvalidNotationFormatException {
		NotationStack<String> stack=new NotationStack<>();
		NotationQueue<String> queue=new NotationQueue<>();
		for (int i=0;i<infixExpression.length();i++) {
			if(Character.isWhitespace(infixExpression.charAt(i))) {
				continue;
			}
			if (Character.isDigit(infixExpression.charAt(i))) {
				queue.enqueue(String.valueOf(infixExpression.charAt(i)));

			}
			if (infixExpression.charAt(i)=='(') {
				stack.push(String.valueOf(infixExpression.charAt(i)));	
			}
			if (infixExpression.charAt(i)=='+'||infixExpression.charAt(i)=='-'||infixExpression.charAt(i)=='*'||infixExpression.charAt(i)=='/') {
				if ((!stack.isEmpty())){
					if(stack.top().equals(String.valueOf(infixExpression.charAt(i)))||stack.top().equals("+")&&infixExpression.charAt(i)=='-'||stack.top().equals("*")&&infixExpression.charAt(i)=='/'||stack.top().equals("-")&&infixExpression.charAt(i)=='+'||stack.top().equals("/")&&infixExpression.charAt(i)=='*'||stack.top().equals("*")&&infixExpression.charAt(i)=='-'||stack.top().equals("*")&&infixExpression.charAt(i)=='+'||stack.top().equals("/")&&infixExpression.charAt(i)=='-'||stack.top().equals("/")&&infixExpression.charAt(i)=='+'){

						queue.enqueue(stack.pop());
					}					

				}
				stack.push(String.valueOf(infixExpression.charAt(i)));
			}
			if (infixExpression.charAt(i)==')') {
				while(!stack.isEmpty()&&!stack.top().equals("(")){
					queue.enqueue(stack.pop());
				}
				if(!stack.isEmpty()) {
					stack.pop();
				}
				else {
					throw new InvalidNotationFormatException();
				}
			}

		}


		return queue.toString();
	}
	/**
	 * This method evaluates a postfix expression from string to double 
	 * @param postfixExpression the postfix expression in string 
	 * @return n the postfix expression as a double
	 * @throws InvalidNotationFormatException thrown if the postfix expression format is invalid
	 */
	public static double evaluatePostfixExpression(String postfixExpression) throws InvalidNotationFormatException{
		NotationStack<String> stack=new NotationStack<>();


		double n=0;
		for(int i=0;i<postfixExpression.length();i++) {
			if(Character.isWhitespace(postfixExpression.charAt(i))) {
				continue;
			}

			if(Character.isDigit(postfixExpression.charAt(i))||postfixExpression.charAt(i)=='(' ) {
				stack.push(String.valueOf(postfixExpression.charAt(i)));
			}
			if(postfixExpression.charAt(i)=='+'||postfixExpression.charAt(i)=='-'||postfixExpression.charAt(i)=='*'||postfixExpression.charAt(i)=='/') {
				if(stack.size()<2) {
					throw new InvalidNotationFormatException();
				}
				else {
					double s=Double.parseDouble(stack.pop());
					double s1=Double.parseDouble(stack.pop());
					switch(postfixExpression.charAt(i)){
					case '+':
						n=s1+s;
						stack.push(Double.toString(n)) ;								
						break;
					case'-':								
						n=s1-s;
						stack.push(Double.toString(n)) ;
						break;
					case'*':
						n=s1*s;
						stack.push(Double.toString(n)) ;
						break;
					default :
						n=s1/s;
						stack.push(Double.toString(n)) ;
						break;

					}

				}
			}

		}
		if(stack.size()>1) {
			throw new InvalidNotationFormatException();
		}

		return n;


	}

}
