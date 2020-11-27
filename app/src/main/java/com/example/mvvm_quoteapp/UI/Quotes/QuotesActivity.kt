package com.example.mvvm_quoteapp.UI.Quotes

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm_quoteapp.Data.Quote
import com.example.mvvm_quoteapp.R
import com.example.mvvm_quoteapp.Utils.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        initUi()

    }

    private fun initUi() {
        val factory = InjectorUtils.provideQuotesVMFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuoteViewModel::class.java)

        viewModel.getQuotes().observe(this, { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("${quote}\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        button_add_quote.setOnClickListener {
            if (editText_quote.text.isEmpty() || editText_author.text.isEmpty()) {
                Toast.makeText(this, "Please fill all info", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }

    }
}