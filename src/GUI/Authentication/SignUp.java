package GUI.Authentication;

import GUI.MainApp.UserForm;
import Logic.SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUp extends JPanel implements ActionListener {
    private SQL sql;
    private Form form;
    private String username = "";
    private JLabel title = new JLabel("Sign up Foofle");
    private JButton home = new JButton("home");
    private JLabel userLabel = new JLabel("USERNAME");
    private JLabel passwordLabel = new JLabel("PASSWORD");
    private JLabel phoneLable = new JLabel("PHONE");
    private JTextField phoneField = new JTextField();
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton registerButton = new JButton("REGISTER");
    private JButton resetButton = new JButton("RESET");
    private JCheckBox showPassword = new JCheckBox("Show Password");


    SignUp(SQL sql, Form form) {
        this.sql = sql;
        this.form = form;
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
        phoneLable.setBounds(50, 250, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 200, 150, 30);
        phoneField.setBounds(150, 250, 150, 30);
        showPassword.setBounds(150, 290, 150, 30);
        registerButton.setBounds(50, 330, 100, 30);
        resetButton.setBounds(200, 330, 100, 30);
    }

    public void addComponentsToContainer() {
        add(title);
        add(home);
        add(userLabel);
        add(passwordLabel);
        add(phoneLable);
        add(userTextField);
        add(passwordField);
        add(phoneField);
        add(showPassword);
        add(registerButton);
        add(resetButton);
    }

    public void addActionEvent() {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        home.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
            phoneField.setText("");
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
        if (e.getSource() == registerButton) {
            try {
                username = userTextField.getText();
                getSql().addUser(username, "123", phoneField.getText());
                getSql().addInfoToUser(username);
                new UserForm(getSql(), userTextField.getText()).getDisplayPanel().setNewsScene();
                getForm().dispose();
            } catch (SQLException error) {
                while (error != null) {
                    System.out.println(error.getMessage());
                    error = error.getNextException();
                }
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
