package com.hivetech.bookinglunch.dto.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.List;

@Data
@JsonAutoDetect
public class SetsRequest {
    private Integer mainDish;
    private List<Integer> sideDishes;
}
