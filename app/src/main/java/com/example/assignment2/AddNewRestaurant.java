package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class AddNewRestaurant extends AppCompatActivity {

    TextView newRestaurantName,newLocation,newPhoneNumber,newDescription,addRating;
    Button btnAdd,btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_restaurant);

        init();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resName = newRestaurantName.getText().toString();
                String phoneNumber = newPhoneNumber.getText().toString().trim();
                String location = newLocation.getText().toString();
                String description = newDescription.getText().toString();
                String rating = addRating.getText().toString().trim();
                if (resName.isEmpty()
                        || phoneNumber.isEmpty()
                        || location.isEmpty()
                        || description.isEmpty()
                        || rating.isEmpty()
                ) {
                    Toast.makeText(
                            getApplicationContext(),
                            "Enter all data",
                            Toast.LENGTH_SHORT).show();

                } else {
                    int ratings = Integer.parseInt(rating);
                    RestaurantModal restaurantModal = new RestaurantModal(resName, location,
                            phoneNumber, description, ratings);
                    Intent intent = new Intent();
                    intent.putExtra("newData", restaurantModal);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }

            });
        btnExit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"New data Canceled",Toast.LENGTH_SHORT).show();
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
    private void init(){
        newRestaurantName=findViewById(R.id.addNewRestaurantName);
        newLocation=findViewById(R.id.addNewLocation);
        newPhoneNumber=findViewById(R.id.addNewPhone);
        newDescription=findViewById(R.id.addNewDescription);
        addRating=findViewById(R.id.addRating);

        btnAdd=findViewById(R.id.btnAdd);
        btnExit=findViewById(R.id.btnExit);
    }

}


