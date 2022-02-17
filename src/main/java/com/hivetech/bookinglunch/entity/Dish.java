package com.hivetech.bookinglunch.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

//@Data
@Getter
@Setter
@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private int dishId;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    private List<DishSet> dishSets;

    @Column(name = "dish_name")
    private String dishName;

    @Column(name = "price")
    private float price;




}
