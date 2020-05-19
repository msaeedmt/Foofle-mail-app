package GUI.MainApp;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {
    private PersonalInfo personalInfo;
    private NewsScene newsScene;

    public DisplayPanel() {
        setLayout(new BorderLayout());
    }

    public void setPersonalInfo() {
        this.removeAll();
        personalInfo = new PersonalInfo();
        add(personalInfo);
        revalidate();
        repaint();
    }

    public void setNewsScene() {
        this.removeAll();
        newsScene = new NewsScene();
        JScrollPane scrollPane = new JScrollPane(newsScene);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
        add(scrollPane,BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
