package com.allan.desafioandroidcore

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.appbar.CollapsingToolbarLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_restaurant.*
import kotlinx.android.synthetic.main.activity_restaurant.rv
import kotlinx.android.synthetic.main.activity_restaurant.view.image
import kotlinx.android.synthetic.main.card_restaurant.view.*

class RestaurantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = intent.getStringExtra("name")
        image.setImageResource(intent.getIntExtra("img",R.drawable.ic_launcher_background))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val recyclerView = rv
        recyclerView.adapter = Adapter(foods, this)
        val layoutManager = GridLayoutManager(this,2)
        recyclerView.layoutManager = layoutManager
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    class Food (val nome: String, val imageId: Int) {}

    val foods = arrayListOf(
        Food("Salada com molho Gengibre", R.drawable.image4),
        Food("Salada com molho Gengibre", R.drawable.image4),
        Food("Salada com molho Gengibre", R.drawable.image4),
        Food("Salada com molho Gengibre", R.drawable.image4),
        Food("Salada com molho Gengibre", R.drawable.image4),
        Food("Salada com molho Gengibre", R.drawable.image4),
        Food("Salada com molho Gengibre", R.drawable.image4),
        Food("Salada com molho Gengibre", R.drawable.image4)
    )

    class Adapter(private val foods: List<Food>, private val context: Context): RecyclerView.Adapter<Adapter.FoodViewHolder>() {

        class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bindView(food: Food) {
                val nome = itemView.textViewNome
                val imagem = itemView.image

                nome.text = food.nome
                imagem.setImageResource(food.imageId)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.card_food, parent, false)
            return FoodViewHolder(view)
        }

        override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
            val food = foods[position]
            holder.bindView(food)
            if (position == 0) {
                holder.itemView.setOnClickListener {
                    val i = Intent(context, FoodActivity::class.java)
                    i.putExtra("name", food.nome)
                    i.putExtra("img", food.imageId)
                    context.startActivity(i)
                }
            }
        }

        override fun getItemCount(): Int {
            return foods.size
        }

    }
}