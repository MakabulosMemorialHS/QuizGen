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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
             "Exponents I",
             "Exponents II",
             "Linear Equations I",
             "Linear Equations II",
             "Quadratic Functions I",
             "Quadratic Equations I", 
             "Quadratic Equations II", 
             "Rational Equations I", 
             "Rational Equations II",
             "Sequences I",
             "Variations I",
             "Variations II");
      
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
                if (selected == "Exponents I") {
                    Exponents.Set01();
                    Alert doneAlert = new Alert(AlertType.INFORMATION, 
                         "Output written to temp.tex");
                    doneAlert.showAndWait();
                }
                else if (selected == "Exponents II") {
                    Exponents.Set02();
                    Alert doneAlert = new Alert(AlertType.INFORMATION, 
                         "Output written to temp.tex");
                    doneAlert.showAndWait();
                }
                else if (selected == "Linear Equations I") {
                    LinearEquations.Set01();
                    Alert doneAlert = new Alert(AlertType.INFORMATION, 
                         "Output written to temp.tex");
                    doneAlert.showAndWait();
                }
                else if (selected == "Linear Equations II") {
                    LinearEquations.Set02();
                    Alert doneAlert = new Alert(AlertType.INFORMATION, 
                         "Output written to temp.tex");
                    doneAlert.showAndWait();
                }
                else if (selected == "Rational Equations I") {
                    RationalEqn.Set01();
                    Alert doneAlert = new Alert(AlertType.INFORMATION, 
                         "Output written to temp.tex");
                    doneAlert.showAndWait();
                }
                else if (selected == "Rational Equations II") {
                    RationalEqn.Set02();
                    Alert doneAlert = new Alert(AlertType.INFORMATION, 
                         "Output written to temp.tex");
                    doneAlert.showAndWait();
                }
                else if (selected == "Sequences I") {
                    Sequences.Set01();
                    Alert doneAlert = new Alert(AlertType.INFORMATION, 
                         "Output written to temp.tex");
                    doneAlert.showAndWait();
                }
                else if (selected == "Quadratic Functions I") {
                    QuadraticFunctions.Set01();
                    Alert doneAlert = new Alert(AlertType.INFORMATION, 
                         "Output written to temp.tex");
                    doneAlert.showAndWait();
                }
                else if (selected == "Quadratic Equations I") {
                    QuadraticEqn.Set01();
                    Alert doneAlert = new Alert(AlertType.INFORMATION, 
                         "Output written to temp.tex");
                    doneAlert.showAndWait();
                }
                else if (selected == "Variations I") {
                    Variations.Set01();
                    Alert doneAlert = new Alert(AlertType.INFORMATION, 
                         "Output written to temp.tex");
                    doneAlert.showAndWait();
                }
                else if (selected == "Variations II") {
                    Variations.Set02();
                    Alert doneAlert = new Alert(AlertType.INFORMATION, 
                         "Output written to temp.tex");
                    doneAlert.showAndWait();
                }
                else {  
                    Alert unimplementedAlert = new Alert(AlertType.INFORMATION, 
                         "The module you have selected is unimplemented.");
                    unimplementedAlert.showAndWait();
                }
            }
        });

        ButtonBox.getChildren().addAll(QuitButton, OKButton);
        root.getChildren().add(ButtonBox);

        stage.setScene(scene);
        stage.show();
    }
}

