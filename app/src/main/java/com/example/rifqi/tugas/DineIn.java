package com.example.rifqi.tugas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class DineIn extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final String TAG = DineIn.class.getSimpleName();
    private String mSpinnerLabel = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in);
        // Create the spinner.
        Spinner spinner = (Spinner) findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    public void showText(View view) {
        Toast.makeText(this,mSpinnerLabel+" Sudah Terpilih", Toast.LENGTH_SHORT).show();

    }
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
        mSpinnerLabel = adapterView.getItemAtPosition(pos).toString();
        showText(view);
    }
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG, "Nothing Selected");
    }
    public void onButtonClicked(View view) {
        Intent intent = new Intent(this, DaftarMenu.class);
        startActivity(intent);
    }
}
