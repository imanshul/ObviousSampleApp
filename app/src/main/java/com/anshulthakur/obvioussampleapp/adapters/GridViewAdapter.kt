package com.anshulthakur.obvioussampleapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anshulthakur.obvioussampleapp.R
import com.anshulthakur.obvioussampleapp.extensions.loadImageFromUrl
import com.anshulthakur.obvioussampleapp.model.NasaPictureData
import com.anshulthakur.obvioussampleapp.model.PicturesData
import com.anshulthakur.obvioussampleapp.utils.OnItemClick
import kotlinx.android.synthetic.main.item_main_grid_view.view.*

/*
*Created By Anshul Thakur on 2/9/2020.
*/

class GridViewAdapter(val callback:OnItemClick) : RecyclerView.Adapter<GridViewAdapter.PictureViewHolder>(){

    val list = ArrayList<NasaPictureData>()

    fun addData(newList:List<NasaPictureData>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PictureViewHolder(inflater.inflate(R.layout.item_main_grid_view,parent,false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.bindData(list.get(position))
    }

    inner class PictureViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun bindData(data: NasaPictureData) {
            itemView.apply{
                ivThumb.loadImageFromUrl(context,data.url)
                clMainGrid.setOnClickListener {
                    callback.onItemClick(PicturesData(data,adapterPosition,clMainGrid))
                }
            }
        }
    }
}