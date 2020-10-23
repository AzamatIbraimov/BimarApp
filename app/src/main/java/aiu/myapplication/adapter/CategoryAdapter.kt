package aiu.myapplication.adapter

import aiu.myapplication.R
import aiu.myapplication.adapter.CategoryAdapter.CategoryViewHolder
import aiu.myapplication.model.Category
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CategoryAdapter(private val context: Context, private val categoryList: List<Category>) : RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_row_items, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.categoryImage.setImageResource(categoryList[position].imageUrl)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class CategoryViewHolder(itemView: View) : ViewHolder(itemView) {
        var categoryImage: ImageView

        init {
            categoryImage = itemView.findViewById(R.id.categoryImage)
        }
    }

}