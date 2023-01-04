package com.globant.worldcupapi.services;

import com.globant.worldcupapi.domain.Player;
import com.globant.worldcupapi.domain.Team;
import com.globant.worldcupapi.repository.PlayerRepository;
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

    @Autowired
    private PlayerRepository playerRepository;

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
                    if (team.getPlayers().size() <=4) {
                        playerService.savePlayers(player);
                        playerService.addPlayerToTeam(player, teamSaved);
                    }
                }
                return "Nueva seleccion creada: " + team.getTeam();
            } else {
                return "La seleccion debe tener entre 1 y 3 jugadores";
            }
    }


    public void deletePlayerFromTeamById(Long idTeam, Long idPlayer) {
        List<Player> players = findTeamById(idTeam).getPlayers();
        for (Player player1:players) {
            if (player1.getId() == idPlayer) {
                playerRepository.deletePlayerById(idPlayer);
            }
        }

    }
}
