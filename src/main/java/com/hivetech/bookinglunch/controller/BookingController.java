package com.hivetech.bookinglunch.controller;

import com.hivetech.bookinglunch.entity.Booking;
import com.hivetech.bookinglunch.repository.BookingView;
import com.hivetech.bookinglunch.service.BookingService;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/booking/saved", method = RequestMethod.POST)
    public String saveBooking(@ModelAttribute("booking") Booking booking) {
        bookingService.saveBooking(booking);
        return "redirect:/booking";
    }

    @RequestMapping(value = "/booking")
    public String showBooking(Model model) {
        // Lay ra danh sach booking
        List<BookingView> list = bookingService.getListBooking();

        // Lay thoi gian hien tai de tinh thoi gian cap nhat
        long current = System.currentTimeMillis();

        // Kiem tra de hien thi thong bao
        boolean notify = bookingService.notify(1);
        model.addAttribute("listBooking", list);
        model.addAttribute("current", current);
        model.addAttribute("notify", notify);
        return "booking";
    }

    @RequestMapping("/booking/{id}/{status}")
    String changeBookingStatus(@PathVariable("id") int bookingId, @PathVariable("status") String status) {
        bookingService.changeBookingStatus(bookingId, status);
        return ("redirect:/booking");
    }

    @RequestMapping("/booking/cancel/{id}")
    String cancelBooking(@PathVariable("id") int bookingId) {
        bookingService.cancelBooking(bookingId);
        return "redirect:/booking";
    }
    @GetMapping("exportFileExcel")
    public void exportBookingExcelFile(HttpServletResponse response) throws IOException {
        ByteArrayInputStream byteArrayInputStream =bookingService.exportBookingExcelFile();
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=Export.xlsx");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());
    }
}
