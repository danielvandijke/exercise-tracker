package com.example.exercisetracker.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TableDisplay(tableData: List<Pair<String, String>>){
    LazyColumn(modifier = Modifier.fillMaxWidth()){
        // Table header
        item {
            Row(modifier = Modifier.fillMaxWidth()){
                Text(
                    text = "Reps Performed",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Input",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        // Table rows
        items(tableData) {row ->
            Row(modifier = Modifier.fillMaxWidth()){
                Text(
                    text = row.first,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = row.second,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}