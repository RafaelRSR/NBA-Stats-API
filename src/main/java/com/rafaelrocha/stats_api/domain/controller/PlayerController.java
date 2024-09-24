package com.rafaelrocha.stats_api.domain.controller;

import com.rafaelrocha.stats_api.domain.dto.PlayerDTO;
import com.rafaelrocha.stats_api.domain.exceptions.PlayerNotFoundException;
import com.rafaelrocha.stats_api.domain.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        List<PlayerDTO> playersDTO = playerService.getAllPlayers();
        return ResponseEntity.ok(playersDTO);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getPlayerByName(@PathVariable String name) {
        try{
            PlayerDTO playerDTO = playerService.getPlayerByName(name);
            return ResponseEntity.ok(playerDTO);
        } catch (PlayerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found with name: " + name);
        }
    }

    @GetMapping("/team/{teamName}")
    public ResponseEntity<List<PlayerDTO>> getPlayersByTeam(@PathVariable String teamName) {
        List<PlayerDTO> playersDTO = playerService.getPlayersByTeam(teamName);
        return ResponseEntity.ok(playersDTO);
    }
}
