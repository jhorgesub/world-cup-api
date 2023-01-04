package com.globant.worldcupapi.controller;

import com.globant.worldcupapi.domain.Player;
import com.globant.worldcupapi.domain.Team;
import com.globant.worldcupapi.repository.PlayerRepository;
import com.globant.worldcupapi.repository.TeamRepository;
import com.globant.worldcupapi.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping()
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("/getPlayer")
    public Player getPlayer(String name) {
        return playerService.findByName(name);
    }

    @PostMapping()
    public ResponseEntity<?> savePlayers(@RequestBody Player player) {
        return new ResponseEntity<>(this.playerService.savePlayers(player), HttpStatus.CREATED);
    }

    @DeleteMapping("deletePlayer/{idPlayer}")
    public void deletePlayer(@PathVariable Long idPlayer) {
        playerRepository.deleteById(idPlayer);
    }


    @PutMapping("/{idPlayer}/teams/{idTeam}")
    public Player addTeamToPlayer (@PathVariable Long idPlayer, @PathVariable Long idTeam ) {
        Player player = playerRepository.findById(idPlayer).get();
        Team team = teamRepository.findById(idTeam).get();
        return playerService.addPlayerToTeam(player,team);
    }

}
