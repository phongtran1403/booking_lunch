package com.hivetech.bookinglunch.repository;

import com.hivetech.bookinglunch.entity.Dish;
import com.hivetech.bookinglunch.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DishRepository extends JpaRepository<Dish, Integer> {
//    select r.restaurant_id, address, phone_number, restaurant_name, s.set_id, set_name, dish_name, is_main_dish, price from restaurant r inner join (sets s inner join (dish_set ds inner join dishes d on ds.dish_id = d.dish_id) on s.set_id = ds.set_id) on r.restaurant_id = s.restaurant_id
//    select dish_name from restaurant r inner join (sets s inner join (dish_set ds inner join dishes d on ds.dish_id = d.dish_id) on s.set_id = ds.set_id) on r.restaurant_id = 1 where is_main_dish=true and s.set_id = 1
//    select * from sets where restaurant_id = 2

//    @Query("select Dish.dishName " +
//            "from Restaurant r " +
//            "inner join Sets s " +
//            "inner join DishSet ds " +
//            "inner join Dish d " +
//            "on ds.dishId = d.dishId " +
//            "on s.setId = ds.setId " +
//            "on r.restaurantId = ?1 " +
//            "where ds.isMainDish = true " +
//            "and s.setId = ?2")

//    @Query("SELECT d.dishName from Dish d INNER JOIN d.dishId INNER JOIN Sets.setId INNER JOIN Restaurant.restaurantId WHERE Restaurant.restaurantId = ?1 and DishSet.isMainDish=true and Sets.setId= 2")

    @Query(value = "select * " +
            "from restaurant r " +
            "inner join sets s " +
            "inner join dish_set ds " +
            "inner join dishes d " +
            "on ds.dish_id = d.dish_id " +
            "on s.set_id = ds.set_id " +
            "on r.restaurant_id = ?1 " +
            "where is_main_dish=true and s.set_id = ?2",
            nativeQuery = true)
   public Dish findMainDishByRestaurantIdAndSetId(int restaurantId, int setId);


    @Query(value = "select d.dish_id " +
            "from restaurant r " +
            "inner join sets s " +
            "inner join dish_set ds " +
            "inner join dishes d " +
            "on ds.dish_id = d.dish_id " +
            "on s.set_id = ds.set_id " +
            "on r.restaurant_id = ?1 " +
            "where is_main_dish=false and s.set_id = ?2",
            nativeQuery = true)
    public List<Integer> findSideDishIdByRestaurantIdAndSetId(int restaurantId, int setId);
}
