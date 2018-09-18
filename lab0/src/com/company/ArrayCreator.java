package com.company;

import java.util.Arrays;

class ArrayCreator {

    private UserTalker userTalker = new UserTalker();

    /**
     * Пользователь вводит два числа x и y;
     * Метод возвращает массив заполненный числами от x до y включительно,
     * либо наоборот от y до x, если x > y;
     *
     * @return массив заполненный последовательными числами
     */
    short[] createArrayWithSequenceShortNumbers(){

        short[] values = getTwoSortedShortValues();
        short valueMin = values[0];
        short valueMax = values[1];

        // Создаем массив, который будем возвращать
        short[] array = new short[valueMax-valueMin+1];

        // Заполняем массив последовательными числами
        int temp = 0;
        for(short i = valueMin; i<=valueMax; i++){
            array[temp] = i;
            temp++;
        }
        return array;
    }

    double[] createArrayWithRandomNumbers(){
        double[] values = getTwoSortedDoubleValues();
        double valueMin = values[0];
        double valueMax = values[1];

        double[] array = new double[userTalker.getIntFromUser("Количество чисел: ")];
        for(int i=0;i<array.length;i++) {
            array[i] = valueMin + (int) (Math.random() * ((valueMax - valueMin) + 1));
        }

        return array;
    }

    private short[] getTwoSortedShortValues() {
        short[] array = new short[]{userTalker.getShortFromUser("Введите первое крайнее значение: "),
                                userTalker.getShortFromUser("Введите второе крайнее значение: ")};

        Arrays.sort(array);

        return array;
    }
    private double[] getTwoSortedDoubleValues(){
        double[] array = new double[]{userTalker.getShortFromUser("Введите первое крайнее значение: "),
                userTalker.getShortFromUser("Введите второе крайнее значение: ")};

        Arrays.sort(array);

        return array;
    }
    private float[] getTwoSortedFloatValues(){

        float[] array = new float[]{userTalker.getFloatFromUser("Введите первое крайнее значение: "),
                                    userTalker.getFloatFromUser("Введите второе крайнее значение: ")};

        Arrays.sort(array);

        return array;
    }
    float[][] createMatrixWithUserInputX(int maxValueX, int maxValueY){

        /* Получаем количество строк ограничиваяясь переменной maxValueX */
        System.out.print("Максимальное значение строк: ");
        System.out.println(maxValueX);
        int x = userTalker.getIntFromUser("Количество строк:");
        if (x > maxValueX){
            System.out.println("Введенное вами значение первосходит максимальное значение."+
                    "\n По умолчанию взято максимально возможное значение.");
            x = maxValueX;
        } else if (x < 1) {
            System.out.println("Введеное вами значение некорректно для матрицы."+
                    "\nКоличество строк не должно быть меньше единицы. По умолчанию взято минимальное значение.");
            x = 1;
        }

        /* Получаем количество столбцов ограничиваясь переменной maxValueY */
        System.out.print("Максимальное значение стобцов: ");
        System.out.println(maxValueY);
        int y = userTalker.getIntFromUser("Количество столбцов:");
        if (y > maxValueY){
            System.out.println("Введенное вами значение первосходит максимальное значение."+
                    "\n По умолчанию взято максимально возможное значение.");
            y = maxValueY;
        } else if(y<1){
            System.out.println("Введеное вами значение некорректно для матрицы."+
                    "\nКоличество столбцов не должно быть меньше единицы. По умолчанию взято минимальное значение.");
            y = 1;
        }

        return new float[x][y];
    }
    float[][] getFilledMatrix(float[][] matrix,short[] a,double[] x){

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){

                if (a[i] == 10){
                    matrix[i][j] = (float) Math.asin(
                            Math.exp(
                                    Math.pow(
                                            -1.0*Math.pow(
                                                        Math.tan(x[i]),
                                                        2.0),
                                            1/3.0
                                    )
                            )
                    );

                }else if(a[i] == 8 || a[i] == 12 || a[i] == 18){
                    matrix[i][j] = (float) Math.exp(
                            Math.pow(
                                    Math.pow(x[i],x[i]),
                                    ((1/3.0+Math.pow(x[i],1/3.0)) / 2) / 3 * (3+x[i])
                            )
                    );
                }
                else{
                    matrix[i][j] = (float) Math.log(
                            Math.pow(
                                    Math.cos(
                                            Math.pow(
                                                    Math.log(
                                                            Math.acos((x[i]-5)/16)
                                                    ),
                                                    2 * Math.log(
                                                            Math.pow(
                                                                    Math.cos(x[i]),
                                                                    2
                                                            )
                                                    )
                                            )
                                    ),
                                    2
                            )
                    );
                }
            }
        }

        return matrix;
    }
}
