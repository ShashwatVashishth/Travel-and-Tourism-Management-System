package travel.management.system;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Payments extends JFrame implements ActionListener {
    JButton pay,back;
    Payments(){
        setBounds(300,100,700,500);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2=i1.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 700, 500);
        add(image);

        pay=new JButton("Pay");
        pay.setBounds(20,20,100,20);
        pay.addActionListener(this);
        image.add(pay);
        back=new JButton("Back");
        back.setBounds(550,20,100,20);
        back.addActionListener(this);
        image.add(back);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==pay){
        setVisible(false);
        new Paytm();

       }else{
        setVisible(false);
       }
    }
    public static void main(String[] args) {
        new Payments();
    }
    
    
}
