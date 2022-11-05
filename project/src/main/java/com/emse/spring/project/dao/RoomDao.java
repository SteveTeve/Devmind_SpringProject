package com.emse.spring.project.dao;

import com.emse.spring.project.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomDao extends JpaRepository<Room, Long> {
    @Query("SELECT c FROM Room c where c.id=:id")
    Room findByName(@Param("id") Integer id);
}