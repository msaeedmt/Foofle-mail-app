package GUI.MainApp;

import javax.swing.*;
import java.awt.*;

public class EmailDetail extends JFrame {
    private String username = "";
    private JLabel sender = new JLabel("Sender");
    private JLabel senderGmail = new JLabel();
    private JLabel receivers = new JLabel("Receivers");
    private JLabel receiversField = new JLabel();
    private JLabel CCReceivers = new JLabel("cc Receivers");
    private JLabel CCReceiversField = new JLabel();
    private JLabel subject = new JLabel("Subject");
    private JLabel subjectField = new JLabel();
    private JLabel content = new JLabel("Content");
    private JTextArea contentField = new JTextArea();
    private JPanel c = new JPanel();

    public EmailDetail(String username) throws HeadlessException {
        super();
        this.username = username;
        senderGmail.setText(getUsername() + "@foofle.com");
        setTitle("Mail");
        setLayout(new BorderLayout());
        setVisible(true);
        setSize(600, 550);
        setLocationAndSize();
        addComponentsToContainer();
        addDetails();
        c.setLayout(null);
    }

    public void setLocationAndSize() {
        sender.setBounds(30, 30, 100, 30);
        senderGmail.setBounds(130, 30, 400, 30);
        receivers.setBounds(30, 80, 100, 30);
        receiversField.setBounds(130, 80, 400, 30);
        CCReceivers.setBounds(30, 130, 100, 30);
        CCReceiversField.setBounds(130, 130, 400, 30);
        subject.setBounds(30, 180, 100, 30);
        subjectField.setBounds(130, 180, 400, 30);
        content.setBounds(30, 230, 150, 30);
        contentField.setBounds(130, 230, 400, 250);
    }

    public void addDetails() {
        contentField.setEditable(false);
    }

    public void addComponentsToContainer() {
        c.add(sender);
        c.add(senderGmail);
        c.add(receivers);
        c.add(receiversField);
        c.add(CCReceivers);
        c.add(CCReceiversField);
        c.add(subject);
        c.add(subjectField);
        c.add(content);
        c.add(contentField);
        add(c);
    }

    public String getUsername() {
        return username;
    }
}
