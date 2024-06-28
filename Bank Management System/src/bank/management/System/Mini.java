package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {
    JButton exit;
    String pin;
    Mini(String pin){
        this.pin = pin;
      setBounds(200,50,450,650);
     getContentPane().setBackground(new Color(189,224,254));
      setLayout(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JLabel top = new JLabel("ARYA BANK");
      top.setBounds(160,5,200,50);
      top.setFont(new Font("Arial", Font.BOLD,20));

        JLabel label1 = new JLabel("Card Number:");
        label1.setBounds(30,100,400,20);
        add(label1);

        JLabel label2 = new JLabel("");
        label2.setBounds(130,100,300,20);
        add(label2);

        JLabel label3 = new JLabel("");
        label3.setBounds(30,150,400,325);
        add(label3);


        JLabel bal = new JLabel();
        bal.setBounds(30,500,400,20);
        add(bal);



        try {
            int balance = 0;
         Con con = new Con();
            ResultSet resultSet = con.statement.executeQuery("select * from Deposite where pin = '"+pin+"'");
            while (resultSet.next()) {
                label3.setText(label3.getText() + "<html>" + resultSet.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount") + "<br><br><html>");
                if (resultSet.getString("type").equals("Deposite")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
                bal.setText("Your Total Balance is: " + balance);
              }
         Con c1 = new Con();
            ResultSet rs = con.statement.executeQuery("select * from login where pin = '"+pin+"' ");
            while (rs.next()){
                label2.setText(rs.getString("card_no").substring(0,4) + "-XXXX-XXXX-"+rs.getString("card_no").substring(12));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        exit = new JButton("EXIT");
        exit.setBackground(Color.black);
        exit.setBounds(30,540,125,35);
        exit.setFocusable(false);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);


        add(top);
      setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            setVisible(false);
            new main_class(pin);
        }
    }

    public static void main(String[] args) {
        new Mini("");
    }
}
