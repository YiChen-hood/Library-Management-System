package com.bjpowernode.module.user;

import com.bjpowernode.bean.Constant;
import com.bjpowernode.bean.User;
import com.bjpowernode.global.util.Alerts;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.math.BigDecimal;


public class UserHandleViewCtrl {

    @FXML
    private TextField userIdField;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField moneyField;

    private Stage stage;

    private TableView<User> userTableView;

    private ObservableList<User> users;

    // user
    private User user;

    /*
        add or edit
     */
    @FXML
    private void addOrEditUser() {
        try {
            String id = userIdField.getText();
            if ("".equals(id) || null == id) {
                User user = new User();
                populate(user);
                user.setStatus(Constant.USER_OK);
                users.add(user);
            }else {
                populate(this.user);
                userTableView.refresh();
            }

            stage.close();
            Alerts.success("success", "successful operation");
        } catch (Exception e) {
            e.printStackTrace();
            Alerts.error("fail","failed operation");
        }

    }

    private void populate(User user) {
        user.setMoney(new BigDecimal(moneyField.getText()));
        user.setName(userNameField.getText());
    }

    @FXML
    private void closeView() {
        stage.close();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public ObservableList<User> getUsers() {
        return users;
    }

    public void setUsers(ObservableList<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            //edit balance displayed on interface
            userNameField.setText(user.getName());
            userIdField.setText(String.valueOf(user.getId()));
            moneyField.setText(user.getMoney().toString());
        }

    }

    public TableView<User> getUserTableView() {
        return userTableView;
    }

    public void setUserTableView(TableView<User> userTableView) {
        this.userTableView = userTableView;
    }
}
