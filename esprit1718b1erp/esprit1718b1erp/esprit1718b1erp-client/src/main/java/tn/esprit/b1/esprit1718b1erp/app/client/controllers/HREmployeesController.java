package tn.esprit.b1.esprit1718b1erp.app.client.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;
import tn.esprit.b1.esprit1718b1erp.entities.Conge;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.entities.UserFunction;
import tn.esprit.b1.esprit1718b1erp.services.UserServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.CongeServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectServiceRemote;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HREmployeesController implements Initializable{

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
    private DatePicker StartDateInput;

    @FXML
    private DatePicker ReturnDateInput;

    @FXML
    private TextArea ReasonInput;

    @FXML
    private AnchorPane ChatPane;

    @FXML
    private AnchorPane paneCrud;
    @FXML
    private ListView<Conge> LeavesList;
    @FXML
    private Button DeleteLeave;

    private ObservableList<User> responsables;
    private final String jndiNameConge = "esprit1718b1erp-ear/esprit1718b1erp-service/CongeService!tn.esprit.b1.esprit1718b1erp.services.youssfi.CongeServiceRemote";
    private final String jndiNameUser = "esprit1718b1erp-ear/esprit1718b1erp-service/UserService!tn.esprit.b1.esprit1718b1erp.services.UserServiceRemote";
    private final String jndiNameProject ="esprit1718b1erp-ear/esprit1718b1erp-service/ProjectService!tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectServiceRemote";

    private InitialContext initialContext = null;
    private CongeServiceRemote congeproxy = null;
    private UserServiceRemote userproxy = null;
    private ProjectServiceRemote projectproxy = null;
    @FXML
    void AddNew(ActionEvent event) {
        AffichageEmployees.setOpacity(0); 
        new FadeInUpTransition(paneCrud).play();
    }

    @FXML
    void JoinChatroom(ActionEvent event) throws IOException {
        AnchorPane newLoadedPane =        FXMLLoader.load(getClass().getResource("/fxml/Chatroom.fxml"));
        ChatPane.getChildren().add(newLoadedPane);
    }
    @FXML
    void AddOrUpdateLeave(ActionEvent event) throws NamingException, ParseException {
        Conge conge = new Conge();
        initialContext = new InitialContext();
        congeproxy = (CongeServiceRemote) initialContext.lookup(jndiNameConge);
        conge.setStartDate(convert(StartDateInput.getEditor().getText()));
        conge.setFinDate(convert(ReturnDateInput.getEditor().getText()));
        conge.setDescription(ReasonInput.getText());
        conge.setConfirmed(0);
        conge.setEmployee(LoginController.getLoggedUser());
        congeproxy.save(conge);
        Config2.dialog(Alert.AlertType.INFORMATION, "Request sent sucessfully ..");
    }
    @FXML
    void DeleteLeave(ActionEvent event) throws NamingException {
        initialContext = new InitialContext();
        congeproxy = (CongeServiceRemote) initialContext.lookup(jndiNameConge);
        congeproxy.delete(LeavesList.getSelectionModel().getSelectedItem());
    }
    public static Date convert(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = sdf.parse(date);
        return d1;
    }

    @SuppressWarnings("restriction")
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        DeleteLeave.setVisible(false);
        LeavesList.setCellFactory((ListView<Conge> arg2) -> {
            ListCell<Conge> cell = new ListCell<Conge>() {
                @Override
                protected void updateItem(Conge e, boolean btl) {
                    super.updateItem(e, btl);

                    if (e != null) {
                        //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                        if(e.getConfirmed()==0)
                        {
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
                        } else {
                            File file = new File("C:\\wamp64\\www\\imagesAmine\\process-accept-icon-62939.png");
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

                }

            };
            return cell;
            
            
            
        });
        try {
            LeavesList.setItems(FXCollections.observableArrayList(findByUser(LoginController.getLoggedUser())));
        } catch (NamingException e) {
            e.printStackTrace();
        }
        LeavesList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                DeleteLeave.setVisible(true);

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
        try {
            ListSupplyChainManager.setItems(findResponsable(UserFunction.SUPPLY_CHAIN_MANAGER));
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    public List<Conge> findByUser(User user) throws NamingException{
        initialContext = new InitialContext();
        congeproxy = (CongeServiceRemote) initialContext.lookup(jndiNameConge);
        return congeproxy.findByEmployee(user);
        
        
    }
    private ObservableList<User> findResponsable(UserFunction userFunction) throws NamingException
    {
        initialContext = new InitialContext();
        userproxy = (UserServiceRemote) initialContext.lookup(jndiNameUser);
        responsables = FXCollections.observableArrayList(userproxy.findByFunction(userFunction));
        
        return responsables;
    }
    private Project projectDetails(User code) throws NamingException
    {
        initialContext = new InitialContext();
        projectproxy = (ProjectServiceRemote) initialContext.lookup(jndiNameProject);
       // userproxy1 = (UserServiceRemote) initialContext1.lookup(jndiNameUser);
        return projectproxy.findResponsablesProjects(code);
    }
}
