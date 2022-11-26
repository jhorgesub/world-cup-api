package com.globant.worldcupapi.controller;

import com.globant.worldcupapi.domain.Match;
import com.globant.worldcupapi.domain.Team;
import com.globant.worldcupapi.repository.MatchRepository;
import com.globant.worldcupapi.repository.TeamRepository;
import com.globant.worldcupapi.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("matches")
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchService matchService;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping
    public List<Match> getMatches(){
        return matchService.getMatches();
    }

    /*@PostMapping()
    public Optional<Team> getResult(@RequestBody Match match) {
        Optional<Team> team1 = teamRepository.findById(match.getIdTeam1());
        Optional<Team> team2 = teamRepository.findById(match.getIdTeam2());
        int goals1 = ThreadLocalRandom.current().nextInt(0,10+1);
        int goals2 = ThreadLocalRandom.current().nextInt(0,10+1);

        return team1;

    }*/
}
