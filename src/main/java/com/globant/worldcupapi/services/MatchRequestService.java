package com.globant.worldcupapi.services;

import com.globant.worldcupapi.domain.*;
import com.globant.worldcupapi.repository.MatchRequestRepository;
import com.globant.worldcupapi.repository.ResultRepository;
import com.globant.worldcupapi.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MatchRequestService {

    @Autowired
    public MatchRequestRepository matchRequestRepository;

    @Autowired
    public ResultRepository resultRepository;

    @Autowired
    public TeamRepository teamRepository;

    @Autowired
    public GroupService groupService;


    public List<MatchRequest> getMatches(){
        return (List<MatchRequest>) matchRequestRepository.findAll();
    }

    public void updateTable(String team, int goals1, int goals2){
        List<GroupT> groups = groupService.getGroups();
        for (GroupT group:groups) {
            if (team.equals(group.getTeam())) {
                if (goals1 == goals2) {
                    group.setPoints(group.getPoints() + 1);
                } else {
                    group.setPoints(group.getPoints() + 3);
                }
            }
        }
    }

    public ResponseEntity<?> simulateMatch(MatchRequest match){
        Optional<Team> team1 = teamRepository.findById(match.getIdTeam1());
        Optional<Team> team2 = teamRepository.findById(match.getIdTeam2());
        List<GroupT> groups = groupService.getGroups();
        int goals1 = ThreadLocalRandom.current().nextInt(0,5+1);
        int goals2 = ThreadLocalRandom.current().nextInt(0,5+1);
        Result result = null;
        if (team1.isPresent() && team2.isPresent()){
            if (! match.getIdTeam1().equals(match.getIdTeam2())){
                if (goals1 > goals2) {
                    result = new Result(team1.get().getTeam(), goals1, team2.get().getTeam(), goals2, "Ganó " + team1.get().getTeam());
                    updateTable(team1.get().getTeam(),goals1,goals2);
                } else if (goals1 < goals2) {
                    result = new Result(team1.get().getTeam(), goals1, team2.get().getTeam(), goals2, "Ganó " + team2.get().getTeam());
                    updateTable(team2.get().getTeam(),goals1,goals2);
                } else {
                    result = new Result(team1.get().getTeam(), goals1, team2.get().getTeam(), goals2, "Empate");
                    updateTable(team1.get().getTeam(),goals1,goals2);
                    updateTable(team2.get().getTeam(),goals1,goals2);
                }
                matchRequestRepository.save(match);
                resultRepository.save(result);
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Debe escoger dos selecciones distintas", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("No se encuentra la selección",HttpStatus.NOT_FOUND);
        }
    }


}
