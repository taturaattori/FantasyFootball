package hh.swd20.FantasyFootball;


import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.FantasyFootball.domain.LeagueRepository;
import hh.swd20.FantasyFootball.domain.Player;
import hh.swd20.FantasyFootball.domain.PlayerRepository;
import hh.swd20.FantasyFootball.domain.Team;
import hh.swd20.FantasyFootball.domain.TeamRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTests {
	
	@Autowired
	private PlayerRepository repository;
	
	@Autowired
	private TeamRepository trepository;
	
	@Autowired
	private LeagueRepository lrepository;
	
	SimpleDateFormat fdate = new SimpleDateFormat("dd.MM.yyyy");
	
	@Test
	public void createNewPlayer() throws ParseException {
		Player player = new Player("Pelimies", "Suomi", fdate.parse("01.01.2000"), 0, 0, 0, null);
		repository.save(player);
		assertThat(player.getName()).isNotNull();
	}
	
	@Test
	public void createNewTeam() {
		Team team = new Team("HJK");
		trepository.save(team);
		assertThat(team.getName()).isNotNull();
	}
	
	
}
