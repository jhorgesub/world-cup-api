package com.globant.worldcupapi.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @NotNull(message = "Country cannot be null")
    @NotEmpty
    private String country;

    @NotNull(message = "Confederation cannot be null")
    @NotEmpty
    private String confederation;

    @Min(value = 11, message = "Players should not be less than 11")
    @Max(value = 26, message = "Players should not be more than 26")
    @Column(name = "cant_Players")
    private Integer cantPlayers;

    @Column(name = "DT")
    @NotNull(message = "DT cannot be null")
    @NotBlank
    private String dt;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private Set<Players> players = new HashSet<>();

    public Teams() {
    }

    public Teams(Long id, String country, String confederation, Integer cantPlayers, String dt, Set<Players> players) {
        this.id = id;
        this.country = country;
        this.confederation = confederation;
        this.cantPlayers = cantPlayers;
        this.dt = dt;
        this.players = players;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getConfederation() {
        return confederation;
    }

    public void setConfederation(String confederation) {
        this.confederation = confederation;
    }

    public Integer getCantPlayers() {
        return cantPlayers;
    }

    public void setCantPlayers(Integer cantPlayers) {
        this.cantPlayers = cantPlayers;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Set<Players> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Players> players) {
        this.players = players;
    }

    public void addPlayer(Players player) {
        this.players = players;
    }
}
