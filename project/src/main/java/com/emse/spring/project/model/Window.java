package com.emse.spring.project.model;
import javax.persistence.*;

@Entity
@Table(name = "RWINDOWS")
public class Window {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WindowStatus window_Status;

    @ManyToOne
    private Room room;

    public Window() {
    }

    public Window(String name, WindowStatus status, Room room) {
        this.window_Status = status;
        this.name = name;
        this.room = room;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WindowStatus getWindowStatus() {
        return window_Status;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.window_Status = windowStatus;
    }

    public Room getRoom() { return room;}

    public void setRoom(Room room) { this.room = room;}

}