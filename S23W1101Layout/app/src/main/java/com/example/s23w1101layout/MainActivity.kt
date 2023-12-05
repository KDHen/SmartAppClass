package com.example.s23w1101layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.s23w1101layout.ui.theme.S23W1101LayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Myapp()
        }
    }
}

@Composable
fun Myapp() {
    S23W1101LayoutTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MyLinearlayout()
        }
    }
}

@Composable
fun MyLinearlayout() {
    Column {
        Row {
            Text(
                text = "Hello World!",
                modifier = Modifier.background(Color.Yellow)
                    .padding(8.dp)
            )
            Text(
                text = "컴퓨터 공학과",
                modifier = Modifier.background(Color.Magenta)
                    .padding(8.dp)
            )
        }
        Text(
            text = "금오공",
            modifier = Modifier.background(Color.Magenta)
                .padding(8.dp)
        )
    }
}