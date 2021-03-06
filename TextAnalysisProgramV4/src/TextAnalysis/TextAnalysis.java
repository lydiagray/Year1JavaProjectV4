package TextAnalysis;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class TextAnalysis {
	
	//Attributes
	
	public String input;
	public char[] inputAsArray;
	public String inputForDisplay;
	public ArrayList<String> inputAsStringArrayList;
	public int numberOfSpaces;
	public int numberOfWords;
	public int charsIncludingSpaces;
	public int charsExcludingSpaces;
	public int[] characterFrequency;
	public int highestCount;
	public int numberOfRecognisedCharacters;
	public int numberOfUnrecognisedCharacters;
	public String[] relativeFrequency;
	public ArrayList<Integer> wordLengths;
	public ArrayList<Integer> wordLengthFrequencies;
	public ArrayList<String> longestWord;
	public ArrayList<String> basicAnalysisForDisplay;
	public String wordLengthFrequenciesDisplay;
	public String longestWordForDisplay;
	public static final char[] characterArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ',', '!', '?', ':', ';', '"','\'', '&', '(', ')', '-', '@', '\\', '/'};
	
	
	//Constructor
	
	public TextAnalysis(String userInput) {
		this.input = userInput.toUpperCase();
		this.inputAsArray = input.toCharArray();
		this.inputAsStringArrayList = inputAsStringArrayList();
		this.numberOfSpaces = numberOfSpaces();
		this.charsIncludingSpaces = charsIncludingSpaces();
		this.charsExcludingSpaces = charsExcludingSpaces();
		this.numberOfWords = numberOfWords();
		this.characterFrequency = characterFrequency();
		this.highestCount = highestCount();
		this.numberOfRecognisedCharacters = numberOfRecognisedCharacters();
		this.numberOfUnrecognisedCharacters = numberOfUnrecognisedCharacters();
		this.relativeFrequency = relativeFrequency();
		this.wordLengths = wordLengths();
		this.wordLengthFrequencies = wordLengthFrequencies();
		this.longestWord = longestWord();
		this.inputForDisplay = inputForDisplay();
		this.wordLengthFrequenciesDisplay = wordLengthFrequenciesDisplay();
		this.longestWordForDisplay = longestWordForDisplay();
		this.basicAnalysisForDisplay = basicAnalysisForDisplay();
	}
	
	
	//Methods
	
	//Get methods
	
	public String getInput() {return input;}
	public char[] getInputAsArray() {return inputAsArray;}
	public ArrayList<String> getInputAsStringArrayList() {return inputAsStringArrayList;}
	public int getNumberOfSpaces() {return numberOfSpaces;}
	public int getCharsIncludingSpaces() {return charsIncludingSpaces;}
	public int getCharsExcludingSpaces() {return charsExcludingSpaces;}
	public int getNumberOfWords() {return numberOfWords;}
	public int[] getCharacterFrequency() {return characterFrequency;}
	public int getHighestCount() {return highestCount;}
	public int getNumberOfRecognisedCharacters() {return numberOfRecognisedCharacters;}
	public int getNumberOfUnrecognisedCharacters() {return numberOfUnrecognisedCharacters;}
	public String[] getRelativeFrequency() {return relativeFrequency;}
	public ArrayList<Integer> getWordLengths() {return wordLengths;}
	public ArrayList<Integer> getWordLengthFrequencies() {return wordLengthFrequencies;}
	public ArrayList<String> getLongestWord() {return longestWord;}
	public String getInputForDisplay() {return inputForDisplay;}
	public String getWordLengthFrequenciesDisplay() {return wordLengthFrequenciesDisplay;}	
	public String getLongestWordForDisplay() {return longestWordForDisplay;}
	public ArrayList<String> getBasicAnalysisForDisplay() {return basicAnalysisForDisplay;}

	
	//Analysis methods
	
	public int numberOfSpaces() {
		int count = 0;
		
		for (int i = 0; i < inputAsArray.length; i++) {
			if (inputAsArray[i] == ' ') {
				count++;
			}
		}
		
		return count;
	}
	
	public int numberOfWords() {
		if (numberOfSpaces == 0) {
			return 0;
		}
		else {
			return numberOfSpaces + 1;
		}
	}
	
	public int countCharacters(char character) {
		int count = 0;
		
		for (int i = 0; i < inputAsArray.length; i++) {
			if (character == inputAsArray[i]) {
				count++;
			}
		}	
		
		return count;
	}
	
	public int charsIncludingSpaces() {
		return inputAsArray.length;
	}
	
	public int charsExcludingSpaces() {
		return charsIncludingSpaces - numberOfSpaces;
	}
	
	public int[] characterFrequency() {
		int[] frequencyValues = new int[characterArray.length];
		
		for (int i = 0; i < characterArray.length; i++) {
			frequencyValues[i] = countCharacters(characterArray[i]); 
		}	
		
		return frequencyValues;
	}
	
	public int highestCount() {
		int count = 0;
		
		for (int i = 0; i < characterFrequency.length; i++) {
			if (characterFrequency[i] > count) {
				count = characterFrequency[i];
			}
		}
		
		return count;
	}
	
	public int numberOfRecognisedCharacters() {
		int count = 0;
		
		for (int i = 0; i < characterFrequency.length; i++) {
			count += characterFrequency[i];
		}
		
		return count;
	}
	
	public int numberOfUnrecognisedCharacters() {
		return charsExcludingSpaces - numberOfRecognisedCharacters;
	}
	
	public String[] relativeFrequency() {
		double[] relativeFrequency = new double[characterArray.length];
		double[] characterFrequencyDouble = new double[characterArray.length];
		String[] formattedRelativeFrequency = new String[characterArray.length];
		
		for (int i = 0; i < characterFrequency.length; i++) {
			characterFrequencyDouble[i] = characterFrequency[i];
		}
		
		for (int i = 0; i < characterFrequency.length; i++) {
			if (charsExcludingSpaces > 0) {
				relativeFrequency[i] = (characterFrequencyDouble[i] / charsExcludingSpaces);
			}
			else {
				relativeFrequency[i] = 0;
			}
		}
		
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);
		
		for (int i = 0; i < relativeFrequency.length; i++) {
			if (charsExcludingSpaces > 0) {
				formattedRelativeFrequency[i] = df.format(relativeFrequency[i]);
			}
			else {
				formattedRelativeFrequency[i] = "0";
			}
		}
		
		return formattedRelativeFrequency;
	}
	
	public ArrayList<String> inputAsStringArrayList() {
		ArrayList<String> inputAsStringArrayList = new ArrayList<String>();
		String word = "";
		
		for (Character character : inputAsArray) {
			if (character != ' ') {
				//loop only uses alphabet characters so only index 0 -25 inclusive. Assumes the alphabet will always be at the beginning of characterArray
				for (int j = 0; j < 26; j++) {
					if (character == characterArray[j]) {
						word += character;
					}
				}
			}
			
			if (character == ' ' && word.length() > 0) {
				inputAsStringArrayList.add(word);
				word = "";
			}
		}
		inputAsStringArrayList.add(word);
		
		return inputAsStringArrayList;
	}
	
	public ArrayList<Integer> wordLengths() {
		ArrayList<Integer> wordLengths = new ArrayList<Integer>();
		int count = 0;
		
   		for (Character character : inputAsArray) {
			if (character != ' ') {
				//loop only uses alphabet characters so only index 0 -25 inclusive. Assumes the alphabet will always be at the beginning of characterArray
				for (int j = 0; j < 26; j++) {
					if (character == characterArray[j]) {
						count++;
					}
				}
			}

			if (character == ' ' && count != 0) {
				wordLengths.add(count);
				count = 0;
			}
		}
   		wordLengths.add(count);
   		
		return wordLengths;
	}
	
	public ArrayList<Integer> wordLengthFrequencies() {
		ArrayList<Integer> wordLengthFrequencies = new ArrayList<Integer>();
		int count = 0;
		
		for (int i = 1; i <= 8; i++) {
			for (Integer item : wordLengths) {
				if (i == 8) {
					if (item >= i) {
						count++;
					}
				}
				else {
					if (item == i) {
						count++;
					}
				}
			}
			wordLengthFrequencies.add(count);
			count = 0;
		}
		
		return wordLengthFrequencies;
	}
	
	public ArrayList<String> longestWord() {
		ArrayList<String> longestWord = new ArrayList<String>();
		int highest = 0;
		
		for (String string : inputAsStringArrayList) {
			if (string.length() > highest) {
				longestWord.clear();
				longestWord.add(string);
				highest = string.length();
			}
			else if (string.length() == highest) {
				boolean duplicate = false;
				for (String word : longestWord) {
					if (string.equals(word)) {
						duplicate = true;
					}
				}
				if (duplicate == false) {
					longestWord.add(string);
				}
			}
		}
		
		return longestWord;
	}
	
	//Display methods
	public String inputForDisplay() {
		String string = "";
		int count = 0;
		
		for (int i = 0; i < inputAsArray.length; i++) {
			string += inputAsArray[i];
			if (inputAsArray[i] == ' ') {
				count++;
			}
			if (inputAsArray[i] == ' ' && count % 20 == 0) {
				string += "\n";
			}
		}
		return string;
	}
	
	public void displayWordLengths() {
		System.out.println("Word lengths");
    	System.out.println("");
		for (int i = 0; i < wordLengths.size(); i++) {
			System.out.println("Word " + (i+1) + " is " + wordLengths.get(i) + " letters long.");
		}
    	System.out.println("");
	}
	
	public String wordLengthFrequenciesDisplay() {
		
		String wordLengthFrequenciesDisplay = "";
		
		for (int i = 0; i < 8; i++) {
			if (i <= 6) {
				wordLengthFrequenciesDisplay += "There are " + wordLengthFrequencies.get(i) + " words containing " + (i+1) + " letters.\r\n";
			}
			else {
				wordLengthFrequenciesDisplay += "There are " + wordLengthFrequencies.get(i) + " words containing 8 or more letters.\r\n";
			}
		}
		
		return wordLengthFrequenciesDisplay;
	}
	
	public String longestWordForDisplay() {
		String longestWordForDisplay = "", longestWordList = "";
		
		for (String word : longestWord) {
			if (word.equals(longestWord.get(0))) {
				longestWordList += word;
			}
			else {
				longestWordList += ", " + word;
			}
		}
		
		if (longestWord.size() < 2) {
			longestWordForDisplay += "The longest word is " + longestWordList;
		}
		else {
			longestWordForDisplay += "The longest words are : " + longestWordList;
		}
		
		longestWordForDisplay += " at " + longestWord.get(0).length() + " letters long.";
		
		return longestWordForDisplay;
	}
	
	public ArrayList<String> basicAnalysisForDisplay() {
		ArrayList<String> basicAnalysisForDisplay = new ArrayList<String>();
		
		basicAnalysisForDisplay.add("Basic analysis");
		basicAnalysisForDisplay.add("");
		basicAnalysisForDisplay.add("Number of words: "	+ numberOfWords);
		basicAnalysisForDisplay.add("Number of spaces: " + numberOfSpaces);
		basicAnalysisForDisplay.add("Total characters including spaces: " + charsIncludingSpaces);
		basicAnalysisForDisplay.add("Total characters excluding spaces: " + charsExcludingSpaces);
		basicAnalysisForDisplay.add("Total number of recognised characters: " + numberOfRecognisedCharacters);
		basicAnalysisForDisplay.add("Total number of unrecognised characters: " + numberOfUnrecognisedCharacters);
		basicAnalysisForDisplay.add("");
		basicAnalysisForDisplay.add(longestWordForDisplay);
		basicAnalysisForDisplay.add(wordLengthFrequenciesDisplay);
		basicAnalysisForDisplay.add("");
		
		return  basicAnalysisForDisplay;
	}
    
    public void printBasicAnalysis() {
    	for (String line : basicAnalysisForDisplay) {
    		System.out.println(line);
    	}
    }
    
	public void displayFrequenciesTableBorders(String first, String second, int start, int finish) {
		System.out.print(first);
		for (int i = start; i < finish; i++) {
			if (i != finish) {
				System.out.print(second);
			}
			else {
				System.out.println(second);
			}
		}
		System.out.println("");
	}
	
	public void displayFrequenciesValues(String first, char[] array, int start, int finish) {
		System.out.print(first);
		for (int i = start; i < finish; i++) {
			System.out.format("%-5s|", array[i]);
		}
		System.out.println("");
	}
	
	public void displayFrequenciesValues(String first, int[] array, int start, int finish) {
		System.out.print(first);
		for (int i = start; i < finish; i++) {
			System.out.format("%-5s|", array[i]);
		}
		System.out.println("");
	}
	
	public void displayFrequenciesValues(String first, String[] array, int start, int finish) {
		System.out.print(first);
		for (int i = start; i < finish; i++) {
			System.out.format("%-5s|", array[i]);
		}
		System.out.println("");
	}
	
	public void displayFrequencies() {
		String leftColumnTopBottom = "+---------+", columnTopBottom = "-----+", character = "|Character|", frequency = "|Frequency|", relative = "|Relative |", leftColumnSpace = "|         |", columnSpace = "     |";
		System.out.println("\n\rCharacter frequency table\n\r");
		//Part 1
		displayFrequenciesTableBorders(leftColumnTopBottom, columnTopBottom, 0, 26);
		displayFrequenciesValues(character, characterArray, 0, 26);
		displayFrequenciesTableBorders(leftColumnSpace, columnSpace, 0, 26);
		displayFrequenciesTableBorders(leftColumnTopBottom, columnTopBottom, 0, 26);
		displayFrequenciesValues(character, characterFrequency, 0, 26);
		displayFrequenciesTableBorders(frequency, columnSpace, 0, 26);
		displayFrequenciesTableBorders(leftColumnTopBottom, columnTopBottom, 0, 26);
		displayFrequenciesValues(relative, relativeFrequency, 0, 26);
		displayFrequenciesTableBorders(frequency, columnSpace, 0, 26);
		displayFrequenciesTableBorders(leftColumnTopBottom, columnTopBottom, 0, 26);		
		//Part 2		
		displayFrequenciesTableBorders(leftColumnTopBottom, columnTopBottom, 26, 51);
		displayFrequenciesValues(character, characterArray, 26, 51);
		displayFrequenciesTableBorders(leftColumnSpace, columnSpace, 26, 51);
		displayFrequenciesTableBorders(leftColumnTopBottom, columnTopBottom, 26, 51);
		displayFrequenciesValues(character, characterFrequency, 26, 51);
		displayFrequenciesTableBorders(frequency, columnSpace, 26, 51);
		displayFrequenciesTableBorders(leftColumnTopBottom, columnTopBottom, 26, 51);
		displayFrequenciesValues(relative, relativeFrequency, 26, 51);
		displayFrequenciesTableBorders(frequency, columnSpace, 26, 51);
		displayFrequenciesTableBorders(leftColumnTopBottom, columnTopBottom, 26, 51);
	}
	
	public void barChartFrequencies() {
		//Have used ternary operators in work, trying one out here
		int count = highestCount < 5 ? 5 : highestCount;
		System.out.println("\nCharacter frequency bar chart");
		System.out.println("");

		for (int i = count; i > 0; i--) {
			if (i < 10) {
				System.out.print(i + "  |");
			}
			else if (i > 9 && i < 100) {
				System.out.print(i + " |");
			}
			else {
				System.out.print(i + "|");
			}
			for (int j = 0; j < characterFrequency.length; j++) {
				if (characterFrequency[j] != 0 && characterFrequency[j] >= i) {
					System.out.print("X ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println("");
		}
		System.out.println("==========================================================================================================");
		System.out.print("   |");
		for (int i = 0; i < TextAnalysis.characterArray.length; i++) {
			System.out.print(TextAnalysis.characterArray[i] + " ");
		}
		System.out.println("\n");
	}
}
