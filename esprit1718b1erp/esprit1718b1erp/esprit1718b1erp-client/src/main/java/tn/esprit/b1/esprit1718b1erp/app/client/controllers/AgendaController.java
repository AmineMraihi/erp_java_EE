package tn.esprit.b1.esprit1718b1erp.app.client.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
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
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.bouncycastle.asn1.isismtt.x509.AdditionalInformationSyntax;
import org.controlsfx.control.Notifications;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.model.Calendar.Style;
import com.calendarfx.model.CalendarEvent;
import com.calendarfx.view.CalendarView;
import com.sun.prism.impl.Disposer.Record;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;
//import tn.esprit.b1.esprit1718b1erp.app.client.controllers.ContactController.ButtonCell;
//import tn.esprit.b1.esprit1718b1erp.app.client.controllers.ContactController.ButtonCell;
import tn.esprit.b1.esprit1718b1erp.entities.Contact;
import tn.esprit.b1.esprit1718b1erp.entities.Event;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.Meeting;
import tn.esprit.b1.esprit1718b1erp.entities.Particular;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Schedule;
import tn.esprit.b1.esprit1718b1erp.entities.StateProject;
import tn.esprit.b1.esprit1718b1erp.services.amine.ItemServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.jassem.ScheduleServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectServiceRemote;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Calendar.Style;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.view.CalendarView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener.Change;
import javafx.event.ActionEvent;
//import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import javafx.scene.control.Button;

public class AgendaController implements Initializable {
    @FXML
    private AnchorPane AgendaPane;

    @FXML
    private TabPane TabPane;

    @FXML
    private AnchorPane paneCrud;

    @FXML
    private Button btnAddMeeting;

    @FXML
    private ComboBox<String> cbProjectM;

    @FXML
    private ImageView addCategory;

    @FXML
    private TextField txttitleM;

    @FXML
    private TextField txtBudgetM;

    @FXML
    private TextField txtPlaceM;

    @FXML
    private DatePicker txtDateM;

    @FXML
    private TextArea txtDescriptionM;

    @FXML
    private ComboBox<String> cbProjectM1;

    @FXML
    private ImageView addCategory1;

    @FXML
    private AnchorPane paneCrud1;

    @FXML
    private Button btnBack1;

    @FXML
    private AnchorPane paneCrud2;

    @FXML
    private ImageView imgItem1;

    @FXML
    private Button btnUpload1;

    @FXML
    private Button btnAddEvent;

    @FXML
    private ComboBox<String> cbProjectE;

    @FXML
    private TextField txtTitleE;

    @FXML
    private TextField txtBudgetE;

    @FXML
    private TextField txtPlaceE;

    @FXML
    private DatePicker txtDateE;

    @FXML
    private TextArea txtDescriptionE;

    @FXML
    private ImageView addProjectE;

    @FXML
    private Button btnCalendar;
    @FXML
    private ListView<Particular> ListPersons;

    @FXML
    private TableView<Particular> tablePersons;

    @FXML
    private TableColumn<Particular, String> colNomPerson;

    @FXML
    private TableColumn<Particular, String> colPrenomPerson;
    @FXML
    private TableColumn colAction;
    @FXML
    private ListView<Particular> ListPersons1;

    @FXML
    private TableView<Particular> tablePersons1;

    @FXML
    private TableColumn<Particular, String> colNomPerson1;

    @FXML
    private TableColumn<Particular, String> colPrenomPerson1;

    @FXML
    private TableColumn colAction1;

    @FXML
    private TableView<Event> TableHandleEvents;

    @FXML
    private TableColumn<String, String> ColTypeEvent;

    @FXML
    private TableColumn<Event, String> ColTitleEvent;

    @FXML
    private TableColumn<Event, String> ColDateEvent;
    @FXML
    private TableColumn<Event, String> ColPlaceEvent;

    @FXML
    private TableColumn<Event, String> ColBudgetEvent;

    @FXML
    private TableColumn ColProjectEvent;

    @FXML
    private TableColumn ColActionEvent;
    @FXML
    private TableView<Meeting> TableHandleMeetings;

    @FXML
    private TableColumn<String, String> ColTypeEvent1;

    @FXML
    private TableColumn<Meeting, String> ColTitleEvent1;

    @FXML
    private TableColumn<Meeting, String> ColDateEvent1;

    @FXML
    private TableColumn<Meeting, String> ColPlaceEvent1;

