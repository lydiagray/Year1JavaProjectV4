package TextAnalysis;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SystemTest {

	private static final TextAnalysis testCase = new TextAnalysis(UnitTests.shortString);
	
	private static String inputExpected = "99037666 THIS! WHAT IS THIS? WHY, THIS IS A (SHORT) STRING.";
	private static char[] inputAsArrayExpected = {'9','9','0','3','7','6','6','6',' ','T','H','I','S','!',' ','W','H','A','T',' ','I','S',' ','T','H','I','S','?',' ','W','H','Y',',',' ','T','H','I','S',' ','I','S',' ','A',' ','(','S','H','O','R','T',')',' ','S','T','R','I','N','G','.'};
	private static ArrayList<String> inputAsStringArrayExpected = new ArrayList<>(Arrays.asList("THIS","WHAT","IS","THIS","WHY","THIS","IS","A","SHORT","STRING"));	
	private static int numberOfSpacesExpected = 10;
	private static int numberOfWordsExpected = 11;
	private static int charIncSpacesExpected = 59;
	private static int charExcSpacesExpected = 49;
	private static int[] charFreqExpected = {2,0,0,0,0,0,1,6,6,0,0,0,0,1,1,0,0,2,7,6,0,0,2,0,1,0,1,0,0,1,0,0,3,1,0,2,1,1,1,1,0,0,0,0,0,1,1,0,0,0,0};
	private static int highestExpected = 7;
	private static int recExpected = 49;
	private static int unrecExpected = 0;
	private static String[] relFreqExpected = {"0.041","0","0","0","0","0","0.021","0.123","0.123","0","0","0","0","0.021","0.021","0","0","0.041","0.143","0.123","0","0","0.041","0","0.021","0","0.021","0","0","0.021","0","0","0.062","0.021","0","0.041","0.021","0.021","0.021","0.021","0","0","0","0","0","0.021","0.021","0","0","0","0"};	
	private static ArrayList<Integer> wordLengthExpected = new ArrayList<>(Arrays.asList(4,4,2,4,3,4,2,1,5,6));
	private static ArrayList<Integer> lengthFreqExpected = new ArrayList<>(Arrays.asList(1,2,1,4,1,1,0,0));
	private static ArrayList<String> longestExpected = new ArrayList<>(Arrays.asList("STRING"));
	private static String longestDispExpected = "The longest word is STRING at 6 letters long.";

	@Test
	public void getInput_ShouldReturnCorrectAttributes() {
		String inputResult = testCase.getInput();
		Assert.assertEquals(inputExpected, inputResult);
	}
	
	@Test
	public void getInputAsArray_ShouldReturnCorrectAttributes() {
		char[] inputAsArrayResult = testCase.getInputAsArray();
		Assert.assertEquals(true, HelperMethods.compareTwoArrays(inputAsArrayExpected, inputAsArrayResult));
	}
	
	@Test
	public void getInputAsStringArrayList_ShouldReturnCorrectAttributes() {
		ArrayList<String> inputAsStringArrayListResult = testCase.getInputAsStringArrayList();
		Assert.assertEquals(true, HelperMethods.compareTwoStringArrayLists(inputAsStringArrayExpected, inputAsStringArrayListResult));
	}
	
	@Test
	public void getNumberOfSpaces_ShouldReturnCorrectAttributes() {
		int numberOfSpacesResult = testCase.getNumberOfSpaces();
		Assert.assertEquals(numberOfSpacesExpected, numberOfSpacesResult);
	}
	
	@Test
	public void getNumberOfWords_ShouldReturnCorrectAttributes() {
		int numberOfWordsResult = testCase.getNumberOfWords();
		Assert.assertEquals(numberOfWordsExpected, numberOfWordsResult);
	}
	
	@Test
	public void getCharsIncludingSpaces_ShouldReturnCorrectAttributes() {
		int charIncSpacesResult = testCase.getCharsIncludingSpaces();
		Assert.assertEquals(charIncSpacesExpected, charIncSpacesResult);
	}
	
	@Test
	public void getCharsExcludingSpaces_ShouldReturnCorrectAttributes() {
		int charExcSpacesResult = testCase.getCharsExcludingSpaces();
		Assert.assertEquals(charExcSpacesExpected, charExcSpacesResult);
	}
	
	@Test
	public void getCharacterFrequency_ShouldReturnCorrectAttributes() {
		int[] charFreqResult = testCase.getCharacterFrequency();
		Assert.assertEquals(true, HelperMethods.compareTwoArrays(charFreqExpected, charFreqResult));
	}
	
	@Test
	public void getHighestCount_ShouldReturnCorrectAttributes() {
		int highestResult = testCase.getHighestCount();
		Assert.assertEquals(highestExpected, highestResult);
	}
	
	@Test
	public void getNumberOfRecognisedCharacters_ShouldReturnCorrectAttributes() {
		int recResult = testCase.getNumberOfRecognisedCharacters();
		Assert.assertEquals(recExpected, recResult);
	}
	
	@Test
	public void getNumberOfUnrecognisedCharacters_ShouldReturnCorrectAttributes() {
		int unrecResult = testCase.getNumberOfUnrecognisedCharacters();
		Assert.assertEquals(unrecExpected, unrecResult);
	}
	
	@Test
	public void getRelativeFrequency_ShouldReturnCorrectAttributes() {
		String[] relFreqResult = testCase.getRelativeFrequency();
		Assert.assertEquals(true, HelperMethods.compareTwoArrays(relFreqExpected, relFreqResult));
	}
	
	@Test
	public void getWordLengths_ShouldReturnCorrectAttributes() {
		ArrayList<Integer> wordLengthResult = testCase.getWordLengths();
		Assert.assertEquals(true, HelperMethods.compareTwoArrayLists(wordLengthExpected, wordLengthResult));
	}
	
	@Test
	public void getWordLengthFrequencies_ShouldReturnCorrectAttributes() {
		ArrayList<Integer> lengthFreqResult = testCase.getWordLengthFrequencies();
		Assert.assertEquals(true, HelperMethods.compareTwoArrayLists(lengthFreqExpected, lengthFreqResult));
	}
	
	@Test
	public void getLongestWord_ShouldReturnCorrectAttributes() {
		ArrayList<String> longestResult = testCase.getLongestWord();
		Assert.assertEquals(true, HelperMethods.compareTwoStringArrayLists(longestExpected, longestResult));
	}
	
	@Test
	public void getLongestWordForDisplay_ShouldReturnCorrectAttributes() {
		String longestDispResult = testCase.getLongestWordForDisplay();
		Assert.assertEquals(longestDispExpected, longestDispResult);
	}

}
