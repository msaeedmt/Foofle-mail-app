package GUI.MainApp;

import Logic.SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonalInfo extends JPanel implements ActionListener {
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
    private JTextField passwordFeild=new JTextField();
    private JLabel signUpPhone=new JLabel("signUpPhone");
    private JTextField signUpPhoneField=new JTextField();
    private JRadioButton accessAll=new JRadioButton("access to all");
    private JRadioButton accessNobody=new JRadioButton("access to nobody");
    private ButtonGroup bg=new ButtonGroup();
    private JTextField exceptions=new JTextField();
    private JLabel execptionsLable=new JLabel("exceptions");
    private JButton save = new JButton("Save");
    private JButton delete = new JButton("Delete");


    public PersonalInfo(SQL sql, String username) {
        this.sql = sql;
        this.username = username;
        setLayout(null);
        setLocationAndSize();
        addComponentsToContainer();
        addActions();
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
        password.setBounds(30,380,100,30);
        passwordFeild.setBounds(130,380,420,30);
        signUpPhone.setBounds(30,430,100,30);
        signUpPhoneField.setBounds(130,430,420,30);
        accessAll.setBounds(30,480,100,30);
        accessNobody.setBounds(130,480,150,30);
        exceptions.setBounds(300,480,250,30);
        execptionsLable.setBounds(300,510,100,15);
        save.setBounds(30, 530, 200, 40);
        delete.setBounds(450, 530, 100, 40);
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
        add(accessAll);
        add(accessNobody);
        bg.add(accessAll);bg.add(accessNobody);
        add(exceptions);add(execptionsLable);
        add(save);
        add(delete);
    }

    public void addActions() {
        save.addActionListener(this::actionPerformed);
    }

    public void fillTheFields() throws SQLException {
        ResultSet resultSet=getSql().getInfo(getUsername());
        while (resultSet.next()){
            firstNameField.setText(resultSet.getString("firstName"));
            lastNameField.setText(resultSet.getString("lastName"));
            nickNameField.setText(resultSet.getString("nickName"));
            birthdayField.setText(resultSet.getString("birthday"));
            phoneField.setText(resultSet.getString("phone"));
            codeMeliField.setText(resultSet.getString("codeMeli"));
            addressField.setText(resultSet.getString("address"));
            signUpPhoneField.setText(resultSet.getString("signUpPhone"));
            if (resultSet.getString("totalPermisson").equals("true")) {
                accessAll.setSelected(true);
            } else {
                accessNobody.setSelected(true);
            }
            ResultSet resultSet1=getSql().getExceptions(getUsername());
            while (resultSet1.next()){
                exceptions.setText(exceptions.getText()+" "+resultSet1.getString("destPerson"));
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == save) {
            try {
                String isTrue="false";
                if (accessAll.isSelected()){
                    isTrue="true";
                }
                getSql().updateInfo(firstNameField.getText(), lastNameField.getText(), nickNameField.getText(),
                        birthdayField.getText(), phoneField.getText(), codeMeliField.getText()
                        , addressField.getText(), getUsername(),signUpPhoneField.getText(),isTrue);
                if (!passwordFeild.getText().equals("")){
                    getSql().updatePassword(getUsername(),passwordFeild.getText());
                }
                getSql().deleteExceptions(getUsername());
                String[] exceptionsArray=exceptions.getText().trim().split(" ");
                for (int i = 0; i < exceptionsArray.length; i++) {
                    getSql().addException(getUsername(),exceptionsArray[i]);
                }
            } catch (SQLException e) {
                while (e!=null){
                    System.out.println(e.getMessage());
                    e=e.getNextException();
                }
            }
        }
    }

    public SQL getSql() {
        return sql;
    }

    public String getUsername() {
        return username;
    }
}
