package com.globant.worldcupapi.controller;

import com.globant.worldcupapi.domain.GroupT;
import com.globant.worldcupapi.domain.Team;
import com.globant.worldcupapi.repository.GroupRepository;
import com.globant.worldcupapi.repository.TeamRepository;
import com.globant.worldcupapi.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private TeamRepository teamRepository;


    @GetMapping
    public List<GroupT> getGroups(){
        return groupService.getGroups();
    }

    /*@GetMapping("/simulator")
    public List<GroupT> simulateGroups(){
        return this.groupService.saveGroup();
    }*/

    @PostMapping()
    public GroupT saveGroup(@RequestBody GroupT group){
        return this.groupService.saveGroup(group);
    }

}
