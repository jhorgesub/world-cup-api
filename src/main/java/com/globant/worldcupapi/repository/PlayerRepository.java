package com.globant.worldcupapi.repository;

import com.globant.worldcupapi.domain.Players;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Players,Long> {
    Players findByName(String name);
}
