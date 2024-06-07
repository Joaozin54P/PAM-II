package com.example.aula_app4.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

// Definição da entidade Pessoa para uso com o Room Database
@Entity
data class Pessoa(
    val nome: String, // Nome da pessoa
    val telefone: String, // Número de telefone da pessoa
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0 // Identificador único da pessoa, gerado automaticamente
)
