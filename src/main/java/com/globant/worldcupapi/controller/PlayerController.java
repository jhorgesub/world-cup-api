package com.globant.worldcupapi.controller;

import com.globant.worldcupapi.domain.Players;
import com.globant.worldcupapi.domain.Teams;
import com.globant.worldcupapi.repository.PlayerRepository;
import com.globant.worldcupapi.repository.TeamRepository;
import com.globant.worldcupapi.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public ResponseEntity<?> getPlayers() {
        return new ResponseEntity<>(playerService.getPlayers(),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> savePlayers(@RequestBody Players player) {
        return new ResponseEntity<>(this.playerService.savePlayers(player), HttpStatus.CREATED);
    }

    @PostMapping("{idTeams}/players/{idPlayers}")
    public Teams addTeamToPlayer (@RequestBody Teams teams, @PathVariable Long idTeams, @PathVariable Long idPlayers) {
        Players player = playerRepository.findById(idPlayers).get();
        Teams team = teamRepository.findById(idTeams).get();
        player.addTeam(team);
        return teamRepository.save(team);
    }

    @GetMapping("/getPlayer")
    public Players getPlayer(String name) {
        return playerRepository.findByName(name);
    }

}
