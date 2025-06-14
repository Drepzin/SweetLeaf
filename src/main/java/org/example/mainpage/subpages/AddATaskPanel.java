package org.example.mainpage.subpages;

import javax.swing.*;
import java.awt.*;

public class AddATaskPanel extends JPanel {

    private JLabel panelLabel, taskNameLabel, taskDateLabel, taskDescriptionLabel;

    private JTextField taskNameField, taskDateField, taskDescriptionField;

    private JButton saveTaskButton;

    public AddATaskPanel(){
        init();
    }

    private void init(){
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //
        panelLabel = new JLabel("Add a task");
        taskNameLabel = new JLabel("Task name");
        taskDateLabel = new JLabel("Init date");
        taskDescriptionLabel = new JLabel("Description");
        //
        taskNameField = new JTextField();
        taskDateField = new JTextField();
        taskDescriptionField = new JTextField();
        saveTaskButton = new JButton("save");
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
        panelLabel.setFont(new Font("Impact", Font.BOLD, 50));
        panelLabel.setForeground(Color.decode("#04ab14"));
        taskNameField.setMaximumSize(new Dimension(300, 40));
        taskDateField.setMaximumSize(new Dimension(300, 40));
        taskDescriptionField.setMaximumSize(new Dimension(300, 40));
         //
        saveTaskButton.setBorder(null);
        saveTaskButton.setMaximumSize(new Dimension(100, 30));
        saveTaskButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveTaskButton.setBackground(Color.decode("#e22dff"));
        saveTaskButton.setForeground(Color.decode("#FFFFFF"));
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
