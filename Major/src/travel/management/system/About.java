package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame implements ActionListener{
    JButton back;
    About(){
        setBounds(200,150,500,450);
        setLayout(null);

        JLabel l1=new JLabel("ABOUT");
        l1.setBounds(200,10,150,40);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);
        
        String s="hello";

        TextArea area=new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 70, 450, 250);
        add(area);

        back=new JButton("Back");
        back.setBounds(200, 340, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    public static void main(String[] args) {
        new About();
    }
    
    
}
