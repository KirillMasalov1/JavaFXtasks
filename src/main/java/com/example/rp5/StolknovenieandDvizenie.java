package com.example.rp5;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Arrays;

public class StolknovenieandDvizenie extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 800, 600);
        Button button = new Button("Двигающая");
        button.setLayoutX(200);
        button.setLayoutY(200);
        Button button2 = new Button("Двигаемая");
        button2.setLayoutX(80);
        button2.setLayoutY(80);
        button.setMinSize(100, 100);
        button2.setMinSize(100, 100);
        group.getChildren().add(button2);
        group.getChildren().add(button);
        button.setStyle("-fx-border-color: #ff0000; -fx-border-width: 1px;");
        button2.setStyle("-fx-border-color: #ff0000; -fx-border-width: 1px;");
        button.setBackground(null);
        button2.setBackground(null);
        Buttonanglecoords buttonfirst = new Buttonanglecoords();
        Buttonanglecoords buttonsecond = new Buttonanglecoords();
        final double[] buttonCoords = new double[2];
        final double[] buttonCoords2 = new double[2];
        final double[] deltaold = {0, 0};
        final double[] deltanew = {0, 0};

        buttonfirst.setButtonangle(button.getLayoutX(), button.getLayoutY());
        System.out.println(Arrays.toString(buttonfirst.buttonangle1) + " " + Arrays.toString(buttonfirst.buttonangle2) + " " + Arrays.toString(buttonfirst.buttonangle3) + " " + Arrays.toString(buttonfirst.buttonangle4));
        buttonsecond.setButtonangle(button2.getLayoutX(), button2.getLayoutY());
        System.out.println(Arrays.toString(buttonsecond.buttonangle1) + " " + Arrays.toString(buttonsecond.buttonangle2) + " " + Arrays.toString(buttonsecond.buttonangle3) + " " + Arrays.toString(buttonsecond.buttonangle4));

        button.setOnMousePressed(mouseEvent -> {
            System.out.println("mouse clicked");
            button.setText("Done");
            System.out.println("X: " + mouseEvent.getSceneX());
            System.out.println("Y: " + mouseEvent.getSceneY());
            buttonCoords[0] = mouseEvent.getX();
            buttonCoords[1] = mouseEvent.getY();
            buttonfirst.setButtonangle(button.getLayoutX(), button.getLayoutY());
            System.out.println(Arrays.toString(buttonfirst.buttonangle1) + " " + Arrays.toString(buttonfirst.buttonangle2) + " " + Arrays.toString(buttonfirst.buttonangle3) + " " + Arrays.toString(buttonfirst.buttonangle4));
            scene.setCursor(Cursor.CLOSED_HAND);

        });
        button2.setOnMousePressed(mouseEvent -> {
            System.out.println("mouse clicked");
            button2.setText("Done");
            System.out.println("X: " + mouseEvent.getSceneX());
            System.out.println("Y: " + mouseEvent.getSceneY());
            buttonCoords2[0] = mouseEvent.getX();
            buttonCoords2[1] = mouseEvent.getY();
            buttonsecond.setButtonangle(button2.getLayoutX(), button2.getLayoutY());
            System.out.println(Arrays.toString(buttonsecond.buttonangle1) + " " + Arrays.toString(buttonsecond.buttonangle2) + " " + Arrays.toString(buttonsecond.buttonangle3) + " " + Arrays.toString(buttonsecond.buttonangle4));
            scene.setCursor(Cursor.CLOSED_HAND);

        });
        button.setOnMouseDragged(mouseEvent -> {
            button.setLayoutX(mouseEvent.getSceneX() - buttonCoords[0]);
            button.setLayoutY(mouseEvent.getSceneY() - buttonCoords[1]);
            buttonfirst.setButtonangle(button.getLayoutX(), button.getLayoutY());
            if(buttonfirst.isFlag(buttonsecond)) {
                System.out.println("Столкновение");
                buttonCoords2[0] = mouseEvent.getX();
                buttonCoords2[1] = mouseEvent.getY();
                System.out.println(buttonfirst.buttonangle1[0] - buttonsecond.buttonangle1[0]);
                System.out.println(buttonfirst.buttonangle1[1] - buttonsecond.buttonangle1[1]);
                deltanew[0] = buttonfirst.buttonangle1[0] - buttonsecond.buttonangle1[0];
                deltanew[1] = buttonfirst.buttonangle1[1] - buttonsecond.buttonangle1[1];
                if(deltaold[0] != deltanew[0] && deltaold[0] == 0) {
                    deltaold[0] = deltanew[0];
                }
                if(deltaold[1] != deltanew[1] && deltaold[1] == 0) {
                    deltaold[1] = deltanew[1];
                }
                button2.setLayoutX(mouseEvent.getSceneX() - buttonCoords2[0]  - deltaold[0]);
                button2.setLayoutY(mouseEvent.getSceneY() - buttonCoords2[1]  - deltaold[1]);
                buttonsecond.setButtonangle(button2.getLayoutX(), button2.getLayoutY());
            } else {
                deltaold[0] = 0;
                deltaold[1] = 0;
            }
            scene.setCursor(Cursor.CLOSED_HAND);

        });
        button2.setOnMouseDragged(mouseEvent -> {
            button2.setLayoutX(mouseEvent.getSceneX() - buttonCoords2[0]);
            button2.setLayoutY(mouseEvent.getSceneY() - buttonCoords2[1]);
            buttonsecond.setButtonangle(button2.getLayoutX(), button2.getLayoutY());
            scene.setCursor(Cursor.CLOSED_HAND);
        });
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}
