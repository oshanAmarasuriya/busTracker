package com.oshan.bustracker.repository;

import com.oshan.bustracker.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Long> {
}
