package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balanceEnquiry extends JFrame implements ActionListener {
    String pin;
    JTextField text;
    JButton back;
    balanceEnquiry(String pin){
        this.pin = pin;
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icon2/atm.png"));
        Image i0 = i.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i0);
        JLabel l3 = new JLabel(i2);
        l3.setBounds(0,0,1550,830);

        JLabel limit = new JLabel("Your Current Balance is RS");
        limit.setFont(new Font("Arial",Font.BOLD,20));
        limit.setBounds(430,180,400,35);
        limit.setForeground(Color.white);
        l3.add(limit);

        int balance = 0;
        Con c = new Con();
        try {
            ResultSet resultSet = c.statement.executeQuery("select * from Deposite where pin = '"+pin+"'");

            while (resultSet.next()){
                if(resultSet.getString("type").equals("Deposite")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }}}catch (Exception E){
            E.printStackTrace();
        }
        text = new JTextField(""+balance);
        text.setFont(new Font("Arial",Font.BOLD,15));
        text.setBounds(430,limit.getY()+35,315,35);
//        text.setBackground(new Color(65,125,128));
        text.setOpaque(false);
        text.setForeground(Color.WHITE);
        text.setBorder(null);
//        text.addActionListener(this);
        l3.add(text);


        back = new JButton("Back");
        back.setBackground(new Color(65,125,128));
        back.setBounds(text.getX()+315,text.getY()+204,100,33);
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
          if(e.getSource() == back){
              setVisible(false);
             new main_class(pin);
          }
    }

    public static void main(String[] args) {
        new balanceEnquiry("");

    }
}
