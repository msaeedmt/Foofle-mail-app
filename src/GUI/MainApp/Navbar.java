package GUI.MainApp;

import GUI.Authentication.Form;
import Logic.SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Navbar extends JPanel implements KeyListener, MouseListener {
    private SQL sql;
    private UserForm userForm = null;
    private JTextField searchBar = new JTextField("Search");
    private JLabel title = new JLabel("Foofle");
    private JPanel infoPanel = new JPanel();

    Navbar(SQL sql,UserForm userForm) {
        this.userForm = userForm;
        this.sql=sql;
        System.out.println(userForm.getUsername());
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActions();
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

    public void addActions() {
        searchBar.addKeyListener(this);
        searchBar.addMouseListener(this);
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
        JButton logout = new JButton("out");
        logout.setPreferredSize(new Dimension(20, 30));
        label.setFont(new Font("font2", Font.ITALIC, 15));

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                getUserForm().dispose();
                new Form(getSql());
            }
        });

        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(label, BorderLayout.CENTER);
        infoPanel.add(logout, BorderLayout.EAST);
    }

    public UserForm getUserForm() {
        return userForm;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            String username = searchBar.getText();
            System.out.println(username);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }


    public JTextField getSearchBar() {
        return searchBar;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == searchBar) {
            searchBar.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    public SQL getSql() {
        return sql;
    }
}
