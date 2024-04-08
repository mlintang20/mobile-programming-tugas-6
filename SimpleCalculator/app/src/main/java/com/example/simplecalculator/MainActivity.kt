package com.example.simplecalculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCalculator()
        }
    }
}

@Composable
fun SimpleCalculator() {
    var num1 by remember {
        mutableStateOf("0")
    }
    var num2 by remember {
        mutableStateOf("0")
    }

    val context = LocalContext.current

    Column {
        TextField(
            value = num1,
            onValueChange = {
                num1 = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = num2,
            onValueChange = {
                num2 = it
            },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                val result = num1.toInt() + num2.toInt()
                Toast.makeText(
                    context,
                    "Result for $num1 + $num2 is $result",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Text(text = "Add")
            }
            Spacer(modifier = Modifier.width(20.dp))

            Button(onClick = {
                val result = num1.toInt() - num2.toInt()
                Toast.makeText(
                    context,
                    "Result for $num1 - $num2 is $result",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Text(text = "Sub")
            }
            Spacer(modifier = Modifier.width(20.dp))

            Button(onClick = {
                val result = num1.toInt() * num2.toInt()
                Toast.makeText(
                    context,
                    "Result for $num1 * $num2 is $result",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Text(text = "Mul")
            }
            Spacer(modifier = Modifier.width(20.dp))

            Button(onClick = {
                val result = num1.toInt() / num2.toInt()
                Toast.makeText(
                    context,
                    "Result for $num1 / $num2 is $result",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Text(text = "Div")
            }
        }
    }
}