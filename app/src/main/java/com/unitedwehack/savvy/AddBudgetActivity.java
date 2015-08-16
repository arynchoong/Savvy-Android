package com.unitedwehack.savvy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class AddBudgetActivity extends AppCompatActivity {
    AutoCompleteTextView mAutoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budget);

        // Get a reference to the AutoCompleteTextView in the layout
        mAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autocomplete_category);
        // Get the string array
        String[] categories = getResources().getStringArray(R.array.categories_array);
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        mAutoCompleteTextView.setAdapter(adapter);

        mAutoCompleteTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                autoCompleteShowAll((AutoCompleteTextView) v);
            }
        });
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

    private void autoCompleteShowAll(AutoCompleteTextView autoCompleteTextView){
        autoCompleteTextView.showDropDown();
    }

    // onClick of next button
    public void startVisualisationAcitivty(View view) {
        Intent intent = new Intent(this, VisualisationActivity.class);
        startActivity(intent);
    }
}
