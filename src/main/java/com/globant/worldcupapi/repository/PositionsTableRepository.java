package com.globant.worldcupapi.repository;

import com.globant.worldcupapi.domain.PositionsTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionsTableRepository extends CrudRepository<PositionsTable, Long> {
}
