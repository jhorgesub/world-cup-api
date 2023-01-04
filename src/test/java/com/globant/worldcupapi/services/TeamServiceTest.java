package com.globant.worldcupapi.services;

import com.globant.worldcupapi.domain.Player;
import com.globant.worldcupapi.domain.Team;
import com.globant.worldcupapi.repository.TeamRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TeamServiceTest {

    @InjectMocks
    private TeamService teamService;

    @Mock
    private TeamRepository teamRepository;

    @Mock
    private PlayerService playerService;

    private Team team;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void saveSeleccion() {

        //Arrange
        team = new Team();
        team.setTeam("Argentina");
        team.setDt("Scaloni");
        team.setConfederation("Conmebol");
        Player player = new Player();
        player.setBirthday(LocalDate.parse("1999-06-01"));
        player.setName("Jorge Subeldia");
        player.setPosition("Delantero");
        List<Player> players = new ArrayList<>();
        players.add(player);
        team.setPlayers(players);
        String result = teamService.saveSeleccion(team);

        //Act
        when(teamRepository.save(team)).thenReturn(team);

        //Assert
        assertEquals(result,"Nueva seleccion creada: " + team.getTeam());
        verify(playerService,Mockito.times(1)).savePlayers(Mockito.any(Player.class));
        verify(playerService,times(1)).addPlayerToTeam(any(),any());
    }

    /*@Test
    void testExceptionWhenTeamSavedReturnsException() {
        //Arrange
        team = null;
        team.setTeam("Argentina");
        team.setDt("Scaloni");
        team.setConfederation("Conmebol");

        //Act
        when(teamRepository.save(any())).thenReturn(new Exception());

        //Assert
        Exception thrown = Assertions.assertThrows(NullPointerException.class, () -> {
            teamService.saveSeleccion(team);
        });
        //Assertions.assertEquals("La seleccion debe tener entre 1 y 3 jugadores", thrown.getMessage());
    }*/

    /*@Test
    void saveSeleccionNotCreated() {
        team.setTeam("Argentina");
        team.setDt("Scaloni");
        team.setConfederation("Conmebol");
        Player player = new Player();
        player.setName("Jorge");
        player.setPosition("delantero");
        player.setBirthday(LocalDate.parse("1983-12-04"));
        String result = teamService.saveSeleccion(team);


        when(teamRepository.save(team)).thenReturn(team);

        assertEquals(result, "La seleccion debe tener entre 1 y 3 jugadores");
    }*/

    @Test
    void getTeams() {
        when(teamService.getTeams()).thenReturn((List<Team>) any(Team.class));
    }

    @Test
    void findTeamByTeam() {
        when(teamService.findTeamByTeam(anyString())).thenReturn(team);
    }

    @Test
    void findTeamById() {
        when(teamService.findTeamById(anyLong())).thenReturn(team);
    }

}