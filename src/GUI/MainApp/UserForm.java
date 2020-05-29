package GUI.MainApp;

import Logic.SQL;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class UserForm extends JFrame {
    private SQL sql;
    private Navbar navbar;
    private ToolBox toolBox;
    private DisplayPanel displayPanel;
    private String username;

    public UserForm(SQL sql,String username) throws HeadlessException, IOException {
        super();
        this.sql=sql;
        this.username = username;
        navbar = new Navbar(getSql(),this);
        toolBox=new ToolBox(this,getSql());
        displayPanel=new DisplayPanel(getSql(),getUsername());
        setTitle(getUsername());
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(750, 660);

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
