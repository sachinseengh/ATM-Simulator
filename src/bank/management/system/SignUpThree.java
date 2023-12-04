
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignUpThree extends JFrame implements ActionListener{
    long random;
    JRadioButton saving,fixed,current,recurring;
    JButton submit;
    JCheckBox atm,mobile,cheque,internet,email,estatement,agree;
    String formno;
    JLabel cardval;
    JPasswordField pinval;
    
    SignUpThree(String formnos){
        setLayout(null);
        formno=formnos;
        
        JLabel AccountDetails = new JLabel("Page 3: Account Details");
        AccountDetails.setBounds(250,30,300,30);
        AccountDetails.setFont(new Font("Railway",Font.BOLD,18));
        add(AccountDetails);
        
        
        JLabel accountType = new JLabel("Account Type:");
        accountType.setBounds(100,100,300,30);
        accountType.setFont(new Font("Railway",Font.BOLD,19));
        add(accountType);
        
        saving= new JRadioButton("Saving Accout");
        saving.setBounds(100,135,200,30);
        saving.setFont(new Font("Railway",Font.BOLD,14));
        add(saving);
        
        current= new JRadioButton("Current Accout");
        current.setBounds(100,170,200,30);
        current.setFont(new Font("Railway",Font.BOLD,14));
        add(current);
        
        fixed= new JRadioButton("Fixed Accout");
        fixed.setBounds(400,170,200,30);
        fixed.setFont(new Font("Railway",Font.BOLD,14));
        add(fixed);
        
        recurring= new JRadioButton("Fixed Accout");
        recurring.setBounds(400,135,200,30);
        recurring.setFont(new Font("Railway",Font.BOLD,14));
        add(recurring);
        
        
        ButtonGroup bg= new ButtonGroup();
        bg.add(saving);
        bg.add(current);
        bg.add(fixed);
        bg.add(recurring);
        
        
        
        JLabel cardno = new JLabel("Card Number : ");
        cardno.setBounds(100,220,400,60);
        cardno.setFont(new Font("Railway",Font.BOLD,25));
        add(cardno);
        
        
        Random ran= new Random();
        random=Math.abs((ran.nextLong()%9000000000L)+1000000000L);
        
         cardval = new JLabel(""+random);
        cardval.setBounds(370,220,400,60);
        cardval.setFont(new Font("Railway",Font.BOLD,30));
        add(cardval);
        
        JLabel carddet = new JLabel("Your 16 Digit Card Number");
        carddet.setBounds(100,260,400,20);
        carddet.setFont(new Font("Railway",Font.BOLD,10));
        add(carddet);
        
        JLabel pinno = new JLabel("Create PIN : ");
        pinno.setBounds(100,300,400,60);
        pinno.setFont(new Font("Railway",Font.BOLD,25));
        add(pinno);
        
        JLabel pindet = new JLabel("Your 4 Digit Pin ");
        pindet.setBounds(100,345,400,10);
        pindet.setFont(new Font("Railway",Font.BOLD,10));
        add(pindet);
        
        pinval=new JPasswordField();
        pinval.setBounds(360,300,200,50);
        add(pinval);
        
       
        JLabel services= new JLabel("Services Required :");
        services.setBounds(100,400,300,30);
        services.setFont(new Font("Railway",Font.BOLD,20));
        add(services);
        
       atm= new JCheckBox("ATM Card");
        atm.setBounds(100,445,300,30);
        atm.setFont(new Font("Railway",Font.BOLD,16));
        add(atm);
        
        mobile= new JCheckBox("Mobile Banking");
        mobile.setBounds(100,490,300,30);
        mobile.setFont(new Font("Railway",Font.BOLD,16));
        add(mobile);
       
      
       
        cheque= new JCheckBox("Cheque Book");
        cheque.setBounds(100,535,300,30);
        cheque.setFont(new Font("Railway",Font.BOLD,16));
        add(cheque);
        
        internet= new JCheckBox("Internet Banking");
        internet.setBounds(400,445,200,30);
        internet.setFont(new Font("Railway",Font.BOLD,16));
        add(internet);
        
       email= new JCheckBox("Email & SMS Alerts");
        email.setBounds(400,490,200,30);
        email.setFont(new Font("Railway",Font.BOLD,16));
        add(email);
        
         estatement= new JCheckBox("E-Statement");
        estatement.setBounds(400,535,200,30);
        estatement.setFont(new Font("Railway",Font.BOLD,16));
        add(estatement);
        
        
        
        
         agree= new JCheckBox(" I hereby declares that the above entered details are correct to the best of my knowledge");
        agree.setBounds(100,600,800,30);
        agree.setFont(new Font("Railway",Font.BOLD,12));
        add(agree);
        
        submit= new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(280,650,100,30);
        submit.addActionListener(this);
        add(submit);
         
        
        
        setVisible(true);
        setLocation(350,50);
        setSize(700,750);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            
            System.out.println(formno);
            
            String account=null;
            if(saving.isSelected()){
                account="Saving";
            }else if(current.isSelected()){
                account="Current";
            }else if(fixed.isSelected()){
                account="Fixed";
            }else if(recurring.isSelected()){
                account="Recurring";
            }
            
            String card=cardval.getText();
            char[] pins=pinval.getPassword();
            String pinn= new String();
            String pin= pinn.valueOf(pins);
            System.out.println(pin);
            
            String atmval=null;
            if(atm.isSelected()){
                 atmval="Yes";
            }else{
                atmval="No";
            }
            String internetval=null;
            if(internet.isSelected()){
                 internetval="Yes";
            }else{
               internetval="No";
            }
             String emailval=null;
            if(email.isSelected()){
                 emailval="Yes";
            }else{
                emailval="No";
            }
             String chequeval=null;
            if(cheque.isSelected()){
                 chequeval="Yes";
            }else{
                chequeval="No";
            }
             String mobileval=null;
            if(mobile.isSelected()){
                 mobileval="Yes";
            }else{
                mobileval="No";
            }
             String estatementval=null;
            if(estatement.isSelected()){
                 estatementval="Yes";
            }else{
                estatementval="No";
            }
            
          try{  
           //inserting in database 
            if(agree.isSelected()){
                Conn c= new Conn();

                
                String query = "insert into signupthree(formno, account,card, pin, atm, mobile, internet, email, estatement, cheque) "
             + "values ('" + formno + "','" + account + "','" + card + "','" + pin + "','" + atmval + "','"
             + mobileval + "','" + internetval + "','" + emailval + "','" + estatementval + "','" + chequeval + "')";

                 
                
                c.s.executeUpdate(query);
                
                setVisible(false);
                
                
                
                
            }else{
                JOptionPane.showMessageDialog(null,"Please Agree to the Commitment ");
            }
          }catch(Exception e){
//              
e.printStackTrace();
          }
            
        }
    }


    public static void main(String args[]) {
     new SignUpThree("");
    }
}
