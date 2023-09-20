package com.example.rickandmorty.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class dataCharacter(
    val species: String,
    val age: String,
    val status: String,
    val name: String,
    val image: Int
    ): Parcelable
