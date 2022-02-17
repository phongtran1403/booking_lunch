package com.hivetech.bookinglunch.service.implement;

import com.hivetech.bookinglunch.entity.DishSet;
import com.hivetech.bookinglunch.repository.DishSetRepository;
import com.hivetech.bookinglunch.service.DishSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishSetServiceImpl implements DishSetService {

    @Autowired
    private DishSetRepository dishSetRepository;

    @Override
    public List<DishSet> getListDishSet() {
        List<DishSet> list = dishSetRepository.findAll();
        return list;
    }

    @Override
    public DishSet getDishSetById(int id) {
        return dishSetRepository.findById(id).get();
    }

    @Override
    public void saveDishSet(DishSet dishSet) {
        dishSetRepository.save(dishSet);
    }

    @Override
    public void deleteDishSet(DishSet dishSet) {
        dishSetRepository.delete(dishSet);
    }
}
