package tn.esprit.b1.esprit1718b1erp.app.client.controllers;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tn.esprit.b1.esprit1718b1erp.entities.Project;
import tn.esprit.b1.esprit1718b1erp.entities.Task;
import tn.esprit.b1.esprit1718b1erp.entities.User;
import tn.esprit.b1.esprit1718b1erp.services.UserServiceRemote;
import javafx.fxml.Initializable;

public class DetailsProgressProjectsController implements Initializable{

    @FXML
    private AnchorPane Anchor;

    @FXML
    private Text ProjectName;

    @FXML
    private ProgressBar bar;

    @FXML
    private AnchorPane DetailsProject;

    @FXML
    private ListView<User> ProjectCordinator;

    @FXML
    private Label Created;

    @FXML
    private Label Delivered;

    @FXML
    private Label Description;
    @FXML
    private Text Hours;

    @FXML
    private Text Minutes;

    @FXML
    private Text Secondes;

    @FXML
    private ListView<Task> TasksList;
    @FXML
    private Label Budget;
    @FXML
    private Label Product;
    private InitialContext initialContext = null;
    UserServiceRemote userproxy = null;
    ObservableList<User> cordinator;
    private final String jndiNameUser = "esprit1718b1erp-ear/esprit1718b1erp-service/UserService!tn.esprit.b1.esprit1718b1erp.services.UserServiceRemote";
    Date date = new Date();
    
    static Project project;
   // long secondes = (project.getDuration())/1000;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ProjectName.setText(project.getProjectName());
        Created.setText(String.valueOf(project.getStartDate()));
        Delivered.setText(String.valueOf(project.getFinDate()));
        Description.setText(project.getDescription());
        Budget.setText(String.valueOf(project.getBugdet()));
        Product.setText(project.getProduct().getNomProduit());
       // Secondes.setText(String.valueOf(secondes));
        
        ProjectCordinator.setCellFactory((ListView<User> arg2) -> {
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

                       
                            setText("Project cordinator's Name : "+e.getName()+"\n"+"Mail : "+e.getEmail()+"\n"+"Salary :"+e.getSalary());
                        
                    

                        setFont(Font.font("Berlin Sans FB Demi Bold", 12));
                        
                        // setAlignment(Pos.CENTER);
                    }

                }

            };
            return cell;
            
            
            
        });
        TasksList.setCellFactory((ListView<Task> arg2) -> {
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
        try {
            ProjectCordinator();
            TasksList.setItems(FXCollections.observableArrayList(project.getTasks()));
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public void Redirect(Project project)
    {
        this.project=project;
        System.out.println(project);
    }
    public void ProjectCordinator() throws NamingException
    {
        initialContext = new InitialContext();
        userproxy = (UserServiceRemote) initialContext.lookup(jndiNameUser);
        List<User> list = new ArrayList<>();
        list.add(userproxy.findByCode(project.getResponsable().getCode()));
        cordinator =FXCollections.observableArrayList(list);
        ProjectCordinator.setItems(cordinator);
       // return cordinator;
    }
}
