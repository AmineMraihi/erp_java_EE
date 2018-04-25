package tn.esprit.b1.esprit1718b1erp.app.client.controllers;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.controlsfx.control.Notifications;
import org.controlsfx.control.table.TableRowExpanderColumn;
import org.controlsfx.control.textfield.TextFields;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.model.Calendar.Style;
import com.calendarfx.view.CalendarView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN8Writer;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.prism.impl.Disposer.Record;

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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeOutUpTransition;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeOutUpTransition;
import tn.esprit.b1.esprit1718b1erp.app.client.util.ItemUtil;
import tn.esprit.b1.esprit1718b1erp.app.client.util.ItemVerfication;
import tn.esprit.b1.esprit1718b1erp.app.client.util.MatrixToImageWriter;
import tn.esprit.b1.esprit1718b1erp.entities.AlertItemType;
import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.ItemOffer;
import tn.esprit.b1.esprit1718b1erp.entities.ItemRequest;
import tn.esprit.b1.esprit1718b1erp.entities.ItemRequestStatus;
import tn.esprit.b1.esprit1718b1erp.entities.Item_Type;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.services.amine.CategoryServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.amine.ItemOfferServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.amine.ItemRequestServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote;

public class ItemController implements Initializable {

    @FXML
    private AnchorPane paneTabel;

    @FXML
    private TableView<Item> tableData;

    @FXML
    private TableColumn colAction;

    @FXML
    private ComboBox<Item> filterByItemForItemOffer;

    @FXML
    private TableColumn<Item, String> colItemName;

    @FXML
    private TableColumn<Item, String> colItemCategory;

    @FXML
    private TableColumn<Item, String> colItemType;

    @FXML
    private TableColumn<Item, String> colItemQuantity;

    @FXML
    private TableColumn<Item, Integer> colItemBarcode;

    @FXML
    private TableColumn<Item, String> colItemSupplier;

    @FXML
    private TableColumn<Item, String> colItemImage;

    @FXML
    private TextField txtBarcodeNumber;

    @FXML
    private PieChart pieCharItemQuantity;

    @FXML
    private ImageView barcodeimgv;

    @FXML
    private Button btnNew;

    @FXML
    private ProgressBar bar;

    @FXML
    private ComboBox<String> cbCurrency;

    @FXML
    private ImageView imgLoad;

    @FXML
    private TabPane TabPane;

    @FXML
    private AnchorPane paneCrud;

    @FXML
    private TableColumn<Category, String> colCategoryDescription;

    @FXML
    private AnchorPane addCategoryPane;

    @FXML
    private TextField txtId1;

    @FXML
    private Button close;

    @FXML
    private TableView<Category> CategoryTableAction;

    @FXML
    private TableColumn colCategoryAction;

    @FXML
    private TableColumn<Category, String> colCategoryName;

    @FXML
    private TextField txtCategoryName;

    @FXML
    private TextArea txtDescriptionCategory;

    @FXML
    private Button btnAddCategory;

    @FXML
    private ComboBox<String> filterByItemType;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtSelling;
    
    @FXML
    private Label ProductIdItem;

    @FXML
    private Tab ItemAlertMenu;

    @FXML
    private Button btnSave;

    @FXML
    private ComboBox<Contact> filterByItemSupplier;

    @FXML
    private ComboBox<Category> filterByCategory;

    @FXML
    private TableView<Item> tableDataAlert;

    @FXML
    private TableColumn<String, String> colAlerType;

    @FXML
    private TableColumn colItemOfferActions;

    @FXML
    private TableColumn<Item, String> colItemNameAlert;

    @FXML
    private TableColumn<Item, String> colItemCategoryAlert;

    @FXML
    private TableColumn<Item, String> colItemExpirationDate;

    @FXML
    private TableColumn<Item, String> colItemQuantityAlert;

    @FXML
    private TableColumn<Item, Integer> colItemBarcodeAlert;

    @FXML
    private TableColumn<Item, String> colItemSupplierAlert;

    @FXML
    private TableView<ItemRequest> tableDataImport;

    @FXML
    private TableColumn<ItemRequest, String> colImportItemName;

    @FXML
    private TableColumn<ItemRequest, String> colImportItemCategory;

    @FXML
    private TableColumn<ItemRequest, String> colImportItemExpirationDate;

    @FXML
    private TableColumn<ItemRequest, Integer> colImportItemQuantity;

    @FXML
    private TableColumn<ItemRequest, String> colImportItemBarcode;

    @FXML
    private TableColumn<ItemRequest, String> colImportItemSupplier;

    @FXML
    private Button btnBack;

    @FXML
    private ComboBox<Category> cbCategory;

    @FXML
    private TextField txtQuantity;

    @FXML
    private CheckBox cbProduct;

    @FXML
    private CheckBox cbService;

    @FXML
    private AnchorPane testtab;

    @FXML
    private Button btnImportItem;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtItemName;

    @FXML
    private CheckBox cbOther;

    @FXML
    private TextField txtBuying;

    @FXML
    private TextField txtBarcode;

    @FXML
    private ComboBox<Contact> cbSupplier;

    @FXML
    private ImageView imgItem;

    @FXML
    private Button btnUpload;

    @FXML
    private ImageView addCategory;

    @FXML
    private ImageView addSupplier;

    @FXML
    private ListView<Item> listviewItemOffer;

    @FXML
    private AnchorPane addSupplierPane;

    @FXML
    private AnchorPane statisticsChartPane;

    @FXML
    private AnchorPane showCategoriesPane;

    @FXML
    private TextField txtId11;

    @FXML
    private Label QuantityLabel;

    @FXML
    private TextField txtSupplierName;

    @FXML
    private TextField txtsearchItem;

    @FXML
    private Button btnAddSupplier;

    @FXML
    private TextField txtIdItemOffer;

    @FXML
    private ComboBox<?> cbCountrySupplier;

    @FXML
    private TextField txtCitySupplier;

    @FXML
    private TextField txtSupplierPhone;

    @FXML
    private TextField txtSupplierEmail;

    @FXML
    private TextField txtSupplierWebsite;

    @FXML
    private AnchorPane paneCrud1;

    @FXML
    private TextField txtLowestQuantity;

    @FXML
    private Button btnBack1;

    @FXML
    private AnchorPane addItemOfferPane;

    @FXML
    private CheckBox cbLowQuantity;

    @FXML
    private AnchorPane newStatisticPane;

    @FXML
    private ComboBox<Item> cbItemOfferItem;

    @FXML
    private ComboBox<Contact> cbItemOfferSupplier;

    @FXML
    private TextField txtItemOfferPrice;

    @FXML
    private TableColumn<ItemOffer, String> colItemOfferPrice;

    @FXML
    private CheckBox cbLowExpirationDate;

    @FXML
    private DatePicker txtExpirationDate;

    @FXML
    private TextField txtItemNameForImport;

    @FXML
    private TableView<ItemOffer> tableDataItemOffer;

    @FXML
    private TableColumn<ItemOffer, String> colitemOfferName;

    @FXML
    private TableColumn<ItemOffer, String> colItemOfferDescription;

    @FXML
    private TableColumn<ItemOffer, String> colItemOfferCategory;

    @FXML
    private TableColumn<ItemOffer, String> colItemOfferType;

    @FXML
    private TableColumn<ItemOffer, String> colItemOfferBarcode;

    @FXML
    private TableColumn<ItemOffer, String> colItemOfferSupplier;

    DatePicker ddd = new DatePicker();
    boolean checkAlertOnQuantity, selectimage;
    private ObservableList<Item> listData, listDataAlert;
    private ObservableList<Category> listDataCategory;
    private ObservableList<ItemOffer> listDataItemOffer;

    private ObservableList<ItemRequest> listItemImports;
    Config2 con = new Config2();
    private InitialContext ctx = null;
    Item iPic;
    TableRowExpanderColumn<ItemRequest> expander = new TableRowExpanderColumn<>(this::createEditor);
    private final String jndiNameItem = "esprit1718b1erp-ear/esprit1718b1erp-service/ItemService!tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote";
    private final String jndiNameCategory = "esprit1718b1erp-ear/esprit1718b1erp-service/CategoryService!tn.esprit.b1.esprit1718b1erp.services.amine.CategoryServiceRemote";
    private final String jndiNameSupplier = "esprit1718b1erp-ear/esprit1718b1erp-service/ContactService!tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote";
    private final String jndiNameItemRequest = "esprit1718b1erp-ear/esprit1718b1erp-service/ItemRequestService!tn.esprit.b1.esprit1718b1erp.services.amine.ItemRequestServiceRemote";
    private final String jndiNameItemOffer = "esprit1718b1erp-ear/esprit1718b1erp-service/ItemOfferService!tn.esprit.b1.esprit1718b1erp.services.amine.ItemOfferServiceRemote";
    ItemServiceRemote itemService;
    CategoryServiceRemote categorieService;
    ContactServiceRemote contactService;
    ItemRequestServiceRemote itemRequestService;
    ItemOfferServiceRemote itemOfferService;
    User u;
    String getImageUrl;
    String imgName;
    MediaPlayer mediaplayer;
    Integer status;
    int itemRId;
    TableColumn<Item, String> expirationDate = new TableColumn<Item, String>();
   

