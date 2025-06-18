package org.example.mainpage.subpages;

import org.example.connection.DB;
import org.example.models.DAO.UserTaskDAO;
import org.example.models.User;
import org.example.models.UserTask;
import org.example.persistence.UserTaskDAOImpl;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.List;

public class TablePanel extends JPanel {

    private JLabel tableLabel;

    public JTable taskTables;

    private User user;

    private UserTaskDAO userTaskDAO;

    public TablePanel(User user){
        this.user = user;
        init();
    }

    private void init(){
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        String[] columns = {"task", "data", "description", "complete"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Nenhuma célula será editável
            }
        };

        //
        tableLabel = new JLabel("Task Table");
        //
        tableLabel.setFont(new Font("Arial", Font.BOLD, 50));
         //
        taskTables = new JTable(tableModel);
        //
        taskTables.setSelectionBackground(Color.decode("#404040"));
        taskTables.getColumnModel().getColumn(0).setMaxWidth(100);
        taskTables.getColumnModel().getColumn(1).setMaxWidth(70);
        taskTables.getColumnModel().getColumn(3).setMaxWidth(70);
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
        Connection connection = DB.getInstace().getConn();
        userTaskDAO = new UserTaskDAOImpl(connection);
         //
        add(jScrollPane);
        attTable();
    }

    private void attTable(){
        Timer timer = new Timer(5000, e -> populateTable());
        timer.start();
    }

    private void populateTable(){
        List<UserTask> tasks = userTaskDAO.findAll(user.getUserName());

        DefaultTableModel model = (DefaultTableModel) taskTables.getModel();

        // Limpa linhas antigas (se quiser)
        model.setRowCount(0);

        for(UserTask userTask : tasks){
            Object[] taskInfo = {
                    userTask.getTaskName(),
                    userTask.getTaskDate(),
                    userTask.getDescription(),
                    userTask.isComplete() ? "Done" : "Pending"
            };
            model.addRow(taskInfo);
        }
    }

    public String getSelectedTaskName(){
        int selectedRow = taskTables.getSelectedRow();
        if(selectedRow != -1){
            Object value = taskTables.getValueAt(selectedRow, 0);
            return (String) value;
        }
        return null;
    }
}
