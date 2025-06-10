package org.example.mainpage.subpages;

import javax.swing.*;
import java.awt.*;

public class UserInfoPanel extends JPanel {

    private JLabel nameLabel, usernameLabel, emailLabel, passwordLabel, passwordRepLabel;

    private JTextField nameField ,usernameField, emailField;

    private JPasswordField passwordField, passwordRepField;

    private JButton applyButton;

    public UserInfoPanel(){
        init();
    }

    private void init(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //
        nameLabel = new JLabel("full name");
        usernameLabel = new JLabel("username");
        emailLabel = new JLabel("email");
        passwordLabel = new JLabel("new password");
        passwordRepLabel = new JLabel("repeat the password");
        //
        nameField = new JTextField();
        usernameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        passwordRepField = new JPasswordField();
        applyButton = new JButton("apply");
        //
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);
        nameField.setAlignmentX(CENTER_ALIGNMENT);
        nameField.setMaximumSize(new Dimension(650, 30));
        //
        usernameLabel.setAlignmentX(CENTER_ALIGNMENT);
        usernameField.setAlignmentX(CENTER_ALIGNMENT);
        usernameField.setMaximumSize(new Dimension(650, 30));
        //
        emailLabel.setAlignmentX(CENTER_ALIGNMENT);
        emailField.setAlignmentX(CENTER_ALIGNMENT);
        emailField.setMaximumSize(new Dimension(650, 30));
         //
        passwordLabel.setAlignmentX(CENTER_ALIGNMENT);
        passwordField.setAlignmentX(CENTER_ALIGNMENT);
        passwordField.setMaximumSize(new Dimension(650, 30));
        //
        passwordRepLabel.setAlignmentX(CENTER_ALIGNMENT);
        passwordRepField.setAlignmentX(CENTER_ALIGNMENT);
        passwordRepField.setMaximumSize(new Dimension(650, 30));
        //
         //remove borders
        nameField.setBorder(null);
        usernameField.setBorder(null);
        emailField.setBorder(null);
        passwordField.setBorder(null);
        passwordRepField.setBorder(null);
        applyButton.setBorder(null);
        //
        applyButton.setAlignmentX(CENTER_ALIGNMENT);
        applyButton.setMaximumSize(new Dimension(70, 30));
        applyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         //
        add(Box.createRigidArea(new Dimension(0, 200)));
        add(nameLabel);
        add(nameField);
        add(usernameLabel);
        add(usernameField);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(passwordRepLabel);
        add(passwordRepField);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(applyButton);
    }

}
