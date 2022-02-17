package com.hivetech.bookinglunch.service.implement;

import com.hivetech.bookinglunch.entity.Users;
import com.hivetech.bookinglunch.repository.UserRepository;
import com.hivetech.bookinglunch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> getListUser() {
        List<Users> listUser = userRepository.findAll();
        return listUser;
    }

    @Override
    public void saveUser(Users users) {
        userRepository.save(users);
    }

    @Override
    public void deleteUser(Users users) {
        userRepository.delete(users);
    }
}
