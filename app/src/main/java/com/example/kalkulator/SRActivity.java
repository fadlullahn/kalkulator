package com.example.kalkulator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class SRActivity extends AppCompatActivity {

    private EditText editTextInitialFishCount, editTextFinalFishCount;
    private TextView textViewSRResult;
    private Button btnCalculateSR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sractivity);

        // Inisialisasi EditText dan TextView
        editTextInitialFishCount = findViewById(R.id.editTextInitialFishCount);
        editTextFinalFishCount = findViewById(R.id.editTextFinalFishCount);
        textViewSRResult = findViewById(R.id.textViewSRResult);
        btnCalculateSR = findViewById(R.id.btnCalculateSR);

        // Set listener untuk tombol
        btnCalculateSR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSR();
            }
        });
    }

    private void calculateSR() {
        try {
            // Ambil nilai dari EditText dan konversi ke int
            int initialFishCount = Integer.parseInt(editTextInitialFishCount.getText().toString());
            int finalFishCount = Integer.parseInt(editTextFinalFishCount.getText().toString());

            // Hitung SR
            double sr = ((double) finalFishCount / initialFishCount) * 100;

            // Tampilkan hasil SR
            textViewSRResult.setText("SR Result: " + String.format("%.2f", sr) + "%");
        } catch (NumberFormatException e) {
            textViewSRResult.setText("Error: Please enter valid numbers.");
        }
    }
}
