package org.example.mainpage;

import org.example.mainpage.subpages.TaskViewPanel;
import org.example.mainpage.subpages.AddATaskPanel;
import org.example.mainpage.subpages.UserInfoPanel;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JPanel {

    private AddATaskPanel AddATaskPanel;

    private TaskViewPanel taskViewPanel;

    private UserInfoPanel userInfoPanel;

    public CardLayout menuLayout;

    public MainPage(){
        init();
    }

    private void init(){
        setVisible(true);
        setMinimumSize(new Dimension(800, 800));
        menuLayout = new CardLayout();
        setLayout(menuLayout);
        AddATaskPanel = new AddATaskPanel();
        taskViewPanel = new TaskViewPanel();
        userInfoPanel = new UserInfoPanel();
        add(AddATaskPanel, "addTasks");
        add(taskViewPanel, "taskTable");
        add(userInfoPanel, "infoPanel");
    }

}
