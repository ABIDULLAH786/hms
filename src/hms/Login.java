package hms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginFrame extends JFrame implements ActionListener 
{
    JLabel userLabel;
    JLabel passwordLabel;
    JTextField userTextField;
    JPasswordField passwordField;
    JButton loginButton;
    JButton resetButton;
    JCheckBox showPassword;
    ImageIcon iconForBackgroung;
    JLabel backgroungPicture;
    Color VERY_LIGHT_RED;
    Color Very_dark_blue;
    Font font1;
    LoginFrame() 
    {
        userLabel = new JLabel("USERNAME");
        passwordLabel = new JLabel("PASSWORD");
        userTextField = new JTextField("E.g 053-18-1200");
        passwordField = new JPasswordField();
        loginButton = new JButton("LOGIN");
        resetButton = new JButton("RESET");
        showPassword = new JCheckBox("Show Password");
        iconForBackgroung = new ImageIcon(ClassLoader.getSystemResource("hms/Login.jpg"));
        backgroungPicture = new JLabel(iconForBackgroung);
        
        setLocationAndSize();
        addComponentsToFrame();
        addActionEvent();
        setStyle();
        
        setSize(1200,700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    final public void setStyle()
    {
        //color
        //Color.red.brighter()
        VERY_LIGHT_RED = new Color(255,80,75);
        userLabel.setForeground(VERY_LIGHT_RED);
        passwordLabel.setForeground(VERY_LIGHT_RED);
        
        //font
        font1 = new Font("TimesRoman",Font.BOLD,15);
        userLabel.setFont(font1);
        passwordLabel.setFont(font1);
        
        //buttonsStyle
        loginButton.setBackground(VERY_LIGHT_RED);
        loginButton.setBorder(null);
        resetButton.setBackground(VERY_LIGHT_RED);
        resetButton.setBorder(null);
        
    }
    final public void setLocationAndSize() 
    {
        userLabel.setBounds(50, 250, 100, 30);
        passwordLabel.setBounds(50, 300, 100, 30);
        userTextField.setBounds(150, 250, 150, 30);
        passwordField.setBounds(150, 300, 150, 30);
        showPassword.setBounds(150, 350, 150, 30);
        loginButton.setBounds(50, 400, 100, 30);
        resetButton.setBounds(200, 400, 100, 30);
        backgroungPicture.setBounds(0, 0, 1200, 700);

    }

    final public void addComponentsToFrame() 
    {
        add(userLabel);
        add(passwordLabel);
        add(userTextField);
        add(passwordField);
        add(showPassword);
        add(loginButton);
        add(resetButton);
        add(backgroungPicture);
    }

    final public void addActionEvent() 
    {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == loginButton) 
        {
            String userText;
            String pwdText;
            userText = userTextField.getText().toString();
            pwdText = passwordField.getText();
            if(userText.length() != 11)
            {
                JOptionPane.showMessageDialog(this, "Sorry User Id length is mismatch");
                userTextField.setText("");
                passwordField.setText("");
            }
            if (userText.equalsIgnoreCase("053-18-0015") || userText.equalsIgnoreCase("023-18-0034")) 
            {
                new AdminFrame();
                dispose();
//                JOptionPane.showMessageDialog(this, "Login Successful");
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        if (e.getSource() == resetButton) 
        {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) 
        {
            if (showPassword.isSelected()) 
            {
                passwordField.setEchoChar((char) 0);
            } else 
            {
                passwordField.setEchoChar('*');
            }
        }
    }

}
class Login {
    public static void main(String[] a) 
    {
        new LoginFrame();
    }

}
