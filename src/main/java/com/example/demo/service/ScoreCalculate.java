package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.POJO.Score.ScoreBalling;
import com.example.demo.POJO.Score.ScoreBating;

@Service
public class ScoreCalculate {
	public  ScoreBating getEntryBating(ScoreBating corrent) {
		float sr;
		int run=corrent.getTotalRun();
		int ballface=corrent.getTotalBall();
		int four=corrent.getFours();
		int six=corrent.getSix();
		
		
		corrent.setFours(four);
		corrent.setTotalBall(ballface);
		corrent.setSix(six);
		corrent.setTotalRun(run);
		corrent.setAvgSr(0);
		corrent.setCentury(0);
		corrent.setHalfCentury(0);
		corrent.setTotalRun(0);
	
		return corrent;
	}
	public  ScoreBating getBating(ScoreBating corrent,ScoreBating previes) {
		float sr;
		int run=previes.getTotalRun();
		int ballface=previes.getTotalBall();
		int four=previes.getFours();
		int six=previes.getSix();
		int cen=previes.getCentury();
		int halfCen=previes.getHalfCentury();
		run=run+corrent.getTotalRun();
		ballface=ballface+corrent.getTotalBall();
		sr=((float)run/ballface)*100;
		four=four+corrent.getFours();
		six=six+corrent.getSix();
		cen=cen+corrent.getCentury();
		halfCen=halfCen+corrent.getHalfCentury();
		corrent.setCentury(cen);
		corrent.setHalfCentury(halfCen+corrent.getHalfCentury());
		corrent.setFours(four);
		corrent.setTotalBall(ballface);
		corrent.setSix(six);
		corrent.setTotalRun(run);
		corrent.setAvgSr(sr);
		return corrent;
	}
	public  ScoreBalling avgEntryBall(ScoreBalling scoreBalling) {
		scoreBalling.setBallOver(0);
		scoreBalling.setEconimy(0);
		scoreBalling.setMedernOver(0);
		scoreBalling.setNoBall(0);
		scoreBalling.setRun(0);
		scoreBalling.setWickets(0);
		scoreBalling.setWideBall(0);
		return scoreBalling;
	}
	public  ScoreBalling avgBall(ScoreBalling corrent,ScoreBalling previus) {
		float over=previus.getBallOver()+corrent.getBallOver();
		int run=previus.getRun()+corrent.getRun();
		float economy=(float)run/over;
		int wicket=previus.getWickets()+corrent.getWickets();
		int medianOver=previus.getMedernOver()+corrent.getMedernOver();
		int noball=previus.getNoBall()+corrent.getNoBall();
		int wideBall=previus.getWideBall()+corrent.getWideBall();
		corrent.setBallOver(over);
		corrent.setEconimy(economy);
		corrent.setRun(run);
		corrent.setWickets(wicket);
		corrent.setNoBall(noball);
		corrent.setWideBall(wideBall);
		corrent.setMedernOver(medianOver);
		return corrent;
	}

}
