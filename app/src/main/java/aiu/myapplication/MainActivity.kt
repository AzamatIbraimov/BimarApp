package aiu.myapplication

import aiu.myapplication.MainActivity
import aiu.myapplication.adapter.CategoryAdapter
import aiu.myapplication.adapter.DiscountedProductAdapter
import aiu.myapplication.adapter.RecentlyViewedAdapter
import aiu.myapplication.model.Category
import aiu.myapplication.model.DiscountedProducts
import aiu.myapplication.model.RecentlyViewed
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    private var discountRecyclerView: RecyclerView? = null
    private var categoryRecyclerView: RecyclerView? = null
    private var recentlyViewedRecycler: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        discountRecyclerView = findViewById(R.id.discountedRecycler)
        val basketIMV = findViewById<ImageView>(R.id.imageView)
        categoryRecyclerView = findViewById(R.id.categoryRecycler)
        val allCategory = findViewById<TextView>(R.id.allCategoryImage)
        recentlyViewedRecycler = findViewById(R.id.recently_item)
        allCategory.setOnClickListener {
            val i = Intent(this@MainActivity, AllCategory::class.java)
            startActivity(i)
        }
        basketIMV.setOnClickListener {
            val i = Intent(this@MainActivity, BasketActivity::class.java)
            startActivity(i)
        }

        // adding data to model
        val discountedProductsList: MutableList<DiscountedProducts> = ArrayList()
        discountedProductsList.add(DiscountedProducts(1, R.drawable.discountberry))
        discountedProductsList.add(DiscountedProducts(2, R.drawable.discountbrocoli))
        discountedProductsList.add(DiscountedProducts(3, R.drawable.discountmeat))
        discountedProductsList.add(DiscountedProducts(4, R.drawable.discountberry))
        discountedProductsList.add(DiscountedProducts(5, R.drawable.discountbrocoli))
        discountedProductsList.add(DiscountedProducts(6, R.drawable.discountmeat))

//        // adding data to model
        val categoryList: MutableList<Category> = ArrayList()
        categoryList.add(Category(1, R.drawable.ic_home_fruits))
        categoryList.add(Category(2, R.drawable.ic_home_fish))
        categoryList.add(Category(3, R.drawable.ic_home_meats))
        categoryList.add(Category(4, R.drawable.ic_home_veggies))
        categoryList.add(Category(5, R.drawable.ic_home_fruits))
        categoryList.add(Category(6, R.drawable.ic_home_fish))
        categoryList.add(Category(7, R.drawable.ic_home_meats))
        categoryList.add(Category(8, R.drawable.ic_home_veggies))

        // adding data to model
        val recentlyViewedList: MutableList<RecentlyViewed> = ArrayList()
        recentlyViewedList.add(RecentlyViewed("Арбуз", "Очень богат арбуз магнием, половина суточной дозы которого содержится всего в ста граммах арбузной мякоти.", "⊆ 80", "1", "KG", R.drawable.card4, R.drawable.b4))
        recentlyViewedList.add(RecentlyViewed("Папая", "Папайя богата витаминами А и С. В одном свежем плоде средних размеров содержится 3 суточных нормы витамина С.", "⊆ 85", "1", "KG", R.drawable.card3, R.drawable.b3))
        recentlyViewedList.add(RecentlyViewed("Клубника", "Клубника содержит массу полезных веществ и является одним из главных источников минералов.", "⊆ 30", "1", "KG", R.drawable.card2, R.drawable.b1))
        recentlyViewedList.add(RecentlyViewed("Киви", "Киви богат пектиновыми веществами, которые выводят шлаки и токсины из организма, устраняют запоры.", "⊆ 30", "1", "KG", R.drawable.card1, R.drawable.b2))
        setDiscountedRecycler(discountedProductsList)
        setCategoryRecycler(categoryList)
        setRecentlyViewedRecycler(recentlyViewedList)
    }

    private fun setDiscountedRecycler(dataList: List<DiscountedProducts>) {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        discountRecyclerView!!.layoutManager = layoutManager
        val discountedProductAdapter = DiscountedProductAdapter(this, dataList)
        discountRecyclerView!!.adapter = discountedProductAdapter
    }

    private fun setCategoryRecycler(categoryDataList: List<Category>) {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView!!.layoutManager = layoutManager
        val categoryAdapter = CategoryAdapter(this, categoryDataList)
        categoryRecyclerView!!.adapter = categoryAdapter
    }

    private fun setRecentlyViewedRecycler(recentlyViewedDataList: List<RecentlyViewed>) {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recentlyViewedRecycler!!.layoutManager = layoutManager
        val recentlyViewedAdapter = RecentlyViewedAdapter(this, recentlyViewedDataList)
        recentlyViewedRecycler!!.adapter = recentlyViewedAdapter
    }
}