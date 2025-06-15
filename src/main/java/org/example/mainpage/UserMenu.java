package org.example.mainpage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserMenu extends JPanel {

    private JLabel profileIconLabel, usernameLabel, emailLabel;

    public  JLabel editInfoLabel;

    public UserMenu(){
        init();
    }

    private void init(){
        setVisible(true);
        setMaximumSize(new Dimension(200, 800));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //
        ImageIcon profileIcon = new ImageIcon(getClass().getResource("/imgs/account_circle_80dp_FFFFFF_FILL0_wght400_GRAD0_opsz48.png"));
        Image profileIconImage = profileIcon.getImage().getScaledInstance(80, 80, Image.SCALE_FAST);
        profileIcon = new ImageIcon(profileIconImage);
        profileIconLabel = new JLabel(profileIcon);
        usernameLabel = new JLabel("username");
        emailLabel = new JLabel("email@email.com");
        editInfoLabel = new JLabel("edit infos");
        //
        profileIconLabel.setAlignmentX(CENTER_ALIGNMENT);
        usernameLabel.setAlignmentX(CENTER_ALIGNMENT);
        emailLabel.setAlignmentX(CENTER_ALIGNMENT);
        editInfoLabel.setAlignmentX(CENTER_ALIGNMENT);
        //
        usernameLabel.setForeground(Color.WHITE);
        emailLabel.setForeground(Color.WHITE);
        editInfoLabel.setForeground(Color.WHITE);
        //
        editInfoLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
         //
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(profileIconLabel);
        add(usernameLabel);
        add(emailLabel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(editInfoLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;
        GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("#ff5d00"), 0, 800, Color.decode("#ffd500"));
        graphics2D.setPaint(gradientPaint);
        graphics2D.fillRect(0,0, 1200, 800);
    }
}
