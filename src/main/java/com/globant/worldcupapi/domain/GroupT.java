package com.globant.worldcupapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GroupT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Character letter;
    private String teamName;
    private Integer goals;
    private Integer dif;
    private Integer points;


    public GroupT() {
    }

    public GroupT(Long id, Character letter, String teamName, Integer goals, Integer dif, Integer points) {
        this.id = id;
        this.letter = letter;
        this.goals = goals;
        this.dif = dif;
        this.teamName = teamName;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public String getTeam() {
        return teamName;
    }
    public void setTeam(String teamName) {
        this.teamName = teamName;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getDif() {
        return dif;
    }

    public void setDif(Integer dif) {
        this.dif = dif;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
