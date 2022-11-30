package com.globant.worldcupapi.repository;

import com.globant.worldcupapi.domain.MatchRequest;
import org.springframework.data.repository.CrudRepository;

public interface MatchRequestRepository extends CrudRepository<MatchRequest, Long> {
}
