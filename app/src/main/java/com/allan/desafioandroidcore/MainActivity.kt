package com.allan.desafioandroidcore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_restaurant.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = rv
        recyclerView.adapter = Adapter(restaurantes, this)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    class Restaurante (val nome: String, val local: String, val horario: String, val imageId: Int) {}

    val restaurantes = arrayListOf(
        Restaurante("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "Fecha às 22:00", R.drawable.image1),
        Restaurante("Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", "Fecha às 00:00", R.drawable.image4),
        Restaurante("Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo", "Fecha às 00:00", R.drawable.image5),
        Restaurante("Sí Señor!", "Alameda Jauaperi, 626 - Moema", "Fecha às 01:00", R.drawable.image3)
    )

    class Adapter(private val restaurantes: List<Restaurante>, private val context: Context): RecyclerView.Adapter<Adapter.RestaurantViewHolder>() {

        class RestaurantViewHolder(itemView: View) : ViewHolder(itemView) {
            fun bindView(restaurante: Restaurante) {
                val nome = itemView.textViewNome
                val local = itemView.textViewLocal
                val horario = itemView.textViewHorario
                val imagem = itemView.image

                nome.text = restaurante.nome
                local.text = restaurante.local
                horario.text = restaurante.horario
                imagem.setImageResource(restaurante.imageId)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.card_restaurant, parent, false)
            return RestaurantViewHolder(view)
        }

        override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
            val restaurante = restaurantes[position]
            holder.bindView(restaurante)
        }

        override fun getItemCount(): Int {
            return restaurantes.size
        }
    }






}