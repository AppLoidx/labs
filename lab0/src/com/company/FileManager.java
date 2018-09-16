package com.company;

import java.io.*;

/**
 * @author Артур Куприянов P3112
 *
 * Используется для работы с файлами
 */
public class FileManager {

    /** Чтение из файла */
    private BufferedReader br = null;
    /** Запись в файл*/
    private FileWriter fw;


    /**
     * @param filename Имя файла, с которым надо работать
     * @throws IOException Обработка исключения ввода/вывода
     */
    FileManager(String filename) throws IOException {

        try {
            this.br = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Ошибка в работе программы");
        }
        this.fw = new FileWriter(new File(filename),true);
    }

}
