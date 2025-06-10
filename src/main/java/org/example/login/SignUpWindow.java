package org.example.login;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayDeque;

public class SignUpWindow extends JPanel {

    private JLabel titleLabel, nameLabel, usernameLabel, emailLabel, passwordLabel, passwordRepLabel;

    private JTextField usernameField, nameField, emailField;

    private JPasswordField passwordField, passwordRepField;

    private JButton signUpButton;

    public SignUpWindow(){
        init();
    }

    private void init(){
        //layouts config
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);
        setBackground(Color.decode("#26e959"));
        //components initialization
        //labels
        titleLabel = new JLabel("Leaf");
        nameLabel = new JLabel("full name");
        usernameLabel = new JLabel("Username");
        emailLabel = new JLabel("Email");
        passwordLabel = new JLabel("Password");
        passwordRepLabel = new JLabel("Password");
        signUpButton = new JButton("SignUp");
        //text fields
        nameField = new JTextField();
        usernameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        passwordRepField = new JPasswordField();
        //
         //align components
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        emailField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordRepLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordRepField.setAlignmentX(Component.CENTER_ALIGNMENT);
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        //
         //Style
        //label
        titleLabel.setFont(new Font("Droid Sans Mono", Font.BOLD, 50));
        titleLabel.setForeground(Color.decode("#f4f2f2"));
        nameLabel.setForeground(Color.decode("#f4f2f2"));
        usernameLabel.setForeground(Color.decode("#f4f2f2"));
        emailLabel.setForeground(Color.decode("#f4f2f2"));
        passwordLabel.setForeground(Color.decode("#f4f2f2"));
        passwordRepLabel.setForeground(Color.decode("#f4f2f2"));
        //
        nameField.setBackground(Color.decode("#f4f2f2"));
        usernameField.setBackground(Color.decode("#dcdcdc"));
        emailField.setBackground(Color.decode("#dcdcdc"));
        passwordField.setBackground(Color.decode("#dcdcdc"));
        passwordRepField.setBackground(Color.decode("#dcdcdc"));
        signUpButton.setBackground(Color.decode("#f4f2f2"));
        signUpButton.setForeground(Color.decode("#26e959"));
        signUpButton.setMaximumSize(new Dimension(150,30));
        signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpButton.setBorder(new EmptyBorder(10,20,10,20));
        //
        nameField.setBorder(null);
        usernameField.setBorder(null);
        emailField.setBorder(null);
        passwordField.setBorder(null);
        passwordRepField.setBorder(null);
         //size of text
        nameField.setMaximumSize(new Dimension(300, 30));
        usernameField.setMaximumSize(new Dimension(300, 30));
        emailField.setMaximumSize(new Dimension(300, 30));
        passwordField.setMaximumSize(new Dimension(300, 30));
        passwordRepField.setMaximumSize(new Dimension(300, 30));
        //add
        add(Box.createRigidArea(new Dimension(0, 40)));
        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(nameLabel);
        add(nameField);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(usernameLabel);
        add(usernameField);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(emailLabel);
        add(emailField);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(passwordLabel);
        add(passwordField);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(passwordRepLabel);
        add(passwordRepField);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(signUpButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;
        GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("#00bd1d"), 0, 500, Color.decode("#12ffe3"));
        graphics2D.setPaint(gradientPaint);
        graphics2D.fillRect(0,0, 1200, 700);
    }
}
