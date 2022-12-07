package com.globant.worldcupapi.services;

import com.globant.worldcupapi.domain.GroupT;
import com.globant.worldcupapi.domain.MatchRequest;
import com.globant.worldcupapi.domain.Team;
import com.globant.worldcupapi.repository.GroupRepository;
import com.globant.worldcupapi.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired TeamRepository teamRepository;

    @Autowired
    private TeamService teamService;

    @Autowired
    private RestTemplate restTemplate;


    public List<GroupT> getGroups() {
        return (List<GroupT>) groupRepository.findAll();
    }

    public GroupT saveGroup(GroupT group){
        Random random = new Random();
        String letters = "ABCDEFGH";
        int randomInt = random.nextInt(letters.length());
        for (int i = 1; i <= 8; i++){
            group.setLetter(letters.charAt(1));
        }
        return groupRepository.save(group);
    }
    public String simulateGroup(List<Team> teams, List<GroupT> group) {


        for (int i = 1 ; i<=8; i++){
            for (int j = 1;j<=4; j++){
                group.get(j).setId(teams.get(i).getId());
                group.get(j).setTeam(teams.get(i).getTeam());
                group.get(j).setPoints(1);
            }
        }
        return "OK";
    }

}
