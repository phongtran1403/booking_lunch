package com.hivetech.bookinglunch.service.implement;

import com.hivetech.bookinglunch.entity.Restaurant;
import com.hivetech.bookinglunch.entity.Sets;
import com.hivetech.bookinglunch.repository.RestaurantRepository;
import com.hivetech.bookinglunch.repository.RestaurantView;
import com.hivetech.bookinglunch.repository.SetsRepository;
import com.hivetech.bookinglunch.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private SetsRepository setsRepository;

    //    @Autowired
//    private SetsRepository setsRepository;
    @Override
    public ResponseEntity<Map<String, Object>> getListRestaurant(int pageNumber, String setname, String keyword,
                                                                 List<Boolean> status) {
        List<String> setnames = new ArrayList<String>();
        if (setname != null) {
            setnames = List.of(setname.split("\\s"));

        }
        Pageable page;
        page = PageRequest.of(pageNumber, 2);
        Page<RestaurantView> viewPage = restaurantRepository.viewRestaurantsPage(page, setnames, keyword, status);
        List<String> setName = new ArrayList<>();
        setsRepository.findAll().forEach(e -> {
            setName.add(e.getSetName());
        });
        Map<String, Object> result = Map.of(
                "content", viewPage.getContent()
                , "pageSize", viewPage.getPageable().getPageSize()
                , "pageNumber", viewPage.getPageable().getPageNumber()
                , "totalPages", viewPage.getTotalPages()
                , "setN", setName);
        return ResponseEntity.ok(result);
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Restaurant restaurant) {
        restaurantRepository.delete(restaurant);
    }

    @Override
    public Restaurant getByRestaurantId(int id) {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public Optional<Restaurant> findRestaurantById(int restaurantId) {
        return restaurantRepository.findById(restaurantId);
    }

    @Override
    public int setStatus(boolean status, int restaurantId) {
        return restaurantRepository.setRestaurantByStatus(status, restaurantId);
    }


}
