package GUI.MainApp;

import GUI.Authentication.Form;
import GUI.InfosForm.InfosForm;
import GUI.MainApp.utils.AddIcon;
import Logic.SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Navbar extends JPanel implements KeyListener, MouseListener {
    private SQL sql;
    private UserForm userForm = null;
    private JTextField searchBar = new JTextField("Search");
    private JLabel title = new JLabel("Foofle");
    private JPanel infoPanel = new JPanel();

    Navbar(SQL sql, UserForm userForm) throws IOException {
        this.userForm = userForm;
        this.sql = sql;
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
        title.setFont(new Font("font1", 1, 30));
        title.setBackground(Color.WHITE);
        infoPanel.setPreferredSize(new Dimension(100, 30));
    }

    public void addComponentsToContainer() throws IOException {
        makingTheMenu();
        add(searchBar, BorderLayout.WEST);
        add(title, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.EAST);
    }

    public void addActions() {
        searchBar.addKeyListener(this);
        searchBar.addMouseListener(this);
    }


    void makingTheMenu() throws IOException {
//        JMenuBar menuBar=new JMenuBar();
//        JMenu menu=new JMenu(getUserForm().getName());
//        JPopupMenu popupMenu = new JPopupMenu("esrger");
//        JMenuItem logout = new JMenuItem("logout");
//        menu.add(logout);
//        menuBar.add(menu);
//        infoPanel.add(menuBar);
//        popupMenu.add(logout);
        JLabel label = new JLabel(getUserForm().getUsername());
        JButton logout = new JButton();
        new AddIcon().createIcon(logout, "logout.jpg", 30, 30);
        logout.setPreferredSize(new Dimension(30, 30));
        label.setFont(new Font("font2", Font.BOLD, 20));

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
            try {
                ResultSet resultSet = getSql().getOtherInfos(username, getUserForm().getUsername());
                while (resultSet.next()){
                    new InfosForm(getSql(),getUserForm().getUsername()).setDetailes(resultSet.getString("userName"),
                            resultSet.getString("lastName"),
                            resultSet.getString("nickName"),
                            resultSet.getString("birthday"),
                            resultSet.getString("phone"),
                            resultSet.getString("codeMeli"),
                            resultSet.getString("address"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
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
