package com.example.proyectoroom.domain

import com.example.proyectoroom.Core.database.entities.toDatabase
import com.example.proyectoroom.data.model.QuoteModel
import com.example.proyectoroom.data.model.QuoteRepository
import com.example.proyectoroom.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository : QuoteRepository) {
    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map {it.toDatabase()})
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }
}