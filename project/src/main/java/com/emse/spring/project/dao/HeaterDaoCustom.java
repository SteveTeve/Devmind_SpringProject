package com.emse.spring.project.dao;

import com.emse.spring.project.model.Heater;

import java.util.List;

public interface HeaterDaoCustom {
    List<Heater> findHeatersByRoomName(String name);
}