package br.com.testproject.features.quote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.testproject.R
import br.com.testproject.repositories.character.QuoteItem

class QuotesAdapter: RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {

    var quotes: MutableList<QuoteItem> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        private val tvDialog = view.findViewById<TextView>(R.id.tvDialog)

        fun bind(quote: QuoteItem?) {
            tvDialog.text = "Dialog: ${quote?.dialog}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quote, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(quotes.getOrNull(position))
    }

    override fun getItemCount(): Int {
       return quotes.size
    }

}