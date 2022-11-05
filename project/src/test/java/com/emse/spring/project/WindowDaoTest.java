package com.emse.spring.project;

import com.emse.spring.project.dao.BuildingDao;
import com.emse.spring.project.model.Window;
import com.emse.spring.project.model.WindowStatus;
import com.emse.spring.project.dao.WindowDao;
import com.emse.spring.project.model.Heater;
import com.emse.spring.project.dao.HeaterDao;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class WindowDaoTest {
    @Autowired
    private WindowDao windowDao;
    @Autowired
    private HeaterDao heaterDao;

    @Autowired
    private BuildingDao buildingDao;

    @Test
    public void shouldFindAWindow() {
        Window window = windowDao.getReferenceById(-10L);
        Assertions.assertThat(window.getName()).isEqualTo("Window 1");
        Assertions.assertThat(window.getWindowStatus()).isEqualTo(WindowStatus.CLOSED);
    }

    @Test
    public void shouldFindRoomOpenWindows() {
        List<Window> result = windowDao.findRoomOpenWindows(-9L);
        Assertions.assertThat(result)
                .hasSize(1)
                .extracting("id", "windowStatus")
                .containsExactly(Tuple.tuple(-8L, WindowStatus.OPEN));
    }

    @Test
    public void shouldNotFindRoomOpenWindows() {
        List<Window> result = windowDao.findRoomOpenWindows(-10L);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void shouldFindWindowsByRoomName() {
        List<Window> result = windowDao.findWindowsByRoomName("Room1");
        Assertions.assertThat(result)
                .hasSize(2)
                .extracting("id")
                .contains(-10L);
    }

    @Test
    public void shouldNotFindWindowsByRoomName() {
        List<Window> result = windowDao.findWindowsByRoomName("Room1");
        Assertions.assertThat(result)
                .hasSize(2)
                .extracting("id", "windowStatus")
                .doesNotContain(Tuple.tuple(-8L));
    }

    @Test
    public void shouldDeleteallWindows(){
        List<Window> result1 = windowDao.findWindowsByRoomName("Room1");
        Assertions.assertThat(result1)
                .hasSize(2);
        windowDao.deleteAllWindows(-10L);
        List<Window> result2 = windowDao.findWindowsByRoomName("Room1");
        Assertions.assertThat(result2)
                .hasSize(0);
    }

    @Test
    public void shouldNotDeleteallWindows(){
        List<Window> result1 = windowDao.findWindowsByRoomName("Room1");
        Assertions.assertThat(result1)
                .hasSize(2);
        windowDao.deleteAllWindows(-10L);
        List<Window> result2 = windowDao.findWindowsByRoomName("Room2");
        Assertions.assertThat(result2)
                .hasSize(2);
    }

    @Test
    public void shouldDeleteSomeHeaters(){
        List<Heater> result1 = heaterDao.findHeatersByRoomName("Room1");
        Assertions.assertThat(result1)
                .hasSize(2);
        heaterDao.deleteAllHeaters(-10L);
        List<Heater> result2 = heaterDao.findHeatersByRoomName("Room1");
        Assertions.assertThat(result2)
                .hasSize(0);
    }

    @Test
    public void shouldFindWindowsByBuilding(){
        List<Window> result = buildingDao.findWindowsByBuilding(0L);
        Assertions.assertThat(result)
                .hasSize(2)
                .extracting("id")
                .doesNotContain(Tuple.tuple(-8L))
                .contains(-9L);
    }

    @Test
    public void EverythingIsOk(){
        List<Window> result = buildingDao.findWindowsByBuilding(0L);
        Assertions.assertThat(result)
                .hasSize(2)
                .extracting("id")
                .doesNotContain(Tuple.tuple(-8L))
                .contains(-9L);
    }

}