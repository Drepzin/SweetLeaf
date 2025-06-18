package org.example;

import org.example.login.LoginWindow;
import org.example.mainpage.MainApp;

import javax.swing.*;

public class App {

    public static void main( String[] args ) {
        System.setProperty("sun.java2d.uiScale", "1.0");
        //SwingUtilities.invokeLater(MainApp::new);
        SwingUtilities.invokeLater(LoginWindow::new);
    }
}
