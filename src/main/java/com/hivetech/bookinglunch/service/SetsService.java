package com.hivetech.bookinglunch.service;

import com.hivetech.bookinglunch.entity.Sets;

import java.util.List;

public interface SetsService {
    List<Sets> getListSet();
    void saveSet(Sets sets);
    void deleteSet(Sets sets);
    List<Sets> findByRestaurantID(int restaurantId);
}
