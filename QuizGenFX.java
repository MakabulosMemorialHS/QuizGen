/* ******************************************************************
 * QuizGenFX.java
 *
 * Program to generate High School Mathematics Drills.
 *
 * $Id$
 *
 * $Log$
 *
 * *****************************************************************/
import java.lang.*;
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.text.*;

public class QuizGenFX extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    @Override public void start(Stage stage) {
        stage.setTitle("Quiz Generator");

        VBox root = new VBox(12);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 120);

        HBox hLayout = new HBox(12);
        hLayout.setAlignment(Pos.CENTER);


        Text titleText = new Text("QuizGen: Quiz Generator");
        titleText.setFont(Font.font ("Times New Roman", 20));
        root.getChildren().add(titleText);

        ChoiceBox qSelect = new ChoiceBox();

        qSelect.getItems().addAll("Quadratic Equations I", "Quadratic Equations II", "Rational Equations I", "Rational Equations II");
       
        hLayout.getChildren().addAll(new Text("Select Quiz"), qSelect);


        root.getChildren().add(hLayout);

        Button OKButton = new Button("   OK   ");

        root.getChildren().add(OKButton);

        stage.setScene(scene);
        stage.show();
    }
}

