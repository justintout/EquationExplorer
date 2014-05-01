package com.eecs314.equationexplorer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by JustinTout on 5/1/14.
 * T improved = (T affected/improvement factor) + T unaffected

 */
public class ImprovedTime extends ActionBarActivity implements Equation {

    private double[] values = new double[3];
    private String toDisplay = "Improved Time = (Affected Time / Improvement Factor) + Unaffected Time";

    @Override
    public double calculate() {
        return (values[0] / values[1]) + values[2];
    }

    @Override
    public String getDisplayString() {
        return toDisplay;
    }

    @Override
    public void setVariables(double[] input) {
        for(int i = 0; i < values.length; i++){
            values[i] = input[i];
        }
    }

    public String toString(){
        return "(" + values[0] + "/" + values[1] + ") + " + values[2];
    }

    public double[] getVariablesInApp() {
        double toReturn[] = {0.0, 0.0, 0.0};
        EditText temp = (EditText)findViewById(R.id.timproved0);
        if (temp.getText().toString().matches("")) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return toReturn;
        } else
            toReturn[0] = Double.parseDouble(temp.getText().toString());
        temp = (EditText)findViewById(R.id.timproved1);
        if (temp.getText().toString().matches("")) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return toReturn;
        } else
            toReturn[1] = Double.parseDouble(temp.getText().toString());
        temp = (EditText)findViewById(R.id.timproved2);
        if (temp.getText().toString().matches("")) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return toReturn;
        } else
            toReturn[1] = Double.parseDouble(temp.getText().toString());
        return toReturn;
    }

    public void updateAndCalculate(View view) {
        setVariables(getVariablesInApp());
        TextView variableString = (TextView)findViewById(R.id.timprovedvariablestring);
        variableString.setText(toString());
        double result =  calculate();
        TextView tv = (TextView)findViewById(R.id.timprovedtimeresult);
        tv.setText(String.valueOf(result));
    }

}
