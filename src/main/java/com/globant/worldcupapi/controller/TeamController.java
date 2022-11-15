package com.globant.worldcupapi.controller;

import com.globant.worldcupapi.domain.Players;
import com.globant.worldcupapi.domain.Teams;
import com.globant.worldcupapi.repository.PlayerRepository;
import com.globant.worldcupapi.repository.TeamRepository;
import com.globant.worldcupapi.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping()
    public List<Teams> getTeams() {
        return teamService.getTeams();
    }

    @PostMapping()
    public ResponseEntity<?> saveTeams(@RequestBody Teams team) {
        return new ResponseEntity<>(this.teamService.saveTeams(team), HttpStatus.CREATED);
    }

    @GetMapping("/getTeam")
    public Teams getTeam(String country) {
        return teamService.findByCountry(country);
    }




}
