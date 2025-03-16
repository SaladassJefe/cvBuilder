package com.example.cvbuilder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CVPreviewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvpreview);

        TextView tvCV = findViewById(R.id.tvCV);
        Button btnShare = findViewById(R.id.btnShare);

        SharedPreferences sharedPreferences = getSharedPreferences("CVData", MODE_PRIVATE);

        // Retrieve stored data
        String name = sharedPreferences.getString("name", "N/A");
        String email = sharedPreferences.getString("email", "N/A");
        String phone = sharedPreferences.getString("phone", "N/A");
        String address = sharedPreferences.getString("address", "N/A");
        String degree = sharedPreferences.getString("degree", "N/A");
        String institute = sharedPreferences.getString("institute", "N/A");
        String year = sharedPreferences.getString("year", "N/A");
        String company = sharedPreferences.getString("company", "N/A");
        String jobTitle = sharedPreferences.getString("jobTitle", "N/A");
        String workDuration = sharedPreferences.getString("workDuration", "N/A");

        String cvText = "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone + "\nAddress: " + address +
                "\nDegree: " + degree + "\nInstitute: " + institute + "\nYear: " + year +
                "\nCompany: " + company + "\nJob Title: " + jobTitle + "\nWork Duration: " + workDuration;

        tvCV.setText(cvText);

        btnShare.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, cvText);
            startActivity(Intent.createChooser(shareIntent, "Share CV via"));
        });
    }
}
