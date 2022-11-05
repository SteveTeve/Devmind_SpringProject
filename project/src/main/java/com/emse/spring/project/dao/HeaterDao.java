package com.emse.spring.project.dao;

import com.emse.spring.project.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HeaterDao extends JpaRepository<Heater, Long>, HeaterDaoCustom {
    @Query("SELECT c FROM Heater c where c.id=:id")
    Heater findByName(@Param("id") Integer id);

    @Modifying
    @Query("delete from Heater h where h.room.id=:id")
    void deleteAllHeaters(@Param("id")Long id);
}
