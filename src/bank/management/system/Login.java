package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JTextField cardtxt;
    JPasswordField pintxt;
    JButton clear,signin,signup;
    
   Login(){
        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
	      	       
        //To make image Scalable
        //  Image is inside java.awt not in javax.swing
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
	       
        //We can add ImageIcon into jLabel but not the Image so we have to convert it into imageIcon
        ImageIcon i3= new ImageIcon(i2);
	       
        JLabel label = new JLabel(i3);	
        label.setBounds(120,20,100,100);	       
        add(label);     
        
        JLabel welcometext = new JLabel("Welcome to Atm");
        welcometext.setFont(new Font("Osward",Font.BOLD,38));
        welcometext.setBounds(240,20,500,100);
        add(welcometext);
        
        JLabel cardnumber = new JLabel("Card No. :");
        cardnumber.setFont(new Font("Osward",Font.BOLD,28));
        cardnumber.setBounds(130,150,300,50);
        add(cardnumber);
        
        JLabel pin= new JLabel("Pin :");
        pin.setFont(new Font("Osward",Font.BOLD,28));
        pin.setBounds(130,200,300,50);
        add(pin);
        
        cardtxt = new JTextField();
        cardtxt.setBounds(270,160,200,30);
        add(cardtxt);
        
        pintxt = new JPasswordField();
        pintxt.setBounds(270,210,200,30);
        add(pintxt);
        
        signin = new JButton("Sign In");
        signin.setBounds(275,265,80,25);
        signin.setForeground(Color.WHITE);
        signin.setBackground(Color.BLACK);
        signin.addActionListener(this);
        add(signin);
        
        clear = new JButton("Clear");
        clear.setBounds(380,265,80,25);
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("Sign Up");
        signup.setBounds(272,305,190,25);
        signup.setForeground(Color.WHITE);
        signup.setBackground(Color.BLACK);
        signup.addActionListener(this);
        add(signup);
        
	          	       
        setSize(800,400) ;	       
        setVisible(true);	     	       
        setLocation(350,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
 
   public void actionPerformed(ActionEvent e){
       if(e.getSource()==clear){
           cardtxt.setText("");
           pintxt.setText("");
       }else if(e.getSource() == signup){
           setVisible(false);
           new SignUpOne().setVisible(true);
       }
   }
   public static void main(String args[]) {	   
       new Login();	  
   }	

  
}


