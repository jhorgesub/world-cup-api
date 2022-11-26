package com.globant.worldcupapi.services;

import com.globant.worldcupapi.domain.Match;
import com.globant.worldcupapi.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getMatches() {
        return (List<Match>) matchRepository.findAll();
    }

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }
}
