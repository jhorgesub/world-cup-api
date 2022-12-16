package com.globant.worldcupapi.controller;

import com.globant.worldcupapi.domain.GroupT;
import com.globant.worldcupapi.repository.GroupRepository;
import com.globant.worldcupapi.repository.TeamRepository;
import com.globant.worldcupapi.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<?> saveGroups(GroupT group){
        return this.groupService.createGroup(group);
    }

}
