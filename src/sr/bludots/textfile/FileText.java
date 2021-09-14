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
	public static String[] names = { "Bryan Doorson", "Bryan Bijlhout", "Juscelino Kartoebi", "Kirsten Mentopawiro",
			"Freddy Krueger" };
	static File dir = new File(".");
	static String[] files = dir.list();
	
	static File textFile = new File("Names.txt");

	public static void main(String args[]) {
		createTextFile();
		deleteIfMaxSize(); 
	}

	public static void createTextFile() {
		for (String name : files) {
			System.err.println(name);
		}
		int run = 0;
		while (run < names.length) {
			try {
				FileWriter writer = new FileWriter(textFile, true);
				writer.write(names[run++] + "\n");
				writer.close();
			} catch (IOException io) {
				System.err.println("Something went wrong:" + io.getMessage());
			}
		}
	}
//	 als deze groter is geworden dan 1000 bytes. (file.size of lenght)
	public static void deleteIfMaxSize() {
		File[] names = dir.listFiles();
		for (File file : names) {
			if (file.isFile()) {
				if (textFile.length() > 1000) { 
					file.delete();
				}
			}

		}
	}

}
