import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*


import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.calculator.R

//import androidx.appcompat.app.AppCompatActivity

class MainActivity : ComponentActivity() {

    private lateinit var display: TextView
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        // Set OnClickListener for all buttons
        val buttonIds = arrayOf(
            R.id.btn_clear, R.id.btn_divide, R.id.btn_multiply, R.id.btn_minus,
            R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_plus,
            R.id.btn_4, R.id.btn_5, R.id.btn_6,
            R.id.btn_1, R.id.btn_2, R.id.btn_3,
            R.id.btn_0, R.id.btn_equal
        )

        for (buttonId in buttonIds) {
            findViewById<Button>(buttonId).setOnClickListener { onButtonClick(it) }
        }
    }

    private fun onButtonClick(view: View) {
        when (view.id) {
            R.id.btn_clear -> {
                clearDisplay()
            }
            R.id.btn_divide, R.id.btn_multiply, R.id.btn_minus, R.id.btn_plus -> {
                operator = (view as Button).text.toString()
                operand1 = display.text.toString().toDouble()
                clearDisplay()
            }
            R.id.btn_equal -> {
                operand2 = display.text.toString().toDouble()
                calculateResult()
            }
            else -> {
                val text = (view as Button).text.toString()
                if (display.text.toString() == "0") {
                    display.text = text
                } else {
                    display.append(text)
                }
            }
        }
    }

    private fun clearDisplay() {
        display.text = "0"
    }

    private fun calculateResult() {
        var result = 0.0
        when (operator) {
            "+" -> result = operand1 + operand2
            "-" -> result = operand1 - operand2
            "*" -> result = operand1 * operand2
            "/" -> {
                if (operand2 != 0.0) {
                    result = operand1 / operand2
                } else {
                    display.text = "Error"
                    return
                }
            }
        }
        display.text = result.toString()
    }
}


//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            CalculatorTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Calculator()
//                }
//            }
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Calculator() {
//    var input by remember { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        // Display area
//        TextField(
//            value = input,
//            onValueChange = { input = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//            textStyle = MaterialTheme.typography.h4,
//            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = Color.Transparent,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent
//            ),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            shape = RoundedCornerShape(16.dp)
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Number buttons
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Button(onClick = { appendInput("1") }) {
//                Text(text = "1")
//            }
//            Button(onClick = { appendInput(char = "2") }) {
//                Text(text = "2")
//            }
//            Button(onClick = { appendInput("3") }) {
//                Text(text = "3")
//            }
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Button(onClick = { appendInput("4") }) {
//                Text(text = "4")
//            }
//            Button(onClick = { appendInput("5") }) {
//                Text(text = "5")
//            }
//            Button(onClick = { appendInput("6") }) {
//                Text(text = "6")
//            }
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Button(onClick = { appendInput("7") }) {
//                Text(text = "7")
//            }
//            Button(onClick = { appendInput("8") }) {
//                Text(text = "8")
//            }
//            Button(onClick = { appendInput("9") }) {
//                Text(text = "9")
//            }
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Button(onClick = { appendInput("0") }) {
//                Text(text = "0")
//            }
//            Button(onClick = { appendInput("+") }) {
//                Text(text = "+")
//            }
//            Button(onClick = { appendInput("-") }) {
//                Text(text = "-")
//            }
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Button(onClick = { calculate() }) {
//                Text(text = "=")
//            }
//            Button(onClick = { clearInput() }) {
//                Text(text = "C")
//            }
//        }
//    }
//}
//
//@Composable
//fun appendInput(char: String) {
//    // You can add more logic here if needed, e.g., to prevent adding operators consecutively
//    // or to handle other edge cases
//    MainActivity().input += char
//}
//
//@Composable
//fun calculate() {
//    // You can implement the calculation logic here
//    // Parse the input string and evaluate the expression
//    // You may use a library like exp4j or write your own parser
//    // The result should be updated in the input field
//    // Clear the input after calculation if necessary
//}
//
//@Composable
//fun clearInput() {
//    MainActivity().input = ""
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    CalculatorTheme {
//        Calculator()
//    }
//}



