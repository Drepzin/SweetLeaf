package org.example.login;

import org.example.connection.DB;
import org.example.mainpage.MainApp;
import org.example.models.DAO.UserDAO;
import org.example.models.User;
import org.example.persistence.UserDAOImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInWindow extends JPanel {

    private JLabel titleLabel, usernameLabel, passwordLabel, forgotPassword, userEmailLabel;

    private JTextField usernameField, userEmailField;

    private JPasswordField passwordField;

    private JButton signInButton, sendEmailButton;

    private JDialog forgotDialog;

    private UserDAO userDAO;

    public User user;

    public SignInWindow(){
        init();
    }

    private void init(){
        setVisible(true);
        setBackground(Color.decode("#f4f2f2"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        userDAO = new UserDAOImpl(getConn());
        //
         //initializate
        titleLabel = new JLabel("Sweet");
        usernameLabel = new JLabel("username");
        passwordLabel = new JLabel("password");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        signInButton = new JButton("Sign in");
        forgotPassword = new JLabel("Forgot password");
        //
         //Align
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        usernameLabel.setAlignmentX(CENTER_ALIGNMENT);
        passwordLabel.setAlignmentX(CENTER_ALIGNMENT);
        signInButton.setAlignmentX(CENTER_ALIGNMENT);
        //Style
        titleLabel.setFont(new Font("Droid Sans Mono", Font.BOLD, 50));
        titleLabel.setForeground(Color.decode("#26e959"));
        //
        usernameLabel.setForeground(Color.decode("#007800"));
        usernameField.setBorder(null);
        usernameField.setBackground(Color.decode("#e1fee1"));
        //
        passwordLabel.setForeground(Color.decode("#007800"));
        passwordField.setBorder(null);
        passwordField.setBackground(Color.decode("#e1fee1"));
        //
        usernameField.setMaximumSize(new Dimension(300, 30));
        passwordField.setMaximumSize(new Dimension(300, 30));
        //
        signInButton.setBorder(null);
        signInButton.setForeground(Color.decode("#f4f2f2"));
        signInButton.setBackground(Color.decode("#007800"));
        signInButton.setMaximumSize(new Dimension(150, 30));
        //
        forgotPassword.setAlignmentX(CENTER_ALIGNMENT);
        forgotPassword.setForeground(Color.decode("#02a181"));
        forgotPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signInButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         //adding
        add(Box.createRigidArea(new Dimension(0, 40)));
        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(usernameLabel);
        add(usernameField);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(passwordLabel);
        add(passwordField);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(signInButton);
        add(forgotPassword);
        //functions
        forgotPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                initForgotDialog();
            }
        });
        //
        signInButton.addActionListener((e) -> {
            doLogin(usernameField.getText());
            System.out.println(user);
        });
    }

    private void initForgotDialog(){
        forgotDialog = new JDialog();
        forgotDialog.setTitle("Recover your account");
        forgotDialog.setVisible(true);
        forgotDialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        forgotDialog.setSize(new Dimension(800, 250));
        forgotDialog.setLayout(new BoxLayout(forgotDialog.getContentPane(), BoxLayout.X_AXIS));
        //
        userEmailLabel = new JLabel("Email ");
        userEmailField = new JTextField();
        sendEmailButton = new JButton("send");
        //
        userEmailField.setMaximumSize(new Dimension(600, 30));
        userEmailField.setAlignmentY(CENTER_ALIGNMENT);
        userEmailLabel.setAlignmentY(CENTER_ALIGNMENT);
        sendEmailButton.setAlignmentY(CENTER_ALIGNMENT);
        //
         //adding
        forgotDialog.add(Box.createRigidArea(new Dimension(50, 10)));
        forgotDialog.add(userEmailLabel);
        forgotDialog.add(userEmailField);
        forgotDialog.add(sendEmailButton);
        //
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;
        GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("#f4f2f2"), 0, 500, Color.decode("#d9d9d9"));
        graphics2D.setPaint(gradientPaint);
        graphics2D.fillRect(0,0, 1200, 700);
    }

    private void doLogin(String username){
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Connection conn = DB.getInstace().getConn();
        if(!verifyUsername(username)){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ErrorFieldDialog efd = new ErrorFieldDialog("Username don't exist!", parent);
                }
            });
        }
        else{
            if(!confirmLogin(username )){
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ErrorFieldDialog efd = new ErrorFieldDialog("Incorrect password!", parent);
                    }
                });
            }
            else{
                if(parent != null){
                    parent.dispose();
                }
                user = userDAO.findUser(username);
                System.out.println("Logado");
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        MainApp mainApp = new MainApp(user);
                    }
                });
            }
        }
    }

    public User getUser(){
        return user;
    }

    private boolean confirmLogin(String username){
        try{
            String dbPassword = userDAO.selectField("password", username);
            String fieldPassword = passwordField.getText();
            if(fieldPassword.equals(dbPassword)){
                return true;
            }
            return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConn(){
        Connection conn = DB.getInstace().getConn();
        return conn;
    }

    private boolean verifyUsername(String username){
        Connection conn = getConn();
        String sql = "SELECT 1 from user_table u WHERE u.username = ? LIMIT 1";
        try(PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
