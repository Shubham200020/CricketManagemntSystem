package com.example.demo.REPOSITORY.matches;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.POJO.Matches.MatchPlayer;
import com.example.demo.POJO.Matches.Turnaments;


@Repository
public interface TurnamentRepo extends JpaRepository<Turnaments, String> {
	@Query(value = "select t.team1 from Turnaments t where t.turnamentid=?1")
	List<MatchPlayer> findByTeam1(String id);
	@Query(value = "select t.team2 from Turnaments t where t.turnamentid=?1")
	List<MatchPlayer> findByTeam2(String id);
	

}
