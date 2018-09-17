package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public class UserTalker {

    /**
     * @throws IOException обработка ошибки
     * @throws FileNotFoundException если файл не найден
     * @throws NullPointerException дописать ошибку!!!
     * Выводит приветственное сообщение из файла.
     * Если файла не существует, то выводит сообщение по умолчанию.
     */
    void welcomeMessage() throws IOException {

        final String FILENAME = "welcomeMessage.txt";

        /*Обрабатываем исключение, если файла с приветсвенным текстом не существует*/
        try {
            FileManager fileManager = new FileManager(FILENAME);

            // Печатаем содержимое файла
            String line;
            while((line = fileManager.readLine()) != null) {
                System.out.println(line);
            }
        }catch (FileNotFoundException | NullPointerException e){
            System.out.println("[UserTalker.java]Файл "+FILENAME+" не найден. Используется приветствие по умолчанию.");
            defaultWelcomeMessage();
        }
    }

    private void defaultWelcomeMessage(){

        final String WELCOME_TEXT = "Программа запущена. Автор: Куприянов Артур";
        System.out.println(WELCOME_TEXT);
    }
}
