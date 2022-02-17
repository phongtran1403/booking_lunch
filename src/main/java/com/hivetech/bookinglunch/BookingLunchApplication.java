package com.hivetech.bookinglunch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BookingLunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingLunchApplication.class, args);
    }

}
