package org.example.mainpage;

import javax.swing.*;
import java.awt.*;

public class LateralMenu extends JPanel {

    public JLabel coworkersButton, addCoworkerButton, sendEmailButton, copyrightLabel;

    public LateralMenu(){
        init();
    }

    private void init(){
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //
        ImageIcon coworkerIcon = new ImageIcon(getClass().getResource("/imgs/folder_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.png"));
        coworkersButton = new JLabel("coworkers", coworkerIcon, JLabel.LEFT);
        //
        ImageIcon emailIcon = new ImageIcon(getClass().getResource("/imgs/mail_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.png"));
        sendEmailButton = new JLabel("Email         ", emailIcon, JLabel.LEFT);//space are for align the icon...
        //
        ImageIcon addCoworkerIcon = new ImageIcon(getClass().getResource("/imgs/person_add_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.png"));
        addCoworkerButton = new JLabel("Management", addCoworkerIcon, JLabel.LEFT);
        //
        ImageIcon copyrightIcon = new ImageIcon(getClass().getResource("/imgs/copyright_24dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.png"));
        copyrightLabel = new JLabel("Drepz.", copyrightIcon, 2);
        //
        copyrightLabel.setAlignmentX(CENTER_ALIGNMENT);
        coworkersButton.setAlignmentX(CENTER_ALIGNMENT);
        sendEmailButton.setAlignmentX(CENTER_ALIGNMENT);
        addCoworkerButton.setAlignmentX(CENTER_ALIGNMENT);
        //
        coworkersButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sendEmailButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addCoworkerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //
        copyrightLabel.setForeground(Color.WHITE);
        coworkersButton.setForeground(Color.WHITE);
        sendEmailButton.setForeground(Color.WHITE);
        addCoworkerButton.setForeground(Color.white);
         //
        add(Box.createRigidArea(new Dimension(0, 200)));
        add(coworkersButton);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(sendEmailButton);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(addCoworkerButton);
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
