package com.siftifybd.smsmanager

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val phoneInput = findViewById<EditText>(R.id.phoneInput)
        val quantityInput = findViewById<EditText>(R.id.quantityInput)
        val consentCheck = findViewById<CheckBox>(R.id.consentCheck)
        val prepareButton = findViewById<Button>(R.id.prepareButton)

        prepareButton.setOnClickListener {
            val phone = phoneInput.text.toString().trim()
            val quantity = quantityInput.text.toString().toIntOrNull()

            when {
                phone.length < 8 ->
                    showMessage("Enter a valid phone number")

                quantity == null || quantity !in 1..50 ->
                    showMessage("Quantity must be between 1 and 50")

                !consentCheck.isChecked ->
                    showMessage("Recipient consent is required")

                else ->
                    showMessage(
                        "Campaign details validated locally. No SMS was sent."
                    )
            }
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
