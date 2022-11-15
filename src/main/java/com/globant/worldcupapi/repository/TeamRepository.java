package com.globant.worldcupapi.repository;

import com.globant.worldcupapi.domain.Teams;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Teams,Long> {
    Teams findByCountry(String team);
}
