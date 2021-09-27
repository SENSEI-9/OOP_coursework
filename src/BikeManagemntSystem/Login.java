package BikeManagemntSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
public class Login implements ActionListener{
    JFrame fr;
    JLabel lbl_heading,lbl_username,lbl_password,lbl_img;
    JTextField txt_firstname;
    JPasswordField txt_password;
    JButton btn_login,btn_reg;
    Font fon1,fon2;
    JPanel panel;
    ImageIcon image_bg;
    public Login(){
        fr=new JFrame("Login Page");
        fon1=new Font("Times new roman",Font.BOLD,50);
        fon2=new Font("Times new roman",Font.PLAIN,30);



        panel= new JPanel();
        panel.setBounds(0,0,1000,700);
        panel.setLayout(null);
        fr.add(panel);

        lbl_heading=new JLabel("LOGIN HERE");
        lbl_heading.setFont(fon1);
        lbl_heading.setBounds(140,60,350,50);
        lbl_heading.setForeground(new Color(219, 255, 0));
        panel.add(lbl_heading);

        lbl_username=new JLabel("User name :");
        lbl_username.setFont(fon2);
        lbl_username.setBounds(120,120,150,40);
        panel.add(lbl_username);

        txt_firstname=new JTextField();
        txt_firstname.setFont(fon2);
        txt_firstname.setBackground(Color.white);
        txt_firstname.setBounds(280,125,200,40);
        panel.add(txt_firstname);

        lbl_password=new JLabel("Password  :");
        lbl_password.setFont(fon2);
        lbl_password.setBounds(120,180,150,40);
        panel.add(lbl_password);

        txt_password=new JPasswordField();
        txt_password.setFont(fon2);
        txt_password.setBackground(Color.white);
        txt_password.setBounds(280,185,200,40);
        panel.add(txt_password);

        btn_login=new JButton("LOGIN");
        btn_login.setFont(fon2);
        btn_login.setForeground(Color.white);
        btn_login.setBackground(Color.blue);
        btn_login.addActionListener(this);
        btn_login.setBounds(250,250,150,60);

        panel.add(btn_login);

        btn_reg=new JButton("Register Here");
        btn_reg.setForeground(Color.white);
        btn_reg.setBackground(Color.blue);
        btn_reg.setFont(fon2);
        btn_reg.setBounds(210,330,220,40);
        btn_reg.addActionListener(this);
        panel.add(btn_reg);

        image_bg=new ImageIcon(Objects.requireNonNull(getClass().getResource("bike.jpg")));
        lbl_img=new JLabel(image_bg);
        lbl_img.setBounds(0, 0, 1000, 700);
        panel.add(lbl_img);

        fr.setSize(1000,700);
        fr.setLayout(null);
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn_reg) {
            fr.dispose();
            new Registration();
        }
        else if (e.getSource()==btn_login) {
            String firstname=txt_firstname.getText();
            String password=txt_password.getText();
            String query="select * from registration where fname='"+firstname+"' and password='"+password+"'";
            Operations db=new Operations();
            ResultSet rs=db.select(query);
            try {
                if(rs.next()) {
                    String gender=rs.getString(4);
                    JOptionPane.showMessageDialog(btn_login, "Login successsful");
                    fr.dispose();
                    new MainPage(firstname);
                }
                else if(firstname.length()==0 && password.length()==0) {
                    JOptionPane.showMessageDialog(btn_login, "All filds mast be filled");
                }
                else {
                    JOptionPane.showMessageDialog(btn_login, "Your username and password do not match.");
                }
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
