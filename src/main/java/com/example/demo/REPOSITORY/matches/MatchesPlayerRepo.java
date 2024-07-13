package com.example.demo.REPOSITORY.matches;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.POJO.Matches.MatchPlayer;

public interface MatchesPlayerRepo extends JpaRepository<MatchPlayer,String>{

}
