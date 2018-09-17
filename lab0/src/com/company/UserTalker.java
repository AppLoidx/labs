package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

class UserTalker {

    private Scanner scanner = new Scanner(System.in);

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

    /**
     * Задает вопрос пользователю и получает от него ответ, который возвращает.
     * Если ответ введен некорректно, рекурсивно вызывает саму себя.
     * @param message Сообщение пользователю
     * @return Ответ выбранный пользователем. true -Y, false -N
     */
    boolean askYesNo(String message){
        scanner = new Scanner(System.in);
        System.out.println(message+" <Y/N>?");
        String user_input = scanner.nextLine();
        switch (user_input.toUpperCase()){
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("Вы ввели недопустимое значение. Повторите ввод.");
                return askYesNo("");
        }
    }

    /**
     * Возвращает целое число, полученное вводом пользователя
     * При некорректном вводе, повторяет рекурсивно операцию
     * @return ответ пользователя типа int
     */
    int getIntFromUser(){
        updateScanner();
        int user_input;

        /*Обработка ошибочного ввода пользователя*/
        try {
            user_input = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Некорректно введены данные. Повторите ввод.");
            user_input = getIntFromUser();
        }
        return user_input;
    }
    /** Перегрузка метода с сообщением */
    int getIntFromUser(String message){
        System.out.println(message);
        return getIntFromUser();
    }

    /**
     * Возвращает целое число, полученное вводом пользователя
     * При некорректном вводе, повторяет рекурсивно операцию
     * @return ответ пользователя типа float
     */
    float getFloatFromUser(){
        updateScanner();
        float user_input;

        /*Обработка ошибочного ввода пользователя*/
        try {
            user_input = scanner.nextFloat();
        }catch (InputMismatchException e){
            System.out.println("Некорректно введены данные. Повторите ввод.");
            user_input = getFloatFromUser();
        }
        return user_input;
    }

    /** Перегрузка метода с сообщением */
    float getFloatFromUser(String message){
        System.out.println(message);
        return getFloatFromUser();
    }
    private void defaultWelcomeMessage(){
        final String WELCOME_TEXT = "Программа запущена. Автор: Куприянов Артур";
        System.out.println(WELCOME_TEXT);
    }
    private void updateScanner(){
        scanner = new Scanner(System.in);
    }

    short getShortFromUser(){
        updateScanner();
        short user_input;

        /*Обработка ошибочного ввода пользователя*/
        try {
            user_input = scanner.nextShort();
        }catch (InputMismatchException e){
            System.out.println("Некорректно введены данные. Повторите ввод.");
            user_input = getShortFromUser();
        }
        return user_input;
    }

    /** Перегрузка метода с сообщением */
    short getShortFromUser(String message){
        System.out.println(message);
        return getShortFromUser();
    }
}
