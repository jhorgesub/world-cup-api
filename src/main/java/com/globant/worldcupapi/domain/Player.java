package com.globant.worldcupapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotBlank
    private String name;

    @NotNull(message = "Position cannot be null")
    @NotBlank
    private String position;

    @NotNull(message = "Birthday cannot be null")
    private LocalDate birthday;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    public Player() {
    }

    public Player(Long id, String name, String position, LocalDate birthday, Team team) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.birthday = birthday;
        this.team = team;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void addTeam(Team team) {
        this.team = team;
    }
}
