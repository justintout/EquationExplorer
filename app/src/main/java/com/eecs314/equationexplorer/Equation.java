package com.eecs314.equationexplorer;

/**
 * Created by JustinTout on 4/30/14.
 */
public interface Equation {

    String getDisplayString();
    String toString();
    void setVariables(double[] values);
    double calculate();
}
