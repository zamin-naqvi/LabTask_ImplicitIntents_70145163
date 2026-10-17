package com.zaman.uoltransportdesk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Key used to send the student's name to ProblemActivity
    public static final String KEY_NAME = "com.zaman.uoltransportdesk.KEY_NAME";

    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the views from activity_main.xml
        etName = findViewById(R.id.etName);
        Button btnPage = findViewById(R.id.btnPage);
        Button btnCallOffice = findViewById(R.id.btnCallOffice);
        Button btnBusStop = findViewById(R.id.btnBusStop);
        Button btnReport = findViewById(R.id.btnReport);

        // Step 2: open the UOL website in the browser (implicit Intent)
        btnPage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uol.edu.pk"));
            openIntent(MainActivity.this, intent);
        });

        // Step 3: open the dialer with the office number typed (no call is placed)
        btnCallOffice.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:04298765432"));
            openIntent(MainActivity.this, intent);
        });

        // Step 4: show the Thokar Niaz Baig bus stop in the maps app
        btnBusStop.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:0,0?q=Thokar+Niaz+Baig,+Lahore"));
            openIntent(MainActivity.this, intent);
        });

        // Scenario 2, Step 1: validate the name, then open ProblemActivity (explicit Intent)
        btnReport.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();

            if (name.isEmpty()) {
                etName.setError("Please enter your name");
                etName.requestFocus();
                return;
            }

            Intent intent = new Intent(MainActivity.this, ProblemActivity.class);
            intent.putExtra(KEY_NAME, name);
            startActivity(intent);
        });
    }

    /**
     * Step 5: safe helper used by every implicit Intent.
     * If no installed app can handle the Intent, a Toast is shown instead of crashing.
     */
    public static void openIntent(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "No app found for this action", Toast.LENGTH_SHORT).show();
        }
    }
}
