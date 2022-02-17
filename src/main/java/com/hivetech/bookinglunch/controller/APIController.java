package com.hivetech.bookinglunch.controller;

import com.hivetech.bookinglunch.entity.Restaurant;
import com.hivetech.bookinglunch.service.DishService;
import com.hivetech.bookinglunch.service.DishSetService;
import com.hivetech.bookinglunch.service.RestaurantService;
import com.hivetech.bookinglunch.service.SetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/")
public class APIController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private DishService dishService;

    @Autowired
    private SetsService setsService;

    @Autowired
    private DishSetService dishSetService;

    @PostMapping("restaurant/save")
    public void saveRestaurant(@RequestBody Restaurant request) {
        restaurantService.saveRestaurant(request);
    }
}
