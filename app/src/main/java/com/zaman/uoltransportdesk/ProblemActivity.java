package com.zaman.uoltransportdesk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProblemActivity extends AppCompatActivity {

    private EditText etPhone;
    private EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem);

        TextView tvGreeting = findViewById(R.id.tvGreeting);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        Button btnCallDriver = findViewById(R.id.btnCallDriver);
        Button btnSendEmail = findViewById(R.id.btnSendEmail);

        // Step 2: read the name sent from MainActivity; use "Student" if none was received
        String name = getIntent().getStringExtra(MainActivity.KEY_NAME);
        if (name == null || name.trim().isEmpty()) {
            name = "Student";
        }
        tvGreeting.setText("Hello, " + name + "! Tell us what went wrong.");

        // Step 3: accept only 11 digits starting with 03, then open the dialer
        btnCallDriver.setOnClickListener(v -> {
            String number = etPhone.getText().toString().trim();

            if (!number.matches("03\\d{9}")) {
                etPhone.setError("Enter 11 digits starting with 03");
                etPhone.requestFocus();
                return;
            }

            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            MainActivity.openIntent(ProblemActivity.this, intent);
        });

        // Step 4: accept only a valid email address, then open an email app
        btnSendEmail.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();

            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("Enter a valid email address");
                etEmail.requestFocus();
                return;
            }

            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
            MainActivity.openIntent(ProblemActivity.this, intent);
        });
    }
}
