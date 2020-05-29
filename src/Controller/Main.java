package Controller;

import GUI.Authentication.Form;
import GUI.MainApp.UserForm;
import Logic.SQL;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SQL sql = new SQL();
        new Form(sql);
//        new UserForm(sql,"saeed");
    }
}
