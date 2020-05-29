package GUI.MainApp;

import GUI.MailForm.MailForm;
import GUI.MainApp.utils.AddIcon;
import Logic.SQL;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SentMailScene extends JPanel implements MouseListener {
    private static int gridY = 0;
    private DisplayPanel displayPanel = null;
    private SQL sql = null;
    ArrayList<String> arrayList = new ArrayList<>();


    public SentMailScene(SQL sql, DisplayPanel displayPanel) throws IOException, SQLException {
        this.sql = sql;
        this.displayPanel = displayPanel;
        setLayout(new GridBagLayout());
        arrayList.add("saeed");
        arrayList.add("hos");
//        makeEmailPad("salma", arrayList, "sajoghweiogjsioghsheeeeeeeeeeeeeeeeee");
//        makeEmailPad("khabare shomare 2", arrayList, "Generally weights are specified with 0.0 and 1.0 as the extremes: the numbers in between are used as necessary. Larger numbers indicate that the component's row or column should get more space. For each column, the weight is related to the highest weightx specified for a component within that column, with each multicolumn component's weight being split somehow between the columns the component is in. Similarly, each row's weight is related to the highest weighty specified for a component within that row. Extra space tends to go toward the");
//        makeEmailPad("khabare shomare 2", arrayList, "fjeoighnewiogndegsiogjnrsasdngksdengvkjsdgvnnjsdgw");
//        makeEmailPad("khabare shomare 2", arrayList, "fjeoighnewiogndegsiogjnrsasdngksdengvkjsdgvnnjsdgw");
//        makeEmailPad("khabare shomare 2", arrayList, "Generally weights are specified with 0.0 and 1.0 as the extremes: the numbers in between are used as necessary. Larger numbers indicate that the component's row or column should get more space. For each column, the weight is related to the highest weightx specified for a component within that column, with each multicolumn component's weight being split somehow between the columns the component is in. Similarly, each row's weight is related to the highest weighty specified for a component within that row. Extra space tends to go toward the");
//        makeEmailPad("khabare shomare 2", arrayList, "fjeoighnewiogndegsiogjnrsasdngksdengvkjsdgvnnjsdgw");
        makeAllNews(getDisplayPanel().getUsername());
    }

    public void makeEmailPad(String subject, String receivers, String content, int id) throws IOException {
        Integer emailId = id;
        JPanel panel = new JPanel();
        JPanel titlePanel = new JPanel();
        JPanel contentPanel = new JPanel();

        panel.setLayout(new BorderLayout());
        panel.add(titlePanel, BorderLayout.NORTH);
        panel.add(contentPanel);
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                try {
                    StringBuilder receiversStr=new StringBuilder("");
                    ResultSet resultSet = getSql().findEmail(emailId);
                    resultSet.next();
                    ResultSet receivers=getSql().getReceivers(emailId);
                    while (receivers.next()){
                        System.out.println(receiversStr);
                        receiversStr.append(receivers.getString("receiverName").concat("@foofle.com  "));
                    }

                    new EmailDetail(getDisplayPanel().getUsername()).setDatas(
                            receiversStr.toString(),
                            "saeid",
                            resultSet.getString("Esubject"),
                            resultSet.getString("Econtent")
                    );
                } catch (SQLException e) {
                    e.printStackTrace();
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
        });

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(Color.white);
        titlePanel.setPreferredSize(new Dimension(550, 40));
        JLabel titleLabel = new JLabel(subject);
        JButton delButton = new JButton();
        delButton.setPreferredSize(new Dimension(30, 40));
        JLabel toLable = new JLabel("to : " + receivers);
        toLable.setBorder(new EmptyBorder(0, 20, 0, 0));
        toLable.setBackground(Color.lightGray);
        titlePanel.add(toLable, BorderLayout.CENTER);
        titlePanel.add(titleLabel, BorderLayout.WEST);
        titlePanel.add(delButton, BorderLayout.EAST);
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
                System.out.println();
                getSql().deleteEmail(emailId);
                getDisplayPanel().setSentMailScene();
                repaint();
                revalidate();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        });


    }

    public void makeAllNews(String username) throws SQLException, IOException {
        ResultSet resultSet = getSql().getSentEmails(username);
        StringBuilder receiversStr=new StringBuilder("");

        while (resultSet.next()) {
            ResultSet receivers=getSql().getReceivers(resultSet.getInt("id"));
            while (receivers.next()){
                receiversStr.append(receivers.getString("receiverName").concat("  "));
            }
            makeEmailPad(
                    resultSet.getString("Esubject"),
                    receiversStr.toString(),
                    resultSet.getString("Econtent"),
                    resultSet.getInt("id")
            );
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        new EmailDetail("saeed");
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

    public DisplayPanel getDisplayPanel() {
        return displayPanel;
    }
}
