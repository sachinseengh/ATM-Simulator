
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class MiniStatement extends JFrame {

    String pin;
    JLabel transaction;
    
 MiniStatement(String pinval){
     this.pin=pinval;
     setTitle("Mini statement");
     
     setLayout(null);
     
     
        JLabel name=new JLabel("ATM Simulator");
        name.setBounds(210,25,300,20);
        name.setFont(new Font("Railway",Font.BOLD,22));
        add(name);
        
          JLabel mini=new JLabel("Mini Statement");
        mini.setBounds(240,50,300,20);
        mini.setFont(new Font("Railway",Font.PLAIN,15));
        add(mini);
        
        
        JLabel card=new JLabel();
        card.setBounds(100,100,350,20);
        card.setFont(new Font("Railway",Font.BOLD,20));
        add(card);
        
       JLabel transaction= new JLabel();
       transaction.setBounds(100,160,550,15);
        transaction.setFont(new Font("Railway",Font.PLAIN,13));
        add(transaction);
        
         JLabel text= new JLabel();
       text.setBounds(100,330,550,15);
        text.setFont(new Font("Railway",Font.PLAIN,13));
        add(text);
     
     try{
         Conn c= new Conn();
         String query="select * from login where pin='"+pin+"' ";
         
         ResultSet rs = c.s.executeQuery(query);
         while(rs.next()){
             card.setText("Card No : "+rs.getString("cardno").substring(0,4)+"XXXXXXXXX"
                     +rs.getString("cardno").substring(6));
         }
         
         String query2="select * from bank where pin='"+pin+"' order by date desc limit 5";
         int x=160;
          ResultSet rs2 = c.s.executeQuery(query2);
         while(rs2.next()){
          
        transaction= new JLabel();
        transaction.setBounds(100,x,550,15);
        transaction.setFont(new Font("Railway",Font.PLAIN,13));
        add(transaction);
        transaction.setText(rs2.getString("date")+"      "+rs2.getString("type")+"           "+
        rs2.getString("amount") );
         
        x=x+30;
          
            
         }
         
         
        ResultSet rs3 = c.s.executeQuery("select * from bank where pin='"+pin+"'");
        int balance =0;
        while(rs3.next()){
            if(rs3.getString("type").equals("Deposit")){
                balance += Integer.parseInt(rs3.getString("amount"));
            }else{
                balance -= Integer.parseInt(rs3.getString("amount"));
            }
        }
        
        text.setText("Your balance is  Rs "+balance+".");
        
         
     }catch(Exception e){
         e.printStackTrace();
     }
     
     
     
     
//     
     
     setSize(600,600);
     setLocation(20,20);
     getContentPane().setBackground(Color.white);
     setVisible(true);
 }
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
