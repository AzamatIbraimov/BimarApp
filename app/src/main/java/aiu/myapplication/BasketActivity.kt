package aiu.myapplication

import aiu.myapplication.adapter.BasketAdapter
import aiu.myapplication.model.Basket
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_basket.*
import java.lang.reflect.Type


@Suppress("DEPRECATION")
class BasketActivity: AppCompatActivity() {

    lateinit var adapter: BasketAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)

        val back = findViewById<ImageView>(R.id.back2)
        val order = findViewById<Button>(R.id.order)
        val clean = findViewById<Button>(R.id.clean)

        initList(getLessons())


        back.setOnClickListener {
            finish()
        }

        order.setOnClickListener {
            if (!getLessons()[0].title.equals("")) {
                val list = ArrayList<Basket>()
                val basket = Basket(0, "", "")
                list.add(basket)
                saveLessons(list)
                getLessons().clear()
                initList(getLessons())
                finish()
                Toast.makeText(this, "Заказ успешно отправлен", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "Корзина пуста, вы не можете сделать заказ", Toast.LENGTH_LONG).show()
            }

        }

        clean.setOnClickListener {
            if (!getLessons()[0].title.equals("")) {
                val list = ArrayList<Basket>()
                val basket = Basket(0, "", "")
                list.add(basket)
                saveLessons(list)
                getLessons().clear()
                initList(getLessons())
                Toast.makeText(this, "Корзина очищенна", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Корзина уже пуста", Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun getLessons(): ArrayList<Basket>{
        var gson = Gson()
        val myPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val listType: Type = object : TypeToken<ArrayList<Basket>>() {}.type
        val listJson = myPrefs.getString("basketObj", " ")

        if (listJson == ""){
            return arrayListOf()
        }

        return gson.fromJson(listJson, listType)
    }

    private fun saveLessons(list: ArrayList<Basket>) {
        val gson = Gson()
        val myPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE).edit()
        myPrefs.putString("basketObj", gson.toJson(list))
        myPrefs.apply()
    }

    private fun initList(fastNoteList:List<Basket>) {

        adapter = BasketAdapter(fastNoteList.asReversed())
        adapter.notifyDataSetChanged()
        val layoutManager = LinearLayoutManager(this@BasketActivity)
        recycler_notes.layoutManager = layoutManager
        recycler_notes.adapter = adapter
    }


}