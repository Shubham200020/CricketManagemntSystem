package com.example.demo.Controller.score;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.POJO.Matches.MatchPlayer;
import com.example.demo.POJO.Score.CorrentBallingScore;
import com.example.demo.POJO.Score.CorrentBatingScore;
import com.example.demo.POJO.Score.ScoreBalling;
import com.example.demo.POJO.Score.ScoreBating;
import com.example.demo.POJO.players.Players;
import com.example.demo.REPOSITORY.matches.MatchesPlayerRepo;
import com.example.demo.REPOSITORY.players.playersRepo;
import com.example.demo.REPOSITORY.score.CorrentScoreBalling;
import com.example.demo.REPOSITORY.score.CorrentScoreBatting;
import com.example.demo.REPOSITORY.score.ScoreBallingRepo;
import com.example.demo.REPOSITORY.score.ScoreBattingRepo;
import com.example.demo.service.CorrentScoreService;
import com.example.demo.service.ScoreCalculate;



@RestController
@RequestMapping("/player/score")
@CrossOrigin("http://localhost:4200/")
public class ContollerScore {

	@Autowired
	private ScoreBallingRepo scoreBallingRepo;
	@Autowired
	private ScoreBattingRepo scoreBattingRepo;
	@Autowired
	private CorrentScoreBatting correntScoreBatting;
	@Autowired
	private CorrentScoreBalling correntScoreBalling;
	@Autowired
	MatchesPlayerRepo matchesPlayerRepo;
	@Autowired
	playersRepo playersRepo;
	
	@PostMapping("/insert-player-turn")
	public MatchPlayer insertPlayer(@RequestBody Players players) {
		CorrentBatingScore correntBatingScore=new CorrentBatingScore();
		CorrentBallingScore correntBallingScore=new CorrentBallingScore();
		correntBallingScore.setScoreid(null);
		correntBallingScore.setBallOver(0.0f);
		correntBallingScore.setEconimy(0);
		correntBallingScore.setNoBall(0);
		correntBallingScore.setMedernOver(0);
		correntBallingScore.setRun(0);
		correntBallingScore.setWickets(0);
		correntBallingScore.setWideBall(0);
		
		correntScoreBalling.save(correntBallingScore);
		
		correntBatingScore.setAvgSr(0);
		correntBatingScore.setFours(0);
		correntBatingScore.setSix(0);
		correntBatingScore.setTotalBall(0);
		correntBatingScore.setTotalRun(0);
		//correntScoreBatting.save(correntBatingScore);
		correntScoreBatting.save(correntBatingScore);
		MatchPlayer ma=new MatchPlayer();
		ma.setCorrentBallingScore(correntBallingScore);
		ma.setCorrentBatingScore(correntBatingScore);
		ma.setPlayers(players);
		ma=matchesPlayerRepo.save(ma);
		return ma;
	}
	@PostMapping("/insert-bat")
	public ScoreBating insertData(@RequestBody ScoreBating scoreBating) {
		ScoreCalculate st=new ScoreCalculate();
		ScoreBating sr=null;
		if(scoreBating.getScoreid()==null) {
			sr.setScoreid(null);
			sr=st.getEntryBating(scoreBating);
			
			sr=scoreBattingRepo.save(sr);
		}
		else if(scoreBating.getScoreid()!=null) {
			ScoreBating sr1=scoreBattingRepo.findById(scoreBating.getScoreid()).orElse(null);
			sr=st.getBating(scoreBating,sr1);
			sr=scoreBattingRepo.save(sr);	
			}
		return sr;
	}
	
	@GetMapping("/get-bat")
	public List<ScoreBating> getBatData() {
		List<ScoreBating> data=scoreBattingRepo.findAll();
		
		return data;
	}
	@GetMapping("/get-bat-by-id/{id}")
	public ScoreBating getBatById(@PathVariable String id) {
		ScoreBating scoreBating=scoreBattingRepo.findById(id).orElse(null);
		return scoreBating;
	}
	@GetMapping("/del-bat-by-id/{id}")
	public ScoreBating delBatById(@PathVariable String id) {
		ScoreBating scoreBating=scoreBattingRepo.findById(id).orElse(null);
		if(scoreBating!=null)
		scoreBattingRepo.deleteById(id);
		
		return scoreBating;
	}
	@GetMapping("/display-ball")
	public List<ScoreBalling>  setBallData() {
		List<ScoreBalling> ball=scoreBallingRepo.findAll();
	 return ball;
	}
	@GetMapping("/find-bat-player-id/{id}")
	public ScoreBalling findBatByPlayerId(String id)
	{
		
		ScoreBalling sc=scoreBallingRepo.findByPlayerid(id);
		return sc;
	}
	@GetMapping("/find-ball-player-id/{id}")
	public ScoreBalling findBallByPlayerId(String id)
	{
		//Players players=playersRepo.findById(id).get();
		
		ScoreBalling sc=scoreBallingRepo.findByPlayerid(id);
		return sc;
	}
	@GetMapping("/del-ball-by-id/{id}")
	public ScoreBalling delBallById(@PathVariable String id) {
		ScoreBalling scoreBating=scoreBallingRepo.findById(id).orElse(null);
		if(scoreBating!=null)
		scoreBattingRepo.deleteById(id);
		
		return scoreBating;
	}
	@GetMapping("/get-ball-by-id/{id}")
	public ScoreBalling getBallById(@PathVariable String id) {
		ScoreBalling scoreBating=scoreBallingRepo.findById(id).orElse(null);
		return scoreBating;
	}
	@PostMapping("/insert-ball")
	public ScoreBalling getBallData(@RequestBody ScoreBalling scoreBalling) {
		
		ScoreCalculate st=new ScoreCalculate();
		ScoreBalling scoreBalling2=null;
		if(scoreBalling.getScoreid()==null) {
			scoreBalling2=st.avgEntryBall(scoreBalling);
		}
		else if(scoreBalling.getScoreid()!=null) {
			scoreBalling2=scoreBallingRepo.findById(scoreBalling.getScoreid()).orElse(null);
			scoreBalling2=st.avgBall(scoreBalling, scoreBalling2);
			
		}
		scoreBalling=scoreBallingRepo.save(scoreBalling2);
		return scoreBalling;
	}


}
