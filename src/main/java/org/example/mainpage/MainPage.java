package org.example.mainpage;

import org.example.mainpage.subpages.AddCoworkerPanel;
import org.example.mainpage.subpages.CoworkersPanel;
import org.example.mainpage.subpages.SendEmailPanel;
import org.example.mainpage.subpages.UserInfoPanel;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JPanel {

    private SendEmailPanel sendEmailPanel;

    private CoworkersPanel coworkersPanel;

    private AddCoworkerPanel addCoworkerPanel;

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
        sendEmailPanel = new SendEmailPanel();
        coworkersPanel = new CoworkersPanel();
        addCoworkerPanel = new AddCoworkerPanel();
        userInfoPanel = new UserInfoPanel();
        add(sendEmailPanel, "email");
        add(coworkersPanel, "coworkers");
        add(addCoworkerPanel, "addCoworkers");
        add(userInfoPanel, "infoPanel");
    }

}
