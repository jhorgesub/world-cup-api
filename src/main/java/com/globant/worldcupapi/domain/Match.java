package com.globant.worldcupapi.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*private Long idTeam1;

    private Long idTeam2;*/

    /*@ManyToMany(mappedBy = "match")
    private List<Team> teams = new ArrayList<>();

    @OneToOne
    private Result result;*/


    public Match() {
    }

    public Match(Long id/*, Long idTeam1, Long idTeam2*/) {
        this.id = id;
        /*this.idTeam1 = idTeam1;
        this.idTeam2 = idTeam2;*/
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Long getIdTeam1() {
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
    }*/

}
