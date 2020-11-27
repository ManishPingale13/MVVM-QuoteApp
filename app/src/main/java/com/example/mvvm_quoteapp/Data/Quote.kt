package com.example.mvvm_quoteapp.Data

/*
* To make it easy I am using Fake Database
* This Project is only for learning MVVM
* Thus I am not making it complex by adding Room */

data class Quote(val quoteText: String, val author: String) {

    override fun toString(): String {
        return "$quoteText - $author"
    }
}