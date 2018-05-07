package tn.esprit.b1.esprit1718b1erp.app.client.controllers;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.RejectedExecutionException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sun.prism.impl.Disposer.Record;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.web.HTMLEditor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListCell;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ListView;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;
import tn.esprit.b1.esprit1718b1erp.entities.Conge;
import tn.esprit.b1.esprit1718b1erp.entities.Item;
import tn.esprit.b1.esprit1718b1erp.entities.ItemRequest;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.entities.UserFunction;
import tn.esprit.b1.esprit1718b1erp.services.UserServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.CongeServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectServiceRemote;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
public class HRController implements Initializable {

    @FXML
    private AnchorPane Anchor;

    @FXML
    private Button ManageResources;

    @FXML
    private ImageView imgLoad;

    @FXML
    private ProgressBar bar;

    @FXML
    private AnchorPane AffichageEmployees;
    @FXML
    private AnchorPane ChatPane;
    @FXML
    private AnchorPane paneCrud;

    @FXML
    private TextField txtId;

    @FXML
    private TextField NameText;

    @FXML
    private Button AddInterview;

    @FXML
    private Button btnBack;

    @FXML
    private DatePicker InterviewDate;

    @FXML
    private TextField MailText;

    @FXML
    private Button UploadButton;
    
    @FXML
    private TableView<User> CondidateTable;

    @FXML
    private TableColumn Actions;

    @FXML
    private TableColumn<User, String> ColName;

    @FXML
    private TableColumn<User, String> ColMail;

    @FXML
    private Button CVshower;
    
    @FXML
    private AnchorPane htmlPane;
    @FXML
    private Button CloseBtn;
    @FXML
    private TextField textCIN;

    @FXML
    private HTMLEditor htmlFiles;
    @FXML
    private ListView<User> ListSupplyChainManager;
    @FXML
    private ListView<User> ListAccountant;
    @FXML
    private ListView<User> ListMarketingManger;
    @FXML
    private ListView<User> ListDirector;
    @FXML
    private ListView<User> ListProjectCordinators;
    @FXML
    private ListView<Conge> LeavesList;
    
    @FXML
    private TextField CondidateName;

    @FXML
    private TextField CondidateMail;

    @FXML
    private TextField CondidateSalary;
    @FXML
    private Button DeleteCondidate;

    @FXML
    private ComboBox<String> ComboFunction;
    @FXML
    private ComboBox<String> ComboAllFunctions;
    @FXML
    private ListView<User> ListEmployees;
    @FXML
    private RadioButton AcceptLeave;

    @FXML
    private RadioButton DeclineLeave;
    
    @FXML
    private ListView<User> ListHireCondidate;
    
    @FXML
    private Button AddEmployee;
    @FXML
    private Label helmi;
    @FXML
    private TextField OldSalaryInput;

    @FXML
    private TextField NewSalaryInput;
    
    
    Config2 con = new Config2();
    private final String jndiNameUser = "esprit1718b1erp-ear/esprit1718b1erp-service/UserService!tn.esprit.b1.esprit1718b1erp.services.UserServiceRemote";
    private final String jndiNameProject ="esprit1718b1erp-ear/esprit1718b1erp-service/ProjectService!tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectServiceRemote";
    private final String jndiNameConge = "esprit1718b1erp-ear/esprit1718b1erp-service/CongeService!tn.esprit.b1.esprit1718b1erp.services.youssfi.CongeServiceRemote";

    private String CVpath = null ,CVName;
    private String Imagepath = null ,imgName;
    private ObservableList<User> responsables,condidates,condidats,employees;
    private User selectedCondidate = null;
    private InitialContext initialContext = null;
    
    private UserServiceRemote userproxy = null;
    private ProjectServiceRemote projectproxy = null;
    private CongeServiceRemote congeproxy = null;
    int verif=0 ;
   static int id;

    
    @FXML
    void AddNew(ActionEvent event) {
        AffichageEmployees.setOpacity(0);
        new FadeInUpTransition(paneCrud).play();
       

    }

