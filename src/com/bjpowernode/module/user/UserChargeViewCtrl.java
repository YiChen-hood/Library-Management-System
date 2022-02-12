package com.bjpowernode.module.user;

import com.bjpowernode.bean.Constant;
import com.bjpowernode.bean.User;
import com.bjpowernode.global.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.math.BigDecimal;

public class UserChargeViewCtrl {

    @FXML
    private TextField moneyField;

    private Stage stage;

    private User user;

    private TableView<User> userTableView;

    /*
        charge/deposit
     */
    @FXML
    private void charge() {
        try {
            // current balance
            BigDecimal before = user.getMoney();
            // charge now
            BigDecimal money = new BigDecimal(moneyField.getText());
            // add
            BigDecimal after = before.add(money);
            // check now balance
            if (after.compareTo(BigDecimal.ZERO) >= 0) {
                // edit status
                user.setStatus(Constant.USER_OK);
            }
            userTableView.refresh();
            stage.close();
            Alerts.success("success", "successful operation");
        } catch (Exception e) {
            e.printStackTrace();
            Alerts.error("fail","failed operation");
        }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public TableView<User> getUserTableView() {
        return userTableView;
    }

    public void setUserTableView(TableView<User> userTableView) {
        this.userTableView = userTableView;
    }
}