    @FXML
    private TableColumn<Meeting, String> ColBudgetEvent1;

    @FXML
    private TableColumn ColProjectEvent1;

    @FXML
    private TableColumn ColActionEvent1;

    private final String jndiNameSchedule = "esprit1718b1erp-ear/esprit1718b1erp-service/ScheduleService!tn.esprit.b1.esprit1718b1erp.services.jassem.ScheduleServiceRemote";
    private final String jndiNameProject = "esprit1718b1erp-ear/esprit1718b1erp-service/ProjectService!tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectServiceRemote";
    private final String jndiNameContact = "esprit1718b1erp-ear/esprit1718b1erp-service/ContactService!tn.esprit.b1.esprit1718b1erp.services.jassem.ContactServiceRemote";
    private InitialContext ctx = null;
    ScheduleServiceRemote scheduleServiceRemote;
    ProjectServiceRemote projectServiceRemote;
    ContactServiceRemote contactServiceRemote;
    String getImageUrl, imgName;
    Boolean selectimage = false;
    ObservableList<Contact> con;
    List<Particular> participants = new ArrayList<Particular>();
    List<Particular> participants1 = new ArrayList<Particular>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        try {
            ctx = new InitialContext();
            projectServiceRemote = (ProjectServiceRemote) ctx.lookup(jndiNameProject);
            contactServiceRemote = (ContactServiceRemote) ctx.lookup(jndiNameContact);
            scheduleServiceRemote = (ScheduleServiceRemote) ctx.lookup(jndiNameSchedule);
            cbProjectE.getItems().addAll(projectServiceRemote.findAllProjectsNames());
            cbProjectM.getItems().addAll(projectServiceRemote.findAllProjectsNames());

        } catch (NamingException e) {

            e.printStackTrace();
        }
        AfficherEvents(); // Table Handle Events
        AfficherMeetings(); // Table Handle Events

