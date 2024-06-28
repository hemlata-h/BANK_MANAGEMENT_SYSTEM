package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JButton signIn;
    JButton Clear;
    JButton signUp;
    JLabel welcome;
    JTextField cardText;
    JPasswordField pinText;
    login() {
        setBounds(190,150,850,460);
        setTitle("Bank Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon outter = new ImageIcon(ClassLoader.getSystemResource("icon2/theme2.jpg"));
        Image iO = outter.getImage().getScaledInstance(850,430,Image.SCALE_DEFAULT);
        ImageIcon i30 = new ImageIcon(iO);
        JLabel labelO = new JLabel(i30);
        labelO.setBounds(0, 0, 850, 430);  // Set bounds for the background image label

        JPanel outPanel = new JPanel();
        outPanel.setBounds(0, 0, 860, 430);
        outPanel.setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon2/1718704080692.png"));
        Image i2 = icon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(250, 7, 400, 100);

//        ImageIcon iconII = new ImageIcon(ClassLoader.getSystemResource("icon2/1718705113733.png"));
//        Image i2II = iconII.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
//        ImageIcon i3II = new ImageIcon(i2II);
//        JLabel labelII = new JLabel(i3II);
//        labelII.setBounds(610, 320, 100, 100);  // Corrected bounds to fit within the frame

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setBounds(150, 100, 550, 230);  // Adjust bounds as necessary to fit within the outPanel

        welcome = new JLabel("WELCOME TO ATM");
        welcome.setFont(new Font("Arial", Font.BOLD, 45));
        welcome.setForeground(Color.BLACK);
        welcome.setBounds(90, 10, 550, 50);  // Adjusted width to fit within the panel

        JLabel cardNo = new JLabel("Card No:");
        cardNo.setForeground(Color.BLACK);
        cardNo.setFont(new Font("Arial", Font.BOLD, 20));
        cardNo.setBounds(140, 70, 100, 20);

        cardText = new JTextField();
        cardText.setBounds(260, 65, 200, 30);

        JLabel pinNo = new JLabel("PIN:");
        pinNo.setForeground(Color.BLACK);
        pinNo.setFont(new Font("Arial", Font.BOLD, 18));
        pinNo.setBounds(140, 100, 100, 20);

        pinText = new JPasswordField();
        pinText.setBounds(260, 100, 200, 30);

        signIn = new JButton("Sign In");
        signIn.setBackground(Color.black);
        signIn.setForeground(Color.WHITE);
        signIn.setBounds(200, pinText.getY() + 50, 90, 30);
        signIn.setFocusable(false);
        signIn.addActionListener(this);

        Clear = new JButton("Clear");
        Clear.setBackground(Color.black);
        Clear.setForeground(Color.WHITE);
        Clear.setBounds(signIn.getX() + 110, pinText.getY() + 50, 90, 30);
        Clear.setFocusable(false);
        Clear.addActionListener(this);

        signUp = new JButton("Sign Up");
        signUp.setBackground(Color.black);
        signUp.setForeground(Color.WHITE);
        signUp.setBounds(200, signIn.getY() + 45, 200, 30);
        signUp.setFocusable(false);
        signUp.addActionListener(this);

        panel.add(welcome);
        panel.add(cardNo);
        panel.add(cardText);
        panel.add(pinNo);
        panel.add(pinText);
        panel.add(signIn);
        panel.add(Clear);
        panel.add(signUp);

        outPanel.add(panel);
        outPanel.add(label);
//        outPanel.add(labelII);
        outPanel.add(labelO);  // Add the background image last

        add(outPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == signIn){
                  Con c =new Con();
                  String cardno = cardText.getText();
                  String pin_no  = pinText.getText();
                  String q = "select * from login where  card_no = '"+cardno+"' and pin = '"+pin_no+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if(resultSet.next()){
                    setVisible(false);
                    new main_class(pin_no);
                }
                else if(cardno.equals("") || pin_no.equals("")){
                    JOptionPane.showMessageDialog(null,"First fill the details");
                }else {

                    JOptionPane.showMessageDialog(null,"Incorrect Card number or Pin");
                }

            }
            else if(e.getSource() == signUp){
                new signUp();
                setVisible(false);
            }
            else if(e.getSource() == Clear){
                cardText.setText("");
                pinText.setText("");

            }

        }
        catch (Exception E){

        }
    }

    public static void main(String[] args) {
        new login();
    }
}
