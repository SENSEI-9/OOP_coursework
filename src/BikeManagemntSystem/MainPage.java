package BikeManagemntSystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



public class MainPage implements ActionListener {
    JFrame fr;
    JLabel lbl_heading, lbl_bike1, lbl_bike2, lbl_bike3, lbl_bike4, lbl_bike5,lbl_bike6,lbl_bike7,lbl_bike8,
            lbl_topic, lbl_firstname, lbl_lastname, lbl_contact, lbl_gender, lbl_password, lbl_confirm, lbl_img;
    Font fon1, fon2, fon3;
    JPanel panel, bike, details, profile;
    JButton btn_bike, btn_details, btn_profile, btn_book, btn_delete;
    ImageIcon image;
    String firstname;
    JCheckBox cb1, cb2, cb3, cb4, cb5,cb6,cb7,cb8;
    ImageIcon bike1, bike2, bike3, bike4, bike5,bike6,bike7,bike8;
    String bike_name;
    ButtonGroup bg;
    JTable jt;
    DefaultTableModel model;
    JScrollPane pg;
    JTextField txt_firstname, txt_lastname, txt_contact, txt_id;
    JPasswordField txt_password, txt_confirm;
    JButton btn_update;
    JRadioButton rmale, rfemale;

    public MainPage(String firstname) {
        this.firstname = firstname;
        fr = new JFrame("HOME Page");
        fon1 = new Font("Algerian", Font.BOLD, 60);
        fon2 = new Font("arial", Font.BOLD, 35);
        fon3 = new Font("arial", Font.BOLD, 18);

        panel = new JPanel();
        panel.setSize(1000, 700);
        panel.setLayout(null);
        fr.add(panel);
        lbl_heading = new JLabel("BIKE LORD TANGO");
        lbl_heading.setFont(fon1);
        lbl_heading.setBounds(800, 20, 550, 50);
        lbl_heading.setForeground(new Color(23, 157, 0));
        panel.add(lbl_heading);

        bike = new JPanel();
        bike.setBackground(Color.black);
        bike.setBounds(0, 80, 1500, 630);
        bike.setLayout(null);
        panel.add(bike);

        details = new JPanel();
        details.setBackground(Color.black);
        details.setLayout(null);
        panel.add(details);


        profile = new JPanel();
        profile.setBackground(Color.black);
        profile.setLayout(null);
        panel.add(profile);


        btn_bike = new JButton("Bike");
        btn_bike.setBounds(40, 70, 200, 50);
        btn_bike.setFont(fon2);
        btn_bike.setForeground(Color.green);
        btn_bike.addActionListener(this);
        btn_bike.setBackground(Color.black);
        panel.add(btn_bike);


        btn_profile = new JButton("Profile");
        btn_profile.setBounds(620, 70, 200, 50);
        btn_profile.setFont(fon2);
        btn_profile.setForeground(Color.white);
        btn_profile.setBackground(Color.black);
        btn_profile.addActionListener(this);
        panel.add(btn_profile);

        btn_details = new JButton("Details");
        btn_details.setBounds(400, 70, 200, 50);
        btn_details.setFont(fon2);
        btn_details.setForeground(Color.white);
        btn_details.setBackground(Color.black);
        btn_details.addActionListener(this);
        panel.add(btn_details);

        bike1 = new ImageIcon(getClass().getResource("180s.png"));
        lbl_bike1 = new JLabel(bike1);
        lbl_bike1.setBounds(0, 0, 300, 270);
        bike.add(lbl_bike1);

        bike2 = new ImageIcon(getClass().getResource("302s.png"));
        lbl_bike2 = new JLabel(bike2);
        lbl_bike2.setBounds(0, 310, 300, 270);
        bike.add(lbl_bike2);

        bike3 = new ImageIcon(getClass().getResource("752s.png"));
        lbl_bike3 = new JLabel(bike3);
        lbl_bike3.setBounds(330, 0, 300, 270);
        bike.add(lbl_bike3);

        bike4 = new ImageIcon(getClass().getResource("leoncino250.png"));
        lbl_bike4 = new JLabel(bike4);
        lbl_bike4.setBounds(330, 310, 300, 270);
        bike.add(lbl_bike4);

        bike5 = new ImageIcon(getClass().getResource("tnt15.png"));
        lbl_bike5 = new JLabel(bike5);
        lbl_bike5.setBounds(670, 0, 300, 270);
        bike.add(lbl_bike5);


        cb1 = new JCheckBox("Benelli 180s");
        cb1.setBounds(60, 270, 240, 30);
        cb1.setForeground(Color.white);
        cb1.setBackground(Color.black);

        cb2 = new JCheckBox("Benelli Tnt 302s");
        cb2.setBounds(60, 580, 290, 30);
        cb2.setForeground(Color.white);
        cb2.setBackground(Color.black);

        cb3 = new JCheckBox("Benelli 752s");
        cb3.setBounds(390, 270, 240, 30);
        cb3.setForeground(Color.white);
        cb3.setBackground(Color.black);

        cb4 = new JCheckBox("Leoncino 250");
        cb4.setBounds(390, 580, 150, 50);
        cb4.setForeground(Color.white);
        cb4.setBackground(Color.black);

        cb5 = new JCheckBox("Benelli Tnt15");
        cb5.setBounds(730, 270, 150, 50);
        cb5.setForeground(Color.white);
        cb5.setBackground(Color.black);


        cb1.setFont(fon3);
        cb2.setFont(fon3);
        cb3.setFont(fon3);
        cb4.setFont(fon3);
        cb5.setFont(fon3);

        ButtonGroup bg = new ButtonGroup();
        bg.add(cb1);
        bg.add(cb2);
        bg.add(cb3);
        bg.add(cb4);
        bg.add(cb5);


        bike.add(cb1);
        bike.add(cb2);
        bike.add(cb3);
        bike.add(cb4);
        bike.add(cb5);

        btn_book = new JButton("BOOK");
        btn_book.setBounds(350, 390, 200, 50);
        btn_book.setFont(fon2);
        btn_book.setForeground(Color.white);
        btn_book.setBackground(Color.black);
        btn_book.addActionListener(this);
        bike.add(btn_book);


        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fr.setVisible(true);
    }

