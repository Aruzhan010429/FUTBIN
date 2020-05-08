package Manager;

import Controllers.MainPage;
import Controllers.WelcomePage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ManagersPage extends Application{


        @Override
        public void start(Stage primaryStage) {

            GridPane grid = new GridPane();
            grid.setAlignment(Pos.TOP_CENTER);
            grid.setHgap(5);
            grid.setVgap(5);
            grid.setPadding(new Insets(25, 25, 25, 25));

            Text scenetitle = new Text("Manager Home Page");
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            grid.add(scenetitle, 0, 0, 10, 10);


            Button btnExit = new Button("Logout");
            btnExit.setMaxWidth(Double.MAX_VALUE);
            btnExit.setMinWidth(60);
            btnExit.setMinHeight(30);

            HBox hbBt = new HBox(10);
            hbBt.setAlignment(Pos.TOP_RIGHT);
            hbBt.getChildren().add(btnExit);
            grid.add(hbBt, 0, 0, 30, 3 );

            btnExit.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    MainPage l = new MainPage();
                    l.start(primaryStage);
                }
            });

            Button btnHome = new Button("Home");
            btnHome.setMaxWidth(Double.MAX_VALUE);
            btnHome.setMinWidth(60);
            btnHome.setMinHeight(30);

            HBox hbBth = new HBox(10);
            hbBth.setAlignment(Pos.TOP_RIGHT);
            hbBth.getChildren().add(btnHome);
            grid.add(hbBth, 0, 4, 30, 3 );

            btnHome.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    WelcomePage l = new WelcomePage();
                    l.start(primaryStage);
                }
            });

            grid.setAlignment(Pos.TOP_CENTER);


            Button btn = new Button("View Managers");
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMinWidth(200);
            btn.setMinHeight(70);
            btn.setStyle("-fx-font-size: 15pt;");
            HBox hbBtn = new HBox(10);

            hbBtn.getChildren().add(btn);
            grid.add(hbBtn, 0, 14, 10, 3 );

            btn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    ShowManagersPage showManagersPage= new ShowManagersPage();
                    showManagersPage.start(primaryStage);

                }
            });

            Button btn1 = new Button("Add Professor");
            btn1.setMaxWidth(Double.MAX_VALUE);
            btn1.setMinWidth(200);
            btn1.setMinHeight(70);
            btn1.setStyle("-fx-font-size: 15pt;");
            HBox hbBtn1 = new HBox(10);

            hbBtn1.getChildren().add(btn1);
            grid.add(hbBtn1, 0, 17, 10, 3 );

            btn1.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    AddManager addManager=new AddManager();
                    addManager.start(primaryStage);

                }
            });

            Button btn3 = new Button("Update Manager");
            btn3.setMaxWidth(Double.MAX_VALUE);
            btn3.setMinWidth(200);
            btn3.setMinHeight(70);
            btn3.setStyle("-fx-font-size: 15pt;");
            HBox hbBtn3 = new HBox(10);hbBtn3.getChildren().add(btn3);
            grid.add(hbBtn3, 0, 20, 10, 3 );

            btn3.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    UpdateManager updateManager=new UpdateManager();
                    updateManager.start(primaryStage);

                }
            });

            Button btn4 = new Button("Delete Manager");
            btn4.setMaxWidth(Double.MAX_VALUE);
            btn4.setMinWidth(200);
            btn4.setMinHeight(70);
            btn4.setStyle("-fx-font-size: 15pt;");
            HBox hbBtn4 = new HBox(10);

            hbBtn4.getChildren().add(btn4);
            grid.add(hbBtn4, 0, 23, 10, 3 );

            btn4.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    DeleteManager deleteManager=new DeleteManager();
                    deleteManager.start(primaryStage);

                }
            });



            primaryStage.setTitle("FUTBIN");
            Scene scene = new Scene(grid, 1000, 600);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

    }


