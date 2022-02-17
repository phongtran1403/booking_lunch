package com.hivetech.bookinglunch.service;

import com.hivetech.bookinglunch.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> getListUser();
    void saveUser(Users users);
    void deleteUser(Users users);
}
