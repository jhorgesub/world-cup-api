package com.globant.worldcupapi.domain;

import javax.persistence.*;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String team1;
    private Integer goals1;
    private String team2;
    private Integer goals2;
    private String result;

    /*@OneToOne(mappedBy = "result")
    @JoinColumn(name = "id_match")
    private MatchRequest match;*/

    public Result() {
    }

    public Result(String team1, Integer goals1, String team2, Integer goals2,String result) {
        this.team1 = team1;
        this.goals1 = goals1;
        this.team2 = team2;
        this.goals2 = goals2;
        this.result = result;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
