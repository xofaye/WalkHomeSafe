package com.example.deltahacks.walksafe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class JourneyActivity extends ActionBarActivity {

    public View v;
    private User jane = new User();
    final Runnable checkAgainSignal = new Runnable() {
        @Override
        public void run() {
            checkAgain(v);
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey);
        Intent intent = getIntent();
        try {
            int journeyNum = (int) intent.getSerializableExtra("journeyKey");
            jane.start(journeyNum, checkAgainSignal);
        } catch (Exception ex) {
            jane.start(3, checkAgainSignal);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_journey, menu);
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


    public void homeSafe(View view){
        jane.gotHome(checkAgainSignal);
        Intent intent = getIntent();
        Intent nextIntent = new Intent(this, MainActivity.class);
        startActivity(nextIntent);
    }

    public void helpMe(View view){
        jane.startPanic(checkAgainSignal);
        Intent intent = getIntent();
        Intent nextIntent = new Intent(this, HelpActivity.class);
        startActivity(nextIntent);
    }

    public void checkAgain(View view){
        Intent intent = getIntent();
        Intent nextIntent = new Intent(this, WaitActivity.class);
        startActivity(nextIntent);
    }

}
