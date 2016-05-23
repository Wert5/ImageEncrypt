import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** JDK 7+. */
public class ImageEncryptGUI extends JFrame {
	JButton save = new JButton("Save");
	JButton encrypt = new JButton("Encrypt");
	JButton browse = new JButton("Browse");
	JButton decrypt = new JButton("Decrypt");
	JTextField password = new JTextField("password");
	JTextField filePath = new JTextField("filePath");
	JButton OK = new JButton("OK");
	JPanel South = new JPanel();
	JButton openImage = new JButton("Open a picture.");
  
	public static void main(String... aArgs) {
		ImageEncryptGUI sonya = new ImageEncryptGUI();
		sonya.setVisible(true);
		  
		  
	}
	
	
	public ImageEncryptGUI(){
		this.setSize(400,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		this.add(save,BorderLayout.NORTH);
		this.add(South,BorderLayout.SOUTH);
		South.setLayout(new GridLayout(4,2));
		South.add(encrypt);
		South.add(decrypt);
		encrypt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					
			}
	
		});
	  }
  
}
