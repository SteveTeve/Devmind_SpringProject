package com.emse.spring.project.model;
import javax.persistence.*;

@Entity
@Table(name = "HEATER")
public class Heater {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private Long power;

    @ManyToOne
    private Room room;


    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private HeaterStatus Heater_status;


    public Heater() {
        this.name = "Default_name";
        this.Heater_status = HeaterStatus.ON;
    }

    public Heater(String name, Room room, HeaterStatus status) {
        this.name = name;
        this.room = room;
        this.Heater_status = status;
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

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Room getRoom() { return room;}

    public void setRoom(Room room) { this.room = room;}

    public HeaterStatus getStatus() {
        return Heater_status;
    }

    public void setStatus(HeaterStatus status) {
        this.Heater_status = status;
    }

}
