package travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
    JButton signup,login,fp;
    JTextField tfpass,tfuser;
    Login(){
        setLocation(300, 100);
        setSize(700, 400);
        setLayout(null);
        //for first panel
        JPanel jp=new JPanel();
        
        jp.setBackground(new Color(131,193,233));
        jp.setBounds(0, 0, 350, 400);

        add(jp);
        //adding image to first panel
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400, 300, 100, 100);
        jp.add(image);
        //for second panel
        JPanel jp2=new JPanel();
        jp2.setLayout(null);
        jp2.setBounds(350,30,350,300);
        
        add(jp2);
        //adding credentials in second panel
        //username
        JLabel lbluser=new JLabel("USERNAME");
        lbluser.setBounds(60,20,100,25);
        lbluser.setFont(new Font("SAN_SARIF", Font.PLAIN, 15));
        jp2.add(lbluser); 
        //username textfield
        tfuser=new JTextField();
        tfuser.setBounds(60, 43, 200, 25);
        tfuser.setBorder(BorderFactory.createEmptyBorder());
        jp2.add(tfuser);
        //password
        JLabel lblpass=new JLabel("PASSWORD");
        lblpass.setBounds(60,73,100,25);
        lblpass.setFont(new Font("SAN_SARIF", Font.PLAIN, 15));
        jp2.add(lblpass); 
        //password textfield
        tfpass=new JTextField();
        tfpass.setBounds(60, 100, 200, 25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        jp2.add(tfpass);
        //login button
        login=new JButton("Login");
        login.setBounds(60,160,100,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        jp2.add(login);
        //signup button
        signup=new JButton("SignUp");
        signup.setBounds(180,160,100,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        jp2.add(signup);
        //forget password button
        fp=new JButton("Forget Password");
        fp.setBounds(110,210,150,30);
        fp.setBackground(new Color(133,193,233));
        fp.setForeground(Color.WHITE);
        fp.addActionListener(this);
        jp2.add(fp);


        

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==login){
            try {
                String username=tfuser.getText();
                String password=tfpass.getText();
                String query="select * from account where username = '"+username+"' AND password = '"+password+"'";
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                }
                else{
                    JOptionPane.showMessageDialog(null, "incorret username or password");
                }
            } catch (Exception e) {
                e.printStackTrace();;
            }

        }else if(ae.getSource()==signup){
            setVisible(false);
            new SignUp();
        }
        else{
            setVisible(false);
            new ForgetPass();
        }
        
    }
    public static void main(String[] args) {
        new Login();
        
    }
   
    
}
