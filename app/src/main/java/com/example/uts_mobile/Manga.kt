package com.example.uts_mobile

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Manga (
    val title: String,
    val img: Int,
    val year: String,
    val genre: String,
    val synopsis: String
) : Parcelable