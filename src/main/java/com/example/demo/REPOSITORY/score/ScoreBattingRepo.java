package com.example.demo.REPOSITORY.score;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.POJO.Score.ScoreBating;

@Repository
public interface ScoreBattingRepo extends JpaRepository<ScoreBating, String>{
	@Query(value  = "select c from ScoreBating c where c.players=?1")
	ScoreBating findbyPlayerid(String id);  
}
