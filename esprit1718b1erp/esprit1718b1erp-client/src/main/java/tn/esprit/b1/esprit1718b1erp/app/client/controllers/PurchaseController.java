package tn.esprit.b1.esprit1718b1erp.app.client.controllers;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.RejectedExecutionException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.scene.control.Alert;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;
import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.Item_Type;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Purchase;
import tn.esprit.b1.esprit1718b1erp.entities.Purchase_type;
import tn.esprit.b1.esprit1718b1erp.entities.Statupurchase;
import tn.esprit.b1.esprit1718b1erp.entities.TypePayementPurchase;
import tn.esprit.b1.esprit1718b1erp.services.ahmed.PurchaseServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.amine.CategoryServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectServiceRemote;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class PurchaseController implements Initializable {

    @FXML
    private AnchorPane paneCrud;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtPurchaseCode;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnBack;
    @FXML
    private TextArea txtDescription;
    @FXML
    private AnchorPane paneTabel;
    @FXML
    private TableView<?> tableData;
    @FXML
    private TableColumn<?, ?> colAction;
    @FXML
    private TableColumn<?, ?> colProductId;
    @FXML
    private TableColumn<?, ?> colManufacturerIid;
    @FXML
    private TableColumn<?, ?> colProductCode;
    @FXML
    private TableColumn<?, ?> colPurchaseCost;
    @FXML
    private TableColumn<?, ?> colQuantityOnHand;
    @FXML
    private TableColumn<?, ?> colMarkup;
    @FXML
    private TableColumn<?, ?> colAvailable;
    @FXML
    private TableColumn<?, ?> colDescription;
    @FXML
    private Button btnNew;
    @FXML
    private ProgressBar bar;
    @FXML
    private ImageView imgLoad;
    @FXML
    private Label txtsupadresse;
    @FXML
    private ComboBox<Contact> cbsupplier;
    @FXML
    private CheckBox paid;
    @FXML
    private CheckBox unpaid;
    @FXML
    private ComboBox<Project> cbProjectname;
    @FXML
    private DatePicker txtdaterequested;
    @FXML
    private DatePicker txtdeliverydate;
    @FXML
    private ComboBox<Item> cbitems;
    @FXML
    private TextField txtQuantity;
    @FXML
    private TextField txtamont;
    @FXML
    private TextField txtsuppphone;
    @FXML
    private ComboBox<String> cbtypepurchase;
    @FXML
    private ComboBox<String> txtpaymenttype;
    
    @FXML
    private TableView<Item> tableitem;
    @FXML
    private AnchorPane paneTabel1;
    @FXML
    private TableColumn<Item, Integer> tbbarcode;
    @FXML
    private TableColumn<Item, String> tbname;
    @FXML
    private TableColumn<Item, String> tbdescription;
    @FXML
    private TableColumn<Item, Integer> tbquantity;
    @FXML
    private TableColumn tbaction;
    @FXML
    private TableColumn<Item, Float> tbprice;
    
    
   

    
    

    private final String jndiNameItem = "esprit1718b1erp-ear/esprit1718b1erp-service/ItemService!tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote";
    private final String jndiPurchase = "esprit1718b1erp-ear/esprit1718b1erp-service/PurchaseService!tn.esprit.b1.esprit1718b1erp.services.ahmed.PurchaseServiceRemote";
    private final String jndiNameSupplier = "esprit1718b1erp-ear/esprit1718b1erp-service/ContactService!tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote";
    private final String jndiNameProject = "esprit1718b1erp-ear/esprit1718b1erp-service/ProjectService!tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectServiceRemote";
    private InitialContext ctx = null;

    private ObservableList<Item> listData;

    ItemServiceRemote itemService;
    PurchaseServiceRemote purchaseService;
    ContactServiceRemote contactService;
    ProjectServiceRemote projectService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Platform.runLater(() -> {
          /* try {
            showPubDetailItem();
            selectWithService();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          */
           cbitems.setOnAction(e->{
               try {
                showPubDetailItem();
                selectWithService();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
              
           });
            cbsupplier.getItems().addAll(findAllContact());
            cbsupplier.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    showPubDetails(newValue);
                } catch (Exception ex) {
                 
                }
            });
            cbProjectname.getItems().addAll(findAlProjects());
          

            cbtypepurchase.getItems().addAll("Purchases of raw materials", "Manufactured purchases",
                    "Investment purchases", "Trading purchases", "Overhead purchases", "Service purchases");
            txtpaymenttype.getItems().addAll("Cash", "Check", "Credit Card");
          
            cbitems.getItems().addAll(findAlItemsfind());
            
        });
        
    }

    @FXML
    private void aksiSave(ActionEvent event) throws Exception {
        String typepurchase = cbtypepurchase.getValue();
        String tpaymenttype = txtpaymenttype.getValue();
       
            Contact supplier = cbsupplier.getValue(); 
           
       
       
        Project Projectname = cbProjectname.getValue();
        String Description = txtDescription.getText();
        

        Date daterequested = convert(txtdaterequested.getEditor().getText());
        Date deliverydate = convert(txtdaterequested.getEditor().getText());
        Purchase purchase = new Purchase(supplier, daterequested, deliverydate, typepurchase, Description,
                tpaymenttype);

        if ((paid.isSelected()) && (unpaid.isSelected())) {
            Config2.dialog(Alert.AlertType.WARNING, "Choose only one parameter");
            paid.requestFocus();
        } else if (paid.isSelected()) {
            purchase.setStatupurchase(Statupurchase.Paid);
        } else
            purchase.setStatupurchase(Statupurchase.Unpaid);

        addPurchase(purchase);
       /////  showPubDetailItem();
         /////selectWithService();
      
    }

    private void addPurchase(Purchase i) {
        try {
            ctx = new InitialContext();
            purchaseService = (PurchaseServiceRemote) ctx.lookup(jndiPurchase);
            purchaseService.save(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
    }

    @FXML
    private void aksiBack(ActionEvent event) {
    }

    @FXML
    private void aksiQuantity(KeyEvent event) {
    }

    @FXML
    private void aksiTrue(ActionEvent event) {
    }

    @FXML
    private void aksiFalse(ActionEvent event) {
    }

    @FXML
    private void aksiKlikTableData(MouseEvent event) {
    }

    @FXML
    private void aksiNew(ActionEvent event) {
        paneTabel.setOpacity(0);
        new FadeInUpTransition(paneCrud).play();
        Platform.runLater(() -> {

        });
    }

    private List<Contact> findAllContact() {
        List<Contact> contacts = new ArrayList<>();
        try {
            ctx = new InitialContext();
            contactService = (ContactServiceRemote) ctx.lookup(jndiNameSupplier);
            contacts = contactService.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return contacts;
    }

    private List<Project> findAlProjects() {
        List<Project> projects = new ArrayList<>();
        try {
            ctx = new InitialContext();
            projectService = (ProjectServiceRemote) ctx.lookup(jndiNameProject);
            projects = projectService.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return projects;
    }

    private List<Item> findAlItemsfind() {
        List<Item> items = new ArrayList<>();
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            items = itemService.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e2) {
            System.out.println("catched rejected");
        }
        return items;
    }

    public static Date convert(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = sdf.parse(date);
        return d1;
    }
    
    void showPubDetails(Contact I) throws ParseException {
        txtsuppphone.setText(String.valueOf(I.getPhone()));
        txtPurchaseCode.setText((I.getStreet()));
    }
    void showPubDetailItem() throws ParseException {
        ////////listData = FXCollections.observableArrayList();
       Config2.setModelColumn(tbbarcode, "barcode");
        Config2.setModelColumn(tbname, "name");
        Config2.setModelColumn(tbdescription, "description");
        Config2.setModelColumn(tbquantity, "quantity");
        Config2.setModelColumn(tbprice, "byingPrice");
     /* tbname.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Item, String> parm) {
                        return new SimpleStringProperty(parm.getValue().getName());                       
                    }
                });
*/
       
    }
    
    
    @FXML
    private void ONiTEM_action(ActionEvent event) {
      
      /*  System.out.println("hi ahmed");
        tableitem.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                showPubDetailItem(newValue);
                selectWithService();
            } catch (Exception ex) {
             
            }
        });
       try {
        showPubDetailItem();
        selectWithService();
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
       
     /////  selectData();
        System.out.println(cbitems.getValue().getBarcode() +"hi "+ cbitems.getValue().getDescription());
       */ 
    }
    
    
    private void selectData() {
        if (listData == null) {
            listData = FXCollections.observableArrayList(findItem(cbitems.getValue()));
            System.out.println("***********************");
            System.out.println(listData);
        } else {
            //////listData.clear();
            listData.addAll(findItem(cbitems.getValue()));
            System.out.println("deffeefefe");
        }
        tableitem.setItems(listData);
    }
    
    private List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            items = itemService.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return items;
    }
    
    
    private Item findItem(Item I) {
       Item az = new Item();
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            az = itemService.find(I.getId());
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return az;
    }
    
    
    private void selectWithService() {
        Service<Integer> service = new Service<Integer>() {
            @Override
            protected Task<Integer> createTask() {
                selectData();
                return new Task<Integer>() {
                    @Override
                    protected Integer call() throws Exception {
                        Integer max = itemService.findAll().size();
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
          //////  new FadeInUpTransition(paneTabel).play();
        });
    }

}
