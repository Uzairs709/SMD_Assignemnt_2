package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;

public class AddNewRestaurant extends AppCompatActivity {

    TextView newRestaurantName,newLocation,newPhoneNumber,newDescription;
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
                String phoneNumber=newPhoneNumber.getText().toString().trim();
                String location=newLocation.getText().toString();
                String description=newDescription.getText().toString();

                if(resName.isEmpty()
                        ||phoneNumber.isEmpty()
                        ||location.isEmpty()
                        ||description.isEmpty())
                {
                    Toast.makeText(
                            getApplicationContext(),
                            "Enter all data",
                            Toast.LENGTH_SHORT).show();

                }else{
                    RestaurantModal restaurantModal=new RestaurantModal(resName,location,phoneNumber,description);
                    Intent intent=new Intent();
                    intent.putExtra("newData", (Serializable) restaurantModal);
                    setResult(RESULT_OK,intent);
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

        btnAdd=findViewById(R.id.btnAdd);
        btnExit=findViewById(R.id.btnExit);
    }
}