package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws IOException {

        /*Подгружаем файл, с которого будем считывать данные.
        * Ошибки обработаны в самом классе FileManager
        * По умолчанию имя файла для работы: "input.txt"*/
        final String INPUT_FILE = "input.txt";
        FileManager fileManager = new FileManager(INPUT_FILE);

        // Для работы с вводом пользователя
        UserTalker userTalker = new UserTalker();

        // Для создания матриц и его заполнения
        ArrayCreator arrayCreator = new ArrayCreator();

        userTalker.welcomeMessage();

        // Считывание данных с файла - true, иначе false
        boolean workWithFile = userTalker.askYesNo("Получить вводимые данные из файла?");

        if (workWithFile){

            // Проверяем ошибки при работе с файлом
            // Если найдена ошибка, то переходим на ввод пользователя
            if (fileManager.checkError()) {
                System.out.print("Работа с файлами невозможна. Ошибка(-и):\n ");
                fileManager.printError();
                workWithFile = false;
            }
        }

        // Массив с последовательными числами
        short[] a;
        // Массив с случайными числами
        double[] x;

        // Условие для выбора способа получения данных: с файла\ с ввода пользователя
        if (workWithFile){

            // Считывание данных с файла
            final short MIN_VALUE_FOR_SEQ_ARRAY = Short.parseShort(fileManager.readLine());
            final short MAX_VALUE_FOR_SEQ_ARRAY = Short.parseShort(fileManager.readLine());
            final double MIN_VALUE_FOR_RND_ARRAY = Double.parseDouble(fileManager.readLine());
            final double MAX_VALUE_FOR_RND_ARRAY = Double.parseDouble(fileManager.readLine());
            final int AMOUNT_VALUE_FOR_RND_ARRAY = Integer.parseInt(fileManager.readLine());

            // Создание массива a
            a = arrayCreator.createArrayWithSequenceShortNumbers(MIN_VALUE_FOR_SEQ_ARRAY, MAX_VALUE_FOR_SEQ_ARRAY);

            // Создание массива x
            x = arrayCreator.createArrayWithRandomNumbers(MIN_VALUE_FOR_RND_ARRAY, MAX_VALUE_FOR_RND_ARRAY,
                                                        AMOUNT_VALUE_FOR_RND_ARRAY);
        }else {
            System.out.println("Создание массива а:");
            a = arrayCreator.createArrayWithSequenceShortNumbers();

            System.out.println("Создание массива x:");
            x = arrayCreator.createArrayWithRandomNumbers();
        }

        // Максимальные значения матрицы
        // Для того чтобы не было ошибок при обработке матрицы
        final int MAX_VALUE_Y = a.length;   // макс допустимое значение для строк
        final int MAX_VALUE_X = x.length;   // макс допустимое значение для столбцов

        float[][] matrix;

        if (workWithFile) {

            // Считывание данных с файла

            // Размеры матрицы
            final int HEIGHT_INPUT_FOR_MATRIX = Integer.parseInt(fileManager.readLine()); // высота
            final int WIDTH_INPUT_FOR_MATRIX = Integer.parseInt(fileManager.readLine());    // ширина

            // Обработка элементов массива по формуле из условия задачи с заданными параметрами
            matrix = arrayCreator.getFilledMatrix(arrayCreator.createMatrix(
                    HEIGHT_INPUT_FOR_MATRIX, WIDTH_INPUT_FOR_MATRIX),
                    a, x);
        }else {

            // Обработка элементов массива со вводом пользователя
            matrix = arrayCreator.getFilledMatrix(
                    arrayCreator.createMatrixWithUserInput(MAX_VALUE_Y, MAX_VALUE_X),
                    a, x);
        }

        // Место отведенное для каждого вывода элемента матрицы
        final int SPACE_FOR_ELEMENT = 11;

        if (userTalker.askYesNo("Сделать вывод в файл?")){

            // Стандартный системный поток вывода
            PrintStream standardOut = System.out;

            // Поток вывода переправленный на файл
            PrintStream fo = new PrintStream(new FileOutputStream("output.txt"));

            // Перенаправляем стандартный поток вывода в файл
            System.setOut(fo);

            // Форматированный вывод матрицы
            MatrixInputer.printOnConsoleFloat(matrix,SPACE_FOR_ELEMENT);
            // Так как мы перенаправили поток вывода в файл, то вывод будет производиться не в консоль, а в файл

            // Возвращаем стандартный поток вывода в консоль
            System.setOut(standardOut);

        }else {

            // Форматированный вывод матрицы на консоль
            MatrixInputer.printOnConsoleFloat(matrix, SPACE_FOR_ELEMENT);
        }

        System.out.println(userTalker.askYesNo("Вы хотите тортик?"));

    }

}
