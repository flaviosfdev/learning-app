package br.com.fsdev.learningapp.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.fsdev.learningapp.ui.list.ListAdapter.ViewHolder
import androidx.recyclerview.widget.RecyclerView
import br.com.fsdev.learningapp.databinding.ItemRowBinding
import br.com.fsdev.learningapp.domain.Character

class ListAdapter : RecyclerView.Adapter<ViewHolder>() {

    inner class ViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    private var items: MutableList<Character> = mutableListOf()
    var onClick: ((Character) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (items.isEmpty())
            return

        holder.binding.apply {
            val item = items[position]
            itemRowTitle.text = item.name
            itemRowDescription.text = item.status.name
            root.setOnClickListener { onClick?.invoke(item) }
        }
    }

    override fun getItemCount(): Int = items.size

    fun addItems(itemsToAdd: List<Character>) {
        items.addAll(itemsToAdd)
        notifyDataSetChanged()
    }

}