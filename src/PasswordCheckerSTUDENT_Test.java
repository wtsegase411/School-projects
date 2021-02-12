
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> invalidPass;
	ArrayList<String> validPass;
	@Before
	public void setUp() throws Exception {
		String[] invalidpassw = {"HOWAREU2DO!N", "hEyhowareU2", "howAreyoufeelin5", "Wen!2", "hellohowe2", "Heyhowarewefel2","ifeelgood2", 
				"ifyouknowyouKnow!", "We2!", "Itriedllol!", "notagain!Y", "jailfrHaHa2", 
				};
		invalidPass = new ArrayList<String>();
		invalidPass.addAll(Arrays.asList(invalidpassw));		
		
		String[] validpassw = {"A1@hellohil", "hOwareyou?2", "Givemeyour2#", "IllikeYou2!", "Thisaremypass2!"};
		validPass = new ArrayList<String>();
		validPass.addAll(Arrays.asList(validpassw));	
		
	}

	@After
	public void tearDown() throws Exception {
		invalidPass=null;
		validPass=null;
				
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			PasswordCheckerUtility.isValidLength("wenge");
			assertTrue(false);
		}
		catch(LengthException e){
			assertTrue(true);
		}
		try {
			PasswordCheckerUtility.isValidLength("wengelt");
			assertTrue(true);
		}
		catch(LengthException e){
			assertTrue(false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			PasswordCheckerUtility.hasUpperAlpha("wengela2@");
			assertTrue(false);
		}
		catch(NoUpperAlphaException e){
			assertTrue(true);
		}
		try {
			PasswordCheckerUtility.hasUpperAlpha("Wengela2@");
			assertTrue(true);
		}
		catch(NoUpperAlphaException e){
			assertTrue(false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			PasswordCheckerUtility.hasLowerAlpha("WENGELA2@");
			assertTrue(false);
		}
		catch(NoLowerAlphaException e){
			assertTrue(true);
		}
		try {
			PasswordCheckerUtility.hasLowerAlpha("WENGfELA2@");
			assertTrue(true);
		}
		catch(NoLowerAlphaException e){
			assertTrue(false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			PasswordCheckerUtility.isWeakPassword("Wengel2!");
			assertTrue(false);
		}
		catch(WeakPasswordException e){
			assertTrue(true);
		}
		try {
			PasswordCheckerUtility.isWeakPassword("Wengel2!de3");
			assertTrue(true);
		}
		catch(WeakPasswordException e){
			assertTrue(false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			PasswordCheckerUtility.hasSameCharInSequence("Wengeeel2!");
			assertTrue(false);
		}
		catch(InvalidSequenceException e){
			assertTrue(true);
		}
		try {
			PasswordCheckerUtility.hasSameCharInSequence("Wengeel2!");
			assertTrue(true);
		}
		catch(InvalidSequenceException e){
			assertTrue(false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			PasswordCheckerUtility.hasDigit("Wengel!wwa");
			assertTrue(false);
		}
		catch(NoDigitException e){
			assertTrue(true);
		}
		try {
			PasswordCheckerUtility.hasDigit("Wengel2!wwa");
			assertTrue(true);
		}
		catch(NoDigitException e){
			assertTrue(false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		ArrayList<String> passwords;
		passwords = PasswordCheckerUtility.getInvalidPasswords(validPass);
		assertTrue(passwords.isEmpty());
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> passwords;
		passwords = PasswordCheckerUtility.getInvalidPasswords(invalidPass);
		assertEquals(passwords.size(), 12);
		assertEquals(passwords.get(0), "HOWAREU2DO!N -> The password must contain at least one lower case alphabetic character");
		assertEquals(passwords.get(1), "hEyhowareU2 -> The password must contain at least one special character");
		assertEquals(passwords.get(2), "howAreyoufeelin5 -> The password must contain at least one special character");
		assertEquals(passwords.get(3), "Wen!2 -> The password must be at least 6 characters long");
		assertEquals(passwords.get(4), "hellohowe2 -> The password must contain at least one uppercase alphabetic character"); 
		assertEquals(passwords.get(5), "Heyhowarewefel2 -> The password must contain at least one special character");
		assertEquals(passwords.get(6), "ifeelgood2 -> The password must contain at least one uppercase alphabetic character");
		assertEquals(passwords.get(7), "ifyouknowyouKnow! -> The password must contain at least one digit");
		assertEquals(passwords.get(8), "We2! -> The password must be at least 6 characters long");
		assertEquals(passwords.get(9), "Itriedllol! -> The password must contain at least one digit");
		assertEquals(passwords.get(10), "notagain!Y -> The password must contain at least one digit");
		assertEquals(passwords.get(11), "jailfrHaHa2 -> The password must contain at least one special character");
		
	}
	
}
