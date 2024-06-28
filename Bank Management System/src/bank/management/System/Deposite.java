package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposite extends JFrame implements ActionListener {
    JButton deposite;
    JButton back;
    JTextField text;
     String pin;
    Deposite(String pin){
   this.pin = pin;
         ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icon2/atm.png"));
         Image i0 = i.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
         ImageIcon i2 = new ImageIcon(i0);
         JLabel l3 = new JLabel(i2);
         l3.setBounds(0,0,1550,830);

        JLabel enter = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSITE");
        enter.setFont(new Font("Arial",Font.BOLD,15));
        enter.setBounds(445,180,400,35);
        enter.setForeground(Color.white);
        l3.add(enter);

        text = new JTextField();
        text.setFont(new Font("Arial",Font.BOLD,15));
        text.setBounds(445,180+40,315,35);
        text.setBackground(new Color(65,125,128));
        text.setForeground(Color.WHITE);
        l3.add(text);


        deposite = new JButton("Deposite");
         back = new JButton("Back");

        deposite.setBackground(new Color(65,125,128));
        back.setBackground(new Color(65,125,128));

        deposite.setBounds(text.getX()+299,text.getY()+153,100,35);
        deposite.setFocusable(false);
        deposite.setForeground(Color.WHITE);
        deposite.addActionListener(this);
        l3.add(deposite);

        back.setBounds(text.getX()+299,text.getY()+198,100,33);
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


        try {
            String amount = text.getText();
            Date date = new Date();
            if(e.getSource() == deposite){
                if(text.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter the amount first");

                }
                else {
                    Con c1 = new Con();
                    String q = "insert into Deposite values('" + pin + "','" + date + "', 'Deposite', '" + amount + "')";
                    c1.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "money deposit successfully");
                    setVisible(false);
                    new main_class(pin);
                }

            }
            if(e.getSource() == back){
                setVisible(false);
                new main_class(pin);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposite("");
    }
}
