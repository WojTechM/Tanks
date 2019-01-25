package com.codecool.Game.maps;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class GameMapRandomFiller {

    private final char EMPTY = '_';
    private final char WALL = 'w';

    public void FillMap(GameMap map, float fillPercentage, int smoothMapRounds) {
        RandomFillMap(map, fillPercentage);
        for (int i = 0; i < smoothMapRounds; i++) {
            SmoothMap(map);
        }
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

    private void SmoothMap(GameMap map) {
        for (int x = 0; x < map.width; x++) {
            for (int y = 0; y < map.height; y++) {
                int neighbourWallTiles = map.getSurroundingElementCount(x, y, WALL);

                if (neighbourWallTiles > 4)
                    map.setField(x, y, WALL);
                else if (neighbourWallTiles < 4)
                    map.setField(x, y, EMPTY);
            }
        }
    }
}
