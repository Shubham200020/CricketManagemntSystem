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
@Table(name = "scorebatting")
public class ScoreBating {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "score_id")
	private String scoreid;
	
	@Column(name = "total_ball_play")
	private int totalBall;
	@Column(name = "Total_Runs")
	private int totalRun;
	@Column(name = "avg_Strike_Rate")
	private float avgSr;
	@Column(name = "Sixs")
	private int six;
	@Column(name = "Foures")
	private int fours;
	@Column(name = "century")
	private int century;
	
	@Column(name = "halfcentury")
	private int halfCentury;
	
	@OneToOne()
    @JoinColumn(name = "player_id")
	private Players players;
	 
	public ScoreBating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ScoreBating(String scoreid, int totalBall, int totalRun, float avgSr, int six, int fours, int century,
			int halfCentury, Players players) {
		super();
		this.scoreid = scoreid;
		this.totalBall = totalBall;
		this.totalRun = totalRun;
		this.avgSr = avgSr;
		this.six = six;
		this.fours = fours;
		this.century = century;
		this.halfCentury = halfCentury;
		this.players = players;
	}

	public int getCentury() {
		return century;
	}

	public void setCentury(int century) {
		this.century = century;
	}

	public int getHalfCentury() {
		return halfCentury;
	}

	public void setHalfCentury(int halfCentury) {
		this.halfCentury = halfCentury;
	}

	public String getScoreid() {
		return scoreid;
	}
	public void setScoreid(String scoreid) {
		this.scoreid = scoreid;
	}
	public int getTotalBall() {
		return totalBall;
	}
	public void setTotalBall(int totalBall) {
		this.totalBall = totalBall;
	}
	public int getTotalRun() {
		return totalRun;
	}
	public void setTotalRun(int totalRun) {
		this.totalRun = totalRun;
	}
	public float getAvgSr() {
		return avgSr;
	}
	public void setAvgSr(float avgSr) {
		this.avgSr = avgSr;
	}
	public int getSix() {
		return six;
	}
	public void setSix(int six) {
		this.six = six;
	}
	public int getFours() {
		return fours;
	}
	public void setFours(int fours) {
		this.fours = fours;
	}
	public Players getPlayers() {
		return players;
	}
	public void setPlayers(Players players) {
		this.players = players;
	}
	
	

}
