import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ImageEncryptFileReader {
	
	public static void main(String[] in) throws IOException{
		String f=chooseFile().getAbsolutePath();
		char[] orig = readBinaryFile(f);
		System.out.println("Original:");
		AESencryptDecrypt.printArr(orig);
		char[] test= AESencryptDecrypt.encryptFullArray(orig, AESencryptDecrypt.passwordToKey("Hello"));
		System.out.println("Encrypted:");
		AESencryptDecrypt.printArr(test);
		char[] dec= AESencryptDecrypt.decryptFullArray(test, AESencryptDecrypt.passwordToKey("Hello"));
		System.out.println("Decrypted:");
		AESencryptDecrypt.printArr(dec);
		writeBinaryFile(dec,f);
	}
	
	public static File chooseFile(){
		 JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG & GIF Images", "jpg", "gif");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		}
		return null;
	}
	
	public static char[] readBinaryFile(String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    byte[] fileBytes=Files.readAllBytes(path);
	    char[] out=new char[fileBytes.length];
	    for(int i=0;i<out.length;i++){
	    	out[i]=(char)fileBytes[i];
	    }
	    return out;
	}
	
	public static char[] readBinaryFile(File f) throws IOException {
		return readBinaryFile(f.getAbsolutePath());
	}
	  
	public static void writeBinaryFile(char[] aBytes, String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    byte[] out=new byte[aBytes.length];
	    for(int i=0;i<out.length;i++){
	    	out[i]=(byte) aBytes[i];
	    }
	    Files.write(path, out); //creates, overwrites
	}
	
	public static void writeBinaryFile(char[] aBytes, File f) throws IOException {
		writeBinaryFile(aBytes, f.getAbsolutePath());
	}

}  
