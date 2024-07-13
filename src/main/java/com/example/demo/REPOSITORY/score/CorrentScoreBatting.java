package com.example.demo.REPOSITORY.score;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.POJO.Score.CorrentBallingScore;
import com.example.demo.POJO.Score.CorrentBatingScore;
@Repository
public interface CorrentScoreBatting extends JpaRepository<CorrentBatingScore, String> {

}
