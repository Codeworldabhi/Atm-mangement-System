
package bank.mangement.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class MiniStatement extends JFrame{
    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        mini.setFont(new Font("Ralway", Font.BOLD, 12));
        add(mini);
        
        JLabel bank = new JLabel("Indain Bank for IT");
        bank.setBounds(100,20,300,20);
        bank.setFont(new Font("Ralway", Font.BOLD, 22));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
       card.setFont(new Font("Ralway", Font.BOLD, 16));
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        balance.setFont(new Font("Ralway", Font.BOLD, 16));
        add(balance);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from login where pin = '" +pinnumber + "';");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4) + "XXXXXX" 
                + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        int bal=0;
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from bank where pin='"+pinnumber + "';");
            while(rs.next()){
                mini.setText(mini.getText() +"<html>"+ rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Account Balnce is : " + bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        
    }
    public static void main(String args[]){
        new MiniStatement("");
    }
}
