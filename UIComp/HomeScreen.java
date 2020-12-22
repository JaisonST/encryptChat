//package UIComp;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.util.*;

class Chat{
	String sender; 
	String receiver; 
	String text; 
	String id; 
	public Chat(HashMap<String, String> m, String idNum){
		sender = m.get("sender");
		receiver = m.get("receiver"); 
		text = m.get("text"); 
		id = idNum;
	}

	public String getText() {
        	return text;
    	} 

	public boolean isSender(){
		if(id.equals(sender))
			return true; 
		return false; 
	}
}

class ChatRender extends JTextArea implements ListCellRenderer<Chat>{
    final JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    final JLabel lt = new JLabel();
    String preR = "<html><body style='width: 300px; text-align:right;margin-right:10px;'>";
    String preL = "<html><body style='width: 300px; text-align:left;margin-left:10px;'>";

    ChatRender(){
	p.setBackground(Color.white);
	lt.setBackground(new Color(0xe6efff));
	lt.setOpaque(true);
   	lt.setBorder(BorderFactory.createLineBorder(Color.black)); 
	p.add(lt);
    }
    	@Override
	public Component getListCellRendererComponent(JList list, Chat val, int index,
        boolean isSelected, boolean cellHasFocus){
	
	Chat c = (Chat) val; 
	FlowLayout l = new FlowLayout();	
	final String text = c.getText();
 
	if(c.isSender()){
		l.setAlignment(FlowLayout.LEFT); 	
		p.setLayout(l);            
		lt.setText(preL + text); 
	}
	else{
		l.setAlignment(FlowLayout.RIGHT); 	
		p.setLayout(l);            
		lt.setText(preR + text); 
	}
 

	return p; 

    }
     
}

class Contact{
	String fid;
	String fname; 
	String chatid; 

	public Contact(HashMap<String, String> m){
		fid = m.get("fid");
		fname = m.get("fname"); 
		chatid = m.get("chatid"); 
	}

	public String getName(){
		return fname; 
	}

}

class ContactRender extends JTextArea implements ListCellRenderer<Contact>{
     
