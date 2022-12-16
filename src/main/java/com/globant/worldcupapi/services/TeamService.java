package com.globant.worldcupapi.services;

import com.globant.worldcupapi.domain.Player;
import com.globant.worldcupapi.domain.Team;
import com.globant.worldcupapi.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerService playerService;

    public List<Team> getTeams() {
      return (List<Team>) teamRepository.findAll();
    }

    public Team findTeamByTeam(String team) {
        return teamRepository.findTeamByTeam(team);
    }

    public Team findTeamById(Long idTeam){
        Optional<Team> team = teamRepository.findTeamById(idTeam);
        return team.orElse(null);
    }

    public String saveSeleccion(Team team) {
        List<Player> players = team.getPlayers();
        if(players.size() >= 1 && players.size() <= 3) {
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
