package com.globant.worldcupapi.controller;

import com.globant.worldcupapi.domain.MatchRequest;
import com.globant.worldcupapi.domain.PositionsTable;
import com.globant.worldcupapi.domain.Team;
import com.globant.worldcupapi.repository.MatchRequestRepository;
import com.globant.worldcupapi.repository.ResultRepository;
import com.globant.worldcupapi.repository.TeamRepository;
import com.globant.worldcupapi.services.MatchRequestService;
import com.globant.worldcupapi.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matches")
public class MatchRequestController {

    @Autowired
    private MatchRequestRepository matchRequestRepository;

    @Autowired
    private MatchRequestService matchRequestService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ResultRepository resultRepository;

    @GetMapping
    public List<MatchRequest> getMatches(){
        return matchRequestService.getMatches();
    }

    @PostMapping
    public ResponseEntity<?> saveMatch(@RequestBody MatchRequest match, PositionsTable positionsTable) {
        return matchRequestService.simulateMatch(match, positionsTable);

    }
}
