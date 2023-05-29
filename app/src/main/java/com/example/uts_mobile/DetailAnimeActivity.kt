package com.example.uts_mobile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailAnimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_anime)

        val anime = intent.getParcelableExtra<Anime>(AnimeActivity.INTENT_PARCELABLE)

        val title = findViewById<TextView>(R.id.title)
        val img= findViewById<ImageView>(R.id.image)
        val year = findViewById<TextView>(R.id.year)
        val genre = findViewById<TextView>(R.id.genre)
        val synopsis = findViewById<TextView>(R.id.synopsis)

        val btnlink = findViewById<Button>(R.id.link)
        btnlink.setOnClickListener {
            val url = "https://myanimelist.net/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        title.text = anime?.title!!
        img.setImageResource(anime.img)
        year.text = anime.year
        genre.text = anime.genre
        synopsis.text = anime.synopsis
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
