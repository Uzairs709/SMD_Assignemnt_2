package com.example.assignment2;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvRestaurants;
    RestaurantAdapter restaurantAdapter;
    ArrayList<RestaurantModal> restaurantModalArrayList;
    Button btnAddRestaurant;
    SearchView search_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        rvRestaurants.setHasFixedSize(true);
        restaurantAdapter =new RestaurantAdapter(restaurantModalArrayList);

        rvRestaurants.setLayoutManager(new LinearLayoutManager(this));
        rvRestaurants.setAdapter(restaurantAdapter);
        btnAddRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddNewRestaurant.class);
                startActivityForResult(intent,1);
            }
        });
    }
    private void init(){
        rvRestaurants=findViewById(R.id.rvRestaurants);
        btnAddRestaurant=findViewById(R.id.btnAddNewRestaurant);
        search_bar=findViewById(R.id.search_bar);

        restaurantModalArrayList=new ArrayList<>();

        restaurantModalArrayList.add(new RestaurantModal(
                "Pind",
                "Thoker Niaz Baig",
                "03001020450",
                "Desi foods"));
        restaurantModalArrayList.add(new RestaurantModal(
                "Sizzling Szechuan",
                "123 Main Street, Cityville",
                "03001234567",
                "Authentic Szechuan cuisine"
        ));

        restaurantModalArrayList.add(new RestaurantModal(
                "The Burger Joint",
                "456 Elm Avenue, Townsville",
                "03009876543",
                "Home of the juiciest burgers in town"
        ));

        restaurantModalArrayList.add(new RestaurantModal(
                "Mama Mia's Pizza",
                "789 Oak Drive, Villageton",
                "03005432109",
                "Handcrafted pizzas made with love"
        ));

        restaurantModalArrayList.add(new RestaurantModal(
                "Golden Dragon Chinese Restaurant",
                "321 Maple Lane, Hamletville",
                "03001112233",
                "Delicious Chinese delicacies served fresh"
        ));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==RESULT_OK){
            RestaurantModal restaurantModal=(RestaurantModal) Objects.requireNonNull(data).getSerializableExtra("newData");
            restaurantModalArrayList.add(restaurantModal);
            restaurantAdapter.notifyDataSetChanged();
        }
    }
}