package aiu.myapplication.adapter

import aiu.myapplication.R
import aiu.myapplication.adapter.AllCategoryAdapter.AllCategoryViewHolder
import aiu.myapplication.model.AllCategoryModel
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class AllCategoryAdapter(private val context: Context, private val categoryList: List<AllCategoryModel>) : RecyclerView.Adapter<AllCategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.all_category_row_items, parent, false)
        return AllCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllCategoryViewHolder, position: Int) {
        holder.categoryImage.setImageResource(categoryList[position].imageUrl)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class AllCategoryViewHolder(itemView: View) : ViewHolder(itemView) {
        var categoryImage: ImageView

        init {
            categoryImage = itemView.findViewById(R.id.categoryImage)
        }
    }

}