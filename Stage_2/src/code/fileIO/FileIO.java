package code.fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileIO {
	/**
	 * This method reads the contents of the indicated file and returns the contents as a String.
	 * @param filename - the name of the file whose contents is to be read
	 * @return the contents of the file, as String
	 */
	public static HoldThreeStrings readFileToString(String filename) {
		Scanner scan = null;
		HoldThreeStrings output = new HoldThreeStrings("","","");
		try {
			scan = new Scanner(new File(filename));
			// scan lines 1, 2, and 3 for the strings of the lines.
			if(scan.hasNextLine()){
				output.line1 = scan.nextLine();
			}
			if(scan.hasNextLine()){
				output.line2 = scan.nextLine();
			}
			if(scan.hasNextLine()){
				output.line3 = scan.nextLine();
			}
 		} catch (FileNotFoundException e) {
			System.err.println("File not found: "+filename);
		}
		finally {
			scan.close();
		}
		return output;
	}
	
	/**
	 * This method writes the String toOutput to the indicated file.
	 * If the file does not exist, it is created.
	 * If the file exists, it is overwritten.
	 * @param filename - the name of the file to write to
	 * @param toOutput - the String to be written to the file
	 * @return true if writing the file was successful, false otherwise
	 */
	public static boolean writeStringToFile(String filename, String toOutput) {
		PrintStream stream = null;
		boolean result = false;
		try {
			stream = new PrintStream(filename);
			stream.format("%s%n",toOutput);
			result = true;
		} catch (FileNotFoundException e) {
			System.err.println("File not found and cannot be created: "+filename);
		}
		finally {
			stream.close();
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(FileIO.writeStringToFile("lab9.kbr", "example3"));
		System.out.println(FileIO.readFileToString("lab9.kbr"));
	}

}
