package com.globant.worldcupapi.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class MatchRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long idTeam1;

    @NotNull
    private Long idTeam2;

    /*@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Team> team;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Result result;*/

    public MatchRequest() {
    }

    public MatchRequest(Long id, Long idTeam1, Long idTeam2/*, List<Team> team*/) {
        this.id = id;
        this.idTeam1 = idTeam1;
        this.idTeam2 = idTeam2;
        //this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTeam1() {
        return idTeam1;
    }

    public void setIdTeam1(Long idTeam1) {
        this.idTeam1 = idTeam1;
    }

    public Long getIdTeam2() {
        return idTeam2;
    }

    public void setIdTeam2(Long idTeam2) {
        this.idTeam2 = idTeam2;
    }

    /*public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }*/
}