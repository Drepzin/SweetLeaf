package org.example.mainpage.subpages;

import javax.swing.*;
import java.awt.*;

public class SendEmailPanel extends JPanel {

    private JLabel coworkerList;


    public SendEmailPanel(){
        init();
    }

    private void init(){
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
