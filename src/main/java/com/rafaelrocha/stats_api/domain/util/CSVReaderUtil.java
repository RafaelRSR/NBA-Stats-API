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

                PlayerDTO playerDTO = getPlayer(infos);
                playerDTOS.add(playerDTO);
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return playerDTOS;
    }

    private static PlayerDTO getPlayer(String[] infos) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName(infos[0]);
        playerDTO.setPosition(infos[1]);
        playerDTO.setTeam(infos[3]);
        playerDTO.setAge(Integer.parseInt(infos[2])); // Ajusta a idade
        playerDTO.setPointsPerGame(Double.parseDouble(infos[28])); // Ajusta pontos por jogo
        playerDTO.setAssistsPerGame(Double.parseDouble(infos[22])); // Ajusta assistências
        playerDTO.setReboundsPerGame(Double.parseDouble(infos[21])); // Ajusta rebotes
        playerDTO.setFieldGoalPercentage(parsePercentage(infos[9])); // Ajusta FG%
        playerDTO.setThreePointPercentage(parsePercentage(infos[12])); // Ajusta 3P%

        return playerDTO;
    }

    private static float parsePercentage(String value) {
        try {
            float percentage = Float.parseFloat(value);
            if (percentage < 0 || percentage > 1) {
                return 0.0f;
            }
            return percentage * 100;
        } catch (NumberFormatException e) {
            return 0.0f;
        }
    }
}
