package omecenBDDWebDriverManager;

import omecenBDDConfiguration.ConfogFileReader;

public class FileReadManager {
	private FileReadManager(){
		
	}
	private static FileReadManager fileReadManager = new FileReadManager();
	
	public static FileReadManager getInstance() {
		return fileReadManager;
		
	}
	
	ConfogFileReader confogFileReader;
	public ConfogFileReader getConfogFileReader() {
		return (confogFileReader==null)? new ConfogFileReader():confogFileReader;
		
	}
	
}
