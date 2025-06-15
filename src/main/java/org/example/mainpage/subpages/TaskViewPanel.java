package org.example.mainpage.subpages;

import javax.swing.*;
import java.awt.*;

public class TaskViewPanel extends JPanel {

    private TablePanel tablePanel;

    private JButton deleteTaskButton;

    public TaskViewPanel(){
        init();
    }

    private void init(){
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#252525"));
        //
        tablePanel = new TablePanel();
        deleteTaskButton = new JButton("delete");
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
