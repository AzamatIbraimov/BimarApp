package aiu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import aiu.myapplication.adapter.CategoryAdapter;
import aiu.myapplication.adapter.DiscountedProductAdapter;
import aiu.myapplication.adapter.RecentlyViewedAdapter;
import aiu.myapplication.model.Category;
import aiu.myapplication.model.DiscountedProducts;
import aiu.myapplication.model.RecentlyViewed;


public class MainActivity extends AppCompatActivity {

    private RecyclerView discountRecyclerView, categoryRecyclerView, recentlyViewedRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        TextView allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);


        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AllCategory.class);
                startActivity(i);
            }
        });

        // adding data to model
        List<DiscountedProducts> discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1, R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(2, R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(3, R.drawable.discountmeat));
        discountedProductsList.add(new DiscountedProducts(4, R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(5, R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(6, R.drawable.discountmeat));

//        // adding data to model
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, R.drawable.ic_home_fruits));
        categoryList.add(new Category(2, R.drawable.ic_home_fish));
        categoryList.add(new Category(3, R.drawable.ic_home_meats));
        categoryList.add(new Category(4, R.drawable.ic_home_veggies));
        categoryList.add(new Category(5, R.drawable.ic_home_fruits));
        categoryList.add(new Category(6, R.drawable.ic_home_fish));
        categoryList.add(new Category(7, R.drawable.ic_home_meats));
        categoryList.add(new Category(8, R.drawable.ic_home_veggies));

        // adding data to model
        List<RecentlyViewed> recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Арбуз", "Очень богат арбуз таким химическим элементом, как магний, половина суточной дозы которого содержится всего в ста граммах арбузной мякоти.", "⊆ 80", "1", "KG", R.drawable.card4, R.drawable.b4));
        recentlyViewedList.add(new RecentlyViewed("Папая", "Папайя богата витаминами А и С. В одном свежем плоде средних размеров содержится 3 суточных нормы витамина С и около 60% суточной нормы витамина А.", "⊆ 85", "1", "KG", R.drawable.card3, R.drawable.b3));
        recentlyViewedList.add(new RecentlyViewed("Клубника", "Клубника содержит массу полезных веществ и является одним из главных источников минералов.", "⊆ 30", "1", "KG", R.drawable.card2, R.drawable.b1));
        recentlyViewedList.add(new RecentlyViewed("Киви", "Киви богат пектиновыми веществами, которые выводят шлаки и токсины из организма, налаживают работу кишечника, устраняют запоры.", "⊆ 30", "1", "KG", R.drawable.card1, R.drawable.b2));

        setDiscountedRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);

    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        discountRecyclerView.setLayoutManager(layoutManager);
        DiscountedProductAdapter discountedProductAdapter = new DiscountedProductAdapter(this, dataList);
        discountRecyclerView.setAdapter(discountedProductAdapter);
    }


    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        RecentlyViewedAdapter recentlyViewedAdapter = new RecentlyViewedAdapter(this, recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }
}
