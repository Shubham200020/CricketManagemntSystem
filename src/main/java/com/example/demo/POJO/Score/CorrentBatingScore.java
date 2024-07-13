package com.example.demo.POJO.Score;

import org.hibernate.annotations.GenericGenerator;

import com.example.demo.POJO.players.Players;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "corrent_bating_")
public class CorrentBatingScore {
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
	@Column(name = "halfCentury")
	private int halfCentury;

	@Column(name = "century")
	private int century;
	
	public CorrentBatingScore() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CorrentBatingScore(String scoreid, int totalBall, int totalRun, float avgSr, int six, int fours,
			int halfCentury, int century) {
		super();
		this.scoreid = scoreid;
		this.totalBall = totalBall;
		this.totalRun = totalRun;
		this.avgSr = avgSr;
		this.six = six;
		this.fours = fours;
		this.halfCentury = halfCentury;
		this.century = century;
	}

	public int getHalfCentury() {
		return halfCentury;
	}

	public void setHalfCentury(int halfCentury) {
		this.halfCentury = halfCentury;
	}

	public int getCentury() {
		return century;
	}

	public void setCentury(int century) {
		this.century = century;
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
	
	
}
