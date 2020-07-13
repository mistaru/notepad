import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
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
 * The Viewer class draws the program's graphics. The Viewer receives data and displays it on the screen.
 */
public class Viewer {

    private Controller controller;
    private JTextArea textArea;
    private JFrame frame;
    private JFileChooser fileChooser;
    private JLabel details;
    private JPanel panel;
    private UndoManager undoManager = new UndoManager();

    /**
     * Viewer Constructor:
     * Initialized: a controller with a reference to this class
     * model instance from the controller
     * canvas instance with reference to the model
     * The rest is the program's graphical interface.
     */
    public Viewer() {
        controller = new Controller(this);
        Model model = controller.getModel();
        fileChooser = new JFileChooser();
        details = new JLabel("");
        panel = new JPanel();

        textArea = new JTextArea();
        textArea.setFont(new Font("Apple Symbols", Font.BOLD | Font.ITALIC, 25));
        JScrollPane scrollPane = new JScrollPane(textArea);
        JMenuBar menuBar = getMenuBar();
        textArea.addKeyListener(controller);
        textArea.getDocument().addUndoableEditListener(undoManager);

        frame = new JFrame("Notepad Inter Labs O!");
        frame.setSize(500, 500);
        frame.setJMenuBar(menuBar);
        frame.add(panel, BorderLayout.SOUTH);
        frame.add(scrollPane);
        frame.setVisible(true);

    }

