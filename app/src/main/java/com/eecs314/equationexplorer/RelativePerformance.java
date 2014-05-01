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
 * Relative Performance = performance x / performance y = exec time y/exec time x = n (x is n time faster)

 */
public class RelativePerformance extends ActionBarActivity implements Equation {

    private double[] values = new double[2];
    private String toDisplay = "Relative Performance = Execution Time y / Execution Time x";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativeperformance);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.relative_performance, menu);
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
        return values[0]/values[1];
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
        return values[0] + "/" + values[1];
    }

    public double[] getVariablesInApp() {
        double toReturn[] = {0.0, 0.0};
        EditText temp = (EditText)findViewById(R.id.performance0);
        if (temp.getText().toString().matches("")) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return toReturn;
        } else
            toReturn[0] = Double.parseDouble(temp.getText().toString());
        temp = (EditText)findViewById(R.id.performance1);
        if (temp.getText().toString().matches("")) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return toReturn;
        } else
            toReturn[1] = Double.parseDouble(temp.getText().toString());
        return toReturn;
    }

    public void updateAndCalculate(View view) {
        setVariables(getVariablesInApp());
        TextView variableString = (TextView)findViewById(R.id.performancevariablestring);
        variableString.setText(toString());
        double result =  calculate();
        TextView tv = (TextView)findViewById(R.id.performancetimeresult);
        tv.setText(String.valueOf(result));
    }

}
