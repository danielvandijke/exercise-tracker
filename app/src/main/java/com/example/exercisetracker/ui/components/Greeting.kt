package com.example.exercisetracker.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.exercisetracker.ui.theme.ExerciseTrackerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    // a mutable state is required for button click handling
    val buttonText = remember { mutableStateOf("Click To View Exercise Stat") }
    var showTextField by remember { mutableStateOf(false) }
    val inputText = remember { mutableStateOf("") }
    val tableData = remember { mutableStateListOf<Pair<String, String>>() }

    Column(modifier = modifier) {

        //Button and its logic
        ToggleButton(
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
            value = inputText.value,
            onValueChange = {inputText.value = it},
            label = { Text("") },
            modifier = Modifier.fillMaxWidth()
        )

        //Submit button to show the entered text
        Button(
            onClick = {
                if (inputText.value.isNotBlank())
                {
                    // Add the entered text as a new entry in tableData
                    tableData.add(Pair("Reps Performed", inputText.value))
                    inputText.value = "" // Clear the input field after submission
                }
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text("Submit number of reps performed")
        }

        // Display the table
        TableDisplay(tableData = tableData)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExerciseTrackerTheme {
        Greeting()
    }
}