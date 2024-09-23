package com.rafaelrocha.stats_api.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PlayerDTO {
    private String name;
    private String team;
    private String position;
    private int age;
    @JsonProperty("PPG")
    private double pointsPerGame;
    @JsonProperty("APG")
    private double assistsPerGame;
    @JsonProperty("RPG")
    private double reboundsPerGame;
    @JsonProperty("FG%")
    private double fieldGoalPercentage;
    @JsonProperty("3P%")
    private double threePointPercentage;
}
