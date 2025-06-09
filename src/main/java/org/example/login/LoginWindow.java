package org.example.login;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {

    public LoginWindow(){
        //Init
        setVisible(true);
        setResizable(false);
        setSize(new Dimension(1200, 600));
        setLayout(new GridLayout(1,2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new SignInWindow());
        add(new SignUpWindow());
    }
}
