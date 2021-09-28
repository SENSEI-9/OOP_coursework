package BikeManagemntSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class Registration implements ActionListener {
    JFrame fr;
    JLabel lbl_topic, lbl_firstname, lbl_lastname, lbl_contact, lbl_gender, lbl_password, lbl_confirm,lbl_img;
    JTextField txt_firstname, txt_lastname, txt_contact;
    JPasswordField txt_password, txt_confirm;
    JButton btn_register, btn_login;
    Font fon1, fon2,fon3;
    JPanel panel,panel1;
    ImageIcon reg_bg;
    JRadioButton rmale, rfemale;
    JCheckBox aggree;
    public Registration() {
        fr = new JFrame("Registration");
        fon1 = new Font("Times new roman", Font.BOLD, 45);
        fon2 = new Font("Times new roman", Font.BOLD, 20);
        fon3 = new Font("Times new roman", Font.BOLD, 30);

        panel = new JPanel();
        panel.setBounds(0, 0, 1370, 700);
        panel.setLayout(null);
        fr.add(panel);

        panel1= new JPanel();
        panel1.setBounds(170,150,670,400);
        panel1.setBackground(new Color(224,224,224));
        panel1.setLayout(null);
        panel.add(panel1);

        lbl_topic= new JLabel("USER REGISTRATION");
        lbl_topic.setFont(fon1);
        lbl_topic.setBounds(80, 10, 550, 50);
        lbl_topic.setForeground(new Color(34, 34, 247));
        panel1.add(lbl_topic);


        lbl_firstname = new JLabel("First name:");
        lbl_firstname.setFont(fon2);
        lbl_firstname.setBounds(20, 75, 300, 50);
        panel1.add(lbl_firstname);

        txt_firstname = new JTextField();
        txt_firstname.setFont(fon2);
        txt_firstname.setBackground(new Color(245, 254, 255));
        txt_firstname.setBounds(130, 85, 170, 35);
        panel1.add(txt_firstname);

        lbl_lastname = new JLabel("Last name             :");
        lbl_lastname.setFont(fon2);
        lbl_lastname.setBounds(310, 75, 300, 50);
        panel1.add(lbl_lastname);

        txt_lastname = new JTextField();
        txt_lastname.setFont(fon2);
        txt_lastname.setBounds(480, 85, 170, 35);
        txt_lastname.setBackground(new Color(245, 254, 255));
        panel1.add(txt_lastname);

        lbl_contact = new JLabel("Contact      :");
        lbl_contact.setFont(fon2);
        lbl_contact.setBounds(20, 135, 300, 50);
        panel1.add(lbl_contact);

        txt_contact = new JTextField();
        txt_contact.setFont(fon2);
        txt_contact.setBounds(130, 145, 170, 35);
        txt_contact.setBackground(new Color(245, 254, 255));
        panel1.add(txt_contact);

        lbl_gender = new JLabel("Gender        :");
        lbl_gender.setFont(fon2);
        lbl_gender.setBounds(310, 140, 300, 50);
        panel1.add(lbl_gender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(480, 150, 80, 30);
        rmale.setFont(fon2);
        rmale.setBackground(new Color(253, 253, 132));
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(570, 150, 100, 30);
        rfemale.setFont(fon2);
        rfemale.setBackground(new Color(253, 253, 132));
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        panel1.add(rmale);
        panel1.add(rfemale);


        lbl_password = new JLabel("Password  :");
        lbl_password.setFont(fon2);
        lbl_password.setBounds(20, 190, 300, 50);
        panel1.add(lbl_password);

        txt_password = new JPasswordField();
        txt_password.setFont(fon2);
        txt_password.setBounds(130, 200, 170, 35);
        txt_password.setBackground(new Color(245, 254, 255));
        panel1.add(txt_password);

        lbl_confirm = new JLabel("Confirm Password:");
        lbl_confirm.setFont(fon2);
        lbl_confirm.setBounds(310, 200, 300, 50);
        panel1.add(lbl_confirm);

        txt_confirm = new JPasswordField();
        txt_confirm.setFont(fon2);
        txt_confirm.setBounds(480, 205, 170, 35);
        txt_confirm.setBackground(new Color(245, 254, 255));
        panel1.add(txt_confirm);

        aggree = new JCheckBox("I agree all the terms and conditions.");
        aggree.setFont(fon2);
        aggree.setBackground(new Color(253,253,132));
        aggree.setBounds(170,270,370,30);
        panel1.add(aggree);


        btn_register = new JButton("Register");
        btn_register.setFont(fon3);
        btn_register.setForeground(Color.white);
        btn_register.setBounds(250, 300, 200, 45);
        btn_register.setBackground(Color.green);
        btn_register.addActionListener(this);
        panel1.add(btn_register);

        btn_login = new JButton("Go Back");
        btn_login.setForeground(Color.white);
        btn_login.setBackground(new Color(255, 0, 0));
        btn_login.setBorder(new LineBorder(new Color(243,143,177),7));
        btn_login.setFont(fon3);
        btn_login.setBounds(500, 300, 130, 40);
        btn_login.addActionListener(this);
        panel1.add(btn_login);



        reg_bg = new ImageIcon(getClass().getResource("register_bg.png"));
        lbl_img = new JLabel(reg_bg);
        lbl_img.setBounds(0, 0, 1370, 700);
        panel.add(lbl_img);

        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fr.setVisible(true);
        fr.setBackground(Color.YELLOW);
    }

    public static void main(String[] args) {
        new Registration();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn_login) {
            fr.dispose();
            new Login();

        }
        else if (e.getSource()==btn_register) {

            String fname=txt_firstname.getText();
            String lname=txt_lastname.getText();
            String contact=txt_contact.getText();
            String gender="";
            if (rmale.isSelected()) {
                gender=rmale.getText();
            }
            if(rfemale.isSelected()) {
                gender=rfemale.getText();
            }
            ;
            String password=txt_password.getText();
            String confirm=txt_confirm.getText();
            if (fname.length()==0 || lname.length()==0 || contact.length()==0
                    || rmale.isSelected()==false && rfemale.isSelected()==false
                    || password.length()==0 ||confirm.length()==0)
            {
                JOptionPane.showMessageDialog(btn_register, "Enter all Fields completely");
            }
            else if(password.equals(confirm) != true) {
                JOptionPane.showMessageDialog(btn_register, "Your password and confirm password did not match.");
            }
            else  {
                Operations db=new Operations();
                String query="insert into registration(fname,lname,contact,gender,password,confirm)"
                        + " values('"+fname+"','"+lname+"','"+contact+"',"
                        + "'"+gender+"','"+password+"','"+confirm+"')";
                int ans= db.insert(query);
                if (ans>0) {
                    JOptionPane.showMessageDialog(btn_register, "User successfully registered");
                    txt_firstname.setText("");
                    txt_lastname.setText("");
                    txt_contact.setText("");
                    txt_password.setText("");
                    txt_confirm.setText("");
                    ButtonGroup bg=new ButtonGroup();
                    bg.add(rmale);
                    bg.add(rfemale);
                    panel.add(rmale);
                    panel.add(rfemale);
                }
                else {
                    JOptionPane.showMessageDialog(btn_register, "User name already used. Please use diffrent "
                            + "username. ");
                }
            }
        }
    }
}
