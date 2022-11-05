package com.emse.spring.project.model;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BUILDING")
public class Building {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy = "building")
    private Set<Room> rooms;

    public Building() {
        this.name = "Building0";
    }

    public Building(String name){
        this.name = name;
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

}
