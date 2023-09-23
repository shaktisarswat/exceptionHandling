package org.javaproject;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {

    LocalStorage localStorage = new LocalStorage();
    NetworkStorage networkStorage = new NetworkStorage();

    public String loginOffline(String username, String inputPassword) {
        String expectedPassword;
        try {
            expectedPassword = localStorage.getPassword(username);
        } catch (FileNotFoundException exceptionObject) {
            // log error trace to file
            // exceptionObject.printStackTrace();
            expectedPassword = loginOnline(username, inputPassword);
        } catch (IOException exceptionObject) {
            // log error trace to file
            // exceptionObject.printStackTrace();
            return "Internal error, please try again later";

        }
        if (expectedPassword.equals(inputPassword)) {
            return "Login successful";
        } else {
            return "Invalid password!";
        }
    }

    public String loginOnline(String username, String password) {
        try {
            String expected = networkStorage.getPassword(username);
            return expected;

        } catch (IOException e) {
            // log error trace to file
            e.printStackTrace();
            return "Internal error, please try again later";
        }
    }


    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.loginOffline("Dhoni", "dhoniPassword"));

    }
}