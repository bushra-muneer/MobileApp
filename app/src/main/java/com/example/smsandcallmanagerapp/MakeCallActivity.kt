package com.example.smsandcallmanagerapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat


class MakeCallActivity : ComponentActivity() {

    private val CALL_PERMISSION_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_call)

        val etPhoneNumber = findViewById<EditText>(R.id.etPhoneNumber)
        val btnCall = findViewById<Button>(R.id.btnCall)

        btnCall.setOnClickListener {
            val phoneNumber = etPhoneNumber.text.toString().trim()
            if (phoneNumber.isNotEmpty()) {
                makeCall(phoneNumber)
            }
        }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_make_call)
//
//        btnCall.setOnClickListener {
//            val phoneNumber = etPhoneNumber.text.toString().trim()
//            if (phoneNumber.isNotEmpty()) {
//                makeCall(phoneNumber)
//            }
//        }
//    }

    private fun makeCall(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:$phoneNumber")

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CALL_PHONE),
                CALL_PERMISSION_REQUEST_CODE
            )
            return
        }
        startActivity(intent)
    }
}
