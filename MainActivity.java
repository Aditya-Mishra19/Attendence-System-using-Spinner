package com.example.spinnerprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //complier ko batao kya use kiya ha
    EditText name, rollnNum;
    Button submit, reset;
    Spinner attendenceStatus;
    String selectedResponse;
    TextView result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // values assign krenge
        name = findViewById(R.id.uName);
        rollnNum = findViewById(R.id.rNum);
        attendenceStatus = findViewById(R.id.aStatus);
        result = findViewById(R.id.showResponse);
        submit = findViewById(R.id.sBtn);
        reset = findViewById(R.id.rBtn);

        //Adapter set krenge
        ArrayAdapter<String> fetchData = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                                                            getResources().getStringArray(R.array.status));
        fetchData.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        attendenceStatus.setAdapter(fetchData);

        // selection process
        attendenceStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedResponse = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // kaam assign kro
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String response = "Name: " + name.getText().toString() +
                        "\nRoll Number: " + rollnNum.getText().toString() +
                        "\nAttendance Status: " + selectedResponse;
                result.setText(response);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                rollnNum.setText("");
                result.setText("");
            }
        });
    }
}
