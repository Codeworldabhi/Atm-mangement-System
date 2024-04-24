package bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("Automated Tailer Machine");
        
        setLayout(null);
//        Adding img on Frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10,100,100);
        add(label);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Onward", Font.BOLD, 38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardNo = new JLabel("Card No : ");
        cardNo.setFont(new Font("Ralway", Font.BOLD, 34));
        cardNo.setBounds(120, 140,200,30);
        add(cardNo);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Ralway", Font.BOLD, 34));
        pin.setBounds(120, 220,250,30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton("Sign In");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("Sign Up");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        
        
        
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '" + cardnumber + "' and pin = '" + pinnumber + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactioin(pinnumber).setVisible(true);
                }else{
                   
                    JOptionPane.showMessageDialog(null, "Incorrect Details try this");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true); 
        }
        
    }
    public static void main(String args[]){
        new Login();
    }
}


//504093540194606     4632