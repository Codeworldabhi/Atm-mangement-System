
package bank.mangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener{
    JPasswordField pin, repin;
    JButton back, change;
    String pinnumber;
    PinChange(String pinnumber){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text = new JLabel("Change Your Pin");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250,280,500,35);
        image.add(text);
        
        JLabel pintext = new JLabel("New Pin :");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165,320,100,25);
        image.add(pintext);
        
         pin = new JPasswordField();
        pin.setFont(new Font("Ralway", Font.BOLD, 25));
        pin.setBounds(330,320,180,25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter Pin :");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165,360,120,25);
        image.add(repintext);       
        
         repin = new JPasswordField();
        repin.setFont(new Font("Ralway", Font.BOLD, 25));
        repin.setBounds(330,360,180,25);
        image.add(repin);
        
         change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
         back = new JButton("Back");
        back.addActionListener(this);
        back.setBounds(355,520,150,30);
        image.add(back);
        
        setSize(900,900);
        this.pinnumber = pinnumber;
        setLocation(300,0);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            String npin = pin.getText();
            String rpin = repin.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered Pin Does't Match!");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "New Pin Can't Be Empty");
                return;
            }
             if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Re Enter Pin Can't Be Empty");
                return;
            }
             try{
                 Conn conn = new Conn();
             String query1 = "update bank set pin='" + rpin + "' where pin ='" + pinnumber + "';";
            String query2 = "update login set pin='" + rpin + "' where pin ='" + pinnumber + "';";
            String query3 = "update signupthree set pin='" + rpin + "' where pin ='" + pinnumber + "';";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null,"Pin Updated Succesfully");
            setVisible(false);
            new Transactioin(rpin).setVisible(true);
             }catch(Exception e){
                 System.out.println(e);
             }
        }else {
            setVisible(false);
            new Transactioin(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main(String args[]){
        new PinChange("");
    }
}
