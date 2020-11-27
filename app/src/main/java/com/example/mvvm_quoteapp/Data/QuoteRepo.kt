package com.example.mvvm_quoteapp.Data

class QuoteRepo private constructor(private val quoteDao: FakeDao) {

    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {
        @Volatile
        private var instance: QuoteRepo? = null

        fun getInstance(quoteDao: FakeDao) =
            instance ?: synchronized(this) {
                instance ?: QuoteRepo(quoteDao).also { instance = it }
            }
    }
}