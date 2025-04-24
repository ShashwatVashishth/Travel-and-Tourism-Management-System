package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewPackage extends JFrame implements ActionListener{
    JButton back;
    ViewPackage(String username){
        setBounds(200,50,800,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel head=new JLabel("View Package Details");
        head.setBounds(20,0,300,27);
        head.setFont(new Font("Tuhoma",Font.BOLD,25));
        add(head);

        JLabel userl=new JLabel("Username");
        userl.setBounds(30,50,100,15);
        add(userl);
        JLabel user2=new JLabel("");
        user2.setBounds(150,50,100,15);
        add(user2);

        JLabel pack1=new JLabel("Package");
        pack1.setBounds(30,95,100,15);
        add(pack1);
        JLabel pack2=new JLabel("");
        pack2.setBounds(150,95,100,15);
        add(pack2);

        JLabel tp1=new JLabel("Total Persons");
        tp1.setBounds(30,140,100,15);
        add(tp1);
        JLabel tp2=new JLabel("");
        tp2.setBounds(150,140,100,15);
        add(tp2);

        JLabel id1=new JLabel("ID");
        id1.setBounds(30,185,100,15);
        add(id1);
        JLabel id2=new JLabel("");
        id2.setBounds(150,185,100,15);
        add(id2);

        JLabel num1=new JLabel("Number");
        num1.setBounds(30,230,100,15);
        add(num1);
        JLabel num2=new JLabel("");
        num2.setBounds(150,230,100,15);
        add(num2);

        JLabel phone1=new JLabel("Phone");
        phone1.setBounds(30,275,100,15);
        add(phone1);
        JLabel phone2=new JLabel("");
        phone2.setBounds(150,275,100,15);
        add(phone2);

        JLabel price1=new JLabel("Price");
        price1.setBounds(30,320,100,15);
        add(price1);
        JLabel price2=new JLabel("");
        price2.setBounds(150,320,100,15);
        add(price2);

       

        back=new JButton("Back");
        back.setBounds(300,385,100,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(300, 30, 500, 350);
        add(image);

        try {
            Conn c=new Conn();
            String query="select * from bookpackage where username = '"+username+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                user2.setText(rs.getString("username"));
                id2.setText(rs.getString("id"));
                num2.setText(rs.getString("number"));
                pack2.setText(rs.getString("package"));
                tp2.setText(rs.getString("persons"));
                phone2.setText(rs.getString("phone"));
                price2.setText(rs.getString("price"));
                

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==back){
                setVisible(false);
            }
            
        } catch (Exception ae) {
            ae.getStackTrace();
            // TODO: handle exception
        }
        // TODO Auto-generated method stub
        
    }
    public static void main(String[] args) {
        new ViewPackage("shashwat11");
    }
   
    
}
