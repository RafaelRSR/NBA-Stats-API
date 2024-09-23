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
        
        try(CSVReader reader = new CSVReader(new FileReader(CSV_FILE_PATH))) {
            List<String[]> records = reader.readAll();
            
            for(int i = 1; i < records.size(); i++) {
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
        playerDTO.setName(infos[1]);
        playerDTO.setTeam(infos[2]);
        playerDTO.setPosition(infos[3]);
        playerDTO.setAge(Integer.parseInt(infos[4]));
        playerDTO.setPointsPerGame(Double.parseDouble(infos[5]));
        playerDTO.setAssistsPerGame(Double.parseDouble(infos[6]));
        playerDTO.setReboundsPerGame(Double.parseDouble(infos[7]));
        playerDTO.setFieldGoalPercentage(Double.parseDouble(infos[8]));
        playerDTO.setThreePointPercentage(Double.parseDouble(infos[9]));
        return playerDTO;
    }
}
