package com.globant.worldcupapi.controller;

import com.globant.worldcupapi.domain.Match;
import com.globant.worldcupapi.domain.Result;
import com.globant.worldcupapi.services.MatchService;
import com.globant.worldcupapi.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping
    public List<Result> getResults(){
        return resultService.getResults();
    }
}
