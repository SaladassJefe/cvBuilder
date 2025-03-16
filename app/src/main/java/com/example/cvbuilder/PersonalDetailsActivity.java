package com.example.cvbuilder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class PersonalDetailsActivity extends AppCompatActivity {
    private EditText etName, etEmail, etPhone, etAddress;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);

        sharedPreferences = getSharedPreferences("CVData", MODE_PRIVATE);

        // Load existing data
        etName.setText(sharedPreferences.getString("name", ""));
        etEmail.setText(sharedPreferences.getString("email", ""));
        etPhone.setText(sharedPreferences.getString("phone", ""));
        etAddress.setText(sharedPreferences.getString("address", ""));

        Button btnSave = findViewById(R.id.btnSave);
        Button btnCancel = findViewById(R.id.btnCancel);

        btnSave.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name", etName.getText().toString());
            editor.putString("email", etEmail.getText().toString());
            editor.putString("phone", etPhone.getText().toString());
            editor.putString("address", etAddress.getText().toString());
            editor.apply();

            finish(); // Return to MainActivity
        });

        btnCancel.setOnClickListener(v -> finish());
    }
}
