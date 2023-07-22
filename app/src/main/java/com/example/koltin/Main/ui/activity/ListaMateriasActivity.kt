package com.example.koltin.Main.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.koltin.FormularioActivity
import com.example.koltin.Main.dao.MateriasDao
import com.example.koltin.Main.recyclerview.ListaMateriasAdapter
import com.example.koltin.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaMateriasActivity : AppCompatActivity(R.layout.activity_layout_listamatmain) {

 private val dao = MateriasDao()
 private val adapter = ListaMateriasAdapter(context = this, materias =dao.buscaTods() )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraReclyerview()
        configuraFab()

    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTods())
    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_recycler_fab)
        fab.setOnClickListener {
            vaiformulariomaterias()
        }
    }

    private fun vaiformulariomaterias() {
        val intent = Intent(this, FormularioActivity::class.java)
        startActivity(intent)
    }

    private fun configuraReclyerview(){
        val recyclerView = findViewById<RecyclerView>(R.id.activity_recycler)
        recyclerView.adapter=adapter

    }


}