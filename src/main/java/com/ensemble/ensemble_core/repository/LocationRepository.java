package com.ensemble.ensemble_core.repository;

import com.ensemble.ensemble_core.model.Coupon;
import com.ensemble.ensemble_core.model.Location;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    Location findOneByAddress(String address);
}
