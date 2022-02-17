package com.hivetech.bookinglunch.repository;

import com.hivetech.bookinglunch.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
