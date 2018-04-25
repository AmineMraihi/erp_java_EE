package tn.esprit.b1.esprit1718b1erp.app.client.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;
import tn.esprit.b1.esprit1718b1erp.entities.Product;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.StateProject;
import tn.esprit.b1.esprit1718b1erp.entities.Task;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.entities.UserFunction;
import tn.esprit.b1.esprit1718b1erp.entities.taskID;
import tn.esprit.b1.esprit1718b1erp.services.UserServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.shil.ProductServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.TaskServiceRemote;
import javafx.scene.input.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.concurrent.RejectedExecutionException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javafx.scene.control.ListView;
import com.sun.prism.impl.Disposer.Record;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.Font;
import javafx.util.Callback;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.*;
import com.itextpdf.text.Anchor;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader; 
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.sun.javafx.scene.control.skin.LabeledText; 






public class ProjectManagmentController implements Initializable{

    @FXML
    private Button btnNew;

    @FXML
    private ImageView imgLoad;

    @FXML
    private ProgressBar bar;
    /////// anchorpanes //////////////////
    @FXML
    private AnchorPane paneTabel;
    
    @FXML
    private AnchorPane AnchorAddTask;

    @FXML
    private AnchorPane PaneManageProject;
    
    @FXML
    private AnchorPane paneCrud;
    @FXML
    private AnchorPane TasksPane;
    @FXML
    private AnchorPane Anchor;
    @FXML
    private AnchorPane TakeActionsPane;
    @FXML
    private AnchorPane AddProductPane;

    @FXML
    private AnchorPane SelectProductAndSuplierPAne;
    /////// fin anchorpanes //////////////////
    @FXML
    private TextField txtId;

    @FXML
    private Label txtsupadresse;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnBack;

    @FXML
    private CheckBox paid;
    @FXML
    private DatePicker FinishingDateInput;
    
    @FXML
    private TextArea txtDescription;

    /**
     * 
     */
    @FXML
    private DatePicker debutProjet;

    @FXML
    private DatePicker FinProjet;

    @FXML
    private TextField budget;
    
    @FXML
    private TextField ProjectName;
    /////// listviews ////////
    @FXML
    private ListView<Project> ListFinishedProjects;
    
    @FXML
    private ListView<Project> ListProgressProject;

    @FXML
    private ListView<Project> ListInterruptedProject;
    @FXML
    private ListView<Project> ActionsProgressProject;
    @FXML
    private ListView<Project> ActionsInterruptedProjectsList;
    
    @FXML
    private ListView<User> ListResponsables;
    @FXML
    private ListView<Project> InProgressProjects;
    @FXML
    private ListView<User> EngineersAndTechniciansList;
    @FXML
    private ListView<Task> TasksListByProject;
    /////// fin listviews //////////
    @FXML
    private Button NewTask;

    @FXML
    private CheckBox InterruptionCheckBox;
    
    @FXML
    private TextField ProjectNametext;

    @FXML
    private TextField TaskNametext;

    @FXML
    private DatePicker TaskStartDate;

    @FXML
    private DatePicker TaskFinishDate;

    @FXML
    private TextArea NoteText;

    @FXML
    private TextArea ReasonText;
    
    @FXML
    private Button RemoveTask;

    @FXML
    private Button UpdateTask;
    @FXML
    private TextField DelayText;
    @FXML
    private ImageView ImageShowProduct;
    @FXML
    private TextField ProductNameText;

    @FXML
    private TextField TextQuantity;

    @FXML
    private TextField PriceText;

    @FXML
    private CheckBox TypeProduct;

    @FXML
    private CheckBox TypeService;
    @FXML
    private ComboBox<Product> ProductCombo;
    @FXML
    private Label Idproduct;
    @FXML
    private ImageView UpdateProduct;
    @FXML
    private Label IdTask;

    
    ObservableList<Project> champs;
    ObservableList<Project> champs1;
    ObservableList<Project> champs2;
   
