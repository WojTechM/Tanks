package com.codecool.Game.maps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameMapGenerator {

    private GameMapRandomFiller randomFiller;

    @Autowired
    public GameMapGenerator(GameMapRandomFiller randomFiller) {
        this.randomFiller = randomFiller;
    }

    GameMap createMap(int width, int height, float fillPercentage, int smoothRounds) {
        GameMap map = new GameMap(width, height);
        randomFiller.FillMap(map, fillPercentage, smoothRounds);
        return map;
    }
}
