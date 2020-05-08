package Player;


import static javafx.geometry.HPos.RIGHT;


import Controllers.MainPage;
import Controllers.WelcomePage;
import Data.PlayerData;
import Database.PlayerShowOperations;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddPlayer extends Application  {

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Add Player Page");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

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
        grid.add(hbBth, 0, 1, 30, 3 );

        btnHome.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                WelcomePage l = new WelcomePage();
                l.start(primaryStage);
            }
        });

        Button btnHome1 = new Button("Player");
        btnHome1.setMaxWidth(Double.MAX_VALUE);
        btnHome1.setMinWidth(60);
        btnHome1.setMinHeight(30);
        HBox hbBth1 = new HBox(10);
        hbBth1.setAlignment(Pos.TOP_RIGHT);
        hbBth1.getChildren().add(btnHome1);
        grid.add(hbBth1, 0, 2, 30, 3 );

        btnHome1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                PlayersPage l = new PlayersPage();
                l.start(primaryStage);
            }
        });

        grid.setAlignment(Pos.TOP_CENTER);

        Label pID = new Label("Player ID:");
        grid.add(pID, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);


        Label sid = new Label("Player Surname:");
        grid.add(sid, 0, 2);

        TextField userTextField1 = new TextField();
        grid.add(userTextField1, 1, 2);

        Label sEmail = new Label("Player Name:");
        grid.add(sEmail, 0, 3);

        TextField userTextField2 = new TextField();
        grid.add(userTextField2, 1, 3);

        Label sPhone = new Label("Player Salary:");
        grid.add(sPhone, 0, 4);

        TextField userTextField3 = new TextField();
        grid.add(userTextField3, 1, 4);

        Button save_button = new Button("Save Details");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(save_button);
        grid.add(hbBtn, 0, 8, 2, 1 );
        //grid.add(hbBtn, 1, 8);

        Text actiontarget = new Text();
        grid.add(actiontarget, 0, 10);
        grid.setColumnSpan(actiontarget, 2);
        grid.setHalignment(actiontarget, RIGHT);
        actiontarget.setId("actiontarget");

        save_button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                String str1 = userTextField.getText();
                String str2 = userTextField1.getText();
                String str3 = userTextField2.getText();
                String str4 = userTextField3.getText();

                if("".equalsIgnoreCase(String.valueOf(str4)) || "".equalsIgnoreCase(str3) ||"".equalsIgnoreCase(str2) || "".equalsIgnoreCase(str1) )
                {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Please provide all values");
                    return;
                }

                PlayerData boObj = new PlayerData();

                boObj.setPlayerID(str1);
                boObj.setPlayerSurname(str2);
                boObj.setPlayerName(str3);
                boObj.setPlayerSalary(str4);


                PlayerShowOperations obj = new PlayerShowOperations();
                String strStatus = obj.addOperation(boObj);

                if("success".equalsIgnoreCase(strStatus))
                {
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Data saved successfully!");
                }
                else
                {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Error in save operation");
                }
            }
        });


        primaryStage.setTitle("Add Player Page");
        Scene scene = new Scene(grid, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
