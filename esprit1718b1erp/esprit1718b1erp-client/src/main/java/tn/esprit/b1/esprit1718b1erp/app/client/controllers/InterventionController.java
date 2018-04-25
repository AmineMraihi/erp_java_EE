package tn.esprit.b1.esprit1718b1erp.app.client.controllers;

import java.awt.Color;
import java.awt.Toolkit;
import java.beans.DesignMode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.time.DateUtils;
import org.controlsfx.control.Notifications;


import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.model.Calendar.Style;
import com.calendarfx.view.CalendarView;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView.TableRow;
import javax.websocket.OnMessage;

import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//import org.w3c.dom.Text;

//import org.dom4j.Text;

import com.sun.prism.impl.Disposer.Record;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javafx.fxml.Initializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;

import javafx.scene.control.TableColumn;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.CheckBox;

import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javafx.util.Duration;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeOutUpTransition;
//import tn.esprit.b1.esprit1718b1erp.app.client.controllers.ItemController.ButtonCell;
import tn.esprit.b1.esprit1718b1erp.app.client.util.ItemVerfication;
import tn.esprit.b1.esprit1718b1erp.entities.Breakdown;
import tn.esprit.b1.esprit1718b1erp.entities.BreakdownState;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Event;
import tn.esprit.b1.esprit1718b1erp.entities.Intervention;
import tn.esprit.b1.esprit1718b1erp.entities.InterventionPriority;
import tn.esprit.b1.esprit1718b1erp.entities.InterventionStatus;
import tn.esprit.b1.esprit1718b1erp.entities.InterventionType;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.ItemRequest;
import tn.esprit.b1.esprit1718b1erp.entities.Item_Type;
import tn.esprit.b1.esprit1718b1erp.entities.MachineState;
import tn.esprit.b1.esprit1718b1erp.entities.MachineType;
import tn.esprit.b1.esprit1718b1erp.entities.Meeting;
import tn.esprit.b1.esprit1718b1erp.entities.Schedule;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.entities.UserFunction;
import tn.esprit.b1.esprit1718b1erp.services.UserService;
import tn.esprit.b1.esprit1718b1erp.services.UserServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.amine.CategoryServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.malek.BreakdownServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.malek.InterventionServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.shil.ReportServiceRemote;

public class InterventionController implements Initializable {

    @FXML
    private Button btnNewintervention;

    @FXML
    private ProgressBar bar;

    @FXML
    private ImageView imgLoad;

    @FXML
    private AnchorPane paneTabel;
    
    @FXML
    private AnchorPane itemqnt;
   
    @FXML
    private HTMLEditor reportEditor;
    
    @FXML
    private AnchorPane interventiondetails;
    
    @FXML
    private AnchorPane stockpane;
    
    @FXML
    private AnchorPane writerapportpane;
    
    @FXML
    private Button addstock;

    @FXML
    private TabPane TabPane;
    
    @FXML
    private TabPane stocktab;

    @FXML
    private AnchorPane paneintervention;

    @FXML
    private AnchorPane Breakdowndetails;
    
    @FXML
    private AnchorPane Breakdowndetails1;

    @FXML
    private Button send;
    
    @FXML
    private Button updbrk;
    
    @FXML
    private Button assigntech;
    
    @FXML
    private Button addbrk;
    
    @FXML
    private Button btnBackBrk;
    

    @FXML
    private Button btnBack;

    @FXML
    private ComboBox<String> typeintervention;
    
    @FXML
    private ComboBox<Item> namestock;

    @FXML
    private TextArea txtDescription;
    
    @FXML
    private TextArea observationbrk;
    
    @FXML
    private TextField addqnt;
    

    @FXML
    private TextField search;
    
    @FXML
    private TextField pieceneeded ;
    
    @FXML
    private TextField searchstock;
    
    @FXML
    private TextField searchbrk;

    @FXML
    private TableColumn<Intervention, String> priority;

    @FXML
    private TableColumn<Intervention, Date> coldate;
    
    @FXML
    private TableColumn interventionaction;

    @FXML
    private ComboBox<String> machinetype;

    @FXML
    private ComboBox<Item> machineref;

    @FXML
    private ComboBox<String> cbpriority;
    
    @FXML
    private ComboBox<String> brkstate;
    
    
    @FXML
    private TableView<Item> stocklist;
    
    @FXML
    private TableView<Item> itemused;
    
    @FXML
    private TableColumn<Item, String> itemu;
   
    @FXML
    private TableView<Integer> itemquantity;
   
    @FXML
    private TableColumn<Integer, String> quantityu;
    
    
    @FXML
    private TableColumn actionitemu;
    
    
    
    @FXML
    private TableView<Item> itembrk;
    
    @FXML
    private TableColumn<Item, String> item2;
    
    @FXML
    private TableColumn<Item, String> item1;
    
    @FXML
    private TableColumn<Item, Integer> qnt;
    
    @FXML
    private TableColumn<Item, Float> prixu;
    
    @FXML
    private TableColumn<Item, String> descriptionstock;
    
    @FXML
    private TableColumn stockAction;
    
    
    @FXML
    private TableView<Intervention> tableintervention;

    @FXML
    private TableColumn<Intervention, String> sender;

    @FXML
    private TableColumn<Intervention, String> itemname;

    @FXML
    private TableColumn<Intervention, String> typeinter;
    
    @FXML
    private TableColumn<Intervention, String> assignedto;

    @FXML
    private TableColumn<Intervention, Date> requestdate;

    @FXML
    private TableColumn<Intervention, String> status;

    @FXML
    private TableColumn<Intervention, String> description;

    @FXML
    private TableView<Breakdown> breakdwonlist;

    @FXML
    private TableColumn<Breakdown, String> item;

    @FXML
    private TableColumn<Breakdown, Date> breakdowndate;

    @FXML
    private TableColumn<Breakdown, Date> registrationdate;

    @FXML
    private TableColumn<Breakdown, String> state;
    
    @FXML
    private TableColumn descriptionbrk;
    
    @FXML
    private TableColumn<Breakdown, String> treatedby;
    
    @FXML
    private TableColumn ActionBrk;

    @FXML
    private DatePicker desireddate;

    @FXML
    private AnchorPane itemdetailsPane;
    
    @FXML
    private AnchorPane guaranteepane;
    
    @FXML
    private AnchorPane availabilitypane;

    @FXML
    private Button addobservation;

    @FXML
    private Text namelabel;

    @FXML
    private Text labeltype;

    @FXML
    private ImageView imgyes;

    @FXML
    private ImageView imgno;

    @FXML
    private Text labelmaintenance;

   
    @FXML
    private Text prix;
   
    @FXML
    private TextArea observation;

    @FXML
    private Button btnBack1;

    @FXML
    private AnchorPane paneintervention1;
    
    @FXML
    private AnchorPane assignt;
    
    @FXML
    private Button updatebrk;
    

    @FXML
    private Button update;

    @FXML
    private Button btnBack2;
    
    @FXML
    private Button btnBack11;

    @FXML
    private DatePicker endguarantee;

    @FXML
    private ComboBox<String> machinetype1;

    @FXML
    private ComboBox<Item> machineref1;
    
    @FXML
    private ComboBox<User> tech;

    @FXML
    private CheckBox guaranteeyes;

    @FXML
    private CheckBox guaranteeno;

    @FXML
    private DatePicker lastmaintain;

    @FXML
    private DatePicker nextmaintain;

    @FXML
    private CheckBox stateFun;

