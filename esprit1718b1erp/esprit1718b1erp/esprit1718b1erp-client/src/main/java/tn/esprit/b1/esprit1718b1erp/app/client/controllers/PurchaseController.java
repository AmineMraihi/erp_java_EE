package tn.esprit.b1.esprit1718b1erp.app.client.controllers;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import javafx.scene.control.ToggleGroup;
import java.net.URL;
import javafx.scene.layout.Priority;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.util.Collections;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressBar;

import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;
import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Intervention;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.Item_Type;
import tn.esprit.b1.esprit1718b1erp.entities.Needa;
import tn.esprit.b1.esprit1718b1erp.entities.Particular;
import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Purchase;
import tn.esprit.b1.esprit1718b1erp.entities.Purchase_type;
import tn.esprit.b1.esprit1718b1erp.entities.Sale;
import tn.esprit.b1.esprit1718b1erp.entities.Statupurchase;
import tn.esprit.b1.esprit1718b1erp.entities.TypePayementPurchase;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.services.UserServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.ahmed.NeedServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.ahmed.PurchaseServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.ahmed.SaleService;
import tn.esprit.b1.esprit1718b1erp.services.ahmed.SaleServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.amine.CategoryServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.shil.CampaignServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.shil.ProductServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectServiceRemote;

