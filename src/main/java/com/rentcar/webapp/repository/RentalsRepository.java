package com.rentcar.webapp.repository;

import com.rentcar.webapp.entity.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsRepository extends JpaRepository<Rentals, Long> {
}
