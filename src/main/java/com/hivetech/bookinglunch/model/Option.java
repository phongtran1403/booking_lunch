package com.hivetech.bookinglunch.model;

import com.hivetech.bookinglunch.entity.Dish;
import lombok.Data;

import java.util.List;

@Data
public class Option {
    Integer mainDish;
    List<Integer> sideDish;
    Integer setId;
}
