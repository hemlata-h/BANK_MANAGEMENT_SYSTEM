package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    String Pin;
    JButton b100;
    JButton b5000;
    JButton b200;
    JButton b500;
    JButton b2000;
    JButton exit;
    JButton b1000;
    JButton b10000;
    FastCash(String Pin){
        this.Pin = Pin;
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icon2/atm.png"));
        Image i0 = i.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i0);
        JLabel l3 = new JLabel(i2);
        l3.setBounds(0,0,1550,830);

        JLabel enter = new JLabel("Please Enter Your Transaction");
        enter.setFont(new Font("Arial",Font.BOLD,24));
        enter.setBounds(450,180,400,35);
        enter.setForeground(Color.white);
        l3.add(enter);
        setBounds(0,0,1550,1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b100 = new JButton("Rs 100");
        b100.setBackground(new Color(65,125,128));
        b100.setBounds(405,enter.getY()+100,150,35);
        b100.setFocusable(false);
        b100.setForeground(Color.WHITE);
        b100.addActionListener(this);
        l3.add(b100);

        b200 = new JButton("Rs 200");
        b200.setBackground(new Color(65,125,128));
        b200.setBounds(405,b100.getY()+45,150,35);
        b200.setFocusable(false);
        b200.setForeground(Color.WHITE);
        b200.addActionListener(this);
        l3.add(b200);

        b500 = new JButton("Rs 500");
        b500.setBackground(new Color(65,125,128));
        b500.setBounds(405,b200.getY()+45,150,35);
        b500.setFocusable(false);
        b500.setForeground(Color.WHITE);
        b500.addActionListener(this);
        l3.add(b500);

        b1000 = new JButton("Rs 1000");
        b1000.setBackground(new Color(65,125,128));
        b1000.setBounds(405,b500.getY()+45,150,35);
        b1000.setFocusable(false);
        b1000.setForeground(Color.WHITE);
        b1000.addActionListener(this);
        l3.add(b1000);

        b2000 = new JButton("Rs 2000");
        b2000.setBackground(new Color(65,125,128));
        b2000.setBounds(405+285,b100.getY(),150,35);
        b2000.setFocusable(false);
        b2000.setForeground(Color.WHITE);
        b2000.addActionListener(this);
        l3.add(b2000);


        b5000 = new JButton("Rs 5000");
        b5000.setBackground(new Color(65,125,128));
        b5000.setBounds(405+285,b200.getY(),150,35);
        b5000.setFocusable(false);
        b5000.setForeground(Color.WHITE);
        b5000.addActionListener(this);
        l3.add(b5000);


        b10000 = new JButton("Rs 10000");
        b10000.setBackground(new Color(65,125,128));
        b10000.setBounds(405+285,b500.getY(),150,35);
        b10000.setFocusable(false);
        b10000.setForeground(Color.WHITE);
        b10000.addActionListener(this);
        l3.add(b10000);


        exit = new JButton("EXIT");
        exit.setBackground(new Color(65,125,128));
        exit.setBounds(405+285,b10000.getY()+45,150,35);
        exit.setFocusable(false);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        l3.add(exit);

        add(l3);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


//        java.util.Date date = new Date();
         if(e.getSource() == exit){
             setVisible(false);
            new main_class(Pin);
         }else {
             String amount = ((JButton)e.getSource()).getText().substring(3);
             Con c = new Con();
             Date date = new Date();
             try {
                 ResultSet resultSet = c.statement.executeQuery("select * from Deposite where pin = '"+Pin+"'");
                 int balance = 0;
                 while (resultSet.next()){
                     if(resultSet.getString("type").equals("Deposite")){
                       balance += Integer.parseInt(resultSet.getString("amount"));
                     }else{
                         balance -= Integer.parseInt(resultSet.getString("amount"));
                     }
                 }
                 if(balance < Integer.parseInt(amount)){
                     JOptionPane.showMessageDialog(null,"Insufficient balance");
                     return;
                 }
                c.statement.executeUpdate("insert into Deposite values('" + Pin + "','" + date + "', 'Withdrawl', '" + amount + "')");
                 JOptionPane.showMessageDialog(null, "money ddebited successfully");
                 setVisible(false);
                 new main_class(Pin);
             }catch (Exception E){
                 E.printStackTrace();
             }
         }
    }

    public static void main(String[] args) {
  new FastCash("");
    }
}
