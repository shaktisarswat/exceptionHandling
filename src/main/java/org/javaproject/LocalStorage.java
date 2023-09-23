package org.javaproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LocalStorage {
    public String getPassword(String username) throws IOException {
        Map<String, String> unameToPassMap = new HashMap<>();
        unameToPassMap = getUsernameToPasswordMapping();
        String password = unameToPassMap.get(username);
        return password;
    }

    public Map<String, String> getUsernameToPasswordMapping() throws IOException {
        // read login data from file
        File loginDataFile = new File("src/main/resources/UnameToPass.txt");
        FileReader fileReader = new FileReader(loginDataFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        System.out.println("Opened resource");

        String inputLine, userName, password;
        Map<String, String> unameToPassMap = new HashMap<String, String>();

        // map each username password pair
        while ((inputLine = bufferedReader.readLine()) != null)
        {
            userName = inputLine.split(":")[0];
            password = inputLine.split(":")[1];
            unameToPassMap.put(userName, password);
        }

        bufferedReader.close();
        fileReader.close();
        System.out.println("Closed resource");
        return unameToPassMap;
    }
}
