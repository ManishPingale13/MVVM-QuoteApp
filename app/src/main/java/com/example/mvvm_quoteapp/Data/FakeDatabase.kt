package com.example.mvvm_quoteapp.Data

class FakeDatabase private constructor() {

    var quoteDao = FakeDao()
        private set


    companion object {
        @Volatile
        private var instance: FakeDatabase? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}