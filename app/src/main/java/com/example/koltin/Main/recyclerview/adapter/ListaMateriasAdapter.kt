package com.example.koltin.Main.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.koltin.Main.Materia.Materia
import com.example.koltin.R

class ListaMateriasAdapter(
    private val context : Context,
    materias : List <Materia>
) : RecyclerView.Adapter<ListaMateriasAdapter.ViewHolder>() {

private val materias = materias.toMutableList()
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        fun vincula(materia: Materia) {
            val nome = itemView.findViewById<TextView>(R.id.mat_item_nome)
            nome.text =materia.nome
            val descricao = itemView.findViewById<TextView>(R.id.mat_item_descricao)
            descricao.text = materia.descricao
            val valor = itemView.findViewById<TextView>(R.id.mat_item_professor)
            valor.text = materia.professor
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val inflater = LayoutInflater.from(context)
       val view =  inflater.inflate(R.layout.mat_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = materias.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val materia = materias[position]
        holder.vincula(materia)
    }

    fun atualiza(materias: List<Materia>) {
        this.materias.clear()
        this.materias.addAll(materias)
        notifyDataSetChanged()

    }

}
