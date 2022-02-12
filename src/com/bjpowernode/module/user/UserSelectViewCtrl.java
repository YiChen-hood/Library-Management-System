package com.bjpowernode.module.user;

import com.bjpowernode.bean.User;
import com.bjpowernode.global.util.Alerts;
import com.bjpowernode.module.book.BookLendViewCtrl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * user search
 *
 * @author admin
 */
public class UserSelectViewCtrl implements Initializable {

    @FXML
    private TableView<User> userTableView;
    @FXML
    private TableColumn<User, String> c1;
    @FXML
    private TableColumn<User, String> c2;

    ObservableList<User> users = FXCollections.observableArrayList();

    private Stage stage;

    private BookLendViewCtrl bookLendViewCtrl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        users.add(new User(1, "Jack", "normal", new BigDecimal(("100"))));
        users.add(new User(2, "Tony", "normal", new BigDecimal(("100"))));
        users.add(new User(3, "Mike", "normal", new BigDecimal(("100"))));
        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
        c2.setCellValueFactory(new PropertyValueFactory<>("name"));
        userTableView.setItems(users);

    }

    @FXML
    private void userSelect() {
        User user = this.userTableView.getSelectionModel().getSelectedItem();
        if (user == null){
            Alerts.warning("please select","select user");
            return;
        }

        bookLendViewCtrl.setUser(user);

        stage.close();

    }

    public BookLendViewCtrl getBookLendViewCtrl() {
        return bookLendViewCtrl;
    }

    public void setBookLendViewCtrl(BookLendViewCtrl bookLendViewCtrl) {
        this.bookLendViewCtrl = bookLendViewCtrl;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