    @FXML
    private CheckBox stateUnf;

    @FXML
    private CheckBox availabilityyes;

    @FXML
    private CheckBox availabilityno;

    @FXML
    private TextArea itemobservation;
    private ValidationSupport validationSupport;

    /*
     * @FXML private TextField searchinter;
     */

    private ObservableList<Intervention> listintervention;
    private ObservableList<Breakdown> listbreakdown;
    private ObservableList<Item> liststock;
    private List<Item> listData=new ArrayList<>();
    private List<Integer> quantite =new ArrayList<>();
  





    private final String jndiNameItem = "esprit1718b1erp-ear/esprit1718b1erp-service/ItemService!tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote";
    private final String jndiNameIntervention = "esprit1718b1erp-ear/esprit1718b1erp-service/InterventionService!tn.esprit.b1.esprit1718b1erp.services.malek.InterventionServiceRemote";
    private final String jndiNameUser = "esprit1718b1erp-ear/esprit1718b1erp-service/UserService!tn.esprit.b1.esprit1718b1erp.services.UserServiceRemote";
    private final String jndiNameBreakdown = "esprit1718b1erp-ear/esprit1718b1erp-service/BreakdownService!tn.esprit.b1.esprit1718b1erp.services.malek.BreakdownServiceRemote";

    private InitialContext ctx = null;
    String idCnew = "";
    String idInter="";
    String idtreat="";
    String idbreak="";
    String idstock="";
    String rapport="";
    String rapport1="";
    String iditembrk="";
    String qntp="";
    Integer a;
    String category ="Machine";
    UserServiceRemote userService;
    ItemServiceRemote itemService;
    BreakdownServiceRemote breakdownService;
    InterventionServiceRemote interventionService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        //System.out.println(findInterventionByItem("Asus"));
      //  namestock.getItems().addAll(findAllRef("For maintain"));
       
        tech.getItems().addAll(findUserByRole(UserFunction.TECHNICIAN));
      
        machineref.getItems().addAll(findAllRef("Machine"));
        machineref1.getItems().addAll(findAllRef("Machine"));

        machinetype.getItems().addAll("ELECTRONIC", "MECANIQUE", "OTHER");
        machinetype1.getItems().addAll("ELECTRONIC", "MECANIQUE", "OTHER");
        brkstate.getItems().addAll("TREATED","UNTREATED");
        typeintervention.getItems().addAll("PREVENTIVE", "CORRECTIVE", "IMPROVEMENT");
        cbpriority.getItems().addAll("NORMAL", "URGENT");
        // tableintervention.setItems(listintervention);
        afficher();
        afficheritemused();
        afficheritem();
        
