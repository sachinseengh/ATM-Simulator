
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

import java.util.Date;
public class Withdrawl extends JFrame implements ActionListener {
    JButton withdrawbtn;
        JButton back;
        JTextField withdraw;
        String pin;
        String amount;

    Withdrawl(String pinval){
        this.pin=pinval;
        
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
        
        
        
        JLabel text= new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(230,300,300,20);
        text.setForeground(Color.white);
        image.add(text);
        
        withdraw= new JTextField();
       withdraw.setBounds(190,330,300,40);
       withdraw.setFont(new Font("Railway",Font.BOLD,22));
       image.add(withdraw);
        
       
       withdrawbtn= new JButton("Withdraw");
       withdrawbtn.setBounds(390,390,100,30);
       withdrawbtn.addActionListener(this);
       image.add(withdrawbtn);
       
       
       back= new JButton("Back");
       back.setBounds(280,390,100,30);
       back.addActionListener(this);
       image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==withdrawbtn){
        
         amount = withdraw.getText();
//        Date is inside util package
        Date date = new Date();
        if(amount.equals("")){
                        JOptionPane.showMessageDialog(null, "Please Enter the amount");
                        return;
        }else if(!isNumeric(amount)){
               JOptionPane.showMessageDialog(null, "Amount must be numeric");
        }else{
              try{
                Conn c= new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pin='"+pin+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                System.out.println(balance);
                if(ae.getSource() !=back && (balance < Integer.parseInt(amount))){
                    JOptionPane.showMessageDialog(null,"InSufficient Balance");
                    return;
                }else{
                    
                    String query="insert into bank (pin,date,type,amount)values ('"+pin+"','"+date+"','Withdraw','"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Rs "+amount+"Withdrawl Successfully");
            setVisible(false);
            new Transaction(pin).setVisible(true);
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
    }else if(ae.getSource()==back){
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }
}
 
private boolean isNumeric(String str) {
    return str.matches("\\d+");
    }
 
    public static void main(String args[]) {
     new Withdrawl("");
    }

    
}
