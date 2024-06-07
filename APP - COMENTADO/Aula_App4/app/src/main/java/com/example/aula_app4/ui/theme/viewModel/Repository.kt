package com.example.aula_app4.ui.theme.viewModel

import com.example.aula_app4.roomdb.Pessoa
import com.example.aula_app4.roomdb.PessoaDataBase

// Repositório vai fornecer uma camada de abstração entre a ViewModel e o banco de dados
class Repository(private val db: PessoaDataBase) {

    // Insere ou atualiza uma pessoa no banco de dados
    suspend fun upsertPessoa(pessoa: Pessoa){
        db.pessoaDao().upsertPessoa(pessoa)
    }
    // Deleta uma pessoa do banco de dados
    suspend fun deletePessoa(pessoa: Pessoa){
        db.pessoaDao().deletePessoa(pessoa)
    }
    // Obtém a lista de todas as pessoas do banco de dados
    fun getAllPessoa() = db.pessoaDao().getAllPessoa()
}