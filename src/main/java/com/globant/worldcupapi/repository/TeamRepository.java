package com.globant.worldcupapi.repository;

import com.globant.worldcupapi.domain.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team,Long> {
    Team findByTeam(String team);
}
