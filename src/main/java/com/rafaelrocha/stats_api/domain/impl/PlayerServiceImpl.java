package com.rafaelrocha.stats_api.domain.impl;

import com.rafaelrocha.stats_api.domain.dto.PlayerDTO;
import com.rafaelrocha.stats_api.domain.exceptions.PlayerNotFoundException;
import com.rafaelrocha.stats_api.domain.service.PlayerService;
import com.rafaelrocha.stats_api.domain.util.CSVReaderUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final CSVReaderUtil csvReaderUtil;

    public PlayerServiceImpl(CSVReaderUtil csvReaderUtil) {
        this.csvReaderUtil = csvReaderUtil;
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        return csvReaderUtil.readPlayersFromCSV();
    }

    @Override
    public PlayerDTO getPlayerByName(String name) {
        List<PlayerDTO> players = csvReaderUtil.readPlayersFromCSV();
        return players.stream()
                .filter(player -> player.getName().equalsIgnoreCase(name)).findFirst().orElseThrow(PlayerNotFoundException::new);
    }

    @Override
    public List<PlayerDTO> getPlayersByTeam(String teamName) {
        List<PlayerDTO> players = csvReaderUtil.readPlayersFromCSV();
        return players.stream()
                .filter(playerDTO -> playerDTO.getTeam().equalsIgnoreCase(teamName))
                .toList();
    }
}
