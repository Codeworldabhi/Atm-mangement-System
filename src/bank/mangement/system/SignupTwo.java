
package bank.mangement.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;

public class SignupTwo extends JFrame implements ActionListener{
    

    private static final long serialVersionUID = 1L;
    
    JTextField panTextField, adharTextField, addressTextField,cityTextField, stateTextField, pincodeTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religionList,categoryList, incomeList, qualificationList, occupationList ;
    String formno;
    SignupTwo(String formno){
        this.formno = formno;
        setTitle("New Account Application Form : Page - 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additonal Details");
        additionalDetails.setFont(new Font("Ralway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
       
        JLabel religion =  new JLabel("Religion : ");
        religion.setFont(new Font("Raleway" , Font.BOLD, 20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String valReligion[] = {"Hindu", "Sikh", "Christians", "Other"};
        religionList = new JComboBox(valReligion);
        religionList.setFont(new Font("Raleway", Font.BOLD, 14));
        religionList.setBounds(300,140,400,30);
        religionList.setBackground(Color.WHITE);
        add(religionList);
             
        JLabel category =  new JLabel("Category : ");
        category.setFont(new Font("Raleway" , Font.BOLD, 20));
        category.setBounds(100,190,200,30);
        add(category);
        
        String valCategory[] = {"OBC", "SC/ST", "Genral", "Others"};
        categoryList = new JComboBox(valCategory);
        categoryList.setBackground(Color.WHITE);
        categoryList.setFont(new Font("Raleway", Font.BOLD, 14));
        categoryList.setBounds(300,190,400,30);
        add(categoryList);
        
        JLabel income =  new JLabel("Income : ");
        income.setFont(new Font("Raleway" , Font.BOLD, 20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String valIncome[] = {"null", "< 1,50,000", "< 2,50,000", "<5,00,000","up to 10,00,000"};
        incomeList = new JComboBox(valIncome);
        incomeList.setBackground(Color.WHITE);
        incomeList.setBounds(300,240,400,30);
        incomeList.setFont(new Font("Raleway" , Font.BOLD, 14));
        add(incomeList);
        
        JLabel educational =  new JLabel("Educational : ");
        educational.setFont(new Font("Raleway" , Font.BOLD, 20));
        educational.setBounds(100,290,200,30);
        add(educational);
        
        
        
        
        JLabel qualification =  new JLabel("Qualification : ");
        qualification.setFont(new Font("Raleway" , Font.BOLD, 20));
        qualification.setBounds(100,310,200,30);
        add(qualification);
        
        String valeducation[] = {"Diploma", "Graduation", "Post - Graduation", "Others"};
        qualificationList = new JComboBox(valeducation);
        qualificationList.setBackground(Color.WHITE);
        qualificationList.setBounds(300,315,400,30);
        qualificationList.setFont(new Font("Raleway" , Font.BOLD, 14));
        add(qualificationList);
        
        
        JLabel occupation =  new JLabel("Occupation : ");
        occupation.setFont(new Font("Raleway" , Font.BOLD, 20));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        
        String valOccupation[] = {"Salaried", "Self-Employed", "Business", "Student","Retired", "Others"};
        occupationList = new JComboBox(valOccupation);
        occupationList.setBackground(Color.WHITE);
        occupationList.setBounds(300,390,400,30);
        occupationList.setFont(new Font("Raleway" , Font.BOLD, 14));
        add(occupationList);
        
      
        JLabel pannumber =  new JLabel("Pan Number : ");
        pannumber.setFont(new Font("Raleway" , Font.BOLD, 20));
        pannumber.setBounds(100,440,200,30);
        add(pannumber);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        
        JLabel adharnumber =  new JLabel("Adhar Number : ");
        adharnumber.setFont(new Font("Raleway" , Font.BOLD, 20));
        adharnumber.setBounds(100,490,200,30);
        add(adharnumber);
        
        adharTextField = new JTextField();
        adharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        adharTextField.setBounds(300,490,400,30);
        add(adharTextField);
        
        JLabel seniorcitizen =  new JLabel("Senior Ciztizen : ");
        seniorcitizen.setFont(new Font("Raleway" , Font.BOLD, 20));
        seniorcitizen.setBounds(100,540,200,30);
        add(seniorcitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,150,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup seniorCitizenButtongroup = new ButtonGroup();
        seniorCitizenButtongroup.add(syes);
        seniorCitizenButtongroup.add(sno);
        
       
        
        JLabel existingaccount =  new JLabel("Existing Account : ");
        existingaccount.setFont(new Font("Raleway" , Font.BOLD, 20));
        existingaccount.setBounds(100,590,200,30);
        add(existingaccount);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,150,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existingAccountButtongroup = new ButtonGroup();
        existingAccountButtongroup.add(eyes);
        existingAccountButtongroup.add(eno);
        
        
        next = new JButton("Next");
        next.addActionListener(this);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        add(next);
        
//        setTitle("Automated Tailer Machine");
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent en){
       
        
        String religion = (String)religionList.getSelectedItem();
        String category = (String)categoryList.getSelectedItem();
        String income = (String)incomeList.getSelectedItem();
        String qualification = (String)qualificationList.getSelectedItem();
        String occupation = (String)occupationList.getSelectedItem();
        String pannumber = panTextField.getText();
        String adharnumber = adharTextField.getText();
        String seniorCitizen = null;
        if(syes.isSelected()){
            seniorCitizen = "Yes";
        }else if(sno.isSelected()){
            seniorCitizen = "No";
        }
        String existingAccount = null;
        if(eyes.isSelected()){
            existingAccount = "Yes";
        }else if(eno.isSelected()){
            existingAccount = "No";
        }

        try{
            if(pannumber.equals("")){
            JOptionPane.showMessageDialog(null, "Name is Required");
        }else{
                Conn c = new Conn();
                String query = "insert into signupTwo values('" + formno + "', '" + religion + "', '" + category + "', '" + income + "', '" + qualification + "', '" + occupation + "', '" + pannumber + "', '"+ adharnumber + "', '" + seniorCitizen + "', '" + existingAccount + "')"; 
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new SignupTwo("");
    }
}
