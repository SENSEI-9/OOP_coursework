package BikeManagemntSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
public class Login implements ActionListener {
    JFrame fr;
    JLabel lbl_heading,lbl_username,lbl_password,lbl_img,lbl_info;
    JTextField txt_username;
    JPasswordField txt_password;
    JButton btn_login,btn_reg;
    Font fon1,fon2,fon3;
    JPanel panel;
    ImageIcon image_bg;
    public Login(){
        fr=new JFrame("Login Page");
        fon1=new Font("algerian",Font.BOLD,50);
        fon2=new Font("areal",Font.BOLD,20);
        fon3=new Font("areal",Font.BOLD,30);

        panel= new JPanel();
        panel.setBounds(0,0,1370,750);
        panel.setLayout(null);
        fr.add(panel);


        lbl_heading=new JLabel("LOGIN HERE");
        lbl_heading.setFont(fon1);
        lbl_heading.setBounds(550,150,350,50);
        lbl_heading.setForeground(new Color(255,255,255));
        panel.add(lbl_heading);

        lbl_username=new JLabel("User name :");
        lbl_username.setForeground(new Color(255,255,255));
        lbl_username.setFont(fon2);
        lbl_username.setBounds(500,195,150,40);
        panel.add(lbl_username);

        txt_username=new JTextField();
        txt_username.setFont(fon2);
        txt_username.setBackground(new Color(220,239,238));
        txt_username.setBounds(620,198,230,40);
        panel.add(txt_username);

        lbl_password=new JLabel("Password  :");
        lbl_password.setForeground(new Color(255,255,255));
        lbl_password.setFont(fon2);
        lbl_password.setBounds(500,240,150,40);
        panel.add(lbl_password);

        txt_password=new JPasswordField();
        txt_password.setFont(fon2);
        txt_password.setBackground(new Color(220,239,238));
        txt_password.setBounds(620,243,230,40);
        txt_password.setBackground(new Color(220,239,238));
        panel.add(txt_password);

        btn_login=new JButton("LOGIN");
        btn_login.setFont(fon3);
        btn_login.setBackground(new Color(0,0,153));
        btn_login.setBorder(new LineBorder(Color.blue,4));
        btn_login.setForeground(new Color(153,153,255));
        btn_login.setBounds(630,290,150,50);
        btn_login.addActionListener(this);
        panel.add(btn_login);

        btn_reg=new JButton("Sign up");
        btn_reg.setForeground(Color.white);
        btn_reg.setBackground(new Color(0,204,204));
        btn_reg.setBorder(new LineBorder(new Color(102,255,255),4));
        btn_reg.setFont(fon2);
        btn_reg.setBounds(700,350,150,40);
        btn_reg.addActionListener(this);
        panel.add(btn_reg);



        lbl_password=new JLabel("Register now:");
        lbl_password.setForeground(new Color(255,255,255));
        lbl_password.setFont(fon2);
        lbl_password.setBounds(500,350,450,40);
        panel.add(lbl_password);

        image_bg=new ImageIcon(getClass().getResource("login.png"));
        lbl_img=new JLabel(image_bg);
        lbl_img.setBounds(0,0,1370,700);
        panel.add(lbl_img);

        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fr.setLayout(null);
        fr.setVisible(true);
    }
    public boolean log_test(String username, String pass) {
        String username_test = "alok";
        String pass_test = "alok";
        boolean result = false;
        if (username == username_test && pass == pass_test) {
            result = true;
        }
        return result;
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
            String username=txt_username.getText();
            String passw=txt_password.getText();
            String query="select * from registration where username='"+username+"' and password='"+passw+"'";
            Operations db=new Operations();
            ResultSet rs=db.select(query);
            try {
                if(rs.next()) {
                    JOptionPane.showMessageDialog(btn_login, "Login successsful");
                    fr.dispose();
                    new MainPage(username);

                }
                else if(username.length()==0 && passw.length()==0) {
                    JOptionPane.showMessageDialog(btn_login, "Please fill both fields.");
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
