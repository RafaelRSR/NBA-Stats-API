package com.rafaelrocha.stats_api.domain.impl;

import com.rafaelrocha.stats_api.domain.dto.PlayerDTO;
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
        return List.of();
    }

    @Override
    public PlayerDTO getPlayerById(int id) {
        return null;
    }

    @Override
    public List<PlayerDTO> getPlayersByTeam(String teamName) {
        return List.of();
    }

    @Override
    public List<PlayerDTO> getPlayersByStatAscending(String stat) {
        return List.of();
    }

    @Override
    public List<PlayerDTO> getPlayersByStatDescending(String stat) {
        return List.of();
    }
}
