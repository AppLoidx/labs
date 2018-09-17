package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        final String INPUT_FILE = "input.txt";

        try {
            FileManager FileManager = new FileManager(INPUT_FILE);
        }catch (FileNotFoundException e){
            System.out.println("Файл "+INPUT_FILE+" не найден.");
        }
        UserTalker UserTalker = new UserTalker();
        UserTalker.welcomeMessage();

    }
}
