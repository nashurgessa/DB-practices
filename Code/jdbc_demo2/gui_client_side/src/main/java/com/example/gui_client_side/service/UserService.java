package com.example.gui_client_side.service;

import com.example.gui_client_side.common.HttpBackendConnector;
import com.example.gui_client_side.model.User;
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
        // Create a model object
        User newUser = new User(name, email, password);
        System.out.println(newUser.toString());
        //
        boolean result = sendToServer(newUser);

        // Jame`s task // SAVE TO LOCAL db
        return  true;
    }


    boolean sendToServer(User newUser) {
        // Jsonfiy
        String jsonBody = newUser.getJson();
        try{
            HttpBackendConnector.getInstance().send(jsonBody, "register");
        } catch (Exception err) {

        }
        return true;
        }



    public boolean isEmailPasswordValid(String email, String password) {
        return validator.isValidEmail(email) && validator.isValidPassword(password);

    }}
