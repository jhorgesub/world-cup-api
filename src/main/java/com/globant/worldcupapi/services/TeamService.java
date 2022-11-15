package com.globant.worldcupapi.services;

import com.globant.worldcupapi.domain.Teams;
import com.globant.worldcupapi.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Teams> getTeams() {
      return (List<Teams>) teamRepository.findAll();
    }

    public Teams saveTeams(Teams team) {
        return teamRepository.save(team);
    }


    public Teams findByCountry(String country) {
        return teamRepository.findByCountry(country);
    }
}
