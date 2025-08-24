package com.gamesgg.dslist.controllers;


import com.gamesgg.dslist.dto.GameDTO;
import com.gamesgg.dslist.dto.GameListDTO;
import com.gamesgg.dslist.dto.GameMinDTO;
import com.gamesgg.dslist.dto.ReplacementDTO;
import com.gamesgg.dslist.projections.GameMinProjection;
import com.gamesgg.dslist.services.GameListService;
import com.gamesgg.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;


    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO replacementDTO){
        gameListService.move(listId, replacementDTO.getSourceIndex(), replacementDTO.getDestinationIndex());
    }
}
