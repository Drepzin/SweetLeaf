package org.example.mainpage.subpages;

import org.example.models.Tasks;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {

    private JLabel tableLabel;

    private JTable taskTables;

    public TablePanel(){
        init();
    }

    private void init(){
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        String[] columns = {"task", "data", "description", "complete"};
        String[][] data = new String[30][30];
        //
        tableLabel = new JLabel("Task Table");
        //
        tableLabel.setFont(new Font("Arial", Font.BOLD, 50));
         //
        taskTables = new JTable(data, columns);
        //
        taskTables.getColumnModel().setColumnMargin(8);
        taskTables.getColumnModel().getColumn(0).setMaxWidth(70);
        taskTables.getColumnModel().getColumn(1).setMaxWidth(70);
        taskTables.getColumnModel().getColumn(3).setMaxWidth(100);
        taskTables.setRowHeight(40);
        taskTables.getTableHeader().setBackground(Color.decode("#a0a0a0"));
        //
        taskTables.setBackground(Color.decode("#767676"));
        taskTables.setAlignmentX(Component.TOP_ALIGNMENT);
         //
        JScrollPane jScrollPane = new JScrollPane(taskTables);
        //
        add(jScrollPane);
    }
}
