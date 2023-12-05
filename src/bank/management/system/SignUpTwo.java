
package bank.management.system;

/**
 *
 * @author sachi
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
//import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

import java.awt.event.*;
public class SignUpTwo extends JFrame implements ActionListener{
    
    JComboBox religions,category,education,income;
    
    
    

    JButton next,back;
    JRadioButton senioryes,seniorno;
     String formno;
    
    
    SignUpTwo(String formno){
        setLayout(null);
        this.formno= formno;
       
       System.out.println(formno);
        
     
        JLabel personaldetails= new JLabel("Page 2: Additional  Details");
       personaldetails.setBounds(270,60 , 500,50 );
       personaldetails.setFont(new Font("Railway",Font.BOLD,20));
        add(personaldetails);
        
        JLabel religion= new JLabel("Religion"); 
       religion.setBounds(150,170 , 500,30 );
       religion.setFont(new Font("Railway",Font.BOLD,18));
        add(religion);
        
        String religionValues[]={"Choose Religion","Hindu","Muslim","Others"};
        religions= new JComboBox(religionValues);
        religions.setBounds(380,170,300,30);
        religions.setBackground(Color.white);
        add(religions); 
        
        JLabel fname= new JLabel("Category");
       fname.setBounds(150,220 , 500,30 );
       fname.setFont(new Font("Railway",Font.BOLD,18));
        add(fname);
        
         String categoryValues[]={"Individual","Company","Others"};
        category= new JComboBox(categoryValues);
       category.setBounds(380,220,300,30);
        category.setBackground(Color.white);
        add(category); 
        
        
        JLabel dob= new JLabel("Education :");
       dob.setBounds(150,270 , 500,30 );
       dob.setFont(new Font("Railway",Font.BOLD,18));
        add(dob);
        
        
         String educationValues[]={"UnderGraduate","Graduate","Others"};
        education= new JComboBox(educationValues);
       education.setBounds(380,270,300,30);
        education.setBackground(Color.white);
        add(education); 





        
        JLabel email= new JLabel("Income :");
       email.setBounds(150,320 , 500,30 );
       email.setFont(new Font("Railway",Font.BOLD,18));
        add(email);
        
          String incomeValues[]={"UnEmployed",">50000","<500000","Others"};
        income= new JComboBox(incomeValues);
       income.setBounds(380,320,300,30);
        income.setBackground(Color.white);
        add(income); 
        
       
        
       JLabel senior= new JLabel("Senior Citizen :");
       senior.setBounds(150,370 , 500,30 );
       senior.setFont(new Font("Railway",Font.BOLD,18));
        add(senior);
        
        senioryes= new JRadioButton("Yes");
        senioryes.setBounds(380,370,70,30);
       senioryes.setBackground(Color.WHITE);
        add(senioryes); 
        
        seniorno= new JRadioButton("No");
        seniorno.setBounds(480,370,120,30);
        seniorno.setBackground(Color.WHITE);
        add(seniorno); 
        
        ButtonGroup bg= new ButtonGroup();
        bg.add(senioryes);
        bg.add(seniorno);
        
        
        
        
        next= new JButton("Next");
        next.setBounds(580,620,100,25);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        add(next);
        
        
        back= new JButton("back");
        back.setBounds(150,620,100,25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        
        
        
        
        
        
        
        
        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setVisible(true);
        setLocation(350,30);
    }
public void actionPerformed(ActionEvent ae){
    
    if(ae.getSource()==next){
  
    
  
   
   
   String religionval =(String) religions.getSelectedItem();
   String categoryval= (String)category.getSelectedItem();
   
   
   String seniorval= null;
   if(senioryes.isSelected()){
       seniorval= "Yes";
   }else if(seniorno.isSelected()){
       seniorval="No";
   }
   
   String educationval=(String)education.getSelectedItem();
   String incomeval=(String)income.getSelectedItem();
         
   
   try{
       if(religionval.equals("")){
           //Do the same for other filed as well;
           JOptionPane.showMessageDialog(null,"Religion is Empty");
       }else{
           Conn c = new Conn();
           String query ="insert into signupTwo(formno,religion,category,income,education,senior) "
                   + "values('"+formno+"','"+religionval+"','"+categoryval+"','"+incomeval+"','"+educationval+"','"
                  +seniorval+"')";
           
           c.s.executeUpdate(query);
           
           
           
           
           setVisible(false);
           new SignUpThree(formno).setVisible(true);
       }
   }catch(Exception e){
       System.out.println(e);
   }
    }else if(ae.getSource()==back){
        setVisible(false);
        new SignUpOne().setVisible(true);
    }
       
}

    
    public static void main(String args[]) {
        new SignUpTwo("");
    }
}
