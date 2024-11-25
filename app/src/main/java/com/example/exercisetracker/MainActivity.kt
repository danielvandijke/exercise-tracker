package com.example.exercisetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import com.example.exercisetracker.ui.theme.ExerciseTrackerTheme

class MainActivity : ComponentActivity() {
    companion object {
        const val GREETING_NAME = "Daniel"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExerciseTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(GREETING_NAME)

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier.fillMaxWidth()) {
    // a mutable state is required for button click handling
    val buttonText = remember { mutableStateOf("Click To View Exercise Stat") }
    var showTextField by remember { mutableStateOf(false) }
    val inputText = remember { mutableStateOf("") }
    var text by remember { mutableStateOf("")}

    Column(modifier = modifier) {
        GreetingHeader(name)

        //Button and its logic
        ToggleButton(
            isVisible = showTextField,
            onClick = {
                showTextField = !showTextField
                buttonText.value = if (showTextField) {
                    "Hide Exercise Stat"
                } else {
                    "Click to View Exercise Stat"
                }
            },
            buttonText = buttonText.value
        )

        //Conditionally display the text box
        if (showTextField) {
            ExerciseStatField(
                inputText = inputText.value,
                onInputChange = {inputText.value = it}
            )
        }

        //Add a text field
        TextField(
            value = text,
            onValueChange = {text = it},
            label = { Text("Enter your prompt")},
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "You typed: $text",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

// Function that displays text greeting someone by their name
@Composable
fun GreetingHeader (name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.fillMaxWidth()
    )
}


//Function that handles the logic for a button and what it does.
@Composable
fun ToggleButton(isVisible: Boolean, onClick: () -> Unit, buttonText: String){
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ){
        Text(text = buttonText)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseStatField(inputText: String, onInputChange: (String) -> Unit) {
    OutlinedTextField(value = inputText,
        onValueChange = onInputChange,
        label = { Text("You did 12 reps of bench press yesterday")},
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExerciseTrackerTheme {
        Greeting(MainActivity.GREETING_NAME)
    }
}