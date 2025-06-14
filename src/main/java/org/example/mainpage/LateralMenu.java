package org.example.mainpage;

import javax.swing.*;
import java.awt.*;

public class LateralMenu extends JPanel {

    public JLabel addTaskButton, taskTableButton, sendEmailButton, copyrightLabel;

    public LateralMenu(){
        init();
    }

    private void init(){
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //
        ImageIcon coworkerIcon = new ImageIcon(getClass().getResource("/imgs/task_alt_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.png"));
        addTaskButton = new JLabel("Add Task   ", coworkerIcon, JLabel.LEFT);
        //
        ImageIcon emailIcon = new ImageIcon(getClass().getResource("/imgs/mail_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.png"));
        sendEmailButton = new JLabel("Email         ", emailIcon, JLabel.LEFT);//space are for align the icon...
        //
        ImageIcon addCoworkerIcon = new ImageIcon(getClass().getResource("/imgs/list_alt_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.png"));
        taskTableButton = new JLabel("Task Table", addCoworkerIcon, JLabel.LEFT);
        //
        ImageIcon copyrightIcon = new ImageIcon(getClass().getResource("/imgs/copyright_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.png"));
        copyrightLabel = new JLabel("Drepz.", copyrightIcon, 2);
        //
        copyrightLabel.setAlignmentX(CENTER_ALIGNMENT);
        addTaskButton.setAlignmentX(CENTER_ALIGNMENT);
        sendEmailButton.setAlignmentX(CENTER_ALIGNMENT);
        taskTableButton.setAlignmentX(CENTER_ALIGNMENT);
        //
        addTaskButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sendEmailButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        taskTableButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //
        copyrightLabel.setForeground(Color.WHITE);
        addTaskButton.setForeground(Color.WHITE);
        sendEmailButton.setForeground(Color.WHITE);
        taskTableButton.setForeground(Color.white);
         //
        add(Box.createRigidArea(new Dimension(0, 200)));
        add(addTaskButton);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(sendEmailButton);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(taskTableButton);
        add(Box.createRigidArea(new Dimension(0, 400)));
        add(copyrightLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;
        GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("#fc4aff"), 0, 1200, Color.decode("#a602db"));
        graphics2D.setPaint(gradientPaint);
        graphics2D.fillRect(0,0, 1200, 800);
    }
}
