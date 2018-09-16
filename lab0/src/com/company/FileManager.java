package com.company;

import java.io.*;

public class FileManager {
    private BufferedReader br = null;
    private FileWriter fw;

    FileManager(String filename) throws IOException {
        try {
            this.br = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.fw = new FileWriter(new File(filename),true);
    }

}
