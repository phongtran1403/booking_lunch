package com.hivetech.bookinglunch.service;

import com.hivetech.bookinglunch.dto.response.DishResponse;
import com.hivetech.bookinglunch.entity.Dish;

import java.util.List;

public interface DishService {
    List<DishResponse> getListDish();
    Dish getDishById (Integer dishId);
    void saveDish(Dish dish);
    void deleteDish(Dish dish);
    Dish findMainDishByRestaurantIdAndSetId(int restaurantId, int setId);
    List<Integer> findSideDishIdByRestaurantIdAndSetId(int restaurantId, int setId);

}
