package com.example.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FRActivity extends AppCompatActivity {

    private EditText editTextTotalFeedFR;
    private EditText editTextDaysFR;
    private Button btnCalculateFR;
    private TextView textViewFRResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fractivity);

        editTextTotalFeedFR = findViewById(R.id.editTextTotalFeedFR);
        editTextDaysFR = findViewById(R.id.editTextDaysFR);
        btnCalculateFR = findViewById(R.id.btnCalculateFR);
        textViewFRResult = findViewById(R.id.textViewFRResult);

        btnCalculateFR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFR();
            }
        });
    }

    private void calculateFR() {
        try {
            // Ambil nilai dari EditText dan konversi ke double
            double totalFeedKg = Double.parseDouble(editTextTotalFeedFR.getText().toString());
            int days = Integer.parseInt(editTextDaysFR.getText().toString());

            // Hitung FR langsung dalam kilogram
            double fr = totalFeedKg / days;

            // Tampilkan hasil FR
            textViewFRResult.setText("FR Result: " + String.format("%.2f", fr) + " kg/day");
        } catch (NumberFormatException e) {
            textViewFRResult.setText("Error: Please enter valid numbers.");
        }
    }


}
