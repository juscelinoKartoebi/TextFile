package sr.bludots.textfile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Schrijf een programma
 * 
 * - Dat een serie van willekeurige namen maakt en deze naar een file write. -
 * een functie waarbij u directory listing opvraagt nadat u zelf de gebruiker om
 * een specifieke directory naam vraagt - een functie waarbij u een file delete
 * als deze groter is geworden dan 1000 bytes. (file.size of lenght)
 * 
 */
public class FileText {
	public static String[] names = { "Freddy Krueger", "Bryan Bijlhout", "Juscelino Kartoebi", "Kirsten Mentopawiro",
			"Bryan Doorson" };
	static File dir = new File(".");
	static String[] files = dir.list();
	private static File textFile = new File("");

	public static void main(String args[]) {
		writeNamesInFile();
		showFiles();
		deleteFileIfMaxSizeReached();
		
	}
	public static void showFiles() {
		for (String file : files) {
			System.err.println(file);
		}
	}
//		writen naar textfile
	public static void writeNamesInFile() {
		textFile = new File("names.txt");
		int tries = 0;
		while (tries < names.length) {
			try {
				FileWriter writer = new FileWriter(textFile, true);
				writer.write(names[tries++] + "\n");
				writer.close();
			} catch (IOException io) {
				System.err.println("Something went wrong:" + io.getMessage());
			}
		}
		System.out.println("TextFile size = "+textFile.length() + "bytes");
		
	}
//	deleten wanneer fileSize groter word dan 1000 bytes
	public static void deleteFileIfMaxSizeReached() {
		if (textFile.length() > 1000) {
			textFile.delete();
			System.out.println("textfile deleted");
		} else {
			System.out.println("Size has not reach 1000bytes yet");
		}
	}
}
