package com.emse.spring.project.dao;

import com.emse.spring.project.model.Heater;
import com.emse.spring.project.model.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuildingDao extends JpaRepository<Heater, Long> {

    @Query("SELECT w FROM Window w where w.room.building.id=:id")
    List<Window> findWindowsByBuilding(@Param("id") Long id);

}
