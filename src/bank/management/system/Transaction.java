
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,balanceenquiry,ministatement,exit,pinchange;
String pinval;
    Transaction(String pin){
        setLayout(null);
        this.pinval=pin;
        
        
        //Image is inside awt package
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
	      	       
        //To make image Scalable
        //  Image is inside java.awt not in javax.swing
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
	       
        //We can add ImageIcon into jLabel but not the Image so we have to convert it into imageIcon
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text= new JLabel("Please Select your Transaction");
        text.setBounds(210,300,700,35);
        //To Add Text on the image
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,400,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,440,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,480,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        
        withdrawl = new JButton("Cash Withdrawl");
       withdrawl.setBounds(350,400,150,30);
       pinchange.addActionListener(this);
        image.add(withdrawl);
        
        ministatement= new JButton("Mini Statement");
       ministatement.setBounds(350,440,150,30);
       ministatement.addActionListener(this);
        image.add(ministatement);
        
        balanceenquiry= new JButton("Balance Enquiry");
        balanceenquiry.setBounds(350,480,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit= new JButton("Exit");
        exit.setBounds(350,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        setLocation(350,0);
        setSize(900,900);
        //Remove the options from top
//        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            
        }else if(ae.getSource()==withdrawl){
            
        }else if(ae.getSource()==fastcash){
            
        }else if(ae.getSource()==withdrawl){
            
        }else if(ae.getSource()==pinchange){
            
        }else if(ae.getSource()==ministatement){
            
        }else if(ae.getSource()==exit){
            System.exit(0);
        }
    }
  
    public static void main(String args[]) {
       new Transaction("");
    }
}
