package com.example.exercisetracker.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseStatField(inputText: String, onInputChange: (String) -> Unit) {
    OutlinedTextField(value = inputText,
        onValueChange = onInputChange,
        label = { Text("You did 12 reps of bench press yesterday") },
        modifier = Modifier.fillMaxWidth()
    )
}