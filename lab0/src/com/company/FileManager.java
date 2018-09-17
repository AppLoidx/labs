package com.company;

import java.io.*;

/**
 * @author Артур Куприянов P3112
 *
 * Используется для работы с файлами
 */
class FileManager {

    /** Чтение из файла */
    private BufferedReader br = null;
    /** Запись в файл*/
    private FileWriter fw;
    private String nameOfFile;
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

        this.nameOfFile = filename;
    }

    //TODO: Write string value to file
    void write(String text) throws IOException {
        fw.write(text);
    }

    //TODO: Write integer value to file
    void writeInt(int integer) throws IOException{
        fw.write(integer);
    }

    //TODO: Read line from file
    String readLine() throws IOException {
        return br.readLine();
    }

    //TODO: Update a FileWriter
    void updateFileWriter() throws IOException {
        fw.close();
        fw = new FileWriter(new File(nameOfFile));
    }
    //TODO: Update a BufferedReader
    void updateBufferedReader() throws IOException{
        br.close();
        br = new BufferedReader(new FileReader(nameOfFile));
    }
    //TODO: Close a FileWriter
    void closeFileWriter() throws IOException{
        fw.close();
    }

}
