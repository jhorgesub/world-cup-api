package com.globant.worldcupapi.controller;

import com.globant.worldcupapi.domain.Player;
import com.globant.worldcupapi.domain.Team;
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
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping()
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/getTeam")
    public Team getTeam(String team) {
        return teamService.findByTeam(team);
    }

    @PostMapping()
    public ResponseEntity<?> saveTeams(@RequestBody Team team) {
        return new ResponseEntity<>(this.teamService.saveSeleccion(team), HttpStatus.CREATED);
    }

    @PostMapping("/{idTeam}/player")
    public Team createTeam(@RequestBody List<Player> idPlayer, @PathVariable Long idTeam) {
        Team team = teamRepository.findById(idTeam).orElse(null);
        return teamRepository.save(team);
    }

    @DeleteMapping("deleteTeam/{idTeam}")
    public void deleteTeam(@PathVariable Long idTeam) {
        teamRepository.deleteById(idTeam);
    }

}
