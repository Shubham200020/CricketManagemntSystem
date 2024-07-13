package com.example.demo.Controller.Turnament;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.POJO.Matches.MatchPlayer;
import com.example.demo.POJO.Matches.Turnaments;
import com.example.demo.POJO.Score.CorrentBallingScore;
import com.example.demo.POJO.Score.CorrentBatingScore;
import com.example.demo.POJO.players.Players;
import com.example.demo.REPOSITORY.matches.MatchesPlayerRepo;
import com.example.demo.REPOSITORY.matches.TurnamentRepo;
import com.example.demo.REPOSITORY.players.playersRepo;
import com.example.demo.REPOSITORY.score.CorrentScoreBalling;
import com.example.demo.REPOSITORY.score.CorrentScoreBatting;
import com.example.demo.service.CorrentScoreService;

@RestController
@RequestMapping("/turnament")
@CrossOrigin("http://localhost:4200")
public class TurnamentController {
	@Autowired
	TurnamentRepo turnamentRepo;
	@Autowired
	CorrentScoreBalling correntScoreBalling;
	@Autowired
	CorrentScoreBatting correntScoreBatting;
	@Autowired
	MatchesPlayerRepo matchesPlayerRepo;
	@Autowired
	playersRepo playersRepo;
	
	
	@GetMapping("/delete-all")
	public void deleteAll() {
		turnamentRepo.deleteAll();
		matchesPlayerRepo.deleteAll();
		correntScoreBatting.deleteAll();
		correntScoreBalling.deleteAll();
	}
	@GetMapping("/display-players-team1/{id}")
	public List<Players> displayPlayers1ByTurnamentId(@PathVariable String id){
		List<Players> players=new LinkedList<>();
		List<MatchPlayer> pla1=	turnamentRepo.findByTeam1(id);
		for(MatchPlayer pla: pla1) {
			players.add(pla.getPlayers());
		}
		return players;
	}
	@GetMapping("/display-players-team2/{id}")
	public List<Players> displayPlayers2ByTurnamentId(@PathVariable String id){
		List<Players> players=new LinkedList<>();
		List<MatchPlayer> pla1=	turnamentRepo.findByTeam2(id);
		for(MatchPlayer pla: pla1) {
			players.add(pla.getPlayers());
		}
		return players;
	}
	@GetMapping("/display/matchPlayer/{id}")
	public List<Players> insertMatchPlayer(@PathVariable String id) {
	List<MatchPlayer> pla1=	turnamentRepo.findByTeam1(id);
	List<MatchPlayer> pla2=	turnamentRepo.findByTeam2(id);
	List<Players> players=playersRepo.findAll();
	
	
	int playercount=players.size();

	if(players.size()>0)
	for(int i=0;i<players.size();i++) {
		if(players.size()>0) {
		System.out.println("Player:"+players.get(i).getName()+" "+i);
		if(pla1.size()>0) {
		for(int j=0;j<pla1.size() ;j++) {
			
			if(players.get(i).getPlayerid().equals(pla1.get(j).getPlayers().getPlayerid())) {
				
				playercount=players.size();
				System.out.println(playercount);
				players.remove(i);
				playercount=players.size();
				pla1.remove(j);
				i=0;
				
				//break;
				
			}
			
		}
		}
		else if(pla2.size()>0)
		for(int j=0;j<pla2.size();j++) {
			if(players.get(i).getPlayerid().equals(pla2.get(j).getPlayers().getPlayerid())) {
				
				players.remove(i);
				
				pla2.remove(j);
				
				i=0;	
			}	
		}
		else {
			return null;
		}
		}
		else {
			return null;
			
		}
	}
	else {
		return null;
	}
	
	
	
		return players;
	}
	@PostMapping("/add-turnament-team/{id}/{cnt}")
	public Turnaments addTurnamentteam(@PathVariable String id,@PathVariable String cnt,@RequestBody Players players) {
		Turnaments turnaments=turnamentRepo.findById(id).get();
		
			MatchPlayer matchPlayer=new MatchPlayer();
			CorrentBallingScore correntBallingScore=new CorrentBallingScore();
			correntBallingScore=CorrentScoreService.correntBallingScore(correntBallingScore);
			CorrentBatingScore correntBatingScore=new CorrentBatingScore();
			correntBatingScore=CorrentScoreService.correntBatingScore(correntBatingScore);
			matchPlayer.setId(null);
			correntBatingScore=correntScoreBatting.save(correntBatingScore);
			correntBallingScore=correntScoreBalling.save(correntBallingScore);
			
			
			matchPlayer.setCorrentBallingScore(correntBallingScore);
			matchPlayer.setCorrentBatingScore(correntBatingScore);
			matchPlayer.setPlayers(players);
			matchPlayer=matchesPlayerRepo.save(matchPlayer);
			if(cnt.equals("1")) {
				List<MatchPlayer>mh1=new ArrayList<>();
				mh1=turnaments.getTeam1();	
			mh1.add(matchPlayer);
			turnaments.setTeam1(mh1);
			
			//turnaments.setTeam2(turnaments.getTeam2());
			}
			else if(cnt.equals("2")) {
				List<MatchPlayer>mh1=new ArrayList<>();
				mh1=turnaments.getTeam2();	
			mh1.add(matchPlayer);
			turnaments.setTeam2(mh1);
			
			//turnaments.setTeam1(turnaments.getTeam1());
			}
			
			turnaments=turnamentRepo.save(turnaments);
		
		return turnaments;
	}
	
	@PostMapping("/insert-data")
	public Turnaments getTuramentByid(@RequestBody Turnaments turnaments) {
		
		turnaments=turnamentRepo.save(turnaments);
		return turnaments;
	}
	
	@GetMapping("/get-turnament")
	public List<Turnaments> agetTurnament() {
		List<Turnaments> turnaments=turnamentRepo.findAll();
		return turnaments;
	}
	@PostMapping("/insert-element")
	private Turnaments insertTur(@RequestBody Turnaments turnaments) {
		turnaments=turnamentRepo.save(turnaments);
		return turnaments;
	}
	
	@PostMapping("/delete-element")
	private Turnaments delete(@RequestBody Turnaments turnaments) {
		turnamentRepo.delete(turnaments);
		return turnaments;
	}
}
