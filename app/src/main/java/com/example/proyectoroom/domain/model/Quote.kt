package com.example.proyectoroom.domain.model

import com.example.proyectoroom.Core.database.entities.QuoteEntity
import com.example.proyectoroom.data.model.QuoteModel

data class Quote(val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)