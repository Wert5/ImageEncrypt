import java.io.File;
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
	JButton OK = new JButton("OK");
	JPanel South = new JPanel();
	JButton imgDisp= new JButton();
	
	File openFile=null;
	char[] current;
  
	public static void main(String... aArgs) {
		ImageEncryptGUI sonya = new ImageEncryptGUI();
		sonya.setVisible(true);
	}
	
	
	public ImageEncryptGUI(){
		this.setSize(400,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		//this.add(save,BorderLayout.NORTH);
		this.add(South,BorderLayout.SOUTH);
		this.add(imgDisp,BorderLayout.CENTER);
		South.setLayout(new GridLayout(2,3));
		South.add(encrypt);
		South.add(decrypt);
		South.add(browse);
		South.add(save);
		South.add(new JLabel("Password:"));
		South.add(password);
		encrypt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(openFile!=null){
					try {
						current=AESencryptDecrypt.encryptFullArray(ImageEncryptFileReader.readBinaryFile(openFile), AESencryptDecrypt.passwordToKey(password.getText()));
						JOptionPane.showMessageDialog(null, (openFile.getName()+" has been encrypted!"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
	
		});
		
		decrypt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(openFile!=null){
					try {
						current=AESencryptDecrypt.decryptFullArray(ImageEncryptFileReader.readBinaryFile(openFile), AESencryptDecrypt.passwordToKey(password.getText()));
						JOptionPane.showMessageDialog(null, (openFile.getName()+" has been decrypted!"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
	
		});
		
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(current!=null){
					JFileChooser chooser = new JFileChooser();
					int ret = chooser.showSaveDialog(null);
					if(ret==JFileChooser.APPROVE_OPTION){
						try {
							File saveF=chooser.getSelectedFile();
							if(!saveF.getName().endsWith(".jpg")){
								saveF.renameTo(new File(saveF.getParent()+saveF.getName().substring(0,saveF.getName().length()-3)));
							}
							ImageEncryptFileReader.writeBinaryFile(current, saveF);
							JOptionPane.showMessageDialog(null, ("Data has been saved as "+saveF.getName()));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
	
		});
		
		browse.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile=ImageEncryptFileReader.chooseFile();
				try{
					imgDisp.setIcon(new ImageIcon(openFile.getAbsolutePath(),""));
				}catch(Exception e1){
					
				}
				
			}
	
		});
	  }
  
}
