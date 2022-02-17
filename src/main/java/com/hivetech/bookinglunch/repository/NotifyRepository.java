package com.hivetech.bookinglunch.repository;

import com.hivetech.bookinglunch.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface NotifyRepository extends JpaRepository<Booking, Integer> {
    @Query(value = "SELECT * FROM Booking WHERE user_id = ?1 AND booking_date between ?2 and ?3", nativeQuery = true)
    List<Booking> notify(int userId, Date currentDate, java.util.Date currentTime);
}
