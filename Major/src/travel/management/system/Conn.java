package travel.management.system;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try {
            //to connect driver-step1
            Class.forName("com.mysql.cj.jdbc.Driver");
            //to connect databse to java using name,password (Connection String)-step2
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem","root","1234");
            //creating the statement-step3
            s=c.createStatement();
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
}
