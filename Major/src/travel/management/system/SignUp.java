package travel.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUp extends JFrame implements ActionListener {
    JButton b1,b2;
    JTextField tfuser,tfname,tfpass,tfans;
    Choice secq;
    SignUp(){
        //for main frame
        setLocation(300, 100);
        setSize(800, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //first panel
        JPanel jp=new JPanel();
        jp.setBackground(new Color(131,193,233));
        jp.setBounds(0, 0, 450, 400);
        jp.setLayout(null);
        add(jp);
        
        //username
        JLabel lbluser=new JLabel("Username");
        lbluser.setBounds(50,25,100,25);
        lbluser.setFont(new Font("SAN_SARIF", Font.PLAIN, 15));
        jp.add(lbluser); 
        //username textfield
        tfuser=new JTextField();
        tfuser.setBounds(175, 25, 200, 25);
        tfuser.setBorder(BorderFactory.createEmptyBorder());
        jp.add(tfuser);
        //Name
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(50,75,100,25);
        lblname.setFont(new Font("SAN_SARIF", Font.PLAIN, 15));
        jp.add(lblname); 
        //name textfield
        tfname=new JTextField();
        tfname.setBounds(175, 75, 200, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        jp.add(tfname);
        //passwrod
        JLabel lblpass=new JLabel("Password");
        lblpass.setBounds(50,125,100,25);
        lblpass.setFont(new Font("SAN_SARIF", Font.PLAIN, 15));
        jp.add(lblpass); 
        //pass textfield
        tfpass=new JTextField();
        tfpass.setBounds(175, 125, 200, 25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        jp.add(tfpass);
        //security question
        JLabel lblsecq=new JLabel("Securtiy Question");
        lblsecq.setBounds(50,175,100,25);
        lblsecq.setFont(new Font("SAN_SARIF", Font.PLAIN, 15));
        jp.add(lblsecq);
        //dropdown using choice class
        secq=new Choice();
        secq.add("Favourite movie");
        secq.add("Your age");
        secq.add("Pet name");
        secq.setBounds(175, 175, 150,25);
        jp.add(secq);
        //answer
        JLabel lblans=new JLabel("Password");
        lblans.setBounds(50,225,100,25);
        lblans.setFont(new Font("SAN_SARIF", Font.PLAIN, 15));
        jp.add(lblans); 
        //answer textfield
        tfans=new JTextField();
        tfans.setBounds(175, 225, 200, 25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        jp.add(tfans);
        //CREATE button
        b1=new JButton("Create");
        b1.setBounds(70,290,100,23);
        b1.setBackground(Color.WHITE);
        b1.setForeground(new Color(133,193,233));
        b1.addActionListener(this);
        jp.add(b1);
        //Back button
        b2=new JButton("Back");
        b2.setBounds(280,290,100,23);
        b2.setBackground(Color.WHITE);
        b2.setForeground(new Color(133,193,233));
        b2.addActionListener(this);
        jp.add(b2);
        //image on right side
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450, 0, 350, 400);
        add(image);




        setVisible(true);
        
    
    }
    //button actionlistener task
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            String username=tfuser.getText();
            String name=tfname.getText();
            String password=tfpass.getText();
            String security=secq.getSelectedItem();
            String answer=tfans.getText();
            String query="insert into account values('"+username+"','"+name+"','"+password+"','"+security+"','"+answer+"')";
            try {
                Conn c=new Conn();
                //step4-executing sql query
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account created Successfully ");
                setVisible(false);
                new Login();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        }else if(ae.getSource()==b2){
            setVisible(false);
            new Login();
        }

        }
        // TODO Auto-generated method stub
        
    
    public static void main(String[] args) {
        new SignUp();
    }
    
    
}
