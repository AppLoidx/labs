package com.company;

import java.io.*;

/**
 * @author Артур Куприянов P3112
 *
 * Используется для работы с файлами
 */
class FileManager {

    // Чтение из файла
    private BufferedReader br = null;

    // Запись в файл
    private FileWriter fw;

    // Имя файла, с которым работает класс
    private String nameOfFile;

    // Фиксируем на ошибки
    private boolean error = false;

    // Строка с ошибками для вывода информации
    private String errorMessage = "";

    /**
     * @param filename Имя файла, с которым надо работать
     * @throws IOException Обработка исключения ввода/вывода
     */
    FileManager(String filename) throws IOException {

        try {
            this.br = new BufferedReader(new FileReader(filename));
            this.fw = new FileWriter(new File(filename),true);

            this.nameOfFile = filename;

        } catch (FileNotFoundException e) {
            System.out.println("[FileManager]Ошибка в работе программы, не найден файл "+filename+".");
            error = true;
            errorMessage+="FileNotFoundException\n";
        }

    }
    boolean checkError(){
        return error;
    }
    /** Возвращает строку с ошибками */
    String[] getError(){
        return (errorMessage.split("\n"));
    }

    /** Если есть ошибки - выводит на экран*/
    void printError(){
        if (error){
            System.out.println(errorMessage);
        }else{
            System.out.println("Ошибок нет");
        }
    }

    //TODO: Write string value to file
    void writeStr(String text) throws IOException {
        fw.write(text);
    }
    void appendStr(String text) throws IOException{
        fw.append(text);
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
