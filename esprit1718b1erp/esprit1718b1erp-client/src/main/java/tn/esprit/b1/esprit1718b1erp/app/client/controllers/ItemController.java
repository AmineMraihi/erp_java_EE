package tn.esprit.b1.esprit1718b1erp.app.client.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.RejectedExecutionException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.controlsfx.control.Notifications;
import org.controlsfx.dialog.ExceptionDialog;

//import org.controlsfx.control.Notifications;

import com.sun.prism.impl.Disposer.Record;

import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.scene.control.Alert;

import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeOutUpTransition;
import tn.esprit.b1.esprit1718b1erp.app.client.util.ItemVerfication;
import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.ItemRequest;
import tn.esprit.b1.esprit1718b1erp.entities.Item_Type;
import tn.esprit.b1.esprit1718b1erp.services.amine.CategoryServiceRemote;
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
    private TableColumn<Item, String> colItemName;

    @FXML
    private TableColumn<Item, String> colItemCategory;

    @FXML
    private TableColumn<Item, String> colItemType;

    @FXML
    private TableColumn<Item, Integer> colItemQuantity;

    @FXML
    private TableColumn<Item, Integer> colItemBarcode;

    @FXML
    private TableColumn<Item, String> colItemSupplier;
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
    private AnchorPane addCategoryPane;

    @FXML
    private TextField txtId1;

    @FXML
    private Button close;

    @FXML
    private TextField txtCategoryName;

    @FXML
    private TextArea txtDescriptionCategory;

    @FXML
    private Button btnAddCategory;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtSelling;

    @FXML
    private Tab ItemAlertMenu;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<Item> tableDataAlert;

    @FXML
    private TableColumn<String, String> colAlerType;

    @FXML
    private TableColumn<Item, String> colItemNameAlert;

    @FXML
    private TableColumn<Item, String> colItemCategoryAlert;

    @FXML
    private TableColumn<Item, Date> colItemExpirationDate;

    @FXML
    private TableColumn<Item, Integer> colItemQuantityAlert;

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
    private AnchorPane addSupplierPane;

    @FXML
    private TextField txtId11;

    @FXML
    private Label QuantityLabel;

    @FXML
    private TextField txtSupplierName;

    @FXML
    private Button btnAddSupplier;

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
    private CheckBox cbLowQuantity;

    @FXML
    private CheckBox cbLowExpirationDate;

    @FXML
    private DatePicker txtExpirationDate;

    boolean checkAlertOnQuantity, selectimage;

    private ObservableList<Item> listData, listDataAlert;
    private ObservableList<ItemRequest> listItemImports;
    Config2 con = new Config2();
    private InitialContext ctx = null;
    Item iPic;

    private final String jndiNameItem = "esprit1718b1erp-ear/esprit1718b1erp-service/ItemService!tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote";
    private final String jndiNameCategory = "esprit1718b1erp-ear/esprit1718b1erp-service/CategoryService!tn.esprit.b1.esprit1718b1erp.services.amine.CategoryServiceRemote";
    private final String jndiNameSupplier = "esprit1718b1erp-ear/esprit1718b1erp-service/ContactService!tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote";
    private final String jndiNameItemRequest = "esprit1718b1erp-ear/esprit1718b1erp-service/ItemRequestService!tn.esprit.b1.esprit1718b1erp.services.amine.ItemRequestServiceRemote";

    ItemServiceRemote itemService;
    CategoryServiceRemote categorieService;
    ContactServiceRemote contactService;
    ItemRequestServiceRemote itemRequestService;

    String getImageUrl, imgName;

    Integer status;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Platform.runLater(() -> {
            afficher();
            selectWithService();
            cbCategory.getItems().addAll(findAllCategories());
            cbCurrency.getItems().addAll("EUR", "USD", "CHF", "GBP", "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "AUD",
                    "AWG", "AZN");
            status = 0;
            cbService.setOnAction(e -> {
                QuantityLabel.setOpacity(0);
                txtQuantity.setOpacity(0);
            });

            cbOther.setOnAction(e -> {
                QuantityLabel.setOpacity(1);
                txtQuantity.setOpacity(1);
            });

            cbProduct.setOnAction(e -> {
                QuantityLabel.setOpacity(1);
                txtQuantity.setOpacity(1);
            });

            afficherAlert();
            colAlerType.setCellValueFactory(c -> new SimpleStringProperty("quantity"));
            tableDataAlert.setItems(listDataAlert);
        });

    }

    @FXML
    void addSupplierPlusButton(MouseEvent event) {
        addSupplierPane.toFront();
        new FadeInUpTransition(addSupplierPane).play();
    }

    @FXML
    void aksiAddSupplier(ActionEvent event) {
        Contact contact = new Contact();
        contact.setFirst_name(txtSupplierName.getText());
        contact.setCountry(null);
        contact.setLast_name(txtCitySupplier.getText());
        contact.setPhone(Integer.parseInt(txtSupplierPhone.getText()));
        contact.setEmail(txtSupplierEmail.getText());
        contact.setWebsite(txtSupplierWebsite.getText());
        addSupplier(contact);
        cbSupplier.getItems().clear();
        cbSupplier.getItems().addAll(findAllSuppliers());
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
        addcategory(category);
        cbCategory.getItems().clear();
        cbCategory.getItems().addAll(findAllCategories());
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
                txtItemName.setText(item.getName());
                txtDescription.setText(item.getDescription());
                cbCategory.setValue(item.getCategory());
                cbSupplier.setValue(item.getSupplier());
                switch (item.getType().toString()) {
                case "PRODUCT":
                    cbProduct.setSelected(true);
                    break;
                case "SERVICE":
                    cbService.setSelected(true);
                    break;
                case "OTHER":
                    cbOther.setSelected(true);
                    break;
                }
                txtQuantity.setText(Integer.toString(item.getQuantity()));
                txtBarcode.setText(Integer.toString(item.getBarcode()));
                txtBuying.setText(Float.toString(item.getByingPrice()));
                txtSelling.setText(Float.toString(item.getSellingPrice()));
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
                File imagefile = new File("C:\\\\wamp64\\\\www\\\\imagesAmine\\\\" + item.getPicture());
                Image ima = new Image(imagefile.toURI().toString(), 300, 208, false, false);
                System.out.println("C:\\\\wamp64\\\\www\\\\imagesAmine\\\\" + item.getPicture());
                imgItem.setImage(ima);
            } catch (Exception e) {

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

    void aksiQuantity(KeyEvent event) {

    }

    @FXML
    void aksiSave(ActionEvent event) {
        Item item = new Item();
        item.setName(txtItemName.getText());
        item.setDescription(txtDescription.getText());

        if (cbCategory.getValue().getId() == null) {
            item.setCategory(findAllCategories().get(findAllCategories().size() - 1));
        } else {
            item.setCategory(cbCategory.getValue());
        }

        if (cbSupplier.getValue().getId() == null) {
            item.setSupplier(findAllSuppliers().get(findAllSuppliers().size() - 1));
        } else {
            item.setSupplier(cbSupplier.getValue());
        }

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
        item.setQuantity(Integer.parseInt(txtQuantity.getText()));
        item.setSellingPrice(Float.parseFloat(txtSelling.getText()));
        item.setByingPrice(Float.parseFloat(txtBuying.getText()));
        item.setCurrency(cbCurrency.getValue());
        item.setTotalPrice(Integer.parseInt(txtQuantity.getText()) * Float.parseFloat(txtSelling.getText()));
        if (selectimage) {
            item.setPicture(imgName);
        } else {
            item.setPicture(iPic.getPicture());
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
        saveOrUpdateItem(item);
        Config2.dialog(Alert.AlertType.INFORMATION, "Success Save Data..");
        clear();
        TabPane.setOpacity(0);
        selectWithService();
    }

    @FXML
    void ImportItem(ActionEvent event) {
        Item i = tableDataAlert.getSelectionModel().getSelectedItem();
        ItemRequest ir = new ItemRequest();
        ir.setItem(i);
        ir.setQuantityNeeded(i.getMinimumQuanity() - i.getQuantity());
        if (ItemRequestExists(ir) == null) {
            addItemRequest(ir);
            System.out.println("it says null");
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
        cbSupplier.getItems().addAll(findAllSuppliers());
        cbLowQuantity.setSelected(false);
        txtLowestQuantity.clear();
        cbLowExpirationDate.setSelected(false);
        txtExpirationDate.setValue(null);
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

    private void selectWithService() {
        Service<Integer> service = new Service<Integer>() {
            @Override
            protected Task<Integer> createTask() {
                selectData();
                selectDataAlert();
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

    private void selectDataAlert() {
        boolean condition = false;
        listDataAlert = FXCollections.observableArrayList();
        for (Item i : findAll()) {
            if (i.getQuantity() < i.getMinimumQuanity()) {
                condition = true;
                listDataAlert.add(i);
            }
        }
        if (condition) {
            buildNotificationItem("Warning !", "Item quantity is lower than what is recommand, press to fix issue",
                    Pos.BOTTOM_RIGHT, e -> {
                        afficherAlert();
                        clear();
                        SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
                        selectionModel.select(2);
                        paneTabel.setOpacity(0);
                        colAlerType.setCellValueFactory(c -> new SimpleStringProperty("quantity"));
                        tableDataAlert.setItems(listDataAlert);
                        new FadeInUpTransition(TabPane).play();
                    });
        }

    }

    private void saveOrUpdateItem(Item i) {
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            if (i.getId() == null) {
                itemService.save(i);
            } else {
                itemService.update(i);
            }
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
    }

    private void addItemRequest(ItemRequest i) {
        try {
            ctx = new InitialContext();
            itemRequestService = (ItemRequestServiceRemote) ctx.lookup(jndiNameItemRequest);
            itemRequestService.save(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong");
        }
    }

    private ItemRequest ItemRequestExists(ItemRequest ir) {
        try {
            ctx = new InitialContext();
            itemRequestService = (ItemRequestServiceRemote) ctx.lookup(jndiNameItemRequest);
            return itemRequestService.iRExist(ir.getItem().getId());
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong");
        }
        return null;
    }

    void deleteItem(Item i) {
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            itemService.delete(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong");
        }
    }

    void afficher() {
        // listData = FXCollections.observableArrayList();
        Config2.setModelColumn(colItemName, "name");
        Config2.setModelColumn(colItemType, "type");
        Config2.setModelColumn(colItemQuantity, "quantity");
        Config2.setModelColumn(colItemBarcode, "barcode");

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
                        return new SimpleStringProperty(param.getValue().getSupplier().getFirst_name() + " "
                                + param.getValue().getSupplier().getLast_name());
                    }
                });

        colAction.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCell();
            }

        });

    }

    void afficherAlert() {
        // listData = FXCollections.observableArrayList();
        Config2.setModelColumn(colItemNameAlert, "name");
        Config2.setModelColumn(colItemExpirationDate, "expirationDate");
        Config2.setModelColumn(colItemQuantityAlert, "quantity");
        Config2.setModelColumn(colItemBarcodeAlert, "barcode");

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
                        return new SimpleStringProperty(param.getValue().getSupplier().getFirst_name() + " "
                                + param.getValue().getSupplier().getLast_name());
                    }
                });

        // colActionAlert.setCellFactory(new Callback<TableColumn<Record, Boolean>,
        // TableCell<Record, Boolean>>() {
        //
        // @Override
        // public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
        // // TODO Auto-generated method stub
        // return new ButtonCell();
        // }
        //
        // });

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
                        String dd="";
