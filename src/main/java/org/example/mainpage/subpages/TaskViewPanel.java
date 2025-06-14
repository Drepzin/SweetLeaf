package org.example.mainpage.subpages;

import javax.swing.*;
import java.awt.*;

public class TaskViewPanel extends JPanel {

    private TablePanel tablePanel;

    public TaskViewPanel(){
        init();
    }

    private void init(){
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        tablePanel = new TablePanel();
        add(tablePanel);
    }
}
