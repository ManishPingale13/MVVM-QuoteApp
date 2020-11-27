package com.example.mvvm_quoteapp.UI.Quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_quoteapp.Data.QuoteRepo

@Suppress("UNCHECKED_CAST")
class QuotesVMFactory(private val quoteRepo: QuoteRepo) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuoteViewModel(quoteRepo) as T
    }

}