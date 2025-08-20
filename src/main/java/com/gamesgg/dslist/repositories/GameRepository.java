package com.gamesgg.dslist.repositories;

import com.gamesgg.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
