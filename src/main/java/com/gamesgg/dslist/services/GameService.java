package com.gamesgg.dslist.services;

import com.gamesgg.dslist.dto.GameDTO;
import com.gamesgg.dslist.dto.GameMinDTO;
import com.gamesgg.dslist.entities.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gamesgg.dslist.repositories.GameRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);

        /*  Básicamente o retorno acima é o que ocorre neste comentário.
        GameDTO dto = new GameDTO(result);
        return dto;
        */
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
       List<Game> result = gameRepository.findAll();
       return result.stream().map(x -> new GameMinDTO(x)).toList();

    }

}