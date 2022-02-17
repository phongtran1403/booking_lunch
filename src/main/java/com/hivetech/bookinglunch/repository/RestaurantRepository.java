package com.hivetech.bookinglunch.repository;

import com.hivetech.bookinglunch.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Query(value = "SELECT " +
            "res.restaurant_id   AS restaurantId ," +
            "res.restaurant_name AS restaurantName ," +
            "res.address         AS address ," +
            "res.phone_number    AS phoneNumber , " +
            "res.status AS status," +
            "array_to_string(array_agg (sets.set_name),',','*')  AS setName " +
            "FROM " +
            "public.restaurant AS res " +
            "INNER JOIN public.sets " +
            "ON res.restaurant_id = sets.restaurant_id " +
            "where (:setname is null or sets.set_name in (:setname)) "+
            "and (:keyword is null or res.restaurant_name like (concat('%', :keyword,'%')) "+
            "or res.phone_number like (concat('%', :keyword,'%'))  "+
            "or res.address like concat('%', :keyword , '%')) " +
            "and res.status in (:stt) "+
            "GROUP BY res.restaurant_id " +
            "ORDER BY res.restaurant_id ",
            nativeQuery = true)
    Page<RestaurantView> viewRestaurantsPage(Pageable pageable,@Param("setname") List<String> setname
            , @Param("keyword") String keyword
            , @Param("stt") List<Boolean> stt);

    @Modifying
    @Query("update Restaurant r set r.status = ?1 where r.restaurantId = ?2")
    @Transactional(rollbackFor=Exception.class)
    int setRestaurantByStatus(Boolean status, Integer restaurantId);

}
