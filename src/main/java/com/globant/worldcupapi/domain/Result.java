package com.globant.worldcupapi.domain;

import javax.persistence.*;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String team1;

    private String team2;

    private Integer goals1;

    private Integer goals2;

    private Boolean draw;

    /*@ManyToOne(fetch = FetchType.EAGER)
    private Team team;

    @OneToOne
    @JoinColumn(name = "id_match")
    private Match match;*/

    public Result() {
    }

    public Result(String team1, String team2, Integer goals1, Integer goals2, Boolean draw) {
        this.team1 = team1;
        this.team2 = team2;
        this.goals1 = goals1;
        this.goals2 = goals2;
        this.draw = draw;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public Integer getGoals1() {
        return goals1;
    }

    public void setGoals1(Integer goals1) {
        this.goals1 = goals1;
    }

    public Integer getGoals2() {
        return goals2;
    }

    public void setGoals2(Integer goals2) {
        this.goals2 = goals2;
    }

    public Boolean getDraw() {
        return draw;
    }

    public void setDraw(Boolean draw) {
        this.draw = draw;
    }

}
