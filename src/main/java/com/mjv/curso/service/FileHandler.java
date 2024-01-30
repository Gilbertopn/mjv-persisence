package com.mjv.curso.service;

import com.mjv.curso.model.User;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String DIRECTORY_PATH = "data";
    private static final String FILE_PATH = DIRECTORY_PATH + "/users.txt";

    public static void createDirectory() {
        File directory = new File(DIRECTORY_PATH);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public static void writeUserToFile(User user) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(user.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> readUsersFromFile() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(", ");
                String fullName = userData[0].substring(6);
                int age = Integer.parseInt(userData[1].substring(7));
                String profession = userData[2].substring(11);
                users.add(new User(fullName, age, profession));
            }
        } catch (IOException e) {

        }
        return users;
    }
}
