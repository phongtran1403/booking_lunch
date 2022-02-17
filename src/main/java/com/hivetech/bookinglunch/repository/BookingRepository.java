package com.hivetech.bookinglunch.repository;

import com.hivetech.bookinglunch.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query(value = "SELECT b.booking_id AS bookingId, u.full_name AS fullName," +
            "r.restaurant_name AS restaurantName," +
            "array_to_string(array_agg(d.dish_name), ',') AS dishName," +
            "b.quantity AS quantity," +
            "b.status AS status," +
            "b.update_time AS updateTime " +
            "FROM booking as b INNER JOIN users as u on b.user_id = u.user_id " +
            "inner join sets as s on b.set_id = s.set_id " +
            "inner join restaurant as r on s.restaurant_id = r.restaurant_id " +
            "inner join dish_set as ds on s.set_id = ds.set_id " +
            "inner join dishes as d on ds.dish_id = d.dish_id " +
            "group by b.booking_date, fullName, restaurantName, quantity, b.status, updateTime, bookingId " +
            "order by b.booking_date desc", nativeQuery = true)
    List<BookingView> viewBooking();

    @Modifying
    @Query("update Booking b set b.status = ?2, b.updateTime = ?3 where b.bookingId = ?1")
    @Transactional(rollbackFor=Exception.class)
    int changeStatus(Integer bookingId, String status, long currentMillis);

    @Query("update Booking b set b.status = 'Đã đặt' where b.status = 'Chưa đặt'")
    int order();
    @Query(value = "SELECT b.booking_id AS bookingId, u.full_name AS fullName," +
            "r.restaurant_name AS restaurantName," +
            "array_to_string(array_agg(d.dish_name), ',') AS dishName," +
            "b.quantity AS quantity," +
            "b.status AS status," +
            "b.update_time AS updateTime " +
            "FROM booking as b INNER JOIN users as u on b.user_id = u.user_id " +
            "inner join sets as s on b.set_id = s.set_id " +
            "inner join restaurant as r on s.restaurant_id = r.restaurant_id " +
            "inner join dish_set as ds on s.set_id = ds.set_id " +
            "inner join dishes as d on ds.dish_id = d.dish_id " +
            "group by b.booking_date, fullName, restaurantName, quantity, b.status, updateTime, bookingId " +
            "order by b.booking_date desc", nativeQuery = true)
    List<BookingView> exportBookingExcelFile();
}
