package com.example.aula_app4.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

// Definição do banco de dados Room que contém a tabela Pessoa
@Database(
    entities = [Pessoa::class],
    version = 1
)

// Método abstrato para obter o DAO (Data Access Object) da entidade Pessoa
abstract class PessoaDataBase: RoomDatabase() {
    abstract fun pessoaDao(): PessoaDao
}