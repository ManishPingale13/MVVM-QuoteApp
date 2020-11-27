package com.example.mvvm_quoteapp.UI.Quotes

import androidx.lifecycle.ViewModel
import com.example.mvvm_quoteapp.Data.Quote
import com.example.mvvm_quoteapp.Data.QuoteRepo

class QuoteViewModel(private val quoteRepo: QuoteRepo) : ViewModel() {

    fun getQuotes() = quoteRepo.getQuotes()

    fun addQuote(quote: Quote) = quoteRepo.addQuote(quote)
}