package com.globant.worldcupapi.services;

import com.globant.worldcupapi.domain.MatchRequest;
import com.globant.worldcupapi.domain.Result;
import com.globant.worldcupapi.repository.MatchRequestRepository;
import com.globant.worldcupapi.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchRequestService {

    @Autowired
    public MatchRequestRepository matchRequestRepository;

    @Autowired
    public ResultRepository resultRepository;

    public List<MatchRequest> getMatches(){
        return (List<MatchRequest>) matchRequestRepository.findAll();
    }

    public MatchRequest saveMatches(MatchRequest match){
        return matchRequestRepository.save(match);
    }

}
