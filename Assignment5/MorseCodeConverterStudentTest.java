import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeConverterStudentTest {
	File input;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

@Test
public void testConvertToEnglishString() {	
	String converter1 = MorseCodeConverter.convertToEnglish(".-- . -. --. . .-.. / - ... . --. .- ... . .-.. .- ... ... .. .");
	assertEquals("wengel tsegaselassie",converter1);

	String test2="cant wait for summer";		
	String converter2 = MorseCodeConverter.convertToEnglish("-.-. .- -. - / .-- .- .. - / ..-. --- .-. / ... ..- -- -- . .-.");
	assertEquals("cant wait for summer", converter2);
}

@Test
public void testConvertToEnglishFile() throws FileNotFoundException {
	String test1="wengel tsegaselassie";		
	getFile("MyName.txt");
	String converter1 = MorseCodeConverter.convertToEnglish(input);
	assertEquals(test1,converter1);

	String test2="cant wait for summer";		
	getFile("Summer.txt");
	String converter2 = MorseCodeConverter.convertToEnglish(input);
	assertEquals(test2,converter2);

}

public void getFile(String in) throws FileNotFoundException {		
	JFileChooser chooser = new JFileChooser();
	int status;

	chooser.setDialogTitle("Select Input File - " + in);
	status = chooser.showOpenDialog(null);

	if(status == JFileChooser.APPROVE_OPTION)
	{
		try
		{
			input = chooser.getSelectedFile();
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
}