package travel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ForgetPass extends JFrame implements ActionListener{
    JTextField tfuser,tfname,tfsecq,tfans,tfpass;
    JButton b1,b2,b3;
    ForgetPass(){
        //for main frame
        setLocation(300, 100);
        setSize(750, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //image on right
        //image on right side
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(470, 0, 250, 400);
        add(image);
        //left panel
        JPanel jp=new JPanel();
        jp.setLayout(null);
        jp.setBounds(25,25,400,300);
        add(jp);
        //username
        JLabel lbluser=new JLabel("Username");
        lbluser.setBounds(25,15,80,20);
        jp.add(lbluser);
        //usertextfield
        tfuser=new JTextField();
        tfuser.setBounds(150,15,140,20);
        jp.add(tfuser);
        //search button
        b1=new JButton("Search");
        b1.setBounds(300,15,90,20);
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        jp.add(b1);
        //name
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(25,50,80,20);
        jp.add(lblname);
        //name tf
        tfname=new JTextField();
        tfname.setBounds(150,50,140,20);
        jp.add(tfname);
        //secq
        JLabel lblsecq=new JLabel("Security Question");
        lblsecq.setBounds(25,85,120,20);
        jp.add(lblsecq);
        //secqtf
        tfsecq=new JTextField();
        tfsecq.setBounds(150,85,140,20);
        jp.add(tfsecq);
        //answer
        JLabel lblans=new JLabel("Answer");
        lblans.setBounds(25,120,100,20);
        jp.add(lblans);
        //anstf
        tfans=new JTextField();
        tfans.setBounds(150,120,140,20);
        jp.add(tfans);
        //retrieve button
        b2=new JButton("Retrieve");
        b2.setBounds(300,120,90,20);
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        jp.add(b2);
        //password
        JLabel lblpass=new JLabel("Password");
        lblpass.setBounds(25,155,100,20);
        jp.add(lblpass);
        //passtf
        tfpass=new JTextField();
        tfpass.setBounds(150,155,140,20);
        jp.add(tfpass);
        //back button
        b3=new JButton("Back");
        b3.setBounds(155,200,90,20);
        b3.setBackground(Color.DARK_GRAY);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        jp.add(b3);


        setVisible(true);
       


    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            try {
                String query="select * from account where username = '"+tfuser.getText()+"'";
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfsecq.setText(rs.getString("security"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(ae.getSource()==b2){
            try {
                String query="select * from account where answer = '"+tfans.getText()+"' AND username='"+tfuser.getText()+"'";
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfpass.setText(rs.getString("password"));
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else {
            setVisible(false);
            new Login();

        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    public static void main(String[] args) {
        new ForgetPass();
    }
    
    
    
}
