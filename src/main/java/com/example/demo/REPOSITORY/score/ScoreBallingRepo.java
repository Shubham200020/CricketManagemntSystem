package com.example.demo.REPOSITORY.score;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.POJO.Score.ScoreBalling;
@Repository
public interface ScoreBallingRepo extends JpaRepository<ScoreBalling, String>{
	@Query(value  = "select c from ScoreBalling c where c.players=?1")
	ScoreBalling findByPlayerid(String id);
}
