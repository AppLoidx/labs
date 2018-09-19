package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    Scanner scanner;

    public static void main(String[] args) throws IOException {

        final String INPUT_FILE = "input.txt";
        UserTalker userTalker = new UserTalker();
        ArrayCreator arrayCreator = new ArrayCreator();
        //UserInput userInput = new UserInput();

        userTalker.welcomeMessage();

        boolean workWithFile = userTalker.askYesNo("Получить вводимые данные из файла?");
        if (workWithFile){
            FileManager fileManager = new FileManager(INPUT_FILE);
            if (fileManager.checkError()) {
                System.out.print("Работа с файлами невозможна. Ошибка(-и):\n ");
                fileManager.printError();
                workWithFile = false;
            }
        }

        System.out.println("Создание массива а:");
        short[] a;
        a = arrayCreator.createArrayWithSequenceShortNumbers();

        System.out.println("Создание массива x:");
        double[] x;
        x = arrayCreator.createArrayWithRandomNumbers();

        final int MAX_VALUE_X = a.length;
        final int MAX_VALUE_Y = x.length;

        float[][] matrix;
        matrix = arrayCreator.getFilledMatrix(arrayCreator.createMatrixWithUserInputX(MAX_VALUE_X,MAX_VALUE_Y),a,x);

        for (float[] f1: matrix
             ) {
            for (float f2: f1
                 ) {
                System.out.printf("%.3f",f2);
                System.out.print(" ");
            }
            System.out.println();
        }



        System.out.println(userTalker.askYesNo("Вы хотите тортик?"));

    }

}
