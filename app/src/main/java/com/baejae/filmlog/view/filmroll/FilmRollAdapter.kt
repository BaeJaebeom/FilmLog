package com.baejae.filmlog.view.filmroll

import android.content.Context
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.baejae.filmlog.R
import com.baejae.filmlog.data.database.FilmRoll

class FilmRollAdapter : RecyclerView.Adapter<FilmRollAdapter.ViewHolder>() {
    var filmRollList: List<FilmRoll> = listOf()
    var onItemClick: ((FilmRoll) -> Unit)? = null
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val filmRollListView = LayoutInflater.from(context)
            .inflate(R.layout.list_film_roll, parent, false)
        return ViewHolder(filmRollListView)
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
        private val nameTextView: TextView = itemView.findViewById(R.id.listFilmRollNameTextView)
        private val cameraTextView: TextView = itemView.findViewById(R.id.listFilmRollCameraTextView)
        private val filmTextView: TextView = itemView.findViewById(R.id.listFilmRollFilmTextView)
        private val statusTextView: TextView = itemView.findViewById(R.id.listFilmRollStatusTextView)
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
            when(filmRollList[absoluteAdapterPosition].status){
                context.getString(R.string.status_active) ->{
                    menu?.findItem(R.id.filmRollAdapterMenuWorkflowActive)?.isChecked = true
                }
                context.getString(R.string.status_processed) ->{
                    menu?.findItem(R.id.filmRollAdapterMenuWorkflowProcessed)?.isChecked = true
                }
                context.getString(R.string.status_digitised) ->{
                    menu?.findItem(R.id.filmRollAdapterMenuWorkflowDigitised)?.isChecked = true
                }
                context.getString(R.string.status_printed) ->{
                    menu?.findItem(R.id.filmRollAdapterMenuWorkflowPrinted)?.isChecked = true
                }
                context.getString(R.string.status_archived) ->{
                    menu?.findItem(R.id.filmRollAdapterMenuWorkflowArchived)?.isChecked = true
                }
            }
        }

        fun bind(filmRoll: FilmRoll) {
            nameTextView.text = filmRoll.name
            cameraTextView.text = filmRoll.camera
            filmTextView.text = filmRoll.film
            statusTextView.text = filmRoll.status
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