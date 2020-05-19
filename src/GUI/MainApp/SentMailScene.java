package GUI.MainApp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SentMailScene extends JPanel{
    private static int gridX=0;
    private static int gridY=0;

    public SentMailScene() {

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
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.weightx = 2;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        constraints.ipadx = 0;
        constraints.ipady = 0;

        add(panel,constraints);
    }
}
