package hh.swd20.FantasyFootball;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.FantasyFootball.domain.League;
import hh.swd20.FantasyFootball.domain.LeagueRepository;
import hh.swd20.FantasyFootball.domain.Player;
import hh.swd20.FantasyFootball.domain.PlayerRepository;
import hh.swd20.FantasyFootball.domain.Team;
import hh.swd20.FantasyFootball.domain.TeamRepository;

@SpringBootApplication
public class FantasyFootballApplication {
	private static final Logger log = LoggerFactory.getLogger(FantasyFootballApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FantasyFootballApplication.class, args);
	}

	@Bean
	public CommandLineRunner footballDemo(PlayerRepository prepository, TeamRepository trepository, LeagueRepository lrepository) {
		return (args) -> {
			log.info("save some sample data");
			League league1 = new League("Premier League");
			lrepository.save(league1);
			
			Team team1 = new Team("Arsenal", league1);
			Team team2 = new Team("Liverpool", league1);
			trepository.save(team1);
			trepository.save(team2);
			
			prepository.save(new Player("Gabriel Jesus", 0, 0, 0, team1));
			prepository.save(new Player("Darwin Nunez", 0, 0, 0, team2));
			
			log.info("fetch test data");
			for (League league : lrepository.findAll()) {
				log.info(league.toString());
			}
			for (Team team : trepository.findAll()) {
				log.info(team.toString());
			}
			for (Player player : prepository.findAll()) {
				log.info(player.toString());
			}
		};
	}
}
