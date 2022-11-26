package com.globant.worldcupapi.repository;

import com.globant.worldcupapi.domain.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends CrudRepository<Result,Long> {
}
