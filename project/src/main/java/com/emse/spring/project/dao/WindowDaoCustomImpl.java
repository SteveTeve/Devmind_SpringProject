package com.emse.spring.project.dao;

import com.emse.spring.project.model.Window;
import com.emse.spring.project.model.WindowStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class WindowDaoCustomImpl implements WindowDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findRoomOpenWindows(Long id) {
        String jpql = "select w from Window w where w.room.id = :id and w.window_Status= :status";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();
    }

    @Override
    public List<Window> findWindowsByRoomName(String name) {
        String jpql = "select w from Window w where w.room.name= :name";
        return em.createQuery(jpql, Window.class)
                .setParameter("name",name)
                .getResultList();
    }
}