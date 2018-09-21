package com.company;

import java.util.Arrays;

class ArrayCreator {

    private UserTalker userTalker = new UserTalker();

    /**
     * Пользователь вводит два числа x и y;
     * Метод возвращает массив заполненный числами от x до y включительно,
     * либо наоборот от y до x, если x > y;
     *
     * Перегрузка : если не заданы аргументы, запрашивает их у пользователя
     *
     * @return массив заполненный последовательными числами
     */
    short[] createArrayWithSequenceShortNumbers(){

        short[] values = getTwoSortedShortValues();
        short valueMin = values[0];
        short valueMax = values[1];

        return createArrayWithSequenceShortNumbers(valueMin,valueMax);
    }

    /** Перегрузка метода */
    short[] createArrayWithSequenceShortNumbers(short valueMin,short valueMax){


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

    /**
     * Возвращает массив, элементы которого являются случайными числами
     * в диапозоне от valueMin до valueMax
     *
     * Перегрузка : если не заданы аргументы, запрашивает их у пользователя
     *
     * @return массив заполненный случайными числами
     */
    double[] createArrayWithRandomNumbers(){

        double[] values = getTwoSortedDoubleValues();
        double valueMin = values[0];
        double valueMax = values[1];
        int arrayLen = userTalker.getIntFromUser("Количество чисел: ");

        return createArrayWithRandomNumbers(valueMin,valueMax,arrayLen);
    }

    /** Перегрузка метода */
    double[] createArrayWithRandomNumbers(double valueMin, double valueMax, int arrayLen){

        double[] array = new double[arrayLen];
        for(int i=0;i<array.length;i++) {

            // Присваиваем случайное значение от valueMin до valueMax
            array[i] = valueMin + (int) (Math.random() * ((valueMax - valueMin) + 1));
        }

        return array;
    }

    //TODO: Запрашивает у пользователя два крайних значения типа short.
    private short[] getTwoSortedShortValues() {
        short[] array = new short[]{userTalker.getShortFromUser("Введите первое крайнее значение: "),
                                userTalker.getShortFromUser("Введите второе крайнее значение: ")};

        // Сортируем полученные значения, чтобы сначала стояло меньшее значение, затем большее
        Arrays.sort(array);

        return array;
    }
    //TODO: Запрашивает у пользователя два крайних значения типа double.
    private double[] getTwoSortedDoubleValues(){
        double[] array = new double[]{userTalker.getShortFromUser("Введите первое крайнее значение: "),
                userTalker.getShortFromUser("Введите второе крайнее значение: ")};

        // Сортируем полученные значения, чтобы сначала стояло меньшее значение, затем большее
        Arrays.sort(array);

        return array;
    }

    //TODO: Запрашивает у пользователя два крайних значения типа float.
    private float[] getTwoSortedFloatValues(){

        float[] array = new float[]{userTalker.getFloatFromUser("Введите первое крайнее значение: "),
                                    userTalker.getFloatFromUser("Введите второе крайнее значение: ")};

        // Сортируем полученные значения, чтобы сначала стояло меньшее значение, затем большее
        Arrays.sort(array);

        return array;
    }

    //TODO: Создает матрицу, размеры заданы как аргументы
    float[][] createMatrix(int height, int width){

        return new float[height][width];
    }

    //TODO: Создает матрицу, размеры которого задает пользователь, огриченные макс. и мин. значением
    float[][] createMatrixWithUserInput(int maxValueY, int maxValueX){

        // Получаем количество строк (height) ограничиваяясь переменной maxValueY

        System.out.printf("Максимальное значение строк: %d\n",maxValueY);
        int height = userTalker.getIntFromUser("Количество строк:");

        // Проверяем на возможные конфликты
        if (height > maxValueY){
            System.out.println("Введенное вами значение первосходит максимальное значение."+
                    "\n По умолчанию взято максимально возможное значение.");
            height = maxValueY;
        } else if (height < 1) {
            System.out.println("Введеное вами значение некорректно для матрицы."+
                    "\nКоличество строк не должно быть меньше единицы. По умолчанию взято минимальное значение.");
            height = 1;
        }

        // Получаем количество столбцов (width) ограничиваясь переменной maxValueX

        System.out.printf("Максимальное значение столбцов: %d\n",maxValueX);
        int width = userTalker.getIntFromUser("Количество столбцов:");

        // Проверяем на возможные конфликты
        if (width > maxValueX){
            System.out.println("Введенное вами значение первосходит максимальное значение."+
                    "\n По умолчанию взято максимально возможное значение.");
            width = maxValueX;
        } else if(width<1){
            System.out.println("Введеное вами значение некорректно для матрицы."+
                    "\nКоличество столбцов не должно быть меньше единицы. По умолчанию взято минимальное значение.");
            width = 1;
        }

        return createMatrix(height, width);
    }

    //TODO: Заполняет массив элементами, которые высчитываются согласно условию задачи
    float[][] getFilledMatrix(float[][] matrix,short[] a,double[] x){

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){

                if (a[i] == 10){
                    matrix[i][j] = (float) Math.asin(
                            Math.exp(
                                    Math.pow(
                                            -1.0*Math.pow(
                                                        Math.tan(x[j]),
                                                        2.0),
                                            1/3.0
                                    )
                            )
                    );

                }else if(a[i] == 8 || a[i] == 12 || a[i] == 18){
                    matrix[i][j] = (float) Math.exp(
                            Math.pow(
                                    Math.pow(x[j],x[j]),
                                    ((1/3.0+Math.pow(x[j],1/3.0)) / 2) / 3 * (3+x[j])
                            )
                    );
                }
                else{
                    matrix[i][j] = (float) Math.log(
                            Math.pow(
                                    Math.cos(
                                            Math.pow(
                                                    Math.log(
                                                            Math.acos((x[j]-5)/16)
                                                    ),
                                                    2 * Math.log(
                                                            Math.pow(
                                                                    Math.cos(x[j]),
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
