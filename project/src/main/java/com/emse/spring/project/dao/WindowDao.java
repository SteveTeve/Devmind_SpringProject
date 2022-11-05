package com.emse.spring.project.dao;

import com.emse.spring.project.model.Window;
import com.emse.spring.project.model.WindowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WindowDao extends JpaRepository<Window, Long>, WindowDaoCustom {
    @Query("SELECT c FROM Window c where c.id=:id")
    Window findByName(@Param("id") Integer id);

    @Modifying
    @Query("delete from Window w where w.room.id=:id")
    void deleteAllWindows(@Param("id")Long id);
}
