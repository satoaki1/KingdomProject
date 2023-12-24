package com.example.kingdom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kingdom_warriors")
public class Warrior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "power")
    private Integer power;

    @Column(name = "intelligence")
    private Integer intelligence;

    @Column(name = "leadership")
    private Integer leadership;

    public Warrior() {}

    public Warrior(String name, Integer power, Integer intelligence, Integer leadership) {
        this.name = name;
        this.power = power;
        this.intelligence = intelligence;
        this.leadership = leadership;
    }

    public Long getId() {
        return id;
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

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getLeadership() {
        return leadership;
    }

    public void setLeadership(Integer leadership) {
        this.leadership = leadership;
    }
}
