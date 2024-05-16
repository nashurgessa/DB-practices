package com.example.gui_client_side.service;

import com.example.gui_client_side.utils.EmailPasswordValidator;

public class UserService {

    public UserService(){}

    private final EmailPasswordValidator validator = new EmailPasswordValidator();


    public boolean registerUser(String name, String email, String password) {
        // Aldin's task // verify the password and email
        if (!isEmailPasswordValid(email, password)) {
            return false;
        }

        // Ken's task // send to server, retrieve the Id

        // Jame`s task // SAVE TO LOCAL db
        return  true;
    }



    public boolean isEmailPasswordValid(String email, String password) {
        return validator.isValidEmail(email) && validator.isValidPassword(password);

    }}
