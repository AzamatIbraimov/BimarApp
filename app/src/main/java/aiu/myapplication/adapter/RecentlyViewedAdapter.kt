package aiu.myapplication.adapter

import aiu.myapplication.ProductDetails
import aiu.myapplication.R
import aiu.myapplication.adapter.RecentlyViewedAdapter.RecentlyViewedViewHolder
import aiu.myapplication.model.RecentlyViewed
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RecentlyViewedAdapter(private val context: Context, private val recentlyViewedList: List<RecentlyViewed>) : RecyclerView.Adapter<RecentlyViewedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentlyViewedViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recently_viewed_items, parent, false)
        return RecentlyViewedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecentlyViewedViewHolder, position: Int) {
        holder.name.text = recentlyViewedList[position].name
        holder.description.text = recentlyViewedList[position].description
        holder.price.text = recentlyViewedList[position].price
        holder.quantity.text = recentlyViewedList[position].quantity
        holder.unit.text = recentlyViewedList[position].unit
        holder.bg.setBackgroundResource(recentlyViewedList[position].imageUrl)
        holder.itemView.setOnClickListener {
            val i = Intent(context, ProductDetails::class.java)
            i.putExtra("name", recentlyViewedList[position].name)
            i.putExtra("image", recentlyViewedList[position].bigimageUrl)
            i.putExtra("price", recentlyViewedList[position].price)
            i.putExtra("description", recentlyViewedList[position].description)
            i.putExtra("quantity", recentlyViewedList[position].quantity)
            i.putExtra("unit", recentlyViewedList[position].unit)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return recentlyViewedList.size
    }

    class RecentlyViewedViewHolder(itemView: View) : ViewHolder(itemView) {
        var name: TextView
        var description: TextView
        var price: TextView
        var quantity: TextView
        var unit: TextView
        var bg: ConstraintLayout

        init {
            name = itemView.findViewById(R.id.product_name)
            description = itemView.findViewById(R.id.description)
            price = itemView.findViewById(R.id.price)
            quantity = itemView.findViewById(R.id.qty)
            unit = itemView.findViewById(R.id.unit)
            bg = itemView.findViewById(R.id.recently_layout)
        }
    }

}