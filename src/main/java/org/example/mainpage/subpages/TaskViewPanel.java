package org.example.mainpage.subpages;

import org.example.utils.GradientButton;

import javax.swing.*;
import java.awt.*;

public class TaskViewPanel extends JPanel {

    private TablePanel tablePanel;

    private GradientButton deleteTaskButton;

    public TaskViewPanel(){
        init();
    }

    private void init(){
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#252525"));
        //
        tablePanel = new TablePanel();
        deleteTaskButton = new GradientButton("delete", 40, 100, Color.decode("#ff6100"), Color.decode("#b900e6"));
        //
        tablePanel.setMaximumSize(new Dimension(800, 700));
        //
        deleteTaskButton.setAlignmentX(CENTER_ALIGNMENT);
        //
        deleteTaskButton.setMaximumSize(new Dimension(150, 60));
        deleteTaskButton.setBorder(null);
        deleteTaskButton.setBackground(Color.decode("#ffffff"));
         //
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(tablePanel);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(deleteTaskButton);
    }
}