    /**
     * Menu
     * Contains drop-down buttons
     * Each button contains a list of options
     * View hotkeys
     * Select a different color for the canvas background
     * Select a font, size, and style
     * Ability to open a document from a folder
     * And other options
     */
    private JMenuBar getMenuBar() {

        JMenuItem createDocumentJMenuItem = new JMenuItem("New");
        createDocumentJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        createDocumentJMenuItem.addActionListener(controller);
        createDocumentJMenuItem.setActionCommand("New Document");

        JMenuItem openDocumentJMenuItem = new JMenuItem("Open ...");
        openDocumentJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openDocumentJMenuItem.addActionListener(controller);
        openDocumentJMenuItem.setActionCommand("Open Document");

        JMenuItem saveDocumentJMenuItem = new JMenuItem("Save");
        saveDocumentJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveDocumentJMenuItem.addActionListener(controller);
        saveDocumentJMenuItem.setActionCommand("Save Document");

        JMenuItem saveAsDocumentJMenuItem = new JMenuItem("Save as ...");
        saveAsDocumentJMenuItem.addActionListener(controller);
        saveAsDocumentJMenuItem.setActionCommand("Save As Document");

        JMenuItem printDocumentJMenuItem = new JMenuItem("Print ...");
        printDocumentJMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        printDocumentJMenuItem.addActionListener(controller);
        printDocumentJMenuItem.setActionCommand("Print Document");

        JMenuItem closeJMenuItem = new JMenuItem("Exit");
        closeJMenuItem.addActionListener(controller);
        closeJMenuItem.setActionCommand("Close Program");

        JMenuItem undoDelete = new JMenuItem("Undo");
        undoDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        undoDelete.addActionListener(controller);
        undoDelete.setActionCommand("undo");

        JMenuItem redo = new JMenuItem("Redo");
        redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        redo.addActionListener(controller);
        redo.setActionCommand("redo");

        JMenuItem blueBack = new JMenuItem("Blue");
        blueBack.addActionListener(controller);
        blueBack.setActionCommand("blue back");

        JMenuItem redBack = new JMenuItem("Red");
        redBack.addActionListener(controller);
        redBack.setActionCommand("red back");

        JMenuItem greenBack = new JMenuItem("Green");
        greenBack.addActionListener(controller);
        greenBack.setActionCommand("green back");

        JMenuItem whiteBack = new JMenuItem("white");
        whiteBack.addActionListener(controller);
        whiteBack.setActionCommand("white back");

        JMenuItem blueForeground = new JMenuItem("Blue");
        blueForeground.addActionListener(controller);
        blueForeground.setActionCommand("blueF");

        JMenuItem redForeground = new JMenuItem("Red");
        redForeground.addActionListener(controller);
        redForeground.setActionCommand("redF");

        JMenuItem greenForeground = new JMenuItem("Green");
        greenForeground.addActionListener(controller);
        greenForeground.setActionCommand("greenF");

        JMenuItem aboutNot = new JMenuItem("About");
        aboutNot.addActionListener(controller);
        aboutNot.setActionCommand("about");

        JMenuItem arialF = new JMenuItem("Arial");
        arialF.addActionListener(controller);
        arialF.setActionCommand("arial");

        JMenuItem serifF = new JMenuItem("Serif");
        serifF.addActionListener(controller);
        serifF.setActionCommand("serif");

        JMenuItem italicS = new JMenuItem("ITALIC");
        italicS.addActionListener(controller);
        italicS.setActionCommand("italic");

        JMenuItem plainS = new JMenuItem("PLAIN");
        plainS.addActionListener(controller);
        plainS.setActionCommand("plain");

        JMenuItem boldS = new JMenuItem("BOLD");
        boldS.addActionListener(controller);
        boldS.setActionCommand("bold");

        JMenuItem s10 = new JMenuItem("10");
        s10.addActionListener(controller);
        s10.setActionCommand("s10");

        JMenuItem s30 = new JMenuItem("30");
        s30.addActionListener(controller);
        s30.setActionCommand("s30");

        JMenuItem s70 = new JMenuItem("70");
        s70.addActionListener(controller);

        JMenuItem status = new JMenuItem("Status bar");
        status.addActionListener(controller);
        status.setActionCommand("status");

        JMenuItem copyWord = new JMenuItem("Copy");
        copyWord.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        copyWord.addActionListener(controller);
        copyWord.setActionCommand("copy word");

        JMenuItem cutWord = new JMenuItem("Cut");
        cutWord.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        cutWord.addActionListener(controller);
        cutWord.setActionCommand("cut word");


        JMenuItem pasteWord = new JMenuItem("Paste");
        pasteWord.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        pasteWord.addActionListener(controller);
        pasteWord.setActionCommand("paste word");

        JMenuItem deleteWord = new JMenuItem("Delete");
        deleteWord.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
        deleteWord.addActionListener(controller);
        deleteWord.setActionCommand("delete word");

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(createDocumentJMenuItem);
        fileMenu.add(openDocumentJMenuItem);
        fileMenu.add(saveDocumentJMenuItem);
        fileMenu.add(saveAsDocumentJMenuItem);
        fileMenu.add(new JSeparator());
        fileMenu.add(printDocumentJMenuItem);
        fileMenu.add(new JSeparator());
        fileMenu.add(closeJMenuItem);

        JMenu editMenu = new JMenu("Edit");
        editMenu.add(undoDelete);
        editMenu.add(redo);
        editMenu.add(copyWord);
        editMenu.add(pasteWord);
        editMenu.add(deleteWord);
        editMenu.add(cutWord);

        JMenu fontFamily = new JMenu("Font Family");
        fontFamily.add(arialF);
        fontFamily.add(serifF);

        JMenu fontStyle = new JMenu("Font Style");
        fontStyle.add(italicS);
        fontStyle.add(boldS);
        fontStyle.add(plainS);

        JMenu fontSize = new JMenu("Font Size");
        fontSize.add(s10);
        fontSize.add(s30);
        fontSize.add(s70);

        JMenu fontMenu = new JMenu("Font");
        fontMenu.add(fontFamily);
        fontMenu.add(fontStyle);
        fontMenu.add(fontSize);

        JMenu backgroundColor = new JMenu("Background Color");
        backgroundColor.add(blueBack);
        backgroundColor.add(redBack);
        backgroundColor.add(greenBack);
        backgroundColor.add(whiteBack);

        JMenu foregroundColor = new JMenu("Foreground Color");
        foregroundColor.add(blueForeground);
        foregroundColor.add(redForeground);
        foregroundColor.add(greenForeground);

        JMenu formatMenu = new JMenu("Format");
        formatMenu.add(fontMenu);
        formatMenu.add(backgroundColor);
        formatMenu.add(foregroundColor);

        JMenu viewMenu = new JMenu("View");
        viewMenu.add(status);

        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(aboutNot);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(formatMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        return menuBar;

    }

    /**
     * Updates text
     */
    void update(String text) {
        textArea.setText(text);
    }


    /**
     * Opens the file selection window
     * Ability to open a file from any location
     *
     * @return a String with the path to the file
     */
    String openFileChooser() {
        if (fileChooser == null) {
            fileChooser = new JFileChooser();
        }
        fileChooser.showOpenDialog(frame);
        File file = fileChooser.getSelectedFile();
        if (file == null) {
            return null;
        } else {
            return file.getPath();
        }
    }


    /**
     * Returns the text to print
     *
     * @return String
     */
    String printer() {
        return textArea.getText();
    }

    /**
     * setColorBackground
     * Sets the color for the background
     *
     * @param numberColor stores the color number
     */
    void setColorBackground(int numberColor) {
        if (numberColor == 1) {
            textArea.setBackground(Color.BLUE);
        } else if (numberColor == 2) {
            textArea.setBackground(Color.RED);
        } else if (numberColor == 3) {
            textArea.setBackground(Color.GREEN);
        } else if (numberColor == 4) {
            textArea.setBackground(Color.WHITE);
        }
    }

    /**
     * setColorForeground
     * Sets the color for the foreground
     *
     * @param numberColor stores the color number
     */
    void setColorForeground(int numberColor) {
        if (numberColor == 1) {
            textArea.setForeground(Color.BLUE);
        } else if (numberColor == 2) {
            textArea.setForeground(Color.RED);
        } else if (numberColor == 3) {
            textArea.setForeground(Color.GREEN);
        }
    }

    /**
     * newDocument
     * Creates a new document
     * If the current document is not saved,
     * do offers to choose the action:
     * save, do not save, cancel
     */
    void newDocument() {
        int chooseAction = JOptionPane.showConfirmDialog(null, "Are you sure? This will make a erease any unsaved documents!");
        if (chooseAction == JOptionPane.YES_OPTION) {
            textArea.setText("");
        }
    }

    /**
     * saveDocument
     * Saves the current file
     */
    void saveDocument() {
        try {
            File file = fileChooser.getSelectedFile();
            if (file == null) {
                System.out.println("you have not file");
            } else {
                FileWriter outputStream = new FileWriter(file.getPath());
                outputStream.write(textArea.getText());
                outputStream.close();
                frame.setTitle("Text Editor-" + file.getName());
            }
        } catch (IOException ioe) {
            System.out.println("IOException");
        }

    }


    /**
     * saveAsDoc
     * Saves the current file in the selected location and name
     */
    void saveAsDoc() {
        int returnVal = fileChooser.showSaveDialog(frame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                FileWriter outputStream = new FileWriter(file.getPath() + ".txt");
                frame.setTitle("notepad-" + file.getName());
                outputStream.write(textArea.getText());
                outputStream.close();
            } catch (IOException ioe) {
                System.out.println("IOException");
            }
        }
    }


