package com.example.demo.POJO.Matches;

import org.hibernate.annotations.GenericGenerator;

import com.example.demo.POJO.Score.CorrentBallingScore;
import com.example.demo.POJO.Score.CorrentBatingScore;
import com.example.demo.POJO.players.Players;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matchplayer")
public class MatchPlayer {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "player")
	private String id;
    @ManyToOne
    @JoinColumn(name="player_id", nullable=false)
	private Players players;
    @ManyToOne
    @JoinColumn(name="batting_id")
	private CorrentBallingScore correntBallingScore;
    @ManyToOne
    @JoinColumn(name="balling_id")
	private CorrentBatingScore correntBatingScore;
	public MatchPlayer(String id, Players players, CorrentBallingScore correntBallingScore,
			CorrentBatingScore correntBatingScore) {
		super();
		this.id = id;
		this.players = players;
		this.correntBallingScore = correntBallingScore;
		this.correntBatingScore = correntBatingScore;
	}
	public MatchPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Players getPlayers() {
		return players;
	}
	public void setPlayers(Players players) {
		this.players = players;
	}
	public CorrentBallingScore getCorrentBallingScore() {
		return correntBallingScore;
	}
	public void setCorrentBallingScore(CorrentBallingScore correntBallingScore) {
		this.correntBallingScore = correntBallingScore;
	}
	public CorrentBatingScore getCorrentBatingScore() {
		return correntBatingScore;
	}
	public void setCorrentBatingScore(CorrentBatingScore correntBatingScore) {
		this.correntBatingScore = correntBatingScore;
	}
	
	
	
}
