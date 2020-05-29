package GUI.MainApp;

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

public class InboxScene extends JPanel {
    private static int gridY=0;
    private DisplayPanel displayPanel=null;
    private SQL sql=null;

    public InboxScene(SQL sql, DisplayPanel displayPanel) throws IOException, SQLException {
        this.sql=sql;
        this.displayPanel=displayPanel;
        setLayout(new GridBagLayout());
        makeAllNews(getDisplayPanel().getUsername());
    }

    public void makeEmailPad(String subject,String content,int id) throws IOException {
        Integer emailId=id;
        JPanel panel=new JPanel();
        JPanel subjectPanel=new JPanel();
        JPanel contentPanel=new JPanel();
        JPanel buttons=new JPanel();

        panel.setPreferredSize(new Dimension(550,50));

        panel.setLayout(new BorderLayout());
        panel.add(subjectPanel,BorderLayout.WEST);
        panel.add(contentPanel);
        panel.add(buttons,BorderLayout.EAST);

        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                try {
                    StringBuilder receiversStr=new StringBuilder("");
                    ResultSet resultSet = getSql().findEmail(emailId);
                    resultSet.next();
                    ResultSet receivers=getSql().getReceivers(emailId);
                    while (receivers.next()){
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


        subjectPanel.setLayout(new BorderLayout());
        subjectPanel.setBackground(Color.lightGray);
        subjectPanel.setPreferredSize(new Dimension(100,50));
        JLabel titleLabel=new JLabel(subject);
        JPanel emptyPanel=new JPanel();
        subjectPanel.add(emptyPanel,BorderLayout.EAST);
        subjectPanel.add(titleLabel,BorderLayout.WEST);
        subjectPanel.setBorder(new EmptyBorder(0,0,0,10));

        buttons.setPreferredSize(new Dimension(30,50));
        buttons.setLayout(new BorderLayout());
        JButton del=new JButton();
        buttons.add(del,BorderLayout.NORTH);
        buttons.add(emptyPanel,BorderLayout.SOUTH);
        buttons.add(emptyPanel,BorderLayout.WEST);
        new AddIcon().createIcon(del,"trash.jpg",30,30);



        contentPanel.setLayout(new BorderLayout());
        JLabel contentText=new JLabel(content);
        contentPanel.add(contentText);
        contentPanel.setBorder(new EmptyBorder(0,20,0,10));


//        panel.setBorder(new EmptyBorder(20,0,0,0));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets=new Insets(20,0,0,0);
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.gridx = 0;
        constraints.gridy = gridY;
        gridY++;

        add(panel,constraints);

        del.addActionListener(actionEvent -> {
            try {
                getSql().deleteReceiver(emailId,displayPanel.getUsername());
                getDisplayPanel().setInboxScene();
                repaint();
                revalidate();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        });

    }

    public void makeAllNews(String username) throws SQLException, IOException {
        ResultSet resultSet=getSql().getReceivedEmails(username);
        while (resultSet.next()) {
            makeEmailPad(
                    resultSet.getString("Esubject"),
                    resultSet.getString("Econtent"),
                    resultSet.getInt("id")
            );
        }
    }

    public DisplayPanel getDisplayPanel() {
        return displayPanel;
    }

    public SQL getSql() {
        return sql;
    }
}
