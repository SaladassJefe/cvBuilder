package com.example.cvbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ReferencesActivity extends AppCompatActivity {
    private EditText etRefName, etRefContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references);

        etRefName = findViewById(R.id.etRefName);
        etRefContact = findViewById(R.id.etRefContact);

        Button btnSave = findViewById(R.id.btnSave);
        Button btnCancel = findViewById(R.id.btnCancel);

        btnSave.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("refName", etRefName.getText().toString());
            intent.putExtra("refContact", etRefContact.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });

        btnCancel.setOnClickListener(v -> finish());
    }
}
