package org.example.mainpage.subpages;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class TablePanel extends JPanel {

    private JLabel tableLabel;

    public JTable taskTables;

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
        taskTables.setSelectionBackground(Color.decode("#404040"));
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
        jScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI(){
            @Override
            protected void configureScrollBarColors() {
                super.configureScrollBarColors();
                this.thumbColor = Color.decode("#393939");
                this.trackColor = Color.decode("#454545");
            }
        });
        //
        add(jScrollPane);
    }
}