    VBox grid = new VBox(70);

    public List<Contact> filterSupplierList() {
        List<Contact> trueSupplierList = new ArrayList<>();
        for (Contact c : findAllSuppliers()) {
            try {
                if (c.getRole().equals("provider"))
                    trueSupplierList.add(c);
            } catch (NullPointerException e) {
            }
        }
        return trueSupplierList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Platform.runLater(() -> {
            txtId.setVisible(false);
            ProductIdItem.setVisible(false);
            tableData.getColumns().add(expirationDate);
            afficherItemImport();
            afficher();
            afficherCategories();
            afficherItemOffer();
            selectWithService();
            pieChartQuantityShow();
            cbCategory.getItems().addAll(findAllCategories());
            cbItemOfferItem.getItems().addAll(findAll());
            cbItemOfferSupplier.getItems().addAll(filterSupplierList());
            filterByItemType.getItems().addAll("Product", "Service", "Other");
            filterByCategory.getItems().addAll(findAllCategories());
            filterByItemSupplier.getItems().addAll(filterSupplierList());
            filterByItemForItemOffer.getItems().addAll(findAll());

            filterByCategory.valueProperty().addListener(new ChangeListener<Category>() {

                @Override
                public void changed(ObservableValue<? extends Category> observable, Category oldValue,
                        Category newValue) {
                    listData = FXCollections.observableArrayList();
                    listData.clear();
                    for (Item i : findAll()) {
                        if (i.getCategory().getName().equals(newValue.getName())) {
                            listData.add(i);
                        }
                    }
                    tableData.setItems(listData);
                    afficher();

                }

            });

            filterByItemForItemOffer.valueProperty().addListener(new ChangeListener<Item>() {

                @Override
                public void changed(ObservableValue<? extends Item> observable, Item oldValue, Item newValue) {
                    listDataItemOffer = FXCollections.observableArrayList();
                    listDataItemOffer.clear();
                    listDataItemOffer.addAll(findByItem(newValue.getId()));
                    tableDataItemOffer.setItems(listDataItemOffer);
                    afficherItemOfferTestVersion();
                }

            });

            filterByItemType.valueProperty().addListener(new ChangeListener<String>() {

                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    listData = FXCollections.observableArrayList();
                    listData.clear();
                    for (Item i : findAll()) {
                        if (i.getType().toString().equals(newValue.toUpperCase())) {
                            listData.add(i);
                        }
                    }
                    tableData.setItems(listData);
                    afficher();

                }
            });

            filterByItemSupplier.valueProperty().addListener(new ChangeListener<Contact>() {

                @Override
                public void changed(ObservableValue<? extends Contact> observable, Contact oldValue, Contact newValue) {
                    listData = FXCollections.observableArrayList();
                    listData.clear();
                    for (Item i : findAll()) {
                        if (i.getSupplier().getName().equals(newValue.getName())) {
                            listData.add(i);
                        }
                    }
                    tableData.setItems(listData);
                    afficher();
                }
            });

            cbCurrency.getItems().addAll("EUR", "USD", "CHF", "GBP", "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "AUD",
                    "AWG", "AZN");
            status = 0;

            cbService.setOnAction(e -> {
                txtQuantity.setDisable(true);
                txtLowestQuantity.setDisable(true);
                cbLowQuantity.setDisable(true);
                cbLowQuantity.setSelected(false);
            });

            cbOther.setOnAction(e -> {
                txtLowestQuantity.setDisable(false);
                cbLowQuantity.setDisable(false);
                txtQuantity.setDisable(false);
                cbLowQuantity.setSelected(false);

            });

            cbProduct.setOnAction(e -> {
                txtLowestQuantity.setDisable(false);
                cbLowQuantity.setDisable(false);
                txtQuantity.setDisable(false);
                cbLowQuantity.setSelected(false);

            });

            afficherAlert();
            tableDataAlert.setItems(listDataAlert);

            TextFields.bindAutoCompletion(txtsearchItem, getItemNames());
            txtsearchItem.textProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                    filerItemList((String) oldValue, (String) newValue);
                }
            });

            TextFields.bindAutoCompletion(txtItemNameForImport, getItemNames());
            txtItemNameForImport.textProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                    filerItemListForItemImport((String) oldValue, (String) newValue);
                }
            });

            tableDataImport.getColumns().add(expander);

            txtItemName.focusedProperty().addListener(new ChangeListener<Boolean>() {

                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        ItemVerfication.verifyItemNameDoesNotExists(txtItemName);
                    }

                }
            });

            txtSelling.focusedProperty().addListener(new ChangeListener<Boolean>() {

                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    try {
                        if (!txtBuying.getText().equals("") && !newValue) {
                            if (Integer.parseInt(txtSelling.getText()) < Integer.parseInt(txtBuying.getText())) {
                                playSound("error.mp3");
                                Config2.dialog(Alert.AlertType.ERROR, "Selling price must be higher than buying one");
                                txtSelling.selectPositionCaret(0);
                            }
                        }
                    } catch (NumberFormatException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            });

            txtExpirationDate.focusedProperty().addListener(new ChangeListener<Boolean>() {

                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (!newValue) {
                        Date timeStampDate = new Date();
                        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
                        String formattedDate1 = dateFormat1.format(timeStampDate);
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate date = LocalDate.parse(formattedDate1, formatter);
                        System.out.println(txtExpirationDate.getValue().isBefore(date));
                        System.out.println("hello");
                        if (txtExpirationDate.getValue().isBefore(date)) {
                            playSound("error.mp3");
                            Config2.dialog(Alert.AlertType.ERROR, "Please, provide a valid date");
                        }
                    }

                }
            });

        });

    }

    public List<String> getItemNames() {
        List<String> list = new ArrayList<String>();
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            list = itemService.getItemNamesList();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return list;
    }

    @FXML
    void datework(ActionEvent event) {
        CalendarView calendarView = new CalendarView();
        Calendar expiration = new Calendar("expiration");
        expiration.setStyle(Style.STYLE1);
        CalendarSource myCalendarSource = new CalendarSource("Expiration Dates");
        myCalendarSource.getCalendars().add(expiration);
        calendarView.getCalendarSources().addAll(myCalendarSource);

        for (Item i : findAll()) {
            if (i.getShowAlertOnExpirationDate()) {
                System.out.println(i);
                Entry<String> date = new Entry<>(i.getName());
                date.setFullDay(true);
                Date input = i.getExpirationDate();
                LocalDate dateL = Instant.ofEpochMilli(input.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                date.changeStartDate(dateL);
                expiration.addEntry(date);
                date.changeEndDate(dateL);
            }
        }

        calendarView.setMaxSize(1225, 531);
        calendarView.setRequestedTime(LocalTime.now());
        calendarView.setShowAddCalendarButton(false);
        calendarView.setShowToolBar(false);
        calendarView.setShowDeveloperConsole(false);
        calendarView.setShowPageSwitcher(false);
        calendarView.setShowPageToolBarControls(false);
        calendarView.setShowPrintButton(false);
        calendarView.setShowSearchField(false);
        calendarView.setShowSearchResultsTray(false);
        calendarView.setShowSourceTray(false);
        calendarView.setShowSourceTrayButton(false);
        calendarView.setShowToday(false);
        calendarView.setShowToolBar(false);
        Stage primaryStage = new Stage();
        Scene scene = new Scene(calendarView);
        primaryStage.setTitle("Calendar");
        primaryStage.setScene(scene);
        primaryStage.setX(150);
        primaryStage.setY(172);
        primaryStage.setWidth(1131);
        primaryStage.setHeight(560);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }

    @FXML
    void addSupplierPlusButton(MouseEvent event) {
        addSupplierPane.toFront();
        new FadeInUpTransition(addSupplierPane).play();
    }

    @FXML
    void addtemOffer(ActionEvent event) {
        addItemOfferPane.toFront();
        new FadeInUpTransition(addItemOfferPane).play();
    }

    @FXML
    void aksiAddSupplier(ActionEvent event) {
        Contact contact = new Contact();
        contact.setName(txtSupplierName.getText());
        contact.setCountry(null);
        contact.setName(txtCitySupplier.getText());
        contact.setPhone(Integer.parseInt(txtSupplierPhone.getText()));
        contact.setEmail(txtSupplierEmail.getText());
        contact.setWebsite(txtSupplierWebsite.getText());
        contact.setRole("provider");
        // addSupplier(contact);
        // cbSupplier.getItems().clear();
        // cbSupplier.getItems().addAll(findAllSuppliers());
        cbSupplier.setValue(contact);
        addSupplierPane.setOpacity(0);
        addSupplierPane.toBack();
        TabPane.toFront();
    }

    @FXML
    void aksiCloseSupplier(ActionEvent event) {
        addSupplierPane.setOpacity(0);
        addSupplierPane.toBack();
        TabPane.toFront();
    }

    @FXML
    void addCategoryPlusButton(MouseEvent event) {
        addCategoryPane.toFront();
        new FadeInUpTransition(addCategoryPane).play();
    }

    @FXML
    void aksiAddCategory(ActionEvent event) {
        Category category = new Category();
        category.setName(txtCategoryName.getText());
        category.setDescription(txtDescriptionCategory.getText());
        // addcategory(category);
        // cbCategory.getItems().clear();
        // cbCategory.getItems().addAll(findAllCategories());
        cbCategory.setValue(category);
        addCategoryPane.setOpacity(0);
        addCategoryPane.toBack();
        TabPane.toFront();
    }

    @FXML
    void aksiClose(ActionEvent event) {
        addCategoryPane.setOpacity(0);
        addCategoryPane.toBack();
        TabPane.toFront();
    }

    @FXML
    void aksiBack(ActionEvent event) {
        TabPane.setOpacity(0);
        selectWithService();
    }

    @FXML
    void aksiKlikTableData(MouseEvent event) {
        if (status == 1) {
            try {
                Item item = tableData.getSelectionModel().getSelectedItem();
                iPic = item;
                System.out.println(item.getPicture());
                System.out.println("////////////////////////////////////");

                txtItemName.setText(item.getName());
                txtDescription.setText(item.getDescription());
                cbCategory.setValue(item.getCategory());
                cbSupplier.setValue(item.getSupplier());
                u = LoginController.getLoggedUser();
                try {
                    txtQuantity.setText(Integer.toString(item.getQuantity()));
                } catch (NullPointerException e) {
                }

                System.out.println("******************" + item.getBarcode());
                cbCurrency.setValue(item.getCurrency());
                txtBarcode.setText(Integer.toString(item.getBarcode()));
                txtBuying.setText(Float.toString(item.getByingPrice()));
                txtSelling.setText(Float.toString(item.getSellingPrice()));
                switch (item.getType().toString()) {
                case "PRODUCT":
                    cbProduct.setSelected(true);
                    txtLowestQuantity.setDisable(false);
                    cbLowQuantity.setDisable(false);
                    txtQuantity.setDisable(false);
                    cbLowQuantity.setSelected(false);
                    break;
                case "SERVICE":
                    cbService.setSelected(true);
                    txtQuantity.setDisable(true);
                    txtLowestQuantity.setDisable(true);
                    cbLowQuantity.setDisable(true);
                    cbLowQuantity.setSelected(false);
                    break;
                case "OTHER":
                    cbOther.setSelected(true);
                    txtLowestQuantity.setDisable(false);
                    cbLowQuantity.setDisable(false);
                    txtQuantity.setDisable(false);
                    cbLowQuantity.setSelected(false);
                    break;
                }
                if (item.getShowAlertOnQuantity()) {
                    cbLowQuantity.setSelected(true);
                    txtLowestQuantity.setText(Integer.toString(item.getMinimumQuanity()));
                }
                if (item.getShowAlertOnExpirationDate()) {
                    cbLowExpirationDate.setSelected(true);
                    try {
                        String dated = item.getExpirationDate().toString();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        LocalDate date = LocalDate.parse(dated, formatter);
                        txtExpirationDate.setValue(date);
                    } catch (DateTimeParseException exc) {
                    }
                }
                File imagefile1 = new File(
                        "C:\\\\wamp64\\\\www\\\\imagesAmine\\\\barcodes\\\\\\\\" + txtBarcode.getText() + ".png");
                Image newBarcode = new Image(imagefile1.toURI().toString(), 385, 246, false, false);
                txtBarcodeNumber.setText(txtBarcode.getText());
                barcodeimgv.setImage(newBarcode);

                File imagefile = new File("C:\\\\wamp64\\\\www\\\\imagesAmine\\\\" + item.getPicture());
                Image ima = new Image(imagefile.toURI().toString(), 300, 208, false, false);
                System.out.println("C:\\\\wamp64\\\\www\\\\imagesAmine\\\\" + item.getPicture());
                imgItem.setImage(ima);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void aksiNew(ActionEvent event) {
        clear();
        paneTabel.setOpacity(0);
        new FadeInUpTransition(TabPane).play();
    }

    @FXML
    void aksiAAddItemOffer(ActionEvent event) {
        ItemOffer iO = new ItemOffer();
        iO.setItem(cbItemOfferItem.getValue());
        iO.setSupplier(cbItemOfferSupplier.getValue());
        iO.setBuyingPrice(Integer.parseInt(txtItemOfferPrice.getText()));
        if (!txtIdItemOffer.getText().equals("")) {
            iO.setId(Integer.parseInt(txtIdItemOffer.getText()));
        }
        Toolkit.getDefaultToolkit().beep();
        addItemOffer(iO);
        Config2.dialog(Alert.AlertType.INFORMATION, "Success Save Data..");
        clear();
        new FadeOutUpTransition(addItemOfferPane);
        addItemOfferPane.toBack();
        tableDataItemOffer.toFront();
        selectDataItemOffer();
        afficherItemOffer();
    }

    @FXML
    void aksiCloseItemOfferPane(ActionEvent event) {
        addItemOfferPane.setOpacity(0);
        addItemOfferPane.toBack();
        TabPane.toFront();

    }

    @FXML
    void aksiSave(ActionEvent event) {
        Item item = new Item();
        item.setName(txtItemName.getText());
        item.setDescription(txtDescription.getText());

        item.setSupplier(cbSupplier.getValue());
        item.setCategory(cbCategory.getValue());
        u = LoginController.getLoggedUser();
        if (cbProduct.isSelected()) {
            item.setType(Item_Type.PRODUCT);
        }

        if (cbOther.isSelected()) {
            item.setType(Item_Type.OTHER);
        }

        if (cbService.isSelected()) {
            item.setType(Item_Type.SERVICE);
        }
        if (ItemVerfication.verifyTypes(cbProduct.isSelected(), cbOther.isSelected(), cbService.isSelected())) {
            System.out.println("yepp");
        }
        item.setBarcode(Integer.parseInt(txtBarcode.getText()));
        try {
            item.setQuantity(Integer.parseInt(txtQuantity.getText()));
        } catch (NumberFormatException e1) {
        }
        try {
            item.setSellingPrice(Float.parseFloat(txtSelling.getText()));
            item.setByingPrice(Float.parseFloat(txtBuying.getText()));
            item.setCurrency(cbCurrency.getValue());
        } catch (Exception e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        try {
            item.setTotalPrice(Integer.parseInt(txtQuantity.getText()) * Float.parseFloat(txtSelling.getText()));
        } catch (NumberFormatException e1) {
        }
        if (selectimage) {
            item.setPicture(imgName);
        } else {
            if(iPic!=null) {
            item.setPicture(iPic.getPicture());
            }else {
                item.setPicture("");
            }
        }

        // alerts
        if (cbLowQuantity.isSelected()) {
            item.setShowAlertOnQuantity(true);
            item.setMinimumQuanity(Integer.parseInt(txtLowestQuantity.getText()));
        } else {
            item.setShowAlertOnQuantity(false);
        }

        if (cbLowExpirationDate.isSelected()) {
            item.setShowAlertOnExpirationDate(true);
            try {
                item.setExpirationDate(convert(txtExpirationDate.getEditor().getText()));
            } catch (ParseException e) {
            }
        } else {
            item.setShowAlertOnExpirationDate(false);
        }

        if (!(txtId.getText()).equals("")) {
            item.setId(Integer.parseInt(txtId.getText()));
        }

        System.out.println(u);
        // saveOrUpdateItem(item);
        ItemUtil.saveOrUpdateItemWithCategoryAndSupplier(item, cbCategory.getValue(), cbSupplier.getValue(), u);
        Toolkit.getDefaultToolkit().beep();
        Config2.dialog(Alert.AlertType.INFORMATION, "Success Save Data..");
        clear();
        TabPane.setOpacity(0);
        selectWithService();
        afficher();
    }

    @FXML
    void generateBarcode(MouseEvent event) throws WriterException, FileNotFoundException, IOException {
        if (txtBarcode.getText().length() != 8) {
            txtBarcode.setText(Long.toString(generateRandomNumber(8)));
        }
        String toBeProcessed = txtBarcode.getText();
        int width = 400;
        int height = 300;
        String imageFormat = "png";
        BitMatrix bitMatrix = new EAN8Writer().encode(toBeProcessed, BarcodeFormat.EAN_8, width, height);
        String path = "C:\\\\wamp64\\\\www\\\\imagesAmine\\\\barcodes\\\\" + toBeProcessed + ".png";
        MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, new FileOutputStream(new File(path)));
        SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
        selectionModel.select(1);
        File imagefile = new File("C:\\\\wamp64\\\\www\\\\imagesAmine\\\\barcodes\\\\\\\\" + toBeProcessed + ".png");
        Image newBarcode = new Image(imagefile.toURI().toString(), 385, 246, false, false);
        txtBarcodeNumber.setText(toBeProcessed);
        barcodeimgv.setImage(newBarcode);
    }

    @FXML
    void ItemStatisticsAction(ActionEvent event) {
        pieChartQuantityShow();
        // SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
        // selectionModel.select(4);
        // paneTabel.setOpacity(0);
        // new FadeInUpTransition(TabPane).play();

        pieChartQuantityShow();
        newStatisticPane.toFront();
        new FadeInUpTransition(newStatisticPane).play();
    }

    private static long generateRandomNumber(int n) {
        long min = (long) Math.pow(10, n - 1);
        return ThreadLocalRandom.current().nextLong(min, min * 10);
    }

    private void pieChartQuantityShow() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Item i : findAll()) {
            if (i.getQuantity() != null) {
                pieChartData.add(new PieChart.Data(i.getName(), i.getQuantity()));
            }

        }
        pieCharItemQuantity.setData(pieChartData);
    }

    @FXML
    void ImportItem(ActionEvent event) {
        Item i = tableDataAlert.getSelectionModel().getSelectedItem();
        ItemRequest ir = new ItemRequest();
        ir.setItem(i);
        ir.setItemRequestStatus(ItemRequestStatus.NOTDONE);
        if (i.getMinimumQuanity() != null && i.getMinimumQuanity() > i.getQuantity()) {
            ir.setQuantityNeeded(i.getMinimumQuanity() - i.getQuantity());
        }
        if (ItemRequestExists(ir) == null) {
            itemRId = addItemRequest(ir);
        }
        afficherItemImport();
        listItemImports = FXCollections.observableArrayList();
        listItemImports.add(ir);
        tableDataImport.setItems(listItemImports);
        SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
        selectionModel.select(3);

    }

    @FXML
    void importItemFromTableItemOffer(ActionEvent event) {
        ItemOffer iO = tableDataItemOffer.getSelectionModel().getSelectedItem();
        Item i = iO.getItem();
        System.out.println(i);
        ItemRequest ir = new ItemRequest();
        ir.setItem(i);
        ir.setItemRequestStatus(ItemRequestStatus.NOTDONE);
        if (ItemRequestExists(ir) == null) {
            itemRId = addItemRequest(ir);
        }
        afficherItemImport();
        listItemImports = FXCollections.observableArrayList();
        listItemImports.add(ir);
        tableDataImport.setItems(listItemImports);
        SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
        selectionModel.select(3);
    }

    @FXML
    void aksiUpload(ActionEvent event) {
        FileChooser fc = new FileChooser();
        selectimage = true;
        File selectedfile = fc.showOpenDialog(null);
        if (selectedfile != null) {
            getImageUrl = selectedfile.getAbsolutePath();
            File file = new File(getImageUrl);
            Image ima = new Image(file.toURI().toString(), 300, 208, false, false);
            int fileNameIndex = getImageUrl.lastIndexOf("\\") + 1;
            imgName = getImageUrl.substring(fileNameIndex);
            File dest = new File("C:\\wamp64\\www\\imagesAmine\\" + imgName);
            imgItem.setImage(ima);
            try {
                copyFileUsingStream(selectedfile, dest);
            } catch (IOException e) {
            }
        } else {

            System.out.println("file does not exist");
        }
    }

    @FXML
    void chooseDirectory(ActionEvent event) throws FileNotFoundException, DocumentException {
        int nb = 0;
        final DirectoryChooser dc = new DirectoryChooser();
        File file = dc.showDialog(null);
        if (file != null) {
            Document document = new Document();
            System.out.println(file.getAbsolutePath());
            System.out.println("C:\\\\\\\\wamp64\\\\\\\\www\\\\\\\\imagesAmine\\\\\\\\");

            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(file.getAbsolutePath() + "\\\\" + "barcode.pdf"));
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            BarcodeEAN barcodeEAN = new BarcodeEAN();
            barcodeEAN.setCode(txtBarcodeNumber.getText());
            barcodeEAN.setCodeType(Barcode.EAN8);
            com.itextpdf.text.Image codeEANImage = barcodeEAN.createImageWithBarcode(cb, null, null);

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Barcode");
            dialog.setHeaderText("Barcode printer");
            dialog.setContentText("Please enter number of times:");
            // Traditional way to get the response value.
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                nb = Integer.parseInt(result.get());
            }
            // The Java 8 way to get the response value (with lambda expression).
            // result.ifPresent(name -> System.out.println("Your name: " + name));

            for (int i = 0; i < nb; i++) {
                document.add(codeEANImage);
                document.add(new Paragraph(""));
            }
            document.newPage();
            document.close();
            Config2.dialog(AlertType.INFORMATION, "saved with success");

        }

    }

    private void clear() {
        txtId.clear();
        txtItemName.clear();
        txtDescription.clear();
        txtQuantity.clear();
        txtBarcode.clear();
        txtSelling.clear();
        txtBuying.clear();
        imgItem.setImage(null);
        cbOther.setSelected(false);
        cbProduct.setSelected(false);
        cbService.setSelected(false);
        cbCategory.getItems().clear();
        cbCategory.getItems().addAll(findAllCategories());
        cbSupplier.getItems().clear();

        cbSupplier.getItems().addAll(filterSupplierList());
        cbLowQuantity.setSelected(false);
        txtLowestQuantity.clear();
        cbLowExpirationDate.setSelected(false);
        txtExpirationDate.setValue(null);

        txtCategoryName.clear();
        txtDescriptionCategory.clear();
        txtLowestQuantity.clear();
        txtItemOfferPrice.clear();
        txtIdItemOffer.clear();
    }

    @FXML
    void showCategories(MouseEvent event) {
        selectDataForCategories();
        afficherCategories();
        showCategoriesPane.toFront();
        new FadeInUpTransition(showCategoriesPane).play();
    }

    @FXML
    void aksiCloseCategoryTable(ActionEvent event) {
        showCategoriesPane.setOpacity(0);
        showCategoriesPane.toBack();
        paneTabel.toFront();
    }

    @FXML
    void tableCategoryMouseClicked(MouseEvent event) {
        listviewItemOffer.setCellFactory((ListView<Item> arg2) -> {
            ListCell<Item> cell = new ListCell<Item>() {
                @Override
                protected void updateItem(Item e, boolean btl) {
                    super.updateItem(e, btl);

                    if (e != null) {
                        File file = new File("C:\\wamp64\\www\\imagesAmine\\" + e.getPicture());
                        file.getParentFile().mkdirs();
                        Image IMAGE_RUBY = new Image(file.toURI().toString());
                        // Image IMAGE_RUBY = new
                        // Image(ps.findById(e.getPassager().getId()).getAvatar());

                        ImageView imgview = new ImageView(IMAGE_RUBY);

                        setGraphic(imgview);

                        imgview.setFitHeight(90);
                        imgview.setFitWidth(90);
                        Rectangle clip = new Rectangle(imgview.getFitWidth(), imgview.getFitHeight());

                        clip.setArcWidth(20);
                        clip.setArcHeight(20);
                        imgview.setClip(clip);

                        // snapshot the rounded image.
                        SnapshotParameters parameters = new SnapshotParameters();
                        parameters.setFill(Color.TRANSPARENT);
                        WritableImage image = imgview.snapshot(parameters, null);

                        // remove the rounding clip so that our effect can show through.
                        imgview.setClip(null);

                        // apply a shadow effect.
                        imgview.setEffect(new DropShadow(20, Color.BLACK));

                        // store the rounded image in the imageView.
                        imgview.setImage(image);

                        setText("Description :" + e.getDescription());

                        setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                        // setAlignment(Pos.CENTER);
                    }

                }

            };
            return cell;
        });
        listviewItemOffer.setItems(FXCollections.observableArrayList(
                getItemsByCategory(CategoryTableAction.getSelectionModel().getSelectedItem().getName())));
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    @FXML
    void refreshtableItemOffer(ActionEvent event) {
        selectDataItemOffer();
        afficherItemOffer();
    }

    private void selectWithService() {
        Service<Integer> service = new Service<Integer>() {
            @Override
            protected Task<Integer> createTask() {
                selectData();
                selectDataAlert();
                selectDataItemImport();
                selectDataForCategories();
                selectDataItemOffer();
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

    private void selectDataItemOffer() {
        if (listDataItemOffer == null) {
            listDataItemOffer = FXCollections.observableArrayList(findAllItemOffers());
        } else {
            listDataItemOffer.clear();
            listDataItemOffer.addAll(findAllItemOffers());
        }

        tableDataItemOffer.setItems(listDataItemOffer);
    }

    private void selectDataForCategories() {
        if (listDataCategory == null) {
            listDataCategory = FXCollections.observableArrayList(findAllCategories());
        } else {
            listDataCategory.clear();
            listDataCategory.addAll(findAllCategories());
        }

        CategoryTableAction.setItems(listDataCategory);
    }

    private void selectDataItemImport() {
        if (listItemImports == null) {
            listItemImports = FXCollections.observableArrayList(findAllItemRequests());
        } else {
            listItemImports.clear();
            listItemImports.addAll(findAllItemRequests());
        }

        tableDataImport.setItems(listItemImports);
    }

    @FXML
    void barcodeReleased(KeyEvent event) {
        ItemVerfication.verifyDoesNotContainLetterForBarcode(txtBarcode);

    }

    @FXML
    void txtSellingReleased(KeyEvent event) {
        if (!ItemVerfication.verifyDoesNotContainLetter(txtSelling)) {
            playSound("error.mp3");
            Config2.dialog(Alert.AlertType.ERROR, "Please, Fill With a valid Number");
        }
    }

    @FXML
    void txtBuyingReleased(KeyEvent event) {
        if (!ItemVerfication.verifyDoesNotContainLetter(txtBuying)) {
            playSound("error.mp3");
            Config2.dialog(Alert.AlertType.ERROR, "Please, Fill With a valid Number");
        }
    }

    @FXML
    void aksiQuantity(KeyEvent event) {
        if (!ItemVerfication.verifyDoesNotContainLetter(txtQuantity)) {
            playSound("error.mp3");
            Config2.dialog(Alert.AlertType.ERROR, "Please, Fill With a valid Number");
        }
    }

    private void selectDataAlert() {
        boolean condition = false;
        boolean condition2 = false;
        listDataAlert = FXCollections.observableArrayList();
        for (Item i : findAll()) {

            if (i.getMinimumQuanity() != null && i.getQuantity() < i.getMinimumQuanity()) {
                condition = true;
                i.setAlertItemType(AlertItemType.Quantity);
                ItemUtil.saveOrUpdateItemWithCategoryAndSupplier(i, i.getCategory(), i.getSupplier(),
                        LoginController.getLoggedUser());
                listDataAlert.add(i);
            }

            if (i.getExpirationDate() != null) {
                Date d1 = i.getExpirationDate();
                Date d2 = new Date();
                long diff = d1.getTime() - d2.getTime();
                long realDifferenceInDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                if (realDifferenceInDays < 7) {
                    condition2 = true;
                    i.setAlertItemType(AlertItemType.ExperationDate);
                    ItemUtil.saveOrUpdateItemWithCategoryAndSupplier(i, i.getCategory(), i.getSupplier(),
                            LoginController.getLoggedUser());
                    listDataAlert.add(i);
                }
            }
        }
        if (condition) {
            playSound("alert.mp3");
            buildNotificationItem("Warning !", "Item quantity is lower than what is recommand, press to fix issue",
                    Pos.BOTTOM_RIGHT, e -> {
                        afficherAlert();
                        clear();
                        SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
                        selectionModel.select(2);
                        paneTabel.setOpacity(0);
                        tableDataAlert.setItems(listDataAlert);
                        new FadeInUpTransition(TabPane).play();
                    });
        }
        if (condition2) {
            playSound("alert.mp3");
            buildNotificationItem("Warning!", "Be careful some items' expiration date is close", Pos.TOP_RIGHT, e -> {
                System.out.println("you're right !!!");
                afficherAlert();
                clear();
                SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
                selectionModel.select(2);
                paneTabel.setOpacity(0);
                tableDataAlert.setItems(listDataAlert);
                new FadeInUpTransition(TabPane).play();
            });
        }

    }

    private int addItemRequest(ItemRequest i) {
        try {
            ctx = new InitialContext();
            itemRequestService = (ItemRequestServiceRemote) ctx.lookup(jndiNameItemRequest);
            return itemRequestService.addItemRequestGetId(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong in addItemRequest");
        }
        return 0;
    }

    private void addItemOffer(ItemOffer i) {
        try {
            ctx = new InitialContext();
            itemOfferService = (ItemOfferServiceRemote) ctx.lookup(jndiNameItemOffer);
            itemOfferService.update(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong in addItemOffer");
        }
    }

    private void deleteItemOffer(ItemOffer i) {
        try {
            ctx = new InitialContext();
            itemOfferService = (ItemOfferServiceRemote) ctx.lookup(jndiNameItemOffer);
            itemOfferService.delete(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong in addItemOffer");
        }
    }

    private void deleteCategory(Category c) {
        try {
            ctx = new InitialContext();
            categorieService = (CategoryServiceRemote) ctx.lookup(jndiNameCategory);
            categorieService.delete(c);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
    }

    private void updateItemRequest(ItemRequest i) {
        try {
            ctx = new InitialContext();
            itemRequestService = (ItemRequestServiceRemote) ctx.lookup(jndiNameItemRequest);
            itemRequestService.update(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong in updateItemRequest");
        }
    }

    private ItemRequest ItemRequestExists(ItemRequest ir) {
        try {
            ctx = new InitialContext();
            itemRequestService = (ItemRequestServiceRemote) ctx.lookup(jndiNameItemRequest);
            return itemRequestService.iRExistforImortDirect(ir.getItem().getId());
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong ItemRequestExists");
        }
        return null;
    }

    private ItemRequest getItemRequestByItemId(int i) {
        try {
            ctx = new InitialContext();
            itemRequestService = (ItemRequestServiceRemote) ctx.lookup(jndiNameItemRequest);
            return itemRequestService.iRExist(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong getItemRequestByItemId");
            e2.printStackTrace();
        }
        return null;
    }

    private Item findItem(int i) {
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            return itemService.find(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong in finditem");
        }
        return null;
    }

    void deleteItem(Item i) {
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            itemService.deleteItemWithCategoryAndSupplier(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    void deleteItemRequest(ItemRequest i) {
        try {
            ctx = new InitialContext();
            itemRequestService = (ItemRequestServiceRemote) ctx.lookup(jndiNameItemRequest);
            itemRequestService.delete(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong in deleteItemRequest");
        }
    }

    void deleteManyItemRequests(int i) {
        try {
            ctx = new InitialContext();
            itemRequestService = (ItemRequestServiceRemote) ctx.lookup(jndiNameItemRequest);
            itemRequestService.deleteManyItemRequests(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong in deleteManyItemRequests");
        }
    }

    void deleteManyItemOffers(int i) {
        try {
            ctx = new InitialContext();
            itemOfferService = (ItemOfferServiceRemote) ctx.lookup(jndiNameItemOffer);
            itemOfferService.deleteItemOffersByItemId(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong in deleteManyItemOffers");
        }
    }

    void afficherCategories() {
        Config2.setModelColumn(colCategoryName, "name");
        Config2.setModelColumn(colCategoryDescription, "description");
        colCategoryAction.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCellForCategory();
            }

        });
    }

    void afficher() {
        Config2.setModelColumn(colItemName, "name");
        Config2.setModelColumn(colItemType, "type");
        Config2.setModelColumn(colItemBarcode, "barcode");
        // Config2.setModelColumn(colItemQuantity, "quantity");

        

        expirationDate.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Item, String> param) {
                        String dd = "";
                        try {
                            dd = convert(param.getValue().getExpirationDate());
                        } catch (NullPointerException e) {
                            System.out.println("this item doesnt have expiration date, excception is catched");
                        }
                        return new SimpleStringProperty(dd);
                    }
                });

        expirationDate.setCellFactory(new Callback<TableColumn<Item, String>, TableCell<Item, String>>() {

            @Override
            public TableCell<Item, String> call(TableColumn<Item, String> param) {
                return new TableCell<Item, String>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    protected void updateItem(String i, boolean empty) {
                        super.updateItem(i, empty);
                        TableRow<Item> currentRow = getTableRow();
                        if (!empty) {
                            TableView<Item> tv = getTableView();
                            try {
                                setText(i);
                            } catch (Exception e1) {
                                System.out.println("exception was catched");
                            }
                            if (tv != null) {
                                try {
                                    Date d1 = convertForAfficher(i);
                                    Date d2 = new Date();
                                    long diff = d1.getTime() - d2.getTime();
                                    long realDifferenceInDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                                    System.out.println("/////////////////////////////");
                                    System.out.println(i);
                                    System.out.println("//////////////////////////////");
                                    if (realDifferenceInDays < 7) {
                                        // setStyle("-fx-background-color: red");
                                        currentRow.setStyle("-fx-background-color:darkgoldenrod");
                                    }
                                } catch (NullPointerException e) {
                                    // TODO Auto-generated catch block
                                    // e.printStackTrace();
                                } catch (NumberFormatException e1) {
                                    // TODO Auto-generated catch block
                                    // e.printStackTrace();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    System.out.println("exception general was catched");
                                }
                            }
                        }
                    }
                };
            }
        });

        colItemQuantity.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Item, String> param) {
                        try {
                            if (Integer.toString(param.getValue().getQuantity()) != null) {
                                return new SimpleStringProperty(Integer.toString(param.getValue().getQuantity()));
                            }
                        } catch (NullPointerException e) {
                            // TODO Auto-generated catch block
                            // e.printStackTrace();
                            System.out.println("exception catched !!!!!!!!!!!!!");
                        }
                        return new SimpleStringProperty("");
                    }
                });

        colItemQuantity.setCellFactory(new Callback<TableColumn<Item, String>, TableCell<Item, String>>() {
            @Override
            public TableCell<Item, String> call(TableColumn<Item, String> param) {
                return new TableCell<Item, String>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    protected void updateItem(String i, boolean empty) {
                        super.updateItem(i, empty);
                        TableRow<Item> currentRow = getTableRow();
                        if (!empty) {
                            TableView<Item> tv = getTableView();
                            try {
                                setText(i);
                            } catch (Exception e1) {
                                System.out.println("exception was catched");
                            }
                            if (tv != null) {
                                try {
                                    if (Integer.parseInt(i) < tv.getItems().get(getTableRow().getIndex())
                                            .getMinimumQuanity()) {
                                        // setStyle("-fx-background-color: red");
                                        currentRow.setStyle("-fx-background-color:coral");
                                    }
                                } catch (NullPointerException e) {
                                    // TODO Auto-generated catch block
                                    // e.printStackTrace();
                                } catch (NumberFormatException e1) {
                                    // TODO Auto-generated catch block
                                    // e.printStackTrace();
                                }
                            }
                        }
                    }
                };
            }
        });

        colItemCategory.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Item, String> param) {
                        return new SimpleStringProperty(param.getValue().getCategory().getName());
                    }
                });

        colItemSupplier.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Item, String> param) {
                        return new SimpleStringProperty(param.getValue().getSupplier().getName());
                    }
                });

        colAction.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCell();
            }

        });

        colItemImage.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Item, String> param) {
                        return new SimpleStringProperty(param.getValue().getUser().getLogin());
                    }
                });
        
       

        
    }

    void afficherAlert() {
        // listData = FXCollections.observableArrayList();
        Config2.setModelColumn(colItemNameAlert, "name");
        Config2.setModelColumn(colItemExpirationDate, "expirationDate");
        Config2.setModelColumn(colItemQuantityAlert, "quantity");
        Config2.setModelColumn(colItemBarcodeAlert, "barcode");
        Config2.setModelColumn(colAlerType, "alertItemType");

        colItemQuantityAlert.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item,String>, ObservableValue<String>>() {
            
            @Override
            public ObservableValue<String> call(CellDataFeatures<Item, String> param) {
                try {
                    if (Integer.toString(param.getValue().getQuantity()) != null) {
                        return new SimpleStringProperty(Integer.toString(param.getValue().getQuantity()));
                    }
                } catch (NullPointerException e) {
                    // TODO Auto-generated catch block
                    // e.printStackTrace();
                    System.out.println("exception catched !!!!!!!!!!!!!");
                }
                return new SimpleStringProperty("");
            }
        });
        
        colItemQuantityAlert.setCellFactory(new Callback<TableColumn<Item, String>, TableCell<Item, String>>() {
            @Override
            public TableCell<Item, String> call(TableColumn<Item, String> param) {
                return new TableCell<Item, String>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    protected void updateItem(String i, boolean empty) {
                        super.updateItem(i, empty);
                        TableRow<Item> currentRow = getTableRow();
                        if (!empty) {
                            TableView<Item> tv = getTableView();
                            try {
                                setText(i);
                            } catch (Exception e1) {
                                System.out.println("exception was catched");
                            }
                            if (tv != null) {
                                try {
                                    if (Integer.parseInt(i) < tv.getItems().get(getTableRow().getIndex())
                                            .getMinimumQuanity()) {
                                         setStyle("-fx-background-color: coral");
//                                        currentRow.setStyle("-fx-background-color:coral");
                                    }
                                } catch (NullPointerException e) {
                                    // TODO Auto-generated catch block
                                    // e.printStackTrace();
                                } catch (NumberFormatException e1) {
                                    // TODO Auto-generated catch block
                                    // e.printStackTrace();
                                }
                            }
                        }
                    }
                };
            }
        });
        
        colItemExpirationDate.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Item, String> param) {
                        String dd = "";
                        try {
                            dd = convert(param.getValue().getExpirationDate());
                        } catch (NullPointerException e) {
                            System.out.println("this item doesnt have expiration date, excception is catched");
                        }
                        return new SimpleStringProperty(dd);
                    }
                });
        
        colItemExpirationDate.setCellFactory(new Callback<TableColumn<Item, String>, TableCell<Item, String>>() {

            @Override
            public TableCell<Item, String> call(TableColumn<Item, String> param) {
                return new TableCell<Item, String>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    protected void updateItem(String i, boolean empty) {
                        super.updateItem(i, empty);
                        TableRow<Item> currentRow = getTableRow();
                        if (!empty) {
                            TableView<Item> tv = getTableView();
                            try {
                                setText(i);
                            } catch (Exception e1) {
                                System.out.println("exception was catched");
                            }
                            if (tv != null) {
                                try {
                                    Date d1 = convertForAfficher(i);
                                    Date d2 = new Date();
                                    long diff = d1.getTime() - d2.getTime();
                                    long realDifferenceInDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                                    System.out.println("/////////////////////////////");
                                    System.out.println(i);
                                    System.out.println("//////////////////////////////");
                                    if (realDifferenceInDays < 7) {
                                         setStyle("-fx-background-color: darkgoldenrod");
//                                        currentRow.setStyle("-fx-background-color:darkgoldenrod");
                                    }
                                } catch (NullPointerException e) {
                                    // TODO Auto-generated catch block
                                    // e.printStackTrace();
                                } catch (NumberFormatException e1) {
                                    // TODO Auto-generated catch block
                                    // e.printStackTrace();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    System.out.println("exception general was catched");
                                }
                            }
                        }
                    }
                };
            }
        });
        
        colItemCategoryAlert.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Item, String> param) {
                        return new SimpleStringProperty(param.getValue().getCategory().getName());
                    }
                });

        colItemSupplierAlert.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Item, String> param) {
                        return new SimpleStringProperty(param.getValue().getSupplier().getName());
                    }
                });

    }

    private void afficherItemOffer() {
        // Config2.setModelColumn(colItemOfferPrice, "buyingPrice");
        colitemOfferName.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemOffer, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemOffer, String> param) {
                        return new SimpleStringProperty(param.getValue().getItem().getName());
                    }
                });
        colItemOfferDescription.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemOffer, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemOffer, String> param) {
                        return new SimpleStringProperty(param.getValue().getItem().getDescription());
                    }
                });
        colItemOfferCategory.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemOffer, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemOffer, String> param) {
                        return new SimpleStringProperty(param.getValue().getItem().getCategory().getName());
                    }
                });
        colItemOfferType.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemOffer, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemOffer, String> param) {
                        return new SimpleStringProperty(param.getValue().getItem().getType().toString());
                    }
                });
        colItemOfferBarcode.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemOffer, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemOffer, String> param) {
                        String s = Integer.toString(param.getValue().getItem().getBarcode());
                        return new SimpleStringProperty(s);
                    }
                });
        colItemOfferSupplier.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemOffer, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemOffer, String> param) {
                        return new SimpleStringProperty(param.getValue().getSupplier().getName());
                    }
                });

        colItemOfferActions.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCellForItemOffer();
            }

        });

        colItemOfferPrice.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemOffer, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemOffer, String> param) {
                        return new SimpleStringProperty(Integer.toString(param.getValue().getBuyingPrice()));
                    }
                });

    }

    @FXML
    void aksiCloseNewStatisticPane(ActionEvent event) {
        newStatisticPane.setOpacity(0);
        newStatisticPane.toBack();
        paneTabel.toFront();

    }

    private void afficherItemOfferTestVersion() {
        // Config2.setModelColumn(colItemOfferPrice, "buyingPrice");
        colitemOfferName.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemOffer, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemOffer, String> param) {
                        return new SimpleStringProperty(param.getValue().getItem().getName());
                    }
                });
        colItemOfferDescription.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemOffer, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemOffer, String> param) {
                        return new SimpleStringProperty(param.getValue().getItem().getDescription());
                    }
                });
        colItemOfferCategory.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemOffer, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemOffer, String> param) {
                        return new SimpleStringProperty(param.getValue().getItem().getCategory().getName());
                    }
                });
        colItemOfferType.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemOffer, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemOffer, String> param) {
                        return new SimpleStringProperty(param.getValue().getItem().getType().toString());
                    }
                });
        colItemOfferBarcode.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemOffer, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemOffer, String> param) {
                        String s = Integer.toString(param.getValue().getItem().getBarcode());
                        return new SimpleStringProperty(s);
                    }
                });
        colItemOfferSupplier.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemOffer, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemOffer, String> param) {
                        return new SimpleStringProperty(param.getValue().getSupplier().getName());
                    }
                });

        colItemOfferActions.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCellForItemOffer();
            }

        });

        colItemOfferPrice.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemOffer, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemOffer, String> param) {
                        // TODO Auto-generated method stub
                        return new SimpleStringProperty(Integer.toString(param.getValue().getItem().getId()));
                    }
                });

        colItemOfferPrice.setCellFactory(new Callback<TableColumn<ItemOffer, String>, TableCell<ItemOffer, String>>() {
            @Override
            public TableCell<ItemOffer, String> call(TableColumn<ItemOffer, String> param) {
                return new TableCell<ItemOffer, String>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    protected void updateItem(String i, boolean empty) {
                        super.updateItem(i, empty);
                        TableRow<ItemOffer> currentRow = getTableRow();
                        TableView<ItemOffer> tv = getTableView();
                        if (!empty) {
                            try {
                                if (tv.getItems().get(getTableRow().getIndex())
                                        .getId() == findBestPrice(Integer.parseInt(i)).getId()) {
                                    currentRow.setStyle("-fx-background-color:lightgreen");
                                }
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                System.out.println("exception of array out of bounds");
                            }
                        }
                        try {
                            setText(Integer.toString(tv.getItems().get(getTableRow().getIndex()).getBuyingPrice()));
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            System.out.println("exception of array out of bounds");
                        }
                    }
                };
            }
        });
    }

    private void afficherItemImport() {
        Config2.setModelColumn(colImportItemQuantity, "quantityNeeded");

        colImportItemName.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemRequest, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemRequest, String> param) {
                        return new SimpleStringProperty(param.getValue().getItem().getName().toString());
                    }
                });

        colImportItemCategory.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemRequest, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemRequest, String> param) {
                        return new SimpleStringProperty(param.getValue().getItem().getCategory().getName());
                    }
                });

        colImportItemExpirationDate.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemRequest, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemRequest, String> param) {
                        String dd = "";
                        try {
                            dd = convert(param.getValue().getItem().getExpirationDate());
                        } catch (NullPointerException e) {
                            System.out.println("this item doesnt have expiration date, excception is catched");
                        }
                        return new SimpleStringProperty(dd);
                    }
                });

        colImportItemBarcode.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemRequest, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemRequest, String> param) {
                        String s = Integer.toString(param.getValue().getItem().getBarcode());
                        return new SimpleStringProperty(s);
                    }
                });

        colImportItemSupplier.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<ItemRequest, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ItemRequest, String> param) {
                        // TODO Auto-generated method stub
                        return new SimpleStringProperty(param.getValue().getItem().getSupplier().getName());
                    }
                });

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

    private ItemOffer findBestPrice(int i) {
        ItemOffer iO = new ItemOffer();
        try {
            ctx = new InitialContext();
            itemOfferService = (ItemOfferServiceRemote) ctx.lookup(jndiNameItemOffer);
            iO = itemOfferService.getItemOfferBestItemPrice(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return iO;
    }

    private List<ItemOffer> findByItem(int i) {
        List<ItemOffer> items = new ArrayList<>();
        try {
            ctx = new InitialContext();
            itemOfferService = (ItemOfferServiceRemote) ctx.lookup(jndiNameItemOffer);
            items = itemOfferService.getItemOffersByItem(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return items;
    }

    private List<Item> getItemsByCategory(String s) {
        List<Item> items = new ArrayList<>();
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            items = itemService.ListStock(s);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return items;
    }

    private List<Category> findAllCategories() {
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

    @FXML
    void aksikilkTableItemOffer(MouseEvent event) {
        try {
            ItemOffer iO = tableDataItemOffer.getSelectionModel().getSelectedItem();
            cbItemOfferItem.setValue(iO.getItem());
            cbItemOfferSupplier.setValue(iO.getSupplier());
            txtItemOfferPrice.setText(Integer.toString(iO.getBuyingPrice()));
        } catch (NullPointerException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            System.out.println("exception was catched aksikilkTableItemOffer");
        }
    }

    private List<Contact> findAllSuppliers() {
        List<Contact> suppliers = new ArrayList<>();
        try {
            ctx = new InitialContext();
            contactService = (ContactServiceRemote) ctx.lookup(jndiNameSupplier);
            suppliers = contactService.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return suppliers;
    }

    private List<ItemRequest> findAllItemRequests() {
        List<ItemRequest> itemRequests = new ArrayList<>();
        try {
            ctx = new InitialContext();
            itemRequestService = (ItemRequestServiceRemote) ctx.lookup(jndiNameItemRequest);
            itemRequests = itemRequestService.findAllNotDone();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong in findAllItemRequests");
        }
        return itemRequests;
    }

    private List<ItemOffer> findAllItemOffers() {
        List<ItemOffer> itemOffers = new ArrayList<>();
        try {
            ctx = new InitialContext();
            itemOfferService = (ItemOfferServiceRemote) ctx.lookup(jndiNameItemOffer);
            itemOffers = itemOfferService.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return itemOffers;
    }

    public static Date convert(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = null;
        try {
            d1 = sdf.parse(date);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("parse exception  or null");
        }
        return d1;
    }

    public static Date convertForAfficher(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;
        try {
            d1 = sdf.parse(date);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("parse exception  or null");
        }
        return d1;
    }

    void buildNotificationItem(String title, String text, Pos position, EventHandler<ActionEvent> e) {
        Notifications notificationBuilder = Notifications.create().title(title).text(text).graphic(null)
                .hideAfter(Duration.seconds(10)).position(position).onAction(e);
        notificationBuilder.showWarning();
    }

    private void playSound(String s) {
        Media videoFile = new Media("file:///C:/wamp64/www/imagesAmine/snd/" + s);
        mediaplayer = new MediaPlayer(videoFile);
        mediaplayer.play();
    }

    private class ButtonCell extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("Delete");
        final Hyperlink cellButtonEdit = new Hyperlink("Edit");
        final HBox hb = new HBox(cellButtonDelete, cellButtonEdit);

        public ButtonCell() {
            hb.setSpacing(4);
            cellButtonDelete.setOnAction((ActionEvent t) -> {
                status = 1;
                int row = getTableRow().getIndex();
                tableData.getSelectionModel().select(row);
                aksiKlikTableData(null);
                Toolkit.getDefaultToolkit().beep();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Delete Data ?");
                alert.initStyle(StageStyle.UTILITY);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Item i = tableData.getSelectionModel().getSelectedItem();
                    System.out.println(i.getId());
                    // if (getItemRequestByItemId(i.getId()) != null) {
                    // ItemRequest ir = getItemRequestByItemId(i.getId());
                    // deleteItemRequest(ir);
                    deleteManyItemRequests(i.getId());
                    deleteManyItemOffers(i.getId());
                    System.out.println("hi my name is jeff");
                    // } else {
                    System.out.println("hi my name is jefe");
                    deleteItem(i);
                    // }
                    clear();
                    selectData();
                    afficher();
                } else {
                    clear();
                    selectData();
                }
                status = 0;
            });

            cellButtonEdit.setOnAction(t -> {
                status = 1;
                int row = getTableRow().getIndex();
                tableData.getSelectionModel().select(row);
                clear();
                aksiKlikTableData(null);
                Item i = tableData.getSelectionModel().getSelectedItem();
                System.out.println("+++++" + i.getPicture());
                txtId.setText(Integer.toString(i.getId()));
                paneTabel.setOpacity(0);
                SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
                selectionModel.select(0);
                new FadeInUpTransition(TabPane).play();
                status = 0;
            });

            // Action when the button is pressed
        }

        // Display button if the row is not empty
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

    public static String convert(Date d) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String text = df.format(d);
        return text;
    }

    void filerItemList(String oldValue, String newValue) {
        ObservableList<Item> filteredList = FXCollections.observableArrayList();
        if (txtsearchItem.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            listData.clear();
            listData.addAll(findAll());
            tableData.setItems(listData);
        } else {
            newValue = newValue.toUpperCase();
            for (Item i : listData) {
                if (i.getName().toUpperCase().contains(newValue)) {
                    filteredList.add(i);
                } else if (Integer.toString(i.getBarcode()).contains(newValue)) {
                    filteredList.add(i);
                }
            }
            tableData.setItems(filteredList);
        }
    }

    void filerItemListForItemImport(String oldValue, String newValue) {
        ObservableList<Item> filteredList = FXCollections.observableArrayList();
        if (txtsearchItem.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            listData.clear();
            listData.addAll(findAll());
            tableData.setItems(listData);
        } else {
            newValue = newValue.toUpperCase();
            for (Item i : listData) {
                if (i.getName().toUpperCase().contains(newValue)) {
                    filteredList.add(i);
                } else if (Integer.toString(i.getBarcode()).contains(newValue)) {
                    filteredList.add(i);
                }
            }
            if (filteredList.size() == 1) {
                Item i = filteredList.get(0);
                System.out.println(i);
                ItemRequest iR = new ItemRequest();
                iR.setItem(i);
                iR.setItemRequestStatus(ItemRequestStatus.NOTDONE);

                try {
                    if (ItemRequestExists(iR) == null) {
                        // if (ItemRequestExists(iR) == null ||
                        // tableDataImport.getItems().indexOf(iR)==-1 ) {
                        playSound("bip.mp3");
                        itemRId = addItemRequest(iR);
                        tableDataImport.getItems().add(iR);
                    }
                } catch (Exception e) {
                    System.out.println("exception !!!!!!!!");
                }
                // }
                afficherItemImport();
                // System.out.println(tableDataImport.getItems());
                // for (ItemRequest iR1 : tableDataImport.getItems()) {
                // if (!iR1.getItem().getName().equals(iR.getItem().getName())) {
                // tableDataImport.getItems().clear();
                // if (tableDataImport.getItems().contains(iR)) {
                // System.out.println(tableDataImport.getItems().indexOf(iR));
                // }else {
                // System.out.println("it does not contains");
                // System.out.println(tableDataImport.getItems().indexOf(iR));
                //
                // tableDataImport.getItems().add(iR);
                // }

                // }
                // }

            }
        }
    }

    public void envoyer(String mail, String subject, String text) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mrayhiamine@gmail.com", "Amine50852234");
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mrayhiamine@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);

        } catch (MessagingException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failure to send");
            alert.setHeaderText("Please check your informations !!");

            alert.showAndWait();

        }

    }

    private GridPane createEditor(TableRowExpanderColumn.TableRowDataFeatures<ItemRequest> param) {

        GridPane editor = new GridPane();
        editor.setPadding(new Insets(10));
        editor.setHgap(10);
        editor.setVgap(5);

        ItemRequest ir = ItemRequestExists(param.getValue());
        try {
            if (ir.getId() != null) {
                System.out.println("///////////////////////////////////");
                System.out.println(ir.getId());
            } else {
                System.out.println("yes its null");
            }
        } catch (NullPointerException e4) {
            // TODO Auto-generated catch block
            // e4.printStackTrace();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }

        try {
            String dated = ir.getItem().getExpirationDate().toString();
            LocalDate date = LocalDate.parse(dated);
            date.plus(5, java.time.temporal.ChronoUnit.DAYS);

            ddd.setValue(date);
        } catch (NullPointerException e) {
        }

        ComboBox<Contact> itemsuppliertext = new ComboBox();
        itemsuppliertext.getItems().addAll(filterSupplierList());
        itemsuppliertext.setValue(ir.getItem().getSupplier());
        TextField itemquantity = new TextField();
        if (ir.getQuantityNeeded() != null) {
            itemquantity.setText(Integer.toString(ir.getQuantityNeeded()));
        } else {
            itemquantity.setText("0");
        }
        editor.addRow(0, new Label("item supplier"), itemsuppliertext);
        editor.addRow(1, new Label("item quantity"), itemquantity);
        if (ir.getItem().getShowAlertOnExpirationDate()) {
            editor.addRow(2, new Label("item expiration date"), ddd);
        }

        Button save = new Button("Save");
        save.setOnAction(e -> {
            Item it = findItem(ir.getItem().getId());
            it.setSupplier(itemsuppliertext.getValue());
            try {
                it.setQuantity(it.getQuantity() + Integer.parseInt(itemquantity.getText()));
            } catch (NullPointerException e3) {
            }
            try {
                it.setExpirationDate(convert(ddd.getEditor().getText()));
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
            ir.setSupplier(itemsuppliertext.getValue());
            ir.setItemRequestStatus(ItemRequestStatus.DONE);
            // ir.setId(itemRId);

            try {
                System.out.println(ir.getId());
            } catch (Exception e2) {
            }

            updateItemRequest(ir);
            it.setAlertItemType(null);
            ItemUtil.saveOrUpdateItemWithCategoryAndSupplier(it, it.getCategory(), it.getSupplier(),
                    LoginController.getLoggedUser());
            Toolkit.getDefaultToolkit().beep();
            buildNotificationItem("Sending Mail", "please wait", Pos.BOTTOM_RIGHT, null);
            Config2.dialog(Alert.AlertType.INFORMATION, "Success Save Data..");
            envoyer(it.getSupplier().getEmail(), "Imort", "We would like to import "
                    + Integer.parseInt(itemquantity.getText()) + " of " + it.getName() + " ");
            buildNotificationItem("Succes", "email was successfully sent to " + it.getSupplier().getName(),
                    Pos.BOTTOM_RIGHT, null);
            TabPane.setOpacity(0);
            selectWithService();
            afficher();
        });

        Button cancel = new Button("Cancel");
        cancel.setOnAction(e1 -> param.toggleExpanded());
        ir.setItemRequestStatus(ItemRequestStatus.DONE);
        editor.addRow(3, save, cancel);

        return editor;

    }

    private class ButtonCellForCategory extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("Delete");

        final HBox hb = new HBox(cellButtonDelete);

        public ButtonCellForCategory() {
            hb.setSpacing(4);
            cellButtonDelete.setOnAction((ActionEvent t) -> {
                int row = getTableRow().getIndex();
                CategoryTableAction.getSelectionModel().select(row);
                Toolkit.getDefaultToolkit().beep();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Delete Data ?");
                alert.initStyle(StageStyle.UTILITY);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Category c = CategoryTableAction.getSelectionModel().getSelectedItem();
                    for (Item i : c.getItems()) {
                        deleteManyItemRequests(i.getId());
                        deleteManyItemOffers(i.getId());
                    }
                    deleteCategory(c);
                    clear();
                    selectDataForCategories();
                    selectData();
                    afficher();
                } else {
                    clear();
                    selectDataForCategories();
                }
            });

            // Action when the button is pressed
        }

        // Display button if the row is not empty
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

    private class ButtonCellForItemOffer extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("Delete");
        final Hyperlink cellButtonEdit = new Hyperlink("Edit");
        final HBox hb = new HBox(cellButtonDelete, cellButtonEdit);

        public ButtonCellForItemOffer() {
            hb.setSpacing(4);
            cellButtonDelete.setOnAction((ActionEvent t) -> {
                int row = getTableRow().getIndex();
                tableDataItemOffer.getSelectionModel().select(row);
                Toolkit.getDefaultToolkit().beep();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Delete Data ?");
                alert.initStyle(StageStyle.UTILITY);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    ItemOffer c = tableDataItemOffer.getSelectionModel().getSelectedItem();
                    deleteItemOffer(c);
                    clear();
                    selectDataItemOffer();
                } else {
                    clear();
                    selectDataItemOffer();
                }
            });

            cellButtonEdit.setOnAction(t -> {
                status = 1;
                int row = getTableRow().getIndex();
                tableDataItemOffer.getSelectionModel().select(row);
                clear();
                aksikilkTableItemOffer(null);
                ItemOffer iO = tableDataItemOffer.getSelectionModel().getSelectedItem();
                txtIdItemOffer.setText(Integer.toString(iO.getId()));
                addItemOfferPane.toFront();
                new FadeInUpTransition(addItemOfferPane).play();
            });

            // Action when the button is pressed
        }

        // Display button if the row is not empty
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

}
