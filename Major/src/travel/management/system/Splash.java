package travel.management.system;

import javax.swing.*;
import java.awt.*;




public class Splash extends JFrame implements Runnable{
    Thread thread;
    Splash(){
        //setSize(1200,600);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2=i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        setVisible(true);
        //setLocation(50,50);
        thread=new Thread(this);
        thread.start();
        

    }
    public void run(){
        try {
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    public static void main(String args[]) {
        Splash frame=new Splash();
        int x=1;
        for(int i=0;i<=500;x+=7,i+=6){
            frame.setLocation(600-(x+i)/2, 300-(i/2));
            frame.setSize(x+i, i);
            try {
                Thread.sleep(20);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        
    }
}