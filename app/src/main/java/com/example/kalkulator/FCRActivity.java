package com.example.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FCRActivity extends AppCompatActivity {

    private EditText editTextTotalFeed, editTextTotalFish;
    private Button btnCalculateFCR;
    private TextView textViewFCRResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fcractivity);

        editTextTotalFeed = findViewById(R.id.editTextTotalFeed);
        editTextTotalFish = findViewById(R.id.editTextTotalFish);
        btnCalculateFCR = findViewById(R.id.btnCalculateFCR);
        textViewFCRResult = findViewById(R.id.textViewFCRResult);

        btnCalculateFCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFCR();
            }
        });
    }

    private void calculateFCR() {
        try {
            // Ambil nilai dari EditText dan konversi ke double
            double totalFeedKg = Double.parseDouble(editTextTotalFeed.getText().toString());
            double totalFishWeightKg = Double.parseDouble(editTextTotalFish.getText().toString());

            // Hitung FCR
            double fcr = totalFeedKg / totalFishWeightKg;

            // Tampilkan hasil FCR
            textViewFCRResult.setText("FCR Result: " + String.format("%.2f", fcr));
        } catch (NumberFormatException e) {
            textViewFCRResult.setText("Error: Please enter valid numbers.");
        }
    }

}
