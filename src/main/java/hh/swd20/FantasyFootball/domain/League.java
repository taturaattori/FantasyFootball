package hh.swd20.FantasyFootball.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class League {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long leagueid;
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "league")
	private List<Team> teams;

	public League(String name) {
		super();
		this.name = name;
	}
	
	public League() {
		
	}

	public Long getLeagueid() {
		return leagueid;
	}

	public void setLeagueid(Long leagueid) {
		this.leagueid = leagueid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	@Override
	public String toString() {
		return "League [leagueid=" + leagueid + ", name=" + name + "]";
	}
	
	
}
