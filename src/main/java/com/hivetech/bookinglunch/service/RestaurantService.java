package com.hivetech.bookinglunch.service;

import com.hivetech.bookinglunch.entity.Restaurant;
import com.hivetech.bookinglunch.repository.RestaurantView;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RestaurantService {
    ResponseEntity<Map<String, Object>> getListRestaurant(int pageNumber, String setname, String keyword, List<Boolean> bl);
    void saveRestaurant(Restaurant restaurant);
    Restaurant getByRestaurantId(int id);
    public void deleteRestaurant(Restaurant restaurant);
    public Optional<Restaurant> findRestaurantById(int restaurantId);
    public int setStatus(boolean status, int restaurantId);
//    public boolean getStatus(int restaurantId);
}
