package com.globant.worldcupapi.services;

import com.globant.worldcupapi.domain.MatchRequest;
import com.globant.worldcupapi.domain.PositionsTable;
import com.globant.worldcupapi.domain.Result;
import com.globant.worldcupapi.domain.Team;
import com.globant.worldcupapi.repository.MatchRequestRepository;
import com.globant.worldcupapi.repository.PositionsTableRepository;
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
    public PositionsTableRepository positionsTableRepository;


    public List<MatchRequest> getMatches(){
        return (List<MatchRequest>) matchRequestRepository.findAll();
    }

    public MatchRequest saveMatches(MatchRequest match){
        return matchRequestRepository.save(match);
    }

    public ResponseEntity<?> simulateMatch(MatchRequest match, PositionsTable positionsTable){
        Optional<Team> team1 = teamRepository.findById(match.getIdTeam1());
        Optional<Team> team2 = teamRepository.findById(match.getIdTeam2());
        Integer goals1 = ThreadLocalRandom.current().nextInt(0,5+1);
        Integer goals2 = ThreadLocalRandom.current().nextInt(0,5+1);
        Result result = null;
        PositionsTable table = null;
        if (team1.isPresent() && team2.isPresent()){
            if (! match.getIdTeam1().equals(match.getIdTeam2())){
                if (goals1 > goals2) {
                    result = new Result(team1.get().getTeam(), goals1, team2.get().getTeam(), goals2, "Ganó " + team1.get().getTeam());
                    table = new PositionsTable(team1.get().getId(), team1.get().getTeam(), table.getMatchesPlayed() + 1, table.getPoints() + 3 );
                } else if (goals1 < goals2) {
                    result = new Result(team1.get().getTeam(), goals1, team2.get().getTeam(), goals2, "Ganó " + team2.get().getTeam());
                    table = new PositionsTable(team2.get().getId(), team2.get().getTeam(),table.getMatchesPlayed() +1, table.getPoints() + 3);
                } else {
                    result = new Result(team1.get().getTeam(), goals1, team2.get().getTeam(), goals2, "Empate");
                    table = new PositionsTable(team1.get().getId(), team1.get().getTeam(), table.getMatchesPlayed() + 1, table.getPoints() + 1 );
                    table = new PositionsTable(team2.get().getId(), team2.get().getTeam(),table.getMatchesPlayed() +1, table.getPoints() + 1);
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
