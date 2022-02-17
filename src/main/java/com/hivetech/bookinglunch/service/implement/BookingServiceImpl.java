package com.hivetech.bookinglunch.service.implement;

import com.hivetech.bookinglunch.entity.Booking;
import com.hivetech.bookinglunch.repository.BookingRepository;
import com.hivetech.bookinglunch.repository.BookingView;
import com.hivetech.bookinglunch.repository.NotifyRepository;
import com.hivetech.bookinglunch.service.BookingService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private NotifyRepository notifyRepository;

    @Override
    public List<BookingView> getListBooking() {
        List<BookingView> list = bookingRepository.viewBooking();
        return list;
    }

    @Override
    public boolean notify(int userId) {
        long millis = System.currentTimeMillis();
        java.sql.Date currentDate = new java.sql.Date(millis);
        Date currentTime = new Date(millis);

        // Lay danh sach booking cua user trong ngay
        List<Booking> list = notifyRepository.notify(userId, currentDate, currentTime);
        //  Neu danh sach trong thi tra ve false
        return !list.isEmpty();
    }

    @Override
    public int changeBookingStatus(int bookingId, String status) {
        long current = System.currentTimeMillis();
        if (status.equals("cd")) {
            return bookingRepository.changeStatus(bookingId, "Đã đặt", current);
        } else {
            return bookingRepository.changeStatus(bookingId, "Chưa đặt", current);
        }
    }

    @Override
    public int cancelBooking(int bookingId) {
        long current = System.currentTimeMillis();
        return bookingRepository.changeStatus(bookingId, "Đã hủy", current);
    }

    @Override
    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public ByteArrayInputStream exportBookingExcelFile() {
        List<BookingView> list = bookingRepository.exportBookingExcelFile();
        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("Export");

            Row row = sheet.createRow(0);

            // Define header cell style
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Creating header cells
            Cell cell = row.createCell(0);
            cell.setCellValue("Người dùng");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Quán ăn ");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(2);
            cell.setCellValue("Thực đơn ");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(3);
            cell.setCellValue("Số lượng");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(4);
            cell.setCellValue("Trạng thái");
            cell.setCellStyle(headerCellStyle);

            // Creating data rows for each contact
            for(int i = 0; i < list.size(); i++) {
                Row dataRow = sheet.createRow(i + 1);
                dataRow.createCell(0).setCellValue(list.get(i).getFullName());
                dataRow.createCell(1).setCellValue(list.get(i).getRestaurantName());
                dataRow.createCell(2).setCellValue(list.get(i).getDishName());
                dataRow.createCell(3).setCellValue(list.get(i).getQuantity());
                dataRow.createCell(4).setCellValue(list.get(i).getStatus());

            }

            // Making size of column auto resize to fit with data
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException ex) {
            logger.error("Error during export Excel file", ex);
            return null;
        }
    }


}
