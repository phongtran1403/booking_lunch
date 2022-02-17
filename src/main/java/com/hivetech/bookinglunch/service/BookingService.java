package com.hivetech.bookinglunch.service;

import com.hivetech.bookinglunch.entity.Booking;
import com.hivetech.bookinglunch.entity.Sets;
import com.hivetech.bookinglunch.repository.BookingView;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface BookingService {
    List<BookingView> getListBooking();
    boolean notify(int userId);
    int changeBookingStatus(int bookingId, String status);
    int cancelBooking(int bookingId);
    void saveBooking(Booking booking);
    void deleteBooking(int bookingId);
    ByteArrayInputStream exportBookingExcelFile();
}
