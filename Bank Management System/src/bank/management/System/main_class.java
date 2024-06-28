package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    String Pin;
    JButton deposite;
    JButton miniStatment;
    JButton fast;
    JButton pin;
    JButton cashWithdrawl;
    JButton exit;
    JButton balanceEnquiry;
    main_class(String Pin){
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

         deposite = new JButton("DEPOSITE");
        deposite.setBackground(new Color(65,125,128));
        deposite.setBounds(405,enter.getY()+100,150,35);
        deposite.setFocusable(false);
        deposite.setForeground(Color.WHITE);
        deposite.addActionListener(this);
        l3.add(deposite);

        fast = new JButton("FAST CASH");
        fast.setBackground(new Color(65,125,128));
        fast.setBounds(405,deposite.getY()+45,150,35);
        fast.setFocusable(false);
        fast.setForeground(Color.WHITE);
        fast.addActionListener(this);
        l3.add(fast);

         pin = new JButton("PIN CHANGE");
        pin.setBackground(new Color(65,125,128));
        pin.setBounds(405,fast.getY()+45,150,35);
        pin.setFocusable(false);
        pin.setForeground(Color.WHITE);
        pin.addActionListener(this);
        l3.add(pin);

//        JButton ran4 = new JButton("PIN WITHDRAWL");
//        ran4.setBackground(new Color(65,125,128));
//        ran4.setBounds(405,ran3.getY()+45,150,35);
//        ran4.setFocusable(false);
//        ran4.setForeground(Color.WHITE);
////        ran.addActionListener(this);
//        l3.add(ran4);

        cashWithdrawl = new JButton("CASH WITHDRAWL");
        cashWithdrawl.setBackground(new Color(65,125,128));
        cashWithdrawl.setBounds(405+285,deposite.getY(),150,35);
        cashWithdrawl.setFocusable(false);
        cashWithdrawl.setForeground(Color.WHITE);
        cashWithdrawl.addActionListener(this);
        l3.add(cashWithdrawl);


         miniStatment = new JButton("MINI STATMENT");
        miniStatment.setBackground(new Color(65,125,128));
        miniStatment.setBounds(405+285,fast.getY(),150,35);
        miniStatment.setFocusable(false);
        miniStatment.setForeground(Color.WHITE);
        miniStatment.addActionListener(this);
        l3.add(miniStatment);


         balanceEnquiry = new JButton("BALANCE ENQUIRY");
        balanceEnquiry.setBackground(new Color(65,125,128));
        balanceEnquiry.setBounds(405+285,pin.getY(),150,35);
        balanceEnquiry.setFocusable(false);
        balanceEnquiry.setForeground(Color.WHITE);
        balanceEnquiry.addActionListener(this);
        l3.add(balanceEnquiry);


         exit = new JButton("EXIT");
        exit.setBackground(new Color(65,125,128));
        exit.setBounds(405+285,pin.getY()+45,150,35);
        exit.setFocusable(false);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        l3.add(exit);

        add(l3);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deposite){
            setVisible(false);
            new Deposite(Pin);
        } else if (e.getSource()==exit) {
            System.exit(0);
        } else if (e.getSource() == cashWithdrawl) {
            setVisible(false);
            new withdrawl(Pin);
        }else if (e.getSource() == balanceEnquiry) {
            setVisible(false);
            new balanceEnquiry(Pin);
        }else if (e.getSource() == fast) {
            setVisible(false);
            new FastCash(Pin);
        } else if (e.getSource() == pin) {
            setVisible(false);
            new PinChange(Pin);
        }else if (e.getSource() == miniStatment) {
            setVisible(false);
            new Mini(Pin);
        }
    }

    public static void main(String[] args) {
        new main_class("");
    }
}
