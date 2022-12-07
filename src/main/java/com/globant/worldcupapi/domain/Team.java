package com.globant.worldcupapi.domain;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Team cannot be null")
    @NotEmpty
    private String team;

    @NotNull(message = "Confederation cannot be null")
    @NotEmpty
    private String confederation;

    @NotNull(message = "DT cannot be null")
    @NotBlank
    @Column(name = "DT")
    private String dt;

    @OneToMany(mappedBy = "team")
    private List<Player> players = new ArrayList<>();

    @ManyToMany(mappedBy = "team")
    private List<MatchRequest> match;

    public Team() {
    }

    public Team(Long id, String team, String confederation, String dt, List<Player> players, List<MatchRequest> match) {
        this.id = id;
        this.team = team;
        this.confederation = confederation;
        this.dt = dt;
        this.players = players;
        this.match = match;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getConfederation() {
        return confederation;
    }

    public void setConfederation(String confederation) {
        this.confederation = confederation;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<MatchRequest> getMatch() {
        return match;
    }

    public void setMatch(List<MatchRequest> match) {
        this.match = match;
    }
}
