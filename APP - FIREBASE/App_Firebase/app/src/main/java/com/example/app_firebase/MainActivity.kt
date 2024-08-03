package com.example.app_firebase

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_firebase.ui.theme.App_FirebaseTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(db)
        }
    }
}


@Composable
fun App(db: FirebaseFirestore) {
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }

    App_FirebaseTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                Modifier.fillMaxSize(),

                ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(40.dp),

                    Arrangement.Center
                ) {
                    Text(text = "App Firebase - Cadastrar Clientes", textAlign = TextAlign.Center, fontSize = 24.sp, fontFamily = FontFamily.Serif)
                }
                Spacer(modifier = Modifier.height(35.dp))

                Row {
                    Column(Modifier.fillMaxWidth(0.3f)) {
                        Text(text = "Nome:",fontSize = 24.sp, fontFamily = FontFamily.Serif)
                    }
                    Column() {

                        TextField(value = nome, onValueChange = {nome = it})
                    }
                }
                Spacer(modifier = Modifier.height(50.dp))
                Row {
                    Column(Modifier.fillMaxWidth(0.3f)) {
                        Text(text = "Telefone:", fontSize = 24.sp, fontFamily = FontFamily.Serif)
                    }
                    Column() {
                        TextField(value = telefone, onValueChange =  {telefone = it})
                    }
                }
                Spacer(modifier = Modifier.height(45.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    Arrangement.Center
                ) {
                    Button(onClick = {
                        val client = hashMapOf(
                            "nome" to nome,
                            "telefone" to telefone
                        )
                        db.collection("Clientes").document("PrimeiroCliente")
                            .set(client)
                            .addOnSuccessListener {
                                Log.d("Firestore", "Document successfully written!")
                            }
                            .addOnFailureListener { e ->
                                Log.w("Firestore", "Error writing document", e)
                            }
                    }) {
                        Text(text = "Cadastrar")
                    }
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth(0.3f)
                    ) {
                        Text(text = "Nome:")
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                    ) {
                        Column(

                        ) {
                            db.collection("Clientes")
                                .get()
                                .addOnSuccessListener { documents ->
                                    for (document in documents) {
                                        val lista = hashMapOf(
                                            "nome" to "${document.data.get("nome")}",
                                            "telefone" to "${document.data.get("telefone")}"
                                        )
                                        Log.d(TAG, "${document.id} => ${document.data}")
                                    }
                                }
                                .addOnFailureListener { exception ->
                                    Log.w(TAG, "Error getting documents: ", exception)
                                } }
                        }
                    }
                }
            }
        }
    }