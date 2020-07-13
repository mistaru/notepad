import java.awt.event.*;

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
 * Controller
 * The controller accepts data and translates it into commands for the model or View.
 * Implements the ActionListener interface for listening to actions from the viewer
 * Implements the KeyListener interface for listening to Key events from the keyboard
 */
public class Controller extends KeyAdapter implements ActionListener, KeyListener {

    private Model model;

    Controller(Viewer viewer) {
        model = new Model(viewer);
    }

    Model getModel() {
        return model;
    }


    /**
     * actionPerformed
     * Listens for actions and sends commands to the model
     */
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        model.doAction(command);
    }

    /**
     * keyTyped
     * Counts the quantity of characters and lines
     * @param keyEvent
     */
    public void keyTyped(KeyEvent keyEvent) {
        model.countCharacterAndLine();
    }

}