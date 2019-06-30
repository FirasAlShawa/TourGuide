package com.example.tour_guide;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

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
    //Views
    GridView CategoryGrid;

    //Lists and Adapters
    List<Category> categories;
    CategoryAdapter categoryAdapter;

    //Firebase vars
    DatabaseReference CategoryRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Firebase initializeApp
        FirebaseApp.initializeApp(getApplicationContext());

        //Get Category Reference
        CategoryRef = FirebaseDatabase.getInstance().getReference("Category");

        //get the gridView
        CategoryGrid = findViewById(R.id.CategoryGridView);

        //Arraylist to maintain the categories from Firebase
        categories = new ArrayList<>();

        //Value event listener to get all the data from the "Category" Reference
        CategoryRef.addValueEventListener(displayCategory);

        //init Category Adapter
        categoryAdapter= new CategoryAdapter(this,categories);

        //On Grid View item click
        CategoryGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),categories.get(position).getType(),Toast.LENGTH_LONG).show();
            }
        });


    }

    //ValueEventListener To retrive and display all the categories
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
            System.out.println("Error : "+databaseError.getMessage());
        }
    };

}
