import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 5
 *Instructor: Farnaz Eivazi
 *Summary of Description:A class used to convert a MorseCode into English 
 *Due Date: 04/28/21
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 */
public class MorseCodeConverter {
	static MorseCodeTree convert=new MorseCodeTree();
	/**
	 * A method that reads a file and convert the MorseCode into English
	 * @param inputFile the file being read
	 * @return covertedStr the converted string
	 * @throws FileNotFoundException an exception to be thrown 
	 */
	public static String convertToEnglish(File inputFile)throws FileNotFoundException {
		try {
		Scanner newFile=new Scanner(inputFile);
		String str;
		String convertedStr="";
		while(newFile.hasNext()) {
			str=newFile.nextLine();
			convertedStr=convertToEnglish(str);			
		}
		
		newFile.close();
		return convertedStr;
		}
		catch(FileNotFoundException e) {
			throw new FileNotFoundException();
		}
		
	}
	/**
	 * A method used to convert a MorseCode into a string 
	 * @param str the code being translated 
	 * @return english the converted string 
	 */
	public static String convertToEnglish(String str) {
	String english="";
	String[] words=str.split("/");
	String[] letters;
	StringBuilder converted=new StringBuilder();
	for (int i=0;i<words.length;i++) {
		words[i]=words[i].trim();
		letters=words[i].split(" ");
		for (int j=0;j<letters.length;j++) {
			converted.append(convert.fetch(letters[j]));
		}
		converted.append(" ");
		
	}
		english=converted.toString();
		english=english.trim();
		return english;
	}
	/**
	 * A method to print the tree in an LNR order
	 * @return tree the tree
	 */

	public static String printTree() {
		ArrayList<String> str=convert.toArrayList();
		StringBuilder printing=new StringBuilder();
		String tree="";
		for (int i=0;i<str.size();i++) {
			printing.append(str.get(i)).append(" ");
		}
		 tree=printing.toString();
		return tree;
	}

}
