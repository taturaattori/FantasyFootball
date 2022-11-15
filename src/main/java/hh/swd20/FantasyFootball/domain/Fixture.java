package hh.swd20.FantasyFootball.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Fixture {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long playerid;
	private Long id;
	private Team homeTeam;
	private Team awayTeam;
	private int homeGoals;
	private int awayGoals;
	
	

}
