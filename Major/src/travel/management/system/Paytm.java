package travel.management.system;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Paytm extends JFrame {
    Paytm(){
        setBounds(200,100,700,500);
        JEditorPane pane =new JEditorPane();
        pane.setEditable(false);
        try {
            pane.setPage("https://paytm.com/rent-payment");

        } catch (Exception e) {
            pane.setContentType("text/html");
            pane.setText("<html>Could not load ,please try again later! </html>");
           
        }
        JScrollPane sp=new JScrollPane(pane);
        getContentPane().add(sp);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new Paytm();
    }
    
}
