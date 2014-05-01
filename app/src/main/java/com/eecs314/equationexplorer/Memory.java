package com.eecs314.equationexplorer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Memory extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.memory, menu);
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

    public void openAMAT(View view) {
        Intent intent = new Intent(this, AMAT.class);
        startActivity(intent);
    }

    public void openCPUMemRW(View view) {
        Intent intent = new Intent(this, CPUMemRW.class);
        startActivity(intent);
    }

    public void openCPUMemWT(View view) {
        Intent intent = new Intent(this, CPUMemWT.class);
        startActivity(intent);
    }

    public void openCPIMem(View view) {
        Intent intent = new Intent(this, CPIMem.class);
        startActivity(intent);
    }

}
