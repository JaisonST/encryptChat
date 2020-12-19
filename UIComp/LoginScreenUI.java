package UIComp;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

	public class LoginScreenUI extends JFrame{

		public JButton btn = new JButton("Login");
		public JTextField username = new JTextField(10);
		public JPasswordField password = new JPasswordField(10);
		public JPanel login = new JPanel();

		JLabel invalid = new JLabel("Invalid login credentials!");

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
	 				
			login.setSize(600,430);			

			login.setBackground(new Color(209, 225, 255, 80));
			login.setForeground(Color.BLACK);

			login.setLayout(null);
			login.setBounds(100, 150, 600, 430);
			
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

			Font placeholderFont = new Font("Serif", Font.PLAIN, 20);

			JLabel uname = new JLabel("Username");
			JLabel pass = new JLabel("Password");
	
			uname.setBounds(150,160,300,20);
			username.setBounds(150,190,300,30);

			pass.setBounds(150,240, 300, 20);
			password.setBounds(150,270,300,30);

			uname.setFont(placeholderFont);
			pass.setFont(placeholderFont);

			Font buttonFont = new Font("Serif", Font.PLAIN, 20);
			btn.setBounds(175,320,250,30);
			btn.setBackground(new Color(50, 80, 250));
			btn.setForeground(Color.WHITE);
			btn.setFont(buttonFont);
	
			//INVALID MESSAGE 
			Font invalidFont = new Font("Serif", Font.PLAIN, 20);
			invalid.setForeground(Color.RED);
			invalid.setBounds(210,360, 400, 40);
			invalid.setVisible(false);
			invalid.setFont(invalidFont);	

			login.add(icon);	
			login.add(uname);
			login.add(username);
			login.add(pass);
			login.add(password);	
			login.add(btn);
			login.add(invalid);

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

		public void setError(boolean val){
			invalid.setVisible(val);
			this.repaint();
		}
	}


