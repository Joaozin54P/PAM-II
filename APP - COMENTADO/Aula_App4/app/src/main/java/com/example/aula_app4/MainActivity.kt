package com.example.aula_app4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
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
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
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
                    App(viewModel, this)
                }
            }
        }
    }
}

@Composable
fun App(viewModel: PessoaViewModel, mainActivity: MainActivity){
    // Declarando as variáveis que armazenar o nome e telefone do cliente
    var nome by remember {
        mutableStateOf("")
    }

    var telefone by remember {
        mutableStateOf("")
    }
    // Criando uma classe 'Pessoa' com as variáveis fornecidos
    val pessoa = Pessoa(
        nome,
        telefone
    )
    // Lista de pessoas,que irá atualizar com os dados obtidos do ViewModel
    var pessoaList by remember {
        mutableStateOf(listOf<Pessoa>())
    }
    // Observação das mudanças na lista de pessoas do ViewModel e atualização da lista local
    viewModel.getPessoa().observe(mainActivity){
        pessoaList = it
    }
    // Composição da interface do usuário
    Column(
        Modifier
            .background(Color.White)
    ) {
        Row(
            Modifier
                .padding(20.dp) // Colocando um espaço vazio para espaçamento entre as caixa de texto
        ){

        }
        // Colocando título do app para cadastrar cliente
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ){
            Text(
                text = "Cadatrar Cliente",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        }
        Row(
            Modifier
                .padding(20.dp) // Colocando um espaço vazio para espaçamento entre as caixa de texto
        ){

        }
        // Colocando um caixa de texto para o nome do 'Cliente'
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text(text = "Nome:") }
            )
        }
        Row(
            Modifier
                .padding(20.dp) // Colocando um espaço vazio para espaçamento entre as caixa de texto
        ){

        }
        // Colocando um caixa de texto para o nome do 'Telefone'
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            TextField(
                value = telefone,
                onValueChange = { telefone = it },
                label = { Text(text = "Telefone:") }
            )
        }
        Row(
            Modifier
                .padding(20.dp) // Colocando um espaço vazio para espaçamento entre as caixa de texto
        ){

        }
        // Colocando um botão de nome 'Cadastrar'
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ){
            Button(
                onClick = {
                    viewModel.upsertPessoa(pessoa)
                    nome = ""
                    telefone = ""
                }
            ) {
                Text(text = "Cadastrar")
            }
        }
        Row(
            Modifier
                .padding(20.dp) // Colocando um espaço vazio para espaçamento entre as caixa de texto
        ){

        }
        // Títulos "Nome" e "Telefone" para a lista de clientes cadastrados
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ){
            Column(
                Modifier
                    .fillMaxWidth(0.5f)
            ) {
                Text(text = "Nome")
            }
            Column(
                Modifier
                    .fillMaxWidth(0.5f)
            ) {
                Text(text = "Telefone")
            }
        }
        // Adicionado uma linha divisoria entre 'Nome' e 'Telefone' para a lista de clientes cadastrados
        Divider()
        // Lista de clientes cadastrados
        LazyColumn {
            items(pessoaList){ pessoa ->
                Row(
                    Modifier
                        .clickable {
                            viewModel.deletePessoa(pessoa)
                        }
                        .fillMaxWidth(),
                    Arrangement.Center
                ){
                    Column(
                        Modifier
                            .fillMaxWidth(0.5f),
                        Arrangement.Center
                    ) {
                        Text(text = "${pessoa.nome}")
                    }
                    Column(
                        Modifier
                            .fillMaxWidth(0.5f),
                        Arrangement.Center
                    ) {
                        Text(text = "${pessoa.telefone}")
                    }
                }
                // Adicionado uma linha divisoria entre a lista de clientes cadastrados

                Divider()
            }
        }
    }
}

/*@Preview
@Composable
fun AppPreview() {
    App()
}*/