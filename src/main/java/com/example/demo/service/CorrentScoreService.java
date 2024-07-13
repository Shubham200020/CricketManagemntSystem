package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.POJO.Matches.MatchPlayer;
import com.example.demo.POJO.Score.CorrentBallingScore;
import com.example.demo.POJO.Score.CorrentBatingScore;
import com.example.demo.POJO.players.Players;
import com.example.demo.REPOSITORY.matches.MatchesPlayerRepo;
import com.example.demo.REPOSITORY.score.CorrentScoreBalling;
import com.example.demo.REPOSITORY.score.CorrentScoreBatting;

@Service
public class CorrentScoreService {
	@Autowired
	CorrentScoreBatting correntScoreBatting;
	@Autowired
	CorrentScoreBalling correntScoreBalling;

	public static CorrentBallingScore correntBallingScore(CorrentBallingScore correntBallingScore)
	{
		correntBallingScore.setBallOver(0);
		correntBallingScore.setEconimy(0);
		correntBallingScore.setMedernOver(0);
		correntBallingScore.setNoBall(0);
		correntBallingScore.setRun(0);
		correntBallingScore.setWickets(0);
		correntBallingScore.setWideBall(0);
		correntBallingScore.setScoreid(null);
		return correntBallingScore;
	}
	public static CorrentBatingScore correntBatingScore(CorrentBatingScore correntBatingScore) {
		correntBatingScore.setAvgSr(0);
		correntBatingScore.setFours(0);
		correntBatingScore.setSix(0);
		correntBatingScore.setTotalBall(0);
		correntBatingScore.setTotalRun(0);
		correntBatingScore.setHalfCentury(0);
		correntBatingScore.setCentury(0);
		correntBatingScore.setScoreid(null);
		return correntBatingScore;
	}
	public static MatchPlayer playerInit(CorrentBallingScore correntBallingScore,CorrentBatingScore correntBatingScore,Players players) {
		//CorrentBallingScore correntBallingScore = new CorrentBallingScore();
		//CorrentBatingScore correntBatingScore = new CorrentBatingScore();
		correntBallingScore.setScoreid(null);
		correntBallingScore.setBallOver(0.0f);
		correntBallingScore.setEconimy(0);
		correntBallingScore.setNoBall(0);
		correntBallingScore.setMedernOver(0);
		correntBallingScore.setRun(0);
		correntBallingScore.setWickets(0);
		correntBallingScore.setWideBall(0);
		correntBallingScore.setScoreid(null);
		//correntScoreBalling.save(correntBallingScore);
		
		correntBatingScore.setAvgSr(0);
		correntBatingScore.setFours(0);
		correntBatingScore.setSix(0);
		correntBatingScore.setTotalBall(0);
		correntBatingScore.setTotalRun(0);
		correntBatingScore.setScoreid(null);
		//correntScoreBatting.save(correntBatingScore);
		MatchPlayer ma=new MatchPlayer();
		ma.setCorrentBallingScore(correntBallingScore);
		ma.setCorrentBatingScore(correntBatingScore);
		ma.setPlayers(players);
	
		//matchesPlayerRepo.save(ma);
		return ma;
	}
}
