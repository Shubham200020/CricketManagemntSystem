package com.example.demo.POJO.Score;

import org.hibernate.annotations.GenericGenerator;

import com.example.demo.POJO.players.Players;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "scoreballing")
public class ScoreBalling {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "score_id")
	private String scoreid;
	@Column(name = "noball")
	private int noBall;
	@Column(name = "wicket")
	private int wickets;
	@Column(name = "wideball")
	private int wideBall;
	@Column(name = "run")
	private int run;
	@Column(name = "Overs")
	private float ballOver;
	@Column(name = "MedernOver")
	private int medernOver;
	@Column(name = "eco")
	private float econimy;
	@OneToOne()
    @JoinColumn(name = "player_id")
	private Players players;
	public ScoreBalling() {
		super();
		
	}
	public String getScoreid() {
		return scoreid;
	}
	public void setScoreid(String scoreid) {
		this.scoreid = scoreid;
	}
	public int getNoBall() {
		return noBall;
	}
	public void setNoBall(int noBall) {
		this.noBall = noBall;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public int getWideBall() {
		return wideBall;
	}
	public void setWideBall(int wideBall) {
		this.wideBall = wideBall;
	}
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	public float getBallOver() {
		return ballOver;
	}
	public void setBallOver(float ballOver) {
		this.ballOver = ballOver;
	}
	public int getMedernOver() {
		return medernOver;
	}
	public void setMedernOver(int medernOver) {
		this.medernOver = medernOver;
	}
	public float getEconimy() {
		return econimy;
	}
	public void setEconimy(float econimy) {
		this.econimy = econimy;
	}
	public Players getPlayers() {
		return players;
	}
	public void setPlayers(Players players) {
		this.players = players;
	}
	public ScoreBalling(String scoreid, int noBall, int wickets, int wideBall, int run, float ballOver, int medernOver,
			float econimy, Players players) {
		super();
		this.scoreid = scoreid;
		this.noBall = noBall;
		this.wickets = wickets;
		this.wideBall = wideBall;
		this.run = run;
		this.ballOver = ballOver;
		this.medernOver = medernOver;
		this.econimy = econimy;
		this.players = players;
	}
	

}
