package com.example.cvbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CertificationsActivity extends AppCompatActivity {
    private EditText etCertName, etIssuedBy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certifications);

        etCertName = findViewById(R.id.etCertName);
        etIssuedBy = findViewById(R.id.etIssuedBy);

        Button btnSave = findViewById(R.id.btnSave);
        Button btnCancel = findViewById(R.id.btnCancel);

        btnSave.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("certName", etCertName.getText().toString());
            intent.putExtra("issuedBy", etIssuedBy.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });

        btnCancel.setOnClickListener(v -> finish());
    }
}
