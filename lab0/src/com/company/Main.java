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
        ArrayCreator arrayCreator = new ArrayCreator();
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
        short[] a = arrayCreator.createArrayWithSequenceShortNumbers();
        double[] x = arrayCreator.createArrayWithRandomNumbers();
        int lenA = a.length;
        int lenX = x.length;
        int maxValue;
        if (lenA < lenX){
            maxValue = lenA;
        }else{
            maxValue = lenX;
        }

        float[][] matrix = arrayCreator.getFilledMatrix(arrayCreator.createMatrixWithUserInputX(maxValue),a,x);

        for (float[] f1: matrix
             ) {
            for (float f2: f1
                 ) {
                System.out.print(f2);
                System.out.print(" ");
            }
            System.out.println();
        }



        System.out.println(userTalker.askYesNo("Вы хотите тортик?"));

    }

}
