package GUI.Authentication;

import GUI.Authentication.Form;
import Logic.SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JPanel {
    private Form form;
    private JButton signIn;
    private JButton signUp;

    public LoginPage(SQL sql, Form form ) {
        this.form=form;

        GridLayout gridLayout = new GridLayout(1, 3);

        signIn = new JButton("Sign In");
        signUp = new JButton("Sign Up");

        customizeButton(signIn);
        customizeButton(signUp);

        setLayout(gridLayout);
        add(signIn);
//        add(new JLabel("/"));
        add(signUp);

        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                getForm().setSignIn();
            }
        });

        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                getForm().setSignUp();
            }
        });
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
