/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 1
 *Instructor: Farnaz Eivazi
 *Summary of Description: This is a program that checks if a password meets a certain requirements and it throws exceptions 
 *if it doesn't 
 *Due Date: 2/10/20
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 */
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	/**
	 * A default constructor
	 */
	private PasswordCheckerUtility() {

	}

	/**
	 * This method throws an exception if the two password don't match.
	 * @param password the password that needs to get checked. 
	 * @param passwordConfirm the second password that has to match the first password.
	 * @throws UnmatchedException an exception that's thrown if the password don't match.
	 */
	public static void comparePasswords(String password,String passwordConfirm)throws UnmatchedException {
		if (!(password.equals(passwordConfirm))) {
			throw new UnmatchedException("Passwords do not match");
		}


	}
	/**
	 * This method checks if the two passwords match.
	 * @param password the password that needs to get checked. 
	 * @param passwordConfirm the second password that has to match the first password.
	 * @return true if password match or false if password don't match.
	 */
	public static boolean comparePasswordsWithReturn(String password,String passwordConfirm) {
		boolean bool;
		if (password.equals(passwordConfirm)) {
			bool= true;
		}
		else {
			bool= false;
		}
		return bool;
	}
	/**
	 * This method checks if the password has between six and nine characters.
	 * @param password the password that needs to be checked. 
	 * @return return true if the password has between six and nine characters, false otherwise.
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		boolean bool;
		if (password.length()>=6 && password.length()<=9) {
			bool= true;
		}
		else {
			bool= false;
		}
		return bool;
	}
	/**
	 * This method checks if the password has at least one digit
	 * @param password the password that needs to be checked 
	 * @return return true if the password has at least one digit
	 * @throws NoDigitException the exception to be thrown if the password doesn't have at least one digit
	 */
	public static boolean hasDigit(String password) throws NoDigitException{
		int count=0;
		for (int i=0;i<password.length();i++) {
			if ((Character.isDigit(password.charAt(i)))){
				count++;

			}
		}
		if(count==0) {
			throw new NoDigitException("The password must contain at least one digit");
		}
		else
			return true;

	}
	/**
	 * This method checks if the password has at least one lower case letter
	 * @param password the password to be checked
	 * @return return true if the password consists at least one lower case letter
	 * @throws NoLowerAlphaException the exception to be thrown if the password doesn't have a lower case letter
	 */
	public static boolean hasLowerAlpha(String password)throws NoLowerAlphaException{
		int count=0;
		for (int i=0;i<password.length();i++) {
			if(Character.isLowerCase(password.charAt(i))) {
				count++;
			}
		}
		if (count==0) {
			throw new NoLowerAlphaException("The password must contain at least one lower case alphabetic character");
		}
		return true;

	}
	/**
	 * This method checks if the password has at least one upper case letter 
	 * @param password the password to be checked
	 * @return return true if the password has at least one upper case letter
	 * @throws NoUpperAlphaException the exception to be thrown if the password doesn't have at least one upper case letter
	 */ 
	public static boolean hasUpperAlpha(String password)throws NoUpperAlphaException{
		int count=0;
		for (int i=0;i<password.length();i++) {
			if(Character.isUpperCase(password.charAt(i))) {
				count++;
			}
		}
		if (count==0) {
			throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
		}
		return true;
	}
	/**
	 * This method checks if the password has six or more characters
	 * @param password the password to be checked
	 * @return returns true if the password has six or more characters, otherwise false
	 * @throws LengthException an exception that's thrown if the password is less than six characters
	 */
	public static boolean isValidLength(String password)throws LengthException{
		boolean bool=false;
		if (password.length()>=6) {
			bool=true;
		}
		else {
			throw new LengthException("The password must be at least 6 characters long");
		}

		return bool;
	}
	/**
	 * This method checks if the password is weak
	 * @param password the password to be checked
	 * @return returns false if the password doesn't have 6 to 9 characters
	 * @throws WeakPasswordException the exception to be thrown if the password is between six to nine characters
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException{

		if (password.length()>=6 && password.length()<=9) {
			throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters");
		}
		return false;
	}
	/**
	 * This method checks if the password has a special character
	 * @param password the password to be checked 
	 * @return returns true if the password has a special character
	 * @throws NoSpecialCharacterException the exception to be thrown if the password doesn't have special characters
	 */
	public static boolean hasSpecialChar(String password)throws NoSpecialCharacterException{

		Pattern pattern = Pattern.compile("\\W");
		Matcher matcher = pattern.matcher(password);
		if (matcher.find()) {
			return true;
		}
		else {
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}



	}
	/**
	 * This method checks if the password has the same character in sequence.
	 * @param password the password to be checked.
	 * @return returns false if the password has the same character in sequence, false otherwise.
	 * @throws InvalidSequenceException the exception to be thrown if the password has the same character in sequence
	 */
	public static boolean hasSameCharInSequence(String password)throws InvalidSequenceException{
		boolean bool=false;
		for (int i=0;i<password.length()-2;i++) {
			if (password.charAt(i)==password.charAt(i+1)&&password.charAt(i+1)==password.charAt(i+2)) {
				throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
			}
			else {
				bool=true;
			}
		}
		return bool;

	}
	/**
	 * This method checks if the password meets all the criteria 
	 * @param password the pass word to be checked
	 * @return return true if the password meets all the criteria, false otherwise
	 * @throws LengthException is thrown if password is not long enough
	 * @throws NoUpperAlphaException is thrown if password doesn't have at least one upper case letter
	 * @throws NoLowerAlphaException is thrown if password doesn't have at least one lower case letter
	 * @throws NoDigitException is thrown if password doesn't have at least one digit
	 * @throws NoSpecialCharacterException is thrown if password doesn't have at least one special character
	 * @throws InvalidSequenceException is thrown if password has the same characters in sequence
	 */
	public static boolean isValidPassword(String password)throws LengthException,
	NoUpperAlphaException,
	NoLowerAlphaException,
	NoDigitException,
	NoSpecialCharacterException,
	InvalidSequenceException{
		if(isValidLength(password)&&hasUpperAlpha(password)&&hasLowerAlpha(password)&&hasDigit(password)&&hasSpecialChar(password)&&hasSameCharInSequence(password)) {
			return true;
		}


		return false;

	}
	/**
	 * This method checks passwords on file and prints out the invalid passwords with error message
	 * @param passwords the passwords to be checked
	 * @return return array of invalid passwords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalid = new ArrayList<>();
		String str;
		for (int i=0;i<passwords.size();i++) {
			try {
				isValidPassword(passwords.get(i));
			}
			catch(LengthException e){
				str=passwords.get(i)+ " -> The password must be at least 6 characters long";
				invalid.add(str);
			}
			catch(NoUpperAlphaException e) {
				str=passwords.get(i)+ " -> The password must contain at least one uppercase alphabetic character";
				invalid.add(str);
			}
			catch(NoLowerAlphaException e) {
				str=passwords.get(i)+ " -> The password must contain at least one lower case alphabetic character";
				invalid.add(str);
			}
			catch(NoDigitException e) {
				str=passwords.get(i)+ " -> The password must contain at least one digit";
				invalid.add(str);
			}
			catch(NoSpecialCharacterException e) {
				str=passwords.get(i)+ " -> The password must contain at least one special character";
				invalid.add(str);
			}
			catch(InvalidSequenceException e) {
				str=passwords.get(i)+ " -> The password cannot contain more than two of the same character in sequence.";
				invalid.add(str);				
			}

		}

		return invalid;


	}

}
