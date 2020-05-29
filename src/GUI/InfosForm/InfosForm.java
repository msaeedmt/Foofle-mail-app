package GUI.InfosForm;

import Logic.SQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfosForm extends JFrame {
    private SQL sql = null;
    private String username;
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
    private JLabel address = new JLabel("Address");
    private JTextField addressField = new JTextField();
    private JLabel password = new JLabel("Password");
    private JTextField passwordFeild = new JTextField();
    private JLabel signUpPhone = new JLabel("signUpPhone");
    private JTextField signUpPhoneField = new JTextField();


    public InfosForm(SQL sql, String username) {
        this.sql = sql;
        this.username = username;
        setVisible(true);
        setSize(600, 600);
        setLayout(null);
        setLocationAndSize();
        addComponentsToContainer();
    }

    public void setLocationAndSize() {
        firstName.setBounds(30, 30, 100, 30);
        firstNameField.setBounds(130, 30, 420, 30);
        lastName.setBounds(30, 80, 100, 30);
        lastNameField.setBounds(130, 80, 420, 30);
        nickName.setBounds(30, 130, 100, 30);
        nickNameField.setBounds(130, 130, 420, 30);
        birthday.setBounds(30, 180, 100, 30);
        birthdayField.setBounds(130, 180, 420, 30);
        phone.setBounds(30, 230, 150, 30);
        phoneField.setBounds(130, 230, 420, 30);
        codeMeli.setBounds(30, 280, 100, 30);
        codeMeliField.setBounds(130, 280, 420, 30);
        address.setBounds(30, 330, 100, 30);
        addressField.setBounds(130, 330, 420, 30);
        password.setBounds(30, 380, 100, 30);
        passwordFeild.setBounds(130, 380, 420, 30);
        signUpPhone.setBounds(30, 430, 100, 30);
        signUpPhoneField.setBounds(130, 430, 420, 30);
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
        add(password);
        add(passwordFeild);
        add(signUpPhone);
        add(signUpPhoneField);
    }


    public void setDetailes(String firstname, String lastname, String nickname, String birthday, String phone, String codeMeli, String address) {
        firstNameField.setText(firstname);
        lastNameField.setText(lastname);
        nickNameField.setText(nickname);
        birthdayField.setText(birthday);
        phoneField.setText(phone);
        codeMeliField.setText(codeMeli);
        addressField.setText(address);
    }

    public SQL getSql() {
        return sql;
    }

    public String getUsername() {
        return username;
    }
}
