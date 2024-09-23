package com.rafaelrocha.stats_api.domain.model;

import lombok.Data;

@Data
public class Player {
    private String name;
    private String team;
    private String position;
    private int age;
    private double pointsPerGame;
    private double assistsPerGame;
    private double reboundsPerGame;
    private float fieldGoalPercentage;
    private float threePointPercentage;
}
