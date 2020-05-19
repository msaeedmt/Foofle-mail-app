package GUI.Authentication;

import javax.swing.*;
import java.awt.*;

public class Form extends JFrame {
    private LoginPage loginPage;
    private SignIn signIn;
    private SignUp signUp;

    public Form() throws HeadlessException {
        super();
        setTitle("Foofle");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400,500);
//        pack();
        setLoginPage();
    }

    public void setLoginPage(){
        getContentPane().removeAll();
        loginPage=new LoginPage(this);
        add(loginPage,BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    public void setSignIn(){
        getContentPane().removeAll();
        signIn=new SignIn(this);
        add(signIn,BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    public void setSignUp(){
        getContentPane().removeAll();
        signUp=new SignUp(this);
        add(signUp,BorderLayout.CENTER);
        repaint();
        revalidate();
    }
}
