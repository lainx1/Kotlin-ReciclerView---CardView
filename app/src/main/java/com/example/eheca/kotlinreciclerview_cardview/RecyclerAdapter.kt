package com.example.eheca.kotlinreciclerview_cardview

import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    private val titles = arrayOf("Chapter One", "Chapter Two", "Chapter Three", "Chapter Four", "Chapter Five", "Chapter Six", "Chapter Seven", "Chapter Eight")
    private val details = arrayOf("Item one details", "Item two details", "Item three details", "Item four details", "Item five details", "Item six details", "Item seven details", "Item eight details")
    private val images = arrayOf(R.drawable.android_image_1, R.drawable.android_image_2, R.drawable.android_image_3, R.drawable.android_image_4, R.drawable.android_image_5, R.drawable.android_image_6, R.drawable.android_image_7, R.drawable.android_image_8)

    override fun onCreateViewHolder(viewGrup: ViewGroup, position: Int): ViewHolder {
        val v = LayoutInflater.from(viewGrup.context).inflate(R.layout.card_layout, viewGrup, false)
        return ViewHolder(v)
    }

    override fun getItemCount() = titles.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemTitle.text = titles[position]
        viewHolder.itemDetail.text= details[position]
        viewHolder.itemImage.setImageResource(images[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener { v: View ->
                var position : Int = adapterPosition
                Snackbar.make(v, "Position $position", Snackbar.LENGTH_SHORT ).setAction("Action", null).show()
            }
        }
    }
}