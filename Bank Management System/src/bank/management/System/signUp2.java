package bank.management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signUp2 extends JFrame implements ActionListener {
    String formno;
    JLabel religion;
    JComboBox<String> religionOption;
    JLabel category;
    JComboBox<String> categoryOption;
    JLabel education;
    JComboBox<String> educationOption;
    JLabel occupation;
    JComboBox<String> occupationOption;
    JLabel income;
    JComboBox<String> incomeOption;
    JLabel pan;
    JTextField panText;
    JLabel aadhar;
    JTextField aadharText;
    JLabel senior;
    JRadioButton yes;
    JRadioButton no;
    JRadioButton yes2;
    JRadioButton no2;
    JLabel existing;
    JButton next;
    signUp2(String first){
        setTitle("Application Form");

        ImageIcon outter = new ImageIcon(ClassLoader.getSystemResource("icon2/1718704080692.png"));
        Image iO = outter.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i30 = new ImageIcon(iO);
        JLabel labelO = new JLabel(i30);
        labelO.setBounds(150, 7, 100, 100);

        this.formno = first;

        JLabel application = new JLabel("FORM NO."+first);
        application.setBounds(labelO.getX()+535,labelO.getY()+20,800,20);
        application.setFont(new Font("Arial",Font.BOLD,14));


        setLayout(null);
       setSize(850,750);
       setLocation(450,80);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       getContentPane().setBackground(new Color(251, 192, 45));

      JLabel page2 = new JLabel("Page 2 :-");
      page2.setFont(new Font("Arial",Font.BOLD,25));
      page2.setBounds(labelO.getX()+150,labelO.getY()+40,400,30);
      page2.setForeground(Color.black);

        JLabel additional = new JLabel("Additional Details");
        additional.setFont(new Font("Arial",Font.BOLD,23));
        additional.setBounds(page2.getX(),page2.getY()+32,800,30);
        additional.setForeground(Color.black);

       JPanel panel = new JPanel();
        panel.setBounds(35,120,750,565);
        panel.setLayout(null);
        panel.setOpaque(false);

        religion = new JLabel("Religion :");
       religion.setBounds(50,0,100,40);
        religion.setFont(new Font("Arial",Font.BOLD,20));
          religionOption = new JComboBox<>();
        religionOption.setBounds(religion.getX()+240,religion.getY()+10,400,30);
        religionOption.setFont(new Font("Arial",Font.PLAIN,15));
        religionOption.addItem("Hindu");
        religionOption.addItem("Muslim");
        religionOption.addItem("Christian");
        religionOption.addItem("Sikh");

         category = new JLabel("Category :");
        category.setBounds(50,religion.getY()+50,100,40);
        category.setFont(new Font("Arial",Font.BOLD,20));
         categoryOption = new JComboBox<>();
        categoryOption.setBounds(category.getX()+240,category.getY()+10,400,30);
        categoryOption.setFont(new Font("Arial",Font.PLAIN,15));
        categoryOption.addItem("General");
        categoryOption.addItem("OBC");
        categoryOption.addItem("SC");
        categoryOption.addItem("ST");

        education = new JLabel("Education :");
        education.setBounds(50,category.getY()+50,200,40);
        education.setFont(new Font("Arial",Font.BOLD,20));
         educationOption = new JComboBox<>();
        educationOption.setBounds(education.getX()+240,education.getY()+10,400,30);
        educationOption.setFont(new Font("Arial",Font.PLAIN,15));
        educationOption.addItem("10th");
        educationOption.addItem("12th");
        educationOption.addItem("Diploma");
        educationOption.addItem("Graduation");
        educationOption.addItem("Post-Graduation");

         occupation = new JLabel("Occupation :");
        occupation.setBounds(50,education.getY()+50,200,40);
        occupation.setFont(new Font("Arial",Font.BOLD,20));
         occupationOption = new JComboBox<>();
        occupationOption.setBounds(occupation.getX()+240,occupation.getY()+10,400,30);
        occupationOption.setFont(new Font("Arial",Font.PLAIN,15));
        occupationOption.addItem("Govt job");
        occupationOption.addItem("Private job");
        occupationOption.addItem("daily bases");
        occupationOption.addItem("Millitary");


         income = new JLabel("Income :");
        income.setBounds(50,occupation.getY()+50,200,40);
        income.setFont(new Font("Arial",Font.BOLD,20));
        incomeOption = new JComboBox<>();
        incomeOption.setBounds(income.getX()+240,income.getY()+10,400,30);
        incomeOption.setFont(new Font("Arial",Font.PLAIN,15));
        incomeOption.addItem("less than 5K");
        incomeOption.addItem("5K-10K");
        incomeOption.addItem("10K-20K");
        incomeOption.addItem("20K-40K");
        incomeOption.addItem("40K-50K");
        incomeOption.addItem("above 50K");


         pan = new JLabel("PAN Number :");
        pan.setBounds(50,income.getY()+50,300,40);
        pan.setFont(new Font("Arial",Font.BOLD,20));
        panText = new JTextField();
        panText.setBounds(pan.getX()+240,pan.getY()+8,400,30);

         aadhar = new JLabel("Aadhar Number :");
        aadhar.setBounds(50,pan.getY()+50,300,40);
        aadhar.setFont(new Font("Arial",Font.BOLD,20));
         aadharText = new JTextField();
        aadharText.setBounds(aadhar.getX()+240,aadhar.getY()+8,400,30);


         senior = new JLabel("Senior Citizen :");
        senior.setBounds(50,aadhar.getY()+50,300,40);
        senior.setFont(new Font("Arial",Font.BOLD,20));

         yes = new JRadioButton("Yes");
        yes.setFont(new Font("Arial",Font.BOLD,13));
        yes.setBounds(senior.getX()+240,senior.getY()+5,80,30);
        yes.setFocusPainted(false);
        yes.setOpaque(false);

         no = new JRadioButton("No");
        no.setFont(new Font("Arial",Font.BOLD,13));
        no.setBounds(yes.getX()+150,senior.getY()+5,80,30);
        no.setFocusPainted(false);
        no.setOpaque(false);


        existing = new JLabel("Existing Account :");
        existing.setBounds(50,senior.getY()+50,300,40);
        existing.setFont(new Font("Arial",Font.BOLD,20));

        yes2 = new JRadioButton("Yes");
        yes2.setFont(new Font("Arial",Font.BOLD,13));
        yes2.setBounds(existing.getX()+240,existing.getY()+5,80,30);
        yes2.setFocusPainted(false);
        yes2.setOpaque(false);

         no2 = new JRadioButton("No");
        no2.setFont(new Font("Arial",Font.BOLD,13));
        no2.setBounds(yes2.getX()+150,existing.getY()+5,80,30);
        no2.setFocusPainted(false);
        no2.setOpaque(false);



        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(yes2);
        bg2.add(no2);


        next = new JButton("Next");
        next.setBackground(Color.white);
        next.setForeground(Color.black);
        next.setBounds(585, 500, 90, 30);
        next.setFocusable(false);
        next.addActionListener(this);



        panel.add(religionOption);
        panel.add(religion);
        panel.add(categoryOption);
        panel.add(category);
        panel.add(educationOption);
        panel.add(education);
        panel.add(occupationOption);
        panel.add(occupation);
        panel.add(incomeOption);
        panel.add(income);
        panel.add(pan);
        panel.add(panText);
        panel.add(aadharText);
        panel.add(aadhar);
        panel.add(senior);
        panel.add(yes);
        panel.add(no);
        panel.add(existing);
        panel.add(yes2);
        panel.add(no2);
        panel.add(next);
   add(application);
        add(labelO);
        add(page2);
        add(panel);
        add(additional);
       setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      var religion = religionOption.getSelectedItem();
      var category = categoryOption.getSelectedItem();
      var education = educationOption.getSelectedItem();
      var occupation = occupationOption.getSelectedItem();
      var income = incomeOption.getSelectedItem();
      var pan_no = panText.getText();
      var aadhar = aadharText.getText();
      String senior = null;
      if(yes.isSelected()){
          senior = "Yes";
      }
      else if(no.isSelected()){
          senior = "No";
      }
      String exisiting = null;
      if(yes2.isSelected()){
          exisiting = "Yes";
      }
      else if(no2.isSelected()){
          exisiting = "No";
      }

        try {
            if (pan.getText().equals(" ")) {
                JOptionPane.showMessageDialog(null, "fill all the fields");
            } else {
                Con con1 = new Con();
                String q = "insert into signUp2 values('" + formno + "','" + religion + "', '" + category + "', '" + education + "','" + occupation + "', '" + income + "', '" + pan_no + "','" + aadhar + "','" + senior + "','"+exisiting+"')";
                con1.statement.executeUpdate(q);
                new signUp3(formno);
                setVisible(false);


            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new signUp2("");
    }
}
