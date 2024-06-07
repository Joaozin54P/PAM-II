package com.example.aula_app4.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

// Data Access Object (DAO) para operações relacionadas à entidade Pessoa no banco de dados
@Dao
interface PessoaDao {
    // Insere ou atualiza uma pessoa no banco de dados
    @Upsert
    suspend fun upsertPessoa(pessoa: Pessoa)
    // Deleta uma pessoa no banco de dados
    @Delete
    suspend fun deletePessoa(pessoa: Pessoa)
    // Obtém a lista de todas as pessoas do banco de dados
    @Query("select * from pessoa")
    fun getAllPessoa(): Flow<List<Pessoa>>
}