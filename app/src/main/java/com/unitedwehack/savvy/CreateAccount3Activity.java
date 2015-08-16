package com.unitedwehack.savvy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class CreateAccount3Activity extends AppCompatActivity {
    private Spinner mSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount3);

        // Set up share among drop down spinner
        mSpinner = (Spinner)findViewById(R.id.spinnerIncome);
        String[] shareItems = getResources().getStringArray(R.array.income_array);
        ArrayAdapter mShareAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, shareItems);
        mSpinner.setAdapter(mShareAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    // onClick of next button
    public void startNextAcitivty(View view) {
        Intent intent = new Intent(this, GoalsActivity.class);
        startActivity(intent);
    }
}
