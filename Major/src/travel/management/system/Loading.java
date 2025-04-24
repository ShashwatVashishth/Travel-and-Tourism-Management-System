package travel.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Loading extends JFrame implements Runnable{
    String username;
    Thread t;
    JProgressBar bar;
    public void run(){
        try {
            for(int i=1;i<=101;i++){
                int max=bar.getMaximum();
                int value=bar.getValue();
                if(value<max){
                    bar.setValue(bar.getValue()+1);
                }
                else{
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);

            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

    }
    Loading(String username){
        this.username=username;
        t=new Thread(this);
        setBounds(300,100,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("Travel and Tourism Application");
        text.setBounds(50,10,550,100);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);

        bar=new JProgressBar();
        bar.setBounds(70,100,500,30);
        bar.setStringPainted(true);
        add(bar);

        JLabel name=new JLabel("Welcome "+ username);
        name.setBounds(250,150,550,100);
        name.setForeground(Color.red);
        name.setFont(new Font("Raleway",Font.BOLD,15));
        add(name);
        t.start();

        setVisible(true);

        
        

    }
    public static void main(String[] args) {
        new Loading("");
    }
    
}