        afficherbreakdown();
      
       
        afficherstock();
        itembrk.setItems(liststock);
        //itemu.setItems(listData);
        stocklist.setItems(liststock);
        breakdwonlist.setItems(listbreakdown);
        tableintervention.setItems(listintervention);
        search.setVisible(false);
        searchstock.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                filerStocklist((String) oldValue, (String) newValue);
            }
        });
        
        searchbrk.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                filerBreakdownList((String) oldValue, (String) newValue);
            }
        });
        
        search.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                filerItemList((String) oldValue, (String) newValue);
            }
        });

        TextFields.bindAutoCompletion(search, getItemNames());
       List<Intervention> i=findAll();
        for(Intervention intervention:i)
        {
            long d=intervention.getRequestdate().getTime();
            long desireddate=intervention.getDesireddate().getTime();
            long now = System.currentTimeMillis();
            String result = null;
            long diff = Math.abs(now-d);
            
            System.out.println(diff);
            long diffdate1=now-d;
            long diffdate = desireddate-now;
            long diffDays = diffdate / ( 60 * 60 * 1000);
            long diffYears =diffdate1 / ( 60 * 60 * 1000 * 24* 365);
            System.out.println(diffYears+"WIIIIIIIIIIIIIIIIIIW");
/*
           if(diff < DateUtils.MILLIS_PER_MINUTE){
               result = (float)(diff/DateUtils.MILLIS_PER_MINUTE)/(24*60*60*365) + "";
            }else if(diff < DateUtils.MILLIS_PER_HOUR){
                 result = (float)(diff/DateUtils.MILLIS_PER_MINUTE)/(24*60*365) + "";
            }else if(diff < DateUtils.MILLIS_PER_DAY){
                result =  (float)(diff/DateUtils.MILLIS_PER_HOUR)/(24*365)+"" ;
            }else if(diff < DateUtils.MILLIS_PER_DAY * 365){
                result = (float)(diff/DateUtils.MILLIS_PER_DAY) +"";
            }
            System.out.println(result);*/
           
            
            System.out.println(diffDays+"WOOOOOOOOOOOOOOOOOOOOOOOOOY");
      
            if(Float.valueOf(diffYears)>3){
          //   delete(intervention);                
            }
           
            if(Float.valueOf(diffDays)==0)
            {
                intervention.setInterventionstatus(InterventionStatus.TREATED);
                saveOrUpdateIntervention(intervention);
            }
            }
        
        List<Item> item=findAllItem();
        for(Item intervention:item)
        {   
            
            if(intervention.getNextmaintenance()==null){
                System.out.println("");
            } else{
            long d=intervention.getNextmaintenance().getTime();
            long now = System.currentTimeMillis();
           // String result = null;
           // long diff = Math.abs(d-now);
            long diff = d-now;
            long diffDays = diff / ( 60 * 60 * 1000);
            
            System.out.println(diff);
            System.out.println(diffDays+"WOOOOOOOOOOOOOOOOOOOOOOOOOY");

      
            if(Float.valueOf(diffDays)<24){
                Notifications not = Notifications.create().darkStyle().hideAfter(Duration.seconds(5)).title("Welcome")
                        .text(intervention.getName()+" needs to be maintain tomorrow");
                not.showConfirm();
                
            }
            }
        
        }
        }
    private class ButtonCell extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonEdit = new Hyperlink("Treat");

        final HBox hb = new HBox(cellButtonEdit);

        public ButtonCell() {
            hb.setSpacing(4);
            cellButtonEdit.setOnAction((ActionEvent t) -> {

                int row = getTableRow().getIndex();
                tableintervention.getSelectionModel().select(row);
                // aksiKlikTableData(null);
              //  System.out.println("WOOOOOOOOOOOOOOOOY");
                interventiondetails.setOpacity(1);
                interventiondetails.toFront();
                interventiondetails.setVisible(true);
                

                   // clear();
                    Intervention i = tableintervention.getSelectionModel().getSelectedItem();
                    
                    //interventiondetails.setOpacity(1);
                    idtreat =String.valueOf(i.getId()) ;
                    System.out.println(idtreat);
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

        /*SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
       if( selectionModel.isSelected(1)){
           search.setVisible(true);

           
       } else {
           search.setVisible(false);

       }*/
        /*status.setCellFactory(column -> {    return new TableCell<Intervention, String>() {
            @Override
             @SuppressWarnings("unchecked") 
             protected void updateItem(String item, boolean empty) {
                List<Intervention> lm = findAll();
                for (Intervention intervention : lm)       
                {   item=intervention.getInterventionstatus().toString();
                    super.updateItem(item, empty);
                 System.out.println(item);
                 
                     TableView<Intervention> tv = getTableView();
                     if ((tv != null))  {
                         if (tv.getItems().get(getTableRow().getIndex()).getInterventionstatus().toString().equals("UNTREATED"))
                         {
                             setStyle("-fx-background-color: red");
                             } else {
                            // setTextFill(Color.GREEN);
                                 setStyle("-fx-background-color: yellow");
                         }
                     } 
                     setText(item);
                 
             }
            }
             };
         }); */
       

    
   

    

    

    @FXML
    void aksiBack(ActionEvent event) {

    }

    @FXML
    void aksiNew(ActionEvent event) {

    }

    @FXML
    void breakdownclicked(MouseEvent event) {

    }

    @FXML
    void interventionclicked(MouseEvent event) {
        if (event.getClickCount() == 1) 
        {
            search.setVisible(true);
        }
        
        if (event.getClickCount() == 2) // Checking double click
        {
            Intervention intervention = new Intervention();
            Item item = new Item();
            String N = tableintervention.getSelectionModel().getSelectedItem().getItemname();
            idInter = String.valueOf(tableintervention.getSelectionModel().getSelectedItem().getId());
            item = tableintervention.getSelectionModel().getSelectedItem().getItem();
            if(item.getAvailability()== null) {
                SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
                selectionModel.select(1);
            }      else    if (item.getAvailability() == true) {
                itemdetailsPane.toFront();
                System.out.println(item.getAvailability());

                new FadeInUpTransition(itemdetailsPane).play();
                imgyes.setVisible(true);
            } else if (item.getAvailability() == false) {
                itemdetailsPane.toFront();
                System.out.println(item.getAvailability());

                new FadeInUpTransition(itemdetailsPane).play();
                imgno.setVisible(true);
            }

          
            
            
            namelabel.setText(N);

            InterventionType Type = tableintervention.getSelectionModel().getSelectedItem().getInterventiontype();
            if (Type.equals(InterventionType.IMPROVEMENT)) {
                labeltype.setText("IMPROVEMENT");
            } else if (Type.equals(InterventionType.CORRECTIVE)) {
                labeltype.setText("CORRECTIVE");
            } else if (Type.equals(InterventionType.PREVENTIVE)) {
                labeltype.setText("PREVENTIVE");
            }

           

            // findItem(iditem).get
           // machine = (Machine) item;
            System.out.println(item.getAvailability());
            if(item.getNextmaintenance()==null){
                SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
                selectionModel.select(2);
            } 
            else {  
            
            labelmaintenance.setText(convert(item.getNextmaintenance()));}

            intervention = tableintervention.getSelectionModel().getSelectedItem();
        }
    }
    void filerItemList(String oldValue, String newValue) {
        ObservableList<Intervention> filteredList = FXCollections.observableArrayList();
        if (search.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            listintervention.clear();
            listintervention.addAll(findAll());
            tableintervention.setItems(listintervention);
        } else {
            newValue = newValue.toUpperCase();
            for (Intervention i : tableintervention.getItems()) {
                if (i.getItemname().toUpperCase().contains(newValue)) {
                    filteredList.add(i);
                } /*else if (Integer.toString(i.getBarcode()).contains(newValue)) {
                    filteredList.add(i);
                }*/
            }
            tableintervention.setItems(filteredList);
        }
    }
    void filerBreakdownList(String oldValue, String newValue) {
        ObservableList<Breakdown> filteredList = FXCollections.observableArrayList();
        if (searchbrk.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            listbreakdown.clear();
            listbreakdown.addAll(findAllBreakdown());
            breakdwonlist.setItems(listbreakdown);
        } else {
            newValue = newValue.toUpperCase();
            for (Breakdown i : breakdwonlist.getItems()) {
                if (i.getObjecttomaintain().getName().toUpperCase().contains(newValue)) {
                    filteredList.add(i);
                } /*else if (Integer.toString(i.getBarcode()).contains(newValue)) {
                    filteredList.add(i);
                }*/
            }
            breakdwonlist.setItems(filteredList);
        }
    }
    void filerStocklist(String oldValue, String newValue) {
        ObservableList<Item> filteredList = FXCollections.observableArrayList();
        if (searchstock.getText() == null || (newValue.length() < oldValue.length()) || newValue == null) {
            liststock.clear();
            liststock.addAll(findAllStock("For maintain"));
            stocklist.setItems(liststock);
        } else {
            newValue = newValue.toUpperCase();
            for (Item i : stocklist.getItems()) {
                if (i.getName().toUpperCase().contains(newValue)) {
                    filteredList.add(i);
                } /*else if (Integer.toString(i.getBarcode()).contains(newValue)) {
                    filteredList.add(i);
                }*/
            }
            stocklist.setItems(filteredList);
        }
    }
    private List<String> getItemNames() {
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
    void sendintervention(ActionEvent event) throws ParseException {
        Intervention intervention = new Intervention();
       // User user=new User();
      //  user=findUser(1);
       // System.out.println(user);
        Date timeStampDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");

        String formattedDate = dateFormat.format(timeStampDate);
        String formattedDate1 = dateFormat1.format(timeStampDate);

        System.out.println(formattedDate + "   A3TINI date svp");
        validationSupport = new ValidationSupport();

        intervention.setDescription(txtDescription.getText());

        validationSupport.registerValidator(desireddate, false, (Control c, LocalDate newValue) -> 
        ValidationResult.fromWarningIf(desireddate, "The date should be in the future", newValue.isBefore(LocalDate.now())));
        try {
            String di = desireddate.getValue()+"";
            String Error="";
         
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
              LocalDate localDate = LocalDate.parse( formattedDate1 , formatter);
              System.out.println(localDate+"zzzzzzzzzzzzzzz");
              if(desireddate.getValue() != null)
                  System.out.println(desireddate.getValue().isBefore(localDate)+"gggggggggggg");
              {if(desireddate.getValue().isBefore(localDate))
              {
                  Error+="Wrong Date!! \n";               
              }
              }
              if(Error != ""){
              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setTitle("Fields Missing");
              alert.setHeaderText(Error);
               alert.showAndWait();}
        
        
        
        
        intervention.setDesireddate(convert(desireddate.getEditor().getText()));

        if (typeintervention.getValue() == "PREVENTIVE") {
            intervention.setInterventiontype(InterventionType.PREVENTIVE);
        } else if (typeintervention.getValue() == "CORRECTIVE") {
            intervention.setInterventiontype(InterventionType.CORRECTIVE);
        } else if (typeintervention.getValue() == "IMPROVEMENT") {
            intervention.setInterventiontype(InterventionType.IMPROVEMENT);
        }

        if (cbpriority.getValue() == "NORMAL") {
            intervention.setPriority(InterventionPriority.NORMAL);
        } else if (cbpriority.getValue() == "URGENT") {
            intervention.setPriority(InterventionPriority.URGENT);

        }

        if (machinetype.getValue() == "ELECTRONIC") {
            intervention.setMachinetype(MachineType.ELECTRONIC);
        } else if (machinetype.getValue() == "MECANIQUE") {
            intervention.setMachinetype(MachineType.MECANIQUE);
        } else if (machinetype.getValue() == "OTHER") {
            intervention.setMachinetype(MachineType.OTHER);
        }

        intervention.setItem(machineref.getValue());

        intervention.setInterventionstatus(InterventionStatus.UNTREATED);
       intervention.setApplicant(LoginController.getLoggedUser());

        intervention.setItemname(machineref.getValue().getName());
       //intervention.setApplicant(user);
       
        intervention.setRequestdate(convert1(formattedDate));
        intervention.setApplicant(LoginController.getLoggedUser());
        if(Error==""){
            
       
        saveOrUpdateIntervention(intervention);
        Config2.dialog(Alert.AlertType.INFORMATION, "Success Save Data.."); }
        } catch (ParseException e) {
            
            e.printStackTrace();
        }
    }

    private void saveOrUpdateIntervention(Intervention i) {
        try {
            ctx = new InitialContext();
            interventionService = (InterventionServiceRemote) ctx.lookup(jndiNameIntervention);
            if (i.getId() == null) {
                interventionService.save(i);
            } else {
                interventionService.update(i);
            }
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
    }
    private void delete(Intervention i) {
        try {
            ctx = new InitialContext();
            interventionService = (InterventionServiceRemote) ctx.lookup(jndiNameIntervention);
          
                interventionService.delete(i);
            
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
    }

    /*
     * @FXML void searchintervention(ActionEvent event) {
     * 
     * }
     */
    private Item findItem(Integer id) {
        Item item = new Item();
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            item = itemService.find(id);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return item;
    }
    private User findUser(Integer id) {
        User user = new User();
        try {
            ctx = new InitialContext();
            userService = (UserServiceRemote) ctx.lookup(jndiNameUser);
            user = userService.find(id);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return user;
    }

    private List<Item> findAllRef( String category) {
        
        List<Item> ref = new ArrayList<>();
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            ref = itemService.getMachineList(category);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return ref;
    }

    private void clear() {
        txtDescription.clear();
        machinetype.setValue(null);
        machinetype.getItems().clear();

        machineref.getItems().clear();
        machineref.getItems().addAll(findAllRef("Machine"));

        // desireddate.setValue(null);
    }

    public static Date convert(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMM dd, yyyy
        // HH:mm:ss a");

        Date d1 = sdf.parse(date);
        return d1;
    }

    public static Date convert1(String date) throws ParseException {
        // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");

        Date d1 = sdf.parse(date);
        return d1;
    }

    public static String convert(Date d) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String text = df.format(d);
        return text;
    }
 private List<Item> findAllItem() {
        
        List<Item> ref = new ArrayList<>();
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            ref = itemService.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return ref;
    }

    private List<Intervention> findAll() {
        List<Intervention> interventions = new ArrayList<>();
        try {
            ctx = new InitialContext();
            interventionService = (InterventionServiceRemote) ctx.lookup(jndiNameIntervention);
            interventions = interventionService.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return interventions;
    }
    private List<Item> findAllStock(String cat) {
        List<Item> interventions = new ArrayList<>();
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
            interventions = itemService.ListStock(cat);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return interventions;
    }
    private List<Breakdown> findAllBreakdown() {
        List<Breakdown> breakdowns = new ArrayList<>();
        try {
            ctx = new InitialContext();
            breakdownService = (BreakdownServiceRemote) ctx.lookup(jndiNameBreakdown);
            breakdowns = breakdownService.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        System.out.println(breakdowns);
        return breakdowns;
    }
    
    private void selectData() {
        if (listintervention == null) {
            listintervention = FXCollections.observableArrayList(findAll());
        } else {
            listintervention.clear();
            listintervention.addAll(findAll());
        }
        tableintervention.setItems(listintervention);
    }
    private void selectDataBrk() {
        if (listbreakdown == null) {
            listbreakdown = FXCollections.observableArrayList(findAllBreakdown());
        } else {
            listbreakdown.clear();
            listbreakdown.addAll(findAllBreakdown());
        }
        breakdwonlist.setItems(listbreakdown);
    }
    private void selectDataStock() {
        if (liststock == null) {
            liststock = FXCollections.observableArrayList(findAllStock("For maintain"));
        } else {
            liststock.clear();
            liststock.addAll(findAllStock("For maintain"));
        }
        stocklist.setItems(liststock);
    }
    
    
    void afficher() {
        // listData = FXCollections.observableArrayList();
        // listData = FXCollections.observableArrayList();
        // Config2.setModelColumn(itemname, "name");
        selectData();

        Config2.setModelColumn(typeinter, "interventiontype");
        Config2.setModelColumn(requestdate, "requestdate");
       // Config2.setModelColumn(description, "description");
        Config2.setModelColumn(priority, "priority");

     //  Config2.setModelColumn(status, "interventionstatus");
        Config2.setModelColumn(coldate, "desireddate");
       
      
  status.setCellFactory(column -> {    return new TableCell<Intervention, String>() {

       
           @Override
            @SuppressWarnings("unchecked") 
            protected void updateItem(String item, boolean empty) {
                
                super.updateItem(item, empty);
                if (!empty) {
                    TableView<Intervention> tv = getTableView();

                    if ((tv != null))  {
                        if (tv.getItems().get(getTableRow().getIndex()).getInterventionstatus().toString().equals("INPROGRESS"))
                        {
                          

                            setStyle("-fx-background-color: orange");
                            } else if(tv.getItems().get(getTableRow().getIndex()).getInterventionstatus().toString().equals("TREATED")){
                           // setTextFill(Color.GREEN);
                                setStyle("-fx-background-color: green");
                        } else{
                            setStyle("-fx-background-color: red");
                          //  currentRow.setTextFill(Color.PINK);

                        }
                    } 
                    setText(tv.getItems().get(getTableRow().getIndex()).getInterventionstatus().toString());
                } 
            }
        
            };
        });   /*
             @Override
                protected void updateItem(String item, boolean empty) {
                
              // item="Asus";

                    super.updateItem(item, empty); //This is mandatory
                    if (item == null || empty) { //If the cell is empty
                        setText(null);
                        setStyle("");
                        System.out.println("NIKOMOK");
                    } else { //If the cell is not empty

                        setText(item); //Put the String data in the cell

                        //We get here all the info of the Person of this row
                        Intervention auxPerson = getTableView().getItems().get(getIndex());
                        // Style all persons wich name is "Edgard"
                        System.out.println(item);
                        if (auxPerson.getItemname().equals("Asus")) {
                           // setTextFill(Color.blue); //The text in red
                            setStyle("-fx-background-color: red"); //The background of the cell in yellow
                        } else {
                            //Here I see if the row of this cell is selected or not
                            if(getTableView().getSelectionModel().getSelectedItems().contains(auxPerson))
                              //  setTextFill(Color.WHITE);
                                setStyle("-fx-background-color: green"); //The background of the cell in yellow

                              //  setTextFill(Color.BLACK);
                        }
                    }
                }
            };
        });
        /*
        private TableColumn<Intervention, String> makeStringColumn(String columnName, String propertyName, int prefWidth) {
            TableColumn<Intervention, String> column = new TableColumn<>(columnName);
            column.setCellValueFactory(new PropertyValueFactory<Intervention, String>(propertyName));
            column.setCellFactory(new Callback<TableColumn<Intervention, String>, TableCell<Intervention, String>>() {
              @Override public TableCell<Intervention, String> call(TableColumn<Intervention, String> status) {
                return new TableCell<Intervention, String>() {
                  @Override public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                      setText(item);
                    }
                  }
                };
              }
            });
            column.setPrefWidth(prefWidth);

            return column;
          }*/
      /* status.setCellValueFactory(
               new Callback<TableColumn.CellDataFeatures<Intervention, String>, ObservableValue<String>>() {

                   @Override
                   public ObservableValue<String> call(CellDataFeatures<Intervention, String> param) {
                       return new SimpleStringProperty(param.getValue().getInterventionstatus().toString());
                   
                   }
               });*/
        
        assignedto.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Intervention, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Intervention, String> param) {
                        if(param.getValue().getRepairer()==null){
                            return new SimpleStringProperty("Not assigned yet");
                        } 
                        else {
                        return new SimpleStringProperty(param.getValue().getRepairer().getName());}
                    }
                });

        itemname.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Intervention, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Intervention, String> param) {
                        return new SimpleStringProperty(param.getValue().getItemname());
                    }
                });

        sender.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Intervention, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Intervention, String> param) {
                        return new SimpleStringProperty(param.getValue().getApplicant().getName());
                    }

                    // colAction.setCellFactory(new Callback<TableColumn<Record,
                    // Boolean>, TableCell<Record, Boolean>>() {

                });
        description.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Intervention, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Intervention, String> param) {
                        return new SimpleStringProperty(param.getValue().getDescription());
                    }

                    // colAction.setCellFactory(new Callback<TableColumn<Record,
                    // Boolean>, TableCell<Record, Boolean>>() {

                });
        interventionaction.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCell();
            }

        });

    }

    @FXML
    void moredetails(ActionEvent event) {

    }

    @FXML
    void addobservations(ActionEvent event) {
        Intervention intervention = new Intervention();

        intervention.setObservation(observation.getText());
        saveOrUpdateIntervention(intervention);
        afficher();

    }

    @FXML
    void updateitem(ActionEvent event) throws ParseException {
        Item item = new Item();
        item=machineref1.getValue();
        item.setAvailability(true);
        Intervention intervention = new Intervention();
        Breakdown breakdown = new Breakdown();

        if (guaranteeyes.isSelected()) {
            
            //guaranteepane.setOpacity(1);
            item.setUnderguarantee(true);
            item.setDurationguarantee(convert(endguarantee.getEditor().getText()));
        } else if (guaranteeno.isSelected()) {
            //guaranteepane.setOpacity(0);

            item.setUnderguarantee(false);
        }
        if (machinetype.getValue() == "ELECTRONIC") {
            item.setMachinetype(MachineType.ELECTRONIC);
        } else if (machinetype.getValue() == "MECANIQUE") {
            item.setMachinetype(MachineType.MECANIQUE);
        } else if (machinetype.getValue() == "OTHER") {
            item.setMachinetype(MachineType.OTHER);
        }



        item.setLastmaintenance(convert(lastmaintain.getEditor().getText()));
        item.setNextmaintenance(convert(nextmaintain.getEditor().getText()));

        if (stateFun.isSelected()) {
            
            item.setState(MachineState.FUNCTIONAL);
        } else if (stateUnf.isSelected()) {
            //availabilitypane.setOpacity(0);

            item.setState(MachineState.UNFUNCTIONAL);
            /*
            breakdown.setObjecttomaintain(item);
            try {
                ctx = new InitialContext();
                interventionService = (InterventionServiceRemote) ctx.lookup(jndiNameIntervention);
                System.out.println(item.getName());
              System.out.println(interventionService.getIntervention(item.getName()));
               intervention = interventionService.getIntervention(item.getName());
            } catch (NamingException e) {
                System.out.println("NamingException jndi");
            } catch (RejectedExecutionException e1) {
                System.out.println("catched rejected");
            }
            breakdown.setBreakdowndate(intervention.getRequestdate());
            if (intervention.getInterventionstatus().equals("UNTREATED"))
            {
            breakdown.setBreakdownstate(BreakdownState.UNTREATED);}
            else if (intervention.getInterventionstatus().equals("TREATED"))
            {
                breakdown.setBreakdownstate(BreakdownState.TREATED);
            } /*else if (intervention.getInterventionstatus().equals("INPROGRESS")){
                breakdown.setBreakdownstate(BreakdownState.INPROGRESS);
            }
            

            */
           /* try {
                ctx = new InitialContext();
                breakdownService = (BreakdownServiceRemote) ctx.lookup(jndiNameBreakdown);
              
                    breakdownService.save(breakdown);
                
            } catch (NamingException e) {
                System.out.println("NamingException jndi");
            } catch (RejectedExecutionException e1) {
                System.out.println("catched rejected");
            }
            
*/            
        }

        if (availabilityyes.isSelected()) {
            item.setAvailability(true);
        } else if (availabilityno.isSelected()) {
            item.setAvailability(false);
        }
        item.setObservation(observation.getText());
       idCnew = String.valueOf(machineref1.getValue().getId());
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
          
                item.setId(Integer.valueOf(idCnew));
                itemService.update(item);
            
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        
        idCnew = "";

        Config2.dialog(Alert.AlertType.INFORMATION, "Success Save Data..");
    }
    @FXML
    void odhhor1(ActionEvent event) {
        availabilitypane.setOpacity(1);

    }
    @FXML
    void tkhaba1(ActionEvent event) {
        availabilitypane.setOpacity(0);

    }
    @FXML
    void odhhor(ActionEvent event) {
        guaranteepane.setOpacity(1);

    }
    @FXML
    void tkhaba(ActionEvent event) {
        guaranteepane.setOpacity(0);

    }


    private void saveOrUpdateMachine(Item i) {
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

    @FXML
    void Back(ActionEvent event) {
        itemdetailsPane.setOpacity(0);
        itemdetailsPane.toBack();
        System.out.println("TKHABA");
    }
   /* private Intervention findInterventionByItem(String id) {
        Intervention intervention = new Intervention();
        try {
            ctx = new InitialContext();
            interventionService = (InterventionServiceRemote) ctx.lookup(jndiNameIntervention);
            intervention = interventionService.getIntervention(id);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return intervention;
    }
    */
    private Intervention findInterventionById(Integer id) {
        Intervention intervention = new Intervention();
        try {
            ctx = new InitialContext();
            interventionService = (InterventionServiceRemote) ctx.lookup(jndiNameIntervention);
            intervention = interventionService.find(id);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return intervention;
    }
    @FXML
    void addobservation(ActionEvent event) {
        Intervention intervention = new Intervention();
        System.out.println(idInter);
        intervention=findInterventionById(Integer.valueOf(idInter));
        intervention.setObservation(observation.getText());

        System.out.println(intervention);
       // intervention=id.getValue();
         try {
             ctx = new InitialContext();
             interventionService = (InterventionServiceRemote) ctx.lookup(jndiNameIntervention);
             
                 intervention.setId(Integer.valueOf(idInter));
                 interventionService.update(intervention);
             
         } catch (NamingException e) {
             System.out.println("NamingException jndi");
         } catch (RejectedExecutionException e1) {
             System.out.println("catched rejected");
         }
         //idInter = "";
         

        // saveOrUpdateMachine(item);
         Config2.dialog(Alert.AlertType.INFORMATION, "Success Save Data..");
    }
    
    @FXML
    void addbreakdown(ActionEvent event) throws ParseException {

        Intervention intervention = new Intervention();
        
        Breakdown breakdown = new Breakdown();
        intervention=findInterventionById(Integer.valueOf(idtreat));
        Item item =new Item();
        Date timeStampDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");

        String formattedDate = dateFormat.format(timeStampDate);
        item =intervention.getItem();
        System.out.println(item);
        breakdown.setObjecttomaintain(item);
    
        System.out.println(intervention.getDesireddate());
        breakdown.setRegistrationdate(convert1(formattedDate));
        breakdown.setBreakdowndate(intervention.getRequestdate());
        if (intervention.getInterventionstatus().toString().equals("UNTREATED"))
        {
        breakdown.setBreakdownstate(BreakdownState.UNTREATED);}
        else if (intervention.getInterventionstatus().toString().equals("TREATED"))
        {
            breakdown.setBreakdownstate(BreakdownState.TREATED);
        } else if (intervention.getInterventionstatus().toString().equals("INPROGRESS")){
            breakdown.setBreakdownstate(BreakdownState.UNTREATED);
        }
        User u = intervention.getRepairer();
        if(u!=null){
            breakdown.setRepairer(u);
        }
        
        System.out.println(breakdown);
        saveBreakdown(breakdown);
        idtreat="";
        Config2.dialog(Alert.AlertType.INFORMATION, "Success Save Data..");

  
        
    }
    private void saveBreakdown(Breakdown breakdown) {
        try {
            ctx = new InitialContext();
            breakdownService = (BreakdownServiceRemote) ctx.lookup(jndiNameBreakdown);
          
                breakdownService.save(breakdown);
            
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        
        


    }
    
    @FXML
    void calendar(ActionEvent event) {
        /*CalendarView calendarView = new CalendarView();
        Calendar expiration = new Calendar("Intervention");
        expiration.setStyle(Style.STYLE1);
        CalendarSource myCalendarSource = new CalendarSource("Interventions Dates");
        
        
        
        myCalendarSource.getCalendars().add(expiration);
        calendarView.getCalendarSources().addAll(myCalendarSource);

        for (Intervention i : findAll()) {
                System.out.println(i);
                Entry<String> date = new Entry<>(convert(i.getDesireddate()));
                date.setFullDay(true);
                Date input = i.getDesireddate();
                LocalDate dateL = Instant.ofEpochMilli(input.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                date.changeStartDate(dateL);
                expiration.addEntry(date);
                date.changeEndDate(dateL);
            }
      
        
        calendarView.setMaxSize(1225, 531);
        calendarView.setRequestedTime(LocalTime.now());
        calendarView.setShowAddCalendarButton(true);
        calendarView.setShowToolBar(true);
        calendarView.setShowDeveloperConsole(true);
        calendarView.setShowPageSwitcher(true);
        calendarView.setShowPageToolBarControls(true);
        calendarView.setShowPrintButton(false);
        calendarView.setShowSearchField(true);
        calendarView.setShowSearchResultsTray(true);
        calendarView.setShowSourceTray(false);
        calendarView.setShowSourceTrayButton(false);
        calendarView.setShowToday(true);
        calendarView.setShowToolBar(true);
        Stage primaryStage = new Stage();
        Scene scene = new Scene(calendarView);
        primaryStage.setTitle("Calendar");
        primaryStage.setScene(scene);
         primaryStage.setX(150);
         primaryStage.setY(172);
         primaryStage.setWidth(1131);
         primaryStage.setHeight(560);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();*/
     

        Intervention intervention = new Intervention();
        System.out.println(idtreat+"WIIIIIIIIIIIIIW");
        
        intervention=findInterventionById(Integer.valueOf(idtreat));
        intervention.setInterventionstatus(InterventionStatus.INPROGRESS);
        saveOrUpdateIntervention(intervention);
        afficher();
                boolean verif = false;
                int isOk = 0;
                String pwd="";
                String mail="";
                String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
                Pattern pattern = Pattern.compile(masque);
                Matcher controler = pattern.matcher("espritb1erp@gmail.com");
              
                
               
                   // Intervention intervention = new Intervention();
                    //System.out.println(idInter);
                  intervention=findInterventionById(Integer.valueOf(idtreat));
                   mail=intervention.getApplicant().getEmail();
                    
                        mail="malek.radhouane@esprit.tn";
                        
                    
             
               
                    envoyer(mail);
                
                }
         
        

            public void envoyer( String mail)
            {
                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");
                
                Session session = Session.getInstance(props,new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication("espritb1erp@gmail.com", "50628053");
                    }
                }); 
                try
                {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("espritb1erp@gmail.com"));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
                    message.setSubject("Intervention request treated");
                    message.setText("Hello ! We have treated your intervention request , Thank you");
                    Transport.send(message);
                    Notifications nb = Notifications.create().darkStyle().hideAfter(Duration.seconds(5)).title("Logout")
                            .text("Mail sent successfully !");
                          
                    nb.showConfirm();
         
                }
                catch(MessagingException e){
                    
                         Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failure to send");
                            alert.setHeaderText("Please check your informations !!");

                            alert.showAndWait();
                        
                     }      
                
            
        CalendarView calendarView = new CalendarView();
        Calendar meeting = new Calendar("meeting");

        Calendar ev = new Calendar("Event");
        meeting.setStyle(Style.STYLE1);
        ev.setStyle(Style.STYLE2);

        CalendarSource myCalendarSource = new CalendarSource("Schedules Dates");
        myCalendarSource.getCalendars().add(meeting);
        myCalendarSource.getCalendars().add(ev);
        calendarView.getCalendarSources().addAll(myCalendarSource);

        for (Intervention s : findAll()) {

            System.out.println(s);

                Entry<String> date = new Entry<>(s.getItemname());
                date.setFullDay(false);
                //date.setLocation(m.getPlace());

                Date input = s.getDesireddate();
                LocalDate dateL = Instant.ofEpochMilli(input.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                date.changeStartDate(dateL);
                meeting.addEntry(date);
                date.changeEndDate(dateL);
            }
         

        

        calendarView.setMaxSize(1225, 531);
        calendarView.setRequestedTime(LocalTime.now());
        calendarView.setShowAddCalendarButton(false);
        calendarView.setShowToolBar(false);// false
        calendarView.setShowDeveloperConsole(false);
        calendarView.setShowPageSwitcher(true);// false
        calendarView.setShowPageToolBarControls(true);// false
        calendarView.setShowPrintButton(false);
        calendarView.setShowSearchField(true);// false
        calendarView.setShowSearchResultsTray(true);// false
        calendarView.setShowSourceTray(false);// false
        calendarView.setShowSourceTrayButton(false);// false
        calendarView.setShowToday(true);// false
        calendarView.setShowToolBar(true);// false

        // **************************************************************
        Stage primaryStage = new Stage();
        Scene scene = new Scene(calendarView);
        primaryStage.setTitle("Calendar");
        primaryStage.setScene(scene);
        primaryStage.setX(150);
        primaryStage.setY(150);// 172
        primaryStage.setWidth(1131);// 1131
        primaryStage.setHeight(560);// 560
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();


       /* assignt.setOpacity(1);
        assignt.toFront();*/
        
    }
    
    @FXML
    void Backintervention(ActionEvent event) {

        interventiondetails.setOpacity(0);
        interventiondetails.toBack();
    }
    @FXML
    void Backintervention1(ActionEvent event) {

        assignt.setOpacity(0);
        assignt.toBack();
    }
    
    void afficherbreakdown() {
        // listData = FXCollections.observableArrayList();
        // listData = FXCollections.observableArrayList();
        // Config2.setModelColumn(itemname, "name");
        selectDataBrk();

        Config2.setModelColumn(item, "objecttomaintain");
        Config2.setModelColumn(breakdowndate, "breakdowndate");
        //Config2.setModelColumn(state, "breakdownstate");

        Config2.setModelColumn(descriptionbrk, "description");
        Config2.setModelColumn(registrationdate, "registrationdate");

        item.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Breakdown, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Breakdown, String> param) {
                        return new SimpleStringProperty(param.getValue().getObjecttomaintain().getName());
                    }
                });
        state.setCellFactory(column -> {    return new TableCell<Breakdown, String>() {

            
            @Override
             @SuppressWarnings("unchecked") 
             protected void updateItem(String item, boolean empty) {
                 
                 super.updateItem(item, empty);
                 if (!empty) {
                     TableView<Breakdown> tv = getTableView();

                     if ((tv != null))  {
                         if (tv.getItems().get(getTableRow().getIndex()).getBreakdownstate().toString().equals("TREATED"))
                         {
                           

                             setStyle("-fx-background-color: green");
                             } else if(tv.getItems().get(getTableRow().getIndex()).getBreakdownstate().toString().equals("UNTREATED")){
                            // setTextFill(Color.GREEN);
                                 setStyle("-fx-background-color: red");
                         } 
                          
                     } 
                     setText(tv.getItems().get(getTableRow().getIndex()).getBreakdownstate().toString());
                 } 
             }
         
             };
         });
        treatedby.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Breakdown, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Breakdown, String> param) {
                        if(param.getValue().getRepairer()==null){
                            return new SimpleStringProperty("Not assigned yet");
                        } 
                        else {
                        return new SimpleStringProperty(param.getValue().getRepairer().getName());}
                    }
                });

        

        ActionBrk.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCellbrk();
            }

        });
        
       

    }
    
    void afficherstock() {
        // listData = FXCollections.observableArrayList();
        // listData = FXCollections.observableArrayList();
        // Config2.setModelColumn(itemname, "name");
        selectDataStock();

        Config2.setModelColumn(item1, "name");
        Config2.setModelColumn(qnt, "quantity");
        Config2.setModelColumn(prixu, "byingPrice");

        Config2.setModelColumn(descriptionstock, "description");
      

        

        stockAction.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCellstock();
            }

        });

    }
    
    void deletebrk(Breakdown i) {
        try {
            ctx = new InitialContext();
            breakdownService = (BreakdownServiceRemote) ctx.lookup(jndiNameBreakdown);
            breakdownService.delete(i);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
   
    private class ButtonCellbrk extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("Delete");
        final Hyperlink cellButtonEdit = new Hyperlink("Edit");
        final HBox hb = new HBox(cellButtonDelete, cellButtonEdit);

        public ButtonCellbrk() {
            hb.setSpacing(4);
            cellButtonDelete.setOnAction((ActionEvent t) -> {
                int row = getTableRow().getIndex();
                breakdwonlist.getSelectionModel().select(row);
                Toolkit.getDefaultToolkit().beep();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Delete Data ?");
                alert.initStyle(StageStyle.UTILITY);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Breakdown i = breakdwonlist.getSelectionModel().getSelectedItem();
                  deletebrk(i);
                    clear();
                    selectDataBrk();
                } else {
                    clear();
                    selectDataBrk();
                }
               
            });

            cellButtonEdit.setOnAction(t -> {
                int row = getTableRow().getIndex();
                breakdwonlist.getSelectionModel().select(row);
                // aksiKlikTableData(null);
              //  System.out.println("WOOOOOOOOOOOOOOOOY");
                Breakdowndetails.setOpacity(1);
                Breakdowndetails.toFront();
                

                   // clear();
                    Breakdown i = breakdwonlist.getSelectionModel().getSelectedItem();
                    
                    //interventiondetails.setOpacity(1);
                    idbreak =String.valueOf(i.getId()) ;
                    System.out.println(idbreak);
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
    private class ButtonCellItemu extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("Delete");
        final HBox hb = new HBox(cellButtonDelete);

        public ButtonCellItemu() {
            hb.setSpacing(4);
            cellButtonDelete.setOnAction((ActionEvent t) -> {
                int row = getTableRow().getIndex();
                itemused.getSelectionModel().select(row);
                Toolkit.getDefaultToolkit().beep();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Delete Data ?");
                alert.initStyle(StageStyle.UTILITY);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Item i = itemused.getSelectionModel().getSelectedItem();
     
                    listData.remove(i);
                    quantite.clear();
                    afficheritemused();
                } else {
                    clear();
                    selectDataStock();
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
    
    private class ButtonCellstock extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonAdd = new Hyperlink("Add");
        //final Hyperlink cellButtonEdit = new Hyperlink("Edit");
        final HBox hb = new HBox(cellButtonAdd);

        public ButtonCellstock() {
            hb.setSpacing(4);
            cellButtonAdd.setOnAction((ActionEvent t) -> {
            
                    int row = getTableRow().getIndex();
                    stocklist.getSelectionModel().select(row);
                    // aksiKlikTableData(null);
                  //  System.out.println("WOOOOOOOOOOOOOOOOY");
                    stockpane.setOpacity(1);
                    stockpane.toFront();
                    

                       // clear();
                        Item i = stocklist.getSelectionModel().getSelectedItem();
                        
                        //interventiondetails.setOpacity(1);
                        idstock =String.valueOf(i.getId()) ;
                        System.out.println(idstock);
                       /* txtId.setText(Integer.toString(i.getId()));
                        paneTabel.setOpacity(0);
                        SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
                        selectionModel.select(0);
                        new FadeInUpTransition(TabPane).play();
                        status = 0;*/
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

    
    
    @FXML
    void Backbreakdown(ActionEvent event) {

        Breakdowndetails.setOpacity(0);
        Breakdowndetails.toBack();
    }
    private void Updatebrk(Breakdown i) {
        try {
            ctx = new InitialContext();
            breakdownService = (BreakdownServiceRemote) ctx.lookup(jndiNameBreakdown);
          
                breakdownService.update(i);
            
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
    }
    private Breakdown findBreakdownById(Integer id) {
        Breakdown breakdown = new Breakdown();
        try {
            ctx = new InitialContext();
            breakdownService = (BreakdownServiceRemote) ctx.lookup(jndiNameBreakdown);
            breakdown = breakdownService.find(id);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return breakdown;
    }
 
    
    
    private List<User> findUserByRole(UserFunction id) {
        List<User> user = new ArrayList<>();
        try {
            ctx = new InitialContext();
            userService = (UserServiceRemote) ctx.lookup(jndiNameUser);
            user = userService.findByFunction(id);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return user;
    }
    
    @FXML
    void updatebreakdown(ActionEvent event) {
        Breakdown breakdown = new Breakdown();
        breakdown = findBreakdownById(Integer.valueOf(idbreak));
        if(brkstate.getValue().equals("TREATED")){
         breakdown.setBreakdownstate(BreakdownState.TREATED);  
         Breakdowndetails1.setOpacity(1);
         Breakdowndetails1.toFront();
         
        }else         if(brkstate.getValue().equals("UNTREATED")){
            breakdown.setBreakdownstate(BreakdownState.UNTREATED);   

        }
        breakdown.setDescription(observationbrk.getText());
        Updatebrk(breakdown);
        afficherbreakdown();
    }

   /* @FXML
    void assigntech(ActionEvent event) {
        Breakdown breakdown = new Breakdown();
        Intervention intervention = new Intervention();
        User u = new User();
        /*breakdown = findBreakdownById(Integer.valueOf(idbreak));
        breakdown.setRepairer(tech.getValue());
        Updatebrk(breakdown);
        afficherbreakdown();
        System.out.println(idtreat+"IDDDDDD");
        intervention = findInterventionById(Integer.valueOf(idtreat));
        intervention.setRepairer(tech.getValue());
        intervention.setInterventionstatus(InterventionStatus.INPROGRESS);
        saveOrUpdateIntervention(intervention);
        afficher();
        

       
    }*/
    
    @FXML
    void BackStock(ActionEvent event) {

        stockpane.setOpacity(0);
        stockpane.toBack();
    }
    
    @FXML
    void AddStock(ActionEvent event) {
        Item item = new Item();
     item = findItem(Integer.valueOf(idstock));
     int q = item.getQuantity();
     int qu=q+Integer.valueOf(addqnt.getText());
     item.setQuantity(qu);
      //  idCnew = String.valueOf(machineref1.getValue().getId());
        try {
            ctx = new InitialContext();
            itemService = (ItemServiceRemote) ctx.lookup(jndiNameItem);
          
                item.setId(Integer.valueOf(idstock));
                itemService.update(item);
            
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        

        Config2.dialog(Alert.AlertType.INFORMATION, "Success Save Data..");
        afficherstock();
    }
     
    @FXML
    void Backbreakdown1(ActionEvent event) {

        Breakdowndetails1.setOpacity(0);
        Breakdowndetails1.toBack();
    }

    @FXML
    void updatebreakdown1(ActionEvent event) {
        Breakdown breakdown = new Breakdown();
        System.out.println(idbreak+"kkkk");
        breakdown=findBreakdownById(Integer.valueOf(idbreak));
     //  Item i =new Item();
      // itemu.
        float p=0;
        int i=0;
        for (Integer increm2 : quantite) {
             i=i+increm2;
             for (Item item :itemused.getItems()){
                 p=increm2*item.getByingPrice();
             }
        }
        Set<Item> bb = new HashSet(listData);
       // item.setBreakdown(bb);
        System.out.println(i+"sssssssssss");
      
       // String cur = namestock.getValue().getCurrency();
        prix.setText("Cost : "+p );
        prix.setVisible(true);
        breakdown.setPrice(i);
        breakdown.setItems(bb);
        Updatebrk(breakdown);
        quantite.clear();

        
    }
    
    
    @FXML
    void rapport(ActionEvent event)throws IOException {
        reportEditor.setHtmlText("Write a report..");
       /* reportEditor.setVisible(true);
        //reportEditor.setDisable(true);
        reportEditor.setOpacity(1);
        reportEditor.toFront();*/

        String response = new String();
            
        reportEditor.setHtmlText(response);
        
        writerapportpane.setOpacity(1);
        writerapportpane.toFront();
        writerapportpane.setVisible(true);
        new FadeInUpTransition(writerapportpane).play();
    }
    
    @FXML
    void Backbreakdown11(ActionEvent event) {

        writerapportpane.setOpacity(0);
        writerapportpane.toBack();
    }
    @FXML
    void Submitreport(ActionEvent event) {
        Breakdown breakdown = new Breakdown();
        breakdown=findBreakdownById(Integer.valueOf(idbreak));
            //breakdown.setDescription(reportEditor.getHtmlText());
            String stringHtml = reportEditor.getHtmlText();

            FileChooser fileChooser = new FileChooser();

            // Set extension filter
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");
            fileChooser.getExtensionFilters().add(extFilter);

            // Show save file dialog
            Stage stage = (Stage) searchbrk.getScene().getWindow();

                File file = fileChooser.showSaveDialog(stage);
                if (file != null) {

                    SaveFile(stringHtml, file);
                    rapport = file.getAbsolutePath();
                    int fileNameIndex = rapport.lastIndexOf("\\") + 1;
                    System.out.println(rapport);
                    System.out.println(fileNameIndex);
                    rapport1 = rapport.substring(fileNameIndex);
                    File dest = new File("C:\\wamp64\\www\\imagesAmine\\" + rapport1);
                    try {
                        copyFileUsingStream(file, dest);
                    } catch (IOException e) {
                    }

                    
                   // System.out.println(rapprot+"HEEH");

                    // saleOpportunity.setReport(report);

                    Config2.dialog(Alert.AlertType.INFORMATION, "Data Saved successfully..");
                }
            breakdown.setReport(rapport1);
            
            Updatebrk(breakdown);
            afficherbreakdown();
            
            writerapportpane.setOpacity(0);
            writerapportpane.toBack();
            /*report = reportService.findByDescription(report.getDescrpiton()).get(0);
            System.out.println(report);
            new FadeOutUpTransition(reportAnchor).play();
            btnNew1.setVisible(false);
            pathHyperLink.setVisible(false);
            labelFromNewReport.setVisible(true);
            labelFromNewReport.setText("Report Added");*/

        

        
       
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
    
    
        
    void afficheritem() {
        // listData = FXCollections.observableArrayList();
        // listData = FXCollections.observableArrayList();
        // Config2.setModelColumn(itemname, "name");
        selectDataStock();

        Config2.setModelColumn(item2, "name");
    }
    @FXML
    void itemclicked(MouseEvent event) {
        if (event.getClickCount() == 2) // Checking double click
        {
            Item item = new Item();
            //String N = tableintervention.getSelectionModel().getSelectedItem().getItemname();
            iditembrk = String.valueOf(itembrk.getSelectionModel().getSelectedItem().getId());
           // item = tableintervention.getSelectionModel().getSelectedItem().getItem()
            item=itembrk.getSelectionModel().getSelectedItem();
            listData.add(item);
            System.out.println(listData+"hhhhhhhhhhhhaaaa");
            pieceneeded.setText("");
            afficheritemused();
            itemqnt.setVisible(true);
            itemqnt.setOpacity(1);
            itemqnt.toFront();
            
            
        }
    }
   /* void afficherqnt() {
        // listData = FXCollections.observableArrayList();
        // listData = FXCollections.observableArrayList();
        // Config2.setModelColumn(itemname, "name");
        itemquantity.setItems(FXCollections.observableArrayList(quantite));

           
        quantityu.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Integer, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Integer, String> param) {
                       
                        return new SimpleStringProperty(String.valueOf(param.getValue()));
                        
                    }
                }); }
        
           */
    
    void afficheritemused() {
            // listData = FXCollections.observableArrayList();
            // listData = FXCollections.observableArrayList();
            // Config2.setModelColumn(itemname, "name");
            itemused.setItems(FXCollections.observableArrayList(listData));

           // Config2.setModelColumn(itemu, "name"+" "+qntp);
            //for (Integer i : quantite) {
            
            List<Item> x=new ArrayList<>();
            x.addAll(itemused.getItems());
            int i=0;

            for(Item item :x)
            {
                i++;
                a=i;
            }
          // int x=0;
          /*  for( a=0;a<i-1;a++){
            */   
            itemu.setCellValueFactory(
                    new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {

                        @Override
                        public ObservableValue<String> call(CellDataFeatures<Item, String> param) {
                           
                            return new SimpleStringProperty(qntp+" "+param.getValue().getName());
                            
                        }
                    }); 
            actionitemu.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

                @Override
                public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                    // TODO Auto-generated method stub
                    return new ButtonCellItemu();
                }

            });
            
        }
        
       

    
    
    @FXML
    void itemusedclicked(MouseEvent event) {
        
    }
    
    @FXML
    void Backbreakdown3(ActionEvent event) {

        itemqnt.setOpacity(0);
        itemqnt.toBack();
    }
    
    @FXML
    void ok (ActionEvent event) {

        qntp=pieceneeded.getText();
        itemqnt.setOpacity(0);
        itemqnt.toBack();
        afficheritemused();
        quantite.add(Integer.valueOf(qntp));
       // afficherqnt();

    }
    
    
}


