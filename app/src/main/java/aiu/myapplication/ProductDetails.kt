package aiu.myapplication

import aiu.myapplication.ProductDetails
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
        val proQuantity = findViewById<TextView>(R.id.qty)
        val proUnit = findViewById<TextView>(R.id.unit)
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
    }
}