package com.rafaelrocha.stats_api.domain.service;

import com.rafaelrocha.stats_api.domain.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {
    List<PlayerDTO> getAllPlayers();
    PlayerDTO getPlayerByName(String name);
    List<PlayerDTO> getPlayersByTeam(String teamName);
}
