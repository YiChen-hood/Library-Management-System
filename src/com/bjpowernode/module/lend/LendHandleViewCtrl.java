package com.bjpowernode.module.lend;


import com.bjpowernode.bean.Constant;
import com.bjpowernode.bean.Lend;
import com.bjpowernode.global.util.Alerts;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LendHandleViewCtrl {

    @FXML
    private TextField lendIdField;

    @FXML
    private TextField lendNameField;

    @FXML
    private TextField isbnField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField publisherField;

    @FXML
    private ComboBox typeField;

    private Stage stage;

    private TableView<Lend> lendTableView;

    private ObservableList<Lend> lends;

    // lender
    private Lend lend;

    /*
        add or edit for lender
     */
    @FXML
    private void addOrEditLend() {
        try {
            String id = lendIdField.getText();
            if ("".equals(id) || null == id) {
                // add
                Lend lend = new Lend();
                populate(lend);
                lend.setStatus(Constant.STATUS_STORAGE);
                lends.add(lend);
            }else {
                // edit
                populate(this.lend);
                // refresh
                lendTableView.refresh();
            }

            stage.close();
            Alerts.success("success", "successful operation");
        } catch (Exception e) {
            e.printStackTrace();
            Alerts.error("fail","failed operation");
        }

    }

    private void populate(Lend lend) {
//        lend.setLendName(lendNameField.getText());
//        lend.setAuthor(authorField.getText());
//        lend.setIsbn(isbnField.getText());
//        lend.setPublisher(publisherField.getText());
//        lend.setType(typeField.getSelectionModel().getSelectedItem().toString());
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

    public ObservableList<Lend> getLends() {
        return lends;
    }

    public void setLends(ObservableList<Lend> lends) {
        this.lends = lends;
    }

    public Lend getLend() {
        return lend;
    }

    public void setLend(Lend lend) {
        this.lend = lend;
        if (lend != null) {
            // edit values of interface
//            lendNameField.setText(lend.getLendName());
//            authorField.setText(lend.getAuthor());
//            isbnField.setText(lend.getIsbn());
//            lendIdField.setText(String.valueOf(lend.getId()));
//            publisherField.setText(lend.getPublisher());
//            typeField.setValue(lend.getType());
        }

    }

    public TableView<Lend> getLendTableView() {
        return lendTableView;
    }

    public void setLendTableView(TableView<Lend> lendTableView) {
        this.lendTableView = lendTableView;
    }
}
