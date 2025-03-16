package com.example.cvbuilder;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ExperienceActivity extends AppCompatActivity {
    private EditText etCompanyName, etJobTitle, etWorkDuration;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        etCompanyName = findViewById(R.id.etCompanyName);
        etJobTitle = findViewById(R.id.etJobTitle);
        etWorkDuration = findViewById(R.id.etWorkDuration);

        sharedPreferences = getSharedPreferences("CVData", MODE_PRIVATE);

        Button btnSave = findViewById(R.id.btnSave);
        Button btnCancel = findViewById(R.id.btnCancel);

        btnSave.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("company", etCompanyName.getText().toString());
            editor.putString("jobTitle", etJobTitle.getText().toString());
            editor.putString("workDuration", etWorkDuration.getText().toString());
            editor.apply();

            finish();
        });

        btnCancel.setOnClickListener(v -> finish());
    }
}
