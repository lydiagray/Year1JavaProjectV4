package TextAnalysis;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ComponentIntegrationTest {
	
	public static final String shortString = "99037666 This! What is this? Why, this is a (short) string.";

	@Test
	public void textAnalysisConstructor_ShouldReturnCorrectAttributes() {
		//arrange
		String inputExpected = "99037666 THIS! WHAT IS THIS? WHY, THIS IS A (SHORT) STRING.";
		char[] inputAsArrayExpected = {'9','9','0','3','7','6','6','6',' ','T','H','I','S','!',' ','W','H','A','T',' ','I','S',' ','T','H','I','S','?',' ','W','H','Y',',',' ','T','H','I','S',' ','I','S',' ','A',' ','(','S','H','O','R','T',')',' ','S','T','R','I','N','G','.'};
		ArrayList<String> inputAsStringArrayExpected = new ArrayList<String>();
		String[] expected = new String[] {"THIS","WHAT","IS","THIS","WHY","THIS","IS","A","SHORT","STRING"};
		for (String string : expected) {
			inputAsStringArrayExpected.add(string);
		}
		int numberOfSpacesExpected = 10;
		int numberOfWordsExpected = 11;
		int charIncSpacesExpected = 59;
		int charExcSpacesExpected = 49;
		
		TextAnalysis testCase = new TextAnalysis(shortString);
		//act
		String inputResult = testCase.getInput();
		char[] inputAsArrayResult = testCase.getInputAsArray();
		ArrayList<String> inputAsStringArrayListResult = testCase.getInputAsStringArrayList();
		int numberOfSpacesResult = testCase.getNumberOfSpaces();
		int numberOfWordsResult = testCase.getNumberOfWords();
		int charIncSpacesResult = testCase.getCharsIncludingSpaces();
		int charExcSpacesResult = testCase.getCharsExcludingSpaces();
		//assert
		Assert.assertEquals(inputExpected, inputResult);
		Assert.assertEquals(true, HelperMethods.compareTwoArrays(inputAsArrayExpected, inputAsArrayResult));
		Assert.assertEquals(true, HelperMethods.compareTwoStringArrayLists(inputAsStringArrayExpected, inputAsStringArrayListResult));
		Assert.assertEquals(numberOfSpacesExpected, numberOfSpacesResult);
		Assert.assertEquals(numberOfWordsExpected, numberOfWordsResult);
		Assert.assertEquals(charIncSpacesExpected, charIncSpacesResult);
		Assert.assertEquals(charExcSpacesExpected, charExcSpacesResult);
	}

}
