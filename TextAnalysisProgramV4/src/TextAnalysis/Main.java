package TextAnalysis;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		int programMode = 0, inputType = 0, demo = 0;
		String input = "";
		
		System.out.println("Welcome to the LG Text Analysis Program");
		AnalysisDisplayInterface.topMenuDisplay();
			
		do {
			Scanner sc = new Scanner(System.in);
			programMode = sc.nextInt();
			
			switch(programMode) {
			
			case 0 : 
				System.out.println("Thank you for using the LG Text Analysis Program");
				System.out.println("Goodbye");
				System.exit(0);
				
			case 1 : 
				do {
					System.out.println("");
					System.out.println("How would you like to enter your text?");
					System.out.println("1: Use the keyboard");
					System.out.println("2: Import a .txt file");
					System.out.println("0: Return to the main menu");
					Scanner scan = new Scanner(System.in);
					inputType = scan.nextInt();
						
						if (inputType == 1) {
							System.out.println("Please enter the text you would like to analyse:");
							Scanner textScanner = new Scanner(System.in);
							input = textScanner.nextLine();
							TextAnalysis textAnalysis = new TextAnalysis(input);
					    	AnalysisDisplayInterface.displayInterface(textAnalysis);
						}
						else if(inputType == 2) {
							System.out.println("Please enter the full location of the .txt file including the path e.g. C:\\code\\Year1JavaProjectV3\\TestTextFiles\\longStringFile.txt:");
							Scanner locationScanner = new Scanner(System.in);
							String location = locationScanner.nextLine();
							input = ImportFile.convertTextFile(location);
							
							if (input != "") {							
								TextAnalysis textAnalysis = new TextAnalysis(input);
								AnalysisDisplayInterface.displayInterface(textAnalysis);
							} else {
								System.out.println("Something went wrong, please try again");
								inputType = -1;
							}
						}				
						else if (inputType == 0) {
							break;
						}					
						else {
							System.out.println("You must enter 1, 2 or 0 only");
						}				
					} while (inputType > 2 || inputType < 0);
					break;
				
			case 2 : 
				do {
					System.out.println("");
					System.out.println("Demo mode");
					System.out.println("");
					System.out.println("Would you like to see a demonstration of:");
					System.out.println("1: A short piece of text");
					System.out.println("2: A long piece of text imported from a .txt file");
					System.out.println("0: Return to the main menu");
					demo = sc.nextInt();
					
					if (demo == 1) {
						TextAnalysis textAnalysis = new TextAnalysis(UnitTests.shortString);
						AnalysisDisplayInterface.displayInterface(textAnalysis);
					}
					else if (demo == 2) {
						TextAnalysis textAnalysis = new TextAnalysis(ImportFile.convertTextFile("C:\\code\\Year1JavaProjectV3\\TestTextFiles\\longStringFile.txt"));
						AnalysisDisplayInterface.displayInterface(textAnalysis);
					}
					else if (demo == 0) {
						break;
					}
					else {
						System.out.println("You must select 1, 2 or 0");
					}
				} while (demo > 2 || demo < 0);
				break;
				
			default : 
				System.out.println("You must select 1, 2 or 0");
				break;
			}
			
			AnalysisDisplayInterface.topMenuDisplay();
			
		} while (programMode != 0);			
	}
}
