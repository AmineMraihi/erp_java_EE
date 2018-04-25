package tn.esprit.b1.esprit1718b1erp.app.client.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.RejectedExecutionException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sound.midi.Soundbank;

import org.controlsfx.control.textfield.TextFields;

import com.sun.prism.impl.Disposer.Record;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;
//import tn.esprit.b1.esprit1718b1erp.app.client.controllers.ItemController.ButtonCell;
import tn.esprit.b1.esprit1718b1erp.app.client.util.ItemVerfication;
import tn.esprit.b1.esprit1718b1erp.entities.Category;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Entreprise;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.ItemRequest;
import tn.esprit.b1.esprit1718b1erp.entities.Item_Type;
import tn.esprit.b1.esprit1718b1erp.entities.Particular;
import tn.esprit.b1.esprit1718b1erp.services.ahmed.PurchaseServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.ahmed.SaleServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.amine.CategoryServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ScheduleServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectServiceRemote;

public class ContactController implements Initializable {

    @FXML
    private AnchorPane paneTabel;

    @FXML
    private TableView<Contact> tableContact;

    @FXML
    private TableColumn<Contact, String> colname;

    @FXML
    private TableColumn<Contact, String> colCountry;

    @FXML
    private TableColumn<Contact, String> colCity;

    @FXML
    private TableColumn<Contact, String> colStreet;

    @FXML
    private TableColumn<Contact, Integer> colphone;

    @FXML
    private TableColumn<Contact, Integer> colMobile;

    @FXML
    private TableColumn<Contact, String> colEmail;

    @FXML
    private TableColumn colStatistic;
    @FXML
    private TableColumn colAction;
    @FXML
    private Button btnNew;

    @FXML
    private ProgressBar bar;

    @FXML
    private ImageView imgLoad;

    @FXML
    private TabPane TabPane;

    @FXML
    private AnchorPane paneCrud;

    @FXML
    private TextField txtfirstname;

    @FXML
    private TextField txtStreet;

    @FXML
    private Button btnAddContact;

    @FXML
    private Button btnBack;

    @FXML
    private ComboBox<String> cbCompany;

    @FXML
    private TextField txtpositionheld;

    @FXML
    private CheckBox cbSingle;

    @FXML
    private CheckBox cbMarried;

    @FXML
    private TextField txtLastName;

    @FXML
    private CheckBox cbOther;

    @FXML
    private TextField txtCity;

    @FXML
    private ComboBox<String> cbLanguage;

    @FXML
    private ImageView imgItem;

    @FXML
    private Button btnUpload;

    @FXML
    private ImageView addCategory;

    @FXML
    private TextField txtWebsite;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtphone;

    @FXML
    private TextField txtmobile;

    @FXML
    private TextField txtCountry;

    @FXML
    private TextField txtRegion;

    @FXML
    private TextField txtZipCode;

    @FXML
    private AnchorPane paneCrud1;

    @FXML
    private Button btnBack1;

    @FXML
    private AnchorPane paneCrud2;

    @FXML
    private TextField txtStreet1;

    @FXML
    private Button btnAddContact1;

    @FXML
    private Button btnBack2;

    @FXML
    private TextField txtLastName1;

    @FXML
    private TextField txtCity1;

    @FXML
    private ComboBox<String> cbLanguage1;

    @FXML
    private ImageView imgItem1;

    @FXML
    private TextField txtWebsite1;

    @FXML
    private TextField txtemail1;

    @FXML
    private TextField txtphone1;

    @FXML
    private TextField txtmobile1;

    @FXML
    private TextField txtCountry1;

    @FXML
    private TextField txtRegion1;

    @FXML
    private TextField txtZipCode1;

    @FXML
    private CheckBox cbCustomer;

    @FXML
    private CheckBox cbProvider;

    @FXML
    private CheckBox cbCustomer1;

    @FXML
    private CheckBox cbProvider1;
    @FXML
    private Button btnUpload1;
    @FXML
    private TextField txtSearchContact;
    @FXML
    private TextField txtSearchContactByName;
    @FXML
    private ComboBox<String> cbFilterBy;
    @FXML
    private TextField txtSearchContactByEmail;

    @FXML
    private TextField txtSearchContactByCity;

    @FXML
    private TextField txtSearchContactByCountry;

    @FXML
    private TextField txtSearchContactByRegion;

    @FXML
    private TextField txtSearchContactByCompany;

    @FXML
    private TextField txtSearchContactByRole;

    @FXML
    private AnchorPane anchorstatistics;
    @FXML
    private LineChart<?, ?> LineContact;
    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    @FXML
    private Button btnFermerStatistic;

