package org.example.mainpage;

import org.example.mainpage.subpages.TaskViewPanel;
import org.example.mainpage.subpages.AddATaskPanel;
import org.example.mainpage.subpages.UserInfoPanel;
import org.example.models.User;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JPanel {

    private AddATaskPanel AddATaskPanel;

    private TaskViewPanel taskViewPanel;

    private UserInfoPanel userInfoPanel;

    public CardLayout menuLayout;

    private User user;

    public MainPage(User user){
        this.user = user;
        init();
    }

    private void init(){
        setVisible(true);
        setMinimumSize(new Dimension(800, 800));
        menuLayout = new CardLayout();
        setLayout(menuLayout);
        AddATaskPanel = new AddATaskPanel(user);
        taskViewPanel = new TaskViewPanel(user);
        userInfoPanel = new UserInfoPanel(user);
        add(AddATaskPanel, "addTasks");
        add(taskViewPanel, "taskTable");
        add(userInfoPanel, "infoPanel");
    }

}
