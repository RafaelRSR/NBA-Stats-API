package com.rafaelrocha.stats_api.domain.service;

import com.rafaelrocha.stats_api.domain.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {
    List<PlayerDTO> getAllPlayers();
    PlayerDTO getPlayerById(int id);
    List<PlayerDTO> getPlayersByTeam(String teamName);
    List<PlayerDTO> getPlayersByStatAscending(String stat);
    List<PlayerDTO> getPlayersByStatDescending(String stat);
}
