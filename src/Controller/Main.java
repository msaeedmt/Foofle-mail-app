package Controller;

import GUI.Authentication.Form;
import Logic.SQL;

public class Main {
    public static void main(String[] args) {
        SQL sql = new SQL();
        new Form(sql);
//        new UserForm("saeed");
    }
}
