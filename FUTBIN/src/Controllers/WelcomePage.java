package Controllers;

import Manager.ManagersPage;
import Player.PlayersPage;
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

public class WelcomePage extends Application  {

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome Page");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 10, 10);

        Button btnExit = new Button("Logout");
        btnExit.setMaxWidth(Double.MAX_VALUE);
        btnExit.setMinWidth(30);
        btnExit.setMinHeight(20);
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

        grid.setAlignment(Pos.TOP_CENTER);



        Button btn = new Button(" Players Page");
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
PlayersPage c= new PlayersPage();
c.start(primaryStage);
            }
        });

        Button btn1 = new Button("   Managers Page");
        btn1.setMaxWidth(Double.MAX_VALUE);
        btn1.setMinWidth(200);
        btn1.setMinHeight(70);
        btn1.setStyle("-fx-font-size: 15pt;");
        HBox hbBtn1 = new HBox(10);
        //hbBtn1.setAlignment(Pos.TOP_CENTER);
        hbBtn1.getChildren().add(btn1);
        grid.add(hbBtn1, 0, 17, 10, 3 );

        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                ManagersPage managersPage=new ManagersPage();
                managersPage.start(primaryStage);

            }
        });

        Button btn3 = new Button("Teams Page");
        btn3.setMaxWidth(Double.MAX_VALUE);
        btn3.setMinWidth(200);
        btn3.setMinHeight(70);
        btn3.setStyle("-fx-font-size: 15pt;");
        HBox hbBtn3 = new HBox(10);
        hbBtn3.getChildren().add(btn3);
        grid.add(hbBtn3, 0, 20, 10, 3 );

        primaryStage.setTitle("WELCOME TO FUTBIN");
        Scene scene = new Scene(grid, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
