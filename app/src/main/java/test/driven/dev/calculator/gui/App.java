/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package test.driven.dev.calculator.gui;
import java.net.URL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class App extends Application {
        private TextField display;
        private Calc calc = new Calc();
        private GridPane gridPane = new GridPane();

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            // Create the text field
            display = new TextField();
            display.getStyleClass().add("display");
            display.setEditable(true);
            display.setPrefSize(500, 500);

            // Create the buttons
            Button button1 = new Button("1");
            Button button2 = new Button("2");
            Button button3 = new Button("3");
            Button button4 = new Button("4");
            Button button5 = new Button("5");
            Button button6 = new Button("6");
            Button button7 = new Button("7");
            Button button8 = new Button("8");
            Button button9 = new Button("9");
            Button button0 = new Button("0");
            Button buttonPlus = new Button("+");
            Button buttonMinus = new Button("-");
            Button buttonDivide = new Button("/");
            Button buttonMultiply = new Button("*");
            Button buttonSin = new Button("sin");
            Button buttonCos = new Button("cos");
            Button buttonTan = new Button("tan");
            Button buttonLog = new Button("log");
            Button buttonSqrt = new Button("sqrt");
            Button buttonMod = new Button("%");
            Button buttonPower = new Button("^");
            Button parathesis1 = new Button("(");
            Button parathesis2 = new Button(")");
            Button buttonEquals = new Button("=");

            button1.setOnAction(e -> {
                display.setText(display.getText() + "1");
            });
            button2.setOnAction(e -> {
                display.setText(display.getText() + "2");
            });
            button3.setOnAction(e -> {
                display.setText(display.getText() + "3");
            });
            button4.setOnAction(e -> {
                display.setText(display.getText() + "4");
            });
            button5.setOnAction(e -> {
                display.setText(display.getText() + "5");
            });
            button6.setOnAction(e -> {
                display.setText(display.getText() + "6");
            });
            button7.setOnAction(e -> {
                display.setText(display.getText() + "7");
            });
            button8.setOnAction(e -> {
                display.setText(display.getText() + "8");
            });
            button9.setOnAction(e -> {
                display.setText(display.getText() + "9");
            });
            button0.setOnAction(e -> {
                display.setText(display.getText() + "0");
            });
            buttonPlus.setOnAction(e -> {
                display.setText(display.getText() + " + ");
            });
            buttonMinus.setOnAction(e -> {
                display.setText(display.getText() + " - ");
            });
            buttonDivide.setOnAction(e -> {
                display.setText(display.getText() + " / ");
            });
            buttonMultiply.setOnAction(e -> {
                display.setText(display.getText() + " * ");
            });
            buttonSin.setOnAction(e -> {
                display.setText(display.getText() + "sin ");
            });
            buttonCos.setOnAction(e -> {
                display.setText(display.getText() + "cos ");
            });
            buttonTan.setOnAction(e -> {
                display.setText(display.getText() + "tan ");
            });
            buttonLog.setOnAction(e -> {
                display.setText(display.getText() + "log ");
            });
            buttonSqrt.setOnAction(e -> {
                display.setText(display.getText() + "sqrt ");
            });
            buttonMod.setOnAction(e -> {
                display.setText(display.getText() + " % ");
            });
            buttonPower.setOnAction(e -> {
                display.setText(display.getText() + " ^ ");
            });
            parathesis1.setOnAction(e -> {
                display.setText(display.getText() + "( ");
            });
            parathesis2.setOnAction(e -> {
                display.setText(display.getText() + " )");
            });
            buttonEquals.setOnAction(e -> {
                display.setText(calc.processInput(display.getText()) + "");
            });
            button1.setPrefSize(150, 150);
            button2.setPrefSize(150, 150);
            button3.setPrefSize(150, 150);
            button4.setPrefSize(150, 150);
            button5.setPrefSize(150, 150);
            button6.setPrefSize(150, 150);
            button7.setPrefSize(150, 150);
            button8.setPrefSize(150, 150);
            button9.setPrefSize(150, 150);
            button0.setPrefSize(150, 150);
            buttonPlus.setPrefSize(150, 150);
            buttonMinus.setPrefSize(150, 150);
            buttonDivide.setPrefSize(150, 150);
            buttonMultiply.setPrefSize(150, 150);
            buttonSin.setPrefSize(150, 150);
            buttonCos.setPrefSize(150, 150);
            buttonTan.setPrefSize(150, 150);
            buttonLog.setPrefSize(150, 150);
            buttonSqrt.setPrefSize(150, 150);
            buttonMod.setPrefSize(150, 150);
            buttonPower.setPrefSize(150, 150);
            parathesis1.setPrefSize(150, 150);
            parathesis2.setPrefSize(150, 150);
            buttonEquals.setPrefSize(150, 150);
            
            button1.setPrefSize(100, 100);
            button2.setPrefSize(100, 100);
            button3.setPrefSize(100, 100);
            button4.setPrefSize(100, 100);
            button5.setPrefSize(100, 100);
            button6.setPrefSize(100, 100);
            button7.setPrefSize(100, 100);
            button8.setPrefSize(100, 100);
            button9.setPrefSize(100, 100);
            button0.setPrefSize(100, 100);
            buttonPlus.setPrefSize(100, 100);
            buttonMinus.setPrefSize(100, 100);
            buttonDivide.setPrefSize(100, 100);
            buttonMultiply.setPrefSize(100, 100);
            buttonSin.setPrefSize(100, 100);
            buttonCos.setPrefSize(100, 100);
            buttonTan.setPrefSize(100, 100);
            buttonLog.setPrefSize(100, 100);
            buttonSqrt.setPrefSize(100, 100);
            buttonMod.setPrefSize(100, 100);
            buttonPower.setPrefSize(100, 100);
            parathesis1.setPrefSize(100, 100);
            parathesis2.setPrefSize(100, 100);
            buttonEquals.setPrefSize(100, 100);

            // Add buttons to the grid pane
            gridPane.add(button1, 0, 0);
            gridPane.add(button2, 1, 0);
            gridPane.add(button3, 2, 0);
            gridPane.add(button4, 0, 1);
            gridPane.add(button5, 1, 1);
            gridPane.add(button6, 2, 1);
            gridPane.add(button7, 0, 2);
            gridPane.add(button8, 1, 2);
            gridPane.add(button9, 2, 2);
            gridPane.add(button0, 2, 3); 
            gridPane.add(buttonPlus, 3, 0);
            gridPane.add(buttonMinus, 3, 1);
            gridPane.add(buttonDivide, 3, 2);
            gridPane.add(buttonMultiply, 3, 3);
            gridPane.add(buttonSin, 0, 4);
            gridPane.add(buttonCos, 1, 4);
            gridPane.add(buttonTan, 2, 4);
            gridPane.add(buttonLog, 3, 4);
            gridPane.add(buttonMod, 0, 3);
            gridPane.add(buttonPower, 1, 3);
            gridPane.add(parathesis1, 0, 5);
            gridPane.add(parathesis2, 1, 5);
            gridPane.add(buttonSqrt, 2, 5);
            gridPane.add(buttonEquals, 3, 5);

            //set all buttons to the same style using the style.css file
            button1.getStyleClass().add("button");
            button2.getStyleClass().add("button");
            button3.getStyleClass().add("button");
            button4.getStyleClass().add("button");
            button5.getStyleClass().add("button");
            button6.getStyleClass().add("button");
            button7.getStyleClass().add("button");
            button8.getStyleClass().add("button");
            button9.getStyleClass().add("button");
            button0.getStyleClass().add("button");
            buttonPlus.getStyleClass().add("button");
            buttonMinus.getStyleClass().add("button");
            buttonDivide.getStyleClass().add("button");
            buttonMultiply.getStyleClass().add("button");
            buttonSin.getStyleClass().add("button");
            buttonCos.getStyleClass().add("button");
            buttonTan.getStyleClass().add("button");
            buttonLog.getStyleClass().add("button");
            buttonSqrt.getStyleClass().add("button");
            buttonMod.getStyleClass().add("button");
            buttonPower.getStyleClass().add("button");
            parathesis1.getStyleClass().add("button");
            parathesis2.getStyleClass().add("button");
            buttonEquals.getStyleClass().add("button");


            // Create the main layout
            VBox vbox = new VBox();


            vbox.getChildren().addAll(display, gridPane);
            gridPane.getStyleClass().add("div");
            gridPane.getStyleClass().add("calcDisplay");

            // Create the scene
            Scene scene = new Scene(vbox, 400, 800);

            // Set the scene and show the stage
            URL styleURL = getClass().getResource("/style.css");
		    String stylesheet = styleURL.toExternalForm();
		    scene.getStylesheets().add(stylesheet);
            primaryStage.setTitle("TI 84-AD edition");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }