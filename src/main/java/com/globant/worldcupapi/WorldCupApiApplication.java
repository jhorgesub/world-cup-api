package com.globant.worldcupapi;

import com.globant.worldcupapi.domain.Players;
import com.globant.worldcupapi.domain.Teams;
import com.globant.worldcupapi.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class WorldCupApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldCupApiApplication.class, args);
	}

}
