package org.example.mainpage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainApp extends JFrame {

    private LateralMenu lateralMenu;

    private MainPage mainPage;

    private UserMenu userMenu;

    public MainApp(){
        init();
    }

    private void init(){
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
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
        mainPage = new MainPage();
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
        userMenu = new UserMenu();
        add(userMenu, grdUser);
        //
        lateralMenu.coworkersButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainPage.menuLayout.show(mainPage, "coworkers");
            }
        });
        //
        lateralMenu.sendEmailButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainPage.menuLayout.show(mainPage, "email");
            }
        });
        //
        lateralMenu.addCoworkerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mainPage.menuLayout.show(mainPage, "addCoworkers");
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
        setResizable(false);
    }
}
