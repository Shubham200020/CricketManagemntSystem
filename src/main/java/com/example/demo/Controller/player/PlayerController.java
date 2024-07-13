package com.example.demo.Controller.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Controller.score.ContollerScore;
import com.example.demo.POJO.Score.CorrentBatingScore;
import com.example.demo.POJO.Score.ScoreBalling;
import com.example.demo.POJO.Score.ScoreBating;
import com.example.demo.POJO.players.Players;
import com.example.demo.REPOSITORY.players.playersRepo;
import com.example.demo.REPOSITORY.score.ScoreBallingRepo;
import com.example.demo.REPOSITORY.score.ScoreBattingRepo;
import com.example.demo.service.ScoreCalculate;

@RestController
@RequestMapping("/player")
@CrossOrigin("http://localhost:4200/")
public class PlayerController {
	@Autowired
	private ScoreBallingRepo scoreBallingRepo;
	@Autowired
	private ScoreBattingRepo scoreBattingRepo;
	@Autowired
	private playersRepo playersrepo;
	@PostMapping("/insert-player")
	public Players insertPlayer(@RequestBody Players players) {
		Players ps =null;
		if(players.getPlayerid()==null)
			 ps =playersrepo.save(players);
		else {
			Players pss=playersrepo.findById(players.getPlayerid()).orElse(null);
			if(pss.getRole()==null)
			{
				ScoreCalculate st=new ScoreCalculate();
				ScoreBalling scoreBalling=new ScoreBalling();
				ScoreBating sr=null;
				//ContollerScore contollerScore=new ContollerScore();
				ScoreBating scoreBating=new ScoreBating();
				scoreBating.setScoreid(null);
				sr=st.getEntryBating(scoreBating);
				sr.setPlayers(players);
				sr=scoreBattingRepo.save(sr);
				
				
				ScoreBalling ss=null;
				
				scoreBalling.setScoreid(null);
				ss=st.avgEntryBall(scoreBalling);
				ss.setPlayers(players);
				scoreBallingRepo.save(ss);
				ps =playersrepo.save(players);
			}
			else {
				String email=players.getEmail().toLowerCase();
				players.setEmail(email);
				 ps =playersrepo.save(players);
			}
			
		}
		
		return ps;
	}
	@GetMapping("/display-players")
	public List<Players>displayPlayers(){
		List<Players> players=playersrepo.findAll();
		return players;
	}
	@GetMapping("/display-players-role")
	public List<Players>displayPlayersRole(){
		List<Players> players=playersrepo.playeRole();
		return players;
	}
	@GetMapping("/find-by-id/{id}")
	public Players PlayerById(@PathVariable String id) {
		Players players=playersrepo.findById(id).get();
		return players;
	}
	@PostMapping("/login/eml")
	public Players PlayerEmailLigin(@RequestBody Players player) {
		List<Players>playe=playersrepo.playeRoleNotNull();
		player.setEmail(player.getEmail().toLowerCase());
		for(Players pl:playe) {
			if(pl.getEmail().toLowerCase().matches(player.getEmail().toLowerCase())) {
				if(pl.getPassword().matches(player.getPassword())) {
					return pl;
				}
				
			}
		}
		return null;
	}
	@PostMapping("/login/phn")
	public Players PlayerPhoneLigin(@RequestBody Players player) {
		List<Players>playe=playersrepo.playeRoleNotNull();
		
		for(Players pl:playe) {
			if(pl.getPhonenumber().matches(player.getPhonenumber())) {
				if(pl.getPassword().matches(player.getPassword())) {
					return pl;
				}
				
			}
		}
		return null;
	}
	@GetMapping("/deleteAll")
	public void DeleteAllData() {
		scoreBallingRepo.deleteAll();
		scoreBattingRepo.deleteAll();
		
		playersrepo.deleteAll();
	}
	@PostMapping("/delete-present")
	private Players deletePlayer(@RequestBody Players players) {
	// ScoreBating scoreBatin=scoreBattingRepo.findbyPlayerid(players.getPlayerid());
	 //ScoreBalling scBalling=scoreBallingRepo.findByPlayerid(players.getPlayerid());
	 //scoreBattingRepo.delete(scoreBatin);
	 //scoreBallingRepo.delete(scBalling);
	 playersrepo.delete(players);
		return players;
	}
	
}
