package com.aou.productapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.aou.productapp.model.ProductsItem
import com.bumptech.glide.Glide

class ProductAdapter(var items: List<ProductsItem?>?) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items?.get(position)


        var percent = item?.discountPercentage
        val stringValue: String = percent.toString()
        val doublePercent: Double = stringValue.toDouble()
        var dicount = item?.price?.minus(((doublePercent / 100) * 100))



        holder.title.setText(item?.title)
        holder.description.setText(item?.description)

        holder.price.setText("EGP " + dicount.toString())

        holder.discountPrice.setText(item?.price.toString() + " EGP")

        holder.review.setText("Review (" + item?.rating.toString() + ")")




        Glide.with(holder.itemView)
            .load(item?.thumbnail)
            .into(holder.image)

    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    fun changeData(data: List<ProductsItem?>?) {
        items = data
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image: ImageView = itemView.findViewById(R.id.image)
        val title: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.description)
        val price: TextView = itemView.findViewById(R.id.price)
        val discountPrice: TextView = itemView.findViewById(R.id.discount_price)
        val review: TextView = itemView.findViewById(R.id.review)

    }


}