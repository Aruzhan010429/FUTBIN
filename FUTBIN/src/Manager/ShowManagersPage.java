package Manager;


import Controllers.MainPage;
import Controllers.WelcomePage;
import Database.ManagerShowOperations;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShowManagersPage extends Application  {



    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Manager Show Page");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);



        Button btnHome = new Button("Home");
        btnHome.setMaxWidth(Double.MAX_VALUE);
        btnHome.setMinWidth(60);
        btnHome.setMinHeight(30);

        HBox hbBth = new HBox(10);
        hbBth.setAlignment(Pos.TOP_RIGHT);
        hbBth.getChildren().add(btnHome);
        grid.add(hbBth, 0, 1);

        btnHome.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                WelcomePage l = new WelcomePage();
                l.start(primaryStage);
            }
        });

        grid.setAlignment(Pos.TOP_LEFT);
        Button btnExit = new Button("Logout");
        btnExit.setMaxWidth(Double.MAX_VALUE);
        btnExit.setMinWidth(60);
        btnExit.setMinHeight(30);

        HBox hbBt = new HBox(10);
        hbBt.setAlignment(Pos.TOP_RIGHT);
        hbBt.getChildren().add(btnExit);
        grid.add(hbBt, 0, 0);

        btnExit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                MainPage l = new MainPage();
                l.start(primaryStage);
            }
        });



        Button btnHome1 = new Button("Manager");
        btnHome1.setMaxWidth(Double.MAX_VALUE);
        btnHome1.setMinWidth(60);
        btnHome1.setMinHeight(30);
        HBox hbBth1 = new HBox(10);
        hbBth1.setAlignment(Pos.TOP_RIGHT);
        hbBth1.getChildren().add(btnHome1);
        grid.add(hbBth1, 0, 2);

        btnHome1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                ManagersPage managersPage=new ManagersPage();
                managersPage.start(primaryStage);
            }
        });

        grid.setAlignment(Pos.TOP_LEFT);

        TableView table = new TableView();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        table.setEditable(true);

        TableColumn firstcol = new TableColumn("ManagerID");
        firstcol.setCellValueFactory(new MapValueFactory("ManagerID"));
        firstcol.setMinWidth(30);

        TableColumn secondcol = new TableColumn("ManagerSurname");
        secondcol.setCellValueFactory(new MapValueFactory("ManagerSurname"));
        secondcol.setMinWidth(100);

        TableColumn thirdcol = new TableColumn("ManagerName");
        thirdcol.setCellValueFactory(new MapValueFactory("ManagerName"));
        thirdcol.setMinWidth(70);

        TableColumn forthcol = new TableColumn("ManagerSalary");
        forthcol.setCellValueFactory(new MapValueFactory("ManagerSalary"));
        forthcol.setMinWidth(100);

        ManagerShowOperations obj = new ManagerShowOperations ();
        table.setItems(obj.viewOperation());

        table.getColumns().addAll(firstcol, secondcol, thirdcol, forthcol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(scenetitle, table);

        grid.add(vbox, 0, 3);

        primaryStage.setTitle("View Manager Page");
        Scene scene = new Scene(grid, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



}
