package org.example;

import org.example.login.LoginWindow;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        SwingUtilities.invokeLater(LoginWindow::new);
    }
}
