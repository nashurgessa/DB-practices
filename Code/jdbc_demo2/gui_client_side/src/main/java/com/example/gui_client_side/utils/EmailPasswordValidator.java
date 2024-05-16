package com.example.gui_client_side.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailPasswordValidator {

    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9_+.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern emailPart = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPart.matcher(email);
        return matcher.matches();

    }

    public boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&+=])(?=\\S+$).{6,24}$";
        Pattern passwordPart = Pattern.compile(passwordRegex);
        Matcher matcher = passwordPart.matcher(password);
        return matcher.matches();

    }
}
