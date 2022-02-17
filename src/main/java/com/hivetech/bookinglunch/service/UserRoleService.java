package com.hivetech.bookinglunch.service;

import com.hivetech.bookinglunch.entity.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> getListUserRole();
    void saveUserRole(UserRole userRole);
    void deleteUserRole(UserRole userRole);
}
