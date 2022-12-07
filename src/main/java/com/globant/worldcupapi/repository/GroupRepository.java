package com.globant.worldcupapi.repository;

import com.globant.worldcupapi.domain.GroupT;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<GroupT,Long> {
}
