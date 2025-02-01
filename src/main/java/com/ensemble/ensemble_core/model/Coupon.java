package com.ensemble.ensemble_core.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Coupons")
@Table(name="Coupons")
@Data
public class Coupon {
    @SequenceGenerator(name="coupon_sequence",sequenceName ="coupon_sequence",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coupon_sequence")
    @Id
    private int couponId;
    private String title;
    private String couponCode;
    private int canBeUsedAt;
    private String sourcedAt;
}
