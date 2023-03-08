import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

public class MainClass {
	
	public static void main(String[] args){
		FileManager filemanager = new FileManager();
		
		try {
			filemanager.openFileName("test.txt");
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found \n");
			return;
		}
		
		
		try {
			filemanager.writeFile("123.txt");
		}
		catch (IOException e) {
			System.out.println("Write error \n");
		}
		
		try {
			filemanager.closeFiles();
		}
		catch (IOException e) {
			System.out.println("Close error \n");
		}
		
		
	}

}
