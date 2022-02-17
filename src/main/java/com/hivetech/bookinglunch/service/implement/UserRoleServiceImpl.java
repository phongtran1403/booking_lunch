package com.hivetech.bookinglunch.service.implement;

import com.hivetech.bookinglunch.entity.UserRole;
import com.hivetech.bookinglunch.repository.UserRoleRepository;
import com.hivetech.bookinglunch.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> getListUserRole() {

        return null;
    }

    @Override
    public void saveUserRole(UserRole userRole) {

    }

    @Override
    public void deleteUserRole(UserRole userRole) {

    }
}
