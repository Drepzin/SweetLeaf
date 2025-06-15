package org.example.mainpage.subpages;

import org.example.utils.GradientLabel;

import javax.swing.*;
import java.awt.*;

public class SendEmailPanel extends JPanel {

    private JLabel coworkerList;

    private GradientLabel gradientLabel;

    public SendEmailPanel(){
        init();
    }

    private void init(){
        setVisible(true);
        coworkerList =new JLabel();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#232323"));
        //
        gradientLabel = new GradientLabel("Constantia","Email com fundo gradiente", 50, Color.decode("#e62300"),
                Color.decode("#ff2fa0"));
        gradientLabel.setForeground(Color.WHITE);
        add(gradientLabel);
    }
}
