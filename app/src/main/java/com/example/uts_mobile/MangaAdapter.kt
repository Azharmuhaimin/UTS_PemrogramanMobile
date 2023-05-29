package com.example.uts_mobile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MangaAdapter (private val context: Context, private val manga: List<Manga>, val listener: (Manga) -> Unit)
    : RecyclerView.Adapter<MangaAdapter.MangaViewHolder>(){
    class MangaViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val title = view.findViewById<TextView>(R.id.manga_title)
        val img= view.findViewById<ImageView>(R.id.manga_image)
        val year = view.findViewById<TextView>(R.id.manga_year)
        val genre = view.findViewById<TextView>(R.id.manga_genre)
        val synopsis = view.findViewById<TextView>(R.id.manga_synopsis)

        fun bindView(manga: Manga, listener: (Manga) -> Unit){
            title.text = manga.title
            img.setImageResource(manga.img)
            year.text = manga.year
            genre.text = manga.genre
            synopsis.text = manga.synopsis
            itemView.setOnClickListener{
                (listener(manga))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaAdapter.MangaViewHolder {
        return MangaAdapter.MangaViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MangaAdapter.MangaViewHolder, position: Int) {
        holder.bindView(manga[position], listener)
    }

    override fun getItemCount(): Int = manga.size

}