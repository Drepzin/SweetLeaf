package org.example.mainpage;

import org.example.mainpage.subpages.TablePanel;
import org.example.models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainApp extends JFrame {

    private LateralMenu lateralMenu;

    private MainPage mainPage;

    private UserMenu userMenu;

    private User user;

    public MainApp(User user){
        this.user = user;
        init();
    }

    private void init(){
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sweet Leaf");
        setLayout(new GridBagLayout());
        //
        GridBagConstraints grdLateral = new GridBagConstraints();
        grdLateral.gridx = 0;
        grdLateral.gridy = 0;
        grdLateral.fill = GridBagConstraints.BOTH;
        grdLateral.gridheight = 1;
        grdLateral.gridwidth = 1;
        grdLateral.weightx = 0.5;
        grdLateral.weighty = 1.0;
        lateralMenu = new LateralMenu();
        add(lateralMenu, grdLateral);
        //
        GridBagConstraints grdMain = new GridBagConstraints();
        grdMain.gridx = 1;
        grdMain.gridy = 0;
        grdMain.fill = GridBagConstraints.BOTH;
        grdMain.gridheight = 1;
        grdMain.gridwidth = 1;
        grdMain.weightx = 4;
        grdMain.weighty = 1;
        mainPage = new MainPage(user);
        add(mainPage, grdMain);
        //
        GridBagConstraints grdUser = new GridBagConstraints();
        grdUser.gridx = 2;
        grdUser.gridy = 0;
        grdUser.fill = GridBagConstraints.BOTH;
        grdUser.gridheight = 1;
        grdUser.gridwidth = 1;
        grdUser.weightx = 0.5;
        grdUser.weighty = 1;
        userMenu = new UserMenu(user);
        add(userMenu, grdUser);
        //
        lateralMenu.addTaskButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainPage.menuLayout.show(mainPage, "addTasks");
            }
        });
        //
        lateralMenu.taskTableButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainPage.menuLayout.show(mainPage, "taskTable");
            }
        });
        //
        userMenu.editInfoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainPage.menuLayout.show(mainPage, "infoPanel");
            }
        });
        pack();
        setSize(1200, 800);
        setResizable(false);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
