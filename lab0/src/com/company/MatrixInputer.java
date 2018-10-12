package com.company;


class MatrixInputer {

    static void printOnConsoleFloat(float[][] matrix, int spaceForElement){

        // Переменная для записи длины числа
        int wordLen;

        // foreach-цикл для обхода каждого элемента матрицы
        for (float[] f1: matrix
             ) {
            for (float f2: f1
                 ) {

                // Если элемент являтся Infinity, сокращаем его имя до Inf, для форматиртованного вывода
                if(Float.isInfinite(f2)) {
                    wordLen = 3;
                    System.out.print(addSpace(spaceForElement - wordLen) + "Inf");
                }

                else {
                    // Если элемент является NaN, то присваиваем ей длину 3
                    if (Float.isNaN(f2)) {
                        wordLen = 3;
                        System.out.printf(addSpace(spaceForElement - wordLen) + "%f", f2);
                    } else {

                        // Получаем длину элемента (отрицательного и положительного
                        // wordLen присвоим целую часть числа вместо со знаком (+(empty)\-)
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

    /** Возвращает пробелы в количестве value */
    static private String addSpace(int value){
        StringBuilder s = new StringBuilder();
        for(int i=0;i<value;i++){
            s.append(" ");
        }
        return s.toString();
    }
}
