package GUI.MainApp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class NewsScene extends JPanel {
    private static int gridX = 0;
    private static int gridY = 0;

    public NewsScene() {
        setLayout(new GridBagLayout());
        makeNewsPad("salma","sajoghweiogjsioghsheeeeeeeeeeeeeeeeee");
        makeNewsPad("khabare shomare 2","Generally weights are specified with 0.0 and 1.0 as the extremes: the numbers in between are used as necessary. Larger numbers indicate that the component's row or column should get more space. For each column, the weight is related to the highest weightx specified for a component within that column, with each multicolumn component's weight being split somehow between the columns the component is in. Similarly, each row's weight is related to the highest weighty specified for a component within that row. Extra space tends to go toward the");
        makeNewsPad("khabare shomare 2","fjeoighnewiogndegsiogjnrsasdngksdengvkjsdgvnnjsdgw");
        makeNewsPad("khabare shomare 2","fjeoighnewiogndegsiogjnrsasdngksdengvkjsdgvnnjsdgw");
        makeNewsPad("khabare shomare 2","Generally weights are specified with 0.0 and 1.0 as the extremes: the numbers in between are used as necessary. Larger numbers indicate that the component's row or column should get more space. For each column, the weight is related to the highest weightx specified for a component within that column, with each multicolumn component's weight being split somehow between the columns the component is in. Similarly, each row's weight is related to the highest weighty specified for a component within that row. Extra space tends to go toward the");
        makeNewsPad("khabare shomare 2","fjeoighnewiogndegsiogjnrsasdngksdengvkjsdgvnnjsdgw");
    }

    public void makeNewsPad(String title,String content){
        JPanel panel=new JPanel();
        JPanel titlePanel=new JPanel();
        JPanel contentPanel=new JPanel();

        panel.setLayout(new BorderLayout());
        panel.add(titlePanel,BorderLayout.NORTH);
        panel.add(contentPanel);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(Color.lightGray);
        titlePanel.setPreferredSize(new Dimension(500,40));
        JLabel titleLabel=new JLabel(title);
        JButton delButton=new JButton("delete");
        delButton.setPreferredSize(new Dimension(30,40));
        titlePanel.add(titleLabel);
        titlePanel.add(delButton,BorderLayout.EAST);

        contentPanel.setLayout(new BorderLayout());
        JTextArea contentText=new JTextArea(content);
//        contentText.setPreferredSize(new Dimension(500,70));
        contentText.setSize(500,70);
        contentText.setLineWrap(true);
        contentText.setWrapStyleWord(true);
        contentText.setEditable(false);
        contentPanel.add(contentText);

        panel.setBorder(new EmptyBorder(20,0,0,0));
        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.insets = new Insets(10, 10, 10, 10);
//        constraints.weightx = 2;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        gridY++;
//        constraints.ipadx = 0;
//        constraints.ipady = 0;

        add(panel,constraints);

    }

    public static int getGridX() {
        return gridX;
    }

    public static int getGridY() {
        return gridY;
    }

    public static void setGridX(int gridX) {
        NewsScene.gridX = gridX;
    }

    public static void setGridY(int gridY) {
        NewsScene.gridY = gridY;
    }
}