    public void details1() {
        jt = new JTable();
        model = (DefaultTableModel) jt.getModel();
        jt.setFont(fon3);
        jt.setRowHeight(40);
        jt.setBackground(Color.black);
        jt.setForeground(Color.white);

        lbl_topic = new JLabel("ID of purchase to cancel:");
        lbl_topic.setBounds(10, 10, 300, 30);
        lbl_topic.setFont(fon3);
        details.add(lbl_topic);

        txt_id = new JTextField();
        txt_id.setFont(fon3);
        txt_id.setBounds(500, 10, 100, 30);
        details.add(txt_id);

        btn_delete = new JButton("Delete");
        btn_delete.setFont(fon3);
        btn_delete.setBounds(500, 50, 100, 30);
        btn_delete.addActionListener(this);
        details.add(btn_delete);
        model.addColumn("Id");
        model.addColumn("User Name");
        model.addColumn("Bike Name");

        JTableHeader header = jt.getTableHeader();
        header.setFont(fon2);
        header.setBackground(Color.black);
        header.setForeground(Color.white);
        jt.getTableHeader().setPreferredSize(new Dimension(80, 50));
        try {
            Operations db = new Operations();
            String query = "select * from bike where username='" + firstname + "'";
            ResultSet rs = db.select(query);


            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        pg = new JScrollPane(jt);
        pg.setBounds(0, 150, 900, 300);
        details.add(pg);


    }

    public void profile() {
        lbl_topic = new JLabel("UPDATE PROFILE");
        lbl_topic.setFont(fon1);
        lbl_topic.setBounds(150, 10, 550, 50);
        lbl_topic.setForeground(Color.white);
        profile.add(lbl_topic);


        lbl_firstname = new JLabel("first name:");
        lbl_firstname.setFont(fon3);
        lbl_firstname.setForeground(Color.white);
        lbl_firstname.setBounds(20, 80, 300, 50);
        profile.add(lbl_firstname);

        lbl_lastname = new JLabel("Last name              :");
        lbl_lastname.setFont(fon3);
        lbl_lastname.setForeground(Color.white);
        lbl_lastname.setBounds(310, 80, 300, 50);
        profile.add(lbl_lastname);

        lbl_contact = new JLabel("Contact      :");
        lbl_contact.setFont(fon3);
        lbl_contact.setForeground(Color.white);
        lbl_contact.setBounds(20, 140, 300, 50);
        profile.add(lbl_contact);

        lbl_gender = new JLabel("Gender        :");
        lbl_gender.setFont(fon3);
        lbl_gender.setForeground(Color.white);
        lbl_gender.setBounds(310, 140, 300, 50);
        profile.add(lbl_gender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(460, 150, 80, 30);
        rmale.setFont(fon3);
        rmale.setBackground(Color.black);
        rmale.setForeground(Color.white);
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(550, 150, 100, 30);
        rfemale.setFont(fon3);
        rfemale.setBackground(Color.black);
        rfemale.setForeground(Color.white);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        profile.add(rmale);
        profile.add(rfemale);

        lbl_password = new JLabel("Password  :");
        lbl_password.setFont(fon3);
        lbl_password.setForeground(Color.white);
        lbl_password.setBounds(150, 200, 300, 50);
        profile.add(lbl_password);

        lbl_confirm = new JLabel("Confirm Password:");
        lbl_confirm.setFont(fon3);
        lbl_confirm.setForeground(Color.white);
        lbl_confirm.setBounds(150, 250, 300, 50);
        profile.add(lbl_confirm);

        Operations db = new Operations();
        String query = "select * from registration where fname='" + firstname + "'";
        ResultSet rs = db.select(query);
        try {
            while (rs.next()) {
                txt_firstname = new JTextField(rs.getString("fname"));
                txt_firstname.setFont(fon3);
                txt_firstname.setBackground(new Color(245, 254, 255));
                txt_firstname.setBounds(130, 85, 170, 35);
                profile.add(txt_firstname);

                txt_lastname = new JTextField(rs.getString("lname"));
                txt_lastname.setFont(fon3);
                txt_lastname.setBounds(480, 85, 170, 35);
                txt_lastname.setBackground(new Color(245, 254, 255));
                profile.add(txt_lastname);


                String gender = rs.getString("gender");

                if (gender.length() == 4) {
                    System.out.println("male");
                    rmale.setSelected(true);
                } else {
                    rfemale.setSelected(true);
                    System.out.println("female");

                }

                txt_contact = new JTextField(rs.getString("contact"));
                txt_contact.setFont(fon3);
                txt_contact.setBounds(130, 145, 170, 35);
                txt_contact.setBackground(new Color(245, 254, 255));
                profile.add(txt_contact);


                txt_password = new JPasswordField(rs.getString("password"));
                txt_password.setFont(fon3);
                txt_password.setBounds(350, 205, 170, 35);
                txt_password.setBackground(new Color(245, 254, 255));
                profile.add(txt_password);

                txt_confirm = new JPasswordField(rs.getString("confirm"));
                txt_confirm.setFont(fon3);
                txt_confirm.setBounds(350, 255, 170, 35);
                txt_confirm.setBackground(new Color(245, 254, 255));
                profile.add(txt_confirm);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        btn_update = new JButton("Update");
        btn_update.setFont(fon3);
        btn_update.setForeground(Color.white);
        btn_update.setBounds(250, 295, 200, 45);
        btn_update.setBackground(Color.green);
        btn_update.addActionListener(this);
        profile.add(btn_update);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_update) {
            String gender = "";
            if (rmale.isSelected()) {
                gender = rmale.getText();
            }
            if (rfemale.isSelected()) {
                gender = rfemale.getText();
            } else {
                try {
                    String query = "update registration set fname='" + txt_firstname.getText() + "',"
                            + "lname='" + txt_lastname.getText() + "',gender='" + gender + "',contact='" + txt_contact.getText() + "'"
                            + ",confirm='" + txt_confirm.getText() + "',password='" + txt_password.getText() + "' where fname='" + firstname + "'";
                    Operations db = new Operations();
                    int rs = db.Update(query);
                    JOptionPane.showMessageDialog(btn_update, "Update successsful");
                } finally {
                }
            }
        }


        if (e.getSource() == btn_bike) {
            profile.setBounds(0, 0, 0, 0);
            details.setBounds(0, 0, 0, 0);
            btn_bike.setForeground(Color.green);
            btn_bike.setBackground(Color.black);
            btn_details.setForeground(Color.white);
            btn_details.setBackground(Color.black);
            btn_profile.setForeground(Color.white);
            btn_profile.setBackground(Color.black);
            bike.setBounds(0, 80, 1500, 630);
        } else if (e.getSource() == btn_details) {
            bike.setBounds(0, 0, 0, 0);
            profile.setBounds(0, 0, 0, 0);
            btn_details.setForeground(Color.green);
            btn_details.setBackground(Color.black);
            btn_bike.setForeground(Color.white);
            btn_bike.setBackground(Color.black);
            btn_profile.setForeground(Color.white);
            btn_profile.setBackground(Color.black);
            details.setBounds(250, 200, 900, 450);
            details1();
        } else if (e.getSource() == btn_profile) {
            bike.setBounds(0, 0, 0, 0);
            details.setBounds(0, 0, 0, 0);
            profile.setBounds(250, 200, 900, 450);
            btn_profile.setForeground(Color.green);
            btn_profile.setBackground(Color.black);
            btn_bike.setForeground(Color.white);
            btn_bike.setBackground(Color.black);
            btn_details.setForeground(Color.white);
            btn_details.setBackground(Color.black);
            profile();

        } else if (e.getSource() == btn_book) {
            if (cb1.isSelected() == false && cb2.isSelected() == false && cb3.isSelected() == false && cb4.isSelected() == false
                    && cb5.isSelected() == false) {
                JOptionPane.showMessageDialog(btn_book, "Please choose bike");
                return;
            } else {
                if (cb1.isSelected() == true) {
                    bike_name = "Benelli 180s";
                }
                if (cb2.isSelected() == true) {
                    bike_name = "Benelli Tnt 302s";
                }
                if (cb3.isSelected() == true) {
                    bike_name = "Benelli 752s";
                }
                if (cb4.isSelected() == true) {
                    bike_name = "leoncino 250";
                }
                if (cb5.isSelected() == true) {
                    bike_name = "Benelli Tnt15";
                }
                Operations db = new Operations();
                String query = "insert into bike(username,bikename)"
                        + " values('" + firstname + "','" + bike_name + "')";
                int ans = db.insert(query);
                if (ans > 0) {
                    JOptionPane.showMessageDialog(fr, "Bike booked successfully");
                    cb1.setSelected(false);
                    cb2.setSelected(false);
                    cb3.setSelected(false);
                    cb4.setSelected(false);
                    cb5.setSelected(false);
                }
            }
        }

        if (e.getSource() == btn_delete) {
            if (e.getSource() == btn_delete) {
                try {
                    Operations db = new Operations();
                    String sql = "DELETE FROM bike WHERE id='" + txt_id.getText() + "'";
                    int rowsDeleted = db.executeDelete(sql);
                    model = (DefaultTableModel) jt.getModel();
                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(btn_delete, "Successfully deleted");
                        txt_id.setText("");
                        details.removeAll();
                        details.repaint();
                        details.revalidate();
                        details1();


                    } else {
                        JOptionPane.showMessageDialog(btn_delete, "ID not found.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }


    }
}