    @FXML
    void CondidatSave(ActionEvent event) throws ParseException, NamingException {
        initialContext = new InitialContext();
        userproxy = (UserServiceRemote) initialContext.lookup(jndiNameUser);
        if(txtId.getText().equals(""))
        {
            selectedCondidate = new User();
            selectedCondidate.setName(NameText.getText());
            selectedCondidate.setCIN(Long.parseLong(textCIN.getText()));
            selectedCondidate.setFunctional(0);
            selectedCondidate.setInterviewDate(convert(InterviewDate.getEditor().getText()));
            selectedCondidate.setEmail(MailText.getText());
            selectedCondidate.setCV(CVName);
            selectedCondidate.setPhoto(imgName);
            selectedCondidate.setLogin(MailText.getText());
            selectedCondidate.setPassword(textCIN.getText());
            
            userproxy.save(selectedCondidate);   
        }else {
           selectedCondidate = userproxy.findByCode(Long.parseLong(txtId.getText()));
           selectedCondidate.setName(NameText.getText());
           selectedCondidate.setFunctional(0);
           selectedCondidate.setCIN(Long.parseLong(textCIN.getText()));
           selectedCondidate.setInterviewDate(convert(InterviewDate.getEditor().getText()));
           selectedCondidate.setEmail(MailText.getText());
           selectedCondidate.setCV(CVName);
           selectedCondidate.setPhoto(imgName);
           selectedCondidate.setLogin(MailText.getText());
           selectedCondidate.setPassword(textCIN.getText());
           userproxy.update(selectedCondidate);
        }
        
       
    }

