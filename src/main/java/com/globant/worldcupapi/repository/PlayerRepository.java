package com.globant.worldcupapi.repository;

import com.globant.worldcupapi.domain.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player,Long> {
    Player findByName(String name);

    void deletePlayerById(Long player1);
}
