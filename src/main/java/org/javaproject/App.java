package org.javaproject;

public class App {

    LocalStorage localStorage = new LocalStorage();
    NetworkStorage networkStorage = new NetworkStorage();

    public String loginOffline(String username, String inputPassword) {
        String expectedPassword;
        try {
            expectedPassword = localStorage.getPassword(username);
        } catch (Exception exception) {
            return "File reading failure. Please try in some time";
        }
        if (expectedPassword.equals(inputPassword)) {
            return "Login successful";
        } else {
            return "Invalid password!";
        }
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.loginOffline("Dhoni", "dhoniPassword"));

    }
}