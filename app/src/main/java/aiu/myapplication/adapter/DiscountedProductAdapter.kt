package aiu.myapplication.adapter

import aiu.myapplication.R
import aiu.myapplication.adapter.DiscountedProductAdapter.DiscountedProductViewHolder
import aiu.myapplication.model.DiscountedProducts
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class DiscountedProductAdapter(private val context: Context, private val discountedProductsList: List<DiscountedProducts>) : RecyclerView.Adapter<DiscountedProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountedProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.discounted_row_items, parent, false)
        return DiscountedProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiscountedProductViewHolder, position: Int) {
        holder.discountImageView.setImageResource(discountedProductsList[position].imageurl)
    }

    override fun getItemCount(): Int {
        return discountedProductsList.size
    }

    class DiscountedProductViewHolder(itemView: View) : ViewHolder(itemView) {
        var discountImageView: ImageView

        init {
            discountImageView = itemView.findViewById(R.id.discountImage)
        }
    }

}