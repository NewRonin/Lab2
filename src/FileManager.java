import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
	
	private String inputFileName;
	private String fileOutputName;
	private FileInputStream fileInputStream;
	private FileOutputStream fileOutputStream;
	
	final int CAPS_START = 65;
	final int NONCAPS_START = 97;
	final int ALPH_SIZE = 25;
	
	Scanner in = new Scanner(System.in);
	
	public FileManager() {
		this.inputFileName = "";
	}
	
	public void openFileName() throws FileNotFoundException {
		System.out.print("Enter filename or path: \n");
		this.inputFileName = in.nextLine();
		openFileName(inputFileName);
		
	}
	
	public void openFileName(String inputFileName) throws FileNotFoundException {
		this.inputFileName = inputFileName;
		this.fileInputStream = new FileInputStream(this.inputFileName);
		System.out.println("File found \n");
	}
	
	public void writeFile() throws IOException {
		System.out.print("Enter output file name: \n");
		this.fileOutputName = in.nextLine();
		this.writeFile(fileOutputName);
	}
	
	public void writeFile(String fileOutputName) throws IOException {
		this.fileOutputStream = new FileOutputStream(fileOutputName);
		int c;
		int counter = 0;
		while ((c = fileInputStream.read()) != -1) {
			
			if((c >= CAPS_START && c <= CAPS_START + ALPH_SIZE) || (c >= NONCAPS_START && c <= NONCAPS_START + ALPH_SIZE)) {
				counter++;
			}
		}
		
		final String stringCounter = String.valueOf(counter);
		System.out.println("Answer: " + stringCounter);
		
		for(int i = 0; i < stringCounter.length(); i++) {
			fileOutputStream.write(stringCounter.charAt(i));
		}
		
		System.out.println("File written \n");
	}
	
	public void closeFiles() throws IOException {
		fileInputStream.close();
		fileOutputStream.close();
	}
	

}
