package tn.esprit.b1.esprit1718b1erp.app.client.controllers;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.RejectedExecutionException;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.NoResultException;

import netscape.javascript.JSObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.annotations.Parent;
//import com.github.snowdream.android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
//import com.lynden.gmapsfx.javascript.object.MapType;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.shapes.Circle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.scene.control.Hyperlink;
import javafx.stage.Modality;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableRow;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import javafx.fxml.FXMLLoader;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInRightTransition;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeOutUpTransition;
import tn.esprit.b1.esprit1718b1erp.entities.Campaign;
import tn.esprit.b1.esprit1718b1erp.entities.Campaign_Type;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Intervention;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Report;
import tn.esprit.b1.esprit1718b1erp.entities.SaleOpportunity;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.services.UserServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.shil.CampaignServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.shil.ProductServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.shil.ReportServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.shil.SaleOpportunityService;
import tn.esprit.b1.esprit1718b1erp.services.shil.SaleOpportunityServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectServiceRemote;

public class MarketingController implements Initializable, MapComponentInitializedListener {

    @FXML
    private TextField subjectReport;

    @FXML
    private HTMLEditor DescriptionReport;

    @FXML
    private AnchorPane mainAnchor;
    @FXML
    private AnchorPane TablePane1;

    @FXML
    private Button saveReport;

    @FXML
    private Button close;

    @FXML
    private DatePicker date;

    @FXML
    private AnchorPane paneCrud2;

    @FXML
    private Button btnUpload1;

    @FXML
    private TextField saleOpportunityBudget;

    @FXML
    private AnchorPane paneCrud1;

    @FXML
    private Button btnAddContact1;

    @FXML
    private Button btnNew1;

    @FXML
    private TextField txtStreet1;

    @FXML
    private TextField txtCity1;

    @FXML
    private ProgressBar bar;

    @FXML
    private TextField txtCountry1;

    @FXML
    private ImageView imgItem1;

    @FXML
    private TextField txtphone1;

    @FXML
    private TabPane TabPane;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnBack1;

    @FXML
    private Button btnNew111;

    @FXML
    private Hyperlink pathHyperLink;

    @FXML
    private Label locationMarker;

    @FXML
    private Hyperlink labelFromNewReport;

    @FXML
    private Button btnBack2;

    @FXML
    private TextField txtWebsite1;

    @FXML
    private AnchorPane TablePane2;

    @FXML
    private HTMLEditor reportEditor;

    @FXML
    private GoogleMapView mapView;

    private GoogleMap map;

    @FXML
    private TableView<SaleOpportunity> saleOplistTable;

    @FXML
    private TableColumn<SaleOpportunity, String> saleNameCol;

    @FXML
    private TableColumn<SaleOpportunity, String> regionCol;

    @FXML
    private TableColumn<SaleOpportunity, String> productCol;

    @FXML
    private TableColumn<SaleOpportunity, Date> dateCol;

    @FXML
    private TableColumn<SaleOpportunity, String> respCol;

    @FXML
    private TextField txtemail1;

    @FXML
    private ComboBox<String> productSelection;

    @FXML
    private TextField SaleOpportunityName;

    @FXML
    private Button btnNew12;

    @FXML
    private Button btnNew11;

    @FXML
    private Button btnNew;

    @FXML
    private TextField txtLastName1;

    @FXML
    private TextField txtmobile1;

    @FXML
    private TextField txtRegion1;

    @FXML
    private ImageView imgLoad;

    @FXML
    private TextField txtZipCode1;

    @FXML
    private AnchorPane reportAnchor;

    @FXML
    private ComboBox<?> cbLanguage1;

    @FXML
    private GridPane gridPane;
    @FXML
    private TextField nameSaleOppDis;

    @FXML
    private TextField dateSaleOppDis;

    @FXML
    private TextField budgetSaleOppDis;

    @FXML
    private TextField productSaleOppDis;
    @FXML
    private ComboBox<Contact> participantsSelection;

