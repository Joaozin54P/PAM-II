package com.example.app_aula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app_aula.ui.theme.App_AulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_AulaTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    Column(
        Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        Row(
            Modifier
                .background(Color.White)
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Text(text = "App Aula: 19/04/2024")
        }
        Row(
            Modifier
                .padding(8.dp)
        ) {

        }

        Row(
            Modifier
                .background(Color.White)
                .fillMaxWidth(),
            Arrangement.SpaceEvenly
        ) {
            Text(text = "Carambolas",
                    fontFamily = FontFamily.Monospace
            )

            Column(

            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Editar",
                        fontFamily = FontFamily.Serif
                        )
                }
            }
            Column(

            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Excluir",
                        fontFamily = FontFamily.Serif
                        )
                }
            }
        }
        Row(
            Modifier
                .padding(8.dp)
        ) {

        }
        Row(
            Modifier
                .background(Color.White)
                .fillMaxWidth(),
            Arrangement.SpaceEvenly
        ) {
            Text(text = "Carambolas",
                fontFamily = FontFamily.Cursive
                )

            Column(

            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Editar",
                        fontFamily = FontFamily.Serif
                        )
                }
            }
            Column(

            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Excluir",
                    fontFamily = FontFamily.Serif
                        )
                }
            }
        }
    }
}


@Preview
@Composable
fun AppPreview() {
    App_AulaTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background) {
            App()
        }
    }
}