import org.apache.http.HttpEntity;
/////import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.controlsfx.control.Notifications;
import org.json.JSONException;
import org.json.JSONObject;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import com.sun.prism.impl.Disposer.Record;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class PurchaseController implements Initializable {

    //////////////// sale ////////////////////

    @FXML
    private TextField txtcomtumeradresse_sale;
    @FXML
    private Button btnBacksale;
    @FXML
    private ComboBox<Contact> cbcustomer_sale;
    @FXML
    private TextArea txtDescri_sale;
    @FXML
    private ComboBox<Product> cbProjectname_sale;
    @FXML
    private DatePicker txtdeliverydate_sale;
    @FXML
    private TextField txtcustomerphone_sale;
    @FXML
    private ComboBox<String> txtpaymenttype_sale;
    @FXML
    private TableView<Product> tbproduct_sale;
    @FXML
    private TableColumn<String, Product> tbbarcode1;
    @FXML
    private TableColumn<Float, Product> tbUnitpRICE;
    @FXML
    private TextField txtquantityProsale;
    @FXML
    private TextField txtamontsale;
    @FXML
    private Button btnSavesale;
    @FXML
    private TextField txtproquant_sale;
    @FXML
    private AnchorPane paneCrud_sale;
    @FXML
    private TextField txtquantity_ofproduct;
    @FXML
    private AnchorPane paneqyantity_sale;
    @FXML
    private TextField txtquantity_ofproduct12;

    @FXML
    private AnchorPane paneTabelSale;
    @FXML
    private AnchorPane userPane;
    @FXML
    private TableView<Sale> tableSale;
    @FXML
    private TableColumn tpActionsALE;
    @FXML
    private TableColumn<Sale, String> tbdescSale;
    @FXML
    private TableColumn<Sale, Float> tbamountProduct;
    @FXML
    private TableColumn<Sale, String> tbtypepaymentSale;
    @FXML
    private TableColumn<Sale, Date> tbDateSale;
    @FXML
    private TableColumn<Sale, String> ContactSale;
    @FXML
    private TableColumn<Sale, String> tbquantitypoSale;
    @FXML
    private AnchorPane aaaa;
    @FXML
    private AnchorPane calculpane;
    @FXML
    private Label datelabel;
    int sssss = 0;
    Float nc = (float) 0;
    /////////////////////////////// end sale////////////////

    ////////////////// begin welcome pane//////////
    @FXML
    private AnchorPane welcomepane;
    @FXML
    private ImageView welcomeimage;
    /////////////// end welcome pane//////

    @FXML
    private AnchorPane paneCrud;
    @FXML
    private AnchorPane pane_Profit_product11;
    @FXML
    private TextField txtPurchaseCode;
    @FXML
    private TextField txtDisplay1;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnBack;
    @FXML
    private TextArea txtDescription;
    @FXML
    private AnchorPane paneTabel;
    @FXML
    private TableView<Purchase> tablePurchase;
    @FXML
    private TableColumn<Purchase, String> tbdescP;
    @FXML
    private TableColumn<Purchase, Float> tbquantityP;
    @FXML
    private TableColumn<Purchase, Float> tbSommeP;
    @FXML
    private TableColumn<Purchase, Date> tbDateDemandeP;
    @FXML
    private TableColumn<Purchase, Date> tbdateDeliveredP;
    @FXML
    private TableColumn<Purchase, String> tbPurchaseTypeP;
    @FXML
    private TableColumn<Purchase, String> tbStatutP;
    @FXML
    private TableColumn<Purchase, String> tbProjectIdP;
    @FXML
    private TableColumn tpActionP;
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
    private ComboBox<Product> cbProjectname;
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
    private Button enterfacehello;
    @FXML
    private ComboBox<String> cbtypepurchase;
    @FXML
    private ComboBox<String> txtpaymenttype;

    @FXML
    private TableView<Item> tableitem;

    @FXML
    private TableColumn<Item, Integer> tbbarcode;
    @FXML
    private TableColumn<Item, String> tbname;
    @FXML
    private TableColumn<Item, String> tbdescription;
    @FXML
    private TableColumn<Item, Integer> tbquantity;
    @FXML
    private TableColumn tbtotalprice;
    @FXML
    private TableColumn<Item, Float> tbprice;

    @FXML
    private TextField txtID;

    @FXML
    private TabPane TabPane;

    @FXML
    private AnchorPane pane_Profit_product;

    @FXML
    private BarChart<String, Integer> barchart;
    @FXML
    private CategoryAxis xAxis;
    Integer status;
    @FXML
    private TextField txtamontcurr;
    @FXML
    private Label iphone7label;
    @FXML
    private Label iphone8label;
    @FXML
    private Label iphone8Pluslabel;
    @FXML
    private Label iphoneXPluslabel;

    @FXML
    private ToggleGroup grupoAcompanhamento;

    @FXML
    private HBox boxTituloAcompanhamento;
    @FXML
    private HBox boxTituloAcompanhamento1;
    @FXML
    private VBox boxAcompanhamento;
    @FXML
    private VBox boxAcompanhamento1;
    @FXML
    private LineChart<?, ?> lineChart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;

    //////////// User declaration ///////////
    @FXML
    private TableView<User> tbUser;
    @FXML
    private TableColumn<String, User> tbEmployeeName;
    @FXML
    private TableColumn<Integer, User> tbcin;
    @FXML
    private TableColumn<Date, User> tbHiredate;
    @FXML
    private TableColumn<String, User> tbuserEmail;
    @FXML
    private TableColumn<Float, User> tbsalary;

    @FXML
    private TextField txtPosteUser;
    @FXML
    private ComboBox<String> cbemployeecateo;
    
    
    
    //////////////finance part ////////////
    @FXML
    private Label USDAUDlabel; 
    @FXML
    private Label USDEURlabel;
    @FXML
    private Label USDGBPlabel;
    @FXML
    private Label USDCHFlabel;
    @FXML
    private Label USDJPYlabel;
    @FXML
    private Label USDCADlabel;
    @FXML
    private Label USDAEDlabel;
    @FXML
    private Label EURGBPabel;
    float aaa = 0;
    
    
    // essential URL structure is built using constants
    public static final String ACCESS_KEY = "14ad0f632f3277965746f1a472efdf24";
    public static final String BASE_URL = "http://apilayer.net/api/";
    public static final String ENDPOINT = "live";

    // this object is used for executing requests to the (REST) API
    static CloseableHttpClient httpClient = HttpClients.createDefault();

    private final String jndiNameItem = "esprit1718b1erp-ear/esprit1718b1erp-service/ItemService!tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote";
    private final String jndiPurchase = "esprit1718b1erp-ear/esprit1718b1erp-service/PurchaseService!tn.esprit.b1.esprit1718b1erp.services.ahmed.PurchaseServiceRemote";
    private final String jndiNameSupplier = "esprit1718b1erp-ear/esprit1718b1erp-service/ContactService!tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote";
    private final String jndiNameProduct = "esprit1718b1erp-ear/esprit1718b1erp-service/ProductService!tn.esprit.b1.esprit1718b1erp.services.shil.ProductServiceRemote";
    private final String jndiNameSale = "esprit1718b1erp-ear/esprit1718b1erp-service/SaleService!tn.esprit.b1.esprit1718b1erp.services.ahmed.SaleServiceRemote";
    private final String jndiNameCompaign = "esprit1718b1erp-ear/esprit1718b1erp-service/CampaignService!tn.esprit.b1.esprit1718b1erp.services.shil.CampaignServiceRemote";
    private final String jndiNameNeeda = "esprit1718b1erp-ear/esprit1718b1erp-service/NeedService!tn.esprit.b1.esprit1718b1erp.services.ahmed.NeedServiceRemote";
    private final String jndiNameUser = "esprit1718b1erp-ear/esprit1718b1erp-service/UserService!tn.esprit.b1.esprit1718b1erp.services.UserServiceRemote";

    private InitialContext ctx = null;

    private ObservableList<Item> listData;
    private ObservableList<Purchase> listDataP;
    private ObservableList<Sale> listDataSale;
    private ObservableList<Product> listDataProduct;
    private ObservableList<User> listUser;

    UserServiceRemote userService;
    ItemServiceRemote itemService;
    PurchaseServiceRemote purchaseService;
    ContactServiceRemote contactService;
    ProductServiceRemote producttService;
    SaleServiceRemote saleService;
    CampaignServiceRemote compaignservice;
    NeedServiceRemote needService;
    Set<Item> merzougList=new HashSet<Item>();

    List<Integer> sub = new ArrayList<>();
    List<Integer> sss = new ArrayList<>();
    ObservableList<String> xvaluefor_axis;

    int quantity = 0;
    private int decimalClick = 0;
    private String generalOperationObject;
    private double firstDouble;
    /**
     * Initializes the controller class.
     */
   
    Double  usdeur;Double  usdaud ;Double  usdGBP ;Double  USDCHF; Double usdjpy;
    Double usdcad;    Double  usdaed;Double eurgbp;
    void Currency_conversion(){
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);
        CloseableHttpResponse response;
        try {
            response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));
            
           usdeur = exchangeRates.getJSONObject("quotes").getDouble("USDEUR");
          USDEURlabel.setText(Double.toString(usdeur));
          
           usdaud = exchangeRates.getJSONObject("quotes").getDouble("USDAUD");
          USDAUDlabel.setText(Double.toString(usdaud));
         
            usdGBP = exchangeRates.getJSONObject("quotes").getDouble("USDGBP");
          USDGBPlabel.setText(Double.toString(usdGBP));
          
            USDCHF = exchangeRates.getJSONObject("quotes").getDouble("USDCHF");
          USDCHFlabel.setText(Double.toString(USDCHF));
          Double  usdusd = exchangeRates.getJSONObject("quotes").getDouble("USDUSD");
        
          usdjpy = usdusd / 0.00936183;
          DecimalFormat usjp = new DecimalFormat("000.00000"); 
          USDJPYlabel.setText((usjp.format(usdjpy)));
         
          DecimalFormat usca = new DecimalFormat("0.00000"); 
           usdcad = usdusd / 0.787483;
          USDCADlabel.setText(usca.format(usdcad));

          
           usdaed = exchangeRates.getJSONObject("quotes").getDouble("USDAED");
          USDAEDlabel.setText(Double.toString(usdaed));
          
          DecimalFormat eubg = new DecimalFormat("0.00000");
           eurgbp = usdGBP /usdeur; 
          EURGBPabel.setText(eubg.format(eurgbp));
          response.close();
          

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        
        cbemployeecateo.getItems().addAll("ENGINEER","chef department","DIRECTOR");
        cbemployeecateo.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                txtPosteUser.setText("");
               
                listUser = FXCollections.observableArrayList();
                listUser.clear();
                for (User u : findAllUser()) {
                    if (u.getGrade().toString().equals(newValue.toUpperCase())) {
                        listUser.add(u);
                        Double Somme ;
                        System.out.println("hello");
                        String employeeGrade = cbemployeecateo.getValue();
                        Somme =  afficherSommepaymentparPoste(employeeGrade);
                        System.out.println(Somme+"somme");
                        
                        txtPosteUser.setText(Double.toString(Somme));
                   
                }
                    
                }
                tbUser.setItems(listUser);
                if (listUser.isEmpty()){
                buildNotification("Sorry !", "we don't have any employee in this post",
                        Pos.CENTER);
                }
            }
            
        });
        
   
        new FadeInUpTransition(welcomepane).play();
        /////// TabPane.toBack();
        TabPane.setOpacity(0);

        System.out.println("ahmed");

        Date timeStampDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
        String formattedDate = dateFormat.format(timeStampDate);
        System.out.println(formattedDate + "   A3TINI date svp");
        userPane.toFront();
        new FadeInUpTransition(userPane).play();
        userPane.setOpacity(1);

        pane_Profit_product11.toFront();
        new FadeInUpTransition(pane_Profit_product11).play();
        pane_Profit_product11.setOpacity(1);

        boxAcompanhamento1.getChildren().clear();

        fillChart();
        Currency_conversion();

    }
    
   

    private ObservableList<String> monthNames = FXCollections.observableArrayList();

    private void fillChart() {

        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
        monthNames.addAll(Arrays.asList(months));
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        XYChart.Series series4 = new XYChart.Series();
        List<Double> listeiphone7 = new ArrayList<>();
        List<Double> listeiphone8 = new ArrayList<>();
        List<Double> listeiphone8plus = new ArrayList<>();
        List<Double> listeiphoneX = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            series1.getData().add(new XYChart.Data(monthNames.get(i), afficherSommeSalesiPhone7(i+1)));
            series2.getData().add(new XYChart.Data(monthNames.get(i), afficherSommeSalesiPhone8(i+1)));
            series3.getData().add(new XYChart.Data(monthNames.get(i), afficherSommeSalesiPhone8Plus(i+1)));
            series4.getData().add(new XYChart.Data(monthNames.get(i), afficherSommeSalesiPhoneX(i+1)));

            listeiphone7.add(afficherSommeSalesiPhone7(i+1));
            Double finalsommeiphone7 = (double) 0;
            for (Double increm : listeiphone7) {
                finalsommeiphone7 += increm;
            }

            listeiphone8.add(afficherSommeSalesiPhone8(i+1));
            Double finalsommeiphone8 = (double) 0;
            for (Double increm2 : listeiphone8) {
                finalsommeiphone8 += increm2;
            }

            listeiphone8plus.add(afficherSommeSalesiPhone8Plus(i+1));
            Double finalsommeiphone8plus = (double) 0;
            for (Double increm3 : listeiphone8plus) {
                finalsommeiphone8plus += increm3;
            }

            listeiphoneX.add(afficherSommeSalesiPhoneX(i+1));
            Double finalsommeiphoneX = (double) 0;
            for (Double increm4 : listeiphoneX) {
                finalsommeiphoneX += increm4;
            }
            iphoneXPluslabel.setText(Double.toString(finalsommeiphoneX) + " USD");

            iphone8Pluslabel.setText(Double.toString(finalsommeiphone8) + " USD");
            iphone8label.setText(Double.toString(finalsommeiphone8) + " USD");
            iphone7label.setText(Double.toString(finalsommeiphone7) + " USD");

        }
        lineChart.getData().addAll(series1, series2, series3, series4);

    }

    //////// filtrer le hashmap en ordre dÃ©croissant : pour filtrer les nom des
    //////// produits
    public static HashMap<String, Integer> triAvecValeur(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> map_apres = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list)
            map_apres.put(entry.getKey(), entry.getValue());
        return map_apres;
    }

    private void boxItensAcompanhamento(VBox vbox, Node... no) {
        HBox box = new HBox();
        box.getStyleClass().add("item-acompanhamento");

        box.getChildren().addAll(no);
        vbox.getChildren().addAll(box);
    }

    class ColoredProgressBar extends ProgressBar {
        ColoredProgressBar(String styleClass, double progress) {
            super(progress);
            getStyleClass().add(styleClass);
        }
    }

    //////// ajouter les noms des labels pour la description de chart
    private void tituloExcursao() {
        boxTituloAcompanhamento1.getChildren().clear();

        Label curso = new Label("    Product Name");
        curso.getStyleClass().add("excursao-curso");

        Label participantes = new Label("Product Result(USD)");
        participantes.getStyleClass().add("excursao-participantes");

        Label data = new Label("DATA VISITA");
        data.getStyleClass().add("excursao-data");

        boxTituloAcompanhamento1.getChildren().addAll(curso, participantes);
    }

    @FXML
    private void entrerinterface(ActionEvent event) throws Exception {

        enterfacehello.setVisible(false);

        welcomepane.toBack();
        welcomepane.setOpacity(0);
        TabPane.toFront();
        new FadeInUpTransition(TabPane).play();
        paneTabel.setOpacity(1);
        paneTabel.toFront();
        paneTabelSale.setOpacity(1);
        paneTabelSale.toFront();
        afficherPurchase();
        afficherSale();
        selectWithServiceSale();
        selectWithServicePurchase();
        afficherUser();
        selectWithServiceUser();
        paneqyantity_sale.setOpacity(0);
        paneqyantity_sale.toBack();

        status = 0;
        cbitems.setOnAction(e -> {
            try {
                showPubDetailItem();
                selectWithService();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        });
        cbsupplier.getItems().addAll(filterSupplierList());
        cbsupplier.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {

                showPubDetails(newValue);
            } catch (Exception ex) {

            }
        });
        cbProjectname.getItems().addAll(findAlProducts());
       
        cbtypepurchase.getItems().addAll("Purchases of raw materials", "Manufactured purchases", "Investment purchases",
                "Trading purchases", "Overhead purchases", "Service purchases");
        txtpaymenttype.getItems().addAll("Cash", "Check", "Credit Card");

        cbitems.getItems().addAll(findAlItemsfind());

        //////////// sale interface ///////////////
        txtpaymenttype_sale.getItems().addAll("Cash", "Check", "Credit Card");
        cbProjectname_sale.setOnAction(e -> {
            try {
                showPubDetailProduct();
                selectWithServicSale();
                txtquantity_ofproduct12.clear();

                paneqyantity_sale.toFront();
                new FadeInUpTransition(paneqyantity_sale).play();
                paneqyantity_sale.setOpacity(1);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        cbcustomer_sale.getItems().addAll(filterCostumerList());
        cbcustomer_sale.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {

                showPubDetailscontact_sale(newValue);
            } catch (Exception ex) {

            }
        });
        cbProjectname_sale.getItems().addAll(findAlProducts());
        List<Integer> fg = new ArrayList<>();

        ////////////// profitable product /////////////
        Map<String, Number> hhh = new HashMap<String, Number>(sommetot_purchase_parproduit());
        Map<String, Number> aaaa = new HashMap<String, Number>(Need_somme_parproduit());
        Map<String, Number> bbbbb = new HashMap<String, Number>(sommetot_campaign_par_profduit());
        HashMap<String, Integer> thisistheone = new HashMap<String, Integer>();
        ObservableList<String> productsname_purchase = FXCollections.observableArrayList();
        ObservableList<String> productsname_sale = FXCollections.observableArrayList();
        ObservableList<String> ordredProdNames;

        Set setsALE = aaaa.entrySet();
        Set set = hhh.entrySet();
        Iterator iterator = set.iterator();
        Iterator iteratorSALE = setsALE.iterator();

        Map.Entry mentrysale;
        while (iteratorSALE.hasNext()) {

            mentrysale = (Map.Entry) iteratorSALE.next();

            System.out.print("key s is: " + mentrysale.getKey() + " & Value S is: " + mentrysale.getValue() + "\n");

            productsname_sale.add((String) mentrysale.getKey());
        }

        double kk;
        Integer ab = null;
        xvaluefor_axis = FXCollections.observableArrayList();
        for (String key : hhh.keySet()) {
            if (aaaa.containsKey(key)) {
                System.out.println(aaaa.get(key) + "sale prod");
                System.out.println(hhh.get(key) + "purchase prod");
                System.out.println(key + "mykey is");
                double salett = aaaa.get(key).doubleValue();
                double purchasett = hhh.get(key).doubleValue();
                kk = salett - purchasett;
                ab = (int) kk;
                fg.add((int) kk);
                sss.add(ab);
                thisistheone.put(key, ab);

                Collections.sort(sss);///// filtrer la liste
                Collections.reverse(sss); /// pour l'ordre dÃ©croissant

                xvaluefor_axis.add(key);

            }

        }
        System.out.println(thisistheone);

        System.out.println("after le tri: " + triAvecValeur(thisistheone));
        Set finalset = triAvecValeur(thisistheone).entrySet();
        Iterator iter = finalset.iterator();
        ordredProdNames = FXCollections.observableArrayList();
        while (iter.hasNext()) {

            Map.Entry me = (Map.Entry) iter.next();

            System.out.print("key s is: " + me.getKey() + " & Value S is: " + me.getValue() + "\n");

            ordredProdNames.add((String) me.getKey());
        }
        sub = sss.subList(0, 4); /// prendre les 5 Ã©lÃ©mÃ©nt de la liste
        System.out.println(xvaluefor_axis + "the final in the chart");
        System.out.println(sss + "the final in the chart");

        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        for (int i = 0; i < sub.size(); i++) {
            series.getData().add(new XYChart.Data<>(ordredProdNames.get(i), sub.get(i)));
            /////// xAxis.setCategories(productsname_sale);
            tituloExcursao();

            Label curso = new Label("    " + ordredProdNames.get(i));
            curso.getStyleClass().add("excursao-curso");
            List<String> newList = new ArrayList<String>(sub.size());
            for (Integer myInt : sub) {
                newList.add(String.valueOf(myInt));
            }

            Label azed = new Label(newList.get(i));
            azed.getStyleClass().add("excursao-curso");

            boxItensAcompanhamento(boxAcompanhamento1, curso, azed);

        }
        barchart.getData().add(series);

    }

    ///////// add purchase Button ////////
    @FXML
    private void aksiSave(ActionEvent event) throws Exception {
        String typepurchase = cbtypepurchase.getValue();
        String tpaymenttype = txtpaymenttype.getValue();

        Contact supplier = cbsupplier.getValue();

        Product Projectname = cbProjectname.getValue();
        String Description = txtDescription.getText();

        Date daterequested = convert(txtdaterequested.getEditor().getText());
        Date deliverydate = convert(txtdaterequested.getEditor().getText());
        Set<Item> bb = new HashSet(listData);
      
   
/////xfhd
        Purchase purchase = new Purchase(supplier, bb, daterequested, deliverydate, quantity, typepurchase, aaa,
                Description, tpaymenttype, Projectname);

        if ((paid.isSelected()) && (unpaid.isSelected())) {
            Config2.dialog(Alert.AlertType.WARNING, "Choose only one parameter");
            paid.requestFocus();
        } else if (paid.isSelected()) {
            purchase.setStatupurchase(Statupurchase.Paid);
        } else
            purchase.setStatupurchase(Statupurchase.Unpaid);
        if (!(txtID.getText()).equals("")) {
            purchase.setId_purchase(Integer.parseInt(txtID.getText()));
            purchase.getItems().addAll(merzougList);
        }
        addPurchase(purchase);
        paneCrud.setOpacity(0);
        selectWithServicePurchase();
        cleartxtPurchase();
    }

    ///////// le boutton de retour de crud vers le tableview //////////
    @FXML
    private void aksiBack(ActionEvent event) {
        cleartxtPurchase();
        paneCrud.setOpacity(0);

        selectWithServicePurchase();

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

    ///////// get the data from the table and set them in the crud panel it's
    ///////// for the update methode///////
    @FXML
    private void aksiKlikTablePurchase(MouseEvent event) {
        if (status == 1) {
            try {
                Purchase pur = tablePurchase.getSelectionModel().getSelectedItem();
                cbsupplier.setValue(pur.getContact());
                txtsuppphone.setText(Integer.toString(pur.getContact().getPhone()));
                txtPurchaseCode.setText((pur.getContact().getStreet()));
                cbtypepurchase.setValue(pur.getPurchase_type());
                txtDescription.setText(pur.getDsecription());
                cbProjectname.setValue(pur.getProduct());
                merzougList.addAll(pur.getItems());
                String dated = pur.getDateDemande().toString();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(dated, formatter);
                txtdaterequested.setValue(date);

                String datedeee = pur.getDateRecu().toString();
                DateTimeFormatter formatterr = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dates = LocalDate.parse(datedeee, formatterr);
                txtdeliverydate.setValue(dates);

                switch (pur.getStatupurchase().toString()) {

                case "Paid":
                    paid.setSelected(true);
                    break;
                case "Unpaid":
                    unpaid.setSelected(true);
                    break;
                }

                txtpaymenttype.setValue(pur.getTypePayementPurchase());

            } catch (Exception e) {

            }
        }
    }

    /////////////// just to show the add purchase interface and to clear all the
    /////////////// data /////////

    @FXML
    private void aksiNew(ActionEvent event) {
        ///// cleartxtPurchase();
        welcomepane.setOpacity(0);

        paneTabel.setOpacity(0);
        TabPane.toFront();
        TabPane.setOpacity(1);
        new FadeInUpTransition(paneCrud).play();

    }

    /////////// afficher les detaiile de contact lors de click sur un combobox
    /////////// ///////////
    void showPubDetails(Contact I) throws ParseException {
        txtsuppphone.setText(String.valueOf(I.getPhone()));
        txtPurchaseCode.setText((I.getStreet()));
    }

    ////////////// affichage des item sÃ©lctionner de combo avant l'ajout de
    ////////////// purchase////////
    void showPubDetailItem() throws ParseException {
        //////// listData = FXCollections.observableArrayList();
        Config2.setModelColumn(tbbarcode, "barcode");
        Config2.setModelColumn(tbname, "name");
        Config2.setModelColumn(tbdescription, "description");
        Config2.setModelColumn(tbquantity, "quantity");
        Config2.setModelColumn(tbprice, "byingPrice");
        Config2.setModelColumn(tbtotalprice, "totalPrice");

    }

    @FXML
    private void ONiTEM_action(ActionEvent event) {

        /*
         * System.out.println("hi ahmed");
         * tableitem.getSelectionModel().selectedItemProperty().addListener((
         * observable, oldValue, newValue) -> { try {
         * showPubDetailItem(newValue); selectWithService(); } catch (Exception
         * ex) {
         * 
         * } }); try { showPubDetailItem(); selectWithService(); } catch
         * (ParseException e) { // TODO Auto-generated catch block
         * e.printStackTrace(); }
         * 
         * ///// selectData();
         * System.out.println(cbitems.getValue().getBarcode() +"hi "+
         * cbitems.getValue().getDescription());
         */
    }
   
    ///////////// ajouter les items sÃ©lÃ©ctionner dans une liste ///////////
    ///////////// calculer la quantiter global des items /////////////////
    ///////// calculer la somme gloabl de tous les item selon la devise de
    ///////////// chaque item sÃ©lectionner ////
    ////// convertir la la somme de chaque item selon la devise de l'item en USD
    ///////////// et enfin calculer la somme des Items global en USD ////
    private void selectData() throws ParseException {
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);
        List<Float> boutiques = new ArrayList<>();
        int quant = 0;
        try {
            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();

            // the following line converts the JSON Response to an equivalent
            // Java Object
            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));

            System.out.println("Live Currency Exchange Rates");

            if (listData == null) {
                listData = FXCollections.observableArrayList(findItem(cbitems.getValue()));
                System.out.println("***********************");
                System.out.println(listData);
            } else {
                ////// listData.clear();
                listData.addAll(findItem(cbitems.getValue()));
                System.out.println("deffeefefe");
                float totalprice = 0;
                int cc = 0 ;
                for (Item i : listData) {
                    System.out.println(i.getTotalPrice());
                    float price = i.getTotalPrice();
                    
                    quant= i.getQuantity();
                    cc += quant;
                    totalprice += price;
                    System.out.println("this is the result" + price);
                    Double v;
                    Float cv;
                    float qs = 0;
                    switch (i.getCurrency()) {
                    case "EUR":

                        v = exchangeRates.getJSONObject("quotes").getDouble("USDEUR");
                        cv = (float) (price * v);
                        response.close();

                        qs += cv;
                        boutiques.add(qs);

                        break;
                    case "GBP":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDGBP");
                        cv = (float) (price * v);
                        response.close();

                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "USD":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDUSD");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "CHF":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDCHF");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "AED":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDAED");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "AFN":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDAFN");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "ALL":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDALL");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "AMD":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDAMD");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "ANG":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDANG");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;
                    case "AOA":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDAOA");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "AUD":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDAUD");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "AWG":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDAWG");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "AZN":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDAZN");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    }
                    System.out.println(boutiques);

                    for (float dd : boutiques) {

                        aaa += dd;
                    }
                    System.out.println(aaa + "this is the converted value");
                    txtamontcurr.setText(Float.toString(aaa));
                    txtamont.setText(Double.toString(totalprice));
                    txtQuantity.setText(Integer.toString(cc));
                    quantity = cc ;
                    System.out.println(totalprice);
                }
                tableitem.setItems(listData);
                System.out.println(listData);

            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    ///////// fonction just pour charger les Ã©lÃ©ments des Item dans le tableview
    ///////// "not really"///////////
    private void selectWithService() {
        Service<Integer> service = new Service<Integer>() {
            @Override
            protected Task<Integer> createTask() {
                try {
                    selectData();
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
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
            ////// new FadeInUpTransition(paneTabel).play();
        });
    }

    /////////// affichage de purchase ///////////
    void afficherPurchase() {

        Config2.setModelColumn(tbdescP, "Dsecription");
        Config2.setModelColumn(tbquantityP, "Quantite");
        Config2.setModelColumn(tbSommeP, "Somme");
        Config2.setModelColumn(tbDateDemandeP, "dateDemande");
        Config2.setModelColumn(tbdateDeliveredP, "dateRecu");
        Config2.setModelColumn(tbPurchaseTypeP, "purchase_type");
        //Config2.setModelColumn(tbStatutP, "statupurchase");

        tbStatutP.setCellFactory(column -> {    return new TableCell<Purchase, String>() {

            
            @Override
             @SuppressWarnings("unchecked") 
             protected void updateItem(String item, boolean empty) {
                 
                 super.updateItem(item, empty);
                 if (!empty) {
                     TableView<Purchase> tv = getTableView();

                     if ((tv != null))  {
                         if (tv.getItems().get(getTableRow().getIndex()).getStatupurchase().toString().equals("Unpaid"))
                         {
                           

                             setStyle("-fx-background-color: red");
                             } else if(tv.getItems().get(getTableRow().getIndex()).getStatupurchase().toString().equals("Paid")){
                            // setTextFill(Color.GREEN);
                                 setStyle("-fx-background-color: green");
                         } 
                           //  currentRow.setTextFill(Color.PINK);

                         }
                     setText(tv.getItems().get(getTableRow().getIndex()).getStatupurchase().toString());

                     } 
                 } 
             
         
             };
         });

        tbProjectIdP.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Purchase, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Purchase, String> param) {
                        return new SimpleStringProperty(param.getValue().getProduct().getNomProduit());
                    }

                });
        tpActionP.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCell2();
            }

        });

    }

    ///////// fonction just pour charger les Ã©lÃ©ments des Purchase dans le
    ///////// tableview "not really"///////////
    private void selectWithServicePurchase() {
        Service<Integer> service = new Service<Integer>() {
            @Override
            protected Task<Integer> createTask() {
                selectDataPurchase();
                paneTabel.toFront();
                paneTabel.setOpacity(1);
                return new Task<Integer>() {
                    @Override
                    protected Integer call() throws Exception {
                        Integer max = purchaseService.findAll().size();
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

    //////////// ajouter tous les purchase dans une liste ////////////////
    private void selectDataPurchase() {
        if (listDataP == null) {
            listDataP = FXCollections.observableArrayList(findALLPurchase());
        } else {
            listDataP.clear();
            listDataP.addAll(findALLPurchase());
        }
        tablePurchase.setItems(listDataP);
    }

    /////////// ajouter l'action delete et update pour le table purchase
    /////////// //////////
    //////// Delete and update action ///////////////

    private class ButtonCell2 extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("Delete");
        final Hyperlink cellButtonEdit = new Hyperlink("Edit");
        final HBox hb = new HBox(cellButtonDelete, cellButtonEdit);

        public ButtonCell2() {
            hb.setSpacing(4);
            cellButtonDelete.setOnAction((ActionEvent t) -> {
                status = 1;
                int row = getTableRow().getIndex();
                tablePurchase.getSelectionModel().select(row);
                aksiKlikTablePurchase(null);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure to Delete this purchase ?");
                alert.initStyle(StageStyle.UTILITY);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Purchase i = tablePurchase.getSelectionModel().getSelectedItem();
                    deletPurchase(i);
                    cleartxtPurchase();
                    selectDataPurchase();
                } else {
                    cleartxtPurchase();
                    selectDataPurchase();
                }
                status = 0;
            });

            cellButtonEdit.setOnAction(t -> {
                status = 1;
                int row = getTableRow().getIndex();
                tablePurchase.getSelectionModel().select(row);
                //// clear();
                aksiKlikTablePurchase(null);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure to update this purchase ?");
                alert.initStyle(StageStyle.UTILITY);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Purchase P = tablePurchase.getSelectionModel().getSelectedItem();
                    txtID.setText(Integer.toString(P.getId_purchase()));
                    paneTabel.setOpacity(0);
                    paneTabel.toBack();
                    paneCrud.toFront();
                    new FadeInUpTransition(paneCrud).play();
                    status = 0;
                } else {
                    selectDataPurchase();
                    ////// httfy///////////
                }

            });

            // Action when the button is pressed

        }

        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (!empty) {
                setGraphic(hb);
            } else {
                setGraphic(null);
            }
        }
    }
    
    private void clearSale() {
        
        cbcustomer_sale.getItems().clear();
        cbcustomer_sale.getItems().addAll(filterCostumerList());
        txtcustomerphone_sale.clear();
        txtcomtumeradresse_sale.clear();
        txtDescri_sale.clear();
        txtdeliverydate_sale.setValue(null);
        txtpaymenttype_sale.getItems().clear();
        txtpaymenttype_sale.getItems().addAll("Cash", "Check", "Credit Card");
        cbProjectname_sale.getItems().clear();
        cbProjectname_sale.getItems().addAll(findAlProducts());
        txtamontsale.clear();
        txtquantityProsale.clear();
        tbproduct_sale.getItems().clear();

    }
    //////////// clear the add interface for a purchase //////////////////
    private void cleartxtPurchase() {
        txtsuppphone.clear();
        txtPurchaseCode.clear();
        txtDescription.clear();
        paid.setSelected(false);
        unpaid.setSelected(false);
        cbsupplier.getItems().clear();
        cbsupplier.getItems().addAll(filterSupplierList());
        cbtypepurchase.setValue("please choose the type");
        cbProjectname.getItems().clear();
        cbProjectname.getItems().addAll(findAlProducts());
        txtpaymenttype.setValue("please choose the type");

        cbitems.getItems().clear();
        cbitems.getItems().addAll(findAlItemsfind());

        txtdaterequested.setValue(null);
        txtdeliverydate.setValue(null);
        txtQuantity.clear();
        txtamont.clear();
        txtamontcurr.clear();
        tableitem.getItems().clear();
    }
    ///////////////////// begin sale functions ////////////////////////////

    ///////// fonction just pour charger les Ã©lÃ©ments des produits dans le
    ///////// tableview
    ///////// "not really"///////////
    private void selectWithServicSale() {
        Service<Integer> service = new Service<Integer>() {
            @Override
            protected Task<Integer> createTask() {
                try {
                    selectDataSale();
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
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
            ////// new FadeInUpTransition(paneTabel).play();
        });
    }

    @FXML
    private void aksiBacksale(ActionEvent event) {
        paneCrud_sale.setOpacity(0);
        
        paneTabelSale.toFront();
        new FadeInUpTransition(paneTabelSale).play();
        paneTabelSale.setOpacity(1);
        clearSale();
    
    
    }

    @FXML
    private void aksiSave_sale(ActionEvent event) throws ParseException {
        Contact Costumer = cbcustomer_sale.getValue();
        String description = txtDescri_sale.getText();
        Date daterequested = convert(txtdeliverydate_sale.getEditor().getText());
        String tpaymenttype = txtpaymenttype_sale.getValue();
        Set<Product> bb = new HashSet(listDataProduct);
       //// if (!(cbcustomer_sale.getValue().equals(""))&&!(txtDescri_sale.getText().equals(""))&&!(txtdeliverydate_sale.getEditor().getText().equals(""))&&!(txtpaymenttype_sale.getValue().equals(""))&&!(cbProjectname_sale.getValue().equals("")))
        //////{
        Sale sa = new Sale(tpaymenttype, description, sssss, nc, daterequested, Costumer, bb);
        addsale(sa);
       

     paneCrud_sale.setOpacity(0);
        
        paneTabelSale.toFront();
        new FadeInUpTransition(paneTabelSale).play();
        paneTabelSale.setOpacity(1);
        selectWithServiceSale();
        clearSale();
      
        }
       //////// else {
           /////////// System.out.println("sorry");
        /////////}
    

    float prixunitt;

    private void selectDataSale() throws ParseException {
        int a = 0;
        float nn = 0;
        if (listDataProduct == null) {
            listDataProduct = FXCollections.observableArrayList(findProduit(cbProjectname_sale.getValue()));

        } else {

            listDataProduct.addAll(findProduit(cbProjectname_sale.getValue()));
            ////// System.out.println("deffeefefe");
            float aa;

            ///// System.out.println(somme+"hell yes");
            ////// txtquantityProsale.setText(Integer.toString(somme));

        }
        tbproduct_sale.setItems(listDataProduct);

        ////// sommetot = prixunitt * note;

        System.out.println(listDataProduct);
        
 
    }

    
    
    ////////////// click on the product quantity //////////   
    Float need = null;

    @FXML
    private void onproduct_quantityclick(ActionEvent event) throws Exception {
        paneqyantity_sale.toBack();
        paneqyantity_sale.setOpacity(0);
        int note = 0;
        String nom  = null;
        Date daterequested1 ;
        int somme = 0;
        List<Float> fff = new ArrayList<>();
        ArrayList<Float> finalsomme = new ArrayList<>();
       ArrayList<Integer> boutiques = new ArrayList<>();

        note = Integer.parseInt(txtquantity_ofproduct12.getText());
        boutiques.add(note);

        for (int i : boutiques) {

            sssss += i;
        }

        for (Product pr : listDataProduct) {

            int ab;
            float price = pr.getPrixUnitaire();
          
            ab = pr.getQte();
            System.out.println(ab + "qte");

            int qq = ab - note;

            pr.setQte(qq);
            updateProdcut(pr);
            System.out.println(qq + "what should be the qtee");
            nom = pr.getNomProduit();
           
            
            need = price * note;
            System.out.println(pr.getNomProduit() + "nomprod");
            System.out.println(need + "need");
       
        }
        daterequested1 = convert(txtdeliverydate_sale.getEditor().getText());
        Needa nn = new Needa(nom, need,daterequested1);
        List<Float> sommetotaldessales = new ArrayList<>();
        addneed(nn);
        sommetotaldessales.add(need);
      
        for (Float total : sommetotaldessales)
        {
           nc+=total;  
        }
        txtamontsale.setText(Float.toString(nc));
        txtquantityProsale.setText(Integer.toString(sssss));
        /*ArrayList<Integer> priceList = new ArrayList(Arrays.asList(fff));
        ArrayList<Integer> priceList2 = new ArrayList(Arrays.asList(boutiques));

        int counter = 0;
        while (counter < boutiques.size()) {
            finalsomme.add(boutiques.get(counter) * fff.get(counter));
            counter++;
        }
        System.out.println(finalsomme + "fuck yeah man");

        for (Float finaaalsomme : finalsomme) {
            nc += finaaalsomme;
        }
        System.out.println(nc + "fuck yeah man");
        
        /////// System.out.println(zzzz+"wwwwwiwwwww");
        System.out.println(boutiques + "ppppppppppp");
        System.out.println(fff + "ppppppppppp");
        System.out.println(priceList.toString() + "aaaaaaaaaaaaa");
        System.out.println(priceList3.toString() + "priceList3");
*/
        /////////// System.out.println(Integer.parseInt(txtquantity_ofproduct12.getText()));
    }

    
    ////////////// affichage des produit sÃ©lctionner de combo avant l'ajout de
    ////////////// sale////////
    void showPubDetailProduct() throws ParseException {
        //////// listData = FXCollections.observableArrayList();
        Config2.setModelColumn(tbbarcode1, "nomProduit");
        Config2.setModelColumn(tbUnitpRICE, "prixUnitaire");

    }

    void showPubDetailscontact_sale(Contact I) throws ParseException {
        txtcustomerphone_sale.setText(String.valueOf(I.getPhone()));
        txtcomtumeradresse_sale.setText((I.getStreet()));
    }

    @FXML
    private void aksiKlikTableSale(MouseEvent event) {
        if (status == 1) {
            try {

            } catch (Exception e) {

            }
        }
    }

    private void selectWithServiceSale() {
        Service<Integer> service = new Service<Integer>() {
            @Override
            protected Task<Integer> createTask() {
                selectDataaffichersale();
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
            ////// new FadeInUpTransition(paneTabel).play();
        });
    }

    private void selectDataaffichersale() {
        if (listDataSale == null) {
            listDataSale = FXCollections.observableArrayList(findALLSale());
        } else {
            listDataSale.clear();
            listDataSale.addAll(findALLSale());
        }
        tableSale.setItems(listDataSale);
    }

    /////////// affichage de sALE ///////////
    void afficherSale() {

        ////// Config2.setModelColumn(tpActionsALE, "Dsecription");
        Config2.setModelColumn(tbdescSale, "Description");
        Config2.setModelColumn(tbamountProduct, "Somme_products");
        Config2.setModelColumn(tbtypepaymentSale, "TypePayementsale");
        Config2.setModelColumn(tbDateSale, "dateSale");
        Config2.setModelColumn(tbquantitypoSale, "quantity_products");

        ContactSale.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Sale, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Sale, String> param) {
                        return new SimpleStringProperty(param.getValue().getContact().getName());
                    }

                });
        tpActionsALE.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCellSale();
            }

        });

    }

    private class ButtonCellSale extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("Delete");
        final Hyperlink cellButtonEdit = new Hyperlink("Edit");
        final HBox hb = new HBox(cellButtonDelete, cellButtonEdit);

        public ButtonCellSale() {
            hb.setSpacing(4);
            cellButtonDelete.setOnAction((ActionEvent t) -> {
                status = 1;
                int row = getTableRow().getIndex();
                tableSale.getSelectionModel().select(row);
                aksiKlikTableSale(null);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure to Delete this Sale ?");
                alert.initStyle(StageStyle.UTILITY);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Sale i = tableSale.getSelectionModel().getSelectedItem();
                    deletSale(i);
                    /// cleartxtPurchase();
                    selectDataaffichersale();
                } else {
                    /// cleartxtPurchase();
                    selectDataaffichersale();
                }
                status = 0;
            });

            // Action when the button is pressed
        }

        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (!empty) {
                setGraphic(hb);
            } else {
                setGraphic(null);
            }
        }
    }

    @FXML
    private void aksiNewsale(ActionEvent event) {
        ///// cleartxtPurchase();
        welcomepane.setOpacity(0);
        paneTabelSale.setOpacity(0);
        TabPane.toFront();
        TabPane.setOpacity(1);
        new FadeInUpTransition(paneCrud_sale).play();

    }

    /////// pour le filtrage ////////////
    /**
     * txtPosteUser.textProperty().addListener(new ChangeListener() {
     * 
     * @Override public void changed(ObservableValue observable, Object
     *           oldValue, Object newValue) {
     * 
     *           filerUserParpost((String) oldValue, (String) newValue); } });
     * 
     */
    //////////// start working on the user //////////////

   
    private void selectDataUser() {
        if (listUser == null) {
            listUser = FXCollections.observableArrayList(findAllUser());
        } else {
            listUser.clear();
            listUser.addAll(findAllUser());
        }
        tbUser.setItems(listUser);
    }

    void afficherUser() {

        ////// Config2.setModelColumn(tpActionsALE, "Dsecription");
        Config2.setModelColumn(tbEmployeeName, "name");
        Config2.setModelColumn(tbcin, "CIN");
        Config2.setModelColumn(tbHiredate, "HiringDate");
        Config2.setModelColumn(tbuserEmail, "email");
        Config2.setModelColumn(tbsalary, "Salary");
    }

    private void selectWithServiceUser() {
        Service<Integer> service = new Service<Integer>() {
            @Override
            protected Task<Integer> createTask() {
                selectDataUser();
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
            ////// new FadeInUpTransition(paneTabel).play();
        });
    }

    void filerUserParpost(String oldValue, String newValue) {
        ObservableList<User> filteredList = FXCollections.observableArrayList();
        if (txtPosteUser.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            listUser.clear();
            listUser.addAll(findAllUser());
            tbUser.setItems(listUser);
        } else {
            newValue = newValue.toUpperCase();
            for (User u : tbUser.getItems()) {
                String filterName = u.getGrade();

                if (filterName.toUpperCase().contains(newValue)) {
                    filteredList.add(u);

                }

            }
            tbUser.setItems(filteredList);

        }
      

    }

    ////////////////// end sale functions /////////////////////////
    
    
    ///////////////calcul function //////////////////

    @FXML
    private void handlerGeneralAction(ActionEvent event) {
        generalOperationObject = ((Button) event.getSource()).getText();
        switch (generalOperationObject) {
            case "AC":
                txtDisplay1.setText("8");
                decimalClick = 0;
                break;
            case "+/-":
                double plusMinus = Double.parseDouble(String.valueOf(txtDisplay1.getText()));
                plusMinus = plusMinus * (-1);
                txtDisplay1.setText(String.valueOf(plusMinus));
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                String currentText = txtDisplay1.getText();
                firstDouble = Double.parseDouble(currentText);
                txtDisplay1.setText("");
                decimalClick = 0;
                break;
            default:
        }
    }

    @FXML
    private void handlerDigitAction(ActionEvent event) {
        String digitObject = ((Button) event.getSource()).getText();
        String oldText = txtDisplay1.getText();
        String newText = oldText + digitObject;
        txtDisplay1.setText(newText);
    }

    @FXML
    private void handlerDecimalAction(ActionEvent event) {
        if (decimalClick == 0) {
            String decimalObject = ((Button) event.getSource()).getText();
            String oldText = txtDisplay1.getText();
            System.out.println(oldText);
            String newText = oldText + decimalObject;
            System.out.println(newText);
            txtDisplay1.setText(newText);
            decimalClick = 1;
        }
    }

    @FXML
    private void handlerEqualAction(ActionEvent event) {
        double secondDouble;
        double result=0;
        String secondText = txtDisplay1.getText();
        secondDouble = Double.parseDouble(secondText);

        switch (generalOperationObject) {
            case "+":
                result = firstDouble + secondDouble;
                break;
            case "-":
                result = firstDouble - secondDouble;
                break;
            case "*":
                result = firstDouble * secondDouble;
                break;
            case "/":
                result = firstDouble / secondDouble;
                break;
            default:
        }
        String format = String.format("%.1f", result);
        txtDisplay1.setText(format);

    }
    
    
    @FXML
    private void  closepanecalcul(ActionEvent event) { 
        calculpane.setOpacity(0);

        calculpane.toBack();;    
    }
   
   
    
    
    @FXML
    private void USDEURpane(MouseEvent event) {
       calculpane.toFront();
       new FadeInUpTransition(calculpane).play();
       calculpane.setOpacity(1);
       txtDisplay1.setText(Double.toString(usdeur));
    }
    
    @FXML
    private void USDAUDpane(MouseEvent event) {
        calculpane.toFront();
        new FadeInUpTransition(calculpane).play();
        calculpane.setOpacity(1);
        txtDisplay1.setText(Double.toString(usdaud));
    }
    
    @FXML
    private void USDGBPpane(MouseEvent event) {
        calculpane.toFront();
        new FadeInUpTransition(calculpane).play();
        calculpane.setOpacity(1);
        txtDisplay1.setText(Double.toString(usdGBP));
    }
    @FXML
    private void USDCHFpane(MouseEvent event) {
        calculpane.toFront();
        new FadeInUpTransition(calculpane).play();
        calculpane.setOpacity(1);
        txtDisplay1.setText(Double.toString(USDCHF));
    }
    @FXML
    private void USDJPYpane(MouseEvent event) {
        calculpane.toFront();
        new FadeInUpTransition(calculpane).play();
        calculpane.setOpacity(1);
        txtDisplay1.setText(Double.toString(usdjpy));
    }
    @FXML
    private void USDCADpane(MouseEvent event) {
        calculpane.toFront();
        new FadeInUpTransition(calculpane).play();
        calculpane.setOpacity(1);
        txtDisplay1.setText(Double.toString(usdcad));
    }
    @FXML
    private void EURGBPpane(MouseEvent event) {
        calculpane.toFront();
        new FadeInUpTransition(calculpane).play();
        calculpane.setOpacity(1);
        txtDisplay1.setText(Double.toString(eurgbp));
    }
    @FXML
    private void USDAEDpane(MouseEvent event) {
        calculpane.toFront();
        new FadeInUpTransition(calculpane).play();
        calculpane.setOpacity(1);
        txtDisplay1.setText(Double.toString(usdaed));
    }
    
    ///////////////// other functions
    ///////////////// //////////////////////////////////////////////////////////////////////
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
    
    public List<Contact> filterSupplierList() {
        List<Contact> SuplierList = new ArrayList<>();
        for (Contact c : findAllContact()) {
            try {
                if (c.getRole().equals("supplier"))
                    SuplierList.add(c);
            } catch (NullPointerException e) {
            }
        }
        return SuplierList;
    }
    
    public List<Contact> filterCostumerList() {
        List<Contact> CostumerList = new ArrayList<>();
        for (Contact c : findAllContact()) {
            try {
                if (c.getRole().equals("Costumer"))
                    CostumerList.add(c);
            } catch (NullPointerException e) {
            }
        }
        return CostumerList;
    }

    private List<Purchase> findAllpurchasquantity() {
        List<Purchase> purchases = new ArrayList<>();
        try {
            ctx = new InitialContext();
            purchaseService = (PurchaseServiceRemote) ctx.lookup(jndiPurchase);
            purchases = purchaseService.aaaa();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return purchases;
    }

    private Map<String, Number> sommetot_purchase_parproduit() {
        Map<String, Number> products = new HashMap<String, Number>();

        ///////// List<Map<String,String>> products = new ArrayList<>();
        try {
            ctx = new InitialContext();
            purchaseService = (PurchaseServiceRemote) ctx.lookup(jndiPurchase);
            products = purchaseService.sommetot_purchase();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return products;
    }

    private Map<String, Number> Need_somme_parproduit() {
        Map<String, Number> products = new HashMap<String, Number>();

        ///////// List<Map<String,String>> products = new ArrayList<>();
        try {
            ctx = new InitialContext();
            needService = (NeedServiceRemote) ctx.lookup(jndiNameNeeda);
            products = needService.Need_somme();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return products;
    }

    private Map<String, Number> sommetot_campaign_par_profduit() {
        Map<String, Number> products = new HashMap<String, Number>();

        ///////// List<Map<String,String>> products = new ArrayList<>();
        try {
            ctx = new InitialContext();
            compaignservice = (CampaignServiceRemote) ctx.lookup(jndiNameCompaign);
            products = compaignservice.sommetot_campaign();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return products;
    }

    private List<Product> findAlProducts() {
        List<Product> products = new ArrayList<>();
        try {
            ctx = new InitialContext();
            producttService = (ProductServiceRemote) ctx.lookup(jndiNameProduct);
            products = producttService.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return products;
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

    private Product findProduit(Product I) {
        Product aaa = new Product();
        try {
            ctx = new InitialContext();
            producttService = (ProductServiceRemote) ctx.lookup(jndiNameProduct);
            aaa = producttService.find(I.getId());
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return aaa;
    }

    private List<Purchase> findALLPurchase() {
        List<Purchase> Purchase = new ArrayList<>();
        try {
            ctx = new InitialContext();
            purchaseService = (PurchaseServiceRemote) ctx.lookup(jndiPurchase);
            Purchase = purchaseService.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return Purchase;
    }

    private List<Sale> findALLSale() {
        List<Sale> Sale = new ArrayList<>();
        try {
            ctx = new InitialContext();
            saleService = (SaleServiceRemote) ctx.lookup(jndiNameSale);
            Sale = saleService.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return Sale;
    }

    private List<User> findAllUser() {
        List<User> User = new ArrayList<>();
        try {
            ctx = new InitialContext();
            userService = (UserServiceRemote) ctx.lookup(jndiNameUser);
            User = userService.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return User;
    }

    ///////// cette mÃ©thode est utilisÃ© pour l'ajout and for the update ////////
    private void addPurchase(Purchase i) {
        try {
            ctx = new InitialContext();
            purchaseService = (PurchaseServiceRemote) ctx.lookup(jndiPurchase);
            if (i.getId_purchase() == null) {
                purchaseService.save(i);
            } else {
                purchaseService.update(i);
            }
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
    }

    private void addsale(Sale i) {
        try {
            ctx = new InitialContext();
            saleService = (SaleServiceRemote) ctx.lookup(jndiNameSale);
            if (i.getId_Sale() == null) {
                saleService.save(i);
            } else {
                saleService.update(i);
            }
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
    }

    private void addneed(Needa i) {
        try {
            ctx = new InitialContext();
            needService = (NeedServiceRemote) ctx.lookup(jndiNameNeeda);

            needService.save(i);

        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
    }

    private Double afficherSommeSalesiPhone7(Integer i) {
        Double ik = (double) 0;
        try {
            ctx = new InitialContext();
            needService = (NeedServiceRemote) ctx.lookup(jndiNameNeeda);
            ik = needService.SommeSalesiPhone7(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return ik;
    }
    
    private Double afficherSommepaymentparPoste(String i) {
        Double ik = (double) 0;
        try {
            ctx = new InitialContext();
            userService = (UserServiceRemote) ctx.lookup(jndiNameUser);
            ik = userService.TotalpayementbyGrade(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return ik;
    }

    private Double afficherSommeSalesiPhone8(Integer i) {
        Double ik = (double) 0;
        try {
            ctx = new InitialContext();
            needService = (NeedServiceRemote) ctx.lookup(jndiNameNeeda);
            ik = needService.SommeSalesiPhone8(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return ik;
    }

    private Double afficherSommeSalesiPhone8Plus(Integer i) {
        Double ik = (double) 0;
        try {
            ctx = new InitialContext();
            needService = (NeedServiceRemote) ctx.lookup(jndiNameNeeda);
            ik = needService.SommeSalesiPhone8Plus(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return ik;
    }

    private Double afficherSommeSalesiPhoneX(Integer i) {
        Double ik = (double) 0;
        try {
            ctx = new InitialContext();
            needService = (NeedServiceRemote) ctx.lookup(jndiNameNeeda);
            ik = needService.SommeSalesiPhoneX(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return ik;
    }

    void deletPurchase(Purchase p) {
        try {
            ctx = new InitialContext();
            purchaseService = (PurchaseServiceRemote) ctx.lookup(jndiPurchase);
            purchaseService.delete(p);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong");
        }
    }

    private void updateProdcut(Product i) {
        try {
            ctx = new InitialContext();
            producttService = (ProductServiceRemote) ctx.lookup(jndiNameProduct);
            if (i.getId_Product() == null) {
                producttService.save(i);
            } else {
                producttService.update(i);
            }
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
    }

    void deletSale(Sale p) {
        try {
            ctx = new InitialContext();
            saleService = (SaleServiceRemote) ctx.lookup(jndiNameSale);
            saleService.delete(p);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong");
        }

    }

    void buildNotification(String title, String text, Pos position) {
        Notifications notificationBuilder = Notifications.create().title(title).text(text).graphic(null)
                .hideAfter(Duration.seconds(10)).position(position);
        notificationBuilder.showWarning();
    }

    ////////////////// dd//////////
}