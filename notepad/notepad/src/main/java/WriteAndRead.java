import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Copyright (C) 2020 Intern Labs O!
 * <p>
 * Notepad program made with Java and Swing with MVC pattern
 * Main features:
 * This program repeats the main functions of Windows Notepad.
 * Its features:
 * create a new document,
 * open a document,
 * save a document,
 * print a document,
 * and so on.
 *
 * @author Argen Kasymov
 */


/**
 * class WriteAndRead
 * Has method readFromFile
 * Method readFromFile reads text from a file and returns text
 */
public class WriteAndRead {

    WriteAndRead() {

    }

    /**
     * readFromFile
     * Reads text from a file and returns text
     * @param fileName stores the file name
     */
    static String readFromFile(String fileName) {
        String text = "";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String l;
            while ((l = bufferedReader.readLine()) != null) {
                text = text + l + "\n";
            }

            bufferedReader.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        return text;
    }
}