package ru.alexkubrick.hotdog.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.alexkubrick.hotdog.R
import ru.alexkubrick.hotdog.data.HotdogDataClass

class FlavorAdapter(
    private val context: Context,
    private val dataset: List<HotdogDataClass>,
    private val onClick: (flavor: String) -> Unit
): RecyclerView.Adapter<FlavorAdapter.FlavorHolder>()  {

    class FlavorHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.order_name)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlavorHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_list, parent, false)

        return FlavorHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size
    
    override fun onBindViewHolder(holder: FlavorHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)

        holder.itemView.setOnClickListener {
            onClick(context.getString(item.stringResourceId))
        }
    }
}