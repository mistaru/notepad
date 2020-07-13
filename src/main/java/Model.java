import javax.swing.*;
import java.awt.print.PrinterException;

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
 * The Model class manages data and program logic.
 * In the class, the Model is initialized by the Viewer to send data directly to the Viewer
 **Allows you to open a document from a folder,
 * create a new document, save a document,
 * change the Status bar, and so on.
 */
public class Model {

    private Viewer viewer;
    private boolean statusBar = true;


    /**
     * constructor of the Model class
     * Initializing the Viewer and WriteAndRead in the constructor
     */
    Model(Viewer viewer) {
        this.viewer = viewer;
        WriteAndRead writeAndRead = new WriteAndRead();
    }


    /**
     * doAction
     * Basic logic of the program
     * The controller sends a command,
     * the model examines it, and when detected,
     * performs this action,
     * after which the break statement is called
     * @param value stores the command name
     */
    void doAction(String value) {
        switch (value) {
            case "New Document":
                viewer.newDocument();
                break;
            case "Save Document":
                viewer.saveDocument();
                break;
            case "Save As Document":
                viewer.saveAsDoc();
                break;
            case "Open Document":
                String fileName = viewer.openFileChooser();
                if (fileName == null) {
                    System.out.println("you didn't choose file");
                } else {
                    String text = open(fileName);
                    viewer.update(text);
                }
                break;
            case "status":
                if (statusBar) {
                    viewer.countManager(statusBar);
                    statusBar = false;
                } else {
                    viewer.countManager(statusBar);
                    statusBar = true;
                }
                break;
            case "Close Program":
                exit();
                break;
            case "Print Document":

                JTextPane textPane = new JTextPane();
                try {
                    textPane.setText(viewer.printer());
                    textPane.print();
                } catch (PrinterException ex) {
                    System.out.println("Error");
                }
                break;
            case "undo":
                viewer.undoStep();
                break;
            case "redo":
                viewer.redoStep();
                break;
            case "copy word":
                viewer.copyWord();
                break;
            case "cut word":
                viewer.cutWord();
                break;
            case "paste word":
                viewer.pasteWord();
                break;
            case "delete word":
                viewer.deleteWord();
                break;
            case "blue back":
                viewer.setColorBackground(1);
                break;
            case "red back":
                viewer.setColorBackground(2);
                break;
            case "green back":
                viewer.setColorBackground(3);
                break;
            case "white back":
                viewer.setColorBackground(4);
                break;
            case "blueF":
                viewer.setColorForeground(1);
                break;
            case "redF":
                viewer.setColorForeground(2);
                break;
            case "greenF":
                viewer.setColorForeground(3);
                break;
            case "arial":
                viewer.setFamily(1);
                break;
            case "serif":
                viewer.setFamily(2);

                break;
            case "italic":
                viewer.setStyle(1);
                break;
            case "plain":
                viewer.setStyle(3);
                break;
            case "bold":
                viewer.setStyle(2);
                break;
            case "s10":
                viewer.setSize(10);
                break;
            case "s30":
                viewer.setSize(30);
                break;
            case "s70":
                viewer.setSize(70);
                break;
            case "about":

                JOptionPane.showMessageDialog(null, "Intern Labs 2020\n\nArgen Kasymov\n--------------------------------------------------------\n Bishkek", "", JOptionPane.INFORMATION_MESSAGE);

                break;
        }

    }


    /**
     * open
     * Reads text from a file and returns text
     * @param fileName stores the file name
     */
    private String open(String fileName) {
        return WriteAndRead.readFromFile(fileName);
    }


    /**
     * exit
     * Exit the program
     */
    private void exit() {
        System.exit(0);
    }


    /**
     * countCharacterAndLine
     * Counts the quantity of characters and lines
     */
    void countCharacterAndLine() {
        viewer.countCharacterAndLine();
    }
}