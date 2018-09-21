package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

class MatrixInputer {

    static void printOnConsoleFloat(float[][] matrix, int spaceForElement){

        // Переменная для записи длины числа
        int wordLen;

        // foreach-цикл для обхода каждого элемента матрицы
        for (float[] f1: matrix
             ) {
            for (float f2: f1
                 ) {

                if(Float.isInfinite(f2)) {
                    wordLen = 3;
                    System.out.print(addSpace(spaceForElement - wordLen) + "Inf");
                }

                else {
                    if (Float.isNaN(f2)) {
                        wordLen = 3;
                        System.out.printf(addSpace(spaceForElement - wordLen) + "%.3f", f2);
                    } else {

                        if (f2<0 && (int) f2 == 0){
                            wordLen = 2;
                        }else wordLen = String.valueOf((int)f2).length();

                        // 4 - запятая и три знака после неё
                        System.out.printf(addSpace(spaceForElement - wordLen - 4) + "%.3f", f2);
                    }
                }
            }
            System.out.println();
        }


    }

    /** Возвращает пробелы в количестве value*/
    static private String addSpace(int value){
        StringBuilder s = new StringBuilder();
        for(int i=0;i<value;i++){
            s.append(" ");
        }
        return s.toString();
    }
}
