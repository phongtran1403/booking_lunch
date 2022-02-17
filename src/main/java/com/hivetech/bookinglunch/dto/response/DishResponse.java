package com.hivetech.bookinglunch.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DishResponse {
    private Integer dishId;
    private String dishName;
    private Float price;
}
