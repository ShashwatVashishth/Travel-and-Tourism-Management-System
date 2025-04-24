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
import javax.swing.JOptionPane;

public class DeleteDetails extends JFrame implements ActionListener{
    JButton back;
    String username;
    DeleteDetails(String username){
        this.username=username;
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

        JLabel name1=new JLabel("Name");
        name1.setBounds(30,175,100,15);
        add(name1);
        JLabel name2=new JLabel("");
        name2.setBounds(150,175,100,15);
        add(name2);

        JLabel gen1=new JLabel("Gender");
        gen1.setBounds(30,220,100,15);
        add(gen1);
        JLabel gen2=new JLabel("");
        gen2.setBounds(150,220,100,15);
        add(gen2);

        JLabel countr1=new JLabel("Country");
        countr1.setBounds(500,40,100,15);
        add(countr1);
        JLabel country2=new JLabel("");
        country2.setBounds(620,40,100,15);
        add(country2);

        JLabel address1=new JLabel("Address");
        address1.setBounds(500,85,100,15);
        add(address1);
        JLabel address2=new JLabel("");
        address2.setBounds(620,85,100,15);
        add(address2);

        JLabel phone1=new JLabel("Phone");
        phone1.setBounds(500,130,100,15);
        add(phone1);
        JLabel phone2=new JLabel("");
        phone2.setBounds(620,130,100,15);
        add(phone2);

        JLabel email1=new JLabel("Email");
        email1.setBounds(500,175,100,15);
        add(email1);
        JLabel email2=new JLabel("");
        email2.setBounds(620,175,150,15);
        add(email2);

        back=new JButton("Delete");
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
            String query="select * from customer where username = '"+username+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                user2.setText(rs.getString("username"));
                id2.setText(rs.getString("id"));
                num2.setText(rs.getString("number"));
                name2.setText(rs.getString("name"));
                gen2.setText(rs.getString("gender"));
                country2.setText(rs.getString("country"));
                address2.setText(rs.getString("address"));
                phone2.setText(rs.getString("phone"));
                email2.setText(rs.getString("email"));

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
                Conn c=new Conn();
                c.s.executeUpdate("delete from account where username = '"+username+"'");
                c.s.executeUpdate("delete from customer where username = '"+username+"'");
                c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
                c.s.executeUpdate("delete from bookhotel where username = '"+username+"'");

                JOptionPane.showMessageDialog(null,"Data deleted Scuccessfully!");
                setVisible(false);
            }
            
        } catch (Exception ae) {
            ae.getStackTrace();
            // TODO: handle exception
        }
        // TODO Auto-generated method stub
        
    }
    public static void main(String[] args) {
        new DeleteDetails("shashwat11");
    }
   
    
}
