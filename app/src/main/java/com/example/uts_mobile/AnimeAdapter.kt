package com.example.uts_mobile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimeAdapter (private val context: Context, private val anime: List<Anime>, val listener: (Anime) -> Unit)
    : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>(){
    class AnimeViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val title = view.findViewById<TextView>(R.id.title)
        val img= view.findViewById<ImageView>(R.id.image)
        val year = view.findViewById<TextView>(R.id.year)
        val genre = view.findViewById<TextView>(R.id.genre)
        val synopsis = view.findViewById<TextView>(R.id.synopsis)

        fun bindView(anime: Anime, listener: (Anime) -> Unit){
            title.text = anime.title
            img.setImageResource(anime.img)
            year.text = anime.year
            genre.text = anime.genre
            synopsis.text = anime.synopsis
            itemView.setOnClickListener{
                (listener(anime))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bindView(anime[position], listener)
    }

    override fun getItemCount(): Int = anime.size

}