    private final String jndiNameContact = "esprit1718b1erp-ear/esprit1718b1erp-service/ContactService!tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote";
    private final String jndiNameSale = "esprit1718b1erp-ear/esprit1718b1erp-service/SaleService!tn.esprit.b1.esprit1718b1erp.services.ahmed.SaleServiceRemote";
    private final String jndiPurchase = "esprit1718b1erp-ear/esprit1718b1erp-service/PurchaseService!tn.esprit.b1.esprit1718b1erp.services.ahmed.PurchaseServiceRemote";
    private InitialContext ctx = null;
    ContactServiceRemote contactservice;
    SaleServiceRemote saleServiceRemote;
    PurchaseServiceRemote purchaseServiceRemote;
    private ObservableList<Contact> listData;
    String idCnew = "";
    String idEnew = "";
    Boolean selectimage = false;
    String getImageUrl, imgName;
    Contact cpic;

    @FXML
    void fermerStat(ActionEvent event) {
        anchorstatistics.setOpacity(0);
        anchorstatistics.toBack();
    }

    @FXML
    void addCompany(ActionEvent event) {
        Entreprise company = new Entreprise();
        if (!txtLastName1.getText().equals("")) {

            company.setName(txtLastName1.getText());
            if (!txtemail1.getText().equals("")) {
                company.setEmail(txtemail1.getText());
            }
            if (!txtphone1.getText().equals("")) {
                company.setPhone(Integer.parseInt(txtphone1.getText()));
            }
            if (!txtmobile1.getText().equals("")) {
                company.setMobile(Integer.parseInt(txtmobile1.getText()));
            }
            if (!txtWebsite1.getText().equals("")) {
                company.setWebsite(txtWebsite1.getText());
            }
            // if (!cbLanguage1.getValue().equals(null)) {
            company.setLanguage(cbLanguage1.getValue());
            // }
            if (!txtStreet1.getText().equals("")) {
                company.setStreet(txtStreet1.getText());
            }
            if (!txtCity1.getText().equals("")) {
                company.setCity(txtCity1.getText());
            }
            if (!txtRegion1.getText().equals("")) {
                company.setRegion(txtRegion1.getText());
            }
            if (!txtCountry1.getText().equals("")) {
                company.setCountry(txtCountry1.getText());
            }
            if (!txtZipCode1.getText().equals("")) {
                company.setZipCode(txtZipCode1.getText());
            }
            if (!((cbCustomer1.isSelected() && cbProvider1.isSelected()))) {
                if (cbCustomer1.isSelected()) {
                    company.setRole("customer");
                }
                if (cbProvider1.isSelected()) {
                    company.setRole("provider");
                }
            } else {
                Config2.dialog(Alert.AlertType.INFORMATION, "Must Choose One Role");
            }
            if (selectimage) {
                company.setPicture(imgName);
            } else {
                if (cpic != null) {
                    company.setPicture(cpic.getPicture());
                } else {
                    company.setPicture("");
                }
            }
            try {
                ctx = new InitialContext();
                contactservice = (ContactServiceRemote) ctx.lookup(jndiNameContact);
                if (idEnew.equals("")) {
                    contactservice.save(company);
                    cbCompany.getItems().add(company.getName());
                } else {
                    company.setId(Integer.valueOf(idEnew));
                    contactservice.update(company);
                }
            } catch (NamingException e) {
                System.out.println("NamingException jndi");
            } catch (RejectedExecutionException e1) {
                System.out.println("catched rejected");
            }
            idEnew = "";
            Config2.dialog(Alert.AlertType.INFORMATION, "Success Save Data..");
        } else {
            Config2.dialog(Alert.AlertType.INFORMATION, "Must Enter Name of Company");
        }
    }

    @FXML
    void addCompanyButton(MouseEvent event) {
        SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
        selectionModel.select(1);
        idEnew = "";
    }

