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

    @PutMapping("{idPlayer}/teams/{idTeam}")
    public Teams addTeamToPlayer (@PathVariable Long idTeam, @PathVariable Long idPlayer) {
        Players player = playerRepository.findById(idPlayer).get();
        Teams team = teamRepository.findById(idTeam).get();
        player.addTeam(team);
        return teamRepository.save(team);
    }

    @GetMapping("/getPlayer")
    public Players getPlayer(String name) {
        return playerRepository.findByName(name);
    }

}
