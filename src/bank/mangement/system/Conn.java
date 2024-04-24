
package bank.mangement.system;
import java.sql.*;
 

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
//            Registring Driver  (After adding jar file no need to register driver it automatically get the classpath of it)
//        Class.forName(com.mysql.cj.jdbc.Driver);


//        Creating Connection
        c = DriverManager.getConnection("jdbc:mysql://localhost:3307/bankmanagement","root","273163@ay");
//        Creating Statement
        s = c.createStatement();
        
        
        
        
        
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}














        // Data base connectivity step 
//1. Create Connection
//2. Create Statemnet
//3. Execute Query
//4. Close Connection