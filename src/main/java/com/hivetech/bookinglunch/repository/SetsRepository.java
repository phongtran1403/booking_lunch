package com.hivetech.bookinglunch.repository;

import com.hivetech.bookinglunch.entity.Sets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.List;

import java.util.List;

import java.util.List;

public interface SetsRepository extends JpaRepository<Sets, Integer> {
    @Query("SELECT s FROM Sets s WHERE s.restaurant.restaurantId = ?1")
    List<Sets> findByRestaurantID(int restaurantId);

}
