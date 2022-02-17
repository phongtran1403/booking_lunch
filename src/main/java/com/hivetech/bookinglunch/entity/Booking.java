package com.hivetech.bookinglunch.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "total_price")
    private float totalPrice;

    @Column(name = "booking_date")
    private Date bookingDate;

    @Column(name = "status")
    private boolean status;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "set_id")
    private Sets sets;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @Column(name = "update_time")
    private long updateTime;
}
