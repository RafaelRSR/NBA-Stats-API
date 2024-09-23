package com.rafaelrocha.stats_api.domain.exceptions;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException() {
        super("Player not found!");
    }
}
