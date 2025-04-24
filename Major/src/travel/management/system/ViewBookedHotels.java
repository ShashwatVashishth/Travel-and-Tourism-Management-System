package travel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewBookedHotels extends JFrame implements ActionListener{
    JButton back;
    ViewBookedHotels(String username){
        setBounds(200,50,800,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel userl=new JLabel("Username");
        userl.setBounds(30,40,100,15);
        add(userl);
        JLabel user2=new JLabel("");
        user2.setBounds(150,40,100,15);
        add(user2);

        JLabel id1=new JLabel("ID");
        id1.setBounds(30,85,100,15);
        add(id1);
        JLabel id2=new JLabel("");
        id2.setBounds(150,85,100,15);
        add(id2);

        JLabel num1=new JLabel("Number");
        num1.setBounds(30,130,100,15);
        add(num1);
        JLabel num2=new JLabel("");
        num2.setBounds(150,130,100,15);
        add(num2);

        JLabel name1=new JLabel("Hotel Name");
        name1.setBounds(30,175,100,15);
        add(name1);
        JLabel name2=new JLabel("");
        name2.setBounds(150,175,100,15);
        add(name2);

        JLabel per1=new JLabel("Total Persons");
        per1.setBounds(30,220,100,15);
        add(per1);
        JLabel per2=new JLabel("");
        per2.setBounds(150,220,100,15);
        add(per2);

        JLabel price1=new JLabel("Price");
        price1.setBounds(500,40,100,15);
        add(price1);
        JLabel price2=new JLabel("");
        price2.setBounds(620,40,100,15);
        add(price2);

        JLabel days1=new JLabel("Total days");
        days1.setBounds(500,85,100,15);
        add(days1);
        JLabel days2=new JLabel("");
        days2.setBounds(620,85,100,15);
        add(days2);

        JLabel ac1=new JLabel("AC/Non-AC");
        ac1.setBounds(500,130,100,15);
        add(ac1);
        JLabel ac2=new JLabel("");
        ac2.setBounds(620,130,100,15);
        add(ac2);

        JLabel food1=new JLabel("Food");
        food1.setBounds(500,175,100,15);
        add(food1);
        JLabel food2=new JLabel("");
        food2.setBounds(620,175,150,15);
        add(food2);

        back=new JButton("Back");
        back.setBounds(300,325,100,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(20, 380, 500, 150);
        add(image);

        try {
            Conn c=new Conn();
            String query="select * from bookhotel where username = '"+username+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                user2.setText(rs.getString("username"));
                id2.setText(rs.getString("id"));
                num2.setText(rs.getString("number"));
                name2.setText(rs.getString("name"));
                per2.setText(rs.getString("persons"));
                days2.setText(rs.getString("days"));
                ac2.setText(rs.getString("ac"));
                food2.setText(rs.getString("food"));
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
        new ViewBookedHotels("shashwat11");
    }
   
    
}
