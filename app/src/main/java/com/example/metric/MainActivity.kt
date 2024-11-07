package com.example.metric

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.metric.R


class MainActivity : AppCompatActivity() {
    private var inputValue: EditText? = null
    private var fromUnit: Spinner? = null
    private var toUnit: Spinner? = null
    private var resultText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputValue = findViewById<EditText>(R.id.inputValue)
        fromUnit = findViewById<Spinner>(R.id.fromUnit)
        toUnit = findViewById<Spinner>(R.id.toUnit)
        resultText = findViewById<TextView>(R.id.resultText)

        findViewById<View>(R.id.convertButton).setOnClickListener { view: View? -> convertUnits() }
    }

    private fun convertUnits() {
        val value = inputValue!!.text.toString().toDouble()
        val from = fromUnit!!.selectedItem.toString()
        val to = toUnit!!.selectedItem.toString()

        val result = convertLength(value, from, to)
        resultText!!.text = "Result: $result $to"
    }

    private fun convertLength(value: Double, from: String, to: String): Double {
        var meters = 0.0

        when (from) {
            "Millimeter" -> meters = value / 1000
            "Centimeter" -> meters = value / 100
            "Meter" -> meters = value
            "Kilometer" -> meters = value * 1000
        }
        when (to) {
            "Millimeter" -> return meters * 1000
            "Centimeter" -> return meters * 100
            "Meter" -> return meters
            "Kilometer" -> return meters / 1000
        }
        return 0.0
    }
}
