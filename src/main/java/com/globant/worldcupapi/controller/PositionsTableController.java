package com.globant.worldcupapi.controller;

import com.globant.worldcupapi.domain.PositionsTable;
import com.globant.worldcupapi.repository.PositionsTableRepository;
import com.globant.worldcupapi.services.PositionsTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/table")
public class PositionsTableController {

    @Autowired
    private PositionsTableRepository positionsTableRepository;

    @Autowired
    private PositionsTableService positionsTableService;

    @GetMapping
    public PositionsTable getTable(){
        return (PositionsTable) positionsTableRepository.findAll();
    }

    @PostMapping
    public PositionsTable saveTable(PositionsTable positionsTable){
        return positionsTableService.savePositionTable(positionsTable);
    }
}
