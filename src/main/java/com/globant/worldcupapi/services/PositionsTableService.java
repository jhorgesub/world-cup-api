package com.globant.worldcupapi.services;

import com.globant.worldcupapi.domain.PositionsTable;
import com.globant.worldcupapi.repository.PositionsTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionsTableService {

    @Autowired
    public PositionsTableRepository positionsTableRepository;

    public PositionsTable getPositionsTable(){
        return (PositionsTable) positionsTableRepository.findAll();
    }

    public PositionsTable savePositionTable(PositionsTable positionsTable){
        return positionsTableRepository.save(positionsTable);
    }
}
