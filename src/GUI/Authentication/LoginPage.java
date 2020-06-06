package GUI.Authentication;

import Logic.SQL;
import javax.swing.*;
import java.awt.*;

public class LoginPage extends JPanel {
    private Form form;
    private JButton signIn;
    private JButton signUp;
    private JLabel title;
    private JLabel homeLable;
    private JButton exit;

    public LoginPage(SQL sql, Form form) {
        this.form = form;

        title = new JLabel("Welcome to Foofle");
        homeLable = new JLabel("home page");
        signIn = new JButton("........Sign In........");
        signUp = new JButton("........Sign Up........");
        exit = new JButton(".........Exit........");

        customizeButton(signIn);
        customizeButton(signUp);
        customizeButton(exit);

        title.setBounds(50, 10, 400, 60);
        title.setFont(new Font("font1", 2, 30));
        homeLable.setBounds(75, 60, 100, 20);

        Font fontButtons = new Font("font2", 1, 15);
        signIn.setBounds(20, 160, 200, 40);
        signUp.setBounds(95, 260, 200, 40);
        exit.setBounds(170, 360, 200, 40);
        signUp.setFont(fontButtons);
        signIn.setFont(fontButtons);
        exit.setFont(fontButtons);


        setLayout(null);
        add(title);
        add(homeLable);
        add(signIn);
        add(signUp);
        add(exit);

        signIn.addActionListener(actionEvent -> getForm().setSignIn());
        signUp.addActionListener(actionEvent -> getForm().setSignUp());
        exit.addActionListener(actionEvent -> form.dispose());
    }

    public void customizeButton(JButton button) {
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setForeground(Color.LIGHT_GRAY);
    }

    public Form getForm() {
        return form;
    }
}
