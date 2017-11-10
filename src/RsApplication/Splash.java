package RsApplication;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Splash extends Application implements EventHandler<ActionEvent>{

    //Create initial objects
    Stage window;                                           //the main window
    Button newPatientBtn, returnPatientBtn, viewReportsBtn; //create buttons for new patient, returning patient and viewing forms.
    BorderPane layout;                                      //the main layout of the window
    HBox bottom;                                            //the sections of the layout
    VBox top, left, center, right;                          //more sections of the layout
    MenuBar topMenu;
    Menu file;
    Image rsLogo, asptLogo;                                 //the logos for reliable solutions and for aspt
    ImageView rsLogoView, asptLogoView;

    //the main method
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //set primary stage
        window = primaryStage;
        window.setTitle("PT Dimension");

        //create layout objects
        layout = new BorderPane();
        top = new VBox();
        left = new VBox();
        bottom = new HBox();
        center = new VBox();
        right = new VBox();

        //set size of panes
        top.setPrefHeight(10);
        left.setPrefWidth(100);
        center.setPrefWidth(200);
        right.setPrefWidth(200);


        //set spacing and padding for each section.
        top.setSpacing(10);
        top.setPadding(new Insets(0));
        left.setSpacing(10);
        left.setPadding(new Insets(10, 0,0,15));
        right.setSpacing(20);
        right.setPadding(new Insets(10, 15,0,0));
        center.setSpacing(15);
        center.setPadding(new Insets(10, 0,0,30));
        bottom.setSpacing(10);
        bottom.setPadding(new Insets(10, 0,15,125));

        //create menubar
        topMenu = new MenuBar();
        topMenu.setPrefWidth(600);
        file = new Menu("File");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });

        file.getItems().addAll(exit);
        topMenu.getMenus().addAll(file);


        /**
         * Create the buttons to direct the user to another section
         * newPatientBtn redirects user to enter a new patient's information
         * returnPatientbtn redirects user to a window to choose what to do next
         * viewReportsBtn sends the user to a window to view reports
         */

        //create images to place on the page.
        rsLogo = new Image(getClass().getResourceAsStream("RS_LogoNew_01.png"));
        rsLogoView = new ImageView(rsLogo);
        rsLogoView.setFitWidth(75);
        rsLogoView.setPreserveRatio(true);

        asptLogo = new Image("https://irp-cdn.multiscreensite.com/8959a3f5/dms3rep/multi/desktop/Logo-195x166.png");
        asptLogoView = new ImageView(asptLogo);
        asptLogoView.setFitWidth(150);
        asptLogoView.setPreserveRatio(true);

        newPatientBtn = new Button("New Patient");
        returnPatientBtn = new Button("Returning Patient");
        viewReportsBtn = new Button("View Reports");

        newPatientBtn.setPrefWidth(100);
        newPatientBtn.setPrefWidth(100);
        viewReportsBtn.setPrefWidth(100);

        //create business information label
        Label busInfo = new Label("Created By: Reliable Solutions, Inc. 2017");

        //add objects to layout areas
        top.getChildren().addAll(topMenu, rsLogoView);
        center.getChildren().add(asptLogoView);
        right.getChildren().addAll(newPatientBtn, returnPatientBtn, viewReportsBtn);
        bottom.getChildren().addAll(busInfo);

        //add sections to main layout
        layout.setTop(top);
        layout.setLeft(left);
        layout.setCenter(center);
        layout.setRight(right);
        layout.setBottom(bottom);

        Scene mainScene = new Scene(layout, 600, 300);
        window.setScene(mainScene);
        window.show();


    }

    @Override
    public void handle(ActionEvent event) {

    }
}
