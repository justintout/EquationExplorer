package com.eecs314.equationexplorer;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CPUMemWT extends ActionBarActivity implements Equation {

    private double[] values = new double[5];
    private String toDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpumemwt);
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.amat, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public double calculate() {
        return values[0] * (values[1] + values[2] * values[3]) * values[4];
    }

    @Override
    public String getDisplayString() {
        return toDisplay;
    }

    @Override
    public void setVariables(double[] input) {
        for(int i = 0; i < 5; i++){
            values[i] = input[i];
        }
    }

    public String toString(){
        return values[0] + " * (" + values[1] + " + " + values[2] + " * " + values[3] + ") * " + values[4];
    }

    public double[] getVariablesInApp() {
        double toReturn[] = {0.0, 0.0, 0.0, 0.0, 0.0};
        EditText temp = (EditText)findViewById(R.id.cpumemwt0);
        if (temp.getText().toString().matches("")) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return toReturn;
        } else toReturn[0] = Double.parseDouble(temp.getText().toString());
        temp = (EditText)findViewById(R.id.cpumemwt1);
        if (temp.getText().toString().matches("")) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return toReturn;
        } else toReturn[1] = Double.parseDouble(temp.getText().toString());
        temp = (EditText)findViewById(R.id.cpumemwt2);
        if (temp.getText().toString().matches("")) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return toReturn;
        } else
            toReturn[2] = Double.parseDouble(temp.getText().toString());
        temp = (EditText)findViewById(R.id.cpumemwt3);
        if (temp.getText().toString().matches("")) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return toReturn;
        } else
            toReturn[3] = Double.parseDouble(temp.getText().toString());
        temp = (EditText)findViewById(R.id.cpumemwt4);
        if (temp.getText().toString().matches("")) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return toReturn;
        } else
            toReturn[4] = Double.parseDouble(temp.getText().toString());
        return toReturn;
    }

    public void updateAndCalculate(View view) {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        setVariables(getVariablesInApp());
        TextView variableString = (TextView)findViewById(R.id.cpumemwtvariablestring);
        variableString.setText(toString());
        double result =  calculate();
        TextView tv = (TextView)findViewById(R.id.cpumemwtresult);
        tv.setText(String.valueOf(result));
    }
}

