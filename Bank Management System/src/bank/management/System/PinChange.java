package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PinChange extends JFrame implements ActionListener{
    String pin;
    JButton deposite;
    JButton back;
    JPasswordField pinText;
    JPasswordField pinText1;
//    JPasswordField text1;


    PinChange(String pin){
        this.pin = pin;
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icon2/atm.png"));
        Image i0 = i.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i0);
        JLabel l3 = new JLabel(i2);
        l3.setBounds(0,0,1550,830);

        JLabel enter = new JLabel("CHANGE YOUR PAIN");
        enter.setFont(new Font("Arial",Font.BOLD,15));
        enter.setBounds(445,180,400,35);
        enter.setForeground(Color.white);
        l3.add(enter);

        JLabel newPin = new JLabel("New PIN:");
        newPin.setFont(new Font("Arial",Font.BOLD,15));
        newPin.setBounds(445,180+40,100,35);
        newPin.setForeground(Color.white);
        l3.add(newPin);




//        text.setBackground(new Color(65,125,128));


        pinText = new JPasswordField();
        pinText.setBounds(260, 100, 200, 30);
        pinText.setBounds(445+150,180+40,200,30);
        pinText.setBackground(new Color(65,125,128));
        pinText.setForeground(Color.WHITE);
        l3.add(pinText);

        JLabel reEnter = new JLabel("Re-Enter New PIN:");
        reEnter.setFont(new Font("Arial",Font.BOLD,15));
        reEnter.setBounds(445,newPin.getY()+40,150,35);
        reEnter.setForeground(Color.white);
        l3.add(reEnter);

        pinText1 = new JPasswordField();
        pinText1.setBounds(445+150,newPin.getY()+40,200,30);
        pinText1.setBackground(new Color(65,125,128));
        pinText1.setForeground(Color.WHITE);
        l3.add(pinText1);


        deposite = new JButton("Change");
        back = new JButton("Back");

        deposite.setBackground(new Color(65,125,128));
        back.setBackground(new Color(65,125,128));

        deposite.setBounds(pinText.getX()+150,pinText.getY()+153,100,35);
        deposite.setFocusable(false);
        deposite.setForeground(Color.WHITE);
        deposite.addActionListener(this);
        l3.add(deposite);

        back.setBounds(pinText.getX()+150,pinText.getY()+198,100,33);
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

            if (e.getSource() == back){
                setVisible(false);
                new main_class(pin);
            }else if(e.getSource() == deposite){
                try {

//                    Con c =new Con();
                    String pin_no2 = pinText1.getText();
                    String pin_no  = pinText.getText();

                    if(!pin_no.equals(pin_no2) && !pin_no2.equals("") && !pin_no.equals("")){
                        JOptionPane.showMessageDialog(null,"Password Doesn't match!");
                    }else if(pin_no2.equals("") || pin_no.equals("")){
                        JOptionPane.showMessageDialog(null,"First Fill Both Fields!");
                    }else {
                        Con c = new Con();
//                        ResultSet resultSet = c.statement.executeQuery("select * from login where pin = '"+pin+"'");
//                        String form_no = resultSet.getString("form_no");
//                        String card_no = resultSet.getString("card_no");
//                        if(resultSet.next()){
//                            c.statement.executeUpdate("'"+form_no+"','"+card_no+"','"+pin_no+"'");
                        String q1 = "update Deposite set pin = '"+pin_no+"' where pin = '"+pin+"'";
                        String q2 = "update login set pin = '"+pin_no+"' where pin = '"+pin+"'";
                        String q3 = "update signUp3 set pin = '"+pin_no+"' where pin = '"+pin+"'";
                        c.statement.executeUpdate(q1);
                        c.statement.executeUpdate(q2);
                        c.statement.executeUpdate(q3);
                            JOptionPane.showMessageDialog(null,"PIN changes Successfully!");
                            setVisible(false);
                            new main_class(pin);
                        }


                }catch (Exception E){
                    E.printStackTrace();
                }
            }
    }

    public static void main(String[] args) {
       new PinChange("");
    }
}
