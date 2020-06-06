package GUI.Authentication;

import GUI.Authentication.Form;
import GUI.MainApp.UserForm;
import Logic.SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;

public class SignIn extends JPanel implements ActionListener {
    private SQL sql;
    private Form form;
    private JLabel title = new JLabel("Sign in Foofle");
    private JButton home = new JButton("home");
    private JLabel userLabel = new JLabel("USERNAME");
    private JLabel passwordLabel = new JLabel("PASSWORD");
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("LOGIN");
    private JButton resetButton = new JButton("RESET");
    private JCheckBox showPassword = new JCheckBox("Show Password");


    SignIn(SQL sql, Form form) {
        this.form = form;
        this.sql = sql;
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        setLayout(null);
    }

    public void setLocationAndSize() {
        title.setBounds(50, 30, 200, 60);
        title.setFont(new Font("font1", 2, 30));
        home.setBounds(270, 35, 80, 60);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setFocusPainted(false);
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 200, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 200, 150, 30);
        showPassword.setBounds(150, 290, 150, 30);
        loginButton.setBounds(50, 330, 100, 30);
        resetButton.setBounds(200, 330, 100, 30);
    }

    public void addComponentsToContainer() {
        add(title);
        add(home);
        add(userLabel);
        add(passwordLabel);
        add(userTextField);
        add(passwordField);
        add(showPassword);
        add(loginButton);
        add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        home.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
        if (e.getSource() == home) {
            getForm().setLoginPage();
        }
        if (e.getSource() == loginButton) {
            try {
                String passwordStr=new String(passwordField.getPassword());
                ResultSet resultset = getSql().findUser(userTextField.getText(), passwordStr);
                String logedInUser = "";
                while (resultset.next()) {
                    if (resultset.getString("username") != null) {
                        logedInUser = resultset.getString("username");
                        getSql().login(logedInUser);
                        getForm().dispose();
                        new UserForm(getSql(), logedInUser).getDisplayPanel().setNewsScene();
                    }
                }
            } catch (SQLException error) {
                System.out.println(error.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    public Form getForm() {
        return form;
    }

    public SQL getSql() {
        return sql;
    }
}
