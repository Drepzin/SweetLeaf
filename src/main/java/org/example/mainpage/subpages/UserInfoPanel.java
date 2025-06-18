package org.example.mainpage.subpages;

import org.example.connection.DB;
import org.example.login.InfoDialog;
import org.example.models.DAO.UserDAO;
import org.example.models.User;
import org.example.persistence.UserDAOImpl;
import org.example.utils.GradientBorder;
import org.example.utils.GradientButton;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class UserInfoPanel extends JPanel {

    private JLabel nameLabel, usernameLabel, emailLabel, passwordLabel, passwordRepLabel;

    private JTextField nameField, usernameField, emailField;

    private JPasswordField passwordField, passwordRepField;

    private GradientButton applyButton;

    private User user;

    public UserInfoPanel(User user) {
        this.user = user;
        init();
    }

    private void init() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#232323"));
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
        applyButton = new GradientButton("apply", 30, 100, Color.decode("#ff6100"), Color.decode("#b900e6"));
        //
        nameField.setText(user.getFullName());
        nameField.setEnabled(false);
        //
        usernameField.setText(user.getUserName());
        usernameField.setEnabled(false);
        //
        emailField.setText(user.getEmail());
        emailField.setEnabled(false);
        //
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);
        nameLabel.setForeground(Color.decode("#ffffff"));
        nameField.setAlignmentX(CENTER_ALIGNMENT);
        nameField.setBackground(Color.decode("#333333"));
        nameField.setForeground(Color.decode("#ffffff"));
        nameField.setMaximumSize(new Dimension(650, 30));
        //
        usernameLabel.setAlignmentX(CENTER_ALIGNMENT);
        usernameLabel.setForeground(Color.decode("#ffffff"));
        usernameField.setAlignmentX(CENTER_ALIGNMENT);
        usernameField.setBackground(Color.decode("#333333"));
        usernameField.setForeground(Color.decode("#ffffff"));
        usernameField.setMaximumSize(new Dimension(650, 30));
        //
        emailLabel.setAlignmentX(CENTER_ALIGNMENT);
        emailLabel.setForeground(Color.decode("#fffffff"));
        emailField.setAlignmentX(CENTER_ALIGNMENT);
        emailField.setBackground(Color.decode("#333333"));
        emailField.setForeground(Color.decode("#ffffff"));
        emailField.setMaximumSize(new Dimension(650, 30));
        //
        passwordLabel.setAlignmentX(CENTER_ALIGNMENT);
        passwordLabel.setForeground(Color.decode("#ffffff"));
        passwordField.setAlignmentX(CENTER_ALIGNMENT);
        passwordField.setBackground(Color.decode("#333333"));
        passwordField.setForeground(Color.decode("#ffffff"));
        passwordField.setMaximumSize(new Dimension(650, 30));
        //
        passwordRepLabel.setAlignmentX(CENTER_ALIGNMENT);
        passwordRepLabel.setForeground(Color.decode("#ffffff"));
        passwordRepField.setAlignmentX(CENTER_ALIGNMENT);
        passwordRepField.setBackground(Color.decode("#333333"));
        passwordRepField.setForeground(Color.decode("#ffffff"));
        passwordRepField.setMaximumSize(new Dimension(650, 30));
        //
        //remove borders
        nameField.setBorder(new GradientBorder(Color.decode("#ff6100"), Color.decode("#b900e6"), 1));
        usernameField.setBorder(new GradientBorder(Color.decode("#ff6100"), Color.decode("#b900e6"), 1));
        emailField.setBorder(new GradientBorder(Color.decode("#ff6100"), Color.decode("#b900e6"), 1));
        passwordField.setBorder(new GradientBorder(Color.decode("#ff6100"), Color.decode("#b900e6"), 1));
        passwordRepField.setBorder(new GradientBorder(Color.decode("#ff6100"), Color.decode("#b900e6"), 1));
        //
        applyButton.setAlignmentX(CENTER_ALIGNMENT);
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
        //
        applyButton.addActionListener((e) -> {
            updatePassword(passwordField.getText(), passwordRepField.getText());
        });
    }

    public void updatePassword(String password, String repPassword) {
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Connection connection = DB.getInstace().getConn();
        if (!password.equals(repPassword)) {
            SwingUtilities.invokeLater(() -> {
                InfoDialog efd = new InfoDialog("Passwords are not equal!", parent);
            });
        }
        else {
            UserDAO userDAO = new UserDAOImpl(connection);
            userDAO.updateUserPassword(user.getUserName(), passwordField.getText());
            SwingUtilities.invokeLater(() -> {
                InfoDialog efd = new InfoDialog("Password changed!", parent);
            });
        }

    }
}
