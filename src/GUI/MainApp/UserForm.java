package GUI.MainApp;

import Logic.SQL;

import javax.swing.*;
import java.awt.*;

public class UserForm extends JFrame {
    private SQL sql;
    private Navbar navbar;
    private ToolBox toolBox;
    private DisplayPanel displayPanel;
    private String username;

    public UserForm(SQL sql,String username) throws HeadlessException {
        super();
        this.sql=sql;
        this.username = username;
        navbar = new Navbar(getSql(),this);
        toolBox=new ToolBox(this);
        displayPanel=new DisplayPanel();
        setTitle(getUsername());
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(700, 500);

        add(displayPanel,BorderLayout.CENTER);
        add(toolBox,BorderLayout.WEST);
        add(navbar, BorderLayout.NORTH);
    }

    public String getUsername() {
        return username;
    }

    public DisplayPanel getDisplayPanel() {
        return displayPanel;
    }

    public SQL getSql() {
        return sql;
    }
}
