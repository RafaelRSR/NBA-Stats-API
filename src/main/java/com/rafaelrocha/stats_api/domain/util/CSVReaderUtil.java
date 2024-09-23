package com.rafaelrocha.stats_api.domain.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.rafaelrocha.stats_api.domain.dto.PlayerDTO;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVReaderUtil {

    private static final String CSV_FILE_PATH = "src/main/resources/NBA_2024_per_game.csv";

    public List<PlayerDTO> readPlayersFromCSV() {
        List<PlayerDTO> playerDTOS = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE_PATH))) {
            List<String[]> records = reader.readAll();

            for (int i = 1; i < records.size(); i++) {
                String[] infos = records.get(i);
                if (infos.length < 10) {
                    continue;
                }

                try {
                    PlayerDTO playerDTO = getPlayer(infos);
                    playerDTOS.add(playerDTO);
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter dados para o jogador: " + infos[1]);
                }
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return playerDTOS;
    }

    private static PlayerDTO getPlayer(String[] infos) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName(infos[0]);
        playerDTO.setTeam(infos[3]);
        playerDTO.setPosition(infos[1]);
        playerDTO.setAge(Integer.parseInt(infos[2]));
        playerDTO.setPointsPerGame(Double.parseDouble(infos[28]));
        playerDTO.setAssistsPerGame(Double.parseDouble(infos[22]));
        playerDTO.setReboundsPerGame(Double.parseDouble(infos[21]));
        playerDTO.setFieldGoalPercentage(Double.parseDouble(infos[9]));
        playerDTO.setThreePointPercentage(Double.parseDouble(infos[12]));
        return playerDTO;
    }
}