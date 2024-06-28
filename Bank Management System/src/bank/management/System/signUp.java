package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


public class signUp extends JFrame implements ActionListener {
    JButton next;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) +1000L;
    String first = " " + Math.abs(first4);
    JPanel panel;
    JTextField nameText;
    JTextField fatherText;
    JRadioButton male;
    JRadioButton female;
    JRadioButton other1;
    JTextField dobText;
    JTextField mailText;
    JRadioButton married;
    JRadioButton unmarried;
    JRadioButton other;
    JTextField addressText;
    JTextField cityText;
    JTextField pinText;
    JTextField stateText;
    JLabel state;
    JLabel pin;
    JLabel city;
    JLabel address;
    JLabel martial;
    JLabel mail;
    JLabel dob;
    JLabel gender;
    JLabel father;
    JLabel name;
    signUp() {
        setTitle("Application Form");
        setBounds(360,40,850,800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(222,255,228));


        ImageIcon outter = new ImageIcon(ClassLoader.getSystemResource("icon2/1718704080692.png"));
        Image iO = outter.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i30 = new ImageIcon(iO);
        JLabel labelO = new JLabel(i30);
        labelO.setBounds(35, 7, 100, 100);


        JLabel application = new JLabel("APPLICATION FORM NO."+first);
        application.setBounds(labelO.getX()+150,labelO.getY()+10,800,60);
        application.setFont(new Font("Arial",Font.BOLD,35));

        JLabel page = new JLabel("Page 1");
        page.setBounds(application.getX()+190,application.getY()+60,150,30);
        page.setFont(new Font("Arial",Font.BOLD,22));

        JLabel personal = new JLabel("Personal Details");
        personal.setBounds(300,page.getY()+30,400,30);
        personal.setFont(new Font("Arial",Font.BOLD,27));


         panel = new JPanel();
        panel.setBounds(35,180,750,565);
        panel.setLayout(null);
        panel.setOpaque(false);

         name = new JLabel("Name :");
        name.setBounds(50,0,100,40);
        name.setFont(new Font("Arial",Font.BOLD,20));
        nameText = new JTextField();
        nameText.setBounds(290,name.getY()+7,400,30);


         father = new JLabel("Father's Name :");
        father.setBounds(50,name.getY()+50,300,40);
       father.setFont(new Font("Arial",Font.BOLD,20));
        fatherText = new JTextField();
        fatherText.setBounds(290,father.getY()+8,400,30);


         gender = new JLabel("Gender :");
        gender.setBounds(50,father.getY()+50,300,40);
        gender.setFont(new Font("Arial",Font.BOLD,20));

         male = new JRadioButton("Male");
        male.setFont(new Font("Arial",Font.BOLD,13));
        male.setBounds(290,gender.getY()+5,80,30);
        male.setFocusPainted(false);
        male.setOpaque(false);

         female = new JRadioButton("Female");
        female.setFont(new Font("Arial",Font.BOLD,13));
        female.setBounds(290+150,gender.getY()+5,80,30);
        female.setFocusPainted(false);
        female.setOpaque(false);

        other1 = new JRadioButton("Other");
        other1.setFont(new Font("Arial",Font.BOLD,13));
        other1.setBounds(290+322,gender.getY()+5,80,30);
        other1.setFocusPainted(false);
        other1.setOpaque(false);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        bg.add(other1);


         dob = new JLabel("Date Of Birth :");
        dob.setBounds(50,gender.getY()+50,300,40);
        dob.setFont(new Font("Arial",Font.BOLD,20));
         dobText = new JTextField();
        dobText.setBounds(290,dob.getY()+8,400,30);


         mail = new JLabel("Email Address :");
        mail.setBounds(50,dob.getY()+50,300,40);
        mail.setFont(new Font("Arial",Font.BOLD,20));
         mailText = new JTextField();
        mailText.setBounds(290,mail.getY()+8,400,30);


        martial = new JLabel("Martial Status :");
        martial.setBounds(50,mail.getY()+50,300,40);
        martial.setFont(new Font("Arial",Font.BOLD,20));

         married = new JRadioButton("Married");
        married.setFont(new Font("Arial",Font.BOLD,13));
        married.setBounds(290,martial.getY()+5,80,30);
        married.setFocusPainted(false);
        married.setOpaque(false);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Arial",Font.BOLD,13));
        unmarried.setBounds(290+150,martial.getY()+5,100,30);
        unmarried.setFocusPainted(false);
        unmarried.setOpaque(false);

         other = new JRadioButton("Other");
        other.setFont(new Font("Arial",Font.BOLD,13));
        other.setBounds(290+322,martial.getY()+5,80,30);
        other.setFocusPainted(false);
        other.setOpaque(false);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(married);
        bg2.add(unmarried);
        bg2.add(other);


         address = new JLabel("Address :");
        address.setBounds(50,martial.getY()+50,300,40);
        address.setFont(new Font("Arial",Font.BOLD,20));
         addressText = new JTextField();
        addressText.setBounds(290,address.getY()+8,400,30);


        city = new JLabel("City :");
        city.setBounds(50,address.getY()+50,300,40);
        city.setFont(new Font("Arial",Font.BOLD,20));
         cityText = new JTextField();
        cityText.setBounds(290,city.getY()+8,400,30);


         pin = new JLabel("Pin Code :");
        pin.setBounds(50,city.getY()+50,300,40);
        pin.setFont(new Font("Arial",Font.BOLD,20));
         pinText = new JTextField();
        pinText.setBounds(290,pin.getY()+8,400,30);


         state = new JLabel("State :");
        state.setBounds(50,pin.getY()+50,300,40);
        state.setFont(new Font("Arial",Font.BOLD,20));
         stateText = new JTextField();
        stateText.setBounds(290,state.getY()+8,400,30);

         next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.setBounds(585, 520, 90, 30);
        next.setFocusable(false);
        next.addActionListener(this);

        panel.add(name);
        panel.add(nameText);
        panel.add(fatherText);
        panel.add(father);
        panel.add(gender);
        panel.add(male);
       panel.add(female);
       panel.add(other1);
       panel.add(dob);
       panel.add(dobText);
       panel.add(mail);
       panel.add(mailText);
        panel.add(martial);
        panel.add(married);
        panel.add(unmarried);
        panel.add(other);
        panel.add(address);
        panel.add(addressText);
        panel.add(cityText);
        panel.add(city);
        panel.add(pin);
        panel.add(pinText);
        panel.add(stateText);
        panel.add(state);
        panel.add(next);



         add(labelO);
         add(application);
         add(page);
         add(personal);
         add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first;
        String name = nameText.getText();
        String father = fatherText.getText();
        String date = dobText.getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        } else if (other1.isSelected()) {
            gender = "other";
        }
        String mail = mailText.getText();
        String martial = null;
        if(married.isSelected()){
            martial = "Married";
        } else if (unmarried.isSelected()) {
            martial = "Unmarried";
        } else if (other.isSelected()) {
            martial = "other";
        }
        String address = addressText.getText();
        String city = cityText.getText();
        String pin = pinText.getText();
        String state = stateText.getText();


        try {
            if (nameText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "fill all the fields");
            } else {
                Con con1 = new Con();
                String q = "insert into signUp values('" + formno + "', '" + name + "', '" + father + "','" + date + "', '" + gender + "', '" + mail + "','" + martial + "','" + address + "','" + city + "','" + pin + "','" + state + "')";
                con1.statement.executeUpdate(q);
                new signUp2(first);
                setVisible(false);


            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

//    @Override






    public static void main(String[] args) {
      new signUp();
    }
}
