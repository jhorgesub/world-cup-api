package com.globant.worldcupapi.domain;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
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
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Teams team;

    public Players() {
    }

    public Players(Long id, String name, String position, LocalDate birthday, Teams team) {
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

    public Teams getTeam() {
        return team;
    }

    public void setTeam(Teams team) {
        this.team = team;
    }

    public void addTeam(Teams team) {
        this.team = team;
    }
}
