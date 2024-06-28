package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signUp3 extends JFrame implements ActionListener {
String formno;

    JLabel acctype;
    JRadioButton saving;
    JRadioButton current;
    JRadioButton fixed;
    JRadioButton recurring;
    JLabel cardNo;
    JLabel cardLabel;
    JLabel cardDown;
    JLabel pinText;
    JCheckBox atmCard;
    JCheckBox internetBanking;
    JCheckBox mobileBanking;
    JCheckBox emailAlerts;
    JCheckBox chequeBook;
    JCheckBox eStatement;
    JCheckBox term;
    JButton submit;
    JButton cancel;
    signUp3(String first){
       setTitle("Application Form");

       ImageIcon outter = new ImageIcon(ClassLoader.getSystemResource("icon2/1718704080692.png"));
       Image iO = outter.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
       ImageIcon i30 = new ImageIcon(iO);
       JLabel labelO = new JLabel(i30);
       labelO.setBounds(150, 7, 100, 100);

       setLayout(null);
       setSize(850,820);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocation(450,30);
       getContentPane().setBackground(new Color(202,240,248));

       this.formno = first;

       JLabel application = new JLabel("FORM NO."+first);
       application.setBounds(labelO.getX()+535,labelO.getY()+20,800,20);
       application.setFont(new Font("Arial",Font.BOLD,14));

       JLabel page2 = new JLabel("Page 3 :-");
       page2.setFont(new Font("Arial",Font.BOLD,25));
       page2.setBounds(labelO.getX()+150,labelO.getY()+40,400,30);
       page2.setForeground(Color.black);

       JLabel additional = new JLabel("Account Details");
       additional.setFont(new Font("Arial",Font.BOLD,23));
       additional.setBounds(page2.getX(),page2.getY()+32,800,30);
       additional.setForeground(Color.black);

       JPanel panel = new JPanel();
       panel.setBounds(35,140,750,640);
       panel.setLayout(null);
       panel.setOpaque(false);

       acctype = new JLabel("Account Type:");
       acctype.setBounds(70,0,200,40);
       acctype.setFont(new Font("Arial",Font.BOLD,20));

        saving = new JRadioButton("Saving Account");
       saving.setFont(new Font("Arial",Font.BOLD,16));
       saving.setBounds(acctype.getX(),acctype.getY()+50,200,30);
       saving.setFocusPainted(false);
       saving.setOpaque(false);

        current = new JRadioButton("Current Account");
       current.setFont(new Font("Arial",Font.BOLD,16));
       current.setBounds(acctype.getX(),saving.getY()+50,200,30);
       current.setFocusPainted(false);
       current.setOpaque(false);

        fixed = new JRadioButton("Fixed Account");
       fixed.setFont(new Font("Arial",Font.BOLD,16));
       fixed.setBounds(acctype.getX()+300,acctype.getY()+50,200,30);
       fixed.setFocusPainted(false);
       fixed.setOpaque(false);

        recurring = new JRadioButton("Recurring Deposite Account");
       recurring.setFont(new Font("Arial",Font.BOLD,16));
       recurring.setBounds(acctype.getX()+300,saving.getY()+50,300,30);
       recurring.setFocusPainted(false);
       recurring.setOpaque(false);

       ButtonGroup bg = new ButtonGroup();
       bg.add(recurring);
       bg.add(saving);
       bg.add(fixed);
       bg.add(current);

        cardNo = new JLabel("Card Number:");
       cardNo.setBounds(70,current.getY()+80,200,40);
       cardNo.setFont(new Font("Arial",Font.BOLD,20));

        cardLabel = new JLabel("XXXX-XXXX-XXXX-4841");
       cardLabel.setBounds(70+250,current.getY()+80,500,40);
       cardLabel.setFont(new Font("Arial",Font.BOLD,20));

        cardDown = new JLabel("(Your 16-digit Card Number)");
       cardDown.setBounds(70,cardLabel.getY()+30,500,40);
       cardDown.setFont(new Font("Arial",Font.BOLD,15));

       JLabel cardLabelDown = new JLabel("(It would appear on atm card/chequebook & statement)");
       cardLabelDown.setBounds(70+250,cardLabel.getY()+30,600,40);
       cardLabelDown.setFont(new Font("Arial",Font.BOLD,15));

       JLabel pin = new JLabel("PIN:");
       pin.setBounds(70,cardNo.getY()+80,200,40);
       pin.setFont(new Font("Arial",Font.BOLD,20));

        pinText = new JLabel("XXXX");
       pinText.setBounds(70+250,cardNo.getY()+80,200,40);
       pinText.setFont(new Font("Arial",Font.BOLD,20));

       JLabel service = new JLabel("Services Required:");
       service.setBounds(70,pin.getY()+70,200,40);
       service.setFont(new Font("Arial",Font.BOLD,20));

        atmCard = new JCheckBox("ATM CARD");
        internetBanking = new JCheckBox("Internet Banking");
        mobileBanking = new JCheckBox("Mobile Banking");
        emailAlerts = new JCheckBox("EMAIL Alerts");
        chequeBook = new JCheckBox("Cheque Book");
        eStatement = new JCheckBox("E-Statement");

       atmCard.setBounds(70,service.getY()+50,200,40);
       internetBanking.setBounds(70+250,atmCard.getY(),200,40);
       mobileBanking.setBounds(70,atmCard.getY()+50,200,40);
       emailAlerts.setBounds(70+250,mobileBanking.getY(),200,40);
       chequeBook.setBounds(70,mobileBanking.getY()+50,200,40);
       eStatement.setBounds(70+250,chequeBook.getY(),200,40);

       atmCard.setOpaque(false);
       internetBanking.setOpaque(false);
       mobileBanking.setOpaque(false);
       emailAlerts.setOpaque(false);
       chequeBook.setOpaque(false);
       eStatement.setOpaque(false);

       atmCard.setFocusable(false);
       internetBanking.setFocusable(false);
       mobileBanking.setFocusable(false);
       emailAlerts.setFocusable(false);
       chequeBook.setFocusable(false);
       eStatement.setFocusable(false);


        term = new JCheckBox("I hereby declare that the above entered details are accurate to the best of my knowlodege");
       term.setBounds(70,chequeBook.getY()+65,1000,40);
       term.setFont(new Font("Arial",Font.BOLD,14));
       term.setFocusable(false);
       term.setOpaque(false);


       submit = new JButton("Submit");
       submit.setBackground(Color.black);
       submit.setForeground(Color.WHITE);
       submit.setBounds(term.getX()+170, term.getY() + 50, 90, 30);
       submit.setFocusable(false);
       submit.addActionListener(this);

         cancel = new JButton("Cancel");
       cancel.setBackground(Color.black);
       cancel.setForeground(Color.WHITE);
       cancel.setBounds(submit.getX() + 150, term.getY() + 50, 90, 30);
       cancel.setFocusable(false);
       cancel.addActionListener(this);


       panel.add(acctype);
       panel.add(saving);
       panel.add(recurring);
       panel.add(fixed);
       panel.add(current);
       panel.add(cardNo);
       panel.add(cardLabel);
       panel.add(cardDown);
       panel.add(cardLabelDown);
       panel.add(pin);
       panel.add(pinText);
       panel.add(service);
       panel.add(atmCard);
       panel.add(internetBanking);
       panel.add(mobileBanking);
       panel.add(emailAlerts);
       panel.add(chequeBook);
       panel.add(eStatement);
       panel.add(term);
       panel.add(submit);
       panel.add(cancel);


       add(panel);
       add(labelO);
       add(page2);
       add(application);
      add(additional);
       setVisible(true);

   }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accType = null;
        if(saving.isSelected()){
            accType = "Saving Account";
        } else if (current.isSelected()) {
            accType = "Current Account";
        }else if(fixed.isSelected()){
            accType = "Fixed Account";
        } else if (recurring.isSelected()) {
            accType = "Reccuring Deposite Account";
        }
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
        String cardNo = "" + Math.abs(first7);
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

       String facility = "";
        if(atmCard.isSelected()){
            facility += "ATM Card";
        } else if (internetBanking.isSelected()) {
            facility += "Internet Bankimg";
        }else if (mobileBanking.isSelected()) {
            facility += "Mobile Bankimg";
        }else if (chequeBook.isSelected()) {
            facility += "Checque Book";
        }else if (emailAlerts.isSelected()) {
            facility += "Email Alerts";
        }else if (eStatement.isSelected()) {
            facility += "E Statement";
        }

        try {
            if (e.getSource() == submit) {
                if (!term.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Accept the term and declaration first.");
                } else {
                    Con con1 = new Con();
                    String q1 = "insert into signUp3 values('" + formno + "', '" + accType + "', '" + cardNo + "','" + pin + "', '" + facility + "')";
                    String q2 = "insert into login values('" + formno + "', '" + cardNo + "','" + pin + "')";
                    con1.statement.executeUpdate(q1);
                    con1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardNo +"\n PIN: "+pin);

                    setVisible(false);
                    new Deposite(pin);
                }

            } else if (e.getSource() == cancel) {
               System.exit(0);
            }


        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
      new signUp3("");
    }
}
