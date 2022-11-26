package com.globant.worldcupapi.services;

import com.globant.worldcupapi.domain.Player;
import com.globant.worldcupapi.domain.Team;
import com.globant.worldcupapi.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerService playerService;

    public List<Team> getTeams() {
      return (List<Team>) teamRepository.findAll();
    }

    public Team findByTeam(String team) {
        return teamRepository.findByTeam(team);
    }

    public String saveSeleccion(Team team) {
        List<Player> players = team.getPlayers();
        if(players.size() >=1 && players.size() <= 3) {
            Team teamSaved = teamRepository.save(team);
            for(Player player:players) {
                playerService.savePlayers(player);
                playerService.addPlayerToTeam(player, teamSaved);
            }
            return "Nueva seleccion creada: " + team.getTeam();
        } else {
            return "La seleccion debe tener entre 1 y 3 jugadores";
        }
    }
}
