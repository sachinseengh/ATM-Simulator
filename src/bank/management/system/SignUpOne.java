
package bank.management.system;

/**
 *
 * @author sachi
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

import java.awt.event.*;
public class SignUpOne extends JFrame implements ActionListener{
    
    JButton next;
    
    SignUpOne(){
        setLayout(null);
        
        Random ran = new Random();
       long random=Math.abs(ran.nextLong()%9000L+1000L);
       
       JLabel formno= new JLabel("Application Form No. "+random);
       formno.setBounds(150,20 , 500,50 );
       formno.setFont(new Font("Railway",Font.BOLD,38));
        add(formno);
        
     
        JLabel personaldetails= new JLabel("Page 1 : Personal Details");
       personaldetails.setBounds(260,80 , 500,50 );
       personaldetails.setFont(new Font("Railway",Font.BOLD,20));
        add(personaldetails);
        
        JLabel name= new JLabel("Name :");
       name.setBounds(150,170 , 500,30 );
       name.setFont(new Font("Railway",Font.BOLD,18));
        add(name);
        
         JTextField nametxt= new JTextField();
        nametxt.setBounds(380,170,300,30);
        add(nametxt); 
        
        JLabel fname= new JLabel("Father's Name :");
       fname.setBounds(150,220 , 500,30 );
       fname.setFont(new Font("Railway",Font.BOLD,18));
        add(fname);
        
         JTextField fnametxt= new JTextField();
        fnametxt.setBounds(380,220,300,30);
        add(fnametxt); 
        
        JLabel dob= new JLabel("Date of Birth :");
       dob.setBounds(150,270 , 500,30 );
       dob.setFont(new Font("Railway",Font.BOLD,18));
        add(dob);
        
//         JTextField domtxt= new JTextField();

    JDateChooser domtxt = new JDateChooser();
    domtxt.setBounds(380, 270, 300, 30);
    add(domtxt);


        
        JLabel email= new JLabel("Email :");
       email.setBounds(150,320 , 500,30 );
       email.setFont(new Font("Railway",Font.BOLD,18));
        add(email);
        
         JTextField emailtxt= new JTextField();
        emailtxt.setBounds(380,320,300,30);
        add(emailtxt); 
        
          JLabel marital= new JLabel("Marital Status :");
       marital.setBounds(150,370 , 500,30 );
       marital.setFont(new Font("Railway",Font.BOLD,18));
        add(marital);
        
        JRadioButton marriedtxt = new JRadioButton("Married");
        marriedtxt.setBounds(380,370,70,30);
        marriedtxt.setBackground(Color.WHITE);
        add(marriedtxt); 
        
          JRadioButton unmarriedtxt = new JRadioButton("Unmarried");
        unmarriedtxt.setBounds(480,370,120,30);
        unmarriedtxt.setBackground(Color.WHITE);
        add(unmarriedtxt); 
        
        ButtonGroup bg= new ButtonGroup();
        bg.add(marriedtxt);
        bg.add(unmarriedtxt);
        
         JLabel city= new JLabel("City :");
       city.setBounds(150,420 , 500,30 );
       city.setFont(new Font("Railway",Font.BOLD,18));
        add(city);
        
         JTextField citytxt= new JTextField();
        citytxt.setBounds(380,420,300,30);
        add(citytxt); 
        
         JLabel state = new JLabel("State :");
       state.setBounds(150,470 , 500,30 );
       state.setFont(new Font("Railway",Font.BOLD,18));
        add(state);
        
         JTextField statetxt= new JTextField();
        statetxt.setBounds(380,470,300,30);
        add(statetxt); 
        
        
        
         JLabel address = new JLabel("Address :");
     address .setBounds(150,520 , 500,30 );
       address .setFont(new Font("Railway",Font.BOLD,18));
        add(address );
        
        JTextField addresstxt= new JTextField();
        addresstxt.setBounds(380,520,300,30);
        add(addresstxt); 
        
        JLabel pincode= new JLabel("Pincode:");
     pincode .setBounds(150,570 , 500,30 );
       pincode .setFont(new Font("Railway",Font.BOLD,18));
        add(pincode);
        
         JTextField pincodetxt= new JTextField();
        pincodetxt.setBounds(380,570,300,30);
        add(pincodetxt); 
        
        
        
        next = new JButton("Next");
        next.setBounds(580,620,100,25);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        add(next);
        
        
        
        
        
        
        
        
        
        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setVisible(true);
        setLocation(350,30);
    }
public void actionPerformed(ActionEvent e){
    if(e.getSource()==next){
        
    }
}
    
    public static void main(String args[]) {
        new SignUpOne();
    }
}
