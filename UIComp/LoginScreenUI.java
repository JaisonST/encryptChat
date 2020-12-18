package UIComp;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

	public class LoginScreenUI extends JFrame{

		public JButton btn = new JButton("Login");

		public LoginScreenUI(){
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("Encrypnet");

			setLayout(null);

			setSize(1600,1000);
			setVisible(false);

			JPanel encrypnet = new JPanel();
			JPanel loginPanel = new JPanel();
			
			//HOME PANEL
			encrypnet.setSize(800,1500);
			encrypnet.setLayout(null);
			encrypnet.setBounds(0,0,800,1500);
			encrypnet.setBackground(new Color(50, 80, 250));
			
			//Background for the panel
			//BACKGROUND IMAGE
			ImageIcon backgroundImg = new ImageIcon("loginBackground.jpg");
			
			//Resizing the image
			Image img = backgroundImg.getImage();
			Image resize = img.getScaledInstance(800,1500,img.SCALE_SMOOTH);
			backgroundImg = new ImageIcon(resize);
			JLabel background = new JLabel("", backgroundImg, JLabel.LEFT);
			background.setBounds(0,0, 800, 1500);

			//encrypnet.add(background);

			//Icon 
			ImageIcon ChatImg = new ImageIcon("chaticon.png");
			
			//Resizing the image
			Image chatIcon = ChatImg.getImage();
			Image resizeChat = chatIcon.getScaledInstance(300,300, chatIcon.SCALE_SMOOTH);
			ChatImg = new ImageIcon(resizeChat);
			JLabel iconChat = new JLabel("", ChatImg, JLabel.LEFT);
			iconChat.setBounds(200, 200, 300, 300);
			
			encrypnet.add(iconChat);

			//Encrypnet Label
			JLabel ChatTitle = new JLabel("Encrypnet");
			Font plainFont = new Font("Serif", Font.PLAIN, 70);
			ChatTitle.setFont(plainFont);
			ChatTitle.setBounds(200,500, 300, 90);
			ChatTitle.setForeground(Color.WHITE);
			
			encrypnet.add(ChatTitle);
			
			//LOGIN PANEL
			loginPanel.setSize(800,1500);
			loginPanel.setLayout(null);
			loginPanel.setBounds(750, 0, 800, 1500);
			loginPanel.setBackground(Color.WHITE);		
	 
			JPanel login = new JPanel();				
			login.setSize(600,400);			

			login.setBackground(new Color(209, 225, 255, 80));
			login.setForeground(Color.BLACK);

			login.setLayout(null);
			login.setBounds(100, 200, 600, 400);
			
			//LOGIN TITLE 
			JLabel title = new JLabel("         Login");
			title.setBounds(0,0,1600,100);

			//Label needs to be opaque for the color to appear 
			title.setOpaque(true);

			title.setBackground(Color.WHITE);
			title.setForeground(new Color(50, 80, 250));

			
			Font titleFont = new Font("Serif", Font.PLAIN, 70);
			title.setFont(titleFont);

			//Login Icon
			ImageIcon loginImg = new ImageIcon("login.png");
			
			//Resizing the icon
			Image logImg = loginImg.getImage();
			Image resizeLog = logImg.getScaledInstance(100,100,logImg.SCALE_SMOOTH);
			loginImg = new ImageIcon(resizeLog);
			JLabel icon = new JLabel("", loginImg, JLabel.LEFT);
			icon.setBounds(250,50,100,100);	

			JTextField username = new JTextField(10);
			username.setBounds(150,170,300,30);
			JPasswordField password = new JPasswordField(10);
			password.setBounds(150,250,300,30);

			Font buttonFont = new Font("Serif", Font.PLAIN, 20);
			btn.setBounds(175,320,250,30);
			btn.setBackground(new Color(50, 80, 250));
			btn.setForeground(Color.WHITE);
			btn.setFont(buttonFont);
	
			login.add(icon);
			login.add(username);
			login.add(password);	
			login.add(btn);


			//Border for the JPanel
			Border blackline = BorderFactory.createLineBorder(Color.black);

			
			login.setVisible(true);

			loginPanel.add(title);
			loginPanel.add(login);

			add(loginPanel);
			add(encrypnet);
		}

		public void isVisible(boolean val){
			setVisible(val); 
		}
	}


