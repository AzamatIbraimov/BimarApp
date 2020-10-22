package aiu.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import aiu.myapplication.adapter.AllCategoryAdapter;
import aiu.myapplication.model.AllCategoryModel;

public class AllCategory extends AppCompatActivity {

    private RecyclerView AllCategoryRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        AllCategoryRecycler = findViewById(R.id.all_category);
        ImageView back = findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(AllCategory.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });


        // adding data to model
        List<AllCategoryModel> allCategoryModelList = new ArrayList<>();
        allCategoryModelList.add(new AllCategoryModel(1, R.drawable.ic_fruits));
        allCategoryModelList.add(new AllCategoryModel(2, R.drawable.ic_veggies));
        allCategoryModelList.add(new AllCategoryModel(3, R.drawable.ic_meat));
        allCategoryModelList.add(new AllCategoryModel(4, R.drawable.ic_fish));
        allCategoryModelList.add(new AllCategoryModel(5, R.drawable.ic_spices));
        allCategoryModelList.add(new AllCategoryModel(6, R.drawable.ic_egg));
        allCategoryModelList.add(new AllCategoryModel(7, R.drawable.ic_drink));
        allCategoryModelList.add(new AllCategoryModel(8, R.drawable.ic_cookies));
        allCategoryModelList.add(new AllCategoryModel(8, R.drawable.ic_juce));


        setCategoryRecycler(allCategoryModelList);

    }

    private void setCategoryRecycler(List<AllCategoryModel> allcategoryModelList) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 4);
        AllCategoryRecycler.setLayoutManager(layoutManager);
        AllCategoryRecycler.addItemDecoration(new GridSpacingItemDecoration(4, dpToPx(), true));
        AllCategoryRecycler.setItemAnimator(new DefaultItemAnimator());
        AllCategoryAdapter allCategoryAdapter = new AllCategoryAdapter(this, allcategoryModelList);
        AllCategoryRecycler.setAdapter(allCategoryAdapter);
    }

    // now we need some item decoration class for manage spacing


    /**
     * Converting dp to pixel
     */
    private int dpToPx() {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, r.getDisplayMetrics()));
    }
}


