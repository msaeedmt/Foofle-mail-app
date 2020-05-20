package GUI.MainApp;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {
    private PersonalInfo personalInfo;
    private NewsScene newsScene;
    private SentMailScene sentMailScene;
    private InboxScene inboxScene;

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

    public void setInboxScene() {
        this.removeAll();
        inboxScene = new InboxScene();
        JScrollPane scrollPane = new JScrollPane(inboxScene);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
        add(scrollPane,BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void setSentMailScene() {
        this.removeAll();
        sentMailScene = new SentMailScene();
        JScrollPane scrollPane = new JScrollPane(sentMailScene);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
        add(scrollPane,BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
