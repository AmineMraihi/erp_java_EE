package tn.esprit.b1.esprit1718b1erp.app.client.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.RejectedExecutionException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;
import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.services.amine.CategoryServiceRemote;

public class Test1Controller implements Initializable {

    @FXML
    private AnchorPane paneTabel;

    @FXML
    private TableView<Category> tableData;

    @FXML
    private TableColumn<Category, String> name;

    @FXML
    private TableColumn<Category, String> description;

    @FXML
    private AnchorPane paneCrud;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextArea txtDescription;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnNew;

    @FXML
    private ImageView imgLoad;

    @FXML
    private ProgressBar bar;

    private ObservableList<Category> listData;

    Config2 con = new Config2();
    CategoryServiceRemote categorieService;

    private InitialContext ctx = null;
    private final String jndiNameCategory = "esprit1718b1erp-ear/esprit1718b1erp-service/CategoryService!tn.esprit.b1.esprit1718b1erp.services.amine.CategoryServiceRemote";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            Config2.setModelColumn(name, "name");
            Config2.setModelColumn(description, "description");
            selectWithService();
        });
    }

    @FXML
    void aksiBack(ActionEvent event) {
        paneCrud.setOpacity(0);
        selectWithService();
    }

    @FXML
    void aksiKlikTableData(MouseEvent event) {

    }

    @FXML
    void aksiNew(ActionEvent event) {
        paneTabel.setOpacity(0);
        new FadeInUpTransition(paneCrud).play();
    }

    @FXML
    void aksiSave(ActionEvent event) {
        Category category = new Category();
        category.setName(txtName.getText());
        category.setDescription(txtDescription.getText());
        addcategory(category);
    }

    private void selectWithService() {
        Service<Integer> service = new Service<Integer>() {
            @Override
            protected Task<Integer> createTask() {
                selectData();
                return new Task<Integer>() {
                    @Override
                    protected Integer call() throws Exception {
                        Integer max = categorieService.findAll().size();
                        if (max > 35) {
                            max = 30;
                        }
                        updateProgress(0, max);
                        for (int k = 0; k < max; k++) {
                            Thread.sleep(60);
                            updateProgress(k + 1, max);
                        }
                        return max;
                    }
                };
            }
        };
        service.start();
        bar.progressProperty().bind(service.progressProperty());
        service.setOnRunning((WorkerStateEvent event) -> {
            imgLoad.setVisible(true);
        });
        service.setOnSucceeded((WorkerStateEvent event) -> {
            imgLoad.setVisible(false);
            new FadeInUpTransition(paneTabel).play();
        });
    }

    private void selectData() {
        if (listData == null) {
            listData = FXCollections.observableArrayList(findAll());
        } else {
            listData.clear();
            listData.addAll(findAll());
        }
        tableData.setItems(listData);
    }

    private void addcategory(Category c) {
        try {
            ctx = new InitialContext();
            categorieService = (CategoryServiceRemote) ctx.lookup(jndiNameCategory);
            categorieService.save(c);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
    }

    private List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {
            ctx = new InitialContext();
            categorieService = (CategoryServiceRemote) ctx.lookup(jndiNameCategory);
            categories = categorieService.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return categories;
    }

}
