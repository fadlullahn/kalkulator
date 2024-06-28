package com.example.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SGRActivity extends AppCompatActivity {

    private EditText editTextInitialWeight;
    private EditText editTextFinalWeight;
    private EditText editTextDaysSGR;
    private Button btnCalculateSGR;
    private TextView textViewSGRResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgractivity);

        editTextInitialWeight = findViewById(R.id.editTextInitialWeight);
        editTextFinalWeight = findViewById(R.id.editTextFinalWeight);
        editTextDaysSGR = findViewById(R.id.editTextDaysSGR);
        btnCalculateSGR = findViewById(R.id.btnCalculateSGR);
        textViewSGRResult = findViewById(R.id.textViewSGRResult);

        btnCalculateSGR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSGR();
            }
        });
    }

    private void calculateSGR() {
        try {
            // Ambil nilai dari EditText dan konversi ke double atau int
            double initialWeightKg = Double.parseDouble(editTextInitialWeight.getText().toString());
            double finalWeightKg = Double.parseDouble(editTextFinalWeight.getText().toString());
            int days = Integer.parseInt(editTextDaysSGR.getText().toString());

            // Konversi dari KG ke Gram
            double initialWeightGram = initialWeightKg * 1000; // Konversi berat awal dari KG ke Gram
            double finalWeightGram = finalWeightKg * 1000; // Konversi berat akhir dari KG ke Gram

            // Hitung SGR
            double sgr = ((Math.log(finalWeightGram) - Math.log(initialWeightGram)) / days) * 100;

            // Tampilkan hasil SGR
            textViewSGRResult.setText("SGR Result: " + String.format("%.2f", sgr) + "% per day");
        } catch (NumberFormatException e) {
            textViewSGRResult.setText("Error: Please enter valid numbers.");
        }
    }

}
