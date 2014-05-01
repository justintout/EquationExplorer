package com.eecs314.equationexplorer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Performance extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.performance, menu);
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

    void openImprovedTime(View view) {
        Intent intent = new Intent(this, ImprovedTime.class);
        startActivity(intent);
    }

    void openOverallSpeedup(View view) {
        Intent intent = new Intent(this, OverallSpeedup.class);
        startActivity(intent);
    }

    void openRelativePerformance(View view) {
        Intent intent = new Intent(this, RelativePerformance.class);
        startActivity(intent);
    }

}
