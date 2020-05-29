package GUI.MainApp;

import GUI.MailForm.MailForm;
import GUI.MainApp.UserForm;
import Logic.SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ToolBox extends JPanel {
    private SQL sql=null;
    private UserForm userForm;
    private ToolBoxButtons toolBoxButtons;
    private JPanel composeButtonPanel;
    private JPanel whiteSpace =new JPanel();

    public ToolBox(UserForm userForm, SQL sql) {
        this.sql=sql;
        this.userForm=userForm;
        toolBoxButtons=new ToolBoxButtons(this);
        composeButtonPanel=new JPanel();
        setPreferredSize(new Dimension(150,470));
        setBackground(Color.LIGHT_GRAY);

        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
    }

    public void setLayoutManager() {
        setLayout(new BorderLayout());
    }

    public void makeSmallComponents(){
        JButton compose =new JButton("Compose");
        compose.setFont(new Font("font",Font.BOLD,17));
        composeButtonPanel.setLayout(new BorderLayout());
        composeButtonPanel.add(compose,BorderLayout.NORTH);
        compose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    new MailForm(getSql(),getUserForm().getUsername());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setLocationAndSize() {
        toolBoxButtons.setPreferredSize(new Dimension(150,200));
        composeButtonPanel.setPreferredSize(new Dimension(150,170));
    }

    public void addComponentsToContainer() {
        toolBoxButtons.setBackground(Color.lightGray);
        whiteSpace.setBackground(Color.lightGray);
        composeButtonPanel.setBackground(Color.lightGray);
        makeSmallComponents();
        add(toolBoxButtons,BorderLayout.NORTH);
        add(whiteSpace,BorderLayout.CENTER);
        add(composeButtonPanel,BorderLayout.SOUTH);
    }

    public UserForm getUserForm() {
        return userForm;
    }

    public SQL getSql() {
        return sql;
    }
}
