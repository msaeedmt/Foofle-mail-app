package GUI.MainApp;

import javax.swing.*;
import java.awt.*;

public class UserForm extends JFrame {
    private Navbar navbar;
    private ToolBox toolBox;
    private DisplayPanel displayPanel;
    private String username;

    public UserForm(String username) throws HeadlessException {
        super();
        this.username = username;
        navbar = new Navbar(this);
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
}
