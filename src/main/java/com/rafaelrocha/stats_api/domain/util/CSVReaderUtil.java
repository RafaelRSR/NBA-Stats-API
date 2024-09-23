package com.rafaelrocha.stats_api.domain.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.rafaelrocha.stats_api.domain.model.Player;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVReaderUtil {
    
    private static final String CSV_FILE_PATH = "src/main/resources/NBA_2024_per_game.csv";
    
    public List<Player> readPlayersFromCSV() {
        List<Player> players = new ArrayList<>();
        
        try(CSVReader reader = new CSVReader(new FileReader(CSV_FILE_PATH))) {
            List<String[]> records = reader.readAll();
            
            for(int i = 1; i < records.size(); i++) {
                String[] infos = records.get(i);

                Player player = getPlayer(infos);

                players.add(player);
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return players;
    }

    private static Player getPlayer(String[] infos) {
        Player player = new Player();
        player.setName(infos[1]);
        player.setTeam(infos[2]);
        player.setPosition(infos[3]);
        player.setAge(Integer.parseInt(infos[4]));
        player.setPointsPerGame(Double.parseDouble(infos[5]));
        player.setAssistsPerGame(Double.parseDouble(infos[6]));
        player.setReboundsPerGame(Double.parseDouble(infos[7]));
        player.setFieldGoalPercentage(Double.parseDouble(infos[8]));
        player.setThreePointPercentage(Double.parseDouble(infos[9]));
        return player;
    }
}
