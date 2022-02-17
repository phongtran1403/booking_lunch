package com.hivetech.bookinglunch.service.implement;

import com.hivetech.bookinglunch.dto.response.DishResponse;
import com.hivetech.bookinglunch.entity.Dish;
import com.hivetech.bookinglunch.repository.DishRepository;
import com.hivetech.bookinglunch.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<DishResponse> getListDish() {
        List<Dish> list = dishRepository.findAll();
        return list.stream().map(item -> DishResponse.builder()
               .dishId(item.getDishId())
               .dishName(item.getDishName())
               .price(item.getPrice())
               .build()).collect(Collectors.toList());
    }

    @Override
    public Dish getDishById(Integer dishId) {
        Dish dish = dishRepository.getById(dishId);
        return dish;
    }

    @Override
    public void saveDish(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public void deleteDish(Dish dish) {
        dishRepository.delete(dish);
    }

    @Override
    public Dish findMainDishByRestaurantIdAndSetId(int restaurantId, int setId){
        return dishRepository.findMainDishByRestaurantIdAndSetId(restaurantId, setId);
    }

    @Override
    public List<Integer> findSideDishIdByRestaurantIdAndSetId(int restaurantId, int setId) {
        return dishRepository.findSideDishIdByRestaurantIdAndSetId(restaurantId, setId);
    }


}
