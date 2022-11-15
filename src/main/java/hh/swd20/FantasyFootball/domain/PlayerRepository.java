package hh.swd20.FantasyFootball.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long>{
	
	// luo listan pelaajista ja järjestää ne laskevaan järjestykseen maalien/syöttöjen mukaan
	List<Player> findAllByOrderByGoalsDesc();
	List<Player> findAllByOrderByAssistsDesc();

	Optional<Player> findById(Long playerid);
}