        con = FXCollections.observableArrayList(contactServiceRemote.findAllParticular());
        ListPersons.setCellFactory((ListView<Particular> arg2) -> {
            ListCell<Particular> cell = new ListCell<Particular>() {
                @Override
                protected void updateItem(Particular p, boolean btl) {
                    super.updateItem(p, btl);

                    if (p != null) {

                        File file = new File("C:\\wamp64\\www\\imagejassem\\" + p.getPicture());
                        file.getParentFile().mkdirs();
                        Image IMAGE_RUBY = new Image(file.toURI().toString());
                        ImageView imgview = new ImageView(IMAGE_RUBY);

                        setGraphic(imgview);

                        imgview.setFitHeight(50);
                        imgview.setFitWidth(50);
                        Rectangle clip = new Rectangle(imgview.getFitWidth(), imgview.getFitHeight());

                        clip.setArcWidth(20);
                        clip.setArcHeight(20);
                        imgview.setClip(clip);

                        // snapshot the rounded image.
                        SnapshotParameters parameters = new SnapshotParameters();
                        parameters.setFill(Color.TRANSPARENT);
                        WritableImage image = imgview.snapshot(parameters, null);

                        // remove the rounding clip so that our effect can show
                        // through.
                        imgview.setClip(null);

                        // apply a shadow effect.
                        imgview.setEffect(new DropShadow(20, Color.BLACK));

                        // store the rounded image in the imageView.
                        imgview.setImage(image);
                        ListPersons.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                                    participants.add(ListPersons.getSelectionModel().getSelectedItem());
                                    afficher();
                                }
                            }
                        });
                        setText("First Name: " + p.getFirst_name() + "\nLast Name: " + p.getName() + "\n");

                        setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                        // setAlignment(Pos.CENTER);
                    }

                }

            };
            return cell;

        });
        ListPersons.setItems(FXCollections.observableArrayList(contactServiceRemote.findAllParticular()));
        ListPersons1.setCellFactory((ListView<Particular> arg2) -> {
            ListCell<Particular> cell = new ListCell<Particular>() {
                @Override
                protected void updateItem(Particular p, boolean btl) {
                    super.updateItem(p, btl);

                    if (p != null) {

                        File file = new File("C:\\wamp64\\www\\imagejassem\\" + p.getPicture());
                        file.getParentFile().mkdirs();
                        Image IMAGE_RUBY = new Image(file.toURI().toString());
                        ImageView imgview = new ImageView(IMAGE_RUBY);

                        setGraphic(imgview);

                        imgview.setFitHeight(50);
                        imgview.setFitWidth(50);
                        Rectangle clip = new Rectangle(imgview.getFitWidth(), imgview.getFitHeight());

                        clip.setArcWidth(20);
                        clip.setArcHeight(20);
                        imgview.setClip(clip);

                        // snapshot the rounded image.
                        SnapshotParameters parameters = new SnapshotParameters();
                        parameters.setFill(Color.TRANSPARENT);
                        WritableImage image = imgview.snapshot(parameters, null);

                        // remove the rounding clip so that our effect can show
                        // through.
                        imgview.setClip(null);

                        // apply a shadow effect.
                        imgview.setEffect(new DropShadow(20, Color.BLACK));

                        // store the rounded image in the imageView.
                        imgview.setImage(image);
                        ListPersons1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                                    participants1.add(ListPersons1.getSelectionModel().getSelectedItem());
                                    afficher1();
                                }
                            }
                        });
                        setText("First Name: " + p.getFirst_name() + "\nLast Name: " + p.getName() + "\n");

                        setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                        // setAlignment(Pos.CENTER);
                    }

                }

            };
            return cell;

        });
        ListPersons1.setItems(FXCollections.observableArrayList(contactServiceRemote.findAllParticular()));

    }

    public void CreateAgenda() {
        CalendarView calendarView = new CalendarView();
        Calendar meeting = new Calendar("meeting");

        Calendar ev = new Calendar("Event");
        meeting.setStyle(Style.STYLE1);
        ev.setStyle(Style.STYLE2);

        CalendarSource myCalendarSource = new CalendarSource("Schedules Dates");
        myCalendarSource.getCalendars().add(meeting);
        myCalendarSource.getCalendars().add(ev);
        calendarView.getCalendarSources().addAll(myCalendarSource);

        for (Schedule s : findAll()) {

            System.out.println(s);
            if (s instanceof Meeting) {
                Meeting m = new Meeting();
                m = (Meeting) s;
                Entry<String> date = new Entry<>(m.getMeetingName());
                date.setFullDay(false);
                date.setLocation(m.getPlace());

                Date input = m.getTargetDate();
                LocalDate dateL = Instant.ofEpochMilli(input.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                date.changeStartDate(dateL);
                meeting.addEntry(date);
                date.changeEndDate(dateL);
            }
            if (s instanceof Event) {
                Event e = new tn.esprit.b1.esprit1718b1erp.entities.Event();
                e = (Event) s;
                Entry<String> date = new Entry<>(e.getEventName());
                date.setFullDay(false);
                date.setLocation(e.getPlace());
                Date input = e.getTargetDate();
                LocalDate dateL = Instant.ofEpochMilli(input.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                date.changeStartDate(dateL);
                ev.addEntry(date);
                date.changeEndDate(dateL);
            }

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
        primaryStage.setWidth(1200);// 1131
        primaryStage.setHeight(560);// 560
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }

    private List<Schedule> findAll() {
        List<Schedule> schedules = new ArrayList<>();
        try {
            ctx = new InitialContext();
            scheduleServiceRemote = (ScheduleServiceRemote) ctx.lookup(jndiNameSchedule);
            schedules = scheduleServiceRemote.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return schedules;
    }

    @FXML
    void ShowCalendar(ActionEvent event) {
        CreateAgenda();

    }

    @FXML
    void addContactMButton(MouseEvent event) {

    }

    @FXML
    void addEvent(ActionEvent event) throws ParseException {
        try {
            ctx = new InitialContext();
            projectServiceRemote = (ProjectServiceRemote) ctx.lookup(jndiNameProject);
        } catch (NamingException e) {

            e.printStackTrace();
        }
        Event e = new tn.esprit.b1.esprit1718b1erp.entities.Event();
        if (!txtDateE.getEditor().getText().equals("")) {

            e.setTargetDate(convert(txtDateE.getEditor().getText()));
        } else {
            Config2.dialog(Alert.AlertType.INFORMATION, "empty Date field !");
        }
        e.setDescription(txtDescriptionE.getText());
        e.setBudget(Integer.valueOf(txtBudgetE.getText()));
        e.setEventName(txtTitleE.getText());
        e.setPlace(txtPlaceE.getText());
        e.setCreator(LoginController.getLoggedUser());
        e.setIdProject(projectServiceRemote.findProjectByName(cbProjectE.getValue()));
        Set<Particular> par = new HashSet<Particular>(participants);
        e.setContacts(par);
        if (selectimage) {
            e.setLogo(imgName);
        } else {

            e.setLogo("");
        }

        try {
            ctx = new InitialContext();
            scheduleServiceRemote = (ScheduleServiceRemote) ctx.lookup(jndiNameSchedule);
            Project p1 = new Project();
            p1 = projectServiceRemote.findProjectByName(cbProjectE.getValue());
            if (Integer.valueOf(txtBudgetE.getText()) < p1.getBugdet()) {

                // ******************************************************************************
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(convert(txtDateE.getEditor().getText()));
                int moisevent, moisSysDate;
                moisevent = cal.get(cal.MONTH) + 1;
                /*
                 * test SYSDATE
                 ********************************************************************/
                Date timeStampDate = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");

                String formattedDate = dateFormat.format(timeStampDate);
                Date d = new Date();
                try {
                    d = convert(formattedDate);

                } catch (ParseException e1) {

                    e1.printStackTrace();
                }
                // System.out.println( d.getMonth()+1);
                GregorianCalendar cal1 = new GregorianCalendar();
                cal1.setTime(d);

                moisSysDate = cal1.get(cal1.MONTH) + 1;

                /**********************************/
                if (moisevent >= moisSysDate) {

                    p1.setBugdet(p1.getBugdet() - Integer.valueOf(txtBudgetE.getText()));
                    projectServiceRemote.update(p1);
                    scheduleServiceRemote.save(e);
                    for (Particular p : par) {
                        envoyer(p.getEmail(), p, txtTitleE.getText());
                    }
                    Notifications nb23 = Notifications.create().darkStyle().hideAfter(Duration.seconds(40))
                            .title("Budget").text("Project Budget has been modified !");
                    nb23.showConfirm();
                    Config2.dialog(Alert.AlertType.INFORMATION, "Success Save Data..");
                } else {
                    Config2.dialog(Alert.AlertType.INFORMATION, "Verify Event Date !");
                }
            } else {
                Config2.dialog(Alert.AlertType.INFORMATION, "Event budget should be inferior than Project Budget : "
                        + projectServiceRemote.findProjectByName(cbProjectE.getValue()).getBugdet());
            }

        } catch (NamingException ex) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }

    }

    @FXML
    void aksiBack(ActionEvent event) {

    }

    @FXML
    void addMeeting(ActionEvent event) throws ParseException {
        try {
            ctx = new InitialContext();
            projectServiceRemote = (ProjectServiceRemote) ctx.lookup(jndiNameProject);
        } catch (NamingException e) {

            e.printStackTrace();
        }
        Meeting meeting = new Meeting();

        meeting.setTargetDate(convert(txtDateM.getEditor().getText()));
        meeting.setDescription(txtDescriptionM.getText());
        meeting.setBudget(Integer.valueOf(txtBudgetM.getText()));
        meeting.setMeetingName(txttitleM.getText());
        meeting.setPlace(txtPlaceM.getText());
        Set<Particular> par = new HashSet<Particular>(participants1);
        meeting.setContactsM(par);
        meeting.setCreator(LoginController.getLoggedUser());
        meeting.setIdProject(projectServiceRemote.findProjectByName(cbProjectM.getValue()));

        try {
            ctx = new InitialContext();
            scheduleServiceRemote = (ScheduleServiceRemote) ctx.lookup(jndiNameSchedule);
            Project p1 = new Project();
            p1 = projectServiceRemote.findProjectByName(cbProjectM.getValue());
            if (Integer.valueOf(txtBudgetM.getText()) < p1.getBugdet()) {
                // ******************************************************************************
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(convert(txtDateM.getEditor().getText()));
                int moisevent, moisSysDate;
                moisevent = cal.get(cal.MONTH) + 1;
                /*
                 * test SYSDATE
                 ********************************************************************/
                Date timeStampDate = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");

                String formattedDate = dateFormat.format(timeStampDate);
                Date d = new Date();
                try {
                    d = convert(formattedDate);

                } catch (ParseException e1) {

                    e1.printStackTrace();
                }
                // System.out.println( d.getMonth()+1);
                GregorianCalendar cal1 = new GregorianCalendar();
                cal1.setTime(d);

                moisSysDate = cal1.get(cal1.MONTH) + 1;

                /**********************************/
                if (moisevent >= moisSysDate) {
                    p1.setBugdet(p1.getBugdet() - Integer.valueOf(txtBudgetM.getText()));
                    projectServiceRemote.update(p1);
                    scheduleServiceRemote.save(meeting);
                    for (Particular p : par) {
                        envoyer1(p.getEmail(), p, txttitleM.getText());
                    }
                    Config2.dialog(Alert.AlertType.INFORMATION, "Success Save Data..");
                    Notifications nb23 = Notifications.create().darkStyle().hideAfter(Duration.seconds(40))
                            .title("Budget").text("Project Budget has been modified !");
                    nb23.showConfirm();
                } else {
                    Config2.dialog(Alert.AlertType.INFORMATION, "Verify Event Date !");
                }
            } else {
                Config2.dialog(Alert.AlertType.INFORMATION, "Event budget should be inferior than Project Budget : "
                        + projectServiceRemote.findProjectByName(cbProjectE.getValue()).getBugdet());
            }

        } catch (NamingException ex) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }

    }

    @FXML
    void addProjectButton(MouseEvent event) {

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

    public static Date convert(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = sdf.parse(date);
        return d1;
    }

    public void envoyer(String mail, Particular p, String evName) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("jassemkochbati23@gmail.com", "163JMT0944");
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("jassemkochbati23@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
            message.setSubject("Event Invitation");
            message.setText("Dear " + p.getName() + " " + p.getFirst_name()
                    + "\nWe have the pleasure to invite you to our event " + evName);
            Transport.send(message);
            Notifications nb = Notifications.create().darkStyle().hideAfter(Duration.seconds(5)).title("Mail")
                    .text("Mail sent successfully !");

            nb.showConfirm();

        } catch (MessagingException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failure to send");
            alert.setHeaderText("Please check your informations !!");

            alert.showAndWait();

        }

    }

    public void envoyer1(String mail, Particular p, String evName) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("jassemkochbati23@gmail.com", "163JMT0944");
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("jassemkochbati23@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
            message.setSubject("Event Invitation");
            message.setText("Dear " + p.getName() + " " + p.getFirst_name()
                    + "\nWe have the pleasure to invite you to our Meeting " + evName);
            Transport.send(message);
            Notifications nb = Notifications.create().darkStyle().hideAfter(Duration.seconds(5)).title("Mail")
                    .text("Mail sent successfully !");

            nb.showConfirm();

        } catch (MessagingException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failure to send");
            alert.setHeaderText("Please check your informations !!");

            alert.showAndWait();

        }

    }

    public void envoyerAnnulation(String mail, Particular p, String evName) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("jassemkochbati23@gmail.com", "163JMT0944");
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("jassemkochbati23@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
            message.setSubject("Event Annulation");
            message.setText("Dear " + p.getName() + " " + p.getFirst_name()
                    + "\nWe are Sorry to annouce you that the event " + evName + " has been canceled");
            Transport.send(message);
            Notifications nb = Notifications.create().darkStyle().hideAfter(Duration.seconds(5)).title("Mail")
                    .text("Mail sent successfully !");

            nb.showConfirm();

        } catch (MessagingException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failure to send");
            alert.setHeaderText("Please check your informations !!");

            alert.showAndWait();

        }

    }

    public void envoyerAnnulation1(String mail, Particular p, String evName) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("jassemkochbati23@gmail.com", "163JMT0944");
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("jassemkochbati23@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
            message.setSubject("Event Annulation");
            message.setText("Dear " + p.getName() + " " + p.getFirst_name()
                    + "\nWe are Sorry to annouce you that the meeting " + evName + " has been canceled");
            Transport.send(message);
            Notifications nb = Notifications.create().darkStyle().hideAfter(Duration.seconds(5)).title("Mail")
                    .text("Mail sent successfully !");

            nb.showConfirm();

        } catch (MessagingException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failure to send");
            alert.setHeaderText("Please check your informations !!");

            alert.showAndWait();

        }

    }

    void afficher() {
        tablePersons.setItems(FXCollections.observableArrayList(participants));
        Config2.setModelColumn(colNomPerson, "name");
        Config2.setModelColumn(colPrenomPerson, "first_name");
        colAction.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCell();
            }

        });

    }

    private class ButtonCell extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("Remove");

        final HBox hb = new HBox(cellButtonDelete);

        public ButtonCell() {
            hb.setSpacing(4);
            cellButtonDelete.setOnAction((ActionEvent t) -> {

                int row = getTableRow().getIndex();
                tablePersons.getSelectionModel().select(row);
                // aksiKlikTableData(null);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure to Remove participant ?");
                alert.initStyle(StageStyle.UTILITY);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    participants.remove(tablePersons.getSelectionModel().getSelectedItem());
                    afficher();
                    /*
                     * clear(); selectData();
                     */
                } else {
                    afficher();
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

    void afficher1() {
        tablePersons1.setItems(FXCollections.observableArrayList(participants1));
        Config2.setModelColumn(colNomPerson1, "name");
        Config2.setModelColumn(colPrenomPerson1, "first_name");
        colAction1.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCell1();
            }

        });

    }

    private class ButtonCell1 extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("Remove");

        final HBox hb = new HBox(cellButtonDelete);

        public ButtonCell1() {
            hb.setSpacing(4);
            cellButtonDelete.setOnAction((ActionEvent t) -> {

                int row = getTableRow().getIndex();
                tablePersons1.getSelectionModel().select(row);
                // aksiKlikTableData(null);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure to Remove participant ?");
                alert.initStyle(StageStyle.UTILITY);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    participants1.remove(tablePersons1.getSelectionModel().getSelectedItem());
                    afficher1();
                    /*
                     * clear(); selectData();
                     */
                } else {
                    afficher1();
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

    void AfficherEvents() {
        TableHandleEvents.setItems(FXCollections.observableArrayList(scheduleServiceRemote.findAllEvents()));
        ColTypeEvent.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<String, String> param) {
                        // TODO Auto-generated method stub
                        return new SimpleStringProperty("event");
                    }

                });
        // Config2.setModelColumn(ColTypeEvent, "Event");
        Config2.setModelColumn(ColTitleEvent, "eventName");
        Config2.setModelColumn(ColDateEvent, "targetDate");
        Config2.setModelColumn(ColPlaceEvent, "place");
        Config2.setModelColumn(ColBudgetEvent, "budget");
        ColProjectEvent.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Schedule, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Schedule, String> param) {
                        // TODO Auto-generated method stub
                        return new SimpleStringProperty(param.getValue().getIdProject().getProjectName());
                    }
                });

        ColActionEvent.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCellHandleEvents();
            }

        });

    }

    private class ButtonCellHandleEvents extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("Delete");

        final HBox hb = new HBox(cellButtonDelete);

        public ButtonCellHandleEvents() {
            hb.setSpacing(4);
            cellButtonDelete.setOnAction((ActionEvent t) -> {

                int row = getTableRow().getIndex();
                TableHandleEvents.getSelectionModel().select(row);
                // aksiKlikTableData(null);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure to Remove Event ?");
                alert.initStyle(StageStyle.UTILITY);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    // ********************** Budget Project
                    // ****************************************
                    Project p = new Project();
                    p = TableHandleEvents.getSelectionModel().getSelectedItem().getIdProject();
                    p.setBugdet(p.getBugdet() + TableHandleEvents.getSelectionModel().getSelectedItem().getBudget());
                    // ******************************************************************************
                    GregorianCalendar cal = new GregorianCalendar();
                    cal.setTime(TableHandleEvents.getSelectionModel().getSelectedItem().getTargetDate());
                    int moisevent, moisSysDate;
                    moisevent = cal.get(cal.MONTH) + 1;
                    /*
                     * test SYSDATE
                     ********************************************************************/
                    Date timeStampDate = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");

                    String formattedDate = dateFormat.format(timeStampDate);
                    Date d = new Date();
                    try {
                        d = convert(formattedDate);

                    } catch (ParseException e1) {

                        e1.printStackTrace();
                    }
                    // System.out.println( d.getMonth()+1);
                    GregorianCalendar cal1 = new GregorianCalendar();
                    cal1.setTime(d);

                    moisSysDate = cal1.get(cal1.MONTH) + 1;

                    /**********************************/
                    System.out.println(moisevent + moisSysDate);
                    if (moisevent >= moisSysDate) {
                        projectServiceRemote.update(p);
                        Notifications nb23 = Notifications.create().darkStyle().hideAfter(Duration.seconds(40))
                                .title("Budget").text("Project Budget has been restored !");
                        nb23.showConfirm();
                    } else {
                        Notifications nb24 = Notifications.create().darkStyle().hideAfter(Duration.seconds(40))
                                .title("Budget").text("Project Budget cannot be restored !");
                        nb24.showConfirm();
                    }
                    // System.out.println(TableHandleEvents.getSelectionModel().getSelectedItem().getContacts());

                    for (Particular part : TableHandleEvents.getSelectionModel().getSelectedItem().getContacts()) {
                        envoyerAnnulation(part.getEmail(), part,
                                TableHandleEvents.getSelectionModel().getSelectedItem().getEventName());
                    }

                    scheduleServiceRemote.delete(TableHandleEvents.getSelectionModel().getSelectedItem());
                    AfficherEvents();

                } else {
                    AfficherEvents();

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

    void AfficherMeetings() {
        TableHandleMeetings.setItems(FXCollections.observableArrayList(scheduleServiceRemote.findAllMeetings()));
        ColTypeEvent1.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<String, String> param) {
                        // TODO Auto-generated method stub
                        return new SimpleStringProperty("meeting");
                    }

                });
        Config2.setModelColumn(ColTitleEvent1, "meetingName");
        Config2.setModelColumn(ColDateEvent1, "targetDate");
        Config2.setModelColumn(ColPlaceEvent1, "place");
        Config2.setModelColumn(ColBudgetEvent1, "budget");
        ColProjectEvent1.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Schedule, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<Schedule, String> param) {
                        // TODO Auto-generated method stub
                        return new SimpleStringProperty(param.getValue().getIdProject().getProjectName());
                    }
                });

        ColActionEvent1.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

            @Override
            public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                // TODO Auto-generated method stub
                return new ButtonCellHandleMeetings();
            }

        });

    }

    private class ButtonCellHandleMeetings extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("Delete");

        final HBox hb = new HBox(cellButtonDelete);

        public ButtonCellHandleMeetings() {
            hb.setSpacing(4);
            cellButtonDelete.setOnAction((ActionEvent t) -> {

                int row = getTableRow().getIndex();
                TableHandleMeetings.getSelectionModel().select(row);
                // aksiKlikTableData(null);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure to Remove Meeting ?");
                alert.initStyle(StageStyle.UTILITY);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {

                    Project p = new Project();
                    p = TableHandleMeetings.getSelectionModel().getSelectedItem().getIdProject();
                    p.setBugdet(p.getBugdet() + TableHandleMeetings.getSelectionModel().getSelectedItem().getBudget());

                    // ******************************************************************************
                    GregorianCalendar cal = new GregorianCalendar();
                    cal.setTime(TableHandleMeetings.getSelectionModel().getSelectedItem().getTargetDate());
                    int moisevent, moisSysDate;
                    moisevent = cal.get(cal.MONTH) + 1;
                    /*
                     * test SYSDATE
                     ********************************************************************/
                    Date timeStampDate = new Date();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");

                    String formattedDate = dateFormat.format(timeStampDate);
                    Date d = new Date();
                    try {
                        d = convert(formattedDate);

                    } catch (ParseException e1) {

                        e1.printStackTrace();
                    }
                    // System.out.println( d.getMonth()+1);
                    GregorianCalendar cal1 = new GregorianCalendar();
                    cal1.setTime(d);

                    moisSysDate = cal1.get(cal1.MONTH) + 1;

                    /**********************************/
                    System.out.println(moisevent + moisSysDate);
                    if (moisevent >= moisSysDate) {
                        projectServiceRemote.update(p);
                        Notifications nb23 = Notifications.create().darkStyle().hideAfter(Duration.seconds(40))
                                .title("Budget").text("Project Budget has been restored !");
                        nb23.showConfirm();
                    } else {
                        Notifications nb24 = Notifications.create().darkStyle().hideAfter(Duration.seconds(40))
                                .title("Budget").text("Project Budget cannot be restored !");
                        nb24.showConfirm();
                    }
                    // System.out.println(TableHandleEvents.getSelectionModel().getSelectedItem().getContacts());

                    for (Particular part : TableHandleMeetings.getSelectionModel().getSelectedItem().getContactsM()) {
                        envoyerAnnulation1(part.getEmail(), part,
                                TableHandleMeetings.getSelectionModel().getSelectedItem().getMeetingName());
                    }

                    scheduleServiceRemote.delete(TableHandleMeetings.getSelectionModel().getSelectedItem());
                    AfficherMeetings();

                } else {

                    AfficherMeetings();
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

}
