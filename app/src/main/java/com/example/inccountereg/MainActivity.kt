package com.example.inccountereg

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.inccountereg.ui.theme.IncCounterEgTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            IncCounterEgTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//            text = "Hello $name!",
//            modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    IncCounterEgTheme {
//        Greeting("Android")
//    }
//}

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var counter = 0
    private lateinit var counterTextView: TextView
    private lateinit var inputField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterTextView = findViewById(R.id.counterTextView)
        inputField = findViewById(R.id.inputField)
        val incrementButton = findViewById<Button>(R.id.incrementButton)
        val decrementButton = findViewById<Button>(R.id.decrementButton)

        incrementButton.setOnClickListener {
            incrementCounter()
        }

        decrementButton.setOnClickListener {
            decrementCounter()
        }
    }

    private fun incrementCounter() {
        val inputValue = inputField.text.toString()
        if (inputValue.isNotEmpty()) {
            counter += inputValue.toInt()
        } else {
            counter++
        }
        updateCounter()
    }

    private fun decrementCounter() {
        val inputValue = inputField.text.toString()
        if (inputValue.isNotEmpty()) {
            counter -= inputValue.toInt()
        } else {
            counter--
        }
        updateCounter()
    }

    private fun updateCounter() {
        counterTextView.text = "Counter: $counter"
    }
}
