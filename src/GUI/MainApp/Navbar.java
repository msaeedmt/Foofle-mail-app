package GUI.MainApp;

import GUI.Authentication.Form;
import GUI.MainApp.UserForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Navbar extends JPanel {
    private UserForm userForm = null;
    private JTextField searchBar = new JTextField("Search");
    private JLabel title = new JLabel("Foofle");
    private JPanel infoPanel = new JPanel();

    Navbar(UserForm userForm) {
        this.userForm = userForm;
        System.out.println(userForm.getUsername());
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
    }

    public void setLayoutManager() {
        setLayout(new BorderLayout());
    }

    public void setLocationAndSize() {
        searchBar.setPreferredSize(new Dimension(150, 30));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("font1", 2, 30));
        infoPanel.setPreferredSize(new Dimension(100, 30));
    }

    public void addComponentsToContainer() {
        makingTheMenu();
        add(searchBar, BorderLayout.WEST);
        add(title, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.EAST);
    }

    void makingTheMenu() {
//        JMenuBar menuBar=new JMenuBar();
//        JMenu menu=new JMenu(getUserForm().getName());
//        JPopupMenu popupMenu = new JPopupMenu("esrger");
//        JMenuItem logout = new JMenuItem("logout");
//        menu.add(logout);
//        menuBar.add(menu);
//        infoPanel.add(menuBar);
//        popupMenu.add(logout);
        JLabel label = new JLabel(getUserForm().getUsername());
        JButton logout=new JButton("out");
        logout.setPreferredSize(new Dimension(20,30));
        label.setFont(new Font("font2",Font.ITALIC,15));

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                getUserForm().dispose();
                new Form();
            }
        });

        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(label,BorderLayout.CENTER);
        infoPanel.add(logout,BorderLayout.EAST);
    }

    public UserForm getUserForm() {
        return userForm;
    }
}
