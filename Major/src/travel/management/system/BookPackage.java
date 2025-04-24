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
import javax.swing.JTextField;

public class BookPackage extends JFrame implements ActionListener{
    JButton cpbtn,bpbtn,backbtn;
    JTextField tftotalp;
    JComboBox combopack;
    JLabel head,user1,user2,selectpack,totalp,id1,num1,phone1,tp1,id2,tp2,phone2,num2;
    String username;
    BookPackage(String username){
        this.username =username;
        setBounds(250,100,800,600);
        setBackground(Color.WHITE);
        setLayout(null);

        head=new JLabel("BOOK PACKAGE");
        head.setBounds(50,10,250,30);
        head.setFont(new Font("Tuhoma",Font.BOLD,23));
        add(head);

        user1=new JLabel("Username");
        user1.setBounds(10,70,150,20);
        user1.setFont(new Font("Tuhoma",Font.PLAIN,15));
        add(user1);
        user2=new JLabel();
        user2.setBounds(190,70,100,20);
        user2.setFont(new Font("Tuhoma",Font.PLAIN,15));
        add(user2);

        selectpack=new JLabel("Select Package");
        selectpack.setBounds(10,110,150,20);
        selectpack.setFont(new Font("Tuhoma",Font.PLAIN,15));
        add(selectpack);
        combopack=new JComboBox<>(new String[]{"Gold Package","Silver Package","Bronze Package"});
        combopack.setBounds(190,110,150,25);
        add(combopack);

        totalp=new JLabel("Total Persons");
        totalp.setBounds(10,150,150,20);
        totalp.setFont(new Font("Tuhoma",Font.PLAIN,15));
        add(totalp);
        tftotalp=new JTextField("1");
        tftotalp.setBounds(190,150,150,25);
        add(tftotalp);

        id1=new JLabel("ID");
        id1.setBounds(10,190,150,20);
        id1.setFont(new Font("Tuhoma",Font.PLAIN,15));
        add(id1);
        id2=new JLabel();
        id2.setBounds(190,190,100,20);
        id2.setFont(new Font("Tuhoma",Font.PLAIN,15));
        add(id2);

        num1=new JLabel("Number");
        num1.setBounds(10,230,150,20);
        num1.setFont(new Font("Tuhoma",Font.PLAIN,15));
        add(num1);
        num2=new JLabel();
        num2.setBounds(190,230,100,20);
        num2.setFont(new Font("Tuhoma",Font.PLAIN,15));
        add(num2);

        phone1=new JLabel("Phone");
        phone1.setBounds(10,270,150,20);
        phone1.setFont(new Font("Tuhoma",Font.PLAIN,15));
        add(phone1);
        phone2=new JLabel();
        phone2.setBounds(190,270,100,20);
        phone2.setFont(new Font("Tuhoma",Font.PLAIN,15));
        add(phone2);

        tp1=new JLabel("Total Price");
        tp1.setBounds(10,310,150,20);
        tp1.setFont(new Font("Tuhoma",Font.PLAIN,15));
        add(tp1);
        tp2=new JLabel();
        tp2.setBounds(190,310,100,20);
        tp2.setFont(new Font("Tuhoma",Font.PLAIN,15));
        add(tp2);

        cpbtn=new JButton("Check Price");
        cpbtn.setBounds(25,410,125,20);
        cpbtn.setBackground(Color.BLACK);
        cpbtn.setForeground(Color.WHITE);
        cpbtn.addActionListener(this);
        add(cpbtn);

        bpbtn=new JButton("Book Package");
        bpbtn.setBounds(175,410,125,20);
        bpbtn.setBackground(Color.BLACK);
        bpbtn.setForeground(Color.WHITE);
        bpbtn.addActionListener(this);
        add(bpbtn);

        backbtn=new JButton("Back");
        backbtn.setBounds(325,410,125,20);
        backbtn.setBackground(Color.BLACK);
        backbtn.setForeground(Color.WHITE);
        backbtn.addActionListener(this);
        add(backbtn);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 700, Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500, 10, 250, 500);
        add(image);


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
        if(e.getSource()==backbtn){
            setVisible(false);
        }else if(e.getSource()==cpbtn){
            int cost=0;
            String pack=(String) combopack.getSelectedItem(); 
            if(pack.equals("Gold Package")){
                cost+=15000;
            }else if(pack.equals("Silver Package")){
                cost+=10000;

            }else{
                cost+=7500;

            }
            int persons=Integer.parseInt(tftotalp.getText());
            cost*=persons;
            tp2.setText("Rs "+ cost);
            

        }else{
            try {
                Conn c=new Conn();
                String query="insert into bookpackage values('"+user2.getText()+"','"+combopack.getSelectedItem()+"','"+tftotalp.getText()+"','"+id2.getText()+"','"+num2.getText()+"','"+phone2.getText()+"','"+tp2.getText()+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false); 
                
            } catch (Exception ae) {
                ae.printStackTrace();
                // TODO: handle exception
            }


        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    public static void main(String[] args) {
        new BookPackage("shashwat11");
    }
   
    
}
