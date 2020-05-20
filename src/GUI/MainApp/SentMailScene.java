package GUI.MainApp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class SentMailScene extends JPanel implements MouseListener {
    private static int gridY = 0;

    public SentMailScene() {
        setLayout(new GridBagLayout());
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("saeed");
        arrayList.add("hos");
        makeNewsPad("salma", arrayList, "sajoghweiogjsioghsheeeeeeeeeeeeeeeeee");
        makeNewsPad("khabare shomare 2", arrayList, "Generally weights are specified with 0.0 and 1.0 as the extremes: the numbers in between are used as necessary. Larger numbers indicate that the component's row or column should get more space. For each column, the weight is related to the highest weightx specified for a component within that column, with each multicolumn component's weight being split somehow between the columns the component is in. Similarly, each row's weight is related to the highest weighty specified for a component within that row. Extra space tends to go toward the");
        makeNewsPad("khabare shomare 2", arrayList, "fjeoighnewiogndegsiogjnrsasdngksdengvkjsdgvnnjsdgw");
        makeNewsPad("khabare shomare 2", arrayList, "fjeoighnewiogndegsiogjnrsasdngksdengvkjsdgvnnjsdgw");
        makeNewsPad("khabare shomare 2", arrayList, "Generally weights are specified with 0.0 and 1.0 as the extremes: the numbers in between are used as necessary. Larger numbers indicate that the component's row or column should get more space. For each column, the weight is related to the highest weightx specified for a component within that column, with each multicolumn component's weight being split somehow between the columns the component is in. Similarly, each row's weight is related to the highest weighty specified for a component within that row. Extra space tends to go toward the");
        makeNewsPad("khabare shomare 2", arrayList, "fjeoighnewiogndegsiogjnrsasdngksdengvkjsdgvnnjsdgw");
    }

    public void makeNewsPad(String subject, ArrayList<String> receivers, String content) {
        JPanel panel = new JPanel();
        JPanel titlePanel = new JPanel();
        JPanel contentPanel = new JPanel();

        panel.setLayout(new BorderLayout());
        panel.add(titlePanel, BorderLayout.NORTH);
        panel.add(contentPanel);
        panel.addMouseListener(this);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(Color.white);
        titlePanel.setPreferredSize(new Dimension(500, 40));
        JLabel titleLabel = new JLabel(subject);
        JButton delButton = new JButton("delete");
        delButton.setPreferredSize(new Dimension(30, 40));
        JLabel toLable = new JLabel("to : " + receivers);
        toLable.setBorder(new EmptyBorder(0, 20, 0, 0));
        toLable.setBackground(Color.lightGray);
        titlePanel.add(toLable, BorderLayout.CENTER);
        titlePanel.add(titleLabel, BorderLayout.WEST);
        titlePanel.add(delButton, BorderLayout.EAST);

        contentPanel.setLayout(new BorderLayout());
        JTextArea contentText = new JTextArea(content);
        contentText.setSize(500, 70);
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
}