//                        try {
                            dd = convert(param.getValue().getItem().getExpirationDate());
//                        } catch (NullPointerException e) {
//                            System.out.println("this item doesnt have expiration date, excception is catched");
//                        }
                        return new SimpleStringProperty(dd);
                    }
                });
        
        colImportItemBarcode.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ItemRequest,String>, ObservableValue<String>>() {
            
            @Override
            public ObservableValue<String> call(CellDataFeatures<ItemRequest, String> param) {
                String s=Integer.toString(param.getValue().getItem().getBarcode());
                return new SimpleStringProperty(s);
            }
        });
        
        colImportItemSupplier.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ItemRequest,String>, ObservableValue<String>>() {
            
            @Override
            public ObservableValue<String> call(CellDataFeatures<ItemRequest, String> param) {
                // TODO Auto-generated method stub
                return new SimpleStringProperty(param.getValue().getItem().getSupplier().getFirst_name());
            }
        });
    }

    private void addcategory(Category c) {
        try {
            ctx = new InitialContext();
            categorieService = (CategoryServiceRemote) ctx.lookup(jndiNameCategory);
            categorieService.save(c);
            System.out.println(c.getId());
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
    }

    private void addSupplier(Contact c) {
        try {
            ctx = new InitialContext();
            contactService = (ContactServiceRemote) ctx.lookup(jndiNameSupplier);
            contactService.save(c);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
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

    public static Date convert(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = sdf.parse(date);
        return d1;
    }

    void buildNotificationItem(String title, String text, Pos position, EventHandler<ActionEvent> e) {
        Notifications notificationBuilder = Notifications.create().title(title).text(text).graphic(null)
                .hideAfter(Duration.seconds(10)).position(Pos.BOTTOM_RIGHT).onAction(e);
        notificationBuilder.showWarning();
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
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Delete Data ?");
                alert.initStyle(StageStyle.UTILITY);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Item i = tableData.getSelectionModel().getSelectedItem();
                    deleteItem(i);
                    clear();
                    selectData();
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
}
