/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medistock.controller;

import com.mycompany.medistock.dao.UserDao;
import com.mycompany.medistock.entity.User;
import com.mycompany.medistock.view.LoginView;
import com.mycompany.medistock.view.PharMedView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ADMINZ
 */
public class LoginController {
    private UserDao userDao;
    private LoginView loginView;
     
    public LoginController(LoginView view) {
        this.loginView = view;
        this.userDao = new UserDao();
        view.LoginListener(new LoginListener());
    }
     
    public void showLoginPanel() {
        loginView.setVisible(true);
    }
     
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            if (userDao.checkUser(user)) {
                PharMedView pharMedView = new PharMedView();
                PharMedController pharMedController = new PharMedController(pharMedView);
                pharMedController.showPharMedView();
                loginView.setVisible(false);
            } else {
                loginView.showMessage("username hoặc password không đúng.");
            }
        }
    }
}
