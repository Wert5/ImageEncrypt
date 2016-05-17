import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sql.rowset.WebRowSet;
import javax.swing.*;


public class ChatProgram extends JPanel{
	
	private static BufferedImage image;
	private static File sound;
	public static boolean addPic = false;
	public static boolean addMusic = false;
	

	public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		final File sound = new File("H:/cow1.wav");
		image = ImageIO.read(new File("H:/Spiderman.jpg"));
		final JLabel pic = new JLabel(new ImageIcon(image));
		pic.setBounds(65, 100, 275, 275);
		
		  

		
		JFrame window = new JFrame("Kahlil's ChatRoom");
		window.setSize(400, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new BorderLayout());
		window.setVisible(true);
		
		//window.add(pic);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 50, 50, 50);
		panel.setLayout(null);
		
		final JTextField message = new JTextField("*Say Something*", 10);
		message.setSize(300, 150);
		message.setLocation(400, 100);
		panel.add(message);
		
		JButton sendPic = new JButton("*Instagram*");
		sendPic.setBounds(400, 300, 150, 50);
		sendPic.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				addPic = true;
			}
			
		});
		panel.add(sendPic);
		
		JButton sendMusic = new JButton("*Rock Out*");
		sendMusic.setBounds(400, 400, 100, 50);
		sendMusic.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				addMusic = true;
			}
			
		});
		panel.add(sendMusic);
		
		final JTextField name = new JTextField("Who are You?", 10);
		name.setSize(200, 50);
		name.setLocation(400, 500);
		panel.add(name);
		
		JButton send = new JButton("Send");
		send.setBounds(400, 750, 100, 50);
		
		window.add(panel);
		
		send.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame window2 = new JFrame("Message from " + name.getText());
				window2.setSize(400, 500);
				window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window2.setLayout(new BorderLayout());
				window2.setVisible(true);
				
				JPanel panel2 = new JPanel();
				panel2.setBounds(50, 50, 50, 50);
				panel2.setLayout(null);
				
				JTextField messageD = new JTextField(name.getText() + " : " + message.getText(), 10);
				messageD.setSize(300, 30);
				messageD.setLocation(50, 50);
				messageD.setEditable(false);
				panel2.add(messageD);
				
				JButton playMusic = new JButton("Tunes");
				playMusic.setBounds(150, 300, 100, 50);
				playMusic.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				JButton pauseMusic = new JButton("Pause");
				pauseMusic.setBounds(150, 300, 100, 50);
				pauseMusic.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				try {
			        AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			        final Clip clip = AudioSystem.getClip();
			        clip.open(ais);
			        playMusic.addActionListener(new java.awt.event.ActionListener() {
			            public void actionPerformed(java.awt.event.ActionEvent evt) {
			                clip.start();
			            }
			        });
			        pauseMusic.addActionListener(new java.awt.event.ActionListener() {
			            public void actionPerformed(java.awt.event.ActionEvent evt) {
			                clip.stop();
			            }
			        });
			        
			        }catch(Exception e1){}
				
				
				JButton exit = new JButton("Leave Chat");
				exit.setBounds(275, 400, 100, 50);
				exit.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
						
					}
					
				});
				panel2.add(exit);
				if(addMusic == true){
					panel2.add(playMusic);
				}
				if(addPic == true){
					panel2.add(pic);
				}
				window2.add(panel2);
				
			}
			
		});
		panel.add(send);
		//System.out.println(message.getText());
		
		
	}

}