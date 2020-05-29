package GUI.MainApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class ToolBoxButtons extends JPanel implements ActionListener {
    private ToolBox toolBox = null;
    private JButton news = new JButton("News");
    private JButton inbox = new JButton("Inbox");
    private JButton sent = new JButton("Sent mail");
    private JButton edit = new JButton("Edit personal info");

    public ToolBoxButtons(ToolBox toolBox) {
        this.toolBox = toolBox;

        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionListeners();
    }

    public void setLayoutManager() {
//        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new GridLayout(4, 1));
    }

    public void makeSmallComponents() {

    }

    public void setLocationAndSize() {

    }

    public void addComponentsToContainer() {
        add(customizeButton(news));
        add(customizeButton(inbox));
        add(customizeButton(sent));
        add(customizeButton(edit));
    }

    public void addActionListeners() {
        edit.addActionListener(this::actionPerformed);
        news.addActionListener(this);
        inbox.addActionListener(this);
        sent.addActionListener(this);
    }

    JButton customizeButton(JButton button) {
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == edit) {
            try {
                getToolBox().getUserForm().getDisplayPanel().setPersonalInfo();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == news) {
            try {
                getToolBox().getUserForm().getDisplayPanel().setNewsScene();
            } catch (IOException | SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == inbox) {
            try {
                getToolBox().getUserForm().getDisplayPanel().setInboxScene();
            } catch (IOException | SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == sent) {
            try {
                getToolBox().getUserForm().getDisplayPanel().setSentMailScene();
            } catch (IOException | SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ToolBox getToolBox() {
        return toolBox;
    }
}
