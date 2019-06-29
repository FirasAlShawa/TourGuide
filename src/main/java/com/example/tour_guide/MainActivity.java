package com.example.tour_guide;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView CategoryGrid;
    List<Category> categories;
    DatabaseReference CategoryRef;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(getApplicationContext());

        CategoryRef = FirebaseDatabase.getInstance().getReference("Category");

        CategoryGrid = findViewById(R.id.CategoryGridView);
        categories = new ArrayList<>();
        CategoryRef.addValueEventListener(displayCategory);
        categoryAdapter= new CategoryAdapter(this,categories);
//        CategoryGrid.setAdapter(categoryAdapter);

    }
    ValueEventListener displayCategory = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            categories.clear();
            if(dataSnapshot != null){
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Category category = snapshot.getValue(Category.class);
                    categories.add(category);
                }
                System.out.println("End For");
                CategoryGrid.setAdapter(categoryAdapter);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

}
