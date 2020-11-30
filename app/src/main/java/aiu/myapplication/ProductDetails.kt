package aiu.myapplication

import aiu.myapplication.model.Basket
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_basket.*
import java.lang.reflect.Type


class ProductDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val i = intent
        val name = i.getStringExtra("name")
        val image = i.getIntExtra("image", R.drawable.b1)
        val price = i.getStringExtra("price")
        val desc = i.getStringExtra("desc")
        val quantity = i.getStringExtra("quantity")
        val unit = i.getStringExtra("unit")
        val proName = findViewById<TextView>(R.id.productName)
        val proDesc = findViewById<TextView>(R.id.prodDesc)
        val proPrice = findViewById<TextView>(R.id.prodPrice)
        val img = findViewById<ImageView>(R.id.big_image)
        val back = findViewById<ImageView>(R.id.back2)
        val addToBasket = findViewById<ImageView>(R.id.imageView7)
        val cart = findViewById<ImageView>(R.id.cart)
        val proQuantity = findViewById<TextView>(R.id.qty)
        val proUnit = findViewById<TextView>(R.id.unit)
        val button = findViewById<TextView>(R.id.button)

        proName.text = name
        proPrice.text = price
        proDesc.text = desc
        proQuantity.text = quantity
        proUnit.text = unit
        img.setImageResource(image)


        back.setOnClickListener {
            val i = Intent(this@ProductDetails, MainActivity::class.java)
            startActivity(i)
            finish()
        }

        cart.setOnClickListener{
            val i = Intent(this@ProductDetails, BasketActivity::class.java)
            startActivity(i)
        }

        addToBasket.setOnClickListener {
            val basket = price?.let { it1 -> Basket(0, name.toString(), it1) }
            var listb : ArrayList<Basket> = ArrayList<Basket>()
            basket?.let { it1 -> listb.add(it1) }
            saveLessons(listb)
            Toast.makeText(this, "Продукт добавлен в корзину", Toast.LENGTH_SHORT).show()

        }

        button.setOnClickListener {
            Toast.makeText(this, "Заказ успешно отправлен", Toast.LENGTH_SHORT).show()
        }

    }

    private fun saveLessons(list: ArrayList<Basket>){
        val gson =  Gson()
        val myPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE).edit()
        myPrefs.putString("basketObj", gson.toJson(list))
        myPrefs.apply()

    }


}