package com.ensemble.ensemble_core.repository;

import com.ensemble.ensemble_core.model.Coupon;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    ArrayList<Coupon> findCouponCodeByCanBeUsedAt(int restaurantId);

    @Transactional
    @Modifying
    @Query("update Coupons c set c.canBeUsedAt = ?1 where c.couponId = ?2")
    void updateCoupon(int restaurantId, int couponId);
}
