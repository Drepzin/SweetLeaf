package org.example.mainpage.subpages;

import org.example.connection.DB;
import org.example.models.DAO.UserTaskDAO;
import org.example.models.User;
import org.example.persistence.UserTaskDAOImpl;
import org.example.utils.GradientButton;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class TaskViewPanel extends JPanel {

    private TablePanel tablePanel;

    private GradientButton deleteTaskButton;

    private User user;

    public TaskViewPanel(User user){
        this.user = user;
        init();
    }

    private void init(){
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#252525"));
        //
        tablePanel = new TablePanel(user);
        deleteTaskButton = new GradientButton("delete", 40, 100, Color.decode("#ff6100"), Color.decode("#b900e6"));
        //
        tablePanel.setMaximumSize(new Dimension(800, 700));
        //
        deleteTaskButton.setAlignmentX(CENTER_ALIGNMENT);
        //
        deleteTaskButton.setMaximumSize(new Dimension(150, 60));
        deleteTaskButton.setBorder(null);
        deleteTaskButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteTaskButton.setBackground(Color.decode("#ffffff"));
         //
        add(Box.createRigidArea(new Dimension(0, 50)));
        add(tablePanel);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(deleteTaskButton);

        deleteTaskButton.addActionListener((e) -> {
            Connection conn = DB.getInstace().getConn();
            UserTaskDAO userTaskDAO = new UserTaskDAOImpl(conn);
            userTaskDAO.deleteUserTask(tablePanel.getSelectedTaskName(), user.getUserName());
        });
    }
}