    @FXML
    private ComboBox<Product> productsSelectionCampaign;
    @FXML
    private TableView<Product> tableOfSelectedProducts;

    @FXML
    private TableColumn<Product, String> nameColumnOfSelectedProducts;

    @FXML
    private TableView<Contact> tableOfSelectedCampaigns;

    @FXML
    private TableColumn<Contact, String> nameColumnOfSelectedCampaigns;

    @FXML
    private TableColumn<Contact, String> countryColumnOfSelectedCampaigns;
    @FXML
    private RadioButton radioType;
    @FXML
    private RadioButton radioType1;

    @FXML
    private TextField campaignNameInput;

    @FXML
    private DatePicker beginingDateInput;

    @FXML
    private DatePicker endingDateInput;

    @FXML
    private TextArea DescriptionInput;

    @FXML
    private TextField BudgetCampaignInput;

    @FXML
    private AnchorPane listProductsPane;
    @FXML
    private AnchorPane ShowPane;

    @FXML
    private Button close1;
    @FXML
    private TableView<SaleOpportunity> tableOfSaleOpportunititiesShow;

    @FXML
    private TableColumn<SaleOpportunity, String> nameColumnOfSalesShow;

    @FXML
    private TableColumn<SaleOpportunity, String> nameProductColumnOfSalesShow;

    @FXML
    private TableColumn<SaleOpportunity, Float> budgetColumnOfSalesShow;

    @FXML
    private TableColumn<SaleOpportunity, String> responsableNameColumnOfSalesShow;

    @FXML
    private HTMLEditor reportSaleOpportunititiesShow;

    @FXML
    private TableColumn<SaleOpportunity, String> regionColumnOfSalesShow;

    @FXML
    private HBox hboxToHide;
    @FXML
    private TableView<Campaign> tableOfCampaingsShow;

    @FXML
    private TableColumn<Campaign, String> nameColumnOfCampaingShow;

    @FXML
    private TableColumn<Campaign, String> DescripnColumnOfCampaingShow;

    @FXML
    private TableColumn<Campaign, String> budgetColumnOfCampaingShow;

    @FXML
    private TableColumn<Campaign, String> responsableNameColumnOfCampainghow;

    @FXML
    private TableColumn<Campaign, String> typeColumnOfCampaingShow;

    @FXML
    private TableColumn<Campaign, String> beginingColumnOfCampaingShow;

    @FXML
    private TableColumn<Campaign, String> endingColumnOfCampaingShow;
    // @FXML
    // private GoogleMapView mapSalesShow;
    // private GoogleMap map2;

    private static final String jndiNameMarketing = "esprit1718b1erp-ear/esprit1718b1erp-service/SaleOpportunityService!tn.esprit.b1.esprit1718b1erp.services.shil.SaleOpportunityServiceRemote";
    private static final String jndiNameReport = "esprit1718b1erp-ear/esprit1718b1erp-service/ReportService!tn.esprit.b1.esprit1718b1erp.services.shil.ReportServiceRemote";
    private final String jndiNameUser = "esprit1718b1erp-ear/esprit1718b1erp-service/UserService!tn.esprit.b1.esprit1718b1erp.services.UserServiceRemote";
    private final String jndiNameProduct = "esprit1718b1erp-ear/esprit1718b1erp-service/ProductService!tn.esprit.b1.esprit1718b1erp.services.shil.ProductServiceRemote";
    private final String jndiNameContact = "esprit1718b1erp-ear/esprit1718b1erp-service/ContactService!tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote";
    private final String jndiNameCampaign = "esprit1718b1erp-ear/esprit1718b1erp-service/CampaignService!tn.esprit.b1.esprit1718b1erp.services.shil.CampaignServiceRemote";

    ContactServiceRemote contactService;
    ProductServiceRemote productService;
    ReportServiceRemote reportService;
    SaleOpportunityServiceRemote saleOpportunityService;
    UserServiceRemote userService;
    CampaignServiceRemote campaignService;

