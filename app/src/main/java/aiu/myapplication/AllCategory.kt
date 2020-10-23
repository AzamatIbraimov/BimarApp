package aiu.myapplication

import aiu.myapplication.AllCategory
import aiu.myapplication.adapter.AllCategoryAdapter
import aiu.myapplication.model.AllCategoryModel
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class AllCategory : AppCompatActivity() {
    private var AllCategoryRecycler: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_category)
        AllCategoryRecycler = findViewById(R.id.all_category)
        val back = findViewById<ImageView>(R.id.back)
        back.setOnClickListener {
            val back = Intent(this@AllCategory, MainActivity::class.java)
            startActivity(back)
            finish()
        }


        // adding data to model
        val allCategoryModelList: MutableList<AllCategoryModel> = ArrayList()
        allCategoryModelList.add(AllCategoryModel(1, R.drawable.ic_fruits))
        allCategoryModelList.add(AllCategoryModel(2, R.drawable.ic_veggies))
        allCategoryModelList.add(AllCategoryModel(3, R.drawable.ic_meat))
        allCategoryModelList.add(AllCategoryModel(4, R.drawable.ic_fish))
        allCategoryModelList.add(AllCategoryModel(5, R.drawable.ic_spices))
        allCategoryModelList.add(AllCategoryModel(6, R.drawable.ic_egg))
        allCategoryModelList.add(AllCategoryModel(7, R.drawable.ic_drink))
        allCategoryModelList.add(AllCategoryModel(8, R.drawable.ic_cookies))
        allCategoryModelList.add(AllCategoryModel(8, R.drawable.ic_juce))
        setCategoryRecycler(allCategoryModelList)
    }

    private fun setCategoryRecycler(allcategoryModelList: List<AllCategoryModel>) {
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 4)
        AllCategoryRecycler!!.layoutManager = layoutManager
        AllCategoryRecycler!!.addItemDecoration(GridSpacingItemDecoration(4, dpToPx(), true))
        AllCategoryRecycler!!.itemAnimator = DefaultItemAnimator()
        val allCategoryAdapter = AllCategoryAdapter(this, allcategoryModelList)
        AllCategoryRecycler!!.adapter = allCategoryAdapter
    }
    // now we need some item decoration class for manage spacing
    /**
     * Converting dp to pixel
     */
    private fun dpToPx(): Int {
        val r = resources
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, r.displayMetrics))
    }
}