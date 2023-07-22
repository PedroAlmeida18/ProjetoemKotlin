package com.example.koltin.Main.dao

import com.example.koltin.Main.Materia.Materia

class MateriasDao {
    fun adiciona(materia: Materia){
        materias.add(materia)

    }
    fun buscaTods(): List<Materia>{
        return materias.toList()
    }

    companion object {
        private val materias = mutableListOf<Materia>()
    }
}