package com.codecool.Game.maps;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class GameMapRandomFiller {

    private final char EMPTY = '_';
    private final char WALL = 'w';

    public void FillMap(GameMap map, float fillPercentage) {
        RandomFillMap(map, fillPercentage);
    }

    private void RandomFillMap(GameMap map, float fillPercentage) {
        if (fillPercentage < 0 || fillPercentage > 1) {
            throw new IllegalArgumentException("Percentage must be in range (0, 1)");
        }

        for (int y = 0; y < map.height; y++) {
            for (int x = 0; x < map.width; x++) {
                char field = ThreadLocalRandom.current().nextFloat() < fillPercentage ? WALL : EMPTY;
                map.setField(x, y, field);
            }
        }
    }
}
