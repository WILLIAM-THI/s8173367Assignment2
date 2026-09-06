package com.example.s8173367assignment2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.s8173367assignment2.R
import com.example.s8173367assignment2.data.Entity

class EntityAdapter(private val onItemClick: (Entity) -> Unit) :
    RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    private var dataset: List<Entity> = emptyList()

    fun updateData(newData: List<Entity>) {
        dataset = newData
        notifyDataSetChanged() // Refreshes the UI whenever new data arrives from the API
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(item, onItemClick)
    }

    override fun getItemCount(): Int = dataset.size

    class EntityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Obtains references to view components
        private val tvProp1: TextView = view.findViewById(R.id.tvProperty1)
        private val tvProp2: TextView = view.findViewById(R.id.tvProperty2)

        fun bind(entity: Entity, onItemClick: (Entity) -> Unit) {
            tvProp1.text = entity.property1
            tvProp2.text = entity.property2
            // Triggers navigation action
            itemView.setOnClickListener { onItemClick(entity) }
        }
    }
}
