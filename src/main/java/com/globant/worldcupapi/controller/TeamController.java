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

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping()
    public List<Teams> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/getTeam")
    public Teams getTeam(String country) {
        return teamService.findByCountry(country);
    }

    @PostMapping()
    public ResponseEntity<?> saveTeams(@RequestBody Teams team) {
        return new ResponseEntity<>(this.teamService.saveTeams(team), HttpStatus.CREATED);
    }

    @PostMapping("/addTeam")
    public Teams saveTeam(@RequestBody Teams team) {
        return teamService.saveTeams(team);
    }

    @PutMapping("{idTeam}/players/{idPlayer}")
    public Players addPlayerToTeam (@PathVariable Long idTeam, @PathVariable Long idPlayer) {
        Players player = playerRepository.findById(idPlayer).get();
        Teams team = teamRepository.findById(idTeam).get();
        team.addPlayer(player);
        return playerRepository.save(player);
    }
}
