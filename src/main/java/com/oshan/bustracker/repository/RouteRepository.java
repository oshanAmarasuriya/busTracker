package com.oshan.bustracker.repository;

import com.oshan.bustracker.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route,Long> {
}
