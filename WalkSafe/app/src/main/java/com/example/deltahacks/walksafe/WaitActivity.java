package com.example.deltahacks.walksafe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class WaitActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wait, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void homeSafe(View view) {
        Intent intent = getIntent();
        Intent nextIntent = new Intent(this, MainActivity.class);
        startActivity(nextIntent);
    }

    public void addMoreTime(View view){
        /**
         * call when user selects add more time default 5 minutes
         */
        Intent intent = getIntent();
        Intent nextIntent = new Intent(this, JourneyActivity.class);
        startActivity(nextIntent);
    }
}
