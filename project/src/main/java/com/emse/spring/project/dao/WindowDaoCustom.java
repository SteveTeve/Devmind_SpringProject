package com.emse.spring.project.dao;

import com.emse.spring.project.model.Window;

import java.util.List;

public interface WindowDaoCustom {
    List<Window> findRoomOpenWindows(Long id);
    List<Window> findWindowsByRoomName(String name);
}