package com.example.exercisetracker.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ToggleButton(onClick: () -> Unit, buttonText: String){
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ){
        Text(text = buttonText)
    }
}