package com.example.uts_mobile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailMangaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_manga)

        val manga = intent.getParcelableExtra<Manga>(MangaActivity.INTENT_PARCELABLE)

        val mangatitle = findViewById<TextView>(R.id.manga_title)
        val mangaimg= findViewById<ImageView>(R.id.manga_image)
        val mangayear = findViewById<TextView>(R.id.manga_year)
        val mangagenre = findViewById<TextView>(R.id.manga_genre)
        val mangasynopsis = findViewById<TextView>(R.id.manga_synopsis)

        val btnlink = findViewById<Button>(R.id.manga_link)
        btnlink.setOnClickListener {
            val url = "https://myanimelist.net/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        mangatitle.text = manga?.title!!
        mangaimg.setImageResource(manga.img)
        mangayear.text = manga.year
        mangagenre.text = manga.genre
        mangasynopsis.text = manga.synopsis
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
