package com.example.assignment2;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    ArrayList<RestaurantModal> restaurants;

    public RestaurantAdapter(ArrayList<RestaurantModal> restaurants) {
        this.restaurants = restaurants;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurant_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RestaurantModal restaurant = restaurants.get(position);

        holder.restaurantName.setText(restaurant.getName());
        holder.location.setText(restaurant.getLocation());
        holder.phoneNumber.setText(restaurant.getPhoneNumber()+"");
        holder.description.setText(restaurant.getDescription());
        holder.rating.setText(restaurant.getRating()+"");

    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView restaurantName,location,phoneNumber,description,rating;
        ImageButton phoneBtn,messageBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantName=itemView.findViewById(R.id.restaurantName);
            location=itemView.findViewById(R.id.location);
            phoneNumber=itemView.findViewById(R.id.phoneNumber);
            description=itemView.findViewById(R.id.description);
            rating=itemView.findViewById(R.id.ratings);

            messageBtn=itemView.findViewById(R.id.messageBtn);
            phoneBtn=itemView.findViewById(R.id.phoneBtn);

            phoneBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber.getText()));
                    itemView.getContext().startActivity(intent);
                }
            });

            messageBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("sms:"+phoneNumber.getText()));
                    itemView.getContext().startActivity(intent);
                }
            });

            location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+location.getText().toString()));
                    itemView.getContext().startActivity(intent);

                }
            });
        }

    }

    public void filterList(ArrayList<RestaurantModal> filteredList) {
        restaurants = filteredList;
        notifyDataSetChanged();
    }
}
