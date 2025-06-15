package org.example.mainpage.subpages;

import org.example.utils.GradientBorder;
import org.example.utils.GradientButton;
import org.example.utils.GradientLabel;

import javax.swing.*;
import java.awt.*;

public class AddATaskPanel extends JPanel {

    private JLabel taskNameLabel, taskDateLabel, taskDescriptionLabel;

    private GradientLabel panelLabel;

    private JTextField taskNameField, taskDateField, taskDescriptionField;

    private GradientButton saveTaskButton;

    public AddATaskPanel(){
        init();
    }

    private void init(){
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#252525"));
        //
        panelLabel = new GradientLabel("Bahnschrift", "Add task", 50, Color.decode("#ff2fa0"), Color.decode("#ffa822"));
        taskNameLabel = new JLabel("Task name");
        taskDateLabel = new JLabel("Init date");
        taskDescriptionLabel = new JLabel("Description");
        //
        taskNameField = new JTextField();
        taskDateField = new JTextField();
        taskDescriptionField = new JTextField();
        saveTaskButton = new GradientButton("save", 30, 100, Color.decode("#ff6100"), Color.decode("#b900e6"));
        //
        taskNameLabel.setForeground(Color.decode("#ffffff"));
        taskDateLabel.setForeground(Color.decode("#ffffff"));
        taskDescriptionLabel.setForeground(Color.decode("#ffffff"));
         //
        panelLabel.setAlignmentX(CENTER_ALIGNMENT);
        taskNameLabel.setAlignmentX(CENTER_ALIGNMENT);
        taskNameField.setAlignmentX(CENTER_ALIGNMENT);
        taskDateLabel.setAlignmentX(CENTER_ALIGNMENT);
        taskDateField.setAlignmentX(CENTER_ALIGNMENT);
        taskDescriptionLabel.setAlignmentX(CENTER_ALIGNMENT);
        taskDescriptionField.setAlignmentX(CENTER_ALIGNMENT);
        saveTaskButton.setAlignmentX(CENTER_ALIGNMENT);
        //
        taskNameField.setBackground(Color.decode("#333333"));
        taskNameField.setForeground(Color.decode("#ffffff"));
        taskNameField.setBorder(new GradientBorder(Color.decode("#ff6100"), Color.decode("#b900e6"), 1));
        //
        taskDateField.setBackground(Color.decode("#333333"));
        taskDateField.setForeground(Color.decode("#ffffff"));
        taskDateField.setBorder(new GradientBorder(Color.decode("#ff6100"), Color.decode("#b900e6"), 1));
        //
        taskDescriptionField.setBackground(Color.decode("#333333"));
        taskDescriptionField.setForeground(Color.decode("#ffffff"));
        taskDescriptionField.setBorder(new GradientBorder(Color.decode("#ff6100"), Color.decode("#b900e6"), 1));
        //
        panelLabel.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        panelLabel.setForeground(Color.decode("#ff5c00"));
        taskNameField.setMaximumSize(new Dimension(300, 30));
        taskDateField.setMaximumSize(new Dimension(300, 30));
        taskDescriptionField.setMaximumSize(new Dimension(300, 30));
         //
        saveTaskButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveTaskButton.setFont(new Font("Arial", Font.BOLD, 15));
         //
        add(Box.createRigidArea(new Dimension(0, 100)));
        add(panelLabel);
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(taskNameLabel);
        add(taskNameField);
        add(taskDateLabel);
        add(taskDateField);
        add(taskDescriptionLabel);
        add(taskDescriptionField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(saveTaskButton);
    }
}
