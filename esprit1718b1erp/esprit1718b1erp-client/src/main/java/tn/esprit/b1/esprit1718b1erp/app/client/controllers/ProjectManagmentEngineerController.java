package tn.esprit.b1.esprit1718b1erp.app.client.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.Convert;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.StateProject;
import tn.esprit.b1.esprit1718b1erp.entities.Task;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectServiceRemote;
import tn.esprit.b1.esprit1718b1erp.services.youssfi.TaskServiceRemote;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ProjectManagmentEngineerController implements Initializable{

    @FXML
    private AnchorPane Anchor;

    @FXML
    private Button btnNew;

    @FXML
    private ImageView imgLoad;

    @FXML
    private ProgressBar bar;

    @FXML
    private AnchorPane PaneManageProject;

    @FXML
    private AnchorPane paneTabel;

    @FXML
    private ListView<Project> ListFinishedProjects;

    @FXML
    private ListView<Project> ListProgressProject;

    @FXML
    private ListView<Project> ListInterruptedProject;
    @FXML
    private ListView<Project> InprogressProjects;
    @FXML
    private ListView<Task> YourTasksList;
    @FXML
    private AnchorPane ManageTasks;
    @FXML
    private CheckBox MarkFinishedInput;

    @FXML
    private TextArea FeedbackText;

    @FXML
    private CheckBox SetDelayInput;

    @FXML
    private TextField DelayText;

    private final String jndiNameProject= "esprit1718b1erp-ear/esprit1718b1erp-service/ProjectService!tn.esprit.b1.esprit1718b1erp.services.youssfi.ProjectServiceRemote";
    private final String jndiNameTask = "esprit1718b1erp-ear/esprit1718b1erp-service/TaskService!tn.esprit.b1.esprit1718b1erp.services.youssfi.TaskServiceRemote";

    private InitialContext initialContext = null;
    ProjectServiceRemote projectproxy = null;
    TaskServiceRemote taskproxy = null;
    ObservableList<Project> champs;
    ObservableList<Project> champs1;
    ObservableList<Project> champs2;
    List<Task> Usertasks;

    @FXML
    void AddNew(ActionEvent event) {
        paneTabel.setOpacity(0);
        new FadeInUpTransition(PaneManageProject).play();
    }

    @SuppressWarnings("restriction")
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            initialContext = new InitialContext();
            projectproxy = (ProjectServiceRemote) initialContext.lookup(jndiNameProject);
        } catch (NamingException e1) {
            e1.printStackTrace();
        }
        champs=FXCollections.observableArrayList(projectproxy.findByStateProject(StateProject.FINISHED));
        champs1=FXCollections.observableArrayList(projectproxy.findByStateProject(StateProject.IN_PROGRESS));
        champs2=FXCollections.observableArrayList(projectproxy.findByStateProject(StateProject.INTERRUPTED));
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
        InprogressProjects.setCellFactory((ListView<Project> arg2) -> {
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
        InprogressProjects.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1
                        ) {
                
                    
                  
                    try {
                        YourTasksList.setItems(FXCollections.observableArrayList(UsertasksbyProject()));
                    } catch (NamingException e) {
                        e.printStackTrace();
                    }

                }  }
        });
        YourTasksList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1
                        ) {
                
                    
                    ManageTasks.toFront();
                    new FadeInUpTransition(ManageTasks).play();

                }  }
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
        YourTasksList.setCellFactory((ListView<Task> arg2) -> {
            ListCell<Task> cell = new ListCell<Task>() {
                @Override
                protected void updateItem(Task e, boolean btl) {
                    super.updateItem(e, btl);

                    if (e != null) {
                        //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                        if(!e.isFini()){
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
                            setText("Started the : "+e.getDateDebut()+"\n Will finish the : "+e.getDateFin()+"\n Descrption : "+e.getDescrption());

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                            // setAlignment(Pos.CENTER);
                        } else{
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
                            setText("Started the : "+e.getDateDebut()+"\n Will finish the : "+e.getDateFin()+"\n Descrption : "+e.getDescrption());

                            setFont(Font.font("Berlin Sans FB Demi Bold", 12));

                            // setAlignment(Pos.CENTER);
                        }
                        
                    }

                }

            };
            return cell;
            
            
            
        });
        SetDelayInput.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                DelayText.setDisable(false);
                MarkFinishedInput.setSelected(false);
            }
            
        });
        MarkFinishedInput.selectedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                DelayText.setDisable(true);
                SetDelayInput.setSelected(false);
                
            }
            
        });
        ListFinishedProjects.setItems(champs);
        ListProgressProject.setItems(champs1);
        ListInterruptedProject.setItems(champs2);
        InprogressProjects.setItems(champs1);
    }
    @FXML
    void SaveYourTask(ActionEvent event) throws NamingException, ParseException {
        initialContext = new InitialContext();
        taskproxy = (TaskServiceRemote) initialContext.lookup(jndiNameTask);
        Task task = YourTasksList.getSelectionModel().getSelectedItem();
        if(SetDelayInput.isSelected())
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            c.setTime(task.getDateFin()); // finishing date.
            c.add(Calendar.DATE, Integer.parseInt(DelayText.getText())); // Adding days
            String output = sdf.format(c.getTime());
            task.setDateFin(convert(output));
            task.setFeedback(FeedbackText.getText());
            taskproxy.update(task);
            Config2.dialog(Alert.AlertType.INFORMATION, "Task delayed successfully..");
        } else if (MarkFinishedInput.isSelected()){
            task.setFeedback(FeedbackText.getText());
            task.setFini(true);
            taskproxy.update(task);
            Config2.dialog(Alert.AlertType.INFORMATION, "You have accomplished your task..");
        }

    }
    List<Task> TasksByProjectAndUser(){
        Project project = InprogressProjects.getSelectionModel().getSelectedItem();
        List<Task> UserTasks = new ArrayList<Task>();
        System.out.println(project.getTasks());
        for(Task task : project.getTasks()){
            if(task.getResponsableTache()==LoginController.getLoggedUser())
            {
                UserTasks.add(task);
            }
        }
        System.out.println(UserTasks);
        System.out.println(LoginController.getLoggedUser());
        return UserTasks;
        
    }
    List<Task> UsertasksbyProject() throws NamingException
    {
        initialContext = new InitialContext();
        taskproxy = (TaskServiceRemote) initialContext.lookup(jndiNameTask);
       return taskproxy.findtasksbyUser(InprogressProjects.getSelectionModel().getSelectedItem(), LoginController.getLoggedUser());
       
    }
    public static Date convert(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = sdf.parse(date);
        return d1;
    }

}
