package com.globant.worldcupapi.repository;

import com.globant.worldcupapi.domain.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends CrudRepository<Team,Long> {
    Team findTeamByTeam(String team);
    Optional<Team> findTeamById(Long idTeam);
}
