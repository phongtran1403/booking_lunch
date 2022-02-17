package com.hivetech.bookinglunch.repository;

import com.hivetech.bookinglunch.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
