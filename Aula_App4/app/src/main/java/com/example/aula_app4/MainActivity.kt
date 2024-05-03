package com.example.aula_app4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.aula_app4.roomdb.Pessoa
import com.example.aula_app4.roomdb.PessoaDataBase
import com.example.aula_app4.ui.theme.Aula_App4Theme
import com.example.aula_app4.ui.theme.viewModel.PessoaViewModel
import com.example.aula_app4.ui.theme.viewModel.Repository

class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            PessoaDataBase::class.java,
            "pessoa.db"
        ).build()
    }

    private val viewModel by viewModels<PessoaViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T: ViewModel> create(modelClass: Class<T>):T{
                    return PessoaViewModel(Repository(db)) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aula_App4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(viewModel)
                }
            }
        }
    }
}

@Composable
fun App(viewModel: PessoaViewModel) {
    var nome by remember {
        mutableStateOf("")
    }

    var Telefone by remember {
        mutableStateOf("")
    }
    val pessoa = Pessoa(
        nome,
        Telefone
    )

    Column(
        Modifier
            .background(Color.Black)
    ) {
        Row(
            Modifier
                .background(Color.White)
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Text(
                text = "App Cadastro Cliente",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        }
        Row(
            Modifier
                .padding(20.dp)
        ) {

        }
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            TextField(value = nome,
                onValueChange = { nome = it },
                label = { Text(text = "Nome:") }
            )
        }
        Row(
            Modifier
                .padding(20.dp)
        ) {

        }
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            TextField(value = Telefone,
                onValueChange = { Telefone = it },
                label = { Text(text = "Telefone:") }
            )
        }
        Row(
            Modifier
                .padding(20.dp)
        ) {

        }
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Button(onClick = {
                viewModel.upsertPessoa(pessoa)
            }) {
                Text(text = "Cadastrar")
            }
        }
    }
}

    /*@Preview
    @Composable
    fun AppPreview() {
        App()
    }*/