package TextAnalysis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HelperMethods {
	
	public static String convertTextFile(String location) {
		String textFromFile = "";
		try {
			Scanner scanner = new Scanner (new FileInputStream(location));
			while (scanner.hasNextLine()) {
				textFromFile += scanner.nextLine();
			}
			return textFromFile;
		}
		catch(FileNotFoundException fileNotFoundException) {
			System.out.println("The file could not be found, please check the filename and path and try again");
			return textFromFile;
		}
	}
	
    public static boolean compareTwoArrays(int[] arrayOne, int[] arrayTwo) {             
        boolean equalOrNot = true;
         
        if(arrayOne.length == arrayTwo.length) {
            for (int i = 0; i < arrayOne.length; i++) {
                if(arrayOne[i] != arrayTwo[i]) {
                    equalOrNot = false;
                }
            }
        }
        else {
        	equalOrNot = false;
        } 
        return equalOrNot;
    }
    
    public static boolean compareTwoArrays(String[] arrayOne, String[] arrayTwo) {             
        boolean equalOrNot = true;
         
        if(arrayOne.length == arrayTwo.length) {
            for (int i = 0; i < arrayOne.length; i++) {
                if(!arrayOne[i].equals(arrayTwo[i])) {
                    equalOrNot = false;
                }
            }
        }
        else {
        	equalOrNot = false;
        }         
        return equalOrNot;
    }
    
    public static boolean compareTwoArrayLists(ArrayList<Integer> expected, ArrayList<Integer> result) {
    	boolean equalOrNot = true;
    	
    	if (expected.size() == result.size()) {
    		for (int i = 0; i < expected.size(); i ++) {
        		if (expected.get(i) != result.get(i)) {
        				equalOrNot = false;
        		}
        	}
    	}
    	else {
    		equalOrNot = false;
    	}    	
    	return equalOrNot;
    }
    
    public static boolean compareTwoStringArrayLists(ArrayList<String> expected, ArrayList<String> result) {
    	boolean equalOrNot = true;
    	
    	if (expected.size() == result.size()) {
    		for (int i = 0; i < expected.size(); i ++) {
        		if (expected.get(i).equals(result.get(i))) {
        				equalOrNot = true;
        		}
        		else {
        			equalOrNot = false;
        		}
        	}
    	}
    	else {
    		equalOrNot = false;
    	}    	
    	return equalOrNot;
    }
    
    public static void fullAnalysisDisplay(TextAnalysis textAnalysis) {
		System.out.println(textAnalysis.toString());
		textAnalysis.displayFrequencies(textAnalysis.getCharacterFrequency(), TextAnalysis.characterArray, textAnalysis.getRelativeFrequency());
		textAnalysis.barChartFrequencies(textAnalysis.characterFrequency, TextAnalysis.characterArray, textAnalysis.getHighestCount());
		textAnalysis.displayWordLengths();
    }
    
    public static void displayInterface(TextAnalysis textAnalysis) {
    	Scanner sc = new Scanner(System.in);
    	int display = 1;
    	do {
	    	System.out.println("What analysis would you like to see?\n\n1: Show all analysis\n2: Show basic analysis\n3: Show character frequency table\n4: Show character frequency bar chart\n5: Show word lengths\n6: Save basic analysis to a .txt file\n0: Return to the main menu\n");
	    	display = sc.nextInt();
	    	if (display == 1) {
	    		HelperMethods.fullAnalysisDisplay(textAnalysis);
	    		display = 0;
	    	}
	    	else if (display == 2) {
	    		System.out.println(textAnalysis.toString());
	    	}
	    	else if (display == 3) {
	    		textAnalysis.displayFrequencies(textAnalysis.getCharacterFrequency(), TextAnalysis.characterArray, textAnalysis.getRelativeFrequency());
	    	}
	    	else if (display == 4) {
	    		textAnalysis.barChartFrequencies(textAnalysis.getCharacterFrequency(), TextAnalysis.characterArray, textAnalysis.getHighestCount());
	    	}
	    	else if (display == 5) {
	    		textAnalysis.displayWordLengths();
	    	}
	    	else if (display == 6) {
	    		Scanner filenameScanner = new Scanner(System.in);
	    		System.out.println("What would you like the file to be called?");
	    		String filename = filenameScanner.next();
	    		try {
	    			PrintWriter writer = new PrintWriter("..\\TestTextFiles\\" + filename + ".txt");
	    			writer.println("The text you are analysing is :\r\n " + textAnalysis.getInputForDisplay());
	    			writer.println();
	    			writer.println("Number of words: " + textAnalysis.getNumberOfWords());
	    			writer.println("Number of spaces: " + textAnalysis.getNumberOfSpaces());
	    			writer.println("Total characters including spaces: " + textAnalysis.getCharsIncludingSpaces());
	    			writer.println("Total characters excluding spaces: " + textAnalysis.getCharsExcludingSpaces());
	    			writer.println("Total number of recognised characters: " + textAnalysis.getNumberOfRecognisedCharacters());
	    			writer.println("Total number of unrecognised characters: " + textAnalysis.getNumberOfUnrecognisedCharacters());
	    			writer.println();
	    			writer.println(textAnalysis.getLongestWordForDisplay());
	    			writer.println(textAnalysis.getWordLengthFrequenciesDisplay());
	    			writer.flush();
	    			System.out.println("Your file is now saved in C:\\code\\Year1JavaProjectV4\\TestTextFiles\\" + filename + ".txt");
	    		} catch (FileNotFoundException e) {
	    			System.out.println("Something went wrong, please try again");
	    		}
	    	}
	    	else if (display > 6) {
	    		System.out.println("You must enter 1, 2, 3, 4, 5, 6 or 0 only");
	    	}
    	} while (display != 0);
    }

}
