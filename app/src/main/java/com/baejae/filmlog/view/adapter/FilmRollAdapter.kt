package com.baejae.filmlog.view.adapter

import android.content.Context
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.baejae.filmlog.R
import com.baejae.filmlog.data.model.FilmRoll

class FilmRollAdapter : RecyclerView.Adapter<FilmRollAdapter.ViewHolder>() {
    var filmRollList: List<FilmRoll> = listOf()
    var onItemClick: ((FilmRoll) -> Unit)? = null
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context)
            .inflate(R.layout.list_film_roll, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnLongClickListener {
            setPosition(holder.absoluteAdapterPosition)
            return@setOnLongClickListener false
        }
        holder.bind(filmRollList[position])
    }

    override fun getItemCount(): Int = filmRollList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnCreateContextMenuListener {
        private val textViewTest: TextView = itemView.findViewById<TextView>(R.id.textViewTest)
//        private val numberTextView: TextView = itemView.findViewById<TextView>(R.id.contactNumber)
//        private val initialTextView: TextView = itemView.findViewById<TextView>(R.id.contactInitial)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(filmRollList[absoluteAdapterPosition])
            }
            itemView.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(
            menu: ContextMenu?,
            v: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            MenuInflater(context).inflate(R.menu.film_roll_adapter_menu, menu)
        }

        fun bind(filmRoll: FilmRoll) {
            textViewTest.text = filmRoll.name
//            numberTextView.text = contact.number
//            initialTextView.text = contact.initial
        }
    }

    fun setContacts(filmRollList: List<FilmRoll>) {
        this.filmRollList = filmRollList
        notifyDataSetChanged()
    }

    private var position = 0

    fun getPosition(): Int = position

    private fun setPosition(position: Int) {
        this.position = position
    }
}