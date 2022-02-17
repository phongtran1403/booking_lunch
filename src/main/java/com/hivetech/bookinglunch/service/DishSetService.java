package com.hivetech.bookinglunch.service;

import com.hivetech.bookinglunch.entity.DishSet;

import java.util.List;

public interface DishSetService {
    List<DishSet> getListDishSet();
    DishSet getDishSetById(int id);
    void saveDishSet(DishSet dishSet);
    void deleteDishSet(DishSet dishSet);
}
