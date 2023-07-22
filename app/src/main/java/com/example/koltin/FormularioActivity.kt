package com.example.koltin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.koltin.Main.Materia.Materia
import com.example.koltin.Main.dao.MateriasDao

class FormularioActivity : AppCompatActivity(R.layout.activity_formulario) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        botaoSalvar()

    }

    private fun botaoSalvar() {
        val botton_save = findViewById<Button>(R.id.botao_salvar)
        val dao = MateriasDao()
        botton_save.setOnClickListener {
            val materiaNova = materia()
            dao.adiciona(materiaNova)
            finish()
        }
    }

    private fun materia(): Materia {
        val camponome = findViewById<EditText>(R.id.activity_formulario_nome)
        val nome = camponome.text.toString()
        val campodescricao = findViewById<EditText>(R.id.activity_descricao)
        val descricao = campodescricao.text.toString()
        val campoprofessor = findViewById<EditText>(R.id.mat_item_professor)
        val professor = campoprofessor.text.toString()
        val materiaNova = Materia(nome = nome, descricao = descricao, professor = professor)
        return materiaNova
    }

}