package com.globant.worldcupapi.services;

import com.globant.worldcupapi.domain.Players;
import com.globant.worldcupapi.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Players> getPlayers() {
        return (List<Players>) playerRepository.findAll();
    }

    public Players savePlayers(Players player) {
        return playerRepository.save(player);
    }

    public Players findByName(String name) {
        return playerRepository.findByName(name);
    }

}
