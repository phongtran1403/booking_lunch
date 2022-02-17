package com.hivetech.bookinglunch.service.implement;

import com.hivetech.bookinglunch.entity.Sets;
import com.hivetech.bookinglunch.repository.SetsRepository;
import com.hivetech.bookinglunch.service.SetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetsServiceImpl implements SetsService {

    @Autowired
    private SetsRepository setsRepository;

    @Override
    public List<Sets> getListSet() {
        List<Sets> list = setsRepository.findAll();
        return list;
    }

    @Override
    public void saveSet(Sets sets) {

        setsRepository.save(sets);
    }

    @Override
    public void deleteSet(Sets sets) {
        setsRepository.delete(sets);
    }

    @Override
    public List<Sets> findByRestaurantID(int restaurantId){
        List<Sets> list = setsRepository.findByRestaurantID(restaurantId);
        return list;
    }
}
