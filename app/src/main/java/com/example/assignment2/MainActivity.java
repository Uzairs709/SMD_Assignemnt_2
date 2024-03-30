package com.example.assignment2;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
                addNewRestaurantLauncher.launch(intent);
            }
        });


    }
    private ActivityResultLauncher<Intent> addNewRestaurantLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            this::handleActivityResult
    );

    private void handleActivityResult(ActivityResult result) {
        if (result.getResultCode() == RESULT_OK) {
            Intent data = result.getData();
            RestaurantModal restaurantModal = (RestaurantModal) data.getSerializableExtra("newData");
            restaurantModalArrayList.add(restaurantModal);
            restaurantAdapter.notifyItemInserted(restaurantModalArrayList.size() - 1); // Assuming new item goes to the end
        }
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
                "Desi foods",
                5
        ));
        restaurantModalArrayList.add(new RestaurantModal(
                "Sizzling Szechuan",
                "123 Main Street, Cityville",
                "03001234567",
                "Authentic Szechuan cuisine",
                1
        ));

        restaurantModalArrayList.add(new RestaurantModal(
                "The Burger Joint",
                "456 Elm Avenue, Townsville",
                "03009876543",
                "Home of the juiciest burgers in town",
                2
        ));

        restaurantModalArrayList.add(new RestaurantModal(
                "Mama Mia's Pizza",
                "789 Oak Drive, Villageton",
                "03005432109",
                "Handcrafted pizzas made with love",
                5
        ));

        restaurantModalArrayList.add(new RestaurantModal(
                "Golden Dragon Chinese Restaurant",
                "321 Maple Lane, Hamletville",
                "03001112233",
                "Delicious Chinese delicacies served fresh",
                3
        ));

    }
}