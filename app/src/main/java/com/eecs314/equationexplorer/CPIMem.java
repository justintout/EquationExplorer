package com.eecs314.equationexplorer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CPIMem extends ActionBarActivity implements Equation {

    private double[] values = new double[4];
    private String toDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpimem);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cpimem, menu);
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
        return values[0] + (values[1] * values[2] * values[3]);
    }

    @Override
    public String getDisplayString() {
        return toDisplay;
    }

    @Override
    public void setVariables(double[] input) {
        for(int i = 0; i < 4; i++){
            values[i] = input[i];
        }
    }

    public String toString(){
        return values[0] + " + (" + values[1] + " * " + values[2] + " * " + values[3] + ")";
    }

    public double[] getVariablesInApp() {
        double toReturn[] = {0.0, 0.0, 0.0, 0.0};
        EditText temp = (EditText)findViewById(R.id.cpimem0);
        if (temp.getText().toString().matches("")) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return toReturn;
        } else toReturn[0] = Double.parseDouble(temp.getText().toString());
        temp = (EditText)findViewById(R.id.cpimem1);
        if (temp.getText().toString().matches("")) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return toReturn;
        } else toReturn[1] = Double.parseDouble(temp.getText().toString());
        temp = (EditText)findViewById(R.id.cpimem2);
        if (temp.getText().toString().matches("")) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return toReturn;
        } else toReturn[2] = Double.parseDouble(temp.getText().toString());
        temp = (EditText)findViewById(R.id.cpimem3);
        if (temp.getText().toString().matches("")) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return toReturn;
        } else toReturn[3] = Double.parseDouble(temp.getText().toString());
        return toReturn;
    }

    public void updateAndCalculate(View view) {
        setVariables(getVariablesInApp());
        TextView variableString = (TextView)findViewById(R.id.cpimemvariablestring);
        variableString.setText(toString());
        double result =  calculate();
        TextView tv = (TextView)findViewById(R.id.cpimemresult);
        tv.setText(String.valueOf(result));
    }
}
