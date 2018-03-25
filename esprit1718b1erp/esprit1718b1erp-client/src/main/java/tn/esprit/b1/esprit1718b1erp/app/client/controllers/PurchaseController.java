package tn.esprit.b1.esprit1718b1erp.app.client.controllers;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;
import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.Item_Type;
import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Purchase;
import tn.esprit.b1.esprit1718b1erp.entities.Purchase_type;
import tn.esprit.b1.esprit1718b1erp.entities.Statupurchase;
import tn.esprit.b1.esprit1718b1erp.entities.TypePayementPurchase;
import tn.esprit.b1.esprit1718b1erp.services.ahmed.PurchaseServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.amine.CategoryServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote;
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
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.prism.impl.Disposer.Record;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class PurchaseController implements Initializable {

    @FXML
    private AnchorPane paneCrud;

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
    Integer status;
    @FXML
    private TextField txtamontcurr;
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
    private InitialContext ctx = null;

    private ObservableList<Item> listData;
    private ObservableList<Purchase> listDataP;

    ItemServiceRemote itemService;
    PurchaseServiceRemote purchaseService;
    ContactServiceRemote contactService;
    ProductServiceRemote producttService;

    int quantity = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            /*
             * try { showPubDetailItem(); selectWithService(); } catch
             * (Exception e) { // TODO Auto-generated catch block
             * e.printStackTrace(); }
             */
            afficherPurchase();
            selectWithServicePurchase();
            paneTabel.toFront();
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
            cbsupplier.getItems().addAll(findAllContact());
            cbsupplier.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    showPubDetails(newValue);
                } catch (Exception ex) {

                }
            });
            cbProjectname.getItems().addAll(findAlProducts());

            cbtypepurchase.getItems().addAll("Purchases of raw materials", "Manufactured purchases",
                    "Investment purchases", "Trading purchases", "Overhead purchases", "Service purchases");
            txtpaymenttype.getItems().addAll("Cash", "Check", "Credit Card");

            cbitems.getItems().addAll(findAlItemsfind());

        });

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
        List<Item> bb = new ArrayList<>();
        bb.add(new Item(45, "hkg"));
        Purchase pp = new Purchase();
        pp.setItem(bb);

        Purchase purchase = new Purchase(supplier, daterequested, deliverydate, quantity, typepurchase, Description,
                tpaymenttype, Projectname);

        if ((paid.isSelected()) && (unpaid.isSelected())) {
            Config2.dialog(Alert.AlertType.WARNING, "Choose only one parameter");
            paid.requestFocus();
        } else if (paid.isSelected()) {
            purchase.setStatupurchase(Statupurchase.Paid);
        } else
            purchase.setStatupurchase(Statupurchase.Unpaid);
        if (!(txtID.getText()).equals("")) {
            purchase.setId_purchase(Integer.parseInt(txtID.getText()));
            System.out.println(txtID.getText() + "hfhgfgh");
        }
        addPurchase(purchase);
        ///// showPubDetailItem();
        ///// selectWithService();

    }

    ///////// le boutton de retour de crud vers le tableview //////////
    @FXML
    private void aksiBack(ActionEvent event) {
        TabPane.setOpacity(0);

        selectWithService();
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

                String dated = pur.getDateDemande().toString();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(dated, formatter);
                txtdaterequested.setValue(date);

                String datedeee = pur.getDateRecu().toString();
                LocalDate dates = LocalDate.parse(datedeee, formatter);
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
        cleartxtPurchase();
        paneTabel.setOpacity(0);
        TabPane.toFront();
        new FadeInUpTransition(paneCrud).play();
        Platform.runLater(() -> {

        });
    }

    /////////// afficher les detaiile de contact lors de click sur un combobox
    /////////// ///////////
    void showPubDetails(Contact I) throws ParseException {
        txtsuppphone.setText(String.valueOf(I.getPhone()));
        txtPurchaseCode.setText((I.getStreet()));
    }

    ////////////// affichage des item sélctionner de combo avant l'ajout de
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

    ///////////// ajouter les items séléctionner dans une liste ///////////
    ///////////// calculer la quantiter global des items /////////////////
    ///////// calculer la somme gloabl de tous les item selon la devise de
    ///////////// chaque item sélectionner ////
    ////// convertir la la somme de chaque item selon la devise de l'item en USD
    ///////////// et enfin calculer la somme des Items global en USD ////
    private void selectData() throws ParseException {
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);
        List<Float> boutiques = new ArrayList<>();
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

                for (Item i : listData) {
                    System.out.println(i.getTotalPrice());
                    float price = i.getTotalPrice();
                    int quant = i.getQuantity();
                    quantity += quant;
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
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDGBP");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "CHF":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDGBP");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "AED":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDGBP");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "AFN":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDGBP");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "ALL":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDGBP");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "AMD":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDGBP");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "ANG":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDGBP");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;
                    case "AOA":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDGBP");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "AUD":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDGBP");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "AWG":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDGBP");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    case "AZN":
                        v = exchangeRates.getJSONObject("quotes").getDouble("USDGBP");
                        cv = (float) (price * v);
                        response.close();
                        qs += cv;
                        boutiques.add(qs);
                        break;

                    }
                    System.out.println(boutiques);
                    float aaa = 0;
                    for (float dd : boutiques) {

                        aaa += dd;
                    }
                    System.out.println(aaa + "this is the converted value");
                    txtamontcurr.setText(Float.toString(aaa));
                    txtamont.setText(Double.toString(totalprice));
                    txtQuantity.setText(Integer.toString(quantity));
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

    ///////// fonction just pour charger les éléments des Item dans le tableview
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
        Config2.setModelColumn(tbStatutP, "statupurchase");
        System.out.println("aaaaaaaaa");

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

    ///////// fonction just pour charger les éléments des Purchase dans le
    ///////// tableview "not really"///////////
    private void selectWithServicePurchase() {
        Service<Integer> service = new Service<Integer>() {
            @Override
            protected Task<Integer> createTask() {
                selectDataPurchase();
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
                    /////// TabPane.setOpacity(1);
                    paneCrud.toFront();
                    new FadeInUpTransition(TabPane).play();
                    status = 0;  
                }
                else {
                    selectDataPurchase();
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
////////////clear the add interface for a purchase //////////////////
    private void cleartxtPurchase() {
        txtsuppphone.clear();
        txtPurchaseCode.clear();
        txtDescription.clear();
        paid.setSelected(false);
        unpaid.setSelected(false);
        cbsupplier.getItems().clear();
        cbsupplier.getItems().addAll(findAllContact());
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

    ///////// cette méthode est utilisé pour l'ajout and for the update ////////
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
}
