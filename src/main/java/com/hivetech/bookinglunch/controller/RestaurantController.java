package com.hivetech.bookinglunch.controller;

import com.hivetech.bookinglunch.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/view")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/redirect")
    String view() {
        return "restaurant";
    }

    @GetMapping("restaurant/{pageNumber}")
    @ResponseBody
    ResponseEntity<Map<String, Object>> getPage(@PathVariable int pageNumber
                                             , @RequestParam(value = "setname", required = false) String setname
                                             , @RequestParam(value = "keyword", required = false) String keyword
                                             , @RequestParam(value = "status", required = false) Boolean status) {

        return restaurantService.getListRestaurant(pageNumber, setname, keyword,
                Objects.isNull(status)
                        ? List.of(true, false)
                        : List.of(status));
    }

    @RequestMapping(value = "restaurant/{restaurantId}/{status}")
    public String changeStatus(@PathVariable("restaurantId") String restaurantId,
                               @PathVariable("status") String status) {

        restaurantService.setStatus(!"true".equals(status), Integer.parseInt(restaurantId));
        return "redirect:/view/redirect";
    }



}
