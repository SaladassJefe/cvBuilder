package com.example.cvbuilder;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class EducationActivity extends AppCompatActivity {
    private EditText etDegree, etInstitute;
    private Spinner spYear;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        etDegree = findViewById(R.id.etDegree);
        etInstitute = findViewById(R.id.etInstitute);
        spYear = findViewById(R.id.spYear);

        sharedPreferences = getSharedPreferences("CVData", MODE_PRIVATE);

        // Load existing data
        etDegree.setText(sharedPreferences.getString("degree", ""));
        etInstitute.setText(sharedPreferences.getString("institute", ""));

        String[] years = {"2025", "2024", "2023", "2022", "2021", "2020"};
        spYear.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, years));

        Button btnSave = findViewById(R.id.btnSave);
        Button btnCancel = findViewById(R.id.btnCancel);

        btnSave.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("degree", etDegree.getText().toString());
            editor.putString("institute", etInstitute.getText().toString());
            editor.putString("year", spYear.getSelectedItem().toString());
            editor.apply();

            finish();
        });

        btnCancel.setOnClickListener(v -> finish());
    }
}
