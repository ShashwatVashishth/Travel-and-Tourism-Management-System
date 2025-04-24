package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dashboard extends JFrame implements ActionListener{
    JButton apd,upd,vpd,dpd,cp,bp,vp,vh,bh,vbh,dest,pay,calc,note,about;
    String username;
    Dashboard(String username){
        this.username=username;
        //setBounds(0,0,1800,680);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel jp1=new JPanel();
        jp1.setLayout(null);
        jp1.setBounds(0,0,1800,70);
        jp1.setBackground(new Color(0,0,102));
        add(jp1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(4, 2, 70, 70);
        jp1.add(image);

        JLabel heading=new JLabel("DASHBOARD");
        heading.setBounds(100,0,200,100);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        jp1.add(heading);

        JPanel jp2=new JPanel();
        jp2.setLayout(null);
        jp2.setBounds(0,70,300,690);
        jp2.setBackground(new Color(0,0,102));
        add(jp2);

        apd=new JButton("Add Personal Details");
        apd.setBounds(0,0,300,46);
        //apd.setBackground(new Color(133,193,233));
        apd.setFont(new Font("Thaoma",Font.BOLD,20));
        apd.setForeground(Color.BLACK);
        apd.addActionListener(this);
        jp2.add(apd);

        upd=new JButton("Update Personal Details");
        upd.setBounds(0,46,300,46);
        //apd.setBackground(new Color(133,193,233));
        upd.setFont(new Font("Thaoma",Font.BOLD,20));
        upd.setForeground(Color.BLACK);
        upd.addActionListener(this);
        jp2.add(upd);

        vpd=new JButton("View Details");
        vpd.setBounds(0,92,300,46);
        //apd.setBackground(new Color(133,193,233));
        vpd.setFont(new Font("Thaoma",Font.BOLD,20));
        vpd.setForeground(Color.BLACK);
        vpd.addActionListener(this);
        jp2.add(vpd);

        dpd=new JButton("Delete Personal Details");
        dpd.setBounds(0,138,300,46);
        //apd.setBackground(new Color(133,193,233));
        dpd.setFont(new Font("Thaoma",Font.BOLD,20));
        dpd.setForeground(Color.BLACK);
        dpd.addActionListener(this);
        jp2.add(dpd);

        cp=new JButton("Check Package");
        cp.setBounds(0,184,300,46);
        //apd.setBackground(new Color(133,193,233));
        cp.setFont(new Font("Thaoma",Font.BOLD,20));
        cp.setForeground(Color.BLACK);
        cp.addActionListener(this);
        jp2.add(cp);

        bp=new JButton("Book Package");
        bp.setBounds(0,230,300,46);
        //apd.setBackground(new Color(133,193,233));
        bp.setFont(new Font("Thaoma",Font.BOLD,20));
        bp.setForeground(Color.BLACK);
        bp.addActionListener(this);
        jp2.add(bp);

        vp=new JButton("View Package");
        vp.setBounds(0,276,300,46);
        //apd.setBackground(new Color(133,193,233));
        vp.setFont(new Font("Thaoma",Font.BOLD,20));
        vp.setForeground(Color.BLACK);
        vp.addActionListener(this);
        jp2.add(vp);

        vh=new JButton("View Hotels");
        vh.setBounds(0,322,300,46);
        //apd.setBackground(new Color(133,193,233));
        vh.setFont(new Font("Thaoma",Font.BOLD,20));
        vh.addActionListener(this);
        vh.setForeground(Color.BLACK);
        jp2.add(vh);

        bh=new JButton("Book Hotels");
        bh.setBounds(0,368,300,46);
        //apd.setBackground(new Color(133,193,233));
        bh.setFont(new Font("Thaoma",Font.BOLD,20));
        bh.setForeground(Color.BLACK);
        bh.addActionListener(this);
        jp2.add(bh);

        vbh=new JButton("View Booked Hotels");
        vbh.setBounds(0,414,300,46);
        //apd.setBackground(new Color(133,193,233));
        vbh.setFont(new Font("Thaoma",Font.BOLD,20));
        vbh.setForeground(Color.BLACK);
        vbh.addActionListener(this);
        jp2.add(vbh);

        dest=new JButton("Destinations");
        dest.setBounds(0,460,300,46);
        //apd.setBackground(new Color(133,193,233));
        dest.setFont(new Font("Thaoma",Font.BOLD,20));
        dest.setForeground(Color.BLACK);
        dest.addActionListener(this);
        jp2.add(dest);

        pay=new JButton("Payment");
        pay.setBounds(0,506,300,46);
        //apd.setBackground(new Color(133,193,233));
        pay.setFont(new Font("Thaoma",Font.BOLD,20));
        pay.setForeground(Color.BLACK);
        pay.addActionListener(this);
        jp2.add(pay);

        calc=new JButton("Calculator");
        calc.setBounds(0,552,300,46);
        //apd.setBackground(new Color(133,193,233));
        calc.setFont(new Font("Thaoma",Font.BOLD,20));
        calc.setForeground(Color.BLACK);
        calc.addActionListener(this);
        jp2.add(calc);

        // note=new JButton("Notepad");
        // note.setBounds(0,598,300,46);
        // //apd.setBackground(new Color(133,193,233));
        // note.setFont(new Font("Thaoma",Font.BOLD,20));
        // note.setForeground(Color.BLACK);
        // jp2.add(note);

        about=new JButton("About");
        about.setBounds(0,598,300,46);
        //apd.setBackground(new Color(133,193,233));
        about.setFont(new Font("Thaoma",Font.BOLD,20));
        about.setForeground(Color.BLACK);
        about.addActionListener(this);
        jp2.add(about);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5=i4.getImage().getScaledInstance(1600, 700, Image.SCALE_DEFAULT); 
        ImageIcon i6=new ImageIcon(i5);
        JLabel image2=new JLabel(i6);
        image2.setBounds(0, 0, 1600, 700);
        add(image2);

        JLabel text=new JLabel("Travel And Tourism Management System");
        text.setFont(new Font("Thaoma",Font.BOLD,35));
        text.setBounds(470,50,1000,100);
        image2.add(text);
        

        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==apd){
            new Addp(username);
        }
        else if(e.getSource()==vpd){
            new ViewCustomer(username);
        }
        else if(e.getSource()==upd){
            new Updatecustomer(username);
        }
        else if(e.getSource()==cp){
            new CheckPackage();
        }
        else if(e.getSource()==bp){
            new BookPackage(username);
        }
        else if(e.getSource()==vp){
            new ViewPackage(username);
        }
        else if(e.getSource()==vh){
            new Viewhotels();
        }
        else if(e.getSource()==dest){
            new Destinations();
        }
        else if(e.getSource()==bh){
            new BookHotel(username);
        }
        else if(e.getSource()==vbh){
            new ViewBookedHotels(username);
        }
        else if(e.getSource()==pay){
            new Payments();
        }
        else if(e.getSource()==calc){
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ae) {
                ae.printStackTrace(); 
                // TODO: handle exception
            };
        }
        else if(e.getSource()==about){
            new About();
        }
        else if(e.getSource()==dpd){
            new DeleteDetails(username);
        }
       
    }
    public static void main(String[] args) {
        new Dashboard("");
    }
    
    
}