    /**
     * setFamily
     * * Sets the font family
     *
     * @param numberFont stores the family number
     */
    void setFamily(int numberFont) {
        if (numberFont == 1) {
            textArea.setFont(new Font("Alergia", textArea.getFont().getStyle(), textArea.getFont().getSize()));
        } else if (numberFont == 2) {
            textArea.setFont(new Font("Serif", textArea.getFont().getStyle(), textArea.getFont().getSize()));
        }
    }


    /**
     * setStyle
     * * Sets the font style
     *
     * @param numberStyle stores the style number
     */
    void setStyle(int numberStyle) {
        if (numberStyle == 1) {
            textArea.setFont(new Font(textArea.getFont().getName(), Font.ITALIC, textArea.getFont().getSize()));
        } else if (numberStyle == 2) {
            textArea.setFont(new Font(textArea.getFont().getName(), Font.BOLD, textArea.getFont().getSize()));
        } else if (numberStyle == 3) {
            textArea.setFont(new Font(textArea.getFont().getName(), Font.PLAIN, textArea.getFont().getSize()));
        }

    }


    /**
     * setSize
     * * Sets the font size
     *
     * @param numberSize stores the font size number
     */
    void setSize(int numberSize) {
        if (numberSize == 10) {
            textArea.setFont(new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), 10));
        } else if (numberSize == 30) {
            textArea.setFont(new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), 30));
        } else if (numberSize == 70) {
            textArea.setFont(new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), 70));
        }

    }


    /**
     * countCharacterAndLine
     * Counts the quantity of characters and lines
     */
    void countCharacterAndLine() {
        int cl = textArea.getText().length();
        int lineCount = textArea.getLineCount();
        details.setText("Length: " + cl + " Line: " + lineCount);
    }


    /**
     * countManager
     * Manages the status bar
     *
     * @param flag
     */
    void countManager(boolean flag) {
        if (flag) {
            panel.add(details);
            panel.repaint();
        } else {
            panel.remove(details);
            panel.repaint();
        }

    }

    /**
     * copyWord
     * Copies the selected text to the clipboard
     */
    void copyWord() {
        textArea.copy();
    }

    /**
     * cutWord
     * Cuts the selected text to the clipboard
     */
    void cutWord() {
        textArea.cut();
    }

    /**
     * pasteWord
     * Cuts the selected text to the clipboard
     */
    void pasteWord() {
        textArea.paste();
    }


    /**
     * undoStep
     * Cancels the last step
     */
    void undoStep() {
        if (undoManager.canUndo()) {
            undoManager.undo();
        }
    }

    /**
     * redoStep
     * Returns the previous step
     */
    void redoStep() {
        if (undoManager.canRedo()) {
            undoManager.redo();
        }
    }

    /**
     * deleteWord
     * Deletes the selected characters
     */
    void deleteWord() {
        String s = textArea.getSelectedText();

        if (s == null)
            System.out.println("you didn't select any characters");
        else
            textArea.setText(textArea.getText().replace(s, ""));
    }

}