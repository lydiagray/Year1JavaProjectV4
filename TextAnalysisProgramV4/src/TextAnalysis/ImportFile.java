package TextAnalysis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportFile {
	
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

}
