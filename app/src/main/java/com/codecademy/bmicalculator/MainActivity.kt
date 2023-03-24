package com.codecademy.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText = findViewById<EditText>(R.id.heightEditText)
        val weightEditText = findViewById<EditText>(R.id.weightEditText)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val heightInCm = heightEditText.text.toString().toDoubleOrNull()
            val weight = weightEditText.text.toString().toDoubleOrNull()

            if (heightInCm != null && weight != null) {
                val heightInMeters = heightInCm / 100
                val bmi = weight / (heightInMeters * heightInMeters)
                val bmiCategory = getBMICategory(bmi)
                resultTextView.text = String.format("BMI: %.2f (%s)", bmi, bmiCategory)
            } else {
                resultTextView.text = "Invalid input"
            }
        }
    }

    private fun getBMICategory(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Underweight"
            bmi < 25 -> "Normal weight"
            bmi < 30 -> "Overweight"
            else -> "Obese"
        }
    }
}