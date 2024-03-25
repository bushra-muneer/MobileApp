package com.example.smsandcallmanagerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.content.Intent
import android.widget.Button

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMakeCall = findViewById<Button>(R.id.btnMakeCall)
        val btnSendSMS = findViewById<Button>(R.id.btnSendSMS)

        btnMakeCall.setOnClickListener {
            startActivity(Intent(this, MakeCallActivity::class.java))
        }

        btnSendSMS.setOnClickListener {
            startActivity(Intent(this, SendSMSActivity::class.java))
        }
    }
}

