package com.example.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FRActivity extends AppCompatActivity {

    private EditText editTextAverageWeight;
    private EditText editTextTotalFishCount;
    private EditText editTextFeedRatePercent;
    private Button btnCalculateFeedRequirement;
    private TextView textViewFeedRequirementResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fractivity);

        editTextAverageWeight = findViewById(R.id.editTextAverageWeight);
        editTextTotalFishCount = findViewById(R.id.editTextTotalFishCount);
        editTextFeedRatePercent = findViewById(R.id.editTextFeedRatePercent);
        btnCalculateFeedRequirement = findViewById(R.id.btnCalculateFeedRequirement);
        textViewFeedRequirementResult = findViewById(R.id.textViewFeedRequirementResult);

        btnCalculateFeedRequirement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDailyFeedRequirement();
            }
        });
    }

    private void calculateDailyFeedRequirement() {
        try {
            // Ambil nilai dari EditText dan konversi ke double
            double averageWeightPerFishKg = Double.parseDouble(editTextAverageWeight.getText().toString());
            int totalFishCount = Integer.parseInt(editTextTotalFishCount.getText().toString());
            double feedRatePercent = Double.parseDouble(editTextFeedRatePercent.getText().toString());

            // Konversi feed rate dari persen ke desimal
            double feedRateDecimal = feedRatePercent / 100.0;

            // Hitung jumlah pakan harian
            double dailyFeedRequirementKg = averageWeightPerFishKg * totalFishCount * feedRateDecimal;

            // Tampilkan hasil kebutuhan pakan harian
            textViewFeedRequirementResult.setText("Kebutuhan Pakan Harian: " + String.format("%.2f", dailyFeedRequirementKg) + " kg/hari");
        } catch (NumberFormatException e) {
            textViewFeedRequirementResult.setText("Error: Mohon masukkan angka yang valid.");
        }
    }
}
