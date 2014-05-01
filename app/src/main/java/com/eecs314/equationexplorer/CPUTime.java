package com.eecs314.equationexplorer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CPUTime extends ActionBarActivity implements Equation {

    private double[] values = new double[3];
    private String toDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cputime);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cputime, menu);
        return true;
    }

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
        return values[0] * values[1] * values[2];
    }

    @Override
    public String getDisplayString() {
        return toDisplay;
    }

    @Override
    public void setVariables(double[] input) {
        for(int i = 0; i < 3; i++){
            values[i] = input[i];
        }
    }

    public String toString(){
        return values[0] + " * " + values[1] + " * " + values[2];
    }

    public double[] getVariablesInApp() {
        double toReturn[] = new double[3];
        EditText temp = (EditText)findViewById(R.id.cputime0);
        toReturn[0] = Double.parseDouble(temp.getText().toString());
        System.out.println(toReturn[0]);
        temp = (EditText)findViewById(R.id.cputime1);
        toReturn[1] = Double.parseDouble(temp.getText().toString());
        temp = (EditText)findViewById(R.id.cputime2);
        toReturn[2] = Double.parseDouble(temp.getText().toString());
        System.out.println(toReturn[0] + ", " + toReturn[1] + ", " + toReturn[2]);
        return toReturn;
    }

    public void updateAndCalculate(View view) {
        setVariables(getVariablesInApp());
        TextView variableString = (TextView)findViewById(R.id.cpuvariablestring);
        variableString.setText(toString());
        double result =  calculate();
        TextView tv = (TextView)findViewById(R.id.cputimeresult);
        tv.setText(String.valueOf(result));
    }
}

