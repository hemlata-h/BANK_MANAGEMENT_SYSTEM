package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class withdrawl extends JFrame implements ActionListener {
    String pin;

    JButton withdrawl1;
    JButton back;
    JTextField text;

    withdrawl(String pin){
        this.pin = pin;

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icon2/atm.png"));
        Image i0 = i.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i0);
        JLabel l3 = new JLabel(i2);
        l3.setBounds(0,0,1550,830);

        JLabel limit = new JLabel(" MAXIMUM WITHDRAWAL IS RS. 10,000");
        limit.setFont(new Font("Arial",Font.BOLD,20));
        limit.setBounds(430,180,400,35);
        limit.setForeground(Color.white);
        l3.add(limit);

        JLabel enter = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW ");
        enter.setFont(new Font("Arial",Font.BOLD,15));
        enter.setBounds(442,180+50,400,35);
        enter.setForeground(Color.white);
        l3.add(enter);

        text = new JTextField();
        text.setFont(new Font("Arial",Font.BOLD,15));
        text.setBounds(445,180+90,315,35);
        text.setBackground(new Color(65,125,128));
        text.setForeground(Color.WHITE);
//        text.addActionListener(this);
        l3.add(text);


        withdrawl1 = new JButton("Withdrawl");
        back = new JButton("Back");

        withdrawl1.setBackground(new Color(65,125,128));
        back.setBackground(new Color(65,125,128));

        withdrawl1.setBounds(text.getX()+299,text.getY()+104,100,35);
        withdrawl1.setFocusable(false);
        withdrawl1.setForeground(Color.WHITE);
        withdrawl1.addActionListener(this);
        l3.add(withdrawl1);

        back.setBounds(text.getX()+299,withdrawl1.getY()+42,100,33);
        back.setFocusable(false);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        l3.add(back);

        setBounds(0,0,1550,1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(l3);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String amount = text.getText();
        java.util.Date date = new Date();

      try{


          if(e.getSource() == back){
              setVisible(false);
              new main_class(pin);
          } else if (e.getSource() == withdrawl1) {
              if(text.getText().equals("")){
                  JOptionPane.showMessageDialog(null,"Please enter the Amount");
              }else {
                  Con c1 = new Con();
                 ResultSet resultSet = c1.statement.executeQuery("select * from Deposite where pin = '"+ pin +"'");
                  int balance = 0;
                  while (resultSet.next()){
                     if(resultSet.getString("type").equals("Deposite")){
                      balance += Integer.parseInt(resultSet.getString("amount"));
                     }
                     else{
                         balance -= Integer.parseInt(resultSet.getString("amount"));
                     }

                  }



                  if(balance < Integer.parseInt(amount)){
                      JOptionPane.showMessageDialog(null,"Insufficient Balance");
                      return;
                  }
////                  String q = "insert into Deposite values('" + pin + "','" + date + "', 'Withdrawl1', '" + amount + "'";
//                  c1.statement.executeUpdate("insert into Deposite values('" + pin + "','" + date + "', 'Withdrawl1', '" + amount + "'");
//                  JOptionPane.showMessageDialog(null,"Money debited successfully !");

                  String q = "insert into Deposite values('" + pin + "','" + date + "', 'withdrawl', '" + amount + "')";
                  c1.statement.executeUpdate(q);
                  JOptionPane.showMessageDialog(null, "money debited successfully");
                  setVisible(false);
                  new main_class(pin);
              }
          }
      }catch (Exception E){
          E.printStackTrace();
      }

    }

    public static void main(String[] args) {
        new withdrawl("");
    }
}
