package com.example.mvvm_quoteapp.Data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeDao {
    private val quoteList = mutableListOf<Quote>()
    private val quotesLive = MutableLiveData<List<Quote>>()

    init {
        quotesLive.value = quoteList
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotesLive.value = quoteList
    }

    fun getQuotes() = quotesLive as LiveData<List<Quote>>
}