    @FXML
    void addContact(ActionEvent event) {
        Particular contact = new Particular();

        contact.setFirst_name(txtfirstname.getText());
        contact.setName(txtLastName.getText());
        contact.setEmail(txtemail.getText());
        contact.setPhone(Integer.parseInt(txtphone.getText()));
        contact.setMobile(Integer.parseInt(txtmobile.getText()));
        contact.setCompany(contactservice.findCompanyByname(cbCompany.getValue()));
        System.out.println(contactservice.findCompanyByname(cbCompany.getValue()));
        if (cbSingle.isSelected()) {
            contact.setCivility("Single");
        }

        if (cbOther.isSelected()) {
            contact.setCivility("Other");
        }

        if (cbMarried.isSelected()) {
            contact.setCivility("Married");
        }
        if (cbCustomer.isSelected()) {
            contact.setRole("customer");
        }
        if (cbProvider.isSelected()) {
            contact.setRole("provider");
        }
        contact.setPositionHeld(txtpositionheld.getText());
        contact.setWebsite(txtWebsite.getText());

        contact.setLanguage(cbLanguage.getValue());
        contact.setStreet(txtStreet.getText());
        contact.setCity(txtCity.getText());
        contact.setCountry(txtCountry.getText());
        contact.setRegion(txtRegion.getText());
        contact.setZipCode(txtZipCode.getText());
        if (selectimage) {
            contact.setPicture(imgName);
        } else {
            if (cpic != null) {
                contact.setPicture(cpic.getPicture());
            } else {
                contact.setPicture("");
            }
        }
        try {
            ctx = new InitialContext();
            contactservice = (ContactServiceRemote) ctx.lookup(jndiNameContact);
            if (idCnew.equals("")) {
                contactservice.save(contact);
            } else {
                contact.setId(Integer.valueOf(idCnew));
                contactservice.update(contact);
            }
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        idCnew = "";
        Config2.dialog(Alert.AlertType.INFORMATION, "Success Save Data..");
        clear();
    }

    @FXML
    void aksiBack(ActionEvent event) {
        TabPane.setOpacity(0);
        paneTabel.setOpacity(1);
        paneTabel.toFront();
        TabPane.toBack();
        afficher();
        txtSearchContactByName.setOpacity(0);
        txtSearchContactByName.toBack();
        txtSearchContactByEmail.setOpacity(0);
        txtSearchContactByEmail.toBack();
        txtSearchContactByCity.setOpacity(0);
        txtSearchContactByCity.toBack();
        txtSearchContactByCountry.setOpacity(0);
        txtSearchContactByCountry.toBack();
        txtSearchContactByRegion.setOpacity(0);
        txtSearchContactByRegion.toBack();
        txtSearchContactByCompany.setOpacity(0);
        txtSearchContactByCompany.toBack();
        txtSearchContactByRole.setOpacity(0);
        txtSearchContactByRole.toBack();
        cbFilterBy.setOpacity(1);
        cbFilterBy.toFront();

    }

    @FXML
    void ShowContactdetails(MouseEvent event) {
        // System.out.println("************************");

        try {
            Contact c = new Contact();
            ctx = new InitialContext();
            contactservice = (ContactServiceRemote) ctx.lookup(jndiNameContact);
            c = tableContact.getSelectionModel().getSelectedItem();
            cpic = c;
            if (c instanceof Particular) {
                idCnew = String.valueOf(c.getId());
                System.out.println(idCnew);
            }
            if (c instanceof Entreprise) {
                idEnew = String.valueOf(c.getId());
                System.out.println(idEnew);
            }
            afficherdetails(c);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");

        }
    }

    void afficherdetails(Contact c) {
        if (c instanceof Entreprise) {

            Entreprise e = new Entreprise();
            e = (Entreprise) c;
            txtLastName1.setText(e.getName());
            txtCity1.setText(e.getCity());
            txtCountry1.setText(e.getCountry());
            txtemail1.setText(e.getEmail());
            txtmobile1.setText(String.valueOf(e.getMobile()));
            txtphone1.setText(String.valueOf(e.getPhone()));
            txtRegion1.setText(e.getRegion());
            txtStreet1.setText(e.getStreet());
            txtWebsite1.setText(e.getWebsite());
            txtZipCode1.setText(e.getZipCode());
            cbLanguage1.setValue(e.getLanguage());
            if (cpic.getPicture() != null) {
                File file = new File("C:\\\\wamp64\\\\www\\\\imagejassem\\\\" + cpic.getPicture());
                Image ima = new Image(file.toURI().toString(), 300, 208, false, false);
                imgItem1.setImage(ima);
            }
            if (e.getRole().equals("customer")) {
                cbCustomer1.setSelected(true);
            }
            if (e.getRole().equals("provider")) {
                cbProvider1.setSelected(true);
            }
            paneTabel.setOpacity(0);
            new FadeInUpTransition(TabPane).play();
            SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
            selectionModel.select(1);
        }
        if (c instanceof Particular) {
            Particular p = new Particular();
            p = (Particular) c;
            txtfirstname.setText(p.getFirst_name());
            txtLastName.setText(p.getName());
            txtemail.setText(p.getEmail());
            txtphone.setText(String.valueOf(p.getPhone()));
            txtmobile.setText(String.valueOf(p.getMobile()));
            if (p.getCompany() != null) {
                cbCompany.setValue(p.getCompany().getName());
            }
            if (p.getCivility() != null && p.getCivility().equals("Single")) {
                cbSingle.setSelected(true);
            }
            if (p.getCivility() != null && p.getCivility().equals("Married")) {
                cbMarried.setSelected(true);
            }
            if (p.getCivility() != null && p.getCivility().equals("Other")) {
                cbOther.setSelected(true);
            }
            if (p.getRole() != null && p.getRole().equals("customer")) {
                cbCustomer.setSelected(true);
            }
            if (p.getRole() != null && p.getRole().equals("provider")) {
                cbProvider.setSelected(true);
            }
            txtpositionheld.setText(p.getPositionHeld());
            txtWebsite.setText(p.getWebsite());
            cbLanguage.setValue(p.getLanguage());
            txtCountry.setText(p.getCountry());
            txtCity.setText(p.getCity());
            txtRegion.setText(p.getRegion());
            txtStreet.setText(p.getStreet());
            txtZipCode.setText(p.getZipCode());
            if (cpic.getPicture() != null) {
                File file = new File("C:\\\\wamp64\\\\www\\\\imagejassem\\\\" + cpic.getPicture());
                Image ima = new Image(file.toURI().toString(), 300, 208, false, false);
                System.out.println("C:\\\\wamp64\\\\www\\\\imagejassem\\\\" + cpic.getPicture());
                imgItem.setImage(ima);
            }
            // ********************* afficher les details de l'entreprise
            // associé *******************************
            try {
                Entreprise e = new Entreprise();
                ctx = new InitialContext();
                contactservice = (ContactServiceRemote) ctx.lookup(jndiNameContact);
                if (p.getCompany() != null) {
                    e = (Entreprise) contactservice.find(p.getCompany().getId());
                    idEnew = String.valueOf(p.getCompany().getId()); // Sauvgarder
                                                                     // l'id de
                                                                     // l'entreprise
                                                                     // associée
                                                                     // en
                                                                     // cas on a
                                                                     // besoin
                                                                     // de la
                                                                     // modifier
                    txtLastName1.setText(e.getName());
                    txtCity1.setText(e.getCity());
                    txtCountry1.setText(e.getCountry());
                    txtemail1.setText(e.getEmail());
                    txtmobile1.setText(String.valueOf(e.getMobile()));
                    txtphone1.setText(String.valueOf(e.getPhone()));
                    txtRegion1.setText(e.getRegion());
                    txtStreet1.setText(e.getStreet());
                    txtWebsite1.setText(e.getWebsite());
                    txtZipCode1.setText(e.getZipCode());
                    cbLanguage1.setValue(e.getLanguage());
                    if (e.getRole().equals("customer")) {
                        cbCustomer1.setSelected(true);
                    }
                    if (e.getRole().equals("provider")) {
                        cbProvider1.setSelected(true);
                    }
                    if (e.getPicture() != null) {
                        File file = new File("C:\\\\wamp64\\\\www\\\\imagejassem\\\\" + e.getPicture());
                        Image ima = new Image(file.toURI().toString(), 300, 208, false, false);
                        imgItem1.setImage(ima);
                    }
                }
            } catch (NamingException e) {
                System.out.println("NamingException jndi");
            } catch (RejectedExecutionException e1) {
                System.out.println("catched rejected");

            }

            paneTabel.setOpacity(0);
            new FadeInUpTransition(TabPane).play();
            SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
            selectionModel.select(0);

        }
        txtSearchContactByName.setOpacity(0);
        txtSearchContactByName.toBack();
        txtSearchContactByEmail.setOpacity(0);
        txtSearchContactByEmail.toBack();
        txtSearchContactByCity.setOpacity(0);
        txtSearchContactByCity.toBack();
        txtSearchContactByCountry.setOpacity(0);
        txtSearchContactByCountry.toBack();
        txtSearchContactByRegion.setOpacity(0);
        txtSearchContactByRegion.toBack();
        txtSearchContactByCompany.setOpacity(0);
        txtSearchContactByCompany.toBack();
        txtSearchContactByRole.setOpacity(0);
        txtSearchContactByRole.toBack();
        cbFilterBy.setOpacity(0);
        cbFilterBy.toBack();
    }

    @FXML
    void aksiNew(ActionEvent event) {
        // clear(); ********************************
        idCnew = "";
        idEnew = "";

        txtSearchContactByName.setOpacity(0);
        txtSearchContactByName.toBack();
        txtSearchContactByEmail.setOpacity(0);
        txtSearchContactByEmail.toBack();
        txtSearchContactByCity.setOpacity(0);
        txtSearchContactByCity.toBack();
        txtSearchContactByCountry.setOpacity(0);
        txtSearchContactByCountry.toBack();
        txtSearchContactByRegion.setOpacity(0);
        txtSearchContactByRegion.toBack();
        txtSearchContactByCompany.setOpacity(0);
        txtSearchContactByCompany.toBack();
        txtSearchContactByRole.setOpacity(0);
        txtSearchContactByRole.toBack();
        cbFilterBy.setOpacity(0);
        cbFilterBy.toBack();

        paneTabel.setOpacity(0);
        new FadeInUpTransition(TabPane).play();
        paneTabel.toBack();
        TabPane.toFront();
        clear();
    }

    @FXML
    void aksiQuantity(KeyEvent event) {

    }

    @FXML
    void aksiUpload1(ActionEvent event) {
        FileChooser fc = new FileChooser();
        selectimage = true;
        File selectedfile = fc.showOpenDialog(null);
        if (selectedfile != null) {
            getImageUrl = selectedfile.getAbsolutePath();
            File file = new File(getImageUrl);
            Image ima = new Image(file.toURI().toString(), 300, 208, false, false);
            int fileNameIndex = getImageUrl.lastIndexOf("\\") + 1;
            imgName = getImageUrl.substring(fileNameIndex);
            File dest = new File("C:\\wamp64\\www\\imagejassem\\" + imgName);
            imgItem1.setImage(ima);
            try {
                copyFileUsingStream(selectedfile, dest);
            } catch (IOException e) {
            }
        } else {

            System.out.println("file does not exist");
        }
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
            File dest = new File("C:\\wamp64\\www\\imagejassem\\" + imgName);
            imgItem.setImage(ima);
            try {
                copyFileUsingStream(selectedfile, dest);
            } catch (IOException e) {
            }
        } else {

            System.out.println("file does not exist");
        }
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

    private void saveOrUpdateContact(Contact c) {
        try {
            ctx = new InitialContext();
            contactservice = (ContactServiceRemote) ctx.lookup(jndiNameContact);
            if (c.getId() == null) {
                contactservice.save(c);
            } else {
                contactservice.update(c);
            }
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
    }

    private List<String> findAllCompanies() {
        List<String> companies = new ArrayList<String>();
        try {
            ctx = new InitialContext();
            contactservice = (ContactServiceRemote) ctx.lookup(jndiNameContact);

            companies.addAll(contactservice.findAllCompaniesNames());
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return companies;
    }

    private List<Contact> findAll() {
        List<Contact> contacts = new ArrayList<>();
        try {
            ctx = new InitialContext();
            contactservice = (ContactServiceRemote) ctx.lookup(jndiNameContact);
            contacts = contactservice.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return contacts;
    }

    private void selectData() {
        if (listData == null) {
            listData = FXCollections.observableArrayList(findAll());
        } else {
            listData.clear();
            listData.addAll(findAll());
        }
        tableContact.setItems(listData);
    }

    void afficher() {
        selectData();
        Config2.setModelColumn(colname, "name");
        Config2.setModelColumn(colCountry, "country");
        Config2.setModelColumn(colCity, "city");
        Config2.setModelColumn(colStreet, "street");
        Config2.setModelColumn(colphone, "phone");
        Config2.setModelColumn(colMobile, "mobile");
        Config2.setModelColumn(colEmail, "email");
        colAction.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCell();
            }

        });
        colStatistic.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCellStatistic();
            }

        });

    }

    void clear() {
        txtCity.clear();
        txtCity1.clear();
        txtCountry.clear();
        txtCountry1.clear();
        txtemail.clear();
        txtemail1.clear();
        txtfirstname.clear();
        txtLastName.clear();
        txtLastName1.clear();
        txtmobile.clear();
        txtmobile1.clear();
        txtphone.clear();
        txtphone1.clear();
        txtpositionheld.clear();
        txtRegion.clear();
        txtRegion1.clear();
        txtStreet.clear();
        txtStreet1.clear();
        txtWebsite.clear();
        txtWebsite1.clear();
        txtZipCode.clear();
        txtZipCode1.clear();
        cbCompany.getItems().clear();
        cbCompany.getItems().addAll(findAllCompanies());
        cbLanguage.getItems().clear();
        cbLanguage.getItems().addAll("English", "French", "Arabic", "German");
        cbLanguage1.getItems().clear();
        cbLanguage1.getItems().addAll("English", "French", "Arabic", "German");
        cbMarried.setSelected(false);
        cbOther.setSelected(false);
        cbSingle.setSelected(false);
    }

    void deleteContact(Contact contact) {
        try {
            ctx = new InitialContext();
            contactservice = (ContactServiceRemote) ctx.lookup(jndiNameContact);
            if (contact instanceof Entreprise) {
                Entreprise e = new Entreprise();
                e = (Entreprise) contact;
                // System.out.println(contactservice.VerifierEntreprise(e));
                if (contactservice.VerifierEntreprise(e).isEmpty()) {
                    contactservice.delete(contact);
                } else {
                    Config2.dialog(Alert.AlertType.INFORMATION, "Can't Delete Contact !");
                }

            } else {
                contactservice.delete(contact);
            }
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            System.out.println("something is wrong");
            e2.printStackTrace();
        }
    }

    private class ButtonCell extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("Delete");

        final HBox hb = new HBox(cellButtonDelete);

        public ButtonCell() {
            hb.setSpacing(4);
            cellButtonDelete.setOnAction((ActionEvent t) -> {

                int row = getTableRow().getIndex();
                tableContact.getSelectionModel().select(row);
                // aksiKlikTableData(null);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Delete Contact ?");
                alert.initStyle(StageStyle.UTILITY);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Contact c = tableContact.getSelectionModel().getSelectedItem();
                    deleteContact(c);
                    afficher();
                    /*
                     * clear(); selectData();
                     */
                } else {
                    clear();
                    selectData();
                }

            });

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

    private class ButtonCellStatistic extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("Show");

        final HBox hb = new HBox(cellButtonDelete);

        public ButtonCellStatistic() {
            hb.setSpacing(4);
            cellButtonDelete.setOnAction((ActionEvent t) -> {

                int row = getTableRow().getIndex();
                tableContact.getSelectionModel().select(row);
                anchorstatistics.setOpacity(1);
                anchorstatistics.toFront();
                fillChart(tableContact.getSelectionModel().getSelectedItem());
                // aksiKlikTableData(null);

            });

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

    void filerContactListByName(String oldValue, String newValue) {
        ObservableList<Contact> filteredList = FXCollections.observableArrayList();
        if (txtSearchContactByName.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            listData.clear();
            listData.addAll(findAll());
            tableContact.setItems(listData);
        } else {
            newValue = newValue.toUpperCase();
            for (Contact c : tableContact.getItems()) {
                if (c.getName().toUpperCase().contains(newValue)) {
                    filteredList.add(c);
                }
            }
            tableContact.setItems(filteredList);
        }
    }

    void filerContactListByEmail(String oldValue, String newValue) {
        ObservableList<Contact> filteredList = FXCollections.observableArrayList();
        if (txtSearchContactByEmail.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            listData.clear();
            listData.addAll(findAll());
            tableContact.setItems(listData);
        } else {
            newValue = newValue.toUpperCase();
            for (Contact c : tableContact.getItems()) {
                if (c.getEmail().toUpperCase().contains(newValue)) {
                    filteredList.add(c);
                }
            }
            tableContact.setItems(filteredList);
        }
    }

    void filerContactListByCity(String oldValue, String newValue) {
        ObservableList<Contact> filteredList = FXCollections.observableArrayList();
        if (txtSearchContactByCity.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            listData.clear();
            listData.addAll(findAll());
            tableContact.setItems(listData);
        } else {
            newValue = newValue.toUpperCase();
            for (Contact c : tableContact.getItems()) {
                if (c.getCity().toUpperCase().contains(newValue)) {
                    filteredList.add(c);
                }
            }
            tableContact.setItems(filteredList);
        }
    }

    void filerContactListByCountry(String oldValue, String newValue) {
        ObservableList<Contact> filteredList = FXCollections.observableArrayList();
        if (txtSearchContactByCountry.getText() == null || (newValue.length() < oldValue.length())
                || newValue == null) {
            listData.clear();
            listData.addAll(findAll());
            tableContact.setItems(listData);
        } else {
            newValue = newValue.toUpperCase();
            for (Contact c : tableContact.getItems()) {
                if (c.getCountry().toUpperCase().contains(newValue)) {
                    filteredList.add(c);
                }
            }
            tableContact.setItems(filteredList);
        }
    }

    void filerContactListByRegion(String oldValue, String newValue) {
        ObservableList<Contact> filteredList = FXCollections.observableArrayList();
        if (txtSearchContactByRegion.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            listData.clear();
            listData.addAll(findAll());
            tableContact.setItems(listData);
        } else {
            newValue = newValue.toUpperCase();
            for (Contact c : tableContact.getItems()) {
                if (c.getRegion().toUpperCase().contains(newValue)) {
                    filteredList.add(c);
                }
            }
            tableContact.setItems(filteredList);
        }
    }

    void filerContactListByCompany(String oldValue, String newValue) {
        ObservableList<Contact> filteredList = FXCollections.observableArrayList();
        if (txtSearchContactByCompany.getText() == null || (newValue.length() < oldValue.length())
                || newValue == null) {
            listData.clear();
            listData.addAll(findAll());
            tableContact.setItems(listData);
        } else {
            newValue = newValue.toUpperCase();
            for (Contact c : tableContact.getItems()) {
                if (c instanceof Particular) {
                    Particular p = new Particular();
                    p = (Particular) c;
                    if (p.getCompany().getName().toUpperCase().contains(newValue)) {
                        filteredList.add(c);
                    }
                }
            }
            tableContact.setItems(filteredList);
        }
    }

    void filerContactListByRole(String oldValue, String newValue) {

        ObservableList<Contact> filteredList = FXCollections.observableArrayList();
        if (txtSearchContactByRole.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            listData.clear();
            listData.addAll(findAll());
            tableContact.setItems(listData);
        } else {
            newValue = newValue.toUpperCase();
            for (Contact c : tableContact.getItems()) {
                if (c.getRole().toUpperCase().contains(newValue)) {
                    filteredList.add(c);
                }
            }
            tableContact.setItems(filteredList);
        }
    }

    @FXML
    void FilterBy(ActionEvent event) {
        if (cbFilterBy.getValue().equals("Name")) {
            txtSearchContactByName.setOpacity(1);
            txtSearchContactByName.toFront();
            txtSearchContactByEmail.setOpacity(0);
            txtSearchContactByEmail.toBack();
            txtSearchContactByCity.setOpacity(0);
            txtSearchContactByCity.toBack();
            txtSearchContactByCountry.setOpacity(0);
            txtSearchContactByCountry.toBack();
            txtSearchContactByRegion.setOpacity(0);
            txtSearchContactByRegion.toBack();
            txtSearchContactByCompany.setOpacity(0);
            txtSearchContactByCompany.toBack();
            txtSearchContactByRole.setOpacity(0);
            txtSearchContactByRole.toBack();

            txtSearchContactByName.textProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                    filerContactListByName((String) oldValue, (String) newValue);
                }
            });
        }
        if (cbFilterBy.getValue().equals("Email")) {
            txtSearchContactByName.setOpacity(0);
            txtSearchContactByName.toBack();
            txtSearchContactByEmail.setOpacity(1);
            txtSearchContactByEmail.toFront();
            txtSearchContactByCity.setOpacity(0);
            txtSearchContactByCity.toBack();
            txtSearchContactByCountry.setOpacity(0);
            txtSearchContactByCountry.toBack();
            txtSearchContactByRegion.setOpacity(0);
            txtSearchContactByRegion.toBack();
            txtSearchContactByCompany.setOpacity(0);
            txtSearchContactByCompany.toBack();
            txtSearchContactByRole.setOpacity(0);
            txtSearchContactByRole.toBack();
            txtSearchContactByEmail.textProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                    filerContactListByEmail((String) oldValue, (String) newValue);
                }
            });
        }
        if (cbFilterBy.getValue().equals("City")) {
            txtSearchContactByName.setOpacity(0);
            txtSearchContactByName.toBack();
            txtSearchContactByEmail.setOpacity(0);
            txtSearchContactByEmail.toBack();
            txtSearchContactByCity.setOpacity(1);
            txtSearchContactByCity.toFront();
            txtSearchContactByCountry.setOpacity(0);
            txtSearchContactByCountry.toBack();
            txtSearchContactByRegion.setOpacity(0);
            txtSearchContactByRegion.toBack();
            txtSearchContactByCompany.setOpacity(0);
            txtSearchContactByCompany.toBack();
            txtSearchContactByRole.setOpacity(0);
            txtSearchContactByRole.toBack();
            txtSearchContactByCity.textProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                    filerContactListByCity((String) oldValue, (String) newValue);
                }
            });
        }
        if (cbFilterBy.getValue().equals("Country")) {
            txtSearchContactByName.setOpacity(0);
            txtSearchContactByName.toBack();
            txtSearchContactByEmail.setOpacity(0);
            txtSearchContactByEmail.toBack();
            txtSearchContactByCity.setOpacity(0);
            txtSearchContactByCity.toBack();
            txtSearchContactByCountry.setOpacity(1);
            txtSearchContactByCountry.toFront();
            txtSearchContactByRegion.setOpacity(0);
            txtSearchContactByRegion.toBack();
            txtSearchContactByCompany.setOpacity(0);
            txtSearchContactByCompany.toBack();
            txtSearchContactByRole.setOpacity(0);
            txtSearchContactByRole.toBack();
            txtSearchContactByCountry.textProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                    filerContactListByCountry((String) oldValue, (String) newValue);
                }
            });
        }
        if (cbFilterBy.getValue().equals("Region")) {
            txtSearchContactByName.setOpacity(0);
            txtSearchContactByName.toBack();
            txtSearchContactByEmail.setOpacity(0);
            txtSearchContactByEmail.toBack();
            txtSearchContactByCity.setOpacity(0);
            txtSearchContactByCity.toBack();
            txtSearchContactByCountry.setOpacity(0);
            txtSearchContactByCountry.toBack();
            txtSearchContactByRegion.setOpacity(1);
            txtSearchContactByRegion.toFront();
            txtSearchContactByCompany.setOpacity(0);
            txtSearchContactByCompany.toBack();
            txtSearchContactByRole.setOpacity(0);
            txtSearchContactByRole.toBack();
            txtSearchContactByRegion.textProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                    filerContactListByRegion((String) oldValue, (String) newValue);
                }
            });
        }
        if (cbFilterBy.getValue().equals("Company")) {
            txtSearchContactByName.setOpacity(0);
            txtSearchContactByName.toBack();
            txtSearchContactByEmail.setOpacity(0);
            txtSearchContactByEmail.toBack();
            txtSearchContactByCity.setOpacity(0);
            txtSearchContactByCity.toBack();
            txtSearchContactByCountry.setOpacity(0);
            txtSearchContactByCountry.toBack();
            txtSearchContactByRegion.setOpacity(0);
            txtSearchContactByRegion.toBack();
            txtSearchContactByCompany.setOpacity(1);
            txtSearchContactByCompany.toFront();
            txtSearchContactByRole.setOpacity(0);
            txtSearchContactByRole.toBack();
            txtSearchContactByCompany.textProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                    filerContactListByCompany((String) oldValue, (String) newValue);
                }
            });
        }
        if (cbFilterBy.getValue().equals("Role")) {
            txtSearchContactByName.setOpacity(0);
            txtSearchContactByName.toBack();
            txtSearchContactByEmail.setOpacity(0);
            txtSearchContactByEmail.toBack();
            txtSearchContactByCity.setOpacity(0);
            txtSearchContactByCity.toBack();
            txtSearchContactByCountry.setOpacity(0);
            txtSearchContactByCountry.toBack();
            txtSearchContactByRegion.setOpacity(0);
            txtSearchContactByRegion.toBack();
            txtSearchContactByCompany.setOpacity(0);
            txtSearchContactByCompany.toBack();
            txtSearchContactByRole.setOpacity(1);
            txtSearchContactByRole.toFront();
            txtSearchContactByRole.textProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                    filerContactListByRole((String) oldValue, (String) newValue);
                }
            });
        }

        // TextFields.bindAutoCompletion(txtsearchItem, getItemNames());

    }

    private ObservableList<String> monthNames = FXCollections.observableArrayList();

    private void fillChart(Contact c) {
        LineContact.getData().clear();

        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getMonths();
        monthNames.addAll(Arrays.asList(months));
        XYChart.Series series1 = new XYChart.Series();

        List<Double> listeiphone7 = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            if (c.getRole().equals("customer")) {
                series1.getData()
                        .add(new XYChart.Data(monthNames.get(i), saleServiceRemote.ContactSalesPerMonth(i + 1, c)));
            }
            if (c.getRole().equals("provider")) {
                System.out.println(purchaseServiceRemote.ContactPurchasesPerMonth(i + 1, c));
                series1.getData().add(
                        new XYChart.Data(monthNames.get(i), purchaseServiceRemote.ContactPurchasesPerMonth(i + 1, c)));
            }

            listeiphone7.add(saleServiceRemote.ContactSalesPerMonth(i + 1, c));
            Double finalsommeiphone7 = (double) 0;
            for (Double increm : listeiphone7) {
                finalsommeiphone7 += increm;
            }

        }
        LineContact.getData().addAll(series1);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbLanguage.getItems().addAll("English", "French", "Arabic", "German");
        cbLanguage1.getItems().addAll("English", "French", "Arabic", "German");
        cbCompany.getItems().addAll(findAllCompanies());
        cbFilterBy.getItems().addAll("Name", "Email", "City", "Country", "Region", "Company", "Role");
        // System.out.println(findAllCompanies());
        paneTabel.toFront();
        TabPane.toBack();
        afficher();
        try {
            ctx = new InitialContext();
            saleServiceRemote = (SaleServiceRemote) ctx.lookup(jndiNameSale);
            purchaseServiceRemote = (PurchaseServiceRemote) ctx.lookup(jndiPurchase);
        } catch (NamingException e) {

            e.printStackTrace();
        }
    }

}
