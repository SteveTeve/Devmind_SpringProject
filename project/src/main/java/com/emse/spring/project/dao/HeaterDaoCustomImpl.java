package com.emse.spring.project.dao;

import com.emse.spring.project.model.Heater;
import com.emse.spring.project.model.HeaterStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HeaterDaoCustomImpl implements HeaterDaoCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Heater> findHeatersByRoomName(String name) {
        String jpql = "select h from Heater h where h.room.name= :name";
        return em.createQuery(jpql, Heater.class)
                .setParameter("name",name)
                .getResultList();
    }
}