    @FXML
    void aksiBack(ActionEvent event) {
        paneCrud.setOpacity(0);
        AffichageEmployees.setOpacity(1);
        new FadeInUpTransition(AffichageEmployees).play();
    }

   
   //@WebServlet("/uploadServlet")
   // @MultipartConfig(maxFileSize = 16177215)
    @FXML
    void UploadCV(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        File selectedFile = fileChooser.showOpenDialog(null);
        fileChooser.setTitle("Open resource file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.jpeg", "*.jpg", "*.pdf",
                "*.tiff", "*.tif","*.JPG","*.JPEG", "*.PDF", "*.TIFF", "*.TIF"));
        if (selectedFile != null) {

            
            CVpath = selectedFile.getAbsolutePath();
            
            int fileNameIndex = CVpath.lastIndexOf("\\") + 1;
            System.out.println(CVpath);
            System.out.println(fileNameIndex);
            CVName = CVpath.substring(fileNameIndex);
            File dest = new File("C:\\wamp64\\www\\imagesAmine\\" + CVName);
            try {
                copyFileUsingStream(selectedFile, dest);
            } catch (IOException e) {
            }
        }

    }
    @FXML
    void AddPictureCondidate(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {

            
            Imagepath = selectedFile.getAbsolutePath();
            
            int fileNameIndex = Imagepath.lastIndexOf("\\") + 1;
            System.out.println(CVpath);
            System.out.println(fileNameIndex);
            imgName = Imagepath.substring(fileNameIndex);
            File dest = new File("C:\\wamp64\\www\\imagesAmine\\" + imgName);
            try {
                copyFileUsingStream(selectedFile, dest);
            } catch (IOException e) {
            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
        // TODO Auto-generated method stub
        CVshower.setVisible(false);
        DeleteCondidate.setVisible(false);
        ComboFunction.getItems().addAll("Technician","Engineer");
        ComboAllFunctions.getItems().addAll("Engineer","Accountant","Supply chain manager","Marketing manager","Contact manager");
        Config2.setModelColumn(ColName, "name");
        Config2.setModelColumn(ColMail, "email");
            condidats = FXCollections.observableArrayList(findCondidates());
            CondidateTable.setItems(condidats);
            Actions.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

                @Override
                public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                    // TODO Auto-generated method stub
                    return new ButtonCell();
                }

            });
            CondidateTable.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
                        CVshower.setVisible(true);
                      
                    }

                }
            });
            ListSupplyChainManager.setCellFactory((ListView<User> arg2) -> {
                ListCell<User> cell = new ListCell<User>() {
                    @Override
                    protected void updateItem(User e, boolean btl) {
                        super.updateItem(e, btl);

                        if (e != null) {
                            File file = new File("C:\\wamp64\\www\\imagesAmine\\"+e.getPhoto());
                            file.getParentFile().mkdirs();
                            Image IMAGE_RUBY = new Image(file.toURI().toString());
                            //   Image IMAGE_RUBY = new Image(ps.findById(e.getPassager().getId()).getAvatar());

                            ImageView imgview = new ImageView(IMAGE_RUBY);

                            setGraphic(imgview);

                            imgview.setFitHeight(90);
                            imgview.setFitWidth(90);
                            Rectangle clip = new Rectangle(
                                    imgview.getFitWidth(), imgview.getFitHeight()
                            );

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

                            setText("Supply chain Manager hired the :"+e.getHiringDate()+"\n"+"Name :"+e.getName()+"\n"+e.getEmail()+"\n"+"Salary :"+e.getSalary());

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));
                            
                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            ListEmployees.setCellFactory((ListView<User> arg2) -> {
                ListCell<User> cell = new ListCell<User>() {
                    @Override
                    protected void updateItem(User e, boolean btl) {
                        super.updateItem(e, btl);

                        if (e != null) {
                            File file = new File("C:\\wamp64\\www\\imagesAmine\\"+e.getPhoto());
                            file.getParentFile().mkdirs();
                            Image IMAGE_RUBY = new Image(file.toURI().toString());
                            //   Image IMAGE_RUBY = new Image(ps.findById(e.getPassager().getId()).getAvatar());

                            ImageView imgview = new ImageView(IMAGE_RUBY);

                            setGraphic(imgview);

                            imgview.setFitHeight(90);
                            imgview.setFitWidth(90);
                            Rectangle clip = new Rectangle(
                                    imgview.getFitWidth(), imgview.getFitHeight()
                            );

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

                            setText(e.getUserFct()+"  hired the :"+e.getHiringDate()+"\n"+"Name :"+e.getName()+"\n"+e.getEmail()+"\n"+"Salary :"+e.getSalary());

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));
                            
                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            ListAccountant.setCellFactory((ListView<User> arg2) -> {
                ListCell<User> cell = new ListCell<User>() {
                    @Override
                    protected void updateItem(User e, boolean btl) {
                        super.updateItem(e, btl);

                        if (e != null) {
                            //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                            File file = new File("C:\\wamp64\\www\\imagesAmine\\"+e.getPhoto());
                            file.getParentFile().mkdirs();
                            Image IMAGE_RUBY = new Image(file.toURI().toString());
                            //   Image IMAGE_RUBY = new Image(ps.findById(e.getPassager().getId()).getAvatar());

                            ImageView imgview = new ImageView(IMAGE_RUBY);

                            setGraphic(imgview);

                            imgview.setFitHeight(90);
                            imgview.setFitWidth(90);
                            Rectangle clip = new Rectangle(
                                    imgview.getFitWidth(), imgview.getFitHeight()
                            );

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

                            setText("Accountant hired the :"+e.getHiringDate()+"\n"+"Name :"+e.getName()+"\n"+e.getEmail()+"\n"+"Salary :"+e.getSalary());

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));
                            
                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            ListMarketingManger.setCellFactory((ListView<User> arg2) -> {
                ListCell<User> cell = new ListCell<User>() {
                    @Override
                    protected void updateItem(User e, boolean btl) {
                        super.updateItem(e, btl);

                        if (e != null) {
                            //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                            File file = new File("C:\\wamp64\\www\\imagesAmine\\"+e.getPhoto());
                            file.getParentFile().mkdirs();
                            Image IMAGE_RUBY = new Image(file.toURI().toString());
                            //   Image IMAGE_RUBY = new Image(ps.findById(e.getPassager().getId()).getAvatar());

                            ImageView imgview = new ImageView(IMAGE_RUBY);

                            setGraphic(imgview);

                            imgview.setFitHeight(90);
                            imgview.setFitWidth(90);
                            Rectangle clip = new Rectangle(
                                    imgview.getFitWidth(), imgview.getFitHeight()
                            );

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

                            setText("Marketing Manager hired the : "+e.getHiringDate()+"\n"+"Name : "+e.getName()+"\n"+"Mail : "+e.getEmail()+"\n"+"Salary :"+e.getSalary());

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));
                            
                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            ListDirector.setCellFactory((ListView<User> arg2) -> {
                ListCell<User> cell = new ListCell<User>() {
                    @Override
                    protected void updateItem(User e, boolean btl) {
                        super.updateItem(e, btl);

                        if (e != null) {
                            //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                            File file = new File("C:\\wamp64\\www\\imagesAmine\\"+e.getPhoto());
                            file.getParentFile().mkdirs();
                            Image IMAGE_RUBY = new Image(file.toURI().toString());
                            //   Image IMAGE_RUBY = new Image(ps.findById(e.getPassager().getId()).getAvatar());

                            ImageView imgview = new ImageView(IMAGE_RUBY);

                            setGraphic(imgview);

                            imgview.setFitHeight(90);
                            imgview.setFitWidth(90);
                            Rectangle clip = new Rectangle(
                                    imgview.getFitWidth(), imgview.getFitHeight()
                            );

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

                            setText("Director's Name : "+e.getName()+"\n"+"Mail : "+e.getEmail()+"\n"+"Salary :"+e.getSalary());

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));
                            
                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            ListProjectCordinators.setCellFactory((ListView<User> arg2) -> {
                ListCell<User> cell = new ListCell<User>() {
                    @Override
                    protected void updateItem(User e, boolean btl) {
                        super.updateItem(e, btl);

                        if (e != null) {
                            //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                            File file = new File("C:\\wamp64\\www\\imagesAmine\\"+e.getPhoto());
                            file.getParentFile().mkdirs();
                            Image IMAGE_RUBY = new Image(file.toURI().toString());
                            //   Image IMAGE_RUBY = new Image(ps.findById(e.getPassager().getId()).getAvatar());

                            ImageView imgview = new ImageView(IMAGE_RUBY);

                            setGraphic(imgview);

                            imgview.setFitHeight(90);
                            imgview.setFitWidth(90);
                            Rectangle clip = new Rectangle(
                                    imgview.getFitWidth(), imgview.getFitHeight()
                            );

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

                            try {
                                setText("Project's name : "+projectDetails(e).getProjectName()+"\n Project cordinator's Name : "+e.getName()+"\n"+"Mail : "+e.getEmail()+"\n"+"Salary :"+e.getSalary());
                            } catch (NamingException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));
                            
                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            ListHireCondidate.setCellFactory((ListView<User> arg2) -> {
                ListCell<User> cell = new ListCell<User>() {
                    @Override
                    protected void updateItem(User e, boolean btl) {
                        super.updateItem(e, btl);

                        if (e != null) {
                            //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                            File file = new File("C:\\wamp64\\www\\imagesAmine\\"+e.getPhoto());
                            file.getParentFile().mkdirs();
                            Image IMAGE_RUBY = new Image(file.toURI().toString());
                            //   Image IMAGE_RUBY = new Image(ps.findById(e.getPassager().getId()).getAvatar());

                            ImageView imgview = new ImageView(IMAGE_RUBY);

                            setGraphic(imgview);

                            imgview.setFitHeight(50);
                            imgview.setFitWidth(50);
                            Rectangle clip = new Rectangle(
                                    imgview.getFitWidth(), imgview.getFitHeight()
                            );

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

                            
                                setText("Condidate's : "+e.getName()+"\n"+"Mail : "+e.getEmail()+"\n"+"Interview Date :"+e.getInterviewDate());
                            

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));
                            
                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
            });
            ListHireCondidate.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    // TODO Auto-generated method stub
                    CondidateName.setText(ListHireCondidate.getSelectionModel().getSelectedItem().getName());
                    CondidateMail.setText(ListHireCondidate.getSelectionModel().getSelectedItem().getEmail());
                    DeleteCondidate.setVisible(true);
                }
                
            });
            LeavesList.setCellFactory((ListView<Conge> arg2) -> {
                ListCell<Conge> cell = new ListCell<Conge>() {
                    @Override
                    protected void updateItem(Conge e, boolean btl) {
                        super.updateItem(e, btl);

                        if (e != null) {
                            //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                            
                            
                                File file = new File("C:\\wamp64\\www\\imagesAmine\\process-info-icon.png");
                                file.getParentFile().mkdirs();
                                Image IMAGE_RUBY = new Image(file.toURI().toString());
                                //   Image IMAGE_RUBY = new Image(ps.findById(e.getPassager().getId()).getAvatar());

                                ImageView imgview = new ImageView(IMAGE_RUBY);

                                setGraphic(imgview);

                                imgview.setFitHeight(50);
                                imgview.setFitWidth(50);
                                Rectangle clip = new Rectangle(
                                        imgview.getFitWidth(), imgview.getFitHeight()
                                );

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
                                
                                setText("Starts the : "+e.getStartDate()+"\n"+"Ends the : "+e.getFinDate()+"\n"+e.getDescription());
                                    
                                setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                                // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            ListEmployees.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    // TODO Auto-generated method stub
                    OldSalaryInput.setText(String.valueOf(ListEmployees.getSelectionModel().getSelectedItem().getSalary()));
                    
                }
                
            });
            try {
                ListSupplyChainManager.setItems(findResponsable(UserFunction.SUPPLY_CHAIN_MANAGER));
                ListAccountant.setItems(findResponsable(UserFunction.ACCOUNTANT));
                ListMarketingManger.setItems(findResponsable(UserFunction.MARKETING_MANAGER));
                ListDirector.setItems(findResponsable(UserFunction.DIRECTOR));
                ListProjectCordinators.setItems(findResponsable(UserFunction.PROJECT_MANAGER));
                ListHireCondidate.setItems(findCondidates(0));
                ListEmployees.setItems(findEmployees());
                LeavesList.setItems(FXCollections.observableArrayList(findUntreated(0)));
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ComboFunction.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    // TODO Auto-generated method stub
                    if(ComboFunction.getSelectionModel().getSelectedIndex()==0)
                    {
                        CondidateSalary.setPromptText("Min value : 400");
                    }
                    if(ComboFunction.getSelectionModel().getSelectedIndex()==1)
                    {
                        CondidateSalary.setPromptText("Min value : 900");
                    }
                }
            });
            
    }
    @FXML
    void FireCondidate(ActionEvent event) throws NamingException {
        initialContext = new InitialContext();
        userproxy = (UserServiceRemote) initialContext.lookup(jndiNameUser);
        userproxy.delete(ListHireCondidate.getSelectionModel().getSelectedItem());
    }

    @FXML
    void TreatLeave(ActionEvent event) throws NamingException {
        initialContext = new InitialContext();
        congeproxy= (CongeServiceRemote) initialContext.lookup(jndiNameConge);
        Conge conge = LeavesList.getSelectionModel().getSelectedItem();
        if(conge==null){
            Config2.dialog(Alert.AlertType.INFORMATION, "Please select a leave to treat..");
        } else {
            if(AcceptLeave.isSelected()){
                conge.setConfirmed(1);
                congeproxy.update(conge);
                Config2.dialog(Alert.AlertType.INFORMATION, "Leave accepted..");
            } else if(DeclineLeave.isSelected()){
                congeproxy.delete(conge);
                Config2.dialog(Alert.AlertType.INFORMATION, "Leave declined and removed..");
            }
        }
    }
    @FXML
    void EmployeSave(ActionEvent event) throws NamingException {
       initialContext = new InitialContext();
       userproxy = (UserServiceRemote) initialContext.lookup(jndiNameUser);
      selectedCondidate = ListHireCondidate.getSelectionModel().getSelectedItem();
     //selectedCondidate.setLogin(ListHireCondidate.getSelectionModel().getSelectedItem().getName()+ListHireCondidate.getSelectionModel().getSelectedItem().getCIN());
     //  selectedCondidate.setPassword(String.valueOf(ListHireCondidate.getSelectionModel().getSelectedItem().getCIN()));
       Date date = new Date();
       selectedCondidate.setHiringDate(date);
       selectedCondidate.setFunctional(1);
       selectedCondidate.setInterviewDate(null);
      if((ComboFunction.getSelectionModel().getSelectedItem().equals("Technician"))&&(Float.parseFloat(CondidateSalary.getText())<400))
       {
           Config2.dialog(Alert.AlertType.INFORMATION, "Select a valid salary..");
           CondidateSalary.clear();
           verif = 1;
       } else if((ComboFunction.getSelectionModel().getSelectedItem().equals("Technician"))&&(Float.parseFloat(CondidateSalary.getText())>400)){
           selectedCondidate.setSalary(Float.parseFloat(CondidateSalary.getText()));
           selectedCondidate.setUserFct(UserFunction.TECHNICIAN);
           selectedCondidate.setGrade("Technician");
           
       }if((ComboFunction.getSelectionModel().getSelectedItem().equals("Engineer"))&&(Float.parseFloat(CondidateSalary.getText())<900))
       {
           Config2.dialog(Alert.AlertType.INFORMATION, "Select a valid salary..");
           CondidateSalary.clear();
           verif = 1;
       } else if((ComboFunction.getSelectionModel().getSelectedItem().equals("Engineer"))&&(Float.parseFloat(CondidateSalary.getText())>900)) {
           selectedCondidate.setSalary(Float.parseFloat(CondidateSalary.getText()));
           selectedCondidate.setUserFct(UserFunction.ENGINEER);
           selectedCondidate.setGrade("Engineer");
       }
       
       if(verif==0)
       {
           userproxy.update(selectedCondidate);
           Config2.dialog(Alert.AlertType.INFORMATION, "Data saved successfully..");
       }
       
       
       
    }


    @FXML
    void ShowCV(ActionEvent event) throws IOException {
        
        File file = new File("C:\\wamp64\\www\\imagesAmine\\" +CondidateTable.getSelectionModel().getSelectedItem().getCV());
        if (file != null) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

            String response = new String();
            for (String line; (line = reader.readLine()) != null; response += line)
                ;
            htmlFiles.setHtmlText(response);
           // htmlPane.setOpacity(1);
            htmlPane.toFront();
            new FadeInUpTransition(htmlPane).play();

        }
    }
    @FXML
    void PromoteEmployee(ActionEvent event) throws NamingException {
        initialContext = new InitialContext();
        userproxy = (UserServiceRemote) initialContext.lookup(jndiNameUser);
        if(ListEmployees.getSelectionModel().getSelectedItem()==null){
            Config2.dialog(Alert.AlertType.INFORMATION, "Please select an employee to promote..");
        } else {
            if(Float.parseFloat(OldSalaryInput.getText())>Float.parseFloat(NewSalaryInput.getText())){
                Config2.dialog(Alert.AlertType.INFORMATION, "please set a reasonable salary..");
            } else {
                ListEmployees.getSelectionModel().getSelectedItem().setSalary(Float.parseFloat(NewSalaryInput.getText()));
                userproxy.update(ListEmployees.getSelectionModel().getSelectedItem());
                Config2.dialog(Alert.AlertType.INFORMATION, "Data saved successfully..");
            }
        }
    }
    @FXML
    void CloseHtml(ActionEvent event) {
        htmlPane.setOpacity(0);
        htmlPane.toBack();
        AffichageEmployees.toFront();
    }
    ////////// Chatroom ////////////
    @FXML
    void JoinChatroom(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane =        FXMLLoader.load(getClass().getResource("/fxml/Chatroom.fxml"));
        ChatPane.getChildren().add(newLoadedPane);
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Chatroom.fxml"));
        //Parent root = loader.load();

        //InterfaceClientController personneController = loader.getController();
       // paneCrud.getScene().setRoot(root);
    }
    //////////////////////////////
    public static Date convert(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = sdf.parse(date);
        return d1;
    }
    private List<User> findCondidates() {
        List<User> Users = new ArrayList<>();
        try {
            initialContext = new InitialContext();
            userproxy = (UserServiceRemote) initialContext.lookup(jndiNameUser);
            Users = userproxy.findCondidates(0);
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return Users;
    }
    private ObservableList<User> findResponsable(UserFunction userFunction) throws NamingException
    {
        initialContext = new InitialContext();
        userproxy = (UserServiceRemote) initialContext.lookup(jndiNameUser);
        responsables = FXCollections.observableArrayList(userproxy.findByFunction(userFunction));
        
        return responsables;
    }
    private ObservableList<User> findCondidates(Integer functional) throws NamingException
    {
        initialContext = new InitialContext();
        userproxy = (UserServiceRemote) initialContext.lookup(jndiNameUser);
        condidates = FXCollections.observableArrayList(userproxy.findCondidates(functional));
        
        return condidates;
    }
    private ObservableList<User> findEmployees() throws NamingException
    {
        initialContext = new InitialContext();
        userproxy = (UserServiceRemote) initialContext.lookup(jndiNameUser);
        employees = FXCollections.observableArrayList(userproxy.findAll());
        
        return employees;
    }
    private Project projectDetails(User code) throws NamingException
    {
        initialContext = new InitialContext();
        projectproxy = (ProjectServiceRemote) initialContext.lookup(jndiNameProject);
       // userproxy1 = (UserServiceRemote) initialContext1.lookup(jndiNameUser);
        return projectproxy.findResponsablesProjects(code);
    }
    private void RefreshEmployee()
    {
        AffichageEmployees.setOpacity(0);
        new FadeInUpTransition(paneCrud).play();
        
    }
    public List<Conge> findUntreated(int i) throws NamingException{
        initialContext = new InitialContext();
        congeproxy = (CongeServiceRemote) initialContext.lookup(jndiNameConge);
        return congeproxy.findByEtat(i);
        
        
    }
    private class ButtonCell extends TableCell<Record, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("Delete");
        final Hyperlink cellButtonEdit = new Hyperlink("Edit");
        final HBox hb = new HBox(cellButtonDelete, cellButtonEdit);

        public ButtonCell() {
            hb.setSpacing(4);
            cellButtonDelete.setOnAction((ActionEvent t) -> {
               // status = 1;
                int row = getTableRow().getIndex();
                CondidateTable.getSelectionModel().select(row);
               // aksiKlikTableData(null);
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Delete Data ?");
                alert.initStyle(StageStyle.UTILITY);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    User i = CondidateTable.getSelectionModel().getSelectedItem();
                    System.out.println(i);
                    try {
                        initialContext = new InitialContext();
                        userproxy = (UserServiceRemote) initialContext.lookup(jndiNameUser);
                        
                        userproxy.delete(i);
                    } catch (NamingException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    
                  
                    
                } 
      
            });

            cellButtonEdit.setOnAction(t -> {
                //status = 1;
                int row = getTableRow().getIndex();
                CondidateTable.getSelectionModel().select(row);
               // clear();
               // aksiKlikTableData(null);
                User i = CondidateTable.getSelectionModel().getSelectedItem();
               // System.out.println("+++++" + i.getPicture());
                txtId.setText(String.valueOf(i.getCode()));
                AffichageEmployees.setOpacity(0);
               // SingleSelectionModel<Tab> selectionModel = CondidateTable.getSelectionModel();
               // selectionModel.select(0);
                new FadeInUpTransition(paneCrud).play();
                //status = 0;
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
    public void Redirect(Integer id)
    {
        this.id=id;
        System.out.println(id);
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
}
