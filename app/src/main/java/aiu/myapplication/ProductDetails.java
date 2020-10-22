package aiu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent i = getIntent();

        String name = i.getStringExtra("name");
        int image = i.getIntExtra("image", R.drawable.b1);
        String price = i.getStringExtra("price");
        String desc = i.getStringExtra("desc");
        String qty = i.getStringExtra("qty");
        String unit = i.getStringExtra("unit");

        TextView proName = findViewById(R.id.productName);
        TextView proDesc = findViewById(R.id.prodDesc);
        TextView proPrice = findViewById(R.id.prodPrice);
        ImageView img = findViewById(R.id.big_image);
        ImageView back = findViewById(R.id.back2);
        TextView proQty = findViewById(R.id.qty);
        TextView proUnit = findViewById(R.id.unit);

        proName.setText(name);
        proPrice.setText(price);
        proDesc.setText(desc);
        proQty.setText(qty);
        proUnit.setText(unit);


        img.setImageResource(image);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ProductDetails.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });

    }


}
