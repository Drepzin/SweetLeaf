package org.example.login;

import javax.swing.*;
import java.awt.*;

public class InfoDialog extends JDialog {

    private String message;

    private JLabel textLabel;

    private JButton button;

    public InfoDialog(String message, JFrame parent) {
        super(parent, true);
        this.message = message;
        init();
    }

    private void init(){
        setLayout(new FlowLayout());
        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.Y_AXIS));
        //
        textLabel = new JLabel(message);
        button = new JButton("OK");
        button.setMaximumSize(new Dimension(80, 30));
        //
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        //
        principalPanel.add(textLabel);
        principalPanel.add(button);
        add(principalPanel);
        setSize(new Dimension(200, 100));
        principalPanel.setVisible(true);
        button.addActionListener((e) -> {
            dispose();
        });
        setVisible(true);
    }
}
