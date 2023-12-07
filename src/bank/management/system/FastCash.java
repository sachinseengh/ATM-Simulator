
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,balanceenquiry,ministatement,exit,pinchange;
String pinval;
    FastCash(String pin){
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
        
        
        JLabel text= new JLabel("Select Withdrawl Amount");
        text.setBounds(250,300,700,35);
        //To Add Text on the image
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
        deposit = new JButton("Rs 500");
        deposit.setBounds(170,400,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,440,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        pinchange = new JButton("Rs 2000");
        pinchange.setBounds(170,480,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        
        withdrawl = new JButton("Rs 5000");
       withdrawl.setBounds(350,400,150,30);
       withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        ministatement= new JButton("Rs 10000");
       ministatement.setBounds(350,440,150,30);
       ministatement.addActionListener(this);
        image.add(ministatement);
        
        balanceenquiry= new JButton("Rs 25000");
        balanceenquiry.setBounds(350,480,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit= new JButton("Back");
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
      
        if(ae.getSource()==exit){
          setVisible(false);
          new Transaction(pinval).setVisible(true);
        }else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            
            try{
                Conn c= new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pin='"+pinval+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() !=exit && balance< Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"InSufficient Balance");
                    return;
                }else{
                    Date date = new Date();
                    String query="insert into bank (pin,date,type,amount) values ('"+pinval+"','"+date+"','Withdraw','"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Rs "+amount+"Withdrawl Successfully");
            setVisible(false);
            new Transaction(pinval).setVisible(true);
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
  
    public static void main(String args[]) {
       new FastCash("");
    }
}