    ObservableList<User> responsables;
    ObservableList<Task> tasks;
    List<Project> Projectverif;
    List<User> Userverif;
    List<Product> Productverif;
    Config2 con = new Config2();
    private final String jndiNameProject= "esprit1718b1erp-ear/esprit1718b1erp-service/ProjectService!tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectServiceRemote";
    private final String jndiNameUser = "esprit1718b1erp-ear/esprit1718b1erp-service/UserService!tn.esprit.b1.esprit1718b1erp.services.UserServiceRemote";
    private final String jndiNameTask = "esprit1718b1erp-ear/esprit1718b1erp-service/TaskService!tn.esprit.b1.esprit1718b1erp.services.youssfi.TaskServiceRemote";
    private final String jndiNameProduct = "esprit1718b1erp-ear/esprit1718b1erp-service/ProductService!tn.esprit.b1.esprit1718b1erp.services.shil.ProductServiceRemote";
    private InitialContext initialContext = null;
    ProjectServiceRemote projectproxy = null;
    UserServiceRemote userproxy = null;
    TaskServiceRemote taskproxy = null;
    ProductServiceRemote productproxy = null;

    @FXML
    void AddNew(ActionEvent event) {
        paneTabel.setOpacity(0);
        refreshLists();
        new FadeInUpTransition(PaneManageProject).play();
    }

    @FXML
    void aksiBack(ActionEvent event) {
        paneCrud.setOpacity(0);
        paneTabel.setOpacity(1);
        refreshLists();
        new FadeInUpTransition(paneTabel).play();
    }
    //////////// Projects ///////////////////////////////

    @FXML
    void ProjSave(ActionEvent event) throws NamingException, ParseException {
        Project project = new Project();
        project.setAnnule(0);
        project.setBugdet(Float.parseFloat(budget.getText()));
        project.setProjectName(ProjectName.getText());
        Date date = new Date();
        project.setCreationDate(date);
        project.setStartDate(convert1(debutProjet.getEditor().getText()));
        project.setFinDate(convert1(FinProjet.getEditor().getText()));
        project.setDescription(txtDescription.getText());
        project.setEtat(StateProject.IN_PROGRESS);
        project.setRetard(0);
        project.setResponsable(ListResponsables.getSelectionModel().getSelectedItem());
        project.setProduct(ProductCombo.getSelectionModel().getSelectedItem());
        initialContext = new InitialContext();
        projectproxy = (ProjectServiceRemote) initialContext.lookup(jndiNameProject);
        userproxy = (UserServiceRemote) initialContext.lookup(jndiNameUser);
        if(ListResponsables.getSelectionModel().getSelectedItem()!=null&&ProductCombo.getSelectionModel().getSelectedItem()==null){
             
                Config2.dialog(Alert.AlertType.INFORMATION, "Please Select Or add a product ..");
                clear();
                refreshLists();
            
        } else if(ListResponsables.getSelectionModel().getSelectedItem()==null&&ProductCombo.getSelectionModel().getSelectedItem()==null){
            
            Config2.dialog(Alert.AlertType.INFORMATION, "Check your selections please ..");
            clear();
            refreshLists();
        
    }
 else if(ListResponsables.getSelectionModel().getSelectedItem()==null&&ProductCombo.getSelectionModel().getSelectedItem()!=null){
            
            Config2.dialog(Alert.AlertType.INFORMATION, "please select a responsible for your project ..");
            clear();
            refreshLists();
        
    }
        else  {
            projectproxy.save(project);
            User user = userproxy.findByCode(ListResponsables.getSelectionModel().getSelectedItem().getCode());
            user.setUserFct(UserFunction.PROJECT_MANAGER);
            userproxy.update(user);
            Config2.dialog(Alert.AlertType.INFORMATION, "Data Saved successfully..");
            refreshLists();
            
        } 
       
        
    }
    @FXML
    void SetInterruption(ActionEvent event) throws NamingException {
        Project project = ActionsProgressProject.getSelectionModel().getSelectedItem();
        initialContext = new InitialContext();
        projectproxy = (ProjectServiceRemote) initialContext.lookup(jndiNameProject);
        
        if(project==null)
        {
            Config2.dialog(Alert.AlertType.INFORMATION, "Please Select a project..");
            TakeActionsPane.toFront();
            refreshLists();
            new FadeInUpTransition(TakeActionsPane).play();
        }else if (project!=null && InterruptionCheckBox.isSelected()){
            project.setAnnule(1);
            project.setEtat(StateProject.INTERRUPTED);
            project.setReason(ReasonText.getText());
            project.setFinDate(null);
            Date date = new Date();
            project.setInterruptionDate(date);
            Config2.dialog(Alert.AlertType.INFORMATION, "Data Saved successfully..");
            projectproxy.update(project);
            refreshLists();
            TakeActionsPane.toFront();
            new FadeInUpTransition(TakeActionsPane).play();
        }
    }

