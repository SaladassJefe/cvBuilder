package com.example.cvbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnProfile).setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ProfileActivity.class)));
        findViewById(R.id.btnPersonalDetails).setOnClickListener(view -> startActivity(new Intent(MainActivity.this, PersonalDetailsActivity.class)));
        findViewById(R.id.btnEducation).setOnClickListener(view -> startActivity(new Intent(MainActivity.this, EducationActivity.class)));
        findViewById(R.id.btnExperience).setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ExperienceActivity.class)));
        findViewById(R.id.btnCertifications).setOnClickListener(view -> startActivity(new Intent(MainActivity.this, CertificationsActivity.class)));
        findViewById(R.id.btnReferences).setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ReferencesActivity.class)));
        findViewById(R.id.btnPreviewCV).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CVPreviewActivity.class);
            startActivity(intent);
        });
    }
}
