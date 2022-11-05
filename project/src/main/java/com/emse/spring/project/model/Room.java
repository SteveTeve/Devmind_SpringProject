package com.emse.spring.project.model;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer floor;

    private Double current_temperature;

    private Double target_temperature;

    @OneToMany(mappedBy = "room")
    private Set<Heater> heaters;

    @OneToMany(mappedBy = "room")
    private Set<Window> windows;

    @ManyToOne
    private Building building;

    public Room() {
        this.name = "Default_room_name";
        this.floor = 0;
    }

    public Room(String name, Integer floor){
        this.name = name;
        this.floor = floor;
    }

    public Room(String name, Integer floor, Building building){
        this.name = name;
        this.floor = floor;
        this.building = building;
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

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Double getCurrent_temperature() { return current_temperature;}

    public void setCurrent_temperature(Double current_temperature) { this.current_temperature = current_temperature;}

    public Double getTarget_temperature() { return target_temperature;}

    public void setTarget_temperature(Double target_temperature) { this.target_temperature = target_temperature;}
}