        @Override
        public Component getListCellRendererComponent(JList list, Contact val, int index,
        boolean isSelected, boolean cellHasFocus){
        
        Contact c = (Contact) val;
	JLabel j = new JLabel();
	j.setText(val.getName());
	if(isSelected){

	}
	return j;  
        
    }
 
}

	class HomeScreen1 extends JFrame{
		JButton logout = new JButton("Logout");
		JButton send = new JButton("Send");
			
		JTextField encrypKey = new JTextField(20);
		JTextField text = new JTextField(10);
		
		DefaultListModel<Chat> chatList =  new DefaultListModel<Chat>(); 
		JList chats = new JList(chatList); 
		DefaultListModel<Contact> contactList =  new DefaultListModel<Contact>(); 
		JList contacts = new JList(contactList); 
		HomeScreen1(){
			
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				setTitle("Chats");

				setLayout(null);
	
				setSize(1400,800);
				setResizable(false);
				setVisible(true);

				//ENCRYPNET LABEL WITH LOGOUT BUTTON
				JPanel titlePanel = new JPanel();
				titlePanel.setBackground(new Color(29, 0, 102));
				titlePanel.setBounds(0,0,1400,80);
				titlePanel.setVisible(true);
				titlePanel.setLayout(null);

				JLabel title = new JLabel("Encrypnet");
				title.setBounds(10,10,1400,60);

				title.setOpaque(true);
		
				title.setBackground(new Color(29, 0, 102));
				title.setForeground(Color.WHITE);

				Font titleFont = new Font("Serif", Font.PLAIN, 50);
				title.setFont(titleFont);

				//LOGOUT BUTTON
				logout.setBounds(1200, 10, 120, 60);
				logout.setBackground(Color.WHITE);
				logout.setForeground(Color.BLUE);
				
				Font logoutFont = new Font("Serif", Font.PLAIN, 25);
				logout.setFont(logoutFont);


				titlePanel.add(logout);	
				titlePanel.add(title);

				//BANK PERSONAL PANEL 
			
				JScrollPane scrollContacts = new JScrollPane(contacts);
				scrollContacts.setBackground(new Color(170, 147, 250));
				scrollContacts.setBounds(0,80, 450, 790);
				add(scrollContacts);		
				contacts.setCellRenderer(new ContactRender());

				//TEXTFIELD FOR TEXT
				text.setBounds(10, 600, 800, 40);
				text.setVisible(true);

				//SEND BUTTON 
				send.setBackground(new Color(50, 80, 250));
				send.setBounds(820, 600, 100, 40);
				send.setForeground(Color.WHITE);
				
				Font sendFont = new Font("Serif", Font.PLAIN, 28);	
				send.setFont(sendFont);			
	
				//MAIN PANEL
				JPanel main = new JPanel();
				main.setBounds(451, 80, 1100, 920);
				main.setBackground(new Color(81, 121, 252));
				main.setLayout(null);
			
				main.add(text);
				main.add(send);
			
				//ENCRYPTION KEY LABEL 
				JLabel encryp = new JLabel("Enter Key: ");
				encryp.setBounds(7, 4, 200, 50);
				encryp.setForeground(Color.WHITE);

				Font keyFont = new Font("Serif", Font.PLAIN, 33);
				encryp.setFont(keyFont);

				//ENCRYPTION KEY TEXTFIELD
				encrypKey.setBounds(250,4,650,50);

				encrypKey.setFont(keyFont);
				
				encrypKey.setBackground(Color.WHITE);
				encrypKey.setVisible(true);
	
				main.add(encryp);
				main.add(encrypKey);
	
				add(titlePanel);
				//add(bankPersonal);
				add(main);			
				
				//CHAT PANEL SCROLLABLE 
				JScrollPane scrollChats = new JScrollPane(chats);
				scrollChats.setBounds(0,60,934,530);
				main.add(scrollChats);	
				chats.setCellRenderer(new ChatRender());

		}

		public void setChats(ArrayList<HashMap<String,String>> A, String id){
			chatList = new DefaultListModel<Chat>(); 
			for(HashMap<String, String> M : A){
				Chat c = new Chat(M,id);
				chatList.addElement(c);  
			}
			chats.setModel(chatList); 
			this.repaint();
		}

		public void setContacts(ArrayList<HashMap<String,String>> A){
			contactList = new DefaultListModel<Contact>(); 
			for(HashMap<String, String> M : A){
				Contact c = new Contact(M);
				contactList.addElement(c);  
			}
			contacts.setModel(contactList); 
			//this.repaint();

		}
	}	

	class HomeScreen{
		public static void main(String ar[]){
			HomeScreen1 home = new HomeScreen1();
			home.repaint();

			HashMap<String, String> SampleSet = new HashMap<String,String>();
			SampleSet.put("sender","1234");
			SampleSet.put("receiver","123");
			SampleSet.put("text","text1");

			HashMap<String, String> SampleSet2 = new HashMap<String,String>();
			SampleSet2.put("sender","123");
			SampleSet2.put("receiver","1234");
			SampleSet2.put("text","text2");

			ArrayList<HashMap<String,String>> L = new ArrayList<HashMap<String,String>>();
			L.add(SampleSet);
			L.add(SampleSet2);

			HashMap<String,String> Contact1 = new HashMap<String,String>(); 
			Contact1.put("fid","abcd@yahoo.com");
			Contact1.put("fname", "Sania");
			Contact1.put("chatid", "C01");

			HashMap<String,String> Contact2 = new HashMap<String,String>(); 
			Contact2.put("fid","ad@yahoo.com");
			Contact2.put("fname", "Jaison");
			Contact2.put("chatid", "C02");

			
			ArrayList<HashMap<String,String>> C = new ArrayList<HashMap<String,String>>();
			C.add(Contact1);
			C.add(Contact2);

			home.setChats(L,"1234");
			home.setContacts(C);  
		}
	}	
		
	
