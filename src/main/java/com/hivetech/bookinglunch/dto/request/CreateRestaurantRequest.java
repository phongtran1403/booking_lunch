package com.hivetech.bookinglunch.dto.request;

import lombok.Data;

import java.util.List;


@Data
public class CreateRestaurantRequest {
    private String restaurantName;
    private String address;
    private String phoneNumber;
    private Boolean status;
    private List<SetsRequest> sets;
}
