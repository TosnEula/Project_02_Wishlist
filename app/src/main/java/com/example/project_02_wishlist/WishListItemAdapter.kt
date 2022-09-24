package com.example.project_02_wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishListItemAdapter(private val wishListItems: List<WishListItem>) : RecyclerView.Adapter<WishListItemAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Create member variables for any view that will be set
        val itemNameView: TextView
        val itemUrlView: TextView
        val itemPriceView: TextView

        // as you render a row.


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            //  Store each of the layout's views into
            itemNameView = itemView.findViewById(R.id.itemNameTV)
            itemUrlView = itemView.findViewById(R.id.itemUrlTV)
            itemPriceView = itemView.findViewById(R.id.priceTV)
            // the public final member variables created above
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wish_list_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val wishListItem = wishListItems.get(position)
        // Set item views based on views and data model
        holder.itemNameView.text = wishListItem.itemName
        holder.itemUrlView.text = wishListItem.itemUrl
        holder.itemPriceView.text = wishListItem.itemPrice
    }



    override fun getItemCount(): Int {
        return wishListItems.size
    }
}