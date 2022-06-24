package com.example.image

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.image.databinding.ItemBinding

class FilterAdapter(cxt: Context) : RecyclerView.Adapter<FilterViewHolder>() {
    private var context: Context = cxt;
    private var clickListener: OnItemClickListener? = null
    private var selectPosition = 0

    fun setItemClickListener(listener: OnItemClickListener) {
        this.clickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val layoutInflater = LayoutInflater.from(context);
        val itemBinding = ItemBinding.inflate(layoutInflater)
        itemBinding.root.setOnClickListener {
            val position = it.tag as Int
            clickListener?.onClick(it, position)

            val lastPosition = selectPosition;
            selectPosition = position
            notifyItemChanged(lastPosition)
            notifyItemChanged(selectPosition)
        }
        return FilterViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.binding.filterName.text = FilterData.filters[position].filterName
        if (selectPosition == position) {
            holder.binding.filterName.setBackgroundResource(R.drawable.filter_name_select_shape)
        } else {
            holder.binding.filterName.setBackgroundResource(R.drawable.filter_name_shape)
        }
        holder.binding.root.tag = position

    }

    override fun getItemCount(): Int {
        return FilterData.filters.size
    }

}

interface OnItemClickListener {
    fun onClick(view: View, position: Int)
}

class FilterViewHolder(itemBinding: ItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
    var binding = itemBinding;
}


