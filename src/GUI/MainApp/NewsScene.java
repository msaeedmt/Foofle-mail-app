package GUI.MainApp;

import GUI.MainApp.utils.AddIcon;
import Logic.SQL;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsScene extends JPanel {
    private DisplayPanel displayPanel;
    private SQL sql = null;
    private static int gridY = 0;

    public NewsScene(SQL sql,DisplayPanel displayPanel) throws IOException {
        this.displayPanel=displayPanel;
        setLayout(new GridBagLayout());
        this.sql = sql;
    }

    public void makeNewsPad(String title, String content,String date,int id) throws IOException {
        Integer newsId=id;
        JPanel panel = new JPanel();
        JPanel titlePanel = new JPanel();
        JPanel contentPanel = new JPanel();
        JPanel infoPanel =new JPanel();

        panel.setLayout(new BorderLayout());
        panel.add(titlePanel, BorderLayout.NORTH);
        panel.add(contentPanel);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(Color.lightGray);
        titlePanel.setPreferredSize(new Dimension(550, 40));
        JLabel titleLabel = new JLabel(title);
        JButton delButton = new JButton();
        delButton.setPreferredSize(new Dimension(30, 40));

        JLabel time=new JLabel(date);
        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(delButton,BorderLayout.EAST);
        infoPanel.add(time);

        titlePanel.add(titleLabel);
        titlePanel.add(infoPanel, BorderLayout.EAST);
        new AddIcon().createIcon(delButton, "trash.jpg", 30, 30);

        contentPanel.setLayout(new BorderLayout());
        JTextArea contentText = new JTextArea(content);
        contentText.setSize(550, 70);
        contentText.setLineWrap(true);
        contentText.setWrapStyleWord(true);
        contentText.setEditable(false);
        contentPanel.add(contentText);

        panel.setBorder(new EmptyBorder(20, 0, 0, 0));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = gridY;
        gridY++;

        add(panel, constraints);

        delButton.addActionListener(actionEvent -> {
            try {
                getSql().deleteNews(newsId);
                getDisplayPanel().setNewsScene();
                repaint();
                revalidate();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void makeAllNews(String username) throws SQLException, IOException {
        ResultSet resultSet=getSql().getNews(username);
        while (resultSet.next()){
            makeNewsPad(resultSet.getString("title"),resultSet.getString("content"),resultSet.getDate("reg_time").toString(),resultSet.getInt("id"));
        }
    }

    public SQL getSql() {
        return sql;
    }

    public DisplayPanel getDisplayPanel() {
        return displayPanel;
    }
}