    @FXML
    void AddDelay(ActionEvent event) throws NamingException, ParseException {
        Project project = ActionsProgressProject.getSelectionModel().getSelectedItem();
        initialContext = new InitialContext();
        projectproxy = (ProjectServiceRemote) initialContext.lookup(jndiNameProject);
        
        if(project==null)
        {
            Config2.dialog(Alert.AlertType.INFORMATION, "Please Select a project..");
            TakeActionsPane.toFront();
            refreshLists();
            new FadeInUpTransition(TakeActionsPane).play();
        }else{
            
            
            project.setRetard(Integer.parseInt(DelayText.getText()));
            //////// Date Adding 
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.setTime(project.getFinDate()); // finishing date.
            c.add(Calendar.DATE, Integer.parseInt(DelayText.getText())); // Adding days
            String output = sdf.format(c.getTime());
            System.out.println(output);
            project.setFinDate(convert(output));
            /////////////
            Config2.dialog(Alert.AlertType.INFORMATION, "Data Saved successfully..");
            projectproxy.update(project);
            refreshLists();
            TakeActionsPane.toFront();
            new FadeInUpTransition(TakeActionsPane).play();
        }
    }
    @FXML
    void ContinueProject(ActionEvent event) throws ParseException, NamingException {
        initialContext = new InitialContext();
        projectproxy = (ProjectServiceRemote) initialContext.lookup(jndiNameProject);
       Project project = ActionsInterruptedProjectsList.getSelectionModel().getSelectedItem();
       if(project!=null&&(!FinishingDateInput.getEditor().getText().equals("")))
       {
           project.setFinDate(convert1(FinishingDateInput.getEditor().getText()));
           project.setReason(null);
           project.setInterruptionDate(null);
           project.setEtat(StateProject.IN_PROGRESS);
           project.setAnnule(0);
           projectproxy.update(project);
           Config2.dialog(Alert.AlertType.INFORMATION, "Date saved Successfully..");
           
       } else if (project==null&&(!FinishingDateInput.getEditor().getText().equals(""))){
           Config2.dialog(Alert.AlertType.INFORMATION, "Please select a project..");
       } else if (project!=null&&(FinishingDateInput.getEditor().getText().equals(""))){
           Config2.dialog(Alert.AlertType.INFORMATION, "Please select an estimated finishing date..");
       }
      
        
    }
    @FXML
    void DropProject(ActionEvent event) throws NamingException {
        initialContext = new InitialContext();
        projectproxy = (ProjectServiceRemote) initialContext.lookup(jndiNameProject);
        userproxy = (UserServiceRemote) initialContext.lookup(jndiNameUser);
        Project project = ActionsInterruptedProjectsList.getSelectionModel().getSelectedItem();
        User user = project.getResponsable();
        user.setUserFct(UserFunction.ENGINEER);
        user.setGrade("Engineer");
        Config2.dialog(Alert.AlertType.INFORMATION, "Are you sure to delete "+project.getProjectName()+" ?");
        projectproxy.delete(project);
        userproxy.update(user);
        Config2.dialog(Alert.AlertType.INFORMATION, "Date removed Successfully..");
    }
    @FXML
    void DeleteProject(ActionEvent event) throws NamingException {
        initialContext = new InitialContext();
        projectproxy = (ProjectServiceRemote) initialContext.lookup(jndiNameProject);
        Config2.dialog(Alert.AlertType.INFORMATION, "Are you Sure to delete "+ActionsInterruptedProjectsList.getSelectionModel().getSelectedItem().getProjectName());
        projectproxy.delete(ActionsInterruptedProjectsList.getSelectionModel().getSelectedItem());
    }
    @FXML
    void MarkFinished(ActionEvent event) throws NamingException {
        initialContext = new InitialContext();
        Date date = new Date();
        projectproxy = (ProjectServiceRemote) initialContext.lookup(jndiNameProject);
        userproxy = (UserServiceRemote) initialContext.lookup(jndiNameUser);
        productproxy = (ProductServiceRemote) initialContext.lookup(jndiNameProduct);
        ActionsProgressProject.getSelectionModel().getSelectedItem().setFinDate(date);
        ActionsProgressProject.getSelectionModel().getSelectedItem().setEtat(StateProject.FINISHED);
        ActionsProgressProject.getSelectionModel().getSelectedItem().getProduct().setDateCreation(date);
        ActionsProgressProject.getSelectionModel().getSelectedItem().getResponsable().setGrade("Engineer");
        ActionsProgressProject.getSelectionModel().getSelectedItem().getResponsable().setUserFct(UserFunction.ENGINEER);
        userproxy.update(ActionsProgressProject.getSelectionModel().getSelectedItem().getResponsable());
        projectproxy.update(ActionsProgressProject.getSelectionModel().getSelectedItem());
        productproxy.update(ActionsProgressProject.getSelectionModel().getSelectedItem().getProduct());
    }
    /////////////////////// fin Projects //////////////////////////
    @FXML
    void aksiTrue(ActionEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        Platform.runLater(() -> {
        try {
            initialContext = new InitialContext();
           
            projectproxy = (ProjectServiceRemote) initialContext.lookup(jndiNameProject);
            userproxy = (UserServiceRemote) initialContext.lookup(jndiNameUser);
            productproxy = (ProductServiceRemote) initialContext.lookup(jndiNameProduct);
            ///////// Date and delay verification ////////////
           /* Projectverif = projectproxy.findAll();
            for(Project project : Projectverif)
            {
                System.out.println(project);
                Date date = new Date();
                
                if(project.getFinDate().compareTo(date)==0)
                { 
                    project.setEtat(StateProject.FINISHED);
                    project.getResponsable().setGrade("Engineer");
                    project.getResponsable().setUserFct(UserFunction.ENGINEER);
                    project.getProduct().setDateCreation(project.getFinDate());
                    projectproxy.update(project);
                    
                }
            }*/
            /////////////////////////////////////////
            champs=FXCollections.observableArrayList(projectproxy.findByStateProject(StateProject.FINISHED));
            champs1=FXCollections.observableArrayList(projectproxy.findByStateProject(StateProject.IN_PROGRESS));
            champs2=FXCollections.observableArrayList(projectproxy.findByStateProject(StateProject.INTERRUPTED));
            responsables=FXCollections.observableArrayList(userproxy.findByFunction(UserFunction.ENGINEER));
            ProductCombo.getItems().addAll(productproxy.findAll());
            ListFinishedProjects.setCellFactory((ListView<Project> arg2) -> {
                ListCell<Project> cell = new ListCell<Project>() {
                    @Override
                    protected void updateItem(Project e, boolean btl) {
                        super.updateItem(e, btl);

                        if (e != null) {
                            //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                            File file = new File("C:\\wamp64\\www\\imagesAmine\\circle.png");
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
                            ListFinishedProjects.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2
                                            ) {
                                    

                                        DetailsFinishedProjectsController l = new DetailsFinishedProjectsController();
                                        l.Redirect(ListFinishedProjects.getSelectionModel().getSelectedItem());
                                        
                                        AnchorPane pane = new AnchorPane();
                                        try {
                                            pane = FXMLLoader.load(getClass().getResource("/fxml/DetailsFinishedProjects.fxml"));
                                        } catch (IOException ex) {
                                           
                                        }
                                        Anchor.getChildren().setAll(pane);

                                    }  }
                            });
                            setText(e.getProjectName());
                                
                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            ListProgressProject.setCellFactory((ListView<Project> arg2) -> {
                ListCell<Project> cell = new ListCell<Project>() {
                    @Override
                    protected void updateItem(Project e, boolean btl) {
                        super.updateItem(e, btl);

                        if (e != null) {
                            //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                            File file = new File("C:\\wamp64\\www\\imagesAmine\\In_progress_icon.svg.png");
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
                            ListProgressProject.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2
                                            ) {
                                    

                                        DetailsProgressProjectsController l = new DetailsProgressProjectsController();
                                        l.Redirect(ListProgressProject.getSelectionModel().getSelectedItem());
                                        
                                        AnchorPane pane = new AnchorPane();
                                        try {
                                            pane = FXMLLoader.load(getClass().getResource("/fxml/DetailsProgressProjects.fxml"));
                                        } catch (IOException ex) {
                                           
                                        }
                                        Anchor.getChildren().setAll(pane);

                                    }  }
                            });
                            setText(e.getProjectName());

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            ActionsProgressProject.setCellFactory((ListView<Project> arg2) -> {
                ListCell<Project> cell = new ListCell<Project>() {
                    @Override
                    protected void updateItem(Project e, boolean btl) {
                        super.updateItem(e, btl);

                        if (e != null) {
                            //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                            File file = new File("C:\\wamp64\\www\\imagesAmine\\In_progress_icon.svg.png");
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

                            setText(e.getProjectName());

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            ListResponsables.setCellFactory((ListView<User> arg2) -> {
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

                            setText(e.getName());

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            EngineersAndTechniciansList.setCellFactory((ListView<User> arg2) -> {
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

                            setText(e.getName());

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            InProgressProjects.setCellFactory((ListView<Project> arg2) -> {
                ListCell<Project> cell = new ListCell<Project>() {
                    @Override
                    protected void updateItem(Project e, boolean btl) {
                        super.updateItem(e, btl);

                        if (e != null) {
                            //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                            File file = new File("C:\\wamp64\\www\\imagesAmine\\In_progress_icon.svg.png");
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

                            setText(e.getProjectName());

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            TasksListByProject.setCellFactory((ListView<Task> arg2) -> {
                ListCell<Task> cell = new ListCell<Task>() {
                    @Override
                    protected void updateItem(Task e, boolean btl) {
                        super.updateItem(e, btl);

                        if (e != null) {
                            //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                            File file = new File("C:\\wamp64\\www\\imagesAmine\\"+e.getResponsableTache().getPhoto());
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

                            setText("Task name : "+e.getNomTache()+ "\n Done by "+e.getResponsableTache().getName()
                                    +"\n Starts the : "+e.getDateDebut());

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            InProgressProjects.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    tasks =FXCollections.observableArrayList(GetTasksByProject(InProgressProjects.getSelectionModel().getSelectedItem()));
                    TasksListByProject.setItems(tasks);
                    ProjectNametext.setText(InProgressProjects.getSelectionModel().getSelectedItem().getProjectName());
                    
                }
                
            });
            ListInterruptedProject.setCellFactory((ListView<Project> arg2) -> {
                ListCell<Project> cell = new ListCell<Project>() {
                    @Override
                    protected void updateItem(Project e, boolean btl) {
                        super.updateItem(e, btl);

                        if (e != null) {
                            //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                            File file = new File("C:\\wamp64\\www\\imagesAmine\\Untitled-4-512.png");
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
                            ListInterruptedProject.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2
                                            ) {
                                    

                                        DetailsInterruptedProjectsController l = new DetailsInterruptedProjectsController();
                                        l.Redirect(ListInterruptedProject.getSelectionModel().getSelectedItem());
                                        
                                        AnchorPane pane = new AnchorPane();
                                        try {
                                            pane = FXMLLoader.load(getClass().getResource("/fxml/DetailsInterruptedProjects.fxml"));
                                        } catch (IOException ex) {
                                           
                                        }
                                        Anchor.getChildren().setAll(pane);

                                    }  }
                            });
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

                            setText(e.getProjectName());

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            
            ActionsInterruptedProjectsList.setCellFactory((ListView<Project> arg2) -> {
                ListCell<Project> cell = new ListCell<Project>() {
                    @Override
                    protected void updateItem(Project e, boolean btl) {
                        super.updateItem(e, btl);

                        if (e != null) {
                            //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                            File file = new File("C:\\wamp64\\www\\imagesAmine\\Untitled-4-512.png");
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

                            setText(e.getProjectName());

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                            // setAlignment(Pos.CENTER);
                        }

                    }

                };
                return cell;
                
                
                
            });
            ListFinishedProjects.setItems(champs);
            ListProgressProject.setItems(champs1);
            InProgressProjects.setItems(champs1);
            ListResponsables.setItems(responsables);
            ActionsProgressProject.setItems(champs1);
            ListInterruptedProject.setItems(champs2);
            ActionsInterruptedProjectsList.setItems(champs2);
            EngineersAndTechniciansList.setItems(responsables);
            
            ImageShowProduct.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

                @Override
                public void handle(MouseEvent arg0) {
                    SelectProductAndSuplierPAne.toBack();
                    new FadeInUpTransition(AddProductPane).play();
                }
                
            });
            UpdateProduct.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

                @Override
                public void handle(MouseEvent arg0) {
                    SelectProductAndSuplierPAne.toBack();
                    new FadeInUpTransition(AddProductPane).play();
                    ProductNameText.setText(ProductCombo.getSelectionModel().getSelectedItem().getNomProduit());
                    if(ProductCombo.getSelectionModel().getSelectedItem().getType().equals("Product")){
                        TypeProduct.setSelected(true);
                        TypeService.setSelected(false);
                    } else if(ProductCombo.getSelectionModel().getSelectedItem().getType().equals("Service")){
                        TypeService.setSelected(true);
                        TypeProduct.setSelected(false);
                        TextQuantity.setDisable(true);
                    }
                    TextQuantity.setText(String.valueOf(ProductCombo.getSelectionModel().getSelectedItem().getQte()));
                PriceText.setText(String.valueOf(ProductCombo.getSelectionModel().getSelectedItem().getPrixUnitaire()));
                Idproduct.setText(String.valueOf(ProductCombo.getSelectionModel().getSelectedItem().getId()));
                Idproduct.setVisible(false);
                }
                
            });
            TypeService.selectedProperty().addListener(new ChangeListener<Boolean>() {

                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    TextQuantity.setDisable(true);
                    TextQuantity.setText("1");
                }
                
            });
            TypeProduct.selectedProperty().addListener(new ChangeListener<Boolean>() {

                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    TextQuantity.setDisable(false);
                }
                
            });
        } catch (NamingException e) {
            
            e.printStackTrace();
        }
         
         
        

        });
        ////////////////// Tasks ////////////////////
    }
    @FXML
    void LoadAddTaskPane(ActionEvent event) {
        AnchorAddTask.toFront();
        new FadeInUpTransition(AnchorAddTask).play();
        RemoveTask.setVisible(false);
        UpdateTask.setVisible(false);
        NewTask.setVisible(false);
        refreshLists();
        clear();

        
    }

    @FXML
    void ClosePaneAddTask(ActionEvent event) {

        AnchorAddTask.toBack();
        new FadeInUpTransition(TasksPane).play();
        RemoveTask.setVisible(true);
        UpdateTask.setVisible(true);
        NewTask.setVisible(true);
        refreshLists();
    }
    @FXML
    void AddOrUpdateTask(ActionEvent event) throws NamingException, ParseException {
        if(InProgressProjects.getSelectionModel().getSelectedItem()==null)
        {
            Config2.dialog(Alert.AlertType.INFORMATION, "Please select a project..");
            clear();
            AnchorAddTask.toFront();
            new FadeInUpTransition(AnchorAddTask).play();
            
        } else {
            if(IdTask.getText().equals("")){
                Task task = new Task();
                initialContext = new InitialContext();
                taskproxy = (TaskServiceRemote) initialContext.lookup(jndiNameTask);
                task.setProject(InProgressProjects.getSelectionModel().getSelectedItem());
                task.setNomTache(TaskNametext.getText());
                task.setDateDebut(convert1(TaskStartDate.getEditor().getText()));
                task.setDateFin(convert1(TaskFinishDate.getEditor().getText()));
                task.setDescrption(NoteText.getText());
                //task.setIdTask();
                task.setFini(false);
                if(EngineersAndTechniciansList.getSelectionModel().getSelectedItem()==null)
                {
                   
                    Config2.dialog(Alert.AlertType.INFORMATION, "Please select the task's responsible..");
                    clear();
                    AnchorAddTask.toFront();
                    new FadeInUpTransition(AnchorAddTask).play();
                }
                else {
                    taskID id = new taskID();
                    id.setIdProject(InProgressProjects.getSelectionModel().getSelectedItem().getId());
                    id.setIdUser(EngineersAndTechniciansList.getSelectionModel().getSelectedItem().getCode());
                    task.setIdTask(id);
                    task.setResponsableTache(EngineersAndTechniciansList.getSelectionModel().getSelectedItem());
                    taskproxy.save(task);
                    clear();
                    refreshLists();
                    TasksPane.toFront();
                    new FadeInUpTransition(TasksPane).play();
                }
                
            } else {
                Task task = TasksListByProject.getSelectionModel().getSelectedItem();
                
                
                
                initialContext = new InitialContext();
                taskproxy = (TaskServiceRemote) initialContext.lookup(jndiNameTask);
                task.setProject(InProgressProjects.getSelectionModel().getSelectedItem());
                task.setNomTache(TaskNametext.getText());
                task.setDateDebut(convert1(TaskStartDate.getEditor().getText()));
                task.setDateFin(convert1(TaskFinishDate.getEditor().getText()));
                task.setDescrption(NoteText.getText());
                //task.setIdTask();
                task.setFini(false);
                if(EngineersAndTechniciansList.getSelectionModel().getSelectedItem()==null)
                {
                   
                    Config2.dialog(Alert.AlertType.INFORMATION, "Please select the task's responsible..");
                    clear();
                    AnchorAddTask.toFront();
                    new FadeInUpTransition(AnchorAddTask).play();
                }
                else {
                    taskID id = new taskID();
                    id.setIdProject(InProgressProjects.getSelectionModel().getSelectedItem().getId());
                    id.setIdUser(EngineersAndTechniciansList.getSelectionModel().getSelectedItem().getCode());
                    task.setIdTask(id);
                    task.setResponsableTache(EngineersAndTechniciansList.getSelectionModel().getSelectedItem());
                    taskproxy.update(task);
                }
                clear();
                refreshLists();
                TasksPane.toFront();
                new FadeInUpTransition(TasksPane).play();
                
            }
            
            
        }
    }
    @FXML
    void ShowAddOrUpdateTask(ActionEvent event) {
        if(TasksListByProject.getSelectionModel().getSelectedItem()==null){
            Config2.dialog(Alert.AlertType.INFORMATION, "Please select a task to update ..");
        } else {
            AnchorAddTask.toFront();
            new FadeInUpTransition(AnchorAddTask).play();
            RemoveTask.setVisible(false);
            UpdateTask.setVisible(false);
            NewTask.setVisible(false);
            refreshLists();
            TaskNametext.setText(TasksListByProject.getSelectionModel().getSelectedItem().getNomTache());
            TaskStartDate.getEditor().setText(String.valueOf(TasksListByProject.getSelectionModel().getSelectedItem().getDateDebut()));
            TaskFinishDate.getEditor().setText(String.valueOf(TasksListByProject.getSelectionModel().getSelectedItem().getDateFin()));
            NoteText.setText(TasksListByProject.getSelectionModel().getSelectedItem().getDescrption());
            IdTask.setText(TasksListByProject.getSelectionModel().getSelectedItem().getDescrption());
        }
        
    }
    @FXML
    void RemoveTask(ActionEvent event) throws NamingException {
        initialContext = new InitialContext();
        taskproxy = (TaskServiceRemote) initialContext.lookup(jndiNameTask);
        Task task = TasksListByProject.getSelectionModel().getSelectedItem();
        if(task==null)
        {
            Config2.dialog(Alert.AlertType.INFORMATION, "Please select a task to remove ..");
        } else {
            Config2.dialog(Alert.AlertType.INFORMATION, "Are you sure to delet this task ? ..");
            taskproxy.delete(task);
        }
    }
    //////////////// Fin Tasks //////////////////
    /////////////// Product ////////////////////
    @FXML
    void CloseAddProduct(ActionEvent event) {
        AddProductPane.toBack();
        new FadeInUpTransition(SelectProductAndSuplierPAne).play();
    }
    @FXML
    void SaveProduct(ActionEvent event) throws NamingException {
        Product product = null;
        initialContext = new InitialContext();
        productproxy = (ProductServiceRemote) initialContext.lookup(jndiNameProduct);
        if(Idproduct.getText().equals(""))
        {
            product = new Product();
            product.setNomProduit(ProductNameText.getText());
            
            product.setPrixUnitaire(Float.parseFloat(PriceText.getText()));
            if(TypeProduct.isSelected())
            {
                product.setType("Product");
            } else if(TypeService.isSelected())
            {
                product.setType("Service");
                TextQuantity.setDisable(true);
                
                
            }
            product.setQte(Integer.parseInt(TextQuantity.getText()));
            
            productproxy.save(product);
            ProductCombo.setValue(product);
            AddProductPane.toBack();
            new FadeInUpTransition(SelectProductAndSuplierPAne).play();
        } else { product = ProductCombo.getSelectionModel().getSelectedItem();
        product.setNomProduit(ProductNameText.getText());
        
        product.setPrixUnitaire(Float.parseFloat(PriceText.getText()));
        if(TypeProduct.isSelected())
        {
            product.setType("Product");
        } else if(TypeService.isSelected())
        {
            product.setType("Service");
            TextQuantity.setDisable(true);
            
            
        }
        product.setQte(Integer.parseInt(TextQuantity.getText()));
        
        productproxy.update(product);
        
        ProductCombo.setValue(product);
        AddProductPane.toBack();
        new FadeInUpTransition(SelectProductAndSuplierPAne).play();
        }
        
        

    }
    
    //////////////////////////////////////////////
    
    /////////// Utils //////////////////////////////
    
    public static Date convert(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(date);
        return d1;
    }
    public static Date convert1(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = sdf.parse(date);
        return d1;
    }
   /*public static String convert(Date d) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String text = df.format(d);
        return text;
    }*/
    private List<Project> findAll() {
        List<Project> projects = new ArrayList<>();
        try {
            initialContext = new InitialContext();
            projectproxy = (ProjectServiceRemote) initialContext.lookup(jndiNameProject);
            projects = projectproxy.findAll();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return projects;
    }

    private void clear() {
        txtId.clear();
        ProjectName.clear();
        txtDescription.clear();
        debutProjet.getEditor().clear();
        FinProjet.getEditor().clear();
        budget.clear();
        ProjectNametext.clear();
        ProjectName.clear();
        TaskNametext.clear();
        TaskStartDate.getEditor().clear();
        TaskFinishDate.getEditor().clear();
        NoteText.clear();
        ReasonText.clear();
        DelayText.clear();
        Idproduct.setText("");
        IdTask.setText("");
    }
    private List<Task> GetTasksByProject(Project project)
    {
        return project.getTasks();
    }
    private void refreshLists()
    {
        ListFinishedProjects.setItems(champs);
        ListProgressProject.setItems(champs1);
        InProgressProjects.setItems(champs1);
        ListResponsables.setItems(responsables);
        ActionsProgressProject.setItems(champs1);
        ListInterruptedProject.setItems(champs2);
        ActionsInterruptedProjectsList.setItems(champs2);
        EngineersAndTechniciansList.setItems(responsables);
    }
    /////////////////////// fin Utils ////////////////////////
    
}
