package com.example.assignment2;

import java.util.Objects;

public class RestaurantModal {
    private String name;
    private String location;
    private String phoneNumber;
    private String description;

    public RestaurantModal(String name, String location, String phoneNumber, String description) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantModal that = (RestaurantModal) o;
        return Objects.equals(name, that.name) && Objects.equals(location, that.location) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(description, that.description);
    }

}
