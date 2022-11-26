package com.globant.worldcupapi.services;

import com.globant.worldcupapi.domain.Player;
import com.globant.worldcupapi.domain.Team;
import com.globant.worldcupapi.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getPlayers() {
        return (List<Player>) playerRepository.findAll();
    }

    public Player savePlayers(Player player) {
        return playerRepository.save(player);
    }

    public Player findByName(String name) {
        return playerRepository.findByName(name);
    }

    public Player addPlayerToTeam(Player player, Team team) {
        player.setTeam(team);
        return playerRepository.save(player);
    }
}
