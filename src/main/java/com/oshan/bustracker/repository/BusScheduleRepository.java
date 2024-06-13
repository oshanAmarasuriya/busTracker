package com.oshan.bustracker.repository;

import com.oshan.bustracker.model.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusScheduleRepository extends JpaRepository<BusSchedule,Long> {
}
