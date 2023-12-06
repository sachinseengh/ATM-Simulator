
package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


public class BalanceEnquiry extends JFrame implements ActionListener {
    String pin;
    JButton exit;

    BalanceEnquiry(String pinval){
        this.pin=pinval;
        System.out.println(pin);
        setLayout(null);
        
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
        
        
        JLabel text= new JLabel();
        text.setBounds(180,300,700,35);
        //To Add Text on the image
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
        exit= new JButton("Back");
        exit.setBounds(415,520,100,30);
        exit.addActionListener(this);
        image.add(exit);
        
        try{
            Conn c= new Conn();
            
        ResultSet rs = c.s.executeQuery("select * from bank where pin='"+pin+"'");
        int balance =0;
        while(rs.next()){
            if(rs.getString("type").equals("Deposit")){
                balance += Integer.parseInt(rs.getString("amount"));
            }else{
                balance -= Integer.parseInt(rs.getString("amount"));
            }
        }
        
        text.setText("Your balance is  Rs "+balance+".");
        
        
        }catch(Exception ae){
            ae.printStackTrace();
        }
              
        
        setSize(900,900);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }
 
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
