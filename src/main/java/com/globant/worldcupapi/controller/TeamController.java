package com.globant.worldcupapi.controller;

import com.globant.worldcupapi.domain.Player;
import com.globant.worldcupapi.domain.Team;
import com.globant.worldcupapi.repository.TeamRepository;
import com.globant.worldcupapi.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamRepository teamRepository;


    @GetMapping()
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/getTeamByName")
    public Team getTeamByName(String team) {
        return teamService.findTeamByTeam(team);
    }

    @GetMapping("/{idTeam}")
    public ResponseEntity<?> getTeamById(@PathVariable Long idTeam) {
        Optional<Team> team = teamRepository.findTeamById(idTeam);
        if(team.isPresent()){
            return new ResponseEntity<>(team.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Selección no encontrada", HttpStatus.NOT_FOUND);
        }
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
