package org.example.mainpage.subpages;

import org.example.connection.DB;
import org.example.models.DAO.UserTaskDAO;
import org.example.models.User;
import org.example.models.UserTask;
import org.example.persistence.UserTaskDAOImpl;
import org.example.utils.GradientBorder;
import org.example.utils.GradientButton;
import org.example.utils.GradientLabel;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.Instant;
import java.util.Date;

public class AddATaskPanel extends JPanel {

    private JLabel taskNameLabel, taskDescriptionLabel;

    private GradientLabel panelLabel;

    private JTextField taskNameField, taskDescriptionField;

    private GradientButton saveTaskButton;

    private User user;

    public AddATaskPanel(User user){
        this.user = user;
        init();
    }

    private void init(){
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#252525"));
        //
        panelLabel = new GradientLabel("Bahnschrift", "Add task", 50, Color.decode("#ff2fa0"), Color.decode("#ffa822"));
        taskNameLabel = new JLabel("Task name");
        taskDescriptionLabel = new JLabel("Description");
        //
        taskNameField = new JTextField();
        taskDescriptionField = new JTextField();
        saveTaskButton = new GradientButton("save", 30, 100, Color.decode("#ff6100"), Color.decode("#b900e6"));
        //
        taskNameLabel.setForeground(Color.decode("#ffffff"));
        taskDescriptionLabel.setForeground(Color.decode("#ffffff"));
         //
        panelLabel.setAlignmentX(CENTER_ALIGNMENT);
        taskNameLabel.setAlignmentX(CENTER_ALIGNMENT);
        taskNameField.setAlignmentX(CENTER_ALIGNMENT);
        taskDescriptionLabel.setAlignmentX(CENTER_ALIGNMENT);
        taskDescriptionField.setAlignmentX(CENTER_ALIGNMENT);
        saveTaskButton.setAlignmentX(CENTER_ALIGNMENT);
        //
        taskNameField.setBackground(Color.decode("#333333"));
        taskNameField.setForeground(Color.decode("#ffffff"));
        taskNameField.setBorder(new GradientBorder(Color.decode("#ff6100"), Color.decode("#b900e6"), 1));
        //
        taskDescriptionField.setBackground(Color.decode("#333333"));
        taskDescriptionField.setForeground(Color.decode("#ffffff"));
        taskDescriptionField.setBorder(new GradientBorder(Color.decode("#ff6100"), Color.decode("#b900e6"), 1));
        //
        panelLabel.setFont(new Font("Bahnschrift", Font.BOLD, 50));
        panelLabel.setForeground(Color.decode("#ff5c00"));
        taskNameField.setMaximumSize(new Dimension(300, 30));
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
        add(taskDescriptionLabel);
        add(taskDescriptionField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(saveTaskButton);
        //
        saveTaskButton.addActionListener((e) -> {
            addTask();
        });
    }

    private void addTask(){
        Connection conn = DB.getInstace().getConn();
        UserTaskDAO utd = new UserTaskDAOImpl(conn);
        //
        String taskName = taskNameField.getText();
        java.sql.Date initDate = new java.sql.Date(Date.from(Instant.now()).getTime());
        String description = taskDescriptionField.getText();
        String userUsername = user.getUserName();;
        UserTask userTask = new UserTask(taskName, initDate, description, false, userUsername);
        //
        utd.addUserTask(userTask);
    }
}
