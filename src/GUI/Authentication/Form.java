package GUI.Authentication;

import Logic.SQL;

import javax.swing.*;
import java.awt.*;

public class Form extends JFrame {
    private LoginPage loginPage;
    private SignIn signIn;
    private SignUp signUp;
    private SQL sql ;

    public Form(SQL sql) throws HeadlessException {
        super();
        this.sql = sql;
        setTitle("Foofle");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 500);
        setLoginPage();
    }

    public void setLoginPage() {
        getContentPane().removeAll();
        loginPage = new LoginPage(getSql(),this);
        add(loginPage, BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    public void setSignIn() {
        getContentPane().removeAll();
        signIn = new SignIn(getSql(),this);
        add(signIn, BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    public void setSignUp() {
        getContentPane().removeAll();
        signUp = new SignUp(getSql(),this);
        add(signUp, BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    public SQL getSql() {
        return sql;
    }
}
