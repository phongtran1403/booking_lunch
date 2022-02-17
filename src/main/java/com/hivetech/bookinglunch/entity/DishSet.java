package com.hivetech.bookinglunch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "dish_set")
public class DishSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_set_id")
    private int dishSetId;

    @ManyToOne
    @JoinColumn(name = "set_id")
    private Sets sets;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Column(name = "is_main_dish")
    private boolean isMainDish;


}
