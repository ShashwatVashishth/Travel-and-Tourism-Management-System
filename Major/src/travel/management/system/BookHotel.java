package travel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BookHotel extends JFrame implements ActionListener{
    JButton cpbtn,bpbtn,backbtn;
    Choice chotel,cac,cfood;
    JLabel head,user1,user2,selecth,totalp,nod,ac,food,id1,id2,num1,num2,phone1,phone2,tp1,tp2;
    TextField tftp,tfnod;
        BookHotel(String username){
        setBounds(200,100,800,500);
        setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/hootel.jpg"));
        Image i2=i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(460, 0, 400, 500);
        add(image);

        head=new JLabel("BOOK HOTEL");
        head.setBounds(50,15,250,25);
        head.setFont(new Font("Tohuma",Font.BOLD,23));
        add(head);

        user1=new JLabel("Username");
        user1.setBounds(10,70,150,20);
        add(user1);
        user2=new JLabel();
        user2.setBounds(190,70,150,20);
        add(user2);

        selecth=new JLabel("Select Hotel");
        selecth.setBounds(10,105,150,20);
        add(selecth);
        chotel=new Choice();
        chotel.setBounds(190,105,150,20);
        add(chotel);
        try {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));

            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

        totalp=new JLabel("Total Persons");
        totalp.setBounds(10,140,150,20);
        add(totalp);
        tftp=new TextField();
        tftp.setBounds(190,140,150,20);
        add(tftp);

        nod=new JLabel("No. of Days");
        nod.setBounds(10,175,150,20);
        add(nod);
        tfnod=new TextField();
        tfnod.setBounds(190,175,150,20);
        add(tfnod);

        ac=new JLabel("AC/Non AC");
        ac.setBounds(10,210,150,20);
        add(ac);
        cac=new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(190,210,150,20);
        add(cac);

        food=new JLabel("Food Included");
        food.setBounds(10,245,150,20);
        add(food);
        cfood=new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(190,245,150,20);
        add(cfood);

        id1=new JLabel("ID");
        id1.setBounds(10,280,150,20);
        add(id1);
        id2=new JLabel();
        id2.setBounds(190,280,150,20);
        add(id2);

        num1=new JLabel("Number");
        num1.setBounds(10,315,150,20);
        add(num1);
        num2=new JLabel();
        num2.setBounds(190,315,150,20);
        add(num2);

        phone1=new JLabel("Phone");
        phone1.setBounds(10,350,150,20);
        add(phone1);
        phone2=new JLabel();
        phone2.setBounds(190,350,150,20);
        add(phone2);

        tp1=new JLabel("Total Price");
        tp1.setBounds(10,385,150,20);
        add(tp1);
        tp2=new JLabel();
        tp2.setBounds(190,385,150,20);
        add(tp2);

        cpbtn=new JButton("Check Price");
        cpbtn.setBounds(25,415,125,20);
        cpbtn.setBackground(Color.BLACK);
        cpbtn.setForeground(Color.WHITE);
        cpbtn.addActionListener(this);
        add(cpbtn);

        bpbtn=new JButton("Book Hotel");
        bpbtn.setBounds(175,415,125,20);
        bpbtn.setBackground(Color.BLACK);
        bpbtn.setForeground(Color.WHITE);
        bpbtn.addActionListener(this);
        add(bpbtn);

        backbtn=new JButton("Back");
        backbtn.setBounds(325,415,125,20);
        backbtn.setBackground(Color.BLACK);
        backbtn.setForeground(Color.WHITE);
        backbtn.addActionListener(this);
        add(backbtn);

        try {
            Conn c=new Conn();
            String query="select * from customer where username = '"+username+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                user2.setText(rs.getString("username"));
                id2.setText(rs.getString("id"));
                num2.setText(rs.getString("number"));
                phone2.setText(rs.getString("phone"));
                
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
            if(e.getSource()==cpbtn){
                try {
                    Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'");
                while(rs.next()){
                    int cost=Integer.parseInt(rs.getString("costperperson"));
                int food=Integer.parseInt(rs.getString("foodincluded"));
                int ac=Integer.parseInt(rs.getString("acroom"));
                int personss=Integer.parseInt(tftp.getText());
                int days=Integer.parseInt(tfnod.getText());
                String acselected=cac.getSelectedItem();
                String foodselected=cfood.getSelectedItem();
                if(personss*days>0){
                    int total=0;
                    total += acselected.equals("AC") ? ac:0;
                    total += foodselected.equals("Yes") ? food:0;
                    total +=cost;
                    total=total*personss*days;
                    tp2.setText("Rs"+total);

                }
                else{
                    JOptionPane.showMessageDialog(null,"Please enter a valid number");
                }
                }

            }
                 catch (Exception ae) {
                    ae.getStackTrace();
                    // TODO: handle exception
                }
                
            
        } 
        else if(e.getSource()==bpbtn){
            try {
                Conn c=new Conn();
                String query="insert into bookhotel values('"+user2.getText()+"','"+chotel.getSelectedItem()+"','"+tftp.getText()+"','"+nod.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+id2.getText()+"','"+num2.getText()+"','"+phone2.getText()+"','"+tp2.getText()+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "HOtel Booked Successfully");
                setVisible(false); 
                
            } catch (Exception ae) {
                ae.printStackTrace();
                // TODO: handle exception
            }
  

        }else{
            setVisible(false);
        }
        
       
        
        
        
    }
    public static void main(String[] args) {
        new BookHotel("shashwat11");
    }
   
    
}
