package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    Scanner scanner;

    public static void main(String[] args) throws IOException {

        final String INPUT_FILE = "inut.txt";
        UserTalker userTalker = new UserTalker();
        UserInput userInput = new UserInput();

        boolean workWithFile = userTalker.askYesNo("Получить вводимые данные из файла?");
        if (workWithFile){
            FileManager fileManager = new FileManager(INPUT_FILE);
            if (fileManager.checkError()) {
                System.out.print("Работа с файлами невозможна. Ошибка(-и):\n ");
                fileManager.printError();
                workWithFile = false;
            }
        }



        System.out.println(userTalker.askYesNo("Вы хотите тортик?"));

    }

}
