package com.hivetech.bookinglunch.repository;

public interface BookingView {
    int getBookingId();
    String getFullName();
    String getRestaurantName();
    String getDishName();
    int getQuantity();
    String getStatus();
    long getUpdateTime();
}
