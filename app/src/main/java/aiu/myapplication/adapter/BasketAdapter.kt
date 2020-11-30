package aiu.myapplication.adapter

import aiu.myapplication.R
import aiu.myapplication.model.Basket
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.basket_items.view.*

class BasketAdapter(
        private val items: List<Basket>)
    : RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {

    inner class BasketViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title = view.title
        private val price = view.price

        @SuppressLint("LongLogTag", "UseValueOf")
        fun bind(basket: Basket) {

            title.text = basket.title
            price.text = basket.price


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        return BasketViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.basket_items, parent, false)
        )    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        holder.bind(items!![position])
    }

    override fun getItemCount(): Int {
        return items?.size!!
    }

}