package com.example.rp5;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Arrays;


public class OkraskaPloshadi extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 800, 600);
        Button button = new Button("Press me.");
        button.setLayoutX(200);
        button.setLayoutY(200);
        Button button2=new Button("Return");
        button2.setLayoutX(80);
        button2.setLayoutY(80);
        button.setMinSize(100,100);
        button2.setMinSize(100,100);
        group.getChildren().add(button2);
        group.getChildren().add(button);
        boolean flag = false;
        int witchangle = 0;
        Buttonanglecoords buttonfirst = new Buttonanglecoords();
        Buttonanglecoords buttonsecond = new Buttonanglecoords();
        final double[] buttonCoords = new double[2];
        final double[] buttonCoords2 = new double[2];
        button.setStyle("-fx-border-color: #ff0000; -fx-border-width: 1px;");
        button2.setStyle("-fx-border-color: #ff0000; -fx-border-width: 1px;");
        button.setBackground(null);
        button2.setBackground(null);
        buttonfirst.setButtonangle(button.getLayoutX(), button.getLayoutY());
        System.out.println(Arrays.toString(buttonfirst.buttonangle1) + " " + Arrays.toString(buttonfirst.buttonangle2) + " " + Arrays.toString(buttonfirst.buttonangle3) + " " + Arrays.toString(buttonfirst.buttonangle4));
        buttonsecond.setButtonangle(button2.getLayoutX(), button2.getLayoutY());
        System.out.println(Arrays.toString(buttonsecond.buttonangle1) + " " + Arrays.toString(buttonsecond.buttonangle2) + " " + Arrays.toString(buttonsecond.buttonangle3) + " " + Arrays.toString(buttonsecond.buttonangle4));


        Rectangle oblast = new Rectangle();
        oblast.setFill(Color.RED);
        oblast.setVisible(false);
        group.getChildren().add(oblast);
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
            // System.out.println(Arrays.toString(buttonfirst.buttonangle1) + " " + Arrays.toString(buttonfirst.buttonangle2) + " " + Arrays.toString(buttonfirst.buttonangle3) + " " + Arrays.toString(buttonfirst.buttonangle4));
            if((buttonfirst.buttonangle1[0] - buttonsecond.buttonangle1[0]) < 100 && (buttonfirst.buttonangle1[0] - buttonsecond.buttonangle1[0]) > 0 &&(buttonfirst.buttonangle1[1] - buttonsecond.buttonangle1[1]) < 100 && (buttonfirst.buttonangle1[1] - buttonsecond.buttonangle1[1]) > 0) {
                System.out.println(buttonfirst.S(buttonsecond, 1));
                oblast.setVisible(true);
                oblast.setX(buttonfirst.buttonangle1[0]);
                oblast.setY(buttonfirst.buttonangle1[1]);
                oblast.setWidth(buttonsecond.buttonangle4[0] - buttonfirst.buttonangle1[0]);
                oblast.setHeight(buttonsecond.buttonangle4[1] - buttonfirst.buttonangle1[1]);
            } else if((buttonfirst.buttonangle2[0] - buttonsecond.buttonangle1[0]) < 100 && (buttonfirst.buttonangle2[0] - buttonsecond.buttonangle1[0]) > 0 &&(buttonfirst.buttonangle2[1] - buttonsecond.buttonangle1[1]) < 100 && (buttonfirst.buttonangle2[1] - buttonsecond.buttonangle1[1]) > 0) {
                System.out.println(buttonfirst.S(buttonsecond, 2));
                oblast.setVisible(true);
                oblast.setX(buttonsecond.buttonangle1[0]);
                oblast.setY(buttonfirst.buttonangle2[1]);
                oblast.setWidth(buttonfirst.buttonangle2[0] - buttonsecond.buttonangle1[0]);
                oblast.setHeight(buttonsecond.buttonangle3[1] - buttonfirst.buttonangle2[1]);
            } else if((buttonfirst.buttonangle3[0] - buttonsecond.buttonangle1[0]) < 100 && (buttonfirst.buttonangle3[0] - buttonsecond.buttonangle1[0]) > 0 &&(buttonfirst.buttonangle3[1] - buttonsecond.buttonangle1[1]) < 100 && (buttonfirst.buttonangle3[1] - buttonsecond.buttonangle1[1]) > 0) {
                System.out.println(buttonfirst.S(buttonsecond, 3));
                oblast.setVisible(true);
                oblast.setX(buttonfirst.buttonangle3[0]);
                oblast.setY(buttonsecond.buttonangle1[1]);
                oblast.setWidth(buttonsecond.buttonangle2[0] - buttonfirst.buttonangle3[0]);
                oblast.setHeight(buttonfirst.buttonangle3[1] - buttonsecond.buttonangle1[1]);
            } else
            if((buttonfirst.buttonangle4[0] - buttonsecond.buttonangle1[0]) < 100 && (buttonfirst.buttonangle4[0] - buttonsecond.buttonangle1[0]) > 0 &&(buttonfirst.buttonangle4[1] - buttonsecond.buttonangle1[1]) < 100 && (buttonfirst.buttonangle4[1] - buttonsecond.buttonangle1[1]) > 0) {
                System.out.println(buttonfirst.S(buttonsecond, 4));
                oblast.setVisible(true);
                oblast.setX(buttonsecond.buttonangle1[0]);
                oblast.setY(buttonsecond.buttonangle1[1]);
                oblast.setWidth(buttonfirst.buttonangle4[0] - buttonsecond.buttonangle1[0]);
                oblast.setHeight(buttonfirst.buttonangle4[1] - buttonsecond.buttonangle1[1]);
            } else {
                oblast.setVisible(false);
            }
            scene.setCursor(Cursor.CLOSED_HAND);

        });
        button2.setOnMouseDragged(mouseEvent -> {
            button2.setLayoutX(mouseEvent.getSceneX() - buttonCoords2[0]);
            button2.setLayoutY(mouseEvent.getSceneY() - buttonCoords2[1]);
            buttonsecond.setButtonangle(button2.getLayoutX(), button2.getLayoutY());
            //System.out.println(Arrays.toString(buttonsecond.buttonangle1) + " " + Arrays.toString(buttonsecond.buttonangle2) + " " + Arrays.toString(buttonsecond.buttonangle3) + " " + Arrays.toString(buttonsecond.buttonangle4));
                    if((buttonsecond.buttonangle1[0] - buttonfirst.buttonangle1[0]) < 100 && (buttonsecond.buttonangle1[0] - buttonfirst.buttonangle1[0]) > 0 &&(buttonsecond.buttonangle1[1] - buttonfirst.buttonangle1[1]) < 100 && (buttonsecond.buttonangle1[1] - buttonfirst.buttonangle1[1]) > 0) {
                        System.out.println(buttonsecond.S(buttonfirst, 1));
//                        oblast.setVisible(true);
//                        oblast.setX(buttonsecond.buttonangle1[0]);
//                        oblast.setY(buttonsecond.buttonangle1[1]);
//                        oblast.setWidth(buttonfirst.buttonangle4[0] - buttonsecond.buttonangle1[0]);
//                        oblast.setHeight(buttonfirst.buttonangle4[1] - buttonsecond.buttonangle1[1]);
//                    } else {
//                        oblast.setVisible(false);
                    }
                    if((buttonsecond.buttonangle2[0] - buttonfirst.buttonangle1[0]) < 100 && (buttonsecond.buttonangle2[0] - buttonfirst.buttonangle1[0]) > 0 &&(buttonsecond.buttonangle2[1] - buttonfirst.buttonangle1[1]) < 100 && (buttonsecond.buttonangle2[1] - buttonfirst.buttonangle1[1]) > 0) {
                        System.out.println(buttonsecond.S(buttonfirst, 2));
                        }
                    if((buttonsecond.buttonangle3[0] - buttonfirst.buttonangle1[0]) < 100 && (buttonsecond.buttonangle3[0] - buttonfirst.buttonangle1[0]) > 0 &&(buttonsecond.buttonangle3[1] - buttonfirst.buttonangle1[1]) < 100 && (buttonsecond.buttonangle3[1] - buttonfirst.buttonangle1[1]) > 0) {
                        System.out.println(buttonsecond.S(buttonfirst, 3));
                            }
                    if((buttonsecond.buttonangle4[0] - buttonfirst.buttonangle1[0]) < 100 && (buttonsecond.buttonangle4[0] - buttonfirst.buttonangle1[0]) > 0 &&(buttonsecond.buttonangle4[1] - buttonfirst.buttonangle1[1]) < 100 && (buttonsecond.buttonangle4[1] - buttonfirst.buttonangle1[1]) > 0) {
                        System.out.println(buttonsecond.S(buttonfirst, 4));
                    }
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