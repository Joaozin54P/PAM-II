package com.example.aula_app4.ui.theme.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.aula_app4.roomdb.Pessoa
import kotlinx.coroutines.launch

// A ViewModel é responsável por fornecer os dados e suas funcionalidades relacionadas à entidade Pessoa na UI
class PessoaViewModel(private val repository: Repository): ViewModel() {
    // Obtém a lista de todas as pessoas e converte para LiveData para observação na UI
    fun getPessoa() = repository.getAllPessoa().asLiveData(viewModelScope.coroutineContext)

    // Insere ou atualiza uma pessoa no banco de dados através do repositório
    fun upsertPessoa(pessoa: Pessoa){
        // Lança uma coroutine no escopo da viewModel para executar a operação em segundo plano
        viewModelScope.launch {
            repository.upsertPessoa(pessoa)
        }
    }
    // Deleta uma pessoa do banco de dados através do repositório
    fun deletePessoa(pessoa: Pessoa){
        // Lança uma coroutine no escopo da viewModel para executar a operação em segundo plano
        viewModelScope.launch {
            repository.deletePessoa(pessoa)
        }
    }
}