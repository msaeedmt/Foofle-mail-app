package GUI.MainApp;

import GUI.MailForm.MailForm;
import GUI.MainApp.UserForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBox extends JPanel {
    private UserForm userForm;
    private ToolBoxButtons toolBoxButtons;
    private JPanel composeButtonPanel;
    private JPanel whiteSpace =new JPanel();

    public ToolBox(UserForm userForm) {
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
                new MailForm(getUserForm().getUsername());
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
}
