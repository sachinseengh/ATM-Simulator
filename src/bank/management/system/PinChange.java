
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class PinChange extends JFrame implements ActionListener {
    JButton depositbtn;
        JButton back;
        JPasswordField npin,cpin;
        String pin;

   PinChange(String pinval){
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
        
        
        
        JLabel text= new JLabel("New Pin");
        text.setBounds(190,300,300,20);
        text.setFont(new Font("Railway",Font.BOLD,10));
        text.setForeground(Color.white);
        image.add(text);
        
        npin= new JPasswordField();
       npin.setBounds(190,330,300,40);
       npin.setFont(new Font("Railway",Font.BOLD,22));
       image.add(npin);
        
       JLabel text2= new JLabel("Confirm Pin");
        text2.setBounds(190,390,300,20);
        text2.setFont(new Font("Railway",Font.BOLD,10));
        text2.setForeground(Color.white);
        image.add(text2);
        
        cpin= new JPasswordField();
       cpin.setBounds(190,420,300,40);
       cpin.setFont(new Font("Railway",Font.BOLD,22));
       image.add(cpin);
        
       
       
       
       
       
       depositbtn= new JButton("Change");
       depositbtn.setBounds(390,490,100,30);
       depositbtn.addActionListener(this);
       image.add(depositbtn);
       
       
       back= new JButton("Back");
       back.setBounds(280,490,100,30);
       back.addActionListener(this);
       image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==depositbtn){
        
       
        char []confirm=cpin.getPassword();
        char []newpin=npin.getPassword();
        
        String npinval=String.valueOf(newpin);
        String confirmval=String.valueOf(confirm);
        
        
        if(npinval.equals(confirmval)){
            
            try{
            Conn c = new Conn();
            String query="update signupthree set pin='"+npinval+"' where pin='"+pin+"'";
            String query2="update login set pin='"+npinval+"' where pin='"+pin+"'";
            String query3="update bank set pin ='"+npinval+"' where pin='"+pin+"'";
            
            
            c.s.executeUpdate(query);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            
            setVisible(false);
            new Transaction(pin).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
            
            
            
            
        }else{
            JOptionPane.showMessageDialog(null,"Pin Doesn't Match");
        }
     
    }else if(ae.getSource()==back){
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }
}
 
    public static void main(String args[]) {
     new PinChange("");
    }

    
}
