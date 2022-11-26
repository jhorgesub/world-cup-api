package com.globant.worldcupapi.services;

import com.globant.worldcupapi.domain.Result;
import com.globant.worldcupapi.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public List<Result> getResults(){
        return (List<Result>) resultRepository.findAll();
    }

    public Result saveResult(Result result){
        return resultRepository.save(result);
    }
}
