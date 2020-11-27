package com.example.mvvm_quoteapp.Utils

import com.example.mvvm_quoteapp.Data.FakeDatabase
import com.example.mvvm_quoteapp.Data.QuoteRepo
import com.example.mvvm_quoteapp.UI.Quotes.QuotesVMFactory

object InjectorUtils {

    fun provideQuotesVMFactory(): QuotesVMFactory {
        val fakeDatabase = FakeDatabase.getInstance().quoteDao
        val quoteRepo = QuoteRepo.getInstance(fakeDatabase)
        return QuotesVMFactory(quoteRepo)
    }
}