    private InitialContext ctx = null;

    User user = new User();
    Report report = new Report();
    Boolean fileaAlreadyExists = false;
    double latPosition;
    double lngPosition;
    SaleOpportunity saleToAffectToCampaign = new SaleOpportunity();
    Boolean checkIfSkipped = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (!LoginController.getLoggedUser().getUserFct().toString().equals("DIRECTOR")&&!LoginController.getLoggedUser().getUserFct().toString().equals("MARKETING_MANAGER")) {
           System.out.println(LoginController.getLoggedUser().getUserFct().toString());
            hboxToHide.setVisible(false);
        }
        ShowPane.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, blue, 50, 0, 0, 0);" + "-fx-background-insets: 0;");

        ShowPane.toFront();
        // new FadeInUpTransition(reportAnchor).play();
        ToggleGroup group = new ToggleGroup();
        radioType.setToggleGroup(group);
        radioType1.setToggleGroup(group);

        mapView.setVisible(true);
        mapView.addMapInializedListener(this);

        reportEditor.setVisible(false);

        labelFromNewReport.setVisible(false);
        try {
            ctx = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        try {
            productService = (ProductServiceRemote) ctx.lookup(jndiNameProduct);
            saleOpportunityService = (SaleOpportunityServiceRemote) ctx.lookup(jndiNameMarketing);
            contactService = (ContactServiceRemote) ctx.lookup(jndiNameContact);
        } catch (NamingException e) {
            e.printStackTrace();
        }

        ObservableList<String> productsList = FXCollections.observableArrayList(productService.productNames());
        productSelection.setItems(productsList);
        ObservableList<SaleOpportunity> listSaleOp = FXCollections
                .observableArrayList(saleOpportunityService.findAll());
        Config2.setModelColumn(saleNameCol, "nameSaleOpportunity");

        Config2.setModelColumn(regionCol, "region");
        Config2.setModelColumn(productCol, "region");
        productCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<SaleOpportunity, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<SaleOpportunity, String> param) {
                        return new SimpleStringProperty(param.getValue().getProduit().getNomProduit());
                    }
                });
        Config2.setModelColumn(dateCol, "creationDate");
        respCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<SaleOpportunity, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<SaleOpportunity, String> param) {
                        return new SimpleStringProperty(param.getValue().getResponsable().getName());
                    }
                });
        /*
         * respCol.setCellFactory(column -> { return new TableCell<SaleOpportunity,
         * String>() {
         * 
         * @Override protected void updateItem(String item, boolean empty) {
         * super.updateItem(item, empty);
         * 
         * setText(empty ? "" : getItem().toString()); setGraphic(null);
         * 
         * TableRow<SaleOpportunity> currentRow = getTableRow();
         * 
         * if (!isEmpty()) {
         * 
         * if(item.equals("user")) { setStyle("-fx-background-color: yellow");} else
         * currentRow.setStyle("-fx-background-color:lightgreen"); } } }; });
         */
        saleOplistTable.setItems(listSaleOp);
        saleOplistTable.setRowFactory(tv -> {
            TableRow<SaleOpportunity> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    SaleOpportunity rowData = row.getItem();
                    nameSaleOppDis.setText(rowData.getNameSaleOpportunity());
                    dateSaleOppDis.setText(rowData.getCreationDate().toString());
                    budgetSaleOppDis.setText(String.valueOf(rowData.getBudgetNeeded()));
                    productSaleOppDis.setText(rowData.getProduit().getNomProduit());
                    saleToAffectToCampaign = rowData;
                    new FadeOutUpTransition(TablePane1).play();
                    TablePane2.setOpacity(1.0);
                    new FadeInUpTransition(TablePane2).play();
                    checkIfSkipped = false;
                }
            });
            return row;
        });
        /// Here contact selection
        participantsSelection.setCellFactory(new Callback<ListView<Contact>, ListCell<Contact>>() {

            @Override
            public ListCell<Contact> call(ListView<Contact> arg0) {
                return new ListCell<Contact>() {
                    @Override
                    protected void updateItem(Contact item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setText(item.getName());
                        }
                    }
                };
            }
        });

        participantsSelection.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {

            if (!tableOfSelectedCampaigns.getItems().contains(newValue)) {
                tableOfSelectedCampaigns.getItems().add(newValue);
            }

        });
        Config2.setModelColumn(nameColumnOfSelectedCampaigns, "name");
        Config2.setModelColumn(countryColumnOfSelectedCampaigns, "country");
        if (!contactService.findAll().isEmpty()) {
            ObservableList<Contact> cantactsList = FXCollections.observableArrayList(contactService.findAll());
            participantsSelection.setItems(cantactsList);
        }
        // here selection of products
        productsSelectionCampaign.setCellFactory(new Callback<ListView<Product>, ListCell<Product>>() {

            @Override
            public ListCell<Product> call(ListView<Product> arg0) {
                return new ListCell<Product>() {
                    @Override
                    protected void updateItem(Product item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setText(item.getNomProduit());
                        }
                    }
                };
            }
        });

        productsSelectionCampaign.getSelectionModel().selectedItemProperty()
                .addListener((options, oldValue, newValue) -> {

                    if (!tableOfSelectedProducts.getItems().contains(newValue)) {
                        tableOfSelectedProducts.getItems().add(newValue);
                    }

                });

        Config2.setModelColumn(nameColumnOfSelectedProducts, "nomProduit");
        if (!productService.findAll().isEmpty()) {
            ObservableList<Product> productsListSelection = FXCollections.observableArrayList(productService.findAll());
            productsSelectionCampaign.setItems(productsListSelection);
        }

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (group.getSelectedToggle() != null) {
                    RadioButton chk = (RadioButton) radioType.getToggleGroup().getSelectedToggle();
                    // radio button
                    System.out.println("Selected Radio Button - " + chk.getText());
                    if (chk.getText().equals("Service")) {
                        new FadeOutUpTransition(listProductsPane).play();
                    } // Do something here with the userData of newly selected radioButton
                    else {
                        new FadeInRightTransition(listProductsPane).play();
                    }

                }

            }
        });
        Config2.setModelColumn(nameColumnOfSalesShow, "nameSaleOpportunity");
        Config2.setModelColumn(budgetColumnOfSalesShow, "budgetNeeded");
        Config2.setModelColumn(regionColumnOfSalesShow, "region");
        nameProductColumnOfSalesShow.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<SaleOpportunity, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<SaleOpportunity, String> param) {
                        return new SimpleStringProperty(param.getValue().getProduit().getNomProduit());
                    }
                });
        responsableNameColumnOfSalesShow.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<SaleOpportunity, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<SaleOpportunity, String> param) {
                        return new SimpleStringProperty(param.getValue().getResponsable().getName());
                    }
                });
        if (!saleOpportunityService.findAll().isEmpty()) {
            ObservableList<SaleOpportunity> saleOpssListSelectionShom = FXCollections
                    .observableArrayList(saleOpportunityService.findAll());
            tableOfSaleOpportunititiesShow.setItems(saleOpssListSelectionShom);
        }
        tableOfSaleOpportunititiesShow.setRowFactory(tv -> {
            TableRow<SaleOpportunity> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!row.isEmpty())) {
                    reportSaleOpportunititiesShow.setHtmlText(row.getItem().getReport().getDescrpiton());

                }
            });
            return row;
        });
        try {
            ctx = new InitialContext();
            campaignService = (CampaignServiceRemote) ctx.lookup(jndiNameCampaign);

        } catch (NamingException e) {

            e.printStackTrace();
        }
        Double f = campaignService.SommeBudgetOfCampaigns();
        saleOpportunityBudget.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!saleOpportunityBudget.getText().equals("")) {
                if (Double.valueOf(saleOpportunityBudget.getText()) > 500) { // Budget Totale
                    saleOpportunityBudget.setStyle("-fx-border-color:red;-fx-prompt-text-fill:red;-fx-text-fill: red;");
                } else {
                    saleOpportunityBudget
                            .setStyle("-fx-border-color:green;-fx-prompt-text-fill:green;-fx-text-fill: green;");
                }
            }

        });
        BudgetCampaignInput.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!BudgetCampaignInput.getText().equals("")) {
                if (Double.valueOf(BudgetCampaignInput.getText()) > (1000 - f)) {
                    BudgetCampaignInput.setStyle("-fx-border-color:red;-fx-prompt-text-fill:red;-fx-text-fill: red;");
                } else {
                    BudgetCampaignInput
                            .setStyle("-fx-border-color:green;-fx-prompt-text-fill:green;-fx-text-fill: green;");
                }
            }

        });
        endingDateInput.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue,
                    LocalDate newValue) {
                try {
                    if (convert(beginingDateInput.getEditor().getText())
                            .before(convert(endingDateInput.getEditor().getText()))) {
                        endingDateInput.getEditor().setText("");
                        Config2.dialog(Alert.AlertType.INFORMATION, "Please select a date after the Begining date ..");
                    }
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
        try {
            ctx = new InitialContext();
            campaignService = (CampaignServiceRemote) ctx.lookup(jndiNameCampaign);
        } catch (NamingException e) {
           
            e.printStackTrace();
        }
        
        if (!campaignService.findAll().isEmpty()) {
            ObservableList<Campaign> campaignListShow = FXCollections
                    .observableArrayList(campaignService.findAll());
            tableOfCampaingsShow.setItems(campaignListShow);
        }
        Config2.setModelColumn(nameColumnOfCampaingShow, "nameCampaign");
        Config2.setModelColumn(DescripnColumnOfCampaingShow, "description");
        Config2.setModelColumn(budgetColumnOfCampaingShow, "budget");
        Config2.setModelColumn(typeColumnOfCampaingShow, "type");
        typeColumnOfCampaingShow.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Campaign, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Campaign, String> param) {
                        return new SimpleStringProperty(param.getValue().getType().toString());
                    }
                });
        Config2.setModelColumn(beginingColumnOfCampaingShow, "beginningDate");
        Config2.setModelColumn(endingColumnOfCampaingShow, "endingDate");
        responsableNameColumnOfCampainghow.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Campaign, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Campaign, String> param) {
                        return new SimpleStringProperty(param.getValue().getResponsable().getName());
                    }
                });
        typeColumnOfCampaingShow.setCellFactory(column -> {
            return new TableCell<Campaign, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                 //   setText(empty ? "" : getItem().toString());
                  //  setGraphic(null);

                    TableRow<Campaign> currentRow = getTableRow();

                    if (!isEmpty()) {

                        if(item.equals("SALE")) 
                            currentRow.setStyle("-fx-background-color:lightcoral");
                        else if (item.equals("ADVERTISEMENT"))
                            currentRow.setStyle("-fx-background-color:lightgreen");
                        else 
                            currentRow.setStyle("-fx-background-color:lightblue");
                    }
                }
            };
        });
        
        
        

    }

    @FXML
    void AddNewCampaign() throws ParseException, NamingException {

        ctx = new InitialContext();
        campaignService = (CampaignServiceRemote) ctx.lookup(jndiNameCampaign);
        if (!(Double.valueOf((BudgetCampaignInput.getText())) > (1000 - campaignService.SommeBudgetOfCampaigns()))
                && !(Double.valueOf((BudgetCampaignInput.getText())) == 00.00)) {
            Campaign campaign = new Campaign();
            campaign.setNameCampaign(campaignNameInput.getText());
            campaign.setDescription(DescriptionInput.getText());
            campaign.setBeginningDate(convert(beginingDateInput.getEditor().getText()));
            campaign.setEndingDate(convert(endingDateInput.getEditor().getText()));
            campaign.setBudget(Float.valueOf(BudgetCampaignInput.getText()));
            campaign.setResponsable(LoginController.getLoggedUser());
            if (checkIfSkipped == false) {
                campaign.setSaleOpportunity(saleToAffectToCampaign);
            }
            RadioButton chk = (RadioButton) radioType.getToggleGroup().getSelectedToggle();
            if (chk == null) {
                campaign.setType(Campaign_Type.SALE);
            } else if (chk.getText().equals("Service")) {
                campaign.setType(Campaign_Type.SERVICE);

            } else if (chk.getText().equals("Advertisement")) {
                campaign.setType(Campaign_Type.ADVERTISEMENT);
            }

            // campaign.setProductsCampaign(tableOfSelectedProducts.getItems());
            /*
             * List<Contact> p = new ArrayList<>(); p = tableOfSelectedCampaigns.getItems();
             * campaign.getParticipants().addAll(p);
             * System.out.println(campaign.getParticipants());
             */
            campaignService.save(campaign);
            Config2.dialog(Alert.AlertType.INFORMATION, "Data Saved successfully..");
        } else {
            Config2.dialog(Alert.AlertType.INFORMATION, "Please put a reseanble budget or contact The Director  !");
        }

    }

    @FXML
    void addNewSaleOpportunity() throws ParseException, NamingException {

        SaleOpportunity saleOpportunity = new SaleOpportunity();

        if (!SaleOpportunityName.getText().equals("") && !date.getEditor().getText().equals("")
                && !locationMarker.getText().equals("")
                && !productSelection.getSelectionModel().getSelectedItem().equals("") && (report != null)) {

            saleOpportunity.setNameSaleOpportunity(SaleOpportunityName.getText());
            if (!date.getEditor().getText().equals("")) {
                saleOpportunity.setCreationDate(convert(date.getEditor().getText()));
            }

            ctx = new InitialContext();
            saleOpportunityService = (SaleOpportunityServiceRemote) ctx.lookup(jndiNameMarketing);
            userService = (UserServiceRemote) ctx.lookup(jndiNameUser);
            productService = (ProductServiceRemote) ctx.lookup(jndiNameProduct);

            saleOpportunity.setResponsable(LoginController.getLoggedUser());
            saleOpportunity.setRegion(locationMarker.getText());
            saleOpportunity.setLat(latPosition);
            saleOpportunity.setLng(lngPosition);
            saleOpportunity
                    .setProduit(productService.findAll().get(productSelection.getSelectionModel().getSelectedIndex()));
            saleOpportunity.setReport(report);
            saleOpportunity.setBudgetNeeded(Float.valueOf(saleOpportunityBudget.getText()));
            String stringHtml = reportEditor.getHtmlText();

            FileChooser fileChooser = new FileChooser();

            // Set extension filter
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");
            fileChooser.getExtensionFilters().add(extFilter);

            // Show save file dialog
            Stage stage = (Stage) SaleOpportunityName.getScene().getWindow();

            if (fileaAlreadyExists == false) {
                File file = fileChooser.showSaveDialog(stage);
                if (file != null) {

                    SaveFile(stringHtml, file);
                    // saleOpportunity.setReport(report);

                    pathHyperLink.setVisible(true);
                    pathHyperLink.setText(file.getAbsolutePath());
                    btnNew1.setVisible(false);
                    Config2.dialog(Alert.AlertType.INFORMATION, "Data Saved successfully..");
                    saleOpportunityService.save(saleOpportunity);
                }
            } else {
                Config2.dialog(Alert.AlertType.INFORMATION, "Data Saved successfully..");
                saleOpportunityService.save(saleOpportunity);
            }
        } else {
            Config2.dialog(Alert.AlertType.INFORMATION, "Please fill all fields  !");
        }

    }

    @FXML
    void newReportFunction() throws IOException {
        // reportEditor.setVisible(true);
        reportAnchor.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, blue, 50, 0, 0, 0);" + "-fx-background-insets: 0;");

        reportAnchor.toFront();
        new FadeInUpTransition(reportAnchor).play();

    }

    @FXML
    void AttachFile() throws IOException, NamingException {
        Stage stage = (Stage) reportEditor.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(stage);
        ctx = new InitialContext();
        reportService = (ReportServiceRemote) ctx.lookup(jndiNameReport);

        if (file != null) {
            fileaAlreadyExists = true;

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

            String response = new String();
            for (String line; (line = reader.readLine()) != null; response += line)
                ;
            // Report reportSearch = new Report();
            List<Report> report = new ArrayList<>();
            try {
                report = reportService.findByDescription(response);
            } catch (RejectedExecutionException e1) {
                System.out.println("catched rejected");
            }

            if (report.isEmpty()) {

                Alert alert = new Alert(AlertType.WARNING,
                        "Report doesn't exist in the database. Do you want to add it ?", ButtonType.YES, ButtonType.NO);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.YES) {
                    reportAnchor.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                            + "-fx-effect: dropshadow(gaussian, blue, 50, 0, 0, 0);" + "-fx-background-insets: 0;");

                    reportAnchor.toFront();
                    DescriptionReport.setHtmlText(response);
                    new FadeInUpTransition(reportAnchor).play();
                } else {
                    // ... user chose NO or closed the dialog
                }
            } else {

                mapView.setVisible(false);
                reportEditor.setHtmlText(response);
                reportEditor.setVisible(true);
                reportEditor.setDisable(true);
                labelFromNewReport.setVisible(false);
                pathHyperLink.setVisible(true);
                pathHyperLink.setText(file.getAbsolutePath());
                btnNew1.setVisible(false);
                this.report = report.get(0);
            }

        }

    }

    @FXML
    void pathHyperLinkFunction() throws IOException {
        File file = new File(pathHyperLink.getText());
        Desktop.getDesktop().open(file);

    }

    @FXML
    void labelFromNewReportFunction() {
        mapView.setVisible(false);
        reportEditor.setHtmlText(report.getDescrpiton());
        reportEditor.setVisible(true);
        reportEditor.setDisable(true);

    }

    @FXML
    void openMap() {
        mapView.setVisible(true);
        mapView.addMapInializedListener(this);

    }

    public static Date convert(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = sdf.parse(date);
        return d1;
    }

    private void SaveFile(String content, File file) {
        try {
            FileWriter fileWriter = null;

            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            // Logger.getLogger(JavaFX_HTMLeditor.class.getName()).log(Level.SEVERE, null,
            // ex);
        }
    }

    @FXML
    void CloseReport() {
        // reportAnchor.setOpacity(0);
        // reportAnchor.toBack();
        new FadeOutUpTransition(reportAnchor).play();
        // mainAnchor.toFront();

    }

    @FXML
    void CloseShow() {
        new FadeOutUpTransition(ShowPane).play();

    }

    @FXML
    void saevReportFunction() throws NamingException {

        ctx = new InitialContext();
        reportService = (ReportServiceRemote) ctx.lookup(jndiNameReport);
        if (!subjectReport.getText().equals("") && !DescriptionReport.getHtmlText().equals("")) {
            report.setReportName(subjectReport.getText());
            report.setDateReport(Calendar.getInstance().getTime());
            report.setDescrpiton(DescriptionReport.getHtmlText());
            reportService.save(report);
            report = reportService.findByDescription(report.getDescrpiton()).get(0);
            System.out.println(report);
            new FadeOutUpTransition(reportAnchor).play();
            btnNew1.setVisible(false);
            pathHyperLink.setVisible(false);
            labelFromNewReport.setVisible(true);
            labelFromNewReport.setText("Report Added");

        } else

        {
            Config2.dialog(Alert.AlertType.INFORMATION, "Please fill all fields !");
        }
    }

    @Override
    public void mapInitialized() {
        List<SaleOpportunity> saleOpportunities = new ArrayList<>();

        LatLong joeSmithLocation = new LatLong(47.6197, -122.3231);

        try {
            ctx = new InitialContext();
            saleOpportunityService = (SaleOpportunityServiceRemote) ctx.lookup(jndiNameMarketing);

        } catch (NamingException e1) {
            e1.printStackTrace();
        }
        // Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();

        mapOptions
                .center(new LatLong(saleOpportunityService.findAll().get(0).getLat(),
                        saleOpportunityService.findAll().get(0).getLng()))
                // .mapType(MapType)
                .overviewMapControl(false).panControl(false).rotateControl(false).scaleControl(false)
                .streetViewControl(false).zoomControl(false).zoom(3);

        map = mapView.createMap(mapOptions);

        saleOpportunities = saleOpportunityService.findAll();
        for (SaleOpportunity o : saleOpportunities) {
            LatLong newLocation = new LatLong(o.getLat(), o.getLng());
            MarkerOptions newmarkerOptions = new MarkerOptions();
            newmarkerOptions.position(newLocation);
            Marker newMarker = new Marker(newmarkerOptions);

            InfoWindowOptions newinfoWindowOptions = new InfoWindowOptions();
            newinfoWindowOptions.content("<h2>" + o.getNameSaleOpportunity() + "</h2>" + o.getRegion() + "<br>");

            InfoWindow newInfoWindow = new InfoWindow(newinfoWindowOptions);
            newInfoWindow.open(map, newMarker);

            map.addMarker(newMarker);

        }

        /*
         * map.addMarker(joshAndersonMarker); map.addMarker(bobUnderwoodMarker);
         * 
         * map.addMarker(fredWilkieMarker);
         */
        // Circle c = new Circle();
        MarkerOptions newmarkerOptions1 = new MarkerOptions();
        Marker newMarker = new Marker(newmarkerOptions1);
        InfoWindowOptions newinfoWindowOptions = new InfoWindowOptions();
        InfoWindow newInfoWindow = new InfoWindow(newinfoWindowOptions);

        map.addUIEventHandler(UIEventType.click, (JSObject obj) -> {
            LatLong ll = new LatLong((JSObject) obj.getMember("latLng"));
            lngPosition = ll.getLongitude();
            latPosition = ll.getLatitude();
            // c.setCenter(ll);
            // c.setRadius(402.00);
            // map.addMapShape(c);

            locationMarker
                    .setText(getUserLocation(String.valueOf(ll.getLatitude()), String.valueOf(ll.getLongitude())));
            LatLong newLocation = new LatLong(latPosition, lngPosition);
            MarkerOptions newmarkerOptions = new MarkerOptions();
            newmarkerOptions.position(newLocation);
            newMarker.setOptions(newmarkerOptions);

            newinfoWindowOptions.content("<h2> New Sale Oppotunity </h2>"
                    + getUserLocation(String.valueOf(ll.getLatitude()), String.valueOf(ll.getLongitude())) + "<br>");
            newInfoWindow.setOptions(newinfoWindowOptions);
            newInfoWindow.open(map, newMarker);
            map.addMarker(newMarker);

        });

    }

    public static String getUserLocation(String lat, String lon) {
        String userlocation = null;
        String readUserFeed = readUserLocationFeed(lat.trim() + "," + lon.trim());
        try {
            JSONObject Strjson = new JSONObject(readUserFeed);
            JSONArray jsonArray = new JSONArray(Strjson.optString("results", "defaultValue"));
            userlocation = jsonArray.getJSONObject(1).getString("formatted_address").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Log.i("User Location ", userlocation);
        return userlocation;
    }

    public static String readUserLocationFeed(String address) {
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(
                "http://maps.google.com/maps/api/geocode/json?latlng=" + address + "&sensor=false");
        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            } else {
                // Log.e(ReverseGeocode.class.toString(), "Failed to download file");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    @FXML
    void SkipFunction() {
        new FadeOutUpTransition(TablePane1).play();
        TablePane2.setOpacity(1.0);
        new FadeInUpTransition(TablePane2).play();
    }

}