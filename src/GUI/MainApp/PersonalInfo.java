package GUI.MainApp;

import javax.swing.*;
import java.awt.*;

public class PersonalInfo extends JPanel {
    private JLabel firstName = new JLabel("Firstname");
    private JTextField firstNameField = new JTextField();
    private JLabel lastName = new JLabel("Lastname");
    private JTextField lastNameField = new JTextField();
    private JLabel nickName = new JLabel("Nickname");
    private JTextField nickNameField = new JTextField();
    private JLabel phone = new JLabel("Phone");
    private JTextField phoneField = new JTextField();
    private JLabel birthday = new JLabel("Birthday");
    private JTextField birthdayField = new JTextField();
    private JLabel codeMeli = new JLabel("Code meli");
    private JTextField codeMeliField = new JTextField();
    private JLabel address=new JLabel("Address");
    private JTextField addressField=new JTextField();
    private JButton save=new JButton("Save");
    private JButton delete=new JButton("Delete");

    public PersonalInfo() {
        setLayout(null);
        setLocationAndSize();
        addComponentsToContainer();
    }

    public void setLocationAndSize() {
        firstName.setBounds(30,30,100,30);
        firstNameField.setBounds(130,30,400,30);
        lastName.setBounds(30,90,100,30);
        lastNameField.setBounds(130,90,400,30);
        nickName.setBounds(30,150,100,30);
        nickNameField.setBounds(130,150,400,30);
        birthday.setBounds(30,210,100,30);
        birthdayField.setBounds(130,210,400,30);
        phone.setBounds(30,270,150,30);
        phoneField.setBounds(130,270,400,30);
        codeMeli.setBounds(30,330,100,30);
        codeMeliField.setBounds(130,330,400,30);
        address.setBounds(30,390,100,30);
        addressField.setBounds(130,390,400,30);
        save.setBounds(30,490,200,40);
        delete.setBounds(500,490,100,40);
    }

    public void addComponentsToContainer() {
        add(firstName);
        add(firstNameField);
        add(lastName);
        add(lastNameField);
        add(nickName);
        add(nickNameField);
        add(birthday);
        add(birthdayField);
        add(phone);
        add(phoneField);
        add(codeMeli);
        add(codeMeliField);
        add(address);
        add(addressField);
        add(save);
        add(delete);
    }


}
