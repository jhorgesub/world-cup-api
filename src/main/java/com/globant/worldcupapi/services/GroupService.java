package com.globant.worldcupapi.services;

import com.globant.worldcupapi.domain.GroupT;
import com.globant.worldcupapi.domain.Team;
import com.globant.worldcupapi.repository.GroupRepository;
import com.globant.worldcupapi.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamService teamService;

    public List<GroupT> getGroups() {
        return (List<GroupT>) groupRepository.findAll();
    }

    public ResponseEntity<?> createGroup(GroupT group){
        List<GroupT> groups = getGroups();
        if(groups.size() < 6) {
            List<Team> teams = teamService.getTeams();
            GroupT groupSaved = groupRepository.save(group);
            char letter = 'A';
            groupSaved.setLetter(letter);
            groupSaved.setPoints(0);
            groupSaved.setTeam("Argentina");
                for (GroupT groupt:groups){
                    while(groupt.getLetter() == letter) {
                        int num = (int) ((Math.random() * 3) + 'A');
                        letter = (char) num;
                    }
                    groupSaved.setLetter(letter);
                    int i = 0;
                    while(groupSaved.getTeam() == teams.get(i).getTeam()){
                        i++;
                    }
                    groupSaved.setTeam(teams.get(i).getTeam());
                }
                return new ResponseEntity<>(groupRepository.save(groupSaved),HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Ya alcanzó el máximo de selecciones posibles a agregar al mundial", HttpStatus.BAD_REQUEST);
        }
    }

}
