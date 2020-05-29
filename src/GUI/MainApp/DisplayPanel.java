package GUI.MainApp;

import Logic.SQL;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class DisplayPanel extends JPanel {
    private SQL sql;
    private String username;
    private PersonalInfo personalInfo;
    private NewsScene newsScene;
    private SentMailScene sentMailScene;
    private InboxScene inboxScene;

    public DisplayPanel(SQL sql,String username) {
        this.sql = sql;
        this.username=username;
        setLayout(new BorderLayout());
    }

    public void setPersonalInfo() throws SQLException {
        this.removeAll();
        personalInfo = new PersonalInfo(getSql(),getUsername());
        add(personalInfo);
        personalInfo.fillTheFields();
        revalidate();
        repaint();
    }

    public void setNewsScene() throws IOException, SQLException {
        this.removeAll();
        newsScene = new NewsScene(getSql(),this);
        newsScene.makeAllNews(getUsername());
        JScrollPane scrollPane = new JScrollPane(newsScene);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void setInboxScene() throws IOException, SQLException {
        this.removeAll();
        inboxScene = new InboxScene(getSql(),this);
        JScrollPane scrollPane = new JScrollPane(inboxScene);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void setSentMailScene() throws IOException, SQLException {
        this.removeAll();
        sentMailScene = new SentMailScene(getSql(),this);
        JScrollPane scrollPane = new JScrollPane(sentMailScene);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public SQL getSql() {
        return sql;
    }

    public String getUsername() {
        return username;
    }
}
