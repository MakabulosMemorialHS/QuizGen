/* ******************************************************************
 * QuizGenFX.java
 *
 * Program to generate High School Mathematics Drills.
 *
 * *****************************************************************/
import java.lang.*;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.text.*;
import javafx.event.*;

public class QuizGenFX extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    @Override public void start(Stage stage) {

        stage.setTitle("Quiz Generator");

       /* **************************************************************
          Setup the Scene. The scene graph shall consist of a VBox as
          the root node with the following three children. 

          (a) A Text element for the title.
          (b) An HBox which will contain Text and a ChoiceBox.
          (b) Another HBox which shall contain Buttons.

          Note the use of CSS to set the style for the application. 
       ************************************************************** */

        /* This is the root node for the scene graph. */

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("QuizGenFX.css");

        /* Now comes the children of root. */

        /* The banner title for the application. */

        Text titleText = new Text("QuizGen: Quiz Generator");
        titleText.getStyleClass().add("h1");
        root.getChildren().add(titleText);


        /* This HBox shall hold the ChoiceBox and its label. */

        HBox hChoices = new HBox();
        hChoices.getStyleClass().add("choice-box");

        Text choiceLabel = new Text("Select Quiz");
        choiceLabel.getStyleClass().add("h3");
        hChoices.getChildren().add(choiceLabel);

        ChoiceBox<String> qSelect = new ChoiceBox<String>();
        hChoices.getChildren().add(qSelect);

        root.getChildren().add(hChoices);

        qSelect.getItems().addAll(
             "Linear Equations I",
             "Linear Equations II",
             "Quadratic Equations I", 
             "Quadratic Equations II", 
             "Rational Equations I", 
             "Rational Equations II");
      
        /* 
           This HBox shall hold the following buttons. 
           (a) Quit
           (b) OK
        */

        HBox ButtonBox = new HBox();
        ButtonBox.getStyleClass().add("button-box");

        Button QuitButton = new Button("Quit");
        QuitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Platform.exit();
            }
        });


        Button OKButton = new Button("OK");
        OKButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String selected = qSelect.getValue();
                if (selected == "Rational Equations I") {
                    RationalEqn.Set01();
                }
                else {  
                System.out.println("You have selected " 
                     + selected 
                     + ". Unfortunately, that module is currently unimplemented.");
                }
            }
        });

        ButtonBox.getChildren().addAll(QuitButton, OKButton);
        root.getChildren().add(ButtonBox);

        stage.setScene(scene);
        stage.show();
    }
}

