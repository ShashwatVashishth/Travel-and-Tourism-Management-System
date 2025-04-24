package travel.management.system;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Addp extends JFrame implements ActionListener {
    JLabel user,id,num,name,gender,country,addr,phone,email,namet,usert;
    JTextField tfuser,tfnum,tfname,tfcountr,tfaddr,tfphone,tfmail;
    
    JComboBox comboid;
    JRadioButton male,female;
    JButton add,back;
    String username;
    Addp(String username){
        this.username=username;
        setBounds(250,100,800,480);
        setLayout(null);

        JPanel jp=new JPanel();
        jp.setLayout(null);
        jp.setBounds(0,0,400,480);
        jp.setBackground(Color.gray);
        add(jp);

        user=new JLabel("Username :");
        user.setBounds(20,50,100,20);
        user.setForeground(Color.WHITE);
        user.setFont(new Font("Tahoma",Font.BOLD,15));
        jp.add(user);

        usert=new JLabel("");
        usert.setBounds(160,50,150,20);
        usert.setForeground(Color.WHITE);
        usert.setFont(new Font("Tahoma",Font.BOLD,15));
        jp.add(usert);

        // tfuser=new JTextField();
        // tfuser.setBounds(160,50,150,20);
        // jp.add(tfuser);

        id=new JLabel("ID :");
        id.setBounds(20,80,100,20);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("Tahoma",Font.BOLD,15));
        jp.add(id);


        //dropdown using choice class
        // idc=new Choice();
        // idc.add("Aadhar Card");
        // idc.add("PAN Card");
        // idc.add("Passport");
        // idc.setBounds(160, 80, 100,25);
        // jp.add(idc);

        comboid=new JComboBox<>(new String[]{"Passport","Aadhar Card","PAN Card","Ration Card"});
        comboid.setBounds(160,80,100,25);
        jp.add(comboid);

        num=new JLabel("Number :");
        num.setBounds(20,110,100,20);
        num.setForeground(Color.WHITE);
        num.setFont(new Font("Tahoma",Font.BOLD,15));
        jp.add(num);

        tfnum=new JTextField();
        tfnum.setBounds(160,110,150,20);
        jp.add(tfnum);

        name=new JLabel("Name");
        name.setBounds(20,140,100,20);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma",Font.BOLD,15));
        jp.add(name);

        
        namet=new JLabel("");
        namet.setBounds(160,140,250,20);
        namet.setForeground(Color.WHITE);
        namet.setFont(new Font("Tahoma",Font.BOLD,15));
        jp.add(namet);

        // tfname=new JTextField();
        // tfname.setBounds(160,140,150,20);
        // jp.add(tfname);

        gender=new JLabel("Gender :");
        gender.setBounds(20,170,100,20);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma",Font.BOLD,15));
        jp.add(gender);

        male=new JRadioButton("Male");
        male.setBounds(160,170,70,25);
        jp.add(male);

        female=new JRadioButton("Female");
        female.setBounds(240,170,70,25);
        jp.add(female);

        country=new JLabel("Country :");
        country.setBounds(20,200,100,20);
        country.setForeground(Color.WHITE);
        country.setFont(new Font("Tahoma",Font.BOLD,15));
        jp.add(country);

        tfcountr=new JTextField();
        tfcountr.setBounds(160,200,150,20);
        jp.add(tfcountr);

        addr=new JLabel("Address :");
        addr.setBounds(20,230,100,20);
        addr.setForeground(Color.WHITE);
        addr.setFont(new Font("Tahoma",Font.BOLD,15));
        jp.add(addr);

        tfaddr=new JTextField();
        tfaddr.setBounds(160,230,150,20);
        jp.add(tfaddr);

        phone=new JLabel("Phone :");
        phone.setBounds(20,260,100,20);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("Tahoma",Font.BOLD,15));
        jp.add(phone);

        tfphone=new JTextField();
        tfphone.setBounds(160,260,150,20);
        jp.add(tfphone);

        email=new JLabel("Email :");
        email.setBounds(20,290,100,20);
        email.setForeground(Color.WHITE);
        email.setFont(new Font("Tahoma",Font.BOLD,15));
        jp.add(email);

        tfmail=new JTextField();
        tfmail.setBounds(160,290,150,20);
        jp.add(tfmail);

        add=new JButton("Add");
        add.setBounds(50,340,80,25);
        add.addActionListener(this);
        jp.add(add);

        back=new JButton("Back");
        back.setBounds(250,340,80,25);
        back.addActionListener(this);
        jp.add(back);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i5=i4.getImage().getScaledInstance(900, 500, Image.SCALE_DEFAULT); 
        ImageIcon i6=new ImageIcon(i5);
        JLabel image2=new JLabel(i6);
        image2.setBounds(400, 0, 400, 480);
        add(image2);

        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from account where username='"+username+"'");
            while(rs.next()){
                usert.setText(rs.getString("username"));
                namet.setText(rs.getString("name"));

            }
            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }




        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String username=usert.getText();
            String number=tfnum.getText();
            String id=(String)comboid.getSelectedItem();
            String name=namet.getText();
            String gender=null;
            if(male.isSelected()){
                gender="Male";
            }else{
                gender="Female";
            }
            String country=tfcountr.getText();
            String address=tfaddr.getText();
            String phone=tfphone.getText();
            String email=tfmail.getText();
            try {
                Conn c=new Conn();
                // String query="insert into customer values('"+username+"','"+number+"','"+id+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
                String query = "INSERT INTO customer (username, id, number, name, gender, country, address, email, phone) VALUES ('"
                + username + "', '" + id + "', '" + number + "', '" + name + "', '" + gender + "', '"
                + country + "', '" + address + "', '" + email + "', '" + phone + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer details added Successfully");
                setVisible(false);
            } catch (Exception ae) {
                // TODO: handle exception
                ae.printStackTrace();
            }



        }else{
            setVisible(false);

        }
        
    }
    public static void main(String[] args) {
        new Addp("");
    }
    
    
}
