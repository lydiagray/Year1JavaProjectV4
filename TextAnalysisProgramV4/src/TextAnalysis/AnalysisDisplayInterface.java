package TextAnalysis;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AnalysisDisplayInterface {
	
	public static void topMenuDisplay() {
		System.out.println("");
		System.out.println("Please select the program mode you would like to use?");
		System.out.println("1: Full mode");
		System.out.println("2: Demo mode");
		System.out.println("0: Exit the program");
	}
	
	public static void displayInput(TextAnalysis textAnalysis) {
		System.out.println("");
		System.out.println("The text you are analysing is :");
		System.out.println("");
		System.out.println(textAnalysis.getInputForDisplay());
		System.out.println("");
	}
	
    public static void displayInterface(TextAnalysis textAnalysis) {
    	Scanner sc = new Scanner(System.in);
    	int display = 1;
    	
    	do {
    		System.out.println("");
	    	System.out.println("What analysis would you like to see?");
			System.out.println("1: Show all analysis");
			System.out.println("2: Show basic analysis");
			System.out.println("3: Show character frequency table");
			System.out.println("4: Show character frequency bar chart");
			System.out.println("5: Show all word lengths");
			System.out.println("6: Save basic analysis to a .txt file");
			System.out.println("0: Return to the main menu");
	    	display = sc.nextInt();
	    	
	    	switch(display) {
	    		case 0: break;
		    	case 1:
		    		displayInput(textAnalysis);
			    	textAnalysis.printBasicAnalysis();
		    		textAnalysis.displayFrequencies();
		    		textAnalysis.barChartFrequencies();
		    		textAnalysis.displayWordLengths();
		    		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		    		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		    		break;
		    	case 2:
		    		displayInput(textAnalysis);
		    		textAnalysis.printBasicAnalysis();
		    		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		    		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		    		break;
		    	case 3:
		    		displayInput(textAnalysis);
		    		textAnalysis.displayFrequencies();
		    		break;
		    	case 4:
		    		displayInput(textAnalysis);
		    		textAnalysis.barChartFrequencies();
		    		break;
		    	case 5:
		    		displayInput(textAnalysis);
		    		textAnalysis.displayWordLengths();
		    		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		    		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		    		break;
		    	case 6:
		    		Scanner filenameScanner = new Scanner(System.in);
		    		System.out.println("What would you like the file to be called?");
		    		String filename = filenameScanner.next();
		    		try {
		    			PrintWriter writer = new PrintWriter("..\\TestTextFiles\\" + filename + ".txt");
		    			writer.println("The text you are analysing is :"); 
		    			writer.println(textAnalysis.getInputForDisplay());
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
		    			System.out.println("Your file is now saved in TestTextFiles\\" + filename + ".txt within this Java workspace");
		    		} catch (FileNotFoundException e) {
		    			System.out.println("Something went wrong, please try again");
		    		}
		    		System.out.println("-----------------------------------------------------------------------");
		    		System.out.println("-----------------------------------------------------------------------");
		    		break;
		    	default: 
		    		System.out.println("You must only enter a number between 0 and 6");	
		    		break;
	    	}
	    	System.out.println("");
    	} while (display != 0);
    }
}
