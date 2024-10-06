package com.example.rp5;


import javafx.scene.control.Button;

import static java.lang.Math.abs;

public class Buttonanglecoords {

    final double[] buttonangle1 = new double[2];
    final double[] buttonangle2 = new double[2];
    final double[] buttonangle3 = new double[2];
    final double[] buttonangle4 = new double[2];



    public Buttonanglecoords() {}

    public void setButtonangle(double x, double y) {
        this.buttonangle1[0] = x;
        this.buttonangle1[1] = y;
        this.buttonangle2[0] = x+100;
        this.buttonangle2[1] = y;
        this.buttonangle3[0] = x;
        this.buttonangle3[1] = y+100;
        this.buttonangle4[0] = x+100;
        this.buttonangle4[1] = y+100;

    }
    public double S(Buttonanglecoords a, int angle) {
        if(angle == 1) {
            return (100 - (this.buttonangle1[0] - a.buttonangle1[0])) * (100 - (this.buttonangle1[1] - a.buttonangle1[1]));
        } else if(angle == 2) {
            return (100 - (a.buttonangle2[0] - this.buttonangle2[0])) * (100 - (this.buttonangle2[1] - a.buttonangle2[1]));
        } else if(angle == 3) {
            return (100 - (this.buttonangle3[0] - a.buttonangle3[0])) * (100 - (a.buttonangle3[1] - this.buttonangle3[1]));
        } else {
            return (100 - (a.buttonangle4[0] - this.buttonangle4[0])) * (100 - (a.buttonangle4[1] - this.buttonangle4[1]));
        }
    }
    // && this.buttonangle1[0] > a.buttonangle1[0]
    public boolean isFlag(Buttonanglecoords a) {
        //Столкновение было
        if (this.buttonangle1[0] < a.buttonangle2[0] && this.buttonangle1[0] > a.buttonangle1[0] && this.buttonangle1[1] > a.buttonangle1[1] && this.buttonangle1[1] < a.buttonangle3[1]) {
            return true;

        } else if (this.buttonangle2[0] > a.buttonangle1[0] && this.buttonangle2[0] < a.buttonangle2[0] && this.buttonangle2[1] > a.buttonangle1[1] && this.buttonangle2[1] < a.buttonangle3[1]) {
            return true;

        } else if(this.buttonangle3[0] > a.buttonangle1[0] && this.buttonangle3[0] < a.buttonangle2[0] && this.buttonangle3[1] > a.buttonangle1[1] && this.buttonangle3[1] < a.buttonangle3[1]) {
            return true;
        } else if(this.buttonangle4[0] > a.buttonangle1[0] && this.buttonangle4[0] < a.buttonangle2[0] && this.buttonangle4[1] > a.buttonangle1[1] && this.buttonangle4[1] < a.buttonangle3[1]) {
            return true;
        }
        //Столкновение не случилось
        else {
            return false;
        }
    }
}
// && this.buttonangle1[1] >= a.buttonangle2[1] && this.buttonangle1[1] <= a.buttonangle4[1]) this.buttonangle1[0] == a.buttonangle2[0]
// && this.buttonangle1[0] >= a.buttonangle1[0] && this.buttonangle1[0] <= a.buttonangle2[0]) this.buttonangle1[1] == a.buttonangle3[1]