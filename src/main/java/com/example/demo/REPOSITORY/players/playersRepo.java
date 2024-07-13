package com.example.demo.REPOSITORY.players;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.POJO.players.Players;
@Repository
public interface playersRepo extends JpaRepository<Players, String>{
	@Query(value="select p.playerid,p.name from Players p")
	List<Players> playe();
	@Query(value="select p from Players p where p.role is null")
	List<Players> playeRole();
	@Query(value="select p from Players p where p.role is not null")
	List<Players> playeRoleNotNull();
	 
}
