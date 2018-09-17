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
}
