package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CheckPackage extends JFrame {
    CheckPackage(){
        
        setBounds(200,100,800,500);
        String[] Package1={"GOLD PACKAGE","Features-","--Airport Assistance","--Daily Buffet","--English Speaking Guide","--6 days and 7 nights","--Full Travel Insaurance","--Summer Special","Only Rs 15000","package1.jpg"};
        String[] Package2={"SILVER PACKAGE","Features-","--Airport Assistance","--Two times Buffet","--English Speaking Guide","--4 days and 4 nights","--Free Kayaking","--Summer Special","Only Rs 10000","package2.jpg"};
        String[] Package3={"BRONZE PACKAGE","Features-","--Airport Assistance","--One time Buffet","--English Speaking Guide","--2 days and 3 nights","--Free Boating","--Summer Special","Only Rs 7500","package3.jpg"};

        JTabbedPane tab=new JTabbedPane();

        
        JPanel jp1 =createPackage(Package1);
        tab.addTab("Package1",null,jp1);
        
        JPanel jp2 =createPackage(Package2);
        tab.addTab("Package2",null,jp2);
        
        JPanel jp3 =createPackage(Package3);
        tab.addTab("Package3",null,jp3);
        add(tab);



        setVisible(true);
    }
    public JPanel createPackage(String[] pack){
        JPanel jp1=new JPanel();
        jp1.setLayout(null);
        jp1.setBackground(Color.WHITE);

        JLabel jl1=new JLabel(pack[0]);
        jl1.setBounds(20,5,300,25);
        jl1.setFont(new Font("Tahoma",Font.BOLD,25));
        jp1.add(jl1);

        JLabel jl2=new JLabel(pack[1]);
        jl2.setBounds(20,50,200,25);
        jl2.setFont(new Font("Tahoma",Font.BOLD,20));
        jp1.add(jl2);

        JLabel jl3=new JLabel(pack[2]);
        jl3.setBounds(20,90,200,25);
        jl3.setFont(new Font("Tahoma",Font.BOLD,16));
        jp1.add(jl3);

        JLabel jl4=new JLabel(pack[3]);
        jl4.setBounds(20,115,200,25);
        jl4.setFont(new Font("Tahoma",Font.BOLD,16));
        jp1.add(jl4);

        JLabel jl5=new JLabel(pack[4]);
        jl5.setBounds(20,140,250,25);
        jl5.setFont(new Font("Tahoma",Font.BOLD,16));
        jp1.add(jl5);

        JLabel jl6=new JLabel(pack[5]);
        jl6.setBounds(20,165,250,25);
        jl6.setFont(new Font("Tahoma",Font.BOLD,16));
        jp1.add(jl6);

        JLabel jl7=new JLabel(pack[6]);
        jl7.setBounds(20,190,250,25);
        jl7.setFont(new Font("Tahoma",Font.BOLD,16));
        jp1.add(jl7);

        JLabel jl8=new JLabel(pack[7]);
        jl8.setBounds(20,260,350,30);
        jl8.setFont(new Font("Tahoma",Font.BOLD,26));
        jp1.add(jl8);

        JLabel jl9=new JLabel(pack[8]);
        jl9.setBounds(250,350,350,30);
        jl9.setFont(new Font("Tahoma",Font.BOLD,26));
        jp1.add(jl9);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[9]));
        Image i2=i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(300, 10, 500, 300);
        jp1.add(image);
        return jp1;
    }
    public static void main(String[] args) {
        new CheckPackage();
    }